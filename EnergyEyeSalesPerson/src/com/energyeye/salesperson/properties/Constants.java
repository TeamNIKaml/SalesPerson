package com.energyeye.salesperson.properties;

public class Constants {

    public static final String EMAIL_ID_PASSWORD_INVALID = "Invalid Username or Password";
    public static final String WEB_SERVICE_ERROR = "500 WEBSERVICE ERROR";
    public static final String LOGIN_URL = "http://10.0.2.2:8080/EnergyEye/Service/LoginService.php";
    public static final String TASK_URL = "http://10.0.2.2:8080/EnergyEye/Service/TaskService.php";
    public static final String ADD_OPPERTUNITY_URL = "http://10.0.2.2:8080/EnergyEye/Service/AddOppertunity.php";
    public static final String ADD_CUSTOMER_INFORMATION_URL = "http://10.0.2.2:8080/EnergyEye/Service/AddCustomerInformation.php";
    public static final String MYOPPERTUNITIES_URL = "http://10.0.2.2:8080/EnergyEye/Service/MyOppertunitiesService.php";
    public static final String UPLOAD_URL = "http://10.0.2.2:8080/EnergyEye/Service/FileUploadService.php";
    public static final String OPPERTUNITIES_URL = "http://10.0.2.2:8080/EnergyEye/Service/OppertunitiesService.php";

    /* DATA BASE SECTION DB_NAME */

    public static final String DB_NAME = "energyEye.db";

    /* OPPERTUNITIES_TABLE_NAME */

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

    /* CUSTOMER_INFOEMATION_TABLE_NAME */

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
	    + "ProjectImplementationtype TEXT," + "other TEXT)";

    /* MODULE_TYPE_TABLE_NAME */

    public static final String MODULE_TYPE_TABLE_NAME = "moduleType";
    public static final String MODULE_TYPE_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.MODULE_TYPE_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";

    /* PROPERTY_TYPE_TABLE_NAME */

    public static final String PROPERTY_TYPE_TABLE_NAME = "property";
    public static final String PROPERTY_TYPE_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.PROPERTY_TYPE_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";

    /* COUNTRY_TABLE_NAME */

    public static final String COUNTRY_TABLE_NAME = "country";
    public static final String COUNTRY_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.COUNTRY_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";

    /* ELECTRICAL_COMPANY_TABLE_NAME */

    public static final String ELECTRICAL_COMPANY_TABLE_NAME = "electricalCompany";
    public static final String ELECTRICAL_COMPANY_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.ELECTRICAL_COMPANY_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";

    /* DNO_COMPANY_TABLE_NAME */

    public static final String DNO_COMPANY_TABLE_NAME = "dnoCompany";
    public static final String DNO_COMPANY_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.DNO_COMPANY_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";

    /* ROOF_TYPE_TABLE_NAME */

    public static final String ROOF_TYPE_TABLE_NAME = "roofType";
    public static final String ROOF_TYPE_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.ROOF_TYPE_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";

    /* YIELD_METHOD_TABLE_NAME */

    public static final String YIELD_METHOD_TABLE_NAME = "yieldMethod";
    public static final String YIELD_METHOD_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.YIELD_METHOD_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";

    /* PROJECT_IMPLEMENTATION_TABLE_NAME */

    public static final String PROJECT_IMPLEMENTATION_TABLE_NAME = "projectImplementation";
    public static final String PROJECT_IMPLEMENTATION_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.PROJECT_IMPLEMENTATION_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";

    /* ROI_METHOD_TABLE_NAME */

    public static final String ROI_METHOD_TABLE_NAME = "roiMethod";
    public static final String ROI_METHOD_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.ROI_METHOD_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";
    
    
    
    /* ROI_METHOD_TABLE_NAME */

    public static final String HOLYDAY_lIST_TABLE_NAME = "holidayList";
    public static final String HOLYDAY_lIST_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "
	    + Constants.HOLYDAY_lIST_TABLE_NAME
	    + " ("
	    + "_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," + "name TEXT)";
    

    /* PRIVATE CONSTRUCTOR */

    private Constants() {
    }

}
