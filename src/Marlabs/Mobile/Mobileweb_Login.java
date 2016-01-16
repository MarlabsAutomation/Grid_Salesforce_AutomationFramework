package Marlabs.Mobile;

import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import Marlabs.Core.BaseClass;
import Marlabs.Core.Keywords;
import Marlabs.Core.Testlink;
import Marlabs.Core.WriteToDB;
import Marlabs.Objects.OR;

public class Mobileweb_Login extends BaseClass{
	static Keywords keywords = new Keywords();
	static ArrayList<String> object;
	static OR or = new OR();
	static WebElement element;
	
	
	public static void test(AppiumDriver driver, ExtentTest test,
			String currentTCName) throws Exception {
		System.out.println("Mobileweb login page ");
		String results;
		String data;
		try {
			data = getProperty("Mobilewebusername");
			// Enter the user name
			results = keywords.MobilewriteInputnav(driver, "Mobileweb_Username", data);
	        Mobilewriteresults(results, driver, "Enter username", test, currentTCName);
			
			Thread.sleep(500);
			data = getProperty("Mobilewebpassword");
			// Enter the user name
			results = keywords.MobilewriteInputnav(driver, "Mobileweb_password", data);
	        Mobilewriteresults(results, driver,"Enter password", test,currentTCName);
	        Thread.sleep(1500);
			results=keywords.Mobileclick(driver,"Mobileweb_Signin","");
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
