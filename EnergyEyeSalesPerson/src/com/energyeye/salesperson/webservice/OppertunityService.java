package com.energyeye.salesperson.webservice;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.energyeye.salesperson.dbComponents.IDBHelper;
import com.energyeye.salesperson.dbComponents.OppertunityHelper;
import com.energyeye.salesperson.properties.OppertunitiesDataSource;

public class OppertunityService {

	private Context context;
	private static OppertunitiesDataSource dataSource;
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

}
