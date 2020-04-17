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
		public static boolean mouseHoverByJavaScript(By locator, String locatorName) throws Throwable {

			try {
				WebElement mo = driver.findElement(locator);
				String javaScript = "var evObj = document.createEvent('MouseEvents');"
						+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
						+ "arguments[0].dispatchEvent(evObj);";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(javaScript, mo);
				flag = true;
				return flag;
			} catch (Exception e) {

				return flag;
			} finally {
				/*if (!flag) {
					Reporter.failureReport("MouseOver ",
							" MouseOver action is not perform on " + locatorName);
				} else if (b && flag) {
					Reporter.SuccessReport("MouseOver ",
							" MouserOver Action is Done on " + locatorName);
				}*/
			}

		}

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
	 
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Rectangle screenRectangle = new Rectangle(screenSize);
	   Robot robot = new Robot();
	   BufferedImage image = robot.createScreenCapture(screenRectangle);
	   ImageIO.write(image, "jpeg", new File(fileName));
	 
	}
  }
