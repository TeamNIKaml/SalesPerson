package com.energyeye.salesperson.properties;

import android.util.Log;

public class SalesPerson {
	
	private String emailId, password,userKey;
	private static SalesPerson user = null;
	
	
	
	
	private SalesPerson()
	{
		
	}
	
	public static SalesPerson getUser()
	{
		if(user == null)
			{
				user = new SalesPerson();
				Log.e("user nulll", "#####FDsgdf###");
			}
		return user;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

}
