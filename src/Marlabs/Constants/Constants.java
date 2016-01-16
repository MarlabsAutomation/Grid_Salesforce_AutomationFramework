package Marlabs.Constants;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

public abstract class Constants {
	
	//public static String URL = "http://10.150.4.27/login.do";
	public static String URL ="https://login.salesforce.com/";
	//Selected Framework
	public static String SelectedFramework;
	
	
	//Main Test Suite Name & path
	public static String TestSuiteName = "Testsuite.xlsx";
	public static String TestSuitePath = System.getProperty("user.dir")+ "\\src\\Marlabs\\Data\\"+TestSuiteName;
	public static String TestSuiteSheetname = "Sheet1";
	
	//Properties file path
	public static String PropertiesFilePath = System.getProperty("user.dir")+"\\src\\Marlabs\\Data\\Procedure_data.properties";
	
	//Set the selected suite
	public static String SelectedSuite="Regression";
	
	//Flag for Bugzilla
	public static String bugzilla = "No";
	public static String Bug_URL = "http://10.12.4.15/bugzilla/xmlrpc.cgi";
	public static String Bug_UN = "Prasad.TC@marlabs.com";
	public static String Bug_PW = "marlabs123";
	public static String Bug_Product = "Automation";
	public static String Bug_Component = "Automation";
	public static String Bug_Version = "1.0";
	public static String Bug_OS = "Windows";
	public static String Bug_Platform = "PC";
	public static String Bug_Priority = "Normal";
	public static String Bug_Severity = "Normal";
	public static String Bug_summary;
	public static String Bug_description;
	
	
	//Browsers to execute
	public static String IE;
	public static String Firefox;
	public static String Chrome;
	public static String Safari;
	public static String Mobile;
	public static String Run_date;
	
	//Object repository
	//ActiTime_ObjectRepository.xlsx
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static MultiMap<String, ?> multiMap = new MultiValueMap();
	public static String OR_Path = System.getProperty("user.dir")+"\\src\\Marlabs\\Data\\SalesForce_objectRepository.xlsx";
	public static String OR_SheetName = "OR";
	public static String OR_Identifier = "Name";
	public static String OR_LocatorType = "AttributeType";
	public static String OR_Locator = "Locator";
	//public static WebDriver driver;
	
	//regression and Smoke test suite name & path
	//ActiTime_Regression.xlsx
	public static String RegressionSuiteName = "SalesForce_Regression.xlsx";
	public static String RegressionModulesSheetName = "Modules";
    public static String RegressionSubModulesSheetName = "SubModules";
	public static String RegressionSuiteSheetName = "TestCases";
	public static String SmokeSuiteName = "Smoke.xlsx";
	public static String RegressionTestSuite = System.getProperty("user.dir")+ "\\src\\Marlabs\\Data\\"+RegressionSuiteName;
	public static String SmokeTestSuite = System.getProperty("user.dir")+ "\\src\\Marlabs\\Data\\"+SmokeSuiteName;
	public static String SmokeSuiteSheetName = "TestCases";
	//Mobile test suite name & path
	public static String MobileSuiteName = "MobileRegression.xlsx";
	public static String MobileSuiteSheetName = "TestCases";
	public static String MobileTestSuite = System.getProperty("user.dir")+ "\\src\\Marlabs\\Data\\"+MobileSuiteName;
	
	//Flagged Test Cases for the suite
	public static ArrayList<String> FlaggedTCs = new ArrayList<String>();
	//Flagged Test Cases for the mobile suite
	public static ArrayList<String> MobileFlaggedTCs = new ArrayList<String>();
	
	//Pass and Fail update
	public static String KEYWORD_PASS = "PASS";
	public static String KEYWORD_FAIL = "FAIL";
	
	//storing result set of the keywords
	public static String keyword_execution_result;
	public static Map<String, String> OverallStatus_Chrome = new LinkedHashMap <String, String> ();
	public static Map<String, String> OverallStatus_IE = new LinkedHashMap <String, String> ();
	public static Map<String, String> OverallStatus_FE = new LinkedHashMap <String, String> ();
	public static Map<String, String> OverallStatus_Safari = new LinkedHashMap <String, String> ();
	public static Map<String, String> OverallStatus_Mobile = new LinkedHashMap <String, String> ();
	
	//For database
	public static String DBurl = "jdbc:mysql://localhost:3306/marlabs";
	public static String DBuser = "root";
	public static String DBpassword = "";
	
	//RUN ID
	public static String Run_ID;
	
	//TestLink
	public static String DEVKEY="d8283c67f63deb539308236cc3981d05";
	public static String testlinkURL="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	
	}
