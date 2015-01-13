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

import com.energyeye.salesperson.dbComponents.IDBHelper;
import com.energyeye.salesperson.dbComponents.OppertunityHelper;
import com.energyeye.salesperson.properties.Constants;
import com.energyeye.salesperson.properties.OppertunitiesDataSource;

public class OppertunityService {

	private static InputStream is = null;
	private Context context;
	private static OppertunitiesDataSource dataSource;
	private SharedPreferences pref;
	private String userKey;
	private IDBHelper helper = new OppertunityHelper();
	private List<OppertunitiesDataSource> oppertunitiesList = new ArrayList<OppertunitiesDataSource>();

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public OppertunityService(Context context) {
		this.context = context;
	}

	public Context getContext() {
		return context;
	}

	private void getKeySharedPref() {
		pref = context.getSharedPreferences("localdiskchildlocator", 0);
		Log.e("getKeySharedPref",
				"OppertunityService: " + "\nuserKey: "
						+ pref.getString("userKey", "") + "\nemailID: "
						+ pref.getString("emailID", "") + "\nPassword: "
						+ pref.getString("password", ""));
		setUserKey(pref.getString("userKey", ""));

	}

	public void setContext(Context context) {
		this.context = context;
	}

	public void getOppertunitiesService() {

		Log.e("getOppertunitiesService", "getOppertunitiesService");
		dataSource = OppertunitiesDataSource.getOppertunitiesDataSource();
		for (int i = 0; i < 30; i++) {
			oppertunitiesList.add(setOpppertunities(String.valueOf(i)));
		}

		deleteOppertunities();

		for (OppertunitiesDataSource oppertunities : oppertunitiesList) {
			OppertunitiesDataSource.setOppertunitiesDataSource(oppertunities);
			insertOppertunities();
		}

		getMyOppertunities();

	}

	private void insertOppertunities() {
		Log.e("insertOppertunities", "fsdsdfsf");
		helper.insert();
	}

	private void getMyOppertunities() {
		Log.e("getMyOppertunities", "sdfdfsdfsd");
		helper.select(null, null, null, null);
	}

	private void deleteOppertunities() {
		Log.e("deleteOppertunities", "sdfdfsdfsd");
		helper.delete(null, null);
	}

	private OppertunitiesDataSource setOpppertunities(String i) {
		// TODO Auto-generated method stub
		Log.e("OppertunitiesDataSource", i);
		dataSource.setProjectTitle("Project title" + i);
		dataSource.setProjectDescription("Project Description" + i);
		dataSource.setPropertyType("Propertytype" + i);
		dataSource.setModuleType("Module type" + i);
		dataSource.setCompCode("Compcode" + i);
		dataSource.setContactName("Contact Name" + i);
		dataSource.setDesignation("Designation" + i);
		dataSource.setAddress1("Address 1" + i);
		dataSource.setAddress2("Address 2+i");
		dataSource.setCity("City" + i);
		dataSource.setCounty("County" + i);
		dataSource.setCountry("Country" + i);
		dataSource.setPostCode("Post Code" + i);
		dataSource.setEmailId("Email id" + i);
		dataSource.setDayPhone("Day phone" + i);
		dataSource.setEveningPhone("Evening phone" + i);
		dataSource.setOther("Other" + i);
		dataSource.setOther("Status" + i);

		return dataSource;

	}

	private class Oppertunitieswebservice extends
			AsyncTask<String, Integer, String> {

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

		}

		@Override
		protected String doInBackground(String... params) {

			String json = "";
			List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
			params1.add(new BasicNameValuePair("userkey", userKey));

			try {

				HttpPost httpPost = null;
				DefaultHttpClient httpClient = new DefaultHttpClient();
				httpPost = new HttpPost(Constants.OPPERTUNITIES_URL);
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
				publishProgress(60);
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
	}

}
