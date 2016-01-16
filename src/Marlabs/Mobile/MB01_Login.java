package Marlabs.Mobile;

import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import Marlabs.Core.BaseClass;
import Marlabs.Core.Keywords;
import Marlabs.Core.Testlink;
import Marlabs.Core.WriteToDB;
import Marlabs.Objects.OR;

import com.relevantcodes.extentreports.ExtentTest;

public class MB01_Login extends BaseClass {
	static Keywords keywords = new Keywords();
	static ArrayList<String> object;
	static OR or = new OR();
	static WebElement element;
	
	
	public static void test(AppiumDriver driver, ExtentTest test,
			String currentTCName) throws Exception {
		System.out.println("Native App login  ");
		String results;
		String data;
		try {
			data = getProperty("MobileLogin_Email");
			// Enter the user name
			results = keywords.MobilewriteInputnav(driver, "MobileLogin_Email", data);
	        Mobilewriteresults(results, driver, "Enter username", test, currentTCName);
			
			Thread.sleep(500);
			data = getProperty("MobileLogin_Pass");
			// Enter the user name
			results = keywords.MobilewriteInputnav(driver, "MobileLogin_Pass", data);
	        Mobilewriteresults(results, driver,"Enter password", test,currentTCName);
	        
	        Thread.sleep(1500);
			results=keywords.Mobileclick(driver,"MobileLogin_SigIn","");
			Mobilewriteresults(results, driver, "Clicked on signin button", test, currentTCName);
	
		} 
		catch (Exception e) 
		{
		WriteToDB.MobileupdateMainResults(driver, currentTCName);
		Testlink.MobileTestFail(currentTCName, "Fail");
		}
		 Testlink.MobileTestPass(currentTCName,"Pass");
		 WriteToDB.MobileupdateMainResults(driver, currentTCName);
	}
}
