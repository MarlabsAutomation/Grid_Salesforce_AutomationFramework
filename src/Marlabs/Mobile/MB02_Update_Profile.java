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

public class MB02_Update_Profile extends BaseClass {
	static Keywords keywords = new Keywords();
	static ArrayList<String> object;
	static OR or = new OR();
	static WebElement element;
	
	
	public static void test(AppiumDriver driver, ExtentTest test,
			String currentTCName) throws Exception {
		System.out.println("update profile ");
		String results;
		String data;
		try {
			
			Thread.sleep(8000);
			results=keywords.Mobileclickwait(driver,"Mobile_checkbox","");
			Mobilewriteresults(results, driver, "Clicked on checkbox", test, currentTCName);
	
			results=keywords.Mobileclick(driver,"Mobile_closebutton","");
			Mobilewriteresults(results, driver, "Clicked on closebutton", test, currentTCName);
			
			results=keywords.Mobileclick(driver,"Mobile_Flyoutmenu","");
			Mobilewriteresults(results, driver, "Clicked on Flyoutmenu", test, currentTCName);
			
			data="My profile";
			results=keywords.MobileScrollto(driver,"", data);
			
			results=keywords.Mobileclickwait(driver,"Mobile_dropbox","");
			Mobilewriteresults(results, driver, "Clicked on dropbox", test, currentTCName);
			
			results=keywords.Mobileclick(driver,"Mobile_MR","");
			Mobilewriteresults(results, driver, "Clicked on MR", test, currentTCName);
			
			
			data = getProperty("Mobile_First_Name");
			results = keywords.MobilewriteInInput(driver, "Mobile_First_Name", data);
	        Mobilewriteresults(results, driver, "Enter First_Name", test, currentTCName);
			
	    	data = getProperty("Mobile_Middle_Name");
			results = keywords.MobilewriteInInput(driver, "Mobile_Middle_Name", data);
	        Mobilewriteresults(results, driver, "Enter Middle_Name", test, currentTCName);
	        
	        data = getProperty("Mobile_Last_Name");
			results = keywords.MobilewriteInInput(driver, "Mobile_Last_Name", data);
	        Mobilewriteresults(results, driver, "Enter Last_Name", test, currentTCName);
	        
	        data = getProperty("Mobile_screenname");
			results = keywords.MobilewriteInInput(driver, "Mobile_screenname", data);
	        Mobilewriteresults(results, driver, "Enter screenname", test, currentTCName);
	        
	        results=keywords.Mobileclick(driver,"Mobile_Gender","");
			Mobilewriteresults(results, driver, "Selected gender", test, currentTCName);
			
		/*	data = getProperty("Mobile_weight");
			results = keywords.MobilewriteInInput(driver, "Mobile_weight", data);
	        Mobilewriteresults(results, driver, "Enter weight", test, currentTCName);
	        
	        data = getProperty("Mobile_height_feet");
			results = keywords.MobilewriteInInput(driver, "Mobile_height_feet", data);
	        Mobilewriteresults(results, driver, "Enter height_feet", test, currentTCName);
	        
	        data = getProperty("Mobile_height_inch");
			results = keywords.MobilewriteInInput(driver, "Mobile_height_inch", data);
	        Mobilewriteresults(results, driver, "Enter height_inch", test, currentTCName);*/
	        
	        results=keywords.Mobileclick(driver,"Mobile_martialdropdown","");
			Mobilewriteresults(results, driver, "Selected martialdropdown", test, currentTCName);
			Thread.sleep(3000);
			results=keywords.Mobileclick(driver,"Mobile_martial_single","");
			Mobilewriteresults(results, driver, "Selected Martial_single", test, currentTCName);
			
			results=keywords.Mobileclick(driver,"Mobile_profilesave","");
			Mobilewriteresults(results, driver, "Selected profilesave", test, currentTCName); 
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
