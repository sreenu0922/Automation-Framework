package accelerators;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Reporter;
import support.Logger;

public class ActionEngine extends TestEngine{
	
	
	public static boolean flag = false;
	static boolean b = true;
	
	/*
	
	example -- Click
	*/
	@SuppressWarnings("finally")
	public static boolean click(By locator, String locatorName)
			throws Throwable {
		//explicityWait(locator, locatorName);
		boolean flag = false;
		try {
			driver.findElement(locator).click();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				Reporter.failureReport("Click", "Unable to click on "
						+ locatorName);
				return flag;
			} else if (b && flag) {
				Reporter.SuccessReport("Click", "Successfully click on "
						+ locatorName);
				
		}
		return flag;
	}
	 
	/* 
	 * 
	 * 
	 * 
	 * 
	 * use ActionClass
	 * 
	Tab(By Locator) AND Tab(using coordinates) -- Vinay
	LongpressTab (By Locator)AND (using Coordinates  -- Vinay
	DoubleTab -- Jagadishwar
	ScrollToElement -- Jagadishwar
	Swipe up -- Srinivas N
	Swipe down -- Srinivas N
	Swipe left -- Srinivas N
	Swipe Right -- Srinivas N
	sendKey -- Ranga
	isElementDisplay -- Pravalika
	WaitforElement -- Bhavya
	draganddrop --Pravalika
	switchWindowByTitle --Sangeetha
	clikcOnAlert -- Sangeetha
	*/

}
	//waitforelement code by Bhavya
	
	public  static void  waitForMobileElement( By element, long duration , WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		
        try {
        	new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            System.out.println("Unable to find the element " + element);
           
        }
    }




public static void screenShot(String fileName) throws Throwable {
	File scrFile = ((TakesScreenshot) driver)
			.getScreenshotAs(OutputType.FILE);
	try {
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		FileUtils.copyFile(scrFile, new File(fileName));
		flag=true;
	} catch (IOException e) {
		//Assert.assertTrue(flag,"Unable to take Screenshot");
		e.printStackTrace();
	}finally {
		if (!flag) {
			//Reporter.failureReport("screenShot ", " Unable to get screenShot ");
			System.out.println(" Unable to get TscreenShot");
		} else if (b && flag) {
			//Reporter.SuccessReport("screenShot ", " Able to get TscreenShot");
			System.out.println(" Able to get TscreenShot");
		}
	}
}



public static void fullScreenShot(String fileName) throws Exception {
	 
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Rectangle screenRectangle = new Rectangle(screenSize);
	   Robot robot = new Robot();
	   BufferedImage image = robot.createScreenCapture(screenRectangle);
	   ImageIO.write(image, "jpeg", new File(fileName));
	 
	}


}
