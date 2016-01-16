package Marlabs.Core;

import io.appium.java_client.AppiumDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Marlabs.Bugzilla.Bugzilla;
import Marlabs.Constants.Constants;
import Marlabs.Drivers.ExecuteThread;
import Marlabs.Objects.OR;
import Marlabs.Reports.ExtentReport;
import TestLink.TestLink_Demo;

public class BaseClass extends OR {

	public static Xls_Reader excel = null;
	public static Xls_Reader Mexcel = null;
	public static OR obj = new OR();
	//public static WebDriver driver;

	public static Keywords keywords;
	public static Method method[];
	public static String currentKeyWord;
	//For Internet explorer
	public static String CustomerID_IE;
	public static String ProjectID_IE;
	//For Chrome
	public static String CustomerID_CH;
	public static String ProjectID_CH;
	//For Safari
	public static String CustomerID_SAF;
	public static String ProjectID_SAF;
	//For FireFox
	public static String CustomerID_FF;
	public static String ProjectID_FF;

	public static void flaggedTestCases() {

		generateRunID();
		generateCustomerProdutID();
		// Xls_Reader excel = null;
		String sheetName = null;

		if (Constants.SelectedSuite.contains("Regression")) {
			excel = new Xls_Reader(Constants.RegressionTestSuite);
			sheetName = Constants.RegressionSuiteSheetName;
		}
		if (Constants.SelectedSuite.contains("Smoke")) {
			excel = new Xls_Reader(Constants.SmokeTestSuite);
			sheetName = Constants.SmokeSuiteSheetName;
		}

		// Get all the flagged test cases
		for (int i = 0; i < excel.getRowCount(sheetName); i++) {
			if (excel.getCellData(sheetName, "RunMode", i).equalsIgnoreCase(
					"Yes")) {

				String tcName = excel.getCellData(sheetName, "TestCase", i);
				Constants.FlaggedTCs.add(tcName);
			}
		}

		// get all the flagged test cases for mobile
		Mexcel = new Xls_Reader(Constants.MobileTestSuite);
		String MsheetName = Constants.MobileSuiteSheetName;
		for (int i = 0; i < Mexcel.getRowCount(MsheetName); i++) 
		{
			if (Mexcel.getCellData(MsheetName, "RunMode", i).equalsIgnoreCase(
					"Yes")) {

				String tcName = Mexcel.getCellData(MsheetName, "TestCase", i);

				Constants.MobileFlaggedTCs.add(tcName);
			}
		}
	}

	// Get the test cases which are flagged Yes and store into the array
	public static void printSelectedCases() {
		flaggedTestCases();
		// System.out.println(Constants.MobileFlaggedTCs.size());
		/*
		 * for(int i=0; i<Constants.MobileFlaggedTCs.size(); i++){
		 * //System.out.println(Constants.MobileFlaggedTCs.get(i)); }
		 */
	}

	// Initialise the excel suites
	public static void initialiseExcel() {

		// System.out.println("Excel...");
		try {
			if (Constants.SelectedSuite.contains("Regression")) {
				excel = new Xls_Reader(Constants.RegressionTestSuite);
				// sheetName = Constants.RegressionSuiteSheetName;
			}
			if (Constants.SelectedSuite.contains("Smoke")) {
				excel = new Xls_Reader(Constants.SmokeTestSuite);
				// sheetName = Constants.SmokeSuiteSheetName;
			}
		} catch (Exception e) {
			// System.out.println("Cannot initialise the excel suite");
		}
	}

