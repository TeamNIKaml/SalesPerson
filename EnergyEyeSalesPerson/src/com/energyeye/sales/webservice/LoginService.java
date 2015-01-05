package com.energyeye.sales.webservice;

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
import com.energyeye.sales.properties.Constants;
import com.energyeye.sales.properties.SalesPerson;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;






public class LoginService {

	private static InputStream is = null;
	private Context context;
	private static SalesPerson user;
	



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
		user.getEmailId();
		user.getPassword();
		new Loginwebservice().execute("login");		
		postLogin();
		
	}
	
	

	public void postLogin() {

		
		context.startActivity(new Intent(context,com.energyeye.salesperson.PostLoginActivity.class))		;
		
		
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
						
						
					}
					else
						loginStatus = Integer.parseInt(json_data.getString("status"));
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if (loginStatus == 200) {
				    Log.e("Login Sucessful", user.getUserKey());
				    postLogin();
				   }else{
					   	   Log.e("Login error",Constants.EMAIL_ID_PASSWORD_INVALID);		 
				   }
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String json = "";
			List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
			// params.add(new BasicNameValuePair("tag", login_tag));
			params1.add(new BasicNameValuePair("emailId", user.getEmailId()));
			params1.add(new BasicNameValuePair("password", user.getPassword()));

			try {
				// defaultHttpClient
				HttpPost httpPost = null;
				DefaultHttpClient httpClient = new DefaultHttpClient();				
				httpPost = new HttpPost(Constants.LOGIN_URL);				
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
	}

} 