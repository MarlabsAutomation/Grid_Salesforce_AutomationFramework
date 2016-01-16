package Marlabs.Reports;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Marlabs.Constants.Constants;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {
	
	 static String reportLocation = System.getProperty("user.dir")+"\\src\\Marlabs\\Reports\\Reports\\";
	    static String imageLocation = "images/";
	
	    //This method for Extent report creation of browsers
	public static ExtentReports startReport(WebDriver driver){
				
		String name = null;
		if(driver.toString().contains("internet")){
			name = "IE";
		}
		if(driver.toString().contains("chrome")){
			name = "Chrome";
		}
		if(driver.toString().contains("firefox")){
			name = "Firefox";
		}
		if(driver.toString().contains("safari")){
			name = "Safari";
		}
		ExtentReports extent = new ExtentReports(reportLocation+name+"Report.html", true);
		
		extent.config().documentTitle("Marlabs Automation test execution report");
		
		extent.config().reportHeadline("<b>Marlabs Automation test execution report</b>");
		
		extent.config().reportName(Constants.SelectedSuite+" Report");
				
		return extent;
	}
	 //This method for Extent report creation of mobile
public static ExtentReports MobilestartReport(AppiumDriver driver){
		
		String name = null;		
		
			name = "Mobile";
	
		
		ExtentReports extent = new ExtentReports(reportLocation+name+"Report.html", true);
		
		extent.config().documentTitle("Marlabs Automation test execution report");
		
		extent.config().reportHeadline("<b>Marlabs Automation test execution report</b>");
		
		extent.config().reportName(Constants.SelectedSuite+" Report");
				
		return extent;
	}
	
	//Take scrennshot
	public static String createScreenshot(WebDriver driver) {
	   	 
        UUID uuid = UUID.randomUUID();
     
        // generate screenshot as a file object
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // copy file object to designated location
            FileUtils.copyFile(scrFile, new File(reportLocation + imageLocation + uuid + ".png"));
            
        } catch (Exception e) {
            System.out.println("Error while generating screenshot:\n" + e.toString());
        }
        return reportLocation + imageLocation + uuid + ".png";
    }
}
