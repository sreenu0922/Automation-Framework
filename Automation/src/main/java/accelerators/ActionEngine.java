package accelerators;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import support.Reporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.Dimension;

import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.List;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Set;


import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

public class ActionEngine extends TestEngine {
	public static WebDriverWait wait;

	public static boolean flag = false;
	static boolean b = true;

	/*
	 *
	 * example -- Click
	 */
	@SuppressWarnings("finally")

	//comment removed throws Throwable @srinivas


	public static boolean click(By locator, String locatorName) throws Throwable {
		// explicityWait(locator, locatorName);

		boolean flag = false;
		try {
			driver.findElement(locator).click();
			flag = true;
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (!flag) {
				Reporter.failureReport("Click", "Unable to click on " + locatorName);
				return flag;
			} else if (b && flag) {
				Reporter.SuccessReport("Click", "Successfully click on " + locatorName);

			}
		}
		return flag;
	}

	//Jagadish
	public static boolean ScrollToElement(By locator, String locatorName) throws Throwable {
		// explicityWait(locator, locatorName);
		boolean flag = false;
		boolean temp;
		try {
			int i=1;
			temp =  isElementDisplayed(locator,locatorName);
			System.out.println(temp);
			while((!temp) && (i<30)){
				swipeVertical(0.8,0.1,0.9, 2000);
				Thread.sleep(500);
				temp = isElementPresent(locator, locatorName);
				System.out.println(temp);
				i++;
			}
			if(i==30) {
				flag = false;
			}else {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (!flag) {
				Reporter.failureReport("Click", "Unable to click on " + locatorName);
				return flag;
			} else if (b && flag) {
				Reporter.SuccessReport("Click", "Successfully click on " + locatorName);
			}

		}
		return flag;
	}


	public static void screenShot(String fileName) throws Throwable {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			FileUtils.copyFile(scrFile, new File(fileName));
			flag = true;
		} catch (IOException e) {
			// Assert.assertTrue(flag,"Unable to take Screenshot");
			e.printStackTrace();
		} finally {
			if (!flag) {
				Reporter.failureReport("screenShot ", " Unable to get screenShot ");
				System.out.println(" Unable to get TscreenShot");
			} else if (b && flag) {
				Reporter.SuccessReport("screenShot ", " Able to get TscreenShot");
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



	//@author :bhavya for acme droppdown

	public static void clickByCondindates(int x, int y) {
		TouchAction touchAction = new TouchAction((MobileDriver) driver);
		touchAction.tap(PointOption.point(x, y)).perform();
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
			if (!flag) {
				Reporter.failureReport("WaitForElementPresent ",
						"Falied to locate element " + locator);
			} else if (b && flag) {
				Reporter.SuccessReport("WaitForElementPresent ",
						"Successfully located element " + locator);
			}
		}
		return flag;

	}

	//@author:Archana Dasari
	//comment removed throws Throwable @srinivas
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
			if (!flag) {
				Reporter.failureReport("Type ",
						"Data typing action is not perform on " + locatorName);
			} else if (b && flag) {
				Reporter.SuccessReport("Type ",
						"Data typing action is performed on " + locatorName);
			}
		}
		return flag;
	}
	//@author:Archana Dasari
	public static void explicityWait(By Locator, String locatorName)  {
		WebDriverWait wdw = new WebDriverWait(driver, 180);
		WebElement ele = null;
		ele = wdw.until(ExpectedConditions.elementToBeClickable(Locator));
	}


	//Author Vinay Gajula

	public static void singletTap(By locator) throws Exception {
		TouchActions actions=new TouchActions(driver);
		MobileElement ele = ((MobileElement) driver.findElement(locator));
		actions.singleTap(ele).perform();

	}

//@vinay Gajula
	public static void hideKeyboard() {
		AndroidDriver.hideKeyboard();
	}

	public void launchKeyboard() {
		AndroidDriver.getKeyboard();
	}


	//Author Vinay Gajula
	public void longPress(By locator) {
		Actions actions = new Actions(driver);
		MobileElement ele = ((MobileElement) driver.findElement(locator));
		actions.clickAndHold(ele).perform();
	}

	//Author Vinay Gajula
	public void pressByCoordinates (int x, int y) {
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(x,y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2L))).release().perform();

	}

	//Author Vinay Gajula
// Generating the random number between 2 values
	public static int randomNumber(int min, int max) {
		Random r = new Random();
		int result = r.nextInt(max - min) + min;
		return result;
	}

	//Author Vinay Gajula
	public List<WebElement> LocatorStrategy(WebElement elementByXPath) {
		List<WebElement> links = (List<WebElement>) driver.findElement(By.xpath("LocatorValue"));
		return links;
	}



	//Author Sreeranga
	public void sendkey(WebElement w, String text) {
		try {
			w.click();
			w.clear();
			w.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*@author sangeethanulu

	  SWITCH TO WINDOW BY TITLE
	 */

	public static void switchWindowByTitle(String windowTitle, int count)
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
			System.out.println("Unable to switch window with title: " + windowTitle);
		}
	}

	//waitforelement code by Bhavya

	public static void waitForMobileElement(By element,long duration,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);

		try {
			new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			System.out.println("Unable to find the element " + element);

		}
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

	public static void swipe(MobileDriver driver, DIRECTION direction) throws Throwable {


		org.openqa.selenium.Dimension size = driver.manage().window().getSize();

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
						.press(PointOption.point(startX, startY))
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


	@SuppressWarnings("finally")
	public static boolean DoubleTab(By locator, String locatorName) throws Throwable {
		// explicityWait(locator, locatorName);
		boolean flag = false;
		try {
			WebElement we = driver.findElement(locator);
			Actions actions = new Actions(driver);
			actions.doubleClick(we).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				Reporter.failureReport("Click", "Unable to click on " + locatorName);
				return flag;
			} else if (b && flag) {
				Reporter.SuccessReport("Click", "Successfully click on " + locatorName);

			}
			return flag;
		}
	}

	//Jagadish
	public static void swipeVertical(double startPercentage, double finalPercentage, double anchorPercentage,
									 int duration) throws Exception {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * finalPercentage);
		TouchAction action = new TouchAction((PerformsTouchActions) driver);

		action.press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
				.moveTo(PointOption.point(anchor, endPoint)).release().perform();
	}

	public static Boolean isElementPresent(By locator, String locatorName) {
		Boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			MobileElement we = (MobileElement) driver.findElement(locator);
			flag = we.isEnabled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {
			if (!flag) {
				System.out.println("Element is not present: "+locatorName);
			} else {
				System.out.println("Element is present: " +locatorName);
			}
		}

		return flag;
	}

	public static Boolean isElementDisplayed(By locator, String locatorName) {
		Boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			MobileElement we = (MobileElement) driver.findElement(locator);
			flag = we.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {
			if (!flag) {
				System.out.println("Element is not display: " +locatorName);
			} else {
				System.out.println("Element is display "+ locatorName);
			}
		}

		return flag;
	}

	public static void scrollTo(String selector, int typ) {
		((FindsByAndroidUIAutomator<MobileElement>) driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(" + typ
						+ ")).scrollIntoView(new UiSelector().text(\"" + selector + "\").instance(0))");

	}
}
