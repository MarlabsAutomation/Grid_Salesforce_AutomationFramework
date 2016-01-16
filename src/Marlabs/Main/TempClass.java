package Marlabs.Main;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.webdriven.WebDriverCommandProcessor;

public class TempClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
WebDriver driver = new FirefoxDriver();
driver.get("https://login.salesforce.com/");
Thread.sleep(5000);

driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Delete']")).click();
Thread.sleep(1000);
Alert alrt=driver.switchTo().alert();
alrt.accept();
 Thread.sleep(5000);
		
	}

}
