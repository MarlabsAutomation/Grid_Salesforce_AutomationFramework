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

public class TC02_ActiTime_UserCreation extends BaseClass{
	
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
			
			//Click the project tab
			results=keywords.clickSelectAllLink(driver, "", "");
			writeresults(results, driver, "Clicking on Task Project select all link", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
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
			//*********************************************
			//Task creation
			results=keywords.clickLink(driver, "UserLink", "");
			writeresults(results, driver, "Clicking on User tab", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Click the user link
			results=keywords.clickLink(driver, "UserPlusBtn", "");
			writeresults(results, driver, "Clicking on User Link", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			Thread.sleep(4000); 
			
			//Fill the user name
			data = getProperty("UserFrstTxt");
			Thread.sleep(500);
			//Enter the user name
			results=keywords.writeInInput(driver, "UserFisrtNameTxtBox", data);
			writeresults(results, driver, "Enter the name", test, currentTCName);
			
			
			//Fill the user last name
			data = getProperty("UserLstTxt");
			Thread.sleep(500);
			//Enter the user name
			results=keywords.writeInInput(driver, "UserLastNameTxtBox", data);
			writeresults(results, driver, "Enter the name", test, currentTCName);			
			
			//Fill the user email name
			data = getProperty("UserEmailTxt");
			Thread.sleep(500);
			//Enter the user name
			results=keywords.writeInInput(driver, "UserMailId", data);
			writeresults(results, driver, "Enter the name", test, currentTCName);
			
			Thread.sleep(500);
			//Enter the user name
			results=keywords.writeInInputUser(driver, "UserNameTxt", "");
			writeresults(results, driver, "Enter the name", test, currentTCName);			
			
			//Fill the password
			data = getProperty("UserPassTxt");
			Thread.sleep(500);
			//Enter the user name
			results=keywords.writeInInput(driver, "UserPassTxt", data);
			writeresults(results, driver, "Enter the Password", test, currentTCName);			
			
			//Fill the password
			data = getProperty("UserPassTxt");
			Thread.sleep(500);
			//Enter the user name
			results=keywords.writeInInput(driver, "UserReTypePass", data);
			writeresults(results, driver, "Enter the Password", test, currentTCName);			
			
			//User  button
			results=keywords.clickLink(driver, "UserButton", "");
			writeresults(results, driver, "Clicking on User button", test, currentTCName);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(5000);
			
			//Verify the user created successfully
			data = getProperty("UserSucMsg");
			results=keywords.verifyLinkText(driver, "User_SuccMsg", data);
			writeresults(results, driver, "Verify the success message", test, currentTCName);	
			Thread.sleep(2000);			
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
