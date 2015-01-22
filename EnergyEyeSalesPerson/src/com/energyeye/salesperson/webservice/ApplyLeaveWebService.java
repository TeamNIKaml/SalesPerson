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
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.energyeye.salesperson.properties.Constants;

public class ApplyLeaveWebService {

    private SharedPreferences pref;
    private static InputStream is = null;
    private Context context;

    public Context getContext() {
	return context;
    }

    public void setContext(Context context) {
	this.context = context;
    }

    public ApplyLeaveWebService(Context context) {
	super();
	this.context = context;
    }

    public void getHolidayList() {
	Log.e("Task Service", "ndfsdf");
	new ApplyLeaveService().execute("attendence");

    }

    private class ApplyLeaveService extends AsyncTask<String, Integer, String> {

	@Override
	protected void onPostExecute(String result) {
	    super.onPostExecute(result);
	    int status = 0;
	    JSONObject json_data;
	    try {
		json_data = new JSONObject(result);
		for (int i = 0; i < json_data.length(); i++) {

		    if (Integer.parseInt(json_data.getString("status")) == 200) {
			status = 200;

		    } else
			status = Integer
				.parseInt(json_data.getString("status"));
		}

	    } catch (final JSONException e) {
		e.printStackTrace();
	    }
	    if (status == 200) {
		Log.e("Task Sucess", "Sucess");
	    } else {
		Log.e("Task error", Constants.WEB_SERVICE_ERROR);
	    }
	}

	@Override
	protected String doInBackground(String... params) {

	    String json = "";
	    final List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
	    pref = context.getSharedPreferences("localdiskchildlocator", 0);
	    Log.e("Task Wenservice",
		    "LoginStatus: "
			    + String.valueOf(pref.getInt("loginstatus", 0))
			    + "\nuserKey: " + pref.getString("userKey", "")
			    + "\nemailID: " + pref.getString("emailID", "")
			    + "\nPassword: " + pref.getString("password", ""));

	    params1.add(new BasicNameValuePair("userkey", pref.getString(
		    "userKey", "")));
	    params1.add(new BasicNameValuePair("select", "MyAttendence"));
	    params1.add(new BasicNameValuePair("fromDate", "FromDate"));
	    params1.add(new BasicNameValuePair("toDate", "ToDate"));

	    try {

		HttpPost httpPost = null;
		final DefaultHttpClient httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(Constants.TASK_URL);
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
