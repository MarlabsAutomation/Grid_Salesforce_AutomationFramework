package Marlabs.Mobile;

import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Marlabs.Core.BaseClass;
import Marlabs.Core.Keywords;
import Marlabs.Core.Testlink;
import Marlabs.Core.WriteToDB;
import Marlabs.Objects.OR;

import com.relevantcodes.extentreports.ExtentTest;

public class Mobilweb_Organisation extends BaseClass
{
	static Keywords keywords = new Keywords();
	static ArrayList<String> object;
	static OR or = new OR();
	static WebElement element;
	
	public static void test(AppiumDriver driver, ExtentTest test,
			String currentTCName) throws Exception {
		System.out.println("Mobileweb login page ");
		String results;
		String data;

		Thread.sleep(3000);
		Set<String> contexts = driver.getContextHandles();
		System.out.println(contexts);
		for(String s:contexts)
		{
			System.out.println(s);
			if(s.contains("NATIVE_APP"))
				//if(s.contains("NATIVE_APP"))
			{
				System.out.println("Mobile Native App view found");
				driver.context(s);

				Thread.sleep(6000);
				System.out.println("Logged in!!!");
				try{
					System.out.println("try1");
					Thread.sleep(6000);
					results=keywords.Mobileclick(driver,"Mobileweb_yespopup","");
					Mobilewriteresults(results, driver, "Clicked on yes  popup button", test, currentTCName);
					System.out.println("try2");
					Thread.sleep(5000);
					results=keywords.Mobileclick(driver,"Mobileweb_Flyoutmenu","");
					Mobilewriteresults(results, driver, "Clicked on Flyoutmenu option", test, currentTCName);
					Thread.sleep(5000);
					results=keywords.Mobileclick(driver,"Mobileweb_organisation","");
					Mobilewriteresults(results, driver, "Clicked on organisation option", test, currentTCName);
					
					results=keywords.Mobileclick(driver,"Mobileweb_organisemenu","");
					Mobilewriteresults(results, driver, "Clicked on organisemenu option", test, currentTCName);
					Thread.sleep(5000);
					results=keywords.Mobileclick(driver,"Mobileweb_organisationname","");
					Mobilewriteresults(results, driver, "Clicked on organisationname option", test, currentTCName);
					
					Thread.sleep(5000);
					data = getProperty("Mobileweb_organisationname");
					results = keywords.MobilewriteInInput(driver, "Mobileweb_organisationname", data);
			        Mobilewriteresults(results, driver, "Enter organisationname", test, currentTCName);
			        
			        data = getProperty("Mobileweb_Description");
					results = keywords.MobilewriteInInput(driver, "Mobileweb_Description", data);
			        Mobilewriteresults(results, driver, "Enter Description", test, currentTCName);
			        
			        data = getProperty("Mobileweb_Phonenumber");
					results = keywords.MobilewriteInInput(driver, "Mobileweb_Phonenumber", data);
			        Mobilewriteresults(results, driver, "Enter Phonenumber", test, currentTCName);
			        
			        data = getProperty("Mobileweb_Address1");
					results = keywords.MobilewriteInInput(driver, "Mobileweb_Address1", data);
			        Mobilewriteresults(results, driver, "Enter Address1", test, currentTCName);
			        
			        data = getProperty("Mobileweb_Address2");
					results = keywords.MobilewriteInInput(driver, "Mobileweb_Address2", data);
			        Mobilewriteresults(results, driver, "Enter Address2", test, currentTCName);
			        
			      data = getProperty("Mobileweb_City");
			  	  results = keywords.MobilewriteInInput(driver, "Mobileweb_City", data);
			  	  Mobilewriteresults(results, driver, "Enter City", test, currentTCName);
			  	 
			        data = getProperty("Mobileweb_Pincode");
				  	results = keywords.MobilewriteInInput(driver, "Mobileweb_Pincode", data);
				  	Mobilewriteresults(results, driver, "Enter Pincode", test, currentTCName);
				  	
				  	results=keywords.Mobileclick(driver,"Mobileweb_State","");
					Mobilewriteresults(results, driver, "Clicked on State option", test, currentTCName);
					
					results=keywords.Mobileclick(driver,"Mobileweb_Statename","");
					Mobilewriteresults(results, driver, "Clicked Statename option", test, currentTCName);
				  	
				    data = getProperty("Mobileweb_EmailId");
				  	results = keywords.MobilewriteInInput(driver, "Mobileweb_EmailId", data);
				  	Mobilewriteresults(results, driver, "Enter EmailId", test, currentTCName); 
			        
				  	data = getProperty("Mobileweb_Mobilenumber");
				  	results = keywords.MobilewriteInInput(driver, "Mobileweb_Mobilenumber", data);
				  	Mobilewriteresults(results, driver, "Enter Mobilenumber", test, currentTCName); 
			        
				  	data = getProperty("Mobileweb_number");
				  	results = keywords.MobilewriteInInput(driver, "Mobileweb_number", data);
				  	Mobilewriteresults(results, driver, "Enter number", test, currentTCName);
				  	
					results=keywords.Mobileclick(driver,"Mobile_fromcal","");
					Mobilewriteresults(results, driver, "Clicked calender option", test, currentTCName);
					
					results=keywords.Mobileclick(driver,"Mobile_fromdate","");
					Mobilewriteresults(results, driver, "Seleted the date ", test, currentTCName);
					
					results=keywords.Mobileclick(driver,"Mobile_tocal","");
					Mobilewriteresults(results, driver, "Clicked calender option", test, currentTCName);
					
					results=keywords.Mobileclick(driver,"Mobile_todate","");
					Mobilewriteresults(results, driver, "Seleted the date ", test, currentTCName);
					
					results=keywords.Mobileclick(driver,"Mobile_organisationsave","");
					Mobilewriteresults(results, driver, "Clicked on save button ", test, currentTCName);
				}

				catch(Exception e)
				{
					WriteToDB.MobileupdateMainResults(driver, currentTCName);
					Testlink.MobileTestFail(currentTCName, "Fail");
					System.out.println("catch");

				}
				 Testlink.MobileTestPass(currentTCName,"Pass");
				 WriteToDB.MobileupdateMainResults(driver, currentTCName);
			}
		}
	}

	
}