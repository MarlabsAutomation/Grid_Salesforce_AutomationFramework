package Marlabs.Core;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;

import Marlabs.Constants.Constants;

public class WriteToDB {

	public static String url = Constants.DBurl;
	public static String user = Constants.DBuser;
	public static String password = Constants.DBpassword;

	// Writing the main suite name and test cases names.
	public static void writingMainResults(String TestSuite, String TestCase,
			WebDriver driver) {

		String Browser = determineBrowser(driver);

		Connection conn = connect();

		String sql = "INSERT INTO marlabs_automation (Run_ID, Date, TestSuite, TestCase, Browser) values (?, ?, ?, ?, ?)";

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, Constants.Run_ID);
			statement.setString(2, Constants.Run_date);
			statement.setString(3, TestSuite);
			statement.setString(4, TestCase);
			statement.setString(5, Browser);

			int row = statement.executeUpdate();
			if (row > 0) {
				// System.out.println("Main DB - A contact was inserted");
			}
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static String determineBrowser(WebDriver driver) {

		String Browser = null;

		if (driver.toString().contains("internet")) {

			Browser = "IE";
		}
		if (driver.toString().contains("chrome")) {

			Browser = "Chrome";
		}
		if (driver.toString().contains("firefox")) {

			Browser = "FE";
		}
		if (driver.toString().contains("Safari")) {

			Browser = "Safari";
		}
		
	/*	if (driver.toString().contains("Mobile")) {

			Browser = "Mobile";
		}*/
		return Browser;
	}

	public static void updateMainResults(WebDriver driver, String TestCase) {

		String Browser = determineBrowser(driver);

		String Status = null;

		if (Browser.equalsIgnoreCase("Chrome")) {

			for (Entry<String, String> entry : Constants.OverallStatus_Chrome
					.entrySet()) {

				if (entry.getValue().startsWith("FAIL")) {
					// System.out.println(entry.getKey());
					Status = "Fail";
					break;
				} else {
					Status = "Pass";
				}

			}

			Constants.OverallStatus_Chrome.clear();
			writeMResults(driver, Status, TestCase);

		}

		if (Browser.equalsIgnoreCase("IE")) {

			for (Entry<String, String> entry : Constants.OverallStatus_IE
					.entrySet()) {

				if (entry.getValue().startsWith("FAIL")) {
					// System.out.println(entry.getKey());
					Status = "Fail";
					break;
				} else {
					Status = "Pass";
				}

			}

			Constants.OverallStatus_IE.clear();
			writeMResults(driver, Status, TestCase);
		}
		
		// For safari
		if (Browser.equalsIgnoreCase("Safari")) {

			for (Entry<String, String> entry : Constants.OverallStatus_Safari
					.entrySet()) {

				if (entry.getValue().startsWith("FAIL")) {
					// System.out.println(entry.getKey());
					Status = "Fail";
					break;
				} else {
					Status = "Pass";
				}

			}

			Constants.OverallStatus_Safari.clear();
			writeMResults(driver, Status, TestCase);
		}
		

		if (Browser.equalsIgnoreCase("FE")) {

			for (Entry<String, String> entry : Constants.OverallStatus_FE
					.entrySet()) {

				if (entry.getValue().startsWith("FAIL")) {
					// System.out.println(entry.getKey());
					Status = "Fail";
					break;
				} else {
					Status = "Pass";
				}

			}

			Constants.OverallStatus_FE.clear();
			writeMResults(driver, Status, TestCase);
		}
		if (Browser.equalsIgnoreCase("Mobile")) {
			for (Entry<String, String> entry : Constants.OverallStatus_Mobile
					.entrySet()) {

				if (entry.getValue().startsWith("FAIL")) {
					// System.out.println(entry.getKey());
					Status = "Fail";
					break;
				} else {
					Status = "Pass";
				}

			}
			Constants.OverallStatus_Mobile.clear();
			writeMResults(driver, Status, TestCase);
		}

	}

