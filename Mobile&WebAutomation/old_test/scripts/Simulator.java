package com.moblie.scripts;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;


public class Simulator {
	
	
	
	public class TestEngine {
		@Test
		public void test1() throws MalformedURLException {
			
			/*
			 WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to("http://www.google.com");
			driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("hello");
			*/
			
			/*
			WebDriver driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to("http://www.google.com");
			driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("hello");
			*/
			
			DesiredCapabilities cap = new DesiredCapabilities();
			/*cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
			cap.setCapability(MobileCapabilityType.APP, "/Users/paramjeetsingh/Documents/Appium/ios-uicatalog-master/UICatalog/build/Release-iphonesimulator/UICatalog.app");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITEST");
			cap.setCapability("useNewWDA", false);
			
			RemoteWebDriver drive = new RemoteWebDriver(new URL("http://127.0.0.0/4723/wd/hub"), cap);
			*/
			
			cap.setCapability("deviceName", "iPhone 6s");
			cap.setCapability("platformName", "iOS");
			cap.setCapability("platformVersion", "12.2");
			//cap.setCapability(CapabilityType.BROWSER_NAME, "Safari");
			cap.setCapability("app", "/Users/paramjeetsingh/Documents/Appium/ios-uicatalog-master/UICatalog/build/Release-iphonesimulator/UICatalog.app");
			cap.setCapability("automationName", "XCUITEST");
			
			URL url = new URL("http://127.0.0.0/4723/wd/hub");
			
			IOSDriver<WebElement> driver = new IOSDriver<WebElement>(url, cap);
			
			driver.get("http://www.google.com");
			
		}

	}

	
	
	
	

}
