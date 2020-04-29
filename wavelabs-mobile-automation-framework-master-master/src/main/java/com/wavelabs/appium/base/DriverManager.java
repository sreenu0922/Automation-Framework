package com.wavelabs.appium.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * The DriverManager is handles the Driver threadsafty while performing the
 * parallel executions
 * 
 * @author Wavelabs_Team
 *
 */
public class DriverManager {

	private static ThreadLocal<AppiumDriver<MobileElement>> appiumDriver = new ThreadLocal<AppiumDriver<MobileElement>>();

	public static AppiumDriver<MobileElement> getDriver() {
		return appiumDriver.get();
	}
	
	public static AndroidDriver<MobileElement> getAndroidDriver() {
		return ((AndroidDriver<MobileElement>) appiumDriver.get());
	}

	public static IOSDriver<MobileElement> getIOSDriver() {
		return ((IOSDriver<MobileElement>) appiumDriver.get());
	}

	public static void setDriver(AppiumDriver<MobileElement> driver) {
		appiumDriver.set(driver);
	}

}