	// Write main results
	public static void writeMResults(WebDriver driver, String Status,
			String TestCase) {
		try {

			String Browser = determineBrowser(driver);

			Connection conn = connect();

			String sql = "UPDATE marlabs_automation SET Status = ?"
					+ " WHERE Run_ID = ?" + " AND TestCase = ?"
					+ " AND Browser = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, Status);
			statement.setString(2, Constants.Run_ID);
			statement.setString(3, TestCase);
			statement.setString(4, Browser);

			int row = statement.executeUpdate();
			if (row > 0) {
				// System.out.println("A contact was inserted");
			}
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	
	// getting the date and time
	public static String getdateTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// get current date time with Date()
		Date date = new Date();

		// get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		// System.out.println(dateFormat.format(cal.getTime()));

		return dateFormat.format(cal.getTime());
	}

	// Database Connection
	public static Connection connect() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Could not conect to the Database");
		}
		return conn;
	}

	// Writing to the specific browser database
	public static void writingResults(WebDriver driver, String TestCase,
			String TestStep, String Status, String path) {

		Connection conn = connect();

		String sql = null;
		String browser = null;
		String pth = path;

		if (driver.toString().contains("internet")) {

			browser = "IE";

			if (pth == null) {
				sql = "INSERT INTO ie_results (Run_ID, BrowserName, TestCase, TestStep, Status) values (?, ?, ?, ?, ?)";
			} else {
				sql = "INSERT INTO ie_results (Run_ID, BrowserName, TestCase, TestStep, Status, ScreenShot) values (?, ?, ?, ?, ?, ?)";
			}
		}
		if (driver.toString().contains("chrome")) {

			browser = "Chrome";

			if (pth == null) {
				sql = "INSERT INTO chrome_results (Run_ID, BrowserName, TestCase, TestStep, Status) values (?, ?, ?, ?, ?)";
			} else {
				sql = "INSERT INTO chrome_results (Run_ID, BrowserName, TestCase, TestStep, Status, ScreenShot) values (?, ?, ?, ?, ?, ?)";
			}
		}
		if (driver.toString().contains("firefox")) {

			browser = "FE";

			if (pth == null) {

				sql = "INSERT INTO fe_results (Run_ID, BrowserName, TestCase, TestStep, Status) values (?, ?, ?, ?, ?)";
			} else {
				sql = "INSERT INTO fe_results (Run_ID, BrowserName, TestCase, TestStep, Status, ScreenShot) values (?, ?, ?, ?, ?, ?)";
			}

		}
		//Safari browser
		if (driver.toString().contains("Safari")) {

			browser = "Safari";

			if (pth == null) {

				sql = "INSERT INTO safari_results (Run_ID, BrowserName, TestCase, TestStep, Status) values (?, ?, ?, ?, ?)";
			} else {
				sql = "INSERT INTO safari_results (Run_ID, BrowserName, TestCase, TestStep, Status, ScreenShot) values (?, ?, ?, ?, ?, ?)";
			}

		}
		

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Constants.Run_ID);
			statement.setString(2, browser);
			statement.setString(3, TestCase);
			statement.setString(4, TestStep);
			statement.setString(5, Status);

			if (!(pth == null)) {
				InputStream inputStream = new FileInputStream(new File(path));

				statement.setBlob(6, (Blob) inputStream);
			}

			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("A contact was inserted.");
			}

			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void MobileupdateMainResults(AppiumDriver driver,String TestCase) {

		String Browser = "Mobile";

		String Status = "Fail";

		Connection conn = connect();

		String sql = "UPDATE marlabs_automation SET Status = ?"
				+ " WHERE Run_ID = ?";

		if (Browser.equalsIgnoreCase("Mobile")
				&& Constants.OverallStatus_Mobile.containsValue("Fail")) {

			Status = "Fail";
		} else {
			Status = "Pass";
		}

		System.out.println(Constants.Run_ID + "---" + Status);

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, Status);
			statement.setString(2, Constants.Run_ID);

			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("A contact was inserted");
			}
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	// Writing to the specific browser database
	public static void MobilewritingResults(AppiumDriver driver,
			String TestCase, String TestStep, String Status,
			String path) {

		Connection conn = connect();

		String sql = null;
		String browser = null;
		String pth = path;

		browser = "Mobile";

		if (pth == null) {

			sql = "INSERT INTO mobile_results (Run_ID, BrowserName, TestCase,  TestStep, Status) values (?, ?, ?, ?, ?)";
		}

		else {
			sql = "INSERT INTO mobile_results (Run_ID, BrowserName, TestCase, TestStep, Status, ScreenShot) values (?, ?, ?, ?, ?, ?)";
		}

		try {
			//System.out.println(step_no);
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Constants.Run_ID);
			statement.setString(2, browser);
			statement.setString(3, TestCase);
			statement.setString(4, TestStep);
			statement.setString(5, Status);
		
			if (!(pth == null)) {
				InputStream inputStream = new FileInputStream(new File(path));

				statement.setBlob(6, (Blob) inputStream);
			}

			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("A contact was inserted.");
			}

			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Writing the main suite name and test cases names.
	public static void MobilewritingMainResults(String TestSuite,
			String TestCase, AppiumDriver driver) {

		String Browser = "Mobile";

		Connection conn = connect();

		String sql = "INSERT INTO marlabs_automation (Run_ID, Date, TestSuite, TestCase, Browser) values (?, ?, ?, ?, ?)";

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, Constants.Run_ID);
			statement.setString(2, Constants.Run_date);
			statement.setString(3, TestSuite);
			statement.setString(4, TestCase);
			statement.setString(5, Browser);

			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("Main DB - A contact was inserted");
			}
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}