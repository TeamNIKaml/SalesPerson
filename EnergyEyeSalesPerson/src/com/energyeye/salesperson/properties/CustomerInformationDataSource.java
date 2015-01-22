package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CustomerInformationDataSource {

    private String mpan;
    private String supplier;
    private String dnoCompany;
    private String electricityRate;
    private String roiMethod;
    private String monitorInstallation;
    private String showCustomerContribution;
    private String roofType;
    private String meterReadinfForFit;
    private String yieldMethod;
    private String ProjectImplementationtype;
    private String other;

    private Context context;
    private String whereClause;
    private String sortOrder;
    private String[] whereArgs;
    private String[] projection;

    private static CustomerInformationDataSource dataSource;

    private List<CustomerInformationDataSource> customerInformationList = new ArrayList<CustomerInformationDataSource>();

    public static CustomerInformationDataSource getCustomerInformationDataSource() {
	if (dataSource == null)
	    dataSource = new CustomerInformationDataSource();
	return dataSource;
    }

    private CustomerInformationDataSource() {

    }

   

    public Context getContext() {
	return context;
    }

    public void setContext(Context context) {
	this.context = context;
    }

    public String getDnoCompany() {
	return dnoCompany;
    }

    public void setDnoCompany(String dnoCompany) {
	this.dnoCompany = dnoCompany;
    }

    public String getElectricityRate() {
	return electricityRate;
    }

    public void setElectricityRate(String electricityRate) {
	this.electricityRate = electricityRate;
    }

    public String getMeterReadinfForFit() {
	return meterReadinfForFit;
    }

    public void setMeterReadinfForFit(String meterReadinfForFit) {
	this.meterReadinfForFit = meterReadinfForFit;
    }

    public String getMonitorInstallation() {
	return monitorInstallation;
    }

    public void setMonitorInstallation(String monitorInstallation) {
	this.monitorInstallation = monitorInstallation;
    }

    public String getMpan() {
	return mpan;
    }

    public void setMpan(String mpan) {
	this.mpan = mpan;
    }

    public String getOther() {
	return other;
    }

    public void setOther(String other) {
	this.other = other;
    }

    public String getProjectImplementationtype() {
	return ProjectImplementationtype;
    }

    public void setProjectImplementationtype(String projectImplementationtype) {
	ProjectImplementationtype = projectImplementationtype;
    }

    public String[] getProjection() {
	return projection;
    }

    public void setProjection(String[] projection) {
	this.projection = projection;
    }

    public String getRoiMethod() {
	return roiMethod;
    }

    public void setRoiMethod(String roiMethod) {
	this.roiMethod = roiMethod;
    }

    public String getRoofType() {
	return roofType;
    }

    public void setRoofType(String roofType) {
	this.roofType = roofType;
    }

    public String getShowCustomerContribution() {
	return showCustomerContribution;
    }

    public void setShowCustomerContribution(String showCustomerContribution) {
	this.showCustomerContribution = showCustomerContribution;
    }

    public String getSortOrder() {
	return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
	this.sortOrder = sortOrder;
    }

    public String getSupplier() {
	return supplier;
    }

    public void setSupplier(String supplier) {
	this.supplier = supplier;
    }

    public String[] getWhereArgs() {
	return whereArgs;
    }

    public void setWhereArgs(String[] whereArgs) {
	this.whereArgs = whereArgs;
    }

    public String getWhereClause() {
	return whereClause;
    }

    public void setWhereClause(String whereClause) {
	this.whereClause = whereClause;
    }

    public String getYieldMethod() {
	return yieldMethod;
    }

    public void setYieldMethod(String yieldMethod) {
	this.yieldMethod = yieldMethod;
    }

    public List<CustomerInformationDataSource> getCustomerInformationList() {
	return customerInformationList;
    }

    public void setCustomerInformationList(
	    List<CustomerInformationDataSource> customerInformationList) {
	this.customerInformationList = customerInformationList;
    }
    
    
    
    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "mpan"+ getMpan()+
		"supplier"+ getSupplier()+
		"dnoCompany"+ getDnoCompany()+
		"electricityRate"+ getElectricityRate()+
		"roiMethod"+ getRoiMethod()+
		"monitorInstallation"+ getMonitorInstallation()+
		"showCustomerContribution"+ getShowCustomerContribution()+
		"roofType"+ getRoofType()+
		"meterReadinfForFit"+ getMeterReadinfForFit()+
		"yieldMethod"+ getYieldMethod()+
		"ProjectImplementationtype"+ getProjectImplementationtype()+
		"other"+ getOther();
    }
    
    
    

    public CustomerInformationDataSource cursorToCustomerInformationList(
	    Cursor cursor) {
	final CustomerInformationDataSource customerInformationDataSource = new CustomerInformationDataSource();
	// TODO Auto-generated method stub

	customerInformationDataSource.setMpan(cursor.getString(1));
	customerInformationDataSource.setSupplier(cursor.getString(2));
	customerInformationDataSource.setDnoCompany(cursor.getString(3));
	customerInformationDataSource.setElectricityRate(cursor.getString(4));
	customerInformationDataSource.setRoiMethod(cursor.getString(5));
	customerInformationDataSource.setMonitorInstallation(cursor
		.getString(6));
	customerInformationDataSource.setShowCustomerContribution(cursor
		.getString(7));
	customerInformationDataSource.setRoofType(cursor.getString(8));
	customerInformationDataSource
		.setMeterReadinfForFit(cursor.getString(9));
	customerInformationDataSource.setYieldMethod(cursor.getString(10));
	customerInformationDataSource.setProjectImplementationtype(cursor
		.getString(11));
	customerInformationDataSource.setOther(cursor.getString(12));

	return customerInformationDataSource;
    }

    public ContentValues customerInformationListToContentValue() {
	// TODO Auto-generated method stub

	final ContentValues values = new ContentValues();

	values.put("mpan", getMpan());
	values.put("supplier", getSupplier());
	values.put("dnoCompany", getDnoCompany());
	values.put("electricityRate", getElectricityRate());
	values.put("roiMethod", getRoiMethod());
	values.put("monitorInstallation", getMonitorInstallation());
	values.put("showCustomerContribution", getShowCustomerContribution());
	values.put("roofType", getRoofType());
	values.put("meterReadinfForFit", getMeterReadinfForFit());
	values.put("yieldMethod", getYieldMethod());
	values.put("ProjectImplementationtype", getProjectImplementationtype());
	values.put("other", getOther());

	return values;
    }

}
