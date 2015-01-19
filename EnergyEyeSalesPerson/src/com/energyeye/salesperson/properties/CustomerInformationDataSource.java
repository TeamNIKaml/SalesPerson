package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CustomerInformationDataSource {

    public static CustomerInformationDataSource getCustomerInformationDataSource() {
	if (dataSource == null)
	    dataSource = new CustomerInformationDataSource();
	return dataSource;
    }

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
    private Context context;
    private String whereClause;
    private String sortOrder;

    private String[] whereArgs;

    private String[] projection;

    private String other;

    private static CustomerInformationDataSource dataSource;

    private List<CustomerInformationDataSource> customerInformationList = new ArrayList<CustomerInformationDataSource>();

    private CustomerInformationDataSource() {

    }

    public CustomerInformationDataSource cursorToCustomerInformationList(
	    Cursor cursor) {
	// TODO Auto-generated method stub
	return null;
    }

    public ContentValues customerInformationListToContentValue() {
	// TODO Auto-generated method stub
	return null;
    }

    public Context getContext() {
	return context;
    }

    public List<CustomerInformationDataSource> getCustomerInformationList() {
	return customerInformationList;
    }

    public String getDnoCompany() {
	return dnoCompany;
    }

    public String getElectricityRate() {
	return electricityRate;
    }

    public String getMeterReadinfForFit() {
	return meterReadinfForFit;
    }

    public String getMonitorInstallation() {
	return monitorInstallation;
    }

    public String getMpan() {
	return mpan;
    }

    public String getOther() {
	return other;
    }

    public String getProjectImplementationtype() {
	return ProjectImplementationtype;
    }

    public String[] getProjection() {
	return projection;
    }

    public String getRoiMethod() {
	return roiMethod;
    }

    public String getRoofType() {
	return roofType;
    }

    public String getShowCustomerContribution() {
	return showCustomerContribution;
    }

    public String getSortOrder() {
	return sortOrder;
    }

    public String getSupplier() {
	return supplier;
    }

    public String[] getWhereArgs() {
	return whereArgs;
    }

    public String getWhereClause() {
	return whereClause;
    }

    public String getYieldMethod() {
	return yieldMethod;
    }

    public void setContext(Context context) {
	this.context = context;
    }

    public void setCustomerInformationList(
	    List<CustomerInformationDataSource> customerInformationList) {
	this.customerInformationList = customerInformationList;
    }

    public void setDnoCompany(String dnoCompany) {
	this.dnoCompany = dnoCompany;
    }

    public void setElectricityRate(String electricityRate) {
	this.electricityRate = electricityRate;
    }

    public void setMeterReadinfForFit(String meterReadinfForFit) {
	this.meterReadinfForFit = meterReadinfForFit;
    }

    public void setMonitorInstallation(String monitorInstallation) {
	this.monitorInstallation = monitorInstallation;
    }

    public void setMpan(String mpan) {
	this.mpan = mpan;
    }

    public void setOther(String other) {
	this.other = other;
    }

    public void setProjectImplementationtype(String projectImplementationtype) {
	ProjectImplementationtype = projectImplementationtype;
    }

    public void setProjection(String[] projection) {
	this.projection = projection;
    }

    public void setRoiMethod(String roiMethod) {
	this.roiMethod = roiMethod;
    }

    public void setRoofType(String roofType) {
	this.roofType = roofType;
    }

    public void setShowCustomerContribution(String showCustomerContribution) {
	this.showCustomerContribution = showCustomerContribution;
    }

    public void setSortOrder(String sortOrder) {
	this.sortOrder = sortOrder;
    }

    public void setSupplier(String supplier) {
	this.supplier = supplier;
    }

    public void setWhereArgs(String[] whereArgs) {
	this.whereArgs = whereArgs;
    }

    public void setWhereClause(String whereClause) {
	this.whereClause = whereClause;
    }

    public void setYieldMethod(String yieldMethod) {
	this.yieldMethod = yieldMethod;
    }

}
