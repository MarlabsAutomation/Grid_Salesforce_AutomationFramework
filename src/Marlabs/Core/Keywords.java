package Marlabs.Core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchableElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.BrowserLauncher;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import Marlabs.Constants.Constants;
import Marlabs.Objects.OR;


/**
 * @author Selenium
 * This is method use to declare all the webdriver methodes
 */
public class Keywords extends BaseClass {

	// Navigate to any page
	public String navigate(WebDriver driver, WebElement element, String data)
			throws Exception {
		driver.navigate().to(data);
		return Constants.KEYWORD_PASS;
	}

	// Click on the link
	public String clickLink(WebDriver driver, String objRef, String data)
			throws Exception {
		String browserName = WriteToDB.determineBrowser(driver);
		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = object(objRef, driver);			
			WebDriverWait wait2 = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = object(objRef, driver);
			// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			WebDriverWait wait2 = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			((JavascriptExecutor) driver).executeScript("arguments[0].focus();",
					element);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					element);
		}		
		//element.click();
		Thread.sleep(4000);
		return Constants.KEYWORD_PASS;
	}

	public String clickSelectAllLink(WebDriver driver, String objRef, String data)
			throws Exception {
		String browserName = WriteToDB.determineBrowser(driver);
		//This condition for safari browser
		Thread.sleep(1000);
		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			boolean ss = driver.findElements(By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr[1]/th[6]/table/tbody/tr/td[1]/a")).size() > 0;
			if (ss== true) {
				System.out.println("Customer product displayed");			
				driver.findElement(By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr[1]/th[6]/table/tbody/tr/td[1]/a")).click();

			}
		}else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			WebDriverWait wait2 = new WebDriverWait(driver, 30);
			boolean ss1 = driver.findElements(By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr[1]/th[6]/table/tbody/tr/td[1]/a")).size() > 0;
			if (ss1== true) {
				System.out.println("Customer product displayed");
				WebElement selectall = driver.findElement(By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr[1]/th[6]/table/tbody/tr/td[1]/a"));
				//driver.findElement(By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr[1]/th[6]/table/tbody/tr/td[1]/a")).click();
				((JavascriptExecutor) driver).executeScript("arguments[0].focus();",
						selectall);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						selectall);
			}		
		}
		Thread.sleep(1000);

		return Constants.KEYWORD_PASS;
	}

	//Wait for the element displayed
	public static void WaitElementDisplayed(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.isDisplayed();
	}

	// Verify the Link text
	public String verifyLinkText(WebDriver driver, String objRef, String data)
			throws Exception {
		String browserName = WriteToDB.determineBrowser(driver);
		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = object(objRef, driver);
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		String actual = element.getText();
		String expected = data;
		Thread.sleep(1000);
		if (actual.contains(expected)) {
			return Constants.KEYWORD_PASS;
		} else {
			return Constants.KEYWORD_FAIL + "--The link text in not matching";
		}

	}

	// For user creation
	// Write the input to text box
	public String writeInInputUser(WebDriver driver, String objRef, String data)
			throws Exception {
		String browserName = WriteToDB.determineBrowser(driver);
		//For internet explorer
		UUID ID = UUID.randomUUID();
		String StrCustID_IE = ID.toString();
		//For Chrome
		UUID ID2 = UUID.randomUUID();
		String StrCustID_Chrome = ID2.toString();
		//For Safari
		UUID ID3 = UUID.randomUUID();
		String StrCustID_Safari = ID3.toString();
		//For FF
		UUID ID4 = UUID.randomUUID();
		String StrCustID_FF = ID4.toString();

		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement element = object(objRef, driver);
			String ss = element.getAttribute("id");
			element.clear();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById(\"" + ss
					+ "\").value=\"" + StrCustID_Safari + "\"");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
		} else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			WebElement element = object(objRef, driver);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(1000);			
			if (browserName.equalsIgnoreCase("IE")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				element.clear();
				element.sendKeys(StrCustID_IE);
			}
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				element.clear();
				element.sendKeys(StrCustID_Chrome);
			}
			if (browserName.equalsIgnoreCase("FE")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				element.clear();
				element.sendKeys(StrCustID_FF);
			}
		}
		return Constants.KEYWORD_PASS;
	}

	// Write the input to text box
	public String writeInInputCustomer(WebDriver driver, String objRef,
			String data) throws Exception {		
		String browserName = WriteToDB.determineBrowser(driver);
		Thread.sleep(1000);
		//This condition for safari browser
		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement element = object(objRef, driver);
			element.clear();
			String ss = element.getAttribute("id");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById(\"" + ss
					+ "\").value=\"" + CustomerID_SAF + "\"");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
		} else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		WebElement element = object(objRef, driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		//This condition for IE browser
		if (browserName.equalsIgnoreCase("IE")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			element.clear();
			element.sendKeys(CustomerID_IE);
		}
		//This condition for Chrome browser
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			element.clear();
			element.sendKeys(CustomerID_CH);
		}
		//This condition for FE browser
		if (browserName.equalsIgnoreCase("FE")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			element.clear();
			element.sendKeys(CustomerID_FF);
		}
		return Constants.KEYWORD_PASS;
	}

	// Write the input to text box
	public String writeInInputProject(WebDriver driver, String objRef,
			String data) throws Exception {
		Thread.sleep(3000);		
		String browserName = WriteToDB.determineBrowser(driver);		
		//This condition for safari browser
		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement element = object(objRef, driver);
			element.clear();
			String ss = element.getAttribute("id");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById(\"" + ss
					+ "\").value=\"" + ProjectID_SAF + "\"");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
		} else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		// ProjectID = StrCustID;
		WebElement element = object(objRef, driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		//This condition for IE browser
		if (browserName.equalsIgnoreCase("IE")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			element.clear();
			element.sendKeys(ProjectID_IE);
			Thread.sleep(1000);
		}
		//This condition for Chrome browser
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			element.clear();
			element.sendKeys(ProjectID_CH);
			Thread.sleep(1000);
		}
		//This condition for FireFox browser
		if (browserName.equalsIgnoreCase("FE")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			element.clear();
			element.sendKeys(ProjectID_FF);
			Thread.sleep(1000);
		}
		return Constants.KEYWORD_PASS;
	}

	// Clicking on the button
	public String clickButton(WebDriver driver, String objRef, String data)
			throws Exception {
		String browserName = WriteToDB.determineBrowser(driver);
		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		// Declare the web element
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = object(objRef, driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		// Click the button
		element.click();
		return Constants.KEYWORD_PASS;
	}

	// Verify the text of the button
	public String verifyButtonText(WebDriver driver, String objRef, String data)
			throws Exception

	{
		WebElement element = object(objRef, driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		String actual = element.getText();
		String expected = data;
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		if (actual.equals(expected)) {
			return Constants.KEYWORD_PASS;
		} else {
			return Constants.KEYWORD_FAIL + "--The button name is not matching";
		}
	}

	/** Write the input to text box
	 * @param driver
	 * @param objRef webelement address
	 * @param data 
	 * @return pass/fail result
	 * @throws Exception
	 */
	public String writeInInput(WebDriver driver, String objRef, String data)
			throws Exception {
		Thread.sleep(2000);
		String browserName = WriteToDB.determineBrowser(driver);
		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement element = object(objRef, driver);
			element.clear();
			String ss = element.getAttribute("id");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById(\"" + ss
					+ "\").value=\"" + data + "\"");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
		} else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = object(objRef, driver);
			Thread.sleep(1000);
			WebDriverWait wait2 = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(1000);
			element.clear();
			element.sendKeys(data);
		}
		return Constants.KEYWORD_PASS;
	}

	/** Write the input to text box
	 * @param driver
	 * @param objRef webelemnet address
	 * @param data 
	 * @return pass/fail result
	 * @throws Exception
	 */
	public String writeInInputByCssSelector(WebDriver driver, String objRef,
			String data) throws Exception {
		String browserName = WriteToDB.determineBrowser(driver);
		if (browserName.equalsIgnoreCase("Safari")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// WebElement element = object1(iWebElementId, driver);
			String ss = object1(objRef, driver);	

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.querySelector(\"" + ss + "\").value=\""
					+ data + "\"");
			Thread.sleep(1000);
		} else {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = object("Password", driver);
			Thread.sleep(1000);
			WebDriverWait wait2 = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(1000);
			element.clear();
			element.sendKeys(data);
		}
		return Constants.KEYWORD_PASS;
	}

	// Selecting amount for Gift
	// Write the input to text box
	public String selectAmount(WebDriver driver, String objRef, String data)
			throws Exception {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		WebElement element = object(objRef, driver);

		if (element.isDisplayed()) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(1000);
			element.sendKeys(data);
		}
		else {
			WebElement element1 = driver.findElement(By
					.cssSelector("#a-autoid-17-announce"));
			element1.click();
		}
		return Constants.KEYWORD_PASS;
	}

	// Enter amount

	// Write the input to text box
	public String enterAmount(WebDriver driver, String objRef, String data)
			throws Exception {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement element = object(objRef, driver);
		if (element.isDisplayed()) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(1000);
			element.sendKeys(data);
		} else
		{
			WebElement element1 = driver.findElement(By
					.cssSelector("#gc-order-form-custom-amount"));
			element1.sendKeys(data);
		}
		return Constants.KEYWORD_PASS;
	}

	// Write the input to text box
	public String enterEmail(WebDriver driver, String objRef, String data)
			throws Exception {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement element = object(objRef, driver);

		if (element.isDisplayed()) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(1000);
			element.sendKeys(data);
		} else {
			WebElement element1 = driver.findElement(By
					.cssSelector("#gc-order-form-recipients-0"));
			element1.sendKeys(data);
		}
		return Constants.KEYWORD_PASS;
	}

	// Fill the sender email details
	public String enterSenderEmail(WebDriver driver, String objRef, String data)
			throws Exception {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement element = object(objRef, driver);
		if (element.isDisplayed()) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(1000);
			element.sendKeys(data);
		} else {
			WebElement element1 = driver.findElement(By
					.cssSelector("#gc-order-form-senderName"));
			element1.sendKeys(data);
		}
		return Constants.KEYWORD_PASS;
	}

	// Fill the Message details
	public String enterMessage(WebDriver driver, String objRef, String data)
			throws Exception {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement element = object(objRef, driver);

		if (element.isDisplayed()) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(1000);
			element.sendKeys(data);
		} else {
			WebElement element1 = driver.findElement(By.cssSelector("#gc-order-form-message"));
			element1.sendKeys(data);
		}
		return Constants.KEYWORD_PASS;
	}

	// Verify the text inputed is correctly entered
	public String verifyTextinInput(WebDriver driver, String objRef, String data)
			throws Exception {
		WebElement element = object(objRef, driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

		waitforElemnt();
		String actual = element.getAttribute("value");
		String expected = data;

		if (actual.equals(expected)) {
			return Constants.KEYWORD_PASS;
		} else {
			return Constants.KEYWORD_FAIL + "--Not matching";
		}
	}

	// Verify the text of the element
	public String verifyText(WebDriver driver, String objRef, String data)
			throws Exception {
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		WebElement element = object(objRef, driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		waitForLoad(driver);

		String actual = element.getText();
		System.out.println("actual: "+actual);
		String expected = data;

		if (actual.contains(data)) {
			return Constants.KEYWORD_PASS;
		} else 
		{
			return Constants.KEYWORD_FAIL + "--The text is not matching";
		}
	}

	// Verify the text of the element
		public String verifyAttribute(WebDriver driver, String objRef, String data)
				throws Exception {
			
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			WebElement element = object(objRef, driver);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			waitForLoad(driver);

			String actual = element.getAttribute("value").trim();
			String expected = data;

			if (actual.contains(expected)) {
				return Constants.KEYWORD_PASS;
			} else {
				return Constants.KEYWORD_FAIL + "--The text is not matching";
			}
		}

	
	// Verify the title of the page
	public String verifyTitle(WebDriver driver, String objRef, String data)
			throws Exception {

		Thread.sleep(3000);
		waitForLoad(driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = data;

		if (actual.contains(expected)) {
			return Constants.KEYWORD_PASS;
		} else {
			return Constants.KEYWORD_FAIL + "--The Title is not matching";
		}
	}
	//Verify the page title displayed
	public String VerifyThePageTitle(WebDriver driver, String data)
			throws Exception {
		Thread.sleep(2000);
		waitForLoad(driver);
		String actual = driver.getTitle();
		String expected = data;

		if (actual.contains(expected)) {
			return Constants.KEYWORD_PASS;
		} else {
			return Constants.KEYWORD_FAIL + "--The Title is not matching";
		}
	}

	// Mouse over on the element
	public String mouseOver(WebDriver driver, String objRef, String data)
			throws Exception {
		WebElement element = object(objRef, driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return Constants.KEYWORD_PASS;
	}

	// Select the element By text
	public String selectElement(WebDriver driver, String objRef, String data)
			throws Exception {
		WebElement element = object(objRef, driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));

		Select sl = new Select(element);
		sl.selectByVisibleText(data);
	
		return Constants.KEYWORD_PASS;
	}

	// Select the element By value
	public String selectElementvalue(WebDriver driver, String objRef,
			String data) throws Exception {
		WebElement element = object(objRef, driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));

		Select sl = new Select(element);
		sl.selectByValue(data);
		return Constants.KEYWORD_PASS;
	}

	
	// Select the element By valuesafari
		public String selectElementvaluesafari(WebDriver driver, String objRef,
				String data) throws Exception {
			
			driver.findElement(By.id(objRef)).click();
			 WebElement aa = driver.findElement(By.id(objRef));
	            
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		

			Select oSelect = new Select(aa); 
            oSelect.selectByValue(data);
			return Constants.KEYWORD_PASS;
		}
	// Select the element By index
	public String selectElementIndex(WebDriver driver, String objRef, int data)
			throws Exception {
		WebElement element = object(objRef, driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));

		Select sl = new Select(element);
		sl.selectByIndex(data);
		return Constants.KEYWORD_PASS;
	}

	public String Deleteleads(WebDriver driver, String objRef, String data)
			throws Exception {
          Thread.sleep(5000);
		
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Delete']")).click();
		Alert alrt=driver.switchTo().alert();
		alrt.accept();
		 Thread.sleep(5000);
				return Constants.KEYWORD_PASS;
	}
	// Click on the element
	public String clickElement(WebDriver driver, String objRef, String data)
			throws Exception {
		WebElement element = object(objRef, driver);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		if (((JavascriptExecutor) driver).executeScript(
				"return document.readyState").equals("complete")) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		return Constants.KEYWORD_PASS;
	}

	// Click on the element
	public String clickElementwt(WebDriver driver, String objRef, String data)
			throws Exception {
		Thread.sleep(5000);
		WebElement element = object(objRef, driver);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		if (((JavascriptExecutor) driver).executeScript(
				"return document.readyState").equals("complete")) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		return Constants.KEYWORD_PASS;
	}

	// Click on element using java script executor
	public String clickElement_JS(WebDriver driver, String objRef, String data)
			throws Exception {
		WebElement element = object(objRef, driver);
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));

		((JavascriptExecutor) driver).executeScript("arguments[0].focus();",
				element);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				element);
		return Constants.KEYWORD_PASS;
	}

	// Wait for the element:thread.sleep
	public String waitforElemnt() throws InterruptedException {
		Thread.sleep(5000);
		return Constants.KEYWORD_PASS;
	}

	// Wait for page to load
	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	// Verify the element is displayed
	public String elementdispayed(WebDriver driver, String objRef, String data)
			throws Exception {
	
		WebElement element = object(data, driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		if(element.isDisplayed())
		{
			return Constants.KEYWORD_FAIL;
		}
		else{
			System.out.println("not displayed");
		}
		
		return Constants.KEYWORD_PASS;
	}

	// Verify the element is displayed
		public String elementdispayed1(WebDriver driver, String objRef, String data)
				throws Exception {
		
			WebElement element = object(data, driver);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed())
			{
				return Constants.KEYWORD_PASS;
				
			}
			else{
				System.out.println("not displayed");
			}
			return Constants.KEYWORD_FAIL;
			
		}
			
		
		
	// Navigate to previous page or to close the virtual keypad in mobile
	// screen.
	public String Pressback(WebDriver driver, WebElement element, String data)
			throws Exception {
		driver.navigate().back();
		return Constants.KEYWORD_PASS;
	}

	// handle the alert window by selecting ok or cancel button
	public String alert(WebDriver driver,String objRef, String data)
			throws Exception {
	//	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//WebElement element = object(objRef, driver);
		//Alert alrt = driver.switchTo().alert();
		 System.out.println("Inside");
      Thread.sleep(6000);
   
			//String alrtMsg = alrt.getText();
		Alert alrt=driver.switchTo().alert();
			alrt.accept();
			return Constants.KEYWORD_PASS;
			//System.out.println("clicked ok on " + alrtMsg);
	
		
		/*else if (data.equals("cancel")) {
			//String alrtMsg = alrt.getText();
			Alert alrt1 = driver.switchTo().alert();
			alrt1.dismiss();
			//System.out.println("clicked cancel on " + alrtMsg);
		}*/
		

	}

	// Scroll to bottom of the web page
	public String Pagescroll(WebDriver driver, String objRef, String data)
			throws Exception {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		WebElement element = object(objRef, driver);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.HOME).perform();
		return Constants.KEYWORD_PASS;
	}

	// Switch to child window
	public String SwitchToChildWindow(WebDriver driver, String objRef,
			String data) throws Exception {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		System.out.println("Inside");

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Switch to window" + winHandleBefore);
		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(20000);
		return Constants.KEYWORD_PASS;
	}

	// Switch to child window
	public String SwitchToparentWindow(WebDriver driver, WebElement element,
			String data) throws Exception {
		Set<String> list = driver.getWindowHandles();
		Iterator<String> it = list.iterator();
		String parent = it.next();
		System.out.println("parent " + parent);
		String child = it.next();
		System.out.println("child " + child);
		driver.switchTo().window(parent);
		return Constants.KEYWORD_PASS;
	}

	// Object method
	public WebElement object(String objRef, WebDriver driver) throws Exception {
		WebElement element;

		ArrayList<String> object = OR.getObject(objRef);

		return element = OR.getObject(driver, object.get(0), object.get(1));

	}

	// Object method
	public String object1(String objRef, WebDriver driver) throws Exception {

		ArrayList<String> object = OR.getObject(objRef);

		return object.get(1);

	}
	// Mobile Object method
	public WebElement mobileobject(String objRef, AppiumDriver driver) throws Exception {
		WebElement element;

		ArrayList<String> object = OR.mobilegetObject(objRef);

		return element = OR.mobilegetObject(driver, object.get(0), object.get(1));

	}

	

	// Write the input to mobile text box
	public String MobilewriteInInput(AppiumDriver driver, String objRef,String data) throws Exception {
		WebElement element = mobileobject(objRef, driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		// System.out.println(element + "::::"+ data);
		element.sendKeys(data);
		Thread.sleep(500); //commented by Siva on 10/20
		driver.navigate().back();
		return Constants.KEYWORD_PASS;
	}

	public String MobilewriteInputnav(AppiumDriver driver, String objRef,String data) throws Exception {
		WebElement element = mobileobject(objRef, driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		// System.out.println(element + "::::"+ data);
		element.sendKeys(data);
		return Constants.KEYWORD_PASS;
	}
	// Clicking on the button
	public String Mobileclick(AppiumDriver driver, String objRef, String data)
			throws Exception {
		WebElement element = mobileobject(objRef, driver);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		return Constants.KEYWORD_PASS;
	}

	// Click on the element
	public String ClickAndNavigateBack(WebDriver driver, String objRef,
			String data) throws Exception {
		Thread.sleep(5000);
		WebElement element = object(objRef, driver);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		if (((JavascriptExecutor) driver).executeScript(
				"return document.readyState").equals("complete")) {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Thread.sleep(2000);
			driver.navigate().to(data);
		}
		return Constants.KEYWORD_PASS;
	}



	// Click on proceed link
	public String clickProceed(WebDriver driver, String objRef, String data)
			throws Exception {
		Thread.sleep(5000);
		WebElement element = object(objRef, driver);

		if (element.isDisplayed()) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} else {
			WebElement element1 = driver
					.findElement(By
							.cssSelector("#gc-mini-cart-proceed-to-checkout > span > input"));
			element1.click();
		}
		return Constants.KEYWORD_PASS;
	}

	// Scroll on the element
	public String MobileScrollto(AppiumDriver driver, String objRef, String data)
			throws Exception {
		WebElement element = object(objRef, driver);

		driver.scrollTo(data).click();
		return Constants.KEYWORD_PASS;
		
	}

	// Clicking on the Mobile click button
	public String Mobileclickwait(AppiumDriver driver, String objRef,
			String data) throws Exception {
		Thread.sleep(3000); //changed from 10sec - Siva
		WebElement element = object(objRef, driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		return Constants.KEYWORD_PASS;
	}

	//----Usa today
	
	public String Wait(AppiumDriver driver, String objRef,
			String data) throws InterruptedException{
		
		int num = Integer.parseInt(data);
		Thread.sleep(num);
				
		return Constants.KEYWORD_PASS;
	}
	public String Waitweb(WebDriver driver, String objRef,
			String data) throws InterruptedException{
		
		int num = Integer.parseInt(data);
		Thread.sleep(num);
				
		return Constants.KEYWORD_PASS;
	}
	
	public String GetText(AppiumDriver driver, String objRef,
			String data) throws Exception {
		String text = "";
		
//		WaitforElement(locator, time);
		WebElement element = object(objRef, driver);
		text = element.getText();
		
		return Constants.KEYWORD_PASS;
	}
	
	public String clickOnElement(AppiumDriver driver, String objRef,
			String data) throws Exception {
	

		WebElement element = object(objRef, driver);
		element.click();
			//System.out.println("Click on element");
		
		return Constants.KEYWORD_PASS;
	}
	
	
	//----ends

	//Select the customer
	public String SelectProjectDropDown(WebDriver driver, String obj,
			String data) throws Exception {
		Thread.sleep(3000);
		// WebElement element = object(totalobjRef, driver);
		String browserName = WriteToDB.determineBrowser(driver);
		List<WebElement> allElements = driver
				.findElements(By
						.xpath("//div[contains(@class, 'at-dropdown-list-btn-menu')]/ul/li"));
		// List <WebElement> allElements = element.getSize();
		// Looping
		for (WebElement element2 : allElements) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//For the Internet explorer
			if (browserName.equalsIgnoreCase("IE")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
				if (element2.getText().equals(CustomerID_IE)) {
					System.out.println(element2.getText() + "found match");
					element2.click();
					break;
				}
			}
			//For the chrome browser
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
				if (element2.getText().equals(CustomerID_CH)) {
					System.out.println(element2.getText() + "found match");
					element2.click();
					break;
				}
			}
			//For the FireFox browser
			if (browserName.equalsIgnoreCase("FE")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
				if (element2.getText().equals(CustomerID_FF)) {
					System.out.println(element2.getText() + "found match");
					element2.click();
					break;
				}
			}		
			//For the FireFox browser
			if (browserName.equalsIgnoreCase("Safari")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
				if (element2.getText().equals(CustomerID_SAF)) {
					System.out.println(element2.getText() + "found match");
					element2.click();
					break;
				}
			}			
		}
		return Constants.KEYWORD_PASS;
	}

	//Delete the project name
	public String DeleteProjTask(WebDriver driver, String obj, String data)
			throws Exception {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String browserName = WriteToDB.determineBrowser(driver);
		int totalProjCount = driver
				.findElements(
						By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr"))
						.size();
		// Used for loop for number of rows.
		for (int i = 2; i <= totalProjCount; i++) {
			String value3 = driver
					.findElement(
							By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr["
									+ i + "]/td/table/tbody/tr/td")).getText();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//For safari browser
			if (browserName.equalsIgnoreCase("Safari")) {
				if (value3.contains(ProjectID_SAF)) {
					driver.findElement(
							By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr["
									+ i + "]/td[6]/input")).click();
					Thread.sleep(1000);
					break;
				}
			}
			//For Internet Explorer browser
			if (browserName.equalsIgnoreCase("IE")) {
				if (value3.contains(ProjectID_IE)) {
					driver.findElement(
							By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr["
									+ i + "]/td[6]/input")).click();
					Thread.sleep(1000);
					break;
				}
			}
			//For Chrome browser
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.out.println("tt");
				if (value3.contains(ProjectID_CH)) {
					driver.findElement(
							By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr["
									+ i + "]/td[6]/input")).click();
					Thread.sleep(1000);
					break;
				}
			}
			//For Chrome browser
			if (browserName.equalsIgnoreCase("FE")) {
				if (value3.contains(ProjectID_FF)) {
					driver.findElement(
							By.xpath(".//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr["
									+ i + "]/td[6]/input")).click();
					Thread.sleep(1000);
					break;
				}
			}

		}
		return Constants.KEYWORD_PASS;
	}

	// Click on proceed link
		public String cloneleads(WebDriver driver, String objRef, String data)
				throws Exception {
			Thread.sleep(5000);
			List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'bPageBlock brandSecondaryBrd secondaryPalette')]//div//tbody//td//a"));    
   int leads=elements.size();
			if (leads>=2) {
				
			} 
			else {
				
			}
			return Constants.KEYWORD_PASS;
		}

			
	
	


}
