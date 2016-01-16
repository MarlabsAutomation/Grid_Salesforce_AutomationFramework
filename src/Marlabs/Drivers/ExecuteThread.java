package Marlabs.Drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;

import Marlabs.Constants.Constants;
import Marlabs.Core.BaseClass;


public class ExecuteThread extends BaseClass {

	static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	static ThreadLocal<WebDriver> threadLocal2 = new ThreadLocal<WebDriver>();
	static ThreadLocal<WebDriver> threadLocal3 = new ThreadLocal<WebDriver>();
	
	// Internet Explorer Thread
	public static class MyRunnable implements Runnable {

//		private ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

		public void run() {

			T1.setName("IE");
			try {
				IE();
				// Kill the running driver process
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			} 
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	static MyRunnable sharedRunnableInstance = new MyRunnable();
	static Thread T1 = new Thread(sharedRunnableInstance);
	
	

	// FireFox Thread
	public static class MyRunnable2 implements Runnable {

			public void run() {
			T2.setName("Firefox");
			try {
				Firefox();
				// Kill the running driver process
				Runtime.getRuntime().exec("taskkill /F /IM Firefox.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	static MyRunnable2 sharedRunnableInstance2 = new MyRunnable2();
	static Thread T2 = new Thread(sharedRunnableInstance2);
	
	// Safari Thread
		public static class MyRunnable5 implements Runnable {

			private ThreadLocal<WebDriver> threadLocal5 = new ThreadLocal<WebDriver>();

			public void run() {
				T5.setName("Safari");
				try {
					Safari();
					// Kill the running driver process
					Runtime.getRuntime().exec("taskkill /F /IM Safari.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		static MyRunnable5 sharedRunnableInstance5 = new MyRunnable5();
		static Thread T5 = new Thread(sharedRunnableInstance5);

	// Chrome Thread
	public static class MyRunnable3 implements Runnable {

		private ThreadLocal<WebDriver> threadLocal3 = new ThreadLocal<WebDriver>();

		public void run() {
			T3.setName("Chrome");
			try {

				Chrome();

				// Kill the running driver process
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	static MyRunnable3 sharedRunnableInstance3 = new MyRunnable3();
	static Thread T3 = new Thread(sharedRunnableInstance3);


	public static class MyRunnable4 implements Runnable {

		private ThreadLocal<AppiumDriver> threadLocal4 = new ThreadLocal<AppiumDriver>();

		public void run() {
			T4.setName("Mobile");
			try {

				//Mobile();
				Mobiinitialize();

				// Kill the running driver process
				Runtime.getRuntime().exec("taskkill /F /IM Mobile.exe");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	static MyRunnable4 sharedRunnableInstance4 = new MyRunnable4();
	static Thread T4 = new Thread(sharedRunnableInstance4);
	// -----------------------------------------------------------------------
	// Execute the threads based on the selection.
	public static void execute(String b1, String b2, String b3, String b4, String b5) {
		if ((b1.equalsIgnoreCase("IE")) || (b2.equalsIgnoreCase("IE"))
				|| (b3.equalsIgnoreCase("IE")) || (b4.equalsIgnoreCase("IE"))
				|| (b5.equalsIgnoreCase("IE"))) {
			T1.start();
		}
		if ((b1.equalsIgnoreCase("Firefox"))
				|| (b2.equalsIgnoreCase("Firefox"))
				|| (b3.equalsIgnoreCase("Firefox"))
				|| (b4.equalsIgnoreCase("Firefox"))
				|| (b5.equalsIgnoreCase("Firefox"))) {
			T2.start();
		}
		if ((b1.equalsIgnoreCase("Chrome")) || (b2.equalsIgnoreCase("Chrome"))
				|| (b3.equalsIgnoreCase("Chrome"))
				|| (b4.equalsIgnoreCase("Chrome"))
				|| (b5.equalsIgnoreCase("Chrome"))) {
			T3.start();
		}
		if ((b1.equalsIgnoreCase("Mobile")) || (b2.equalsIgnoreCase("Mobile"))
				|| (b3.equalsIgnoreCase("Mobile"))
				|| (b4.equalsIgnoreCase("Mobile"))
				|| (b5.equalsIgnoreCase("Mobile"))) {
			T4.start();
		}
		if ((b1.equalsIgnoreCase("Safari"))
				|| (b2.equalsIgnoreCase("Safari"))
				|| (b3.equalsIgnoreCase("Safari"))
				|| (b4.equalsIgnoreCase("Safari"))
				|| (b5.equalsIgnoreCase("Safari"))) {
			T5.start();
		}
		

	}

	// Execute the threads based on the selection - Overridden method
	public static void execute(String b1, String b2) {
		if ((b1.equalsIgnoreCase("IE")) || (b2.equalsIgnoreCase("IE"))) {
			T1.start();
		}
		if ((b1.equalsIgnoreCase("Firefox"))
				|| (b2.equalsIgnoreCase("Firefox"))) {
			T2.start();
		}
		if ((b1.equalsIgnoreCase("Chrome")) || (b2.equalsIgnoreCase("Chrome"))) {
			T3.start();
		}			
		if ((b1.equalsIgnoreCase("Safari")) || (b2.equalsIgnoreCase("Safari"))) {
				T5.start();	
		}
	}

	// Execute the threads based on the selection - Overridden method
	public static void execute(String b1) {
		if (b1.equalsIgnoreCase("IE")) {
			T1.start();
		} else if (b1.equalsIgnoreCase("Firefox")) {
			T2.start();
		} else if (b1.equalsIgnoreCase("Chrome")) {
			T3.start();
		} else if (b1.equalsIgnoreCase("Safari")) {
			T5.start();
		}
	}

	// IE driver
	public static WebDriver IE() {

		WebDriver driver = null;
		try {
			System.setProperty("webdriver.ie.driver",
			System.getProperty("user.dir")+ "\\src\\Marlabs\\Drivers\\IEDriverServer.exe");
		/*	DesiredCapabilities ieCapability = DesiredCapabilities.internetExplorer();
		    ieCapability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);*/
			// Create the object for IE
			 System.out.println("Executing on IE");
	         DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	         cap.setBrowserName("ie");
	         String Node ="http://10.150.4.48:5558/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), cap);
	       
			/*
			driver = ThreadGuard.protect(new InternetExplorerDriver(
					ieCapability));*/
			
			threadLocal.set(driver);
			driver = threadLocal.get();
			initialize(driver);
			driver.close();
			System.out.println("This is thread 1: IE ");

		} catch (Exception e) {
			System.out.println("Not able to start the IE driver");
		}
		return driver;
	}

	// Firefox driver
	public static WebDriver Firefox() {

		WebDriver driver = null;
		try {
			
			 System.out.println("Executing on FireFox");
	         String Node = "http://10.150.4.48:5555/wd/hub";
	         DesiredCapabilities cap = DesiredCapabilities.firefox();
	         cap.setBrowserName("firefox");
	         driver = new RemoteWebDriver(new URL(Node), cap);

			//driver = ThreadGuard.protect(new FirefoxDriver());
			
			threadLocal2.set(driver);
			driver = threadLocal2.get();
			
			initialize(driver);
			System.out.println("This is thread 2: Firefox ");

		} catch (Exception e) {
			System.out.println("Not able to start the Firefox driver");
		}
		return driver;
	}
	
	// Safari driver
		public static WebDriver Safari() {

			WebDriver driver = null;
			try {

				driver = ThreadGuard.protect(new SafariDriver());
				initialize(driver);
				driver.close();
				System.out.println("This is thread 4: Safari ");

			} catch (Exception e) {
				System.out.println("Not able to start the Safari driver");
			}
			return driver;
		}

	// Chrome driver
	public static WebDriver Chrome() 
	{

		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver",
            System.getProperty("user.dir")+"\\src\\Marlabs\\Drivers\\chromedriver.exe");

			System.out.println("Executing on CHROME");
	         DesiredCapabilities cap = DesiredCapabilities.chrome();
	         cap.setBrowserName("chrome");
	         String Node = "http://10.150.4.48:5557/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         
	         
	         ///driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Object for chrome browser
			//driver = ThreadGuard.protect(new ChromeDriver());
			
			threadLocal3.set(driver);
			driver = threadLocal3.get();
			
			initialize(driver);
			driver.close();
			System.out.println("This is thread 3: Chrome");

		} catch (Exception e) {
			System.out.println("Not able to start the Chrome driver");
		}
		return driver;
	}

	// Mobile driver
	public static AppiumDriver Mobile() 
	{
		String currentTCName = Constants.MobileFlaggedTCs.get(0);
		System.out.println(currentTCName);
       //String mobile="webapp";
     // String mobile="nativeapp";
		AppiumDriver driver = null;
		try {
     if(currentTCName.contains("MB0"))
{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("device", "Android");
			capabilities.setCapability("VERSION", "5.2.2");
			capabilities.setCapability("deviceName", "Samsung ");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
			 
			//-----------------Icancer health------------
			// capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("app-package",
					"com.iCancerHealth.ICHPatientApp"); // my case
														// com.gorillalogic.monkeytalk.demo1
			capabilities.setCapability("app-activity",
					"com.iCancerHealth.ICHPatientApp.ui.LogoActivityNew"); // my
																			// case
																			// RootActivity
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);
			
			
			/*//-----------------USATODAY sports--------------------
			// This package name of your app (you can get it from apk info app)
			capabilities.setCapability("appPackage", "com.usat.sports");
			// This is Launcher activity of your app (you can get it from apk info app)
			capabilities.setCapability("appActivity","com.usat.sports.ui.SplashActivity"); 
			 //Create RemoteWebDriver instance and connect to the Appium server
		     driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/
			
			//------------------Generic code--------
			
			System.out.println("Launched Native App");
			//System.out.println("abcd" + Constants.MobileFlaggedTCs.size());
			Mobileexecute(driver);
         System.out.println("This is thread 5: Mobile Native App");
         driver.closeApp();
}
else
{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	capabilities.setCapability("VERSION", "5.2.2");
	capabilities.setCapability("deviceName","samsung");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("autoWebview","True");
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	Thread.sleep(1000);
	driver.get("http://cleartouchstage.azurewebsites.net");
	Thread.sleep(10000);
	System.out.println("Launched web App!!");

	Mobileexecute(driver);
	System.out.println("This is thread 5: Mobile Web App");
	driver.closeApp();
}
		}
		catch (Exception e) {
			System.out.println("Not able to start the Mobile driver");
			driver.closeApp();
		}
		return driver;
	}
	
	public static AppiumDriver Mobilepage() 
	{
		String currentTCName = Constants.MobileFlaggedTCs.get(0);
		System.out.println(currentTCName);
         AppiumDriver driver = null;
		try {
if(currentTCName.contains("MB0"))
{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("device", "Android");
			// capabilities.setCapability("BROWSER_NAME", "Android");
			capabilities.setCapability("VERSION", "5.2.2");
			capabilities.setCapability("deviceName", "Samsung ");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
			 
			//-----------------Icancer health------------
			// capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("app-package",
					"com.iCancerHealth.ICHPatientApp"); // my case
														// com.gorillalogic.monkeytalk.demo1
			capabilities.setCapability("app-activity",
					"com.iCancerHealth.ICHPatientApp.ui.LogoActivityNew"); // my
																			// case
																			// RootActivity
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);
			
			
			/*//-----------------USATODAY sports--------------------
			// This package name of your app (you can get it from apk info app)
			capabilities.setCapability("appPackage", "com.usat.sports");
			// This is Launcher activity of your app (you can get it from apk info app)
			capabilities.setCapability("appActivity","com.usat.sports.ui.SplashActivity"); 
			 //Create RemoteWebDriver instance and connect to the Appium server
		     driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/
			
			//------------------Generic code--------
			
			System.out.println("Launched Native App");
			//System.out.println("abcd" + Constants.MobileFlaggedTCs.size());
			mobileexecuteClass(driver);
         System.out.println("This is thread 5: Mobile Native App");
         driver.closeApp();
}
else
{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	capabilities.setCapability("VERSION", "5.2.2");
	capabilities.setCapability("deviceName","samsung");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("autoWebview","True");
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	Thread.sleep(1000);
	driver.get("http://cleartouchstage.azurewebsites.net");
	Thread.sleep(10000);
	System.out.println("Launched web App!!");

	mobileexecuteClass(driver);
	System.out.println("This is thread 5: Mobile Web App");
	driver.closeApp();
}
		}
		catch (Exception e) {
			System.out.println("Not able to start the Mobile driver");
			driver.closeApp();
		}
		return driver;
	}
}
