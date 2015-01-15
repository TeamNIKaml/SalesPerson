package com.energyeye.salesperson.properties;

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
	
	private static CustomerInformationDataSource dataSource;
	
	private CustomerInformationDataSource()
	{
		
	}
	
	public CustomerInformationDataSource getCustomerInformationDataSource()
	{
		if(dataSource == null)
			dataSource = new CustomerInformationDataSource();
		return dataSource;
	}
	
	
	public String getMpan() {
		return mpan;
	}
	public void setMpan(String mpan) {
		this.mpan = mpan;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
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
	public String getRoiMethod() {
		return roiMethod;
	}
	public void setRoiMethod(String roiMethod) {
		this.roiMethod = roiMethod;
	}
	public String getMonitorInstallation() {
		return monitorInstallation;
	}
	public void setMonitorInstallation(String monitorInstallation) {
		this.monitorInstallation = monitorInstallation;
	}
	public String getShowCustomerContribution() {
		return showCustomerContribution;
	}
	public void setShowCustomerContribution(String showCustomerContribution) {
		this.showCustomerContribution = showCustomerContribution;
	}
	public String getRoofType() {
		return roofType;
	}
	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}
	public String getMeterReadinfForFit() {
		return meterReadinfForFit;
	}
	public void setMeterReadinfForFit(String meterReadinfForFit) {
		this.meterReadinfForFit = meterReadinfForFit;
	}
	public String getYieldMethod() {
		return yieldMethod;
	}
	public void setYieldMethod(String yieldMethod) {
		this.yieldMethod = yieldMethod;
	}
	public String getProjectImplementationtype() {
		return ProjectImplementationtype;
	}
	public void setProjectImplementationtype(String projectImplementationtype) {
		ProjectImplementationtype = projectImplementationtype;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}

}