	// Get the test cases flagged Yes and execute
	public static void execute(WebDriver driver) throws Exception {

		Thread.sleep(5000);
		keywords = new Keywords();
		method = keywords.getClass().getMethods();
		String currentTCName = null;

		// Start the reporting
		ExtentReports extent = ExtentReport.startReport(driver);

		try 
		{
			for (int i = 0; i < Constants.FlaggedTCs.size(); i++) {
				// System.out.println(Constants.FlaggedTCs.get(i));

				currentTCName = Constants.FlaggedTCs.get(i);
				// System.out.println("Numbet TCS: "+excel.getRowCount(currentTCName));

				ExtentTest test = extent.startTest(currentTCName);

				WriteToDB.writingMainResults(Constants.SelectedSuite,
						currentTCName, driver);

				for (int j = 2; j < excel.getRowCount(currentTCName); j++) {

					String step = excel.getCellData(currentTCName, "StepNo", j);
					String desc = excel.getCellData(currentTCName,
							"Description", j);
					currentKeyWord = excel.getCellData(currentTCName, "Action",
							j);
					String ORef = excel.getCellData(currentTCName, "Object", j);
					String data = excel.getCellData(currentTCName, "TestData",
							j);

					ArrayList<String> object = OR.getObject(ORef);

					// System.out.println(Thread.currentThread()+"-------"+desc+"----"+currentKeyWord+"----"+object.get(0)+"----"+object.get(1)+"----"+data);

					/*WebElement element = getObject(driver, object.get(0),
							object.get(1));*/
					try{
						// Using the reflection API, collect all the keywords
						for (int k = 0; k < method.length; k++) {

							Double t = Double.valueOf(step);
							int step_no = t.intValue();

							// comparing the keywords of keywords.class to
							if (method[k].getName().equals(currentKeyWord)) {


								Constants.keyword_execution_result = (String) method[k]
										.invoke(keywords, driver, ORef, data);

								System.out.println(desc+"-"+Constants.keyword_execution_result);

								String Browser = WriteToDB.determineBrowser(driver);

								//
								if (Browser.equalsIgnoreCase("Chrome")) {
									Constants.OverallStatus_Chrome.put(desc,
											Constants.keyword_execution_result);
								}
								if (Browser.equalsIgnoreCase("IE")) {
									Constants.OverallStatus_IE.put(desc,
											Constants.keyword_execution_result);
								}
								if (Browser.equalsIgnoreCase("FE")) {
									Constants.OverallStatus_FE.put(desc,
											Constants.keyword_execution_result);
								}
								if (Browser.equalsIgnoreCase("Safari")) {
									Constants.OverallStatus_Safari.put(desc,
											Constants.keyword_execution_result);
								}							
								if (Browser.equalsIgnoreCase("Mobile")) {
									Constants.OverallStatus_Mobile.put(desc,
											Constants.keyword_execution_result);
								}

								if (Constants.keyword_execution_result
										.equalsIgnoreCase("Pass")) {

									test.log(LogStatus.PASS, desc);

									WriteToDB.writingResults(driver, currentTCName,
											desc,
											Constants.keyword_execution_result,
											null);

								}
								else
								{

									String imagePath = ExtentReport
											.createScreenshot(driver);

									// test.log(LogStatus.FAIL, desc, imagePath);
									test.log(LogStatus.FAIL,desc, imagePath);
									
									Constants.Bug_summary = "["+Browser+"]"+" "+desc;
									Constants.Bug_description = Constants.Bug_summary+"\n"+" Please refer to the screen shot - "+imagePath;
									
									//Create bug in Bugzilla
									Bugzilla.bug(Constants.Bug_summary, Constants.Bug_description);
									
									WriteToDB.writingResults(driver, currentTCName,
											desc,
											Constants.keyword_execution_result,
											imagePath);

								}
							}												
						}

					}
					catch(Exception e)
					{
						System.out.println("No such element found------->>>: "+desc+"----"+e.getMessage());
						
						String Browser = WriteToDB.determineBrowser(driver);
						
						String imagePath = ExtentReport
								.createScreenshot(driver);

						// test.log(LogStatus.FAIL, desc, imagePath);
						test.log(LogStatus.FAIL, desc);
						
						Constants.Bug_summary = "["+Browser+"]"+" "+desc;
						Constants.Bug_description = Constants.Bug_summary+"\n"+" Please refer to the screen shot - "+imagePath;
						
						//Create bug in Bugzilla
						Bugzilla.bug(Constants.Bug_summary, Constants.Bug_description);
												
						WriteToDB.writingResults(driver, currentTCName,
								desc,
								Constants.keyword_execution_result,
								imagePath);

						break;
					}

				}
				String Browser1 = WriteToDB.determineBrowser(driver);
				Testlink.Testpass(Browser1,currentTCName,"Pass");
				WriteToDB.updateMainResults(driver, currentTCName);


			}

		} 

		catch (Exception e) {

			WriteToDB.updateMainResults(driver, currentTCName);
			String Browser2 = WriteToDB.determineBrowser(driver);
			//Testlink.Testfail(Browser2,currentTCName, "Fail");
			System.out.println("Not able to execute the keyword: ");
		}
		extent.close();
	}

