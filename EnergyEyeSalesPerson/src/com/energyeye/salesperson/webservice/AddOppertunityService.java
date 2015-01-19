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
import com.energyeye.salesperson.properties.OppertunitiesDataSource;

public class AddOppertunityService {
    private class MyOppertunitiwebservice extends
	    AsyncTask<String, Integer, String> {

	@Override
	protected String doInBackground(String... params) {

	    String json = "";
	    List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
	    AddOppertunityService.this.pref = AddOppertunityService.this.context
		    .getSharedPreferences("localdiskchildlocator", 0);
	    Log.e("AddOpertunities",
		    "LoginStatus: "
			    + String.valueOf(AddOppertunityService.this.pref
				    .getInt("loginstatus", 0))
			    + "\nuserKey: "
			    + AddOppertunityService.this.pref.getString(
				    "userKey", "")
			    + "\nemailID: "
			    + AddOppertunityService.this.pref.getString(
				    "emailID", "")
			    + "\nPassword: "
			    + AddOppertunityService.this.pref.getString(
				    "password", ""));

	    params1.add(new BasicNameValuePair("userkey",
		    AddOppertunityService.this.pref.getString("userKey", "")));
	    params1.add(new BasicNameValuePair("select", "addOppertunities"));

	    params1.add(new BasicNameValuePair("projectTitle",
		    AddOppertunityService.this.dataSource.getProjectTitle()));
	    params1.add(new BasicNameValuePair("projectDescription",
		    AddOppertunityService.this.dataSource
			    .getProjectDescription()));
	    params1.add(new BasicNameValuePair("propertyType",
		    AddOppertunityService.this.dataSource.getPropertyType()));
	    params1.add(new BasicNameValuePair("moduleType",
		    AddOppertunityService.this.dataSource.getModuleType()));
	    params1.add(new BasicNameValuePair("compCode",
		    AddOppertunityService.this.dataSource.getCompCode()));
	    params1.add(new BasicNameValuePair("contactName",
		    AddOppertunityService.this.dataSource.getContactName()));
	    params1.add(new BasicNameValuePair("designation",
		    AddOppertunityService.this.dataSource.getDesignation()));
	    params1.add(new BasicNameValuePair("address1",
		    AddOppertunityService.this.dataSource.getAddress1()));
	    params1.add(new BasicNameValuePair("address2",
		    AddOppertunityService.this.dataSource.getAddress2()));
	    params1.add(new BasicNameValuePair("city",
		    AddOppertunityService.this.dataSource.getCity()));
	    params1.add(new BasicNameValuePair("county",
		    AddOppertunityService.this.dataSource.getCounty()));
	    params1.add(new BasicNameValuePair("country",
		    AddOppertunityService.this.dataSource.getCountry()));
	    params1.add(new BasicNameValuePair("postCode",
		    AddOppertunityService.this.dataSource.getPostCode()));
	    params1.add(new BasicNameValuePair("emailId",
		    AddOppertunityService.this.dataSource.getEmailId()));
	    params1.add(new BasicNameValuePair("dayPhone",
		    AddOppertunityService.this.dataSource.getDayPhone()));
	    params1.add(new BasicNameValuePair("eveningPhone",
		    AddOppertunityService.this.dataSource.getEveningPhone()));
	    params1.add(new BasicNameValuePair("other",
		    AddOppertunityService.this.dataSource.getOther()));
	    params1.add(new BasicNameValuePair("status",
		    AddOppertunityService.this.dataSource.getStatus()));
	    params1.add(new BasicNameValuePair("latitude",
		    AddOppertunityService.this.dataSource.getLatitude()));
	    params1.add(new BasicNameValuePair("longitute",
		    AddOppertunityService.this.dataSource.getLongitute()));

	    try {

		HttpPost httpPost = null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(Constants.MYOPPERTUNITIES_URL);
		httpPost.setEntity(new UrlEncodedFormEntity(params1));
		HttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity httpEntity = httpResponse.getEntity();
		is = httpEntity.getContent();

	    } catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	    } catch (ClientProtocolException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }

	    try {
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(is, "iso-8859-1"), 8);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
		    sb.append(line);
		}
		is.close();
		json = sb.toString();
		Log.e("JSON", json);
	    } catch (Exception e) {
		Log.e("Buffer Error", "Error converting result " + e.toString());
	    }
	    return json;
	}

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

	    } catch (JSONException e) {
		e.printStackTrace();
	    }
	    if (status == 200) {
		Log.e("AddOpertunities Sucess", "Sucess");
	    } else {
		Log.e("AddOpertunities error", Constants.WEB_SERVICE_ERROR);
	    }
	}
    }

    private SharedPreferences pref;
    private static InputStream is = null;
    private Context context;

    private OppertunitiesDataSource dataSource = OppertunitiesDataSource
	    .getOppertunitiesDataSource();

    public AddOppertunityService(Context context) {
	super();
	this.context = context;
    }

    public void addOpperTunities() {
	Log.e("Add Opppertunity Service", "add Oppertunities");
	new MyOppertunitiwebservice().execute("addOppertunity");

    }

    public Context getContext() {
	return this.context;
    }

    public void setContext(Context context) {
	this.context = context;
    }
}
