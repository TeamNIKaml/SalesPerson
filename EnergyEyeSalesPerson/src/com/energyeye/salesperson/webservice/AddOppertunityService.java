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

    private SharedPreferences pref;
    private static InputStream is = null;
    private Context context;

    private final OppertunitiesDataSource dataSource = OppertunitiesDataSource
	    .getOppertunitiesDataSource();

    public AddOppertunityService(Context context) {
	super();
	this.context = context;
    }

    public void addOpperTunities() {
	Log.e("Add Opppertunity Service", "add Oppertunities");
	setData();
	new AddOppertunitiwebservice().execute("addOppertunity");

    }

    private void setData() {

	dataSource.setProjectTitle("title");
	dataSource.setProjectDescription("Description");
	dataSource.setPropertyType("propertyType");
	dataSource.setModuleType("ModuleType");
	dataSource.setCompCode("compcode");
	dataSource.setContactName("Contactname");
	dataSource.setDesignation("Designation");
	dataSource.setAddress1("Adddress1");
	dataSource.setAddress2("Address2");
	dataSource.setCity("City");
	dataSource.setCounty("County");
	dataSource.setCountry("Contry");
	dataSource.setPostCode("Postalcode");
	dataSource.setEmailId("Email");
	dataSource.setDayPhone("dayphone");
	dataSource.setEveningPhone("eveningphone");
	dataSource.setOther("other");
	dataSource.setStatus("status");
	dataSource.setLatitude("latitude");
	dataSource.setLongitute("longitude");

    }

    public Context getContext() {
	return context;
    }

    public void setContext(Context context) {
	this.context = context;
    }

    private class AddOppertunitiwebservice extends
	    AsyncTask<String, Integer, String> {

	@Override
	protected String doInBackground(String... params) {

	    String json = "";
	    final List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
	    pref = context.getSharedPreferences("localdiskchildlocator", 0);
	    Log.e("AddOpertunities",
		    "LoginStatus: "
			    + String.valueOf(pref.getInt("loginstatus", 0))
			    + "\nuserKey: " + pref.getString("userKey", "")
			    + "\nemailID: " + pref.getString("emailID", "")
			    + "\nPassword: " + pref.getString("password", ""));

	    params1.add(new BasicNameValuePair("userkey", pref.getString(
		    "userKey", "")));
	    params1.add(new BasicNameValuePair("select", "addOppertunities"));

	    params1.add(new BasicNameValuePair("projectTitle", dataSource
		    .getProjectTitle()));
	    params1.add(new BasicNameValuePair("projectDescription", dataSource
		    .getProjectDescription()));
	    params1.add(new BasicNameValuePair("propertyType", dataSource
		    .getPropertyType()));
	    params1.add(new BasicNameValuePair("moduleType", dataSource
		    .getModuleType()));
	    params1.add(new BasicNameValuePair("compCode", dataSource
		    .getCompCode()));
	    params1.add(new BasicNameValuePair("contactName", dataSource
		    .getContactName()));
	    params1.add(new BasicNameValuePair("designation", dataSource
		    .getDesignation()));
	    params1.add(new BasicNameValuePair("address1", dataSource
		    .getAddress1()));
	    params1.add(new BasicNameValuePair("address2", dataSource
		    .getAddress2()));
	    params1.add(new BasicNameValuePair("city", dataSource.getCity()));
	    params1.add(new BasicNameValuePair("county", dataSource.getCounty()));
	    params1.add(new BasicNameValuePair("country", dataSource
		    .getCountry()));
	    params1.add(new BasicNameValuePair("postCode", dataSource
		    .getPostCode()));
	    params1.add(new BasicNameValuePair("emailId", dataSource
		    .getEmailId()));
	    params1.add(new BasicNameValuePair("dayPhone", dataSource
		    .getDayPhone()));
	    params1.add(new BasicNameValuePair("eveningPhone", dataSource
		    .getEveningPhone()));
	    params1.add(new BasicNameValuePair("other", dataSource.getOther()));
	    params1.add(new BasicNameValuePair("status", dataSource.getStatus()));
	    params1.add(new BasicNameValuePair("latitude", dataSource
		    .getLatitude()));
	    params1.add(new BasicNameValuePair("longitute", dataSource
		    .getLongitute()));

	    try {

		HttpPost httpPost = null;
		final DefaultHttpClient httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(Constants.ADD_OPPERTUNITY_URL);
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
		Log.e("AddOpertunities Sucess", "Sucess");
	    } else {
		Log.e("AddOpertunities error", Constants.WEB_SERVICE_ERROR);
	    }
	}
    }
}
