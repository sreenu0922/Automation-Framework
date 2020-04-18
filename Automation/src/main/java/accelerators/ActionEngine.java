package accelerators;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.Reporter;

import javax.imageio.ImageIO;
import java.awt.Dimension;

import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import rough.SecondClass.DIRECTION;
import support.Reporter;


public class ActionEngine extends TestEngine{

	public static boolean flag = false;
	public static WebDriverWait wait;
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
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*if (!flag) {
				Reporter.failureReport("Click", "Unable to click on "
						+ locatorName);
				return flag;
			} else if (b && flag) {
				Reporter.SuccessReport("Click", "Successfully click on "
						+ locatorName);

			}
*/        return flag;
		}
	}

	//@author:Archana Dasari
	public static boolean waitForElementPresent(By by, String locator)
			throws Throwable {

		try {
			wait = new WebDriverWait(driver, 800);
			WebElement element = null;
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			boolean enabled = element.getSize().getHeight() > 0;
			if (enabled) {
				flag = true;
			} else {
				driver.wait(50);
			}
		} catch (Exception e) {

			Assert.assertTrue(flag, "waitForElementPresent : Falied to locate element " + locator);

			e.printStackTrace();

			return flag;
		} finally {
			/*if (!flag) {
				Reporter.failureReport("WaitForElementPresent ",
						"Falied to locate element " + locator);
			} else if (b && flag) {
				Reporter.SuccessReport("WaitForElementPresent ",
						"Successfully located element " + locator);
			}*/
		}
		return flag;

	}

	//@author:Archana Dasari
	public static boolean type(By locator, String testdata, String locatorName) throws Throwable {
		explicityWait(locator, locatorName);
		try {
			WebElement we = driver.findElement(locator);
			we.clear();
			we.sendKeys(testdata);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		} finally {
			/*if (!flag) {
				Reporter.failureReport("Type ",
						"Data typing action is not perform on " + locatorName
								+ " with data is " + testdata);
			} else if (b && flag) {
				Reporter.SuccessReport("Type ",
						"Data typing action is performed on " + locatorName
								+ " with data is " + testdata);
			}*/
		}
		return flag;
	}
	//@author:Archana Dasari
	public static void explicityWait(By Locator, String locatorName) throws InterruptedException {
		WebDriverWait wdw = new WebDriverWait(driver, 180);
		WebElement ele = null;
		ele = wdw.until(ExpectedConditions.elementToBeClickable(Locator));
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
	
	/*@author sangeethanulu
	 
	  SWITCH TO WINDOW BY TITLE
	 */
	
	public static boolean switchWindowByTitle(String windowTitle, int count)
			throws Throwable {
		boolean flag = false;
		try {
			Set<String> s=driver.getWindowHandles();
			if(s.size()>1)
			{
				driver.switchTo().window(windowTitle);	
				flag = true;
			}
	
			
		} catch (Exception e) {
      
	//waitforelement code by Bhavya
	
	public  static void  waitForMobileElement( By element, long duration , WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		
        try {
        	new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            System.out.println("Unable to find the element " + element);
           
        }
    }

			} 
	return flag;
	}
	
	/**
	 * @author sangeethan
	 * Verify alert present or not 
	 * 
	 */
	public static boolean Alert(String par) throws Throwable {
		boolean flag = false;
		
		Alert alert = driver.switchTo().alert();

		try {
             
			if(par.equalsIgnoreCase("accept"))
			{
			
			// if present consume the alert
			alert.accept();
			flag = true;
			}
			else if(par.equalsIgnoreCase("dismiss"))
			{
				//
				alert.dismiss();
				flag = true;
			}
			
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} 

		return flag;
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
		/*if (!flag) {
			//Reporter.failureReport("screenShot ", " Unable to get screenShot ");
			System.out.println(" Unable to get TscreenShot");
		} else if (b && flag) {
			//Reporter.SuccessReport("screenShot ", " Able to get TscreenShot");
			System.out.println(" Able to get TscreenShot");
		}*/
	}
   }

   public static void fullScreenShot(String fileName) throws Exception {

    public static void fullScreenShot(String fileName) throws Exception {
	 
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Rectangle screenRectangle = new Rectangle(screenSize);
	   Robot robot = new Robot();
	   BufferedImage image = robot.createScreenCapture(screenRectangle);
	   ImageIO.write(image, "jpeg", new File(fileName));
	 
	}
  }


/*@author srinivas n 17th Apr 2020.
 * Swipe up 
	Swipe down 
	Swipe left 
	Swipe Right 
 * 
 * using swipe method we can perform above operations
 * eg: swipe(driver,DIRECTION.UP);
 * 
 * swipe(driver,DIRECTION.RIGHT);
 * 
 */

public enum DIRECTION {
    DOWN, UP, LEFT, RIGHT;
}


public static void swipe(MobileDriver driver, DIRECTION direction) {
   
	
	Dimension size = driver.manage().window().getSize();

    int startX = 0;
    int endX = 0;
    int startY = 0;
    int endY = 0;

    switch (direction) {
        case RIGHT:
            startY = (int) (size.height / 2);
            startX = (int) (size.width * 0.90);
            endX = (int) (size.width * 0.05);
            new TouchAction(driver)
          .press(PointOption.point(startX, startY))
          .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L)))
          .moveTo(PointOption.point(endX, startY)).release().perform();
             break;

        case LEFT:
            startY = (int) (size.height / 2);
            startX = (int) (size.width * 0.05);
            endX = (int) (size.width * 0.90);
            new TouchAction(driver)
            .press(PointOption.point( startX, startY ))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L)))
            .moveTo(PointOption.point(endX, startY))
            .release()
            .perform();

            break;

        case UP:
        	
        	startX = (size.width / 2);
            endY = (int) (size.height * 0.70);
            startY = (int) (size.height * 0.30);
           
            new TouchAction(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L)))
            .moveTo(PointOption.point(startX, endY))
            .release()
            .perform();
                  
            break;


        case DOWN:
        	
        	startX = (size.width / 2);
            startY = (int) (size.height * 0.70);
            endY = (int) (size.height * 0.30);
                   
            new TouchAction(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L)))
            .moveTo(PointOption.point(startX, endY))
            .release()
            .perform();
                 

            break;

    }
    
    
    
}
}
