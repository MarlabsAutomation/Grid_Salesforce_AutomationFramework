package Marlabs.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import Marlabs.Core.BaseClass;
import Marlabs.Core.Keywords;
import Marlabs.Core.Testlink;
import Marlabs.Core.WriteToDB;
import Marlabs.Objects.OR;

public class TC02_Createleads extends BaseClass{

	static Keywords keywords = new Keywords();
	static ArrayList<String> object; 
	static OR or = new OR();
	static WebElement element;

	public static void test(WebDriver driver, ExtentTest test, String currentTCName) throws Exception{
		String results;
		String data;		

		try {	
			//Leads
			results = keywords.clickLink(driver, "Leads", "");
			writeresults(results, driver, "Clicking on Leads button",
					test, currentTCName);
			Thread.sleep(1000);

			//LeadsHome
			results = keywords.verifyLinkText(driver, "LeadsHome","Home");
			writeresults(results, driver, "Verify Leads Home Text",test, currentTCName);
			Thread.sleep(1000);

			//New
			results = keywords.clickLink(driver, "New", "");
			writeresults(results, driver, "Clicking on New button",
					test, currentTCName);
			Thread.sleep(1000);
			System.out.println("a");

			/* driver.findElement(By.id("name_salutationlea2")).click();
            WebElement aa = driver.findElement(By.id("name_salutationlea2"));
            Select oSelect = new Select(aa); 
            oSelect.selectByValue("Mr.");*/
			//driver.findElement(By.id("name_salutationlea2")).click();
			
		    driver.findElement(By.id("name_firstlea2")).sendKeys("test");
			Thread.sleep(2000);
			results = keywords.selectElementvaluesafari(driver, "Mr", "Mr.");
			writeresults(results, driver, "Selected Mr. option",test, currentTCName);
			Thread.sleep(1000);


			//Fill the Firstname
			data = getProperty("Firstname");
			Thread.sleep(1000);
			results=keywords.writeInInput(driver, "Firstname", data);
			writeresults(results, driver, "Enter the Firstname", test, currentTCName);

			//Enter the LastName
			data = getProperty("LastName");
			Thread.sleep(500);
			results=keywords.writeInInput(driver, "LastName", data);
			writeresults(results, driver, "Enter the Firstname", test, currentTCName);


			//Enter the Company
			data = getProperty("Company");
			Thread.sleep(500);
			results=keywords.writeInInput(driver, "Company", data);
			writeresults(results, driver, "Enter the Company name", test, currentTCName);

			//Enter the Title
			data = getProperty("Title");
			Thread.sleep(500);
			results=keywords.writeInInput(driver, "Title", data);
			writeresults(results, driver, "Enter the Title", test, currentTCName);


			results = keywords.selectElementvalue(driver,"Select_Leadsourse","Web");
			writeresults(results, driver, "Selected Mr. option",test, currentTCName);
			Thread.sleep(1000);


			//Fill the phone_number
			data = getProperty("phone_number");
			Thread.sleep(500);
			//Enter the user name
			results=keywords.writeInInput(driver, "phone_number", data);
			writeresults(results, driver, "Enter the Phone_number", test, currentTCName);

			Thread.sleep(500);
			results = keywords.selectElementvalue(driver, "Select_leadstatus","Working - Contacted");
			writeresults(results, driver, "Selected Working-Contacted option",test, currentTCName);
			Thread.sleep(500);	


			data = getProperty("Email_id");
			Thread.sleep(500);
			results=keywords.writeInInput(driver, "Email_id", data);
			writeresults(results, driver, "Enter the Email_id", test, currentTCName);

			results = keywords.clickLink(driver, "Save_button", "");
			writeresults(results, driver, "Clicking on Save_button",test, currentTCName);
			Thread.sleep(1000);

			results = keywords.verifyAttribute(driver, "edit_btn", "Edit");
			writeresults(results, driver, "Verify Edit button text",test, currentTCName);
			Thread.sleep(1000);

			results = keywords.verifyAttribute(driver, "delete_btn", "Delete");
			writeresults(results, driver, "Verify delete button text",test, currentTCName);
			Thread.sleep(1000);

			results = keywords.verifyAttribute(driver, "clone_btn", "Clone");
			writeresults(results, driver, "Verify clone button text",test, currentTCName);


			results = keywords.verifyAttribute(driver, "convert_btn", "Convert");
			writeresults(results, driver, "Verify convert button text",test, currentTCName);
			Thread.sleep(1000);

			results = keywords.verifyAttribute(driver, "duplicate_btn", "Find Duplicates");
			writeresults(results, driver, "Verify duplicate button text",test, currentTCName);


		}
		catch(Exception e){

			WriteToDB.updateMainResults(driver, currentTCName);
			String Browser1 = WriteToDB.determineBrowser(driver);
			Testlink.Testfail(Browser1,currentTCName, "Fail");
		}

		WriteToDB.updateMainResults(driver, currentTCName);
		String Browser2 = WriteToDB.determineBrowser(driver);
		Testlink.Testpass(Browser2,currentTCName,"Pass");

	}	

}