	@SuppressWarnings("unchecked")
	public static void executeClass(WebDriver driver) {

		ClassLoader classLoader = BaseClass.class.getClassLoader();

		ExtentReports extent = ExtentReport.startReport(driver);

		for (int i = 0; i < Constants.FlaggedTCs.size(); i++) {

			String currentTCName = Constants.FlaggedTCs.get(i);

			// Start the reporting

			ExtentTest test = extent.startTest(currentTCName);

			WriteToDB.writingMainResults(Constants.SelectedSuite,
					currentTCName, driver);

			try {
				Class myClass = Class.forName("Marlabs.salesforce." + currentTCName);
				
				//Class myClass = Class.forName("Marlabs.Test." + currentTCName);

				Method m[] = myClass.getDeclaredMethods();

				for (int k = 0; k < m.length; k++) {

					String keyword = "test";

					// execute the classes
					m[k].invoke(keyword, driver, test, currentTCName);

				}

			} catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		extent.close();
	}


	@SuppressWarnings("unchecked")
	public static void mobileexecuteClass(AppiumDriver driver) {

		ClassLoader classLoader = BaseClass.class.getClassLoader();

		ExtentReports extent = ExtentReport.MobilestartReport(driver);

		for (int i = 0; i < Constants.MobileFlaggedTCs.size(); i++) {

			String currentTCName = Constants.MobileFlaggedTCs.get(i);

			// Start the reporting

			ExtentTest test = extent.startTest(currentTCName);
			WriteToDB.MobilewritingMainResults(Constants.SelectedSuite, currentTCName, driver);
			//WriteToDB.writingMainResults(Constants.SelectedSuite,
			//currentTCName, driver);

			try 
			{
				Class myClass = Class.forName("Marlabs.Mobile."+ currentTCName);

				Method m[] = myClass.getDeclaredMethods();

				for (int k = 0; k < m.length; k++) {

					String keyword = "test";

					// execute the classes
					m[k].invoke(keyword, driver, test, currentTCName);

				}

			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		extent.close();
	}



	public static void initialize(WebDriver driver) throws Exception {

		// Initialize by getting the main URL
                driver.get(Constants.URL);
		
		if (!(driver.toString().contains("Internet"))) {
			System.out.println("ddd"+driver.toString());
			// Maximize the browser
			driver.manage().window().maximize();
		}

		initialiseExcel();

		if (Constants.SelectedFramework.equalsIgnoreCase("KeyWord")) {

			// Execute the keywords
			execute(driver);
		} else {
			executeClass(driver);
		}
	}

	
	public static void Mobiinitialize() throws Exception {
		ExecuteThread et=new ExecuteThread();
		if (Constants.SelectedFramework.equalsIgnoreCase("KeyWord")) {
			// Execute the keywords
		et.Mobile();
		} 
		else {
			et.Mobilepage();
			//executeClass();
		}
	}
	
	
	public static void initializeFE(WebDriver driver) throws Exception {

		// Initialize by getting the main URL
		driver.get(Constants.URL);

		// Maximize the browser
		driver.manage().window().maximize();

		initialiseExcel();

		if (Constants.SelectedFramework.equalsIgnoreCase("KeyWord")) {
			// Execute the keywords
			executeFE(driver);
		} else {
			executeClass(driver);
		}
	}

	// Get the test cases flagged Yes and execute
	public static void executeFE(WebDriver driver) throws Exception {

		Thread.sleep(5000);
		keywords = new Keywords();
		method = keywords.getClass().getMethods();
		String currentTCName = null;

		// Start the reporting
		ExtentReports extent = ExtentReport.startReport(driver);

		try {
			for (int i = 0; i < Constants.FlaggedTCs.size(); i++) {

				currentTCName = Constants.FlaggedTCs.get(i).toString();
				// System.out.println("Numbet TCS: "+excel.getRowCount(currentTCName));

				ExtentTest test = extent.startTest(currentTCName);

				WriteToDB.writingMainResults(Constants.SelectedSuite,
						currentTCName, driver);

				for (int j = 2; j < excel.getRowCount(currentTCName); j++) {

					String step = excel.getCellData(currentTCName, "StepNo", j);
					String desc = excel.getCellData(currentTCName,
							"Description", j);
					currentKeyWord = excel.getCellData(currentTCName, "Action",
							j);
					String ORef = excel.getCellData(currentTCName, "Object", j);
					String data = excel.getCellData(currentTCName, "TestData",
							j);

					ArrayList<String> object = OR.getObject(ORef);

					// System.out.println(Thread.currentThread()+"-------"+desc+"----"+currentKeyWord+"----"+object.get(0)+"----"+object.get(1)+"----"+data);

					WebElement element = getObject(driver, object.get(0),
							object.get(1));

					// Using the reflection API, collect all the keywords
					for (int k = 0; k < method.length; k++) {

						Double t = Double.valueOf(step);
						int step_no = t.intValue();

						// comparing the keywords of keywords.class to
						// spreadsheet(currentKeyWord)
						if (method[k].getName().equals(currentKeyWord)) {

							Constants.keyword_execution_result = (String) method[k]
									.invoke(keywords, driver, ORef, data);

							String Browser = WriteToDB.determineBrowser(driver);

							// System.out.println(desc+"-"+Constants.keyword_execution_result);

							if (Browser.equalsIgnoreCase("Chrome")) {
								Constants.OverallStatus_Chrome.put(desc,
										Constants.keyword_execution_result);
							}
							if (Browser.equalsIgnoreCase("IE")) {
								Constants.OverallStatus_IE.put(desc,
										Constants.keyword_execution_result);
							}
							if (Browser.equalsIgnoreCase("FE")) {
								Constants.OverallStatus_FE.put(desc,
										Constants.keyword_execution_result);
							}
							if (Browser.equalsIgnoreCase("Safari")) {
								Constants.OverallStatus_Safari.put(desc,
										Constants.keyword_execution_result);
							}

							if (Browser.equalsIgnoreCase("Mobile")) {
								Constants.OverallStatus_Mobile.put(desc,
										Constants.keyword_execution_result);
							}

							if (Constants.keyword_execution_result
									.equalsIgnoreCase("Pass")) {

								test.log(LogStatus.PASS, desc);

								WriteToDB.writingResults(driver, currentTCName,
										desc,
										Constants.keyword_execution_result,
										null);

							} else {

								String imagePath = ExtentReport
										.createScreenshot(driver);

								// test.log(LogStatus.FAIL, desc, imagePath);
								test.log(LogStatus.FAIL, desc);

								WriteToDB.writingResults(driver, currentTCName,
										desc,
										Constants.keyword_execution_result,
										imagePath);

							}

						}

					}

				}

				WriteToDB.updateMainResults(driver, currentTCName);

			}

		} catch (Exception e) {
			System.out.println("Not able to execute the keyword: "
					+ e.getStackTrace());
			WriteToDB.updateMainResults(driver, currentTCName);
		}
		extent.close();
	}

	public static void generateRunID() {

		UUID ID = UUID.randomUUID();

		String strID = ID.toString();

		Constants.Run_ID = strID;
	}

	// Generate the random number for the customer creation
	public static void generateCustomerProdutID() {
		Random random=new Random();
		Set randomValue=new HashSet();
		for (int i = 1; i <=12; i++) {
			int intValue=random.nextInt(1000) + 1;
			randomValue.add(intValue);
		}
		List stringsList = new ArrayList(randomValue);	
		//For the customer creation
		CustomerID_IE = stringsList.get(0).toString() + "_CustomerName";
		CustomerID_CH = stringsList.get(1).toString() + "_CustomerName";
		CustomerID_SAF = stringsList.get(2).toString() + "_CustomerName";
		CustomerID_FF = stringsList.get(3).toString() + "_CustomerName";
		// For the product creation
		ProjectID_IE = stringsList.get(4).toString() + "_ProductName";
		ProjectID_CH =stringsList.get(5).toString() + "_ProductName";
		ProjectID_SAF =stringsList.get(6).toString() + "_ProductName";
		ProjectID_FF = stringsList.get(7).toString() + "_ProductName";
	}


	public static String getProperty(String value) {

		Properties prop = new Properties();
		InputStream input = null;
		String Value = null;

		try {
			input = new FileInputStream(Constants.PropertiesFilePath);

			// load a properties file
			prop.load(input);

			Value = prop.getProperty(value);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Value;
	}
	public static void Mobilewriteresults(String Results, AppiumDriver driver,
			String desc, ExtentTest test, String currentTCName) {

	     if (Results.equalsIgnoreCase("Pass")) {
			test.log(LogStatus.PASS, desc);
                   WriteToDB.MobilewritingResults(driver, currentTCName, desc, Constants.KEYWORD_PASS,null );
				}
		else {

			String imagePath = ExtentReport.createScreenshot(driver);

			// test.log(LogStatus.FAIL, desc, imagePath);
			test.log(LogStatus.FAIL, desc);

			WriteToDB.MobilewritingResults(driver, currentTCName, desc,
					Constants.KEYWORD_FAIL, imagePath);
		}
	}
	public static void writeresults(String Results, WebDriver driver,
			String desc, ExtentTest test, String currentTCName) {

		String Browser = WriteToDB.determineBrowser(driver);

		// System.out.println(desc+"-"+Results);

		if (Browser.equalsIgnoreCase("Chrome")) {
			Constants.OverallStatus_Chrome.put(desc, Results);
		}
		if (Browser.equalsIgnoreCase("IE")) {
			Constants.OverallStatus_IE.put(desc, Results);
		}
		if (Browser.equalsIgnoreCase("FE")) {
			Constants.OverallStatus_FE.put(desc, Results);
		}
		if (Browser.equalsIgnoreCase("Mobile")) {
			Constants.OverallStatus_Mobile.put(desc, Results);
		}
		if (Browser.equalsIgnoreCase("Safari")) {
			Constants.OverallStatus_Safari.put(desc, Results);
		}

		if (Results.equalsIgnoreCase("Pass")) {

			test.log(LogStatus.PASS, desc);

			WriteToDB.writingResults(driver, currentTCName, desc,
					Constants.KEYWORD_PASS, null);

		}
		else {

			String imagePath = ExtentReport.createScreenshot(driver);

			// test.log(LogStatus.FAIL, desc, imagePath);
			test.log(LogStatus.FAIL, desc);

			WriteToDB.writingResults(driver, currentTCName, desc,
					Constants.KEYWORD_FAIL, imagePath);
		}
	}


	/*public String testcasename()
	{
		for(int m=0;m<)
	}*/
	// Get the test cases flagged Yes and execute
	public static void Mobileexecute(AppiumDriver driver) throws Exception {

		Thread.sleep(5000); //changing from 10s
		keywords = new Keywords();
		method = keywords.getClass().getMethods();
		System.out.println("Mobile Testcase size: " + Constants.MobileFlaggedTCs.size());
		String currentTCName = null;
		
		try 
		{
			for (int i = 0; i < Constants.MobileFlaggedTCs.size(); i++) {

				System.out.println(Constants.MobileFlaggedTCs.size());

				 currentTCName = Constants.MobileFlaggedTCs.get(i);

				System.out.println("Testcase name: " + currentTCName);
				// System.out.println("Numbet TCS: "+excel.getRowCount(currentTCName));

				// Start the reporting
				ExtentReports extent = ExtentReport.MobilestartReport(driver);

				ExtentTest test = extent.startTest(currentTCName);

				WriteToDB.MobilewritingMainResults(Constants.SelectedSuite,
						currentTCName, driver);
				Mexcel = new Xls_Reader(Constants.MobileTestSuite);
				
				
				for (int j = 2; j < Mexcel.getRowCount(currentTCName); j++) {
					
					
					String step = Mexcel
							.getCellData(currentTCName, "StepNo", j);
					String desc = Mexcel.getCellData(currentTCName,
							"Description", j);

					currentKeyWord = Mexcel.getCellData(currentTCName,
							"Action", j);

					String ORef = Mexcel
							.getCellData(currentTCName, "Object", j);

					String data = Mexcel.getCellData(currentTCName, "TestData",
							j);

					ArrayList<String> object = OR.mobilegetObject(ORef);

//					 System.out.println("debug");
					/*System.out.println(Thread.currentThread() + "-------"
							+ desc + "----" + currentKeyWord + "----"
							+ object.get(0) + "----" + object.get(1) + "----"
							+ data);*/

					WebElement element = mobilegetObject(driver, object.get(0),object.get(1));

					//System.out.println("Element" + element);
					//System.out.println(method.length);
					// Using the reflection API, collect all the keywords
					for (int k = 0; k < method.length; k++) {

						//Double t = Double.valueOf(step);
						//int step_no = t.intValue();

						// comparing the keywords of keywords.class to
						// spreadsheet(currentKeyWord)
						if (method[k].getName().equals(currentKeyWord)) {

							Constants.keyword_execution_result = (String) method[k]
									.invoke(keywords, driver, ORef, data);

							System.out.println(desc + "-"
									+ Constants.keyword_execution_result);

							Constants.OverallStatus_Mobile.put(desc,
									Constants.keyword_execution_result);

							if (Constants.keyword_execution_result
									.equalsIgnoreCase("Pass")) {

								test.log(LogStatus.PASS, desc);

								WriteToDB.MobilewritingResults(driver,
										currentTCName,desc,
										Constants.keyword_execution_result,
										null);

							} 
							else 
							{

								String imagePath = ExtentReport
										.createScreenshot(driver);

								// test.log(LogStatus.FAIL, desc, imagePath);
								test.log(LogStatus.FAIL, desc);

								WriteToDB.MobilewritingResults(driver,
										currentTCName, desc,
										Constants.keyword_execution_result,
										imagePath);

							}

						}

					}

				}

				WriteToDB.MobileupdateMainResults(driver,currentTCName);
				Testlink.MobileTestPass(currentTCName, "Pass");
				extent.close();
			}
		} 

		catch (Exception e)
		{

		Testlink.MobileTestFail(currentTCName, "Fail");
			System.out.println("Not able to execute the keyword: "
					+ e.getStackTrace());
		}
	}

}
