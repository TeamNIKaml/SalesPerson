package com.energyeye.salesperson.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.util.Log;

import com.energyeye.salesperson.properties.Constants;
import com.energyeye.salesperson.properties.SalesPerson;

public class LoginService {

    private static InputStream is = null;
    private Context context;
    private static SalesPerson user;
    private SharedPreferences pref;
    private Editor editor;

    public LoginService(Context context) {
	this.context = context;
    }

    public Context getContext() {
	return context;
    }

    public void setContext(Context context) {
	this.context = context;
    }

    public void doLogin() {
	Log.e("login Service", "ndfsdf");
	user = SalesPerson.getUser();

	new Loginwebservice().execute("login");

    }

    public void postLogin() {

	writeSharedPreference();
	final Intent intent = new Intent(context,
		com.energyeye.salesperson.activity.PostLoginActivity.class);
	// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	context.startActivity(intent);

    }

    private void writeSharedPreference() {
	// TODO Auto-generated method stub

	pref = getContext().getSharedPreferences("localdiskchildlocator", 0);
	editor = pref.edit();
	Log.e("writeToSharedPreferences", "localdiskchildlocator");
	editor.putString("userKey", user.getUserKey());
	editor.putString("emailID", user.getEmailId());
	editor.putString("password", user.getPassword());
	editor.putInt("loginstatus", 100);
	editor.commit();

    }

    private class Loginwebservice extends AsyncTask<String, Integer, String> {

	@Override
	protected void onPostExecute(String result) {
	    // TODO Auto-generated method stub
	    super.onPostExecute(result);
	    int loginStatus = 0;
	    JSONObject json_data;
	    try {
		json_data = new JSONObject(result);
		for (int i = 0; i < json_data.length(); i++) {

		    if (Integer.parseInt(json_data.getString("status")) == 200) {
			loginStatus = 200;
			user.setUserKey(json_data.getString("userKey"));
			postLogin();

		    } else
			loginStatus = Integer.parseInt(json_data
				.getString("status"));
		}

	    } catch (final JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    if (loginStatus == 200) {
		Log.e("Login Sucessful", user.getUserKey());
		postLogin();
	    } else {
		Log.e("Login error", Constants.EMAIL_ID_PASSWORD_INVALID);
	    }
	}

	@Override
	protected String doInBackground(String... params) {

	    String json = "";
	    final List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
	    params1.add(new BasicNameValuePair("emailId", user.getEmailId()));
	    params1.add(new BasicNameValuePair("password", user.getPassword()));
	    params1.add(new BasicNameValuePair("select", "Login"));

	    try {

		HttpPost httpPost = null;
		final DefaultHttpClient httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(Constants.LOGIN_URL);
		httpPost.setEntity(new UrlEncodedFormEntity(params1));
		final HttpResponse httpResponse = httpClient.execute(httpPost);
		final HttpEntity httpEntity = httpResponse.getEntity();

		is = httpEntity.getContent();

	    } catch (final UnsupportedEncodingException e) {
		e.printStackTrace();
	    } catch (final ClientProtocolException e) {
		e.printStackTrace();
	    } catch (final IOException e) {
		e.printStackTrace();
	    }

	    try {
		final BufferedReader reader = new BufferedReader(
			new InputStreamReader(is, "iso-8859-1"), 8);
		final StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
		    sb.append(line);
		}
		is.close();
		json = sb.toString();
		Log.e("JSON", json);
	    } catch (final Exception e) {
		Log.e("Buffer Error", "Error converting result " + e.toString());
	    }

	    return json;
	}
    }

}