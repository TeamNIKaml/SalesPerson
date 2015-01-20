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
import com.energyeye.salesperson.properties.CustomerInformationDataSource;

public class CustomerInformationService {

    private SharedPreferences pref;
    private static InputStream is = null;
    private Context context;
    private final CustomerInformationDataSource dataSource = CustomerInformationDataSource
	    .getCustomerInformationDataSource();

    public CustomerInformationService(Context context) {
	super();
	this.context = context;
    }

    public Context getContext() {
	return context;
    }

    public void setContext(Context context) {
	this.context = context;
    }

    public void addCutomerInformation() {
	Log.e("CustomerInformationService service", "ndfsdf");
	setData();
	new CustomerInformationWebService()
		.execute("CustomerInformationWebService");

    }

    private void setData() {
	dataSource.setMpan("mpan");
	dataSource.setSupplier("supplier");
	dataSource.setDnoCompany("dnoCompany");
	dataSource.setElectricityRate("electricityRate");
	dataSource.setRoiMethod("roiMethod");
	dataSource.setMonitorInstallation("monitorInstallation");
	dataSource.setShowCustomerContribution("showCustomerContribution");
	dataSource.setRoofType("roofType");
	dataSource.setMeterReadinfForFit("meterReadinfForFit");
	dataSource.setYieldMethod("yieldMethod");
	dataSource.setProjectImplementationtype("ProjectImplementationtype");
	dataSource.setOther("other");
    }

    private class CustomerInformationWebService extends
	    AsyncTask<String, Integer, String> {

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
		Log.e("MyOppertunities Sucess", "Sucess");
	    } else {
		Log.e("MyOppertunities error", Constants.WEB_SERVICE_ERROR);
	    }
	}

	@Override
	protected String doInBackground(String... params) {

	    String json = "";
	    final List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
	    pref = context.getSharedPreferences("localdiskchildlocator", 0);
	    Log.e("MyOppertunities",
		    "LoginStatus: "
			    + String.valueOf(pref.getInt("loginstatus", 0))
			    + "\nuserKey: " + pref.getString("userKey", "")
			    + "\nemailID: " + pref.getString("emailID", "")
			    + "\nPassword: " + pref.getString("password", ""));

	    params1.add(new BasicNameValuePair("userkey", pref.getString(
		    "userKey", "")));
	    params1.add(new BasicNameValuePair("select",
		    "CustomerInformationWebService"));

	    params1.add(new BasicNameValuePair("mpan", dataSource.getMpan()));
	    params1.add(new BasicNameValuePair("supplier", dataSource
		    .getSupplier()));
	    params1.add(new BasicNameValuePair("dnoCompany", dataSource
		    .getDnoCompany()));
	    params1.add(new BasicNameValuePair("electricityRate", dataSource
		    .getElectricityRate()));
	    params1.add(new BasicNameValuePair("roiMethod", dataSource
		    .getRoiMethod()));
	    params1.add(new BasicNameValuePair("monitorInstallation",
		    dataSource.getMonitorInstallation()));
	    params1.add(new BasicNameValuePair("showCustomerContribution",
		    dataSource.getShowCustomerContribution()));
	    params1.add(new BasicNameValuePair("roofType", dataSource
		    .getRoofType()));
	    params1.add(new BasicNameValuePair("meterReadinfForFit", dataSource
		    .getMeterReadinfForFit()));
	    params1.add(new BasicNameValuePair("yieldMethod", dataSource
		    .getYieldMethod()));
	    params1.add(new BasicNameValuePair("ProjectImplementationtype",
		    dataSource.getProjectImplementationtype()));
	    params1.add(new BasicNameValuePair("other", dataSource.getOther()));

	    try {

		HttpPost httpPost = null;
		final DefaultHttpClient httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(Constants.ADD_CUSTOMER_INFORMATION_URL);
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
