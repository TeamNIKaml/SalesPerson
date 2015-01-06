package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import com.energyeye.salesperson.SQLLite.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

public class OppertunitiesDataSource {

	

	private String projectTitle;
	private String projectDescription;
	private String propertyType;
	private String moduleType;
	private String compCode;
	private String contactName;
	private String designation;
	private String address1;
	private String address2;
	private String city;
	private String county;
	private String country;
	private String postCode;
	private String emailId;
	private String dayPhone;
	private String eveningPhone;
	private String other;
	private static OppertunitiesDataSource oppertunitiesDataSource;
	
	private Context context;
	private String whereClause;
	private String[] whereArgs;
	private List<OppertunitiesDataSource> oppertunitieslist = new ArrayList<OppertunitiesDataSource>();	
	private String[] projection;
	String sortOrder;
	
	
	
	public String getWhereClause() {
		return whereClause;
	}


	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}


	public String[] getWhereArgs() {
		return whereArgs;
	}


	public void setWhereArgs(String[] whereArgs) {
		this.whereArgs = whereArgs;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return  "\n\n\n projectTitle : " +getProjectTitle() +"\n"+
				"projectDescription : " + getProjectDescription() + "\n" +
				"propertyType : " + getPropertyType() +"\n" +
				"moduleType : " +getModuleType() + " \n" +
				"compCode : "+getCompCode() + "\n" +
				"contactName : " + getContactName() + "\n" +
				"designation : " + getDesignation() + "\n" +
				"address1 : " + getAddress1() + "\n" +
				"address2 : " +getAddress2() + "\n" + 
				"city : " +getCity() + "\n" +
				"county" + getCounty() + "\n" +
				"postCode : " +getPostCode() +"\n" +
				"emailId : " + getEmailId() + "\n" +
				"dayPhone : "  +getDayPhone() +"\n" +
				"eveningPhone : " +getEveningPhone() + "\n" +
				"other : " + getOther() ;
		
		
	}
	
	
	public Context getContext() {
		return this.context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public static OppertunitiesDataSource getOppertunitiesDataSource() {
		
		if(oppertunitiesDataSource == null)
			oppertunitiesDataSource = new OppertunitiesDataSource();		
		return oppertunitiesDataSource;
	}
	
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getModuleType() {
		return moduleType;
	}
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDayPhone() {
		return dayPhone;
	}
	public void setDayPhone(String dayPhone) {
		this.dayPhone = dayPhone;
	}
	public String getEveningPhone() {
		return eveningPhone;
	}
	public void setEveningPhone(String eveningPhone) {
		this.eveningPhone = eveningPhone;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	private OppertunitiesDataSource()
	{
		
	}
	
	public ContentValues oppertuniiesToContentValues()
	{
		 ContentValues values = new ContentValues();
		 
		    values.put("projectTitle",getProjectTitle());
		    values.put("projectDescription",getProjectDescription());
		    values.put("propertyType",getPropertyType());
		    values.put("moduleType",getModuleType());
		    values.put("compCode",getCompCode());
		    values.put("contactName",getContactName());
		    values.put("designation",getDesignation());
		    values.put("address1",getAddress1());
		    values.put("address2",getAddress2());
		    values.put("city",getCity());
		    values.put("county",getCounty());
		    values.put(" country",getCountry());
		    values.put(" postCode",getPostCode());
		    values.put("emailId",getEmailId());
		    values.put("dayPhone",getDayPhone());
		    values.put(" eveningPhone",getEveningPhone());
		    values.put("other",getOther());		    
		    
		    return values;
	}
	
	public OppertunitiesDataSource cursorToOppertunitiesDataSource(Cursor cursor)
	{
		setProjectTitle(cursor.getString(1));
		setProjectDescription(cursor.getString(2));
		setPropertyType(cursor.getString(3));
		setModuleType(cursor.getString(4));
		setCompCode(cursor.getString(5));
		setContactName(cursor.getString(6));
		setDesignation(cursor.getString(7));
		setAddress1(cursor.getString(8));
		setAddress2(cursor.getString(9));
		setCity(cursor.getString(10));
		setCounty(cursor.getString(11));
		setCountry(cursor.getString(12));
		setPostCode(cursor.getString(13));
		setEmailId(cursor.getString(14));
		setDayPhone(cursor.getString(15));
		setEveningPhone(cursor.getString(16));
		setOther(cursor.getString(17));
		
		return this;
		
	}
	
	
	
	 public List<OppertunitiesDataSource> getOppertunitieslist() {
		return oppertunitieslist;
	}


	public void setOppertunitieslist(List<OppertunitiesDataSource> oppertunitieslist) {
		this.oppertunitieslist = oppertunitieslist;
	}


	public String[] getProjection() {
		return projection;
	}


	public void setProjection(String[] projection) {
		this.projection = projection;
	}


	public String getSortOrder() {
		return sortOrder;
	}


	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}




	
	

}
