package com.energyeye.salesperson.properties;

public class Constants {

    public static final String EMAIL_ID_PASSWORD_INVALID = "Invalid Username or Password";
    public static final String WEB_SERVICE_ERROR = "500 WEBSERVICE ERROR";
    public static final String LOGIN_URL = "http://10.0.2.2:8080/EnergyEye/Service/LoginService.php";
    public static final String TASK_URL = "http://10.0.2.2:8080/EnergyEye/Service/TaskService.php";
    public static final String MYOPPERTUNITIES_URL = "http://10.0.2.2:8080/EnergyEye/Service/MyOppertunitiesService.php";
    public static final String UPLOAD_URL = "http://10.0.2.2:8080/EnergyEye/Service/FileUploadService.php";
    public static final String OPPERTUNITIES_URL = "http://10.0.2.2:8080/EnergyEye/Service/OppertunitiesService.php";
    public static final String DB_NAME = "energyEye.db";
    public static final String OPPERTUNITIES_TABLE_NAME = "oppertunities";
    public static final String OPPERTUNITIES_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.OPPERTUNITIES_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL,"
	    + "projectTitle TEXT,"
	    + "projectDescription TEXT,"
	    + "propertyType TEXT,"
	    + "moduleType TEXT,"
	    + "compCode TEXT,"
	    + "contactName TEXT,"
	    + "designation TEXT,"
	    + "address1 TEXT,"
	    + "address2 TEXT,"
	    + "city TEXT,"
	    + "county TEXT,"
	    + "country TEXT,"
	    + "postCode TEXT,"
	    + "emailId TEXT,"
	    + "dayPhone TEXT,"
	    + "eveningPhone TEXT,"
	    + "other TEXT,"
	    + "status TEXT, " + "latitude TEXT ," + "longitude TEXT)";

    public static final String CUSTOMER_INFOEMATION_TABLE_NAME = "customerInformation";
    public static final String CUSTOMER_INFORMATION_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.CUSTOMER_INFOEMATION_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL,"
	    + "mpan TEXT,"
	    + "supplier TEXT,"
	    + "dnoCompany TEXT,"
	    + "electricityRate TEXT,"
	    + "roiMethod TEXT,"
	    + "monitorInstallation TEXT,"
	    + "showCustomerContribution TEXT,"
	    + "roofType TEXT,"
	    + "meterReadinfForFit TEXT,"
	    + "yieldMethod TEXT,"
	    + "ProjectImplementationtype TEXT,"
	    + "other TEXT)";

    private Constants() {
    }

}
