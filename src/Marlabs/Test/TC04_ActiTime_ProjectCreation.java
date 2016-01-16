package Marlabs.Test;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import Marlabs.Core.BaseClass;
import Marlabs.Core.Keywords;
import Marlabs.Core.Testlink;
import Marlabs.Core.WriteToDB;
import Marlabs.Objects.OR;

public class TC04_ActiTime_ProjectCreation extends BaseClass {
	static Keywords keywords = new Keywords();
	static ArrayList<String> object;
	static OR or = new OR();
	static WebElement element;

	public static void test(WebDriver driver, ExtentTest test,
			String currentTCName) throws Exception {
		String results;
		String data;
		
		try {
			// Click the project link
			Thread.sleep(3000);
			results = keywords.clickLink(driver, "Proj_Button", "");
			writeresults(results, driver, "Clicking on Task Project button", test,
					currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		   //ProjectID = StrCustID;
			results = keywords.writeInInputProject(driver, "Proj_NameTxtBox", "");
			writeresults(results, driver, "Enter the name", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			// Click project dropdown
			results = keywords.clickLink(driver, "Proj_Dropdown", "");
			writeresults(results, driver, "Clicking on Task Project dropdown",
					test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Fill the project name
			data = getProperty("Proj_NameTxt");
			results = keywords.SelectProjectDropDown(driver, "", "");
			writeresults(results, driver, "Select dropdown value", test,
					currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			results = keywords.clickLink(driver, "Proj_TaskBtn", "");
			writeresults(results, driver, "Clicking on Task button", test,
					currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			// Click project submit button
			results = keywords.clickLink(driver, "Proj_SubmitBtn", "");
			writeresults(results, driver, "Clicking on Task Project submit button",
					test, currentTCName);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			//Success message
			data = getProperty("CustSucMsg");
			results = keywords.verifyLinkText(driver, "Proj_SuccMsg", data);
			writeresults(results, driver, "Verify the success message", test,
					currentTCName);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			WriteToDB.updateMainResults(driver, currentTCName);
			String Browser1 = WriteToDB.determineBrowser(driver);
			Testlink.Testfail(Browser1,currentTCName, "Fail");
		}				
		WriteToDB.updateMainResults(driver, currentTCName);
		String Browser2 = WriteToDB.determineBrowser(driver);
		 Testlink.Testpass(Browser2,currentTCName,"Pass");
	}

}
