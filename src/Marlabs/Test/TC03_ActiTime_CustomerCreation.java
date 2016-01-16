package Marlabs.Test;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import Marlabs.Core.BaseClass;
import Marlabs.Core.Keywords;
import Marlabs.Core.Testlink;
import Marlabs.Objects.OR;

import org.openqa.selenium.WebDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentTest;

import Marlabs.Core.WriteToDB;

public class TC03_ActiTime_CustomerCreation extends BaseClass{

	static Keywords keywords = new Keywords();
	static ArrayList<String> object; 
	static OR or = new OR();
	static WebElement element;
	
	public static void test(WebDriver driver, ExtentTest test, String currentTCName) throws Exception{
	String results;
	String data;
	
		try {					
			//Task creation
			results=keywords.clickLink(driver, "TaskCreate", "");
			writeresults(results, driver, "Clicking on Task tab", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
			
			//Click the project tab
			results=keywords.clickLink(driver, "Task_ProjectButton", "");
			writeresults(results, driver, "Clicking on Task Project tab", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Click the Customer link tab
			results=keywords.clickLink(driver, "Task_CustButton", "");
			writeresults(results, driver, "Clicking on Task customer tab", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Fill customer name			
			results=keywords.writeInInputCustomer(driver, "Task_CustTxtBox", "");
			writeresults(results, driver, "Enter the name", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			//Fill the user name
			data = getProperty("CustDesc");
			results=keywords.writeInInput(driver, "Task_CustDescTxtBox", data);
			writeresults(results, driver, "Enter the name", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(500);
			
			//Click confirm button
			results=keywords.clickLink(driver, "Task_CustConfirmBtn", "");
			writeresults(results, driver, "Clicking on customer button tab", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(3000);
			
			//Fill the user name
			data = getProperty("CustSucMsg");
			results=keywords.verifyLinkText(driver, "Task_CustSuccssMsg", data);
			writeresults(results, driver, "Verify the success message", test, currentTCName);	
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}		
		catch (Exception e) {
			WriteToDB.updateMainResults(driver, currentTCName);
			String Browser1 = WriteToDB.determineBrowser(driver);
			Testlink.Testfail(Browser1,currentTCName, "Fail");
		}
		WriteToDB.updateMainResults(driver, currentTCName);
		String Browser2 = WriteToDB.determineBrowser(driver);
		 Testlink.Testpass(Browser2,currentTCName,"Pass");
	}
}
