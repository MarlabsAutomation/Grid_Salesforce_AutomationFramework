package Marlabs.salesforce;

import Marlabs.Core.BaseClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Marlabs.Core.Keywords;
import Marlabs.Core.Testlink;
import Marlabs.Core.WriteToDB;
import Marlabs.Objects.OR;

import com.relevantcodes.extentreports.ExtentTest;


/**
 * @author Selenium
 *
 */
public class TC01_Salesforce_Login extends BaseClass {

	static Keywords keywords = new Keywords();
	static ArrayList<String> object;
	static OR or = new OR();
	static WebElement element;

	public static void test(WebDriver driver, ExtentTest test,String currentTCName) throws Exception {
		String results;
		String data;		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String browserName = WriteToDB.determineBrowser(driver);
		try {
			data = getProperty("salesforceLogin");
			// Enter the user name
			results = keywords.writeInInput(driver, "Username", data);
			writeresults(results, driver, "Enter the user name", test,
					currentTCName);
			Thread.sleep(500);
			
			data = getProperty("salesforcepassword");
			// Enter the user name
			results = keywords.writeInInput(driver,
					"Password", data);
			writeresults(results, driver, "Enter the user password", test,
					currentTCName);
			Thread.sleep(500);
			results = keywords.clickLink(driver, "Login", "");
			writeresults(results, driver, "Clicking on the login button", test,
					currentTCName);
			
/*
			if (browserName.equalsIgnoreCase("Safari")) {
				// Enter password
				data = getProperty("Password");
				// Enter the user name
				results = keywords.writeInInputByCssSelector(driver,
						"UserPassSafari", data);
				writeresults(results, driver, "Enter the user password", test,
						currentTCName);
				Thread.sleep(500);
			} else { // Enter password
				data = getProperty("Password");
				// Enter the user name
				results = keywords.writeInInput(driver, "Password", data);
				writeresults(results, driver, "Enter the user password", test,
						currentTCName);
				Thread.sleep(500);
			}*/
			// Click on the your login button
		
			Thread.sleep(5000);
			data = getProperty("salesforceTitle");
			results = keywords.VerifyThePageTitle(driver, data);
			writeresults(results, driver, "Verify the salesforceTitle ", test,
					currentTCName);
		} 
		
		catch (Exception e) 
		{
		
			WriteToDB.updateMainResults(driver, currentTCName);
			String Browser1 = WriteToDB.determineBrowser(driver);
			Testlink.Testfail(Browser1,currentTCName, "Fail");
		}
		
		 String Browser2 = WriteToDB.determineBrowser(driver);
		 Testlink.Testpass(Browser2,currentTCName,"Pass");
		WriteToDB.updateMainResults(driver, currentTCName);
	}
}
