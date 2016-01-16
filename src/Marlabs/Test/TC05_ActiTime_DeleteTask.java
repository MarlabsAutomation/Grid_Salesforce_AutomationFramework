package Marlabs.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Marlabs.Core.BaseClass;
import Marlabs.Core.Keywords;
import Marlabs.Core.Testlink;
import Marlabs.Core.WriteToDB;
import Marlabs.Objects.OR;

import com.relevantcodes.extentreports.ExtentTest;

public class TC05_ActiTime_DeleteTask extends BaseClass {

	static Keywords keywords = new Keywords();
	static ArrayList<String> object;
	static OR or = new OR();
	static WebElement element;

	public static void test(WebDriver driver, ExtentTest test,
			String currentTCName) throws Exception {
		String results;
		String data;
		
		try {
			// Task creation
			results = keywords.DeleteProjTask(driver, "", "");
			writeresults(results, driver, "Clicking on Task checkbox", test,
					currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			// click the delete button
			results = keywords.clickLink(driver, "Proj_DeleteBtn", "");
			writeresults(results, driver, "Clicking on  Project delete button",
					test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			// Delete the task
			results = keywords.clickLink(driver, "Proj_TaskDelBtn", "");
			writeresults(results, driver, "Clicking on  Project delete button",
					test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			
			// Success message
			data = getProperty("Proj_DeleteMsg");
			results = keywords.verifyLinkText(driver, "Proj_DeleteSuccMsg", data);
			writeresults(results, driver, "Verify the success message", test,
					currentTCName);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
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
