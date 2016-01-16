package Marlabs.Objects;

import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Marlabs.Constants.Constants;
import Marlabs.Core.WriteToDB;

public class OR {
	
	//Get all the objects from the excel and store it in a Multimap map
	public static void storeObjects(){
			
		try{
			
			Constants.Run_date = WriteToDB.getdateTime();
			
			//Initialise the excel reader for Object repository
			Marlabs.Core.Xls_Reader excel = new Marlabs.Core.Xls_Reader(Constants.OR_Path);
			
			//Get the count of OR rows
			int OR_Rowcount = excel.getRowCount(Constants.OR_SheetName);
			
			System.out.println("Row Count"+OR_Rowcount);
			
			for(int i=0; i<OR_Rowcount; i++){
				
				//Get the OR infor from the Excel
				String Name_ide = excel.getCellData("OR", Constants.OR_Identifier, i);
				String LocatorType = excel.getCellData("OR", Constants.OR_LocatorType, i);
				String Locator = excel.getCellData("OR", Constants.OR_Locator, i);
				
				//Store it in Multimap map
				Constants.multiMap.put(Name_ide, LocatorType);
				Constants.multiMap.put(Name_ide, Locator);
				
			}
			System.out.println("Adding OR completed");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
								
		}
	
	//Return the object in an array for the object reference
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getObject(String ORefer){
		
		ArrayList<String> object = null;
		
		try{
		object = (ArrayList<String>) Constants.multiMap.get(ORefer);
		}
		catch (Exception e){
			System.out.println("There is no object by the name: "+ORefer);
		}
		
		return object;
		
	}
	

	//Return the object in an array for the object reference
	@SuppressWarnings("unchecked")
	public static ArrayList<String> mobilegetObject(String ORefer){
		
		ArrayList<String> object = null;
		
		try{
		object = (ArrayList<String>) Constants.multiMap.get(ORefer);
		}
		catch (Exception e){
			System.out.println("There is no object by the name: "+ORefer);
		}
		
		return object;
		
	}
	
	// Fetch the attribute value based on the attribute type
		public static WebElement getObject(WebDriver driver, String attributeType, String locator)
				throws Exception {
						
			try {
				// Based on the "ID"
				if (attributeType.equalsIgnoreCase("id")) {
					return driver.findElement(By.id(locator));
				}
				// Based on the "NAME"
				else if (attributeType.equalsIgnoreCase("name")) {
					return driver.findElement(By.name(locator));
				}
				// Based on the "XPATH"
				else if (attributeType.equalsIgnoreCase("xpath")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					return driver.findElement(By.xpath(locator));
				}
				// Based on the "PARTIALTEXT"
				else if (attributeType.equalsIgnoreCase("partialLinkText")) {
					return driver.findElement(By.partialLinkText(locator));
				}
				// Based on the "CSSSelector"
				else if (attributeType.equalsIgnoreCase("cssSelector")) {
					return driver.findElement(By.cssSelector(locator));
				}
				// Based on the "className"
				else if (attributeType.equalsIgnoreCase("className")) {
					return driver.findElement(By.className(locator));
				}
				// Based on the "TagName"
				else if (attributeType.equalsIgnoreCase("tagName")) {
					return driver.findElement(By.tagName(locator));
				}
				// Based on the "LinkText"
				else if (attributeType.equalsIgnoreCase("linkText")) {
					return driver.findElement(By.linkText(locator));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}	
		public static WebElement mobilegetObject(AppiumDriver driver, String attributeType, String locator)
				throws Exception {
						
			try {
				// Based on the "ID"
				if (attributeType.equalsIgnoreCase("id")) {
					return driver.findElement(By.id(locator));
				}
				// Based on the "NAME"
				else if (attributeType.equalsIgnoreCase("name")) {
					return driver.findElement(By.name(locator));
				}
				// Based on the "XPATH"
				else if (attributeType.equalsIgnoreCase("xpath")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					return driver.findElement(By.xpath(locator));
				}
				// Based on the "PARTIALTEXT"
				else if (attributeType.equalsIgnoreCase("partialLinkText")) {
					return driver.findElement(By.partialLinkText(locator));
				}
				// Based on the "CSSSelector"
				else if (attributeType.equalsIgnoreCase("cssSelector")) {
					return driver.findElement(By.cssSelector(locator));
				}
				// Based on the "className"
				else if (attributeType.equalsIgnoreCase("className")) {
					return driver.findElement(By.className(locator));
				}
				// Based on the "TagName"
				else if (attributeType.equalsIgnoreCase("tagName")) {
					return driver.findElement(By.tagName(locator));
				}
				// Based on the "LinkText"
				else if (attributeType.equalsIgnoreCase("linkText")) {
					return driver.findElement(By.linkText(locator));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}	
}
