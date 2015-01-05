package com.energyeye.salesperson.properties;

import android.content.ContentValues;
import android.database.Cursor;

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
		setProjectTitle(cursor.getString(3));
		
		return this;
		
	}
	

}
