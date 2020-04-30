package com.wavelabs.appium.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wavelabs.appium.reports.Loggers;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.wavelabs.appium.base.BasePage;
import com.wavelabs.appium.base.DriverManager;
import com.wavelabs.appium.utils.ConfigFileReader.ConfigProperties;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * Class contains all the reusable UI element interaction functions/methods
 */
public class ScreenBaseUtils {

	public static UIElementMapping uiElement;
	public WebDriverWait wait;
	public static Logger log = BasePage.log;
	public static com.aventstack.extentreports.ExtentTest test;
	

	public ScreenBaseUtils() {
		if (ConfigProperties.AppType.equals(MobilePlatform.ANDROID)) {
			Loggers.logInfoMessage("Loading android locators");
			uiElement = new UIElementMapping(ConfigFileReader
					.getConfigFileLocation("/src/test/resources/properties/Android_locators.properties"));
		} else if (ConfigProperties.AppType.equals(MobilePlatform.WINDOWS)) {
			Loggers.logInfoMessage("Loading windows locators");
			uiElement = new UIElementMapping(ConfigFileReader
					.getConfigFileLocation("/src/test/resources/properties/Windows_locators.properties"));
		} else {
			Loggers.logInfoMessage("Loading iOS locators");
			uiElement = new UIElementMapping(
					ConfigFileReader.getConfigFileLocation("/src/test/resources/properties/IOS_locators.properties"));
		}
	}

	/**
	 * Method finds the WebElement    
	 *
	 * @param locator 
	 * @throws    
	 */
	public WebElement getWebElement(String locator) {
		WebElement element = null;
		try {
			element = DriverManager.getDriver().findElement(uiElement.getLocator(locator));
		} catch (Exception e) {
			Loggers.logInfoMessage(element + "element not found");
			throw new NoSuchElementException("Element with locator information as '" + locator + "' was not present");
		}
		return element;
	}

	/**
	 * Method finds the WebElement   
	 *
	 * @param locator 
	 * @throws    
	 */
	public MobileElement getMobileElement(String locator) {
		MobileElement element = null;
		try {
			element = (MobileElement) DriverManager.getDriver().findElement(uiElement.getMobileLocator(locator));
			Loggers.logInfoMessage("*** element with locator information as '" + locator + "' was found");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Element with locator information as '" + locator + "' was not present");
		}
		return element;
	}

	/**
	 * Method finds the dynamic MobileElement   
	 *
	 * @param locator 
	 * @throws    
	 */
	public MobileElement getMobileElement(String locator, String replaceValue) {
		MobileElement element = null;
		try {
			element = (MobileElement) DriverManager.getDriver()
					.findElement(uiElement.getMobileLocator(locator, replaceValue));
			Loggers.logInfoMessage("*** element with locator information as '" + locator + "' was found");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Element with locator information as '" + locator + "' was not present");
		}
		return element;
	}

	/**
	 * Method finds the list of WebElement 
	 *
	 * @param locator 
	 * @throws    
	 */
	public List<MobileElement> getWebElements(String locator) {
		List<MobileElement> elements = null;
		try {
			elements = DriverManager.getDriver().findElements(uiElement.getLocator(locator));
		} catch (Exception e) {
			Loggers.logErrorMessage(elements + "element not found", true);
			throw new NoSuchElementException("Element '" + locator + "' is not present");
		}
		return elements;
	}

	/**
	 * Method finds the list of Mobile Elements    
	 *
	 * @param locator 
	 * @return list of Mobile Elements
	 * @throws    
	 */
	public List<MobileElement> getMobileElements(String locator) {
		List<MobileElement> elements = null;
		try {
			elements = DriverManager.getDriver().findElements(uiElement.getMobileLocator(locator));
		} catch (Exception e) {
			Loggers.logErrorMessage(elements + "element not found", true);
			throw new NoSuchElementException("Element '" + locator + "' is not present");
		}
		return elements;
	}

	/**
	 * Method gets the element text
	 *
	 * @param locator
	 * @return element text
	 */
	public String getMobileElementText(String locator) {
		String text = null;
		try {
			text = getMobileElement(locator).getText();
		} catch (Exception e) {
			Loggers.logErrorMessage("text not found", true);
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return text;
	}
	
	
	/**
	 * Method gets the element text with dynamic locator strategy
	 *
	 * @param locator
	 * @return element text
	 */
	public String getMobileElementTextWithDynamicLocator(String locator, String replaceValue) {
		String text = null;
		try {
			text = getMobileElement(locator,replaceValue).getText();
		} catch (Exception e) {
			Loggers.logErrorMessage("text not found", true);
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * Method gets the element attribute value
	 *
	 * @param locator
	 * @return element text
	 */
	public String getMobileElementValue(String locator) {
		String text = null;
		try {
			text = getMobileElement(locator).getAttribute("value");

		} catch (Exception e) {
			Loggers.logInfoMessage("the attribute value not found for given element" + locator);
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return text;
	}
	
	/**
	 * Method gets the element attribute value of passing attribute
	 *
	 * @param locator
	 * @return element text
	 */
	public String getMobileElementAttribueValueDynamic(String locator, String value ) {
		String text = null;
		try {
			text = getMobileElement(locator).getAttribute(value);

		} catch (Exception e) {
			Loggers.logInfoMessage("the attribute value not found for given element" + locator);
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * Method gets the element text
	 *
	 * @param locator
	 * @return element text
	 */
	public String getWebElementText(String locator) {
		String text = null;
		try {
			text = getWebElement(locator).getText();
		} catch (Exception e) {
			Loggers.logInfoMessage("text not found");
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * Method switches the Frames
	 *
	 * @param locator
	 */
	public void switchToFrame(String locator) {
		DriverManager.getDriver().switchTo().frame(getMobileElement(locator));
	}

	/**
	 * Method switches to the default Frame
	 */
	public void switchToDefault() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

	/**
	 * Method makes action on alert popup
	 *
	 * @param btnText
	 * @return boolean isAlertClicked
	 */
	public boolean clickOnMobAlert(String btnText) {
		waitforAlert();
		boolean isAlertClicked = false;
		try {
			Alert alert = DriverManager.getDriver().switchTo().alert();
			String alertTitle = alert.getText();
			if (btnText.equalsIgnoreCase("Allow") || btnText.equalsIgnoreCase("Continue")
					|| btnText.equalsIgnoreCase("Yes") || btnText.equalsIgnoreCase("Ok")
					|| btnText.equalsIgnoreCase("accept")) {
				alert.accept();
				Loggers.logInfoMessage("the " + alertTitle + " is accepted");
				isAlertClicked = true;
			} else if (btnText.equalsIgnoreCase("cancel") || btnText.equalsIgnoreCase("dismiss")
					|| btnText.equalsIgnoreCase("deny") || btnText.equalsIgnoreCase("No")
					|| btnText.equalsIgnoreCase("Don't Allow")) {
				alert.dismiss();
				Loggers.logInfoMessage("the " + alertTitle + " is dismissed");
				isAlertClicked = true;
			}
		} catch (Exception e) {
			Loggers.logInfoMessage("The MobileAlert Button not found in Alert popup");
			log.error(e.getLocalizedMessage());
			isAlertClicked = false;
		}
		return isAlertClicked;
	}

	/**
	 * Method is used to send the text in to the UI element
	 *
	 * @param locator
	 * @param textData
	 */
	public void sendTextInputWeb(String locator, String textData) {
		WebElement textfiled = getWebElement(locator);
		textfiled.click();
		textfiled.clear();
		try {
			textfiled.sendKeys(textData);
			Loggers.logInfoMessage("The text is entered successfully in the UI element " + locator);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to send the text to " + locator + " due to the " + e.getLocalizedMessage());
		}
	}

	/**
	 * Method is used to send the text in to the UI element
	 *
	 * @param locator
	 * @param textData
	 * @throws InterruptedException
	 */
	public void sendTextInputToMobile(String locator, String textData) {
		mobileElementclick(locator);
		launchKeyboard();
		MobileElement textfiled = (MobileElement) getMobileElement(locator);
		textfiled.click();
		textfiled.clear();
		try {
			textfiled.sendKeys(textData);
			hideKeyboard();
			Loggers.logInfoMessage("The text is entered successfully in the UI element " + locator);
		} catch (Exception e) {
			Loggers.logErrorMessage(e.getLocalizedMessage(), true);
			e.printStackTrace();
			log.error("Unable to send the text to " + locator + " due to the " + e.getLocalizedMessage());
		}
	}

	/**
	 *
	 *
	 * @param element
	 * @param textData
	 * @param elementName
	 */
	public void sendTextInputToMobile(MobileElement element, String textData, String elementName) {

		launchKeyboard();

		element.click();
		element.clear();
		try {

			element.sendKeys(textData);
			hideKeyboard();

			Loggers.logInfoMessage("The text is entered successfully in the UI element " + elementName);

		} catch (Exception e) {

			Loggers.logInfoMessage(e.getLocalizedMessage());
			e.printStackTrace();
			log.error("Unable to send the text to" + elementName + " due to the " + e.getLocalizedMessage());

		}

	}

	/**
	 * Method scrolls up till the element preset
	 * 
	 * @param locator
	 */
	public void scrollUpTillElementPresent(String locator, int noOfScrolls) {
		int count = 0;
		 String attribute;
		 
        if (ConfigFileReader.ConfigProperties.AppType.equalsIgnoreCase("ios")) {
        	attribute = "visible";
        } else {
        	attribute = "displayed";
        }

		while (!(isMobileElementDisplayed(locator, 3)& Boolean.parseBoolean(getMobileElementAttribueValueDynamic(locator, attribute)))) {
			count = count + 1;
			verticalSwipeUpByPercentage(50.00, 50.00, 30.00);
			if (count == noOfScrolls) {
				break;
			}
		}

	}
	
	/**
	 * Method scrolls up till the element preset
	 * 
	 * @param locator
	 */
	public void scrollUpTillElementPresent(String locator) {
		int count = 0;
		String attribute;
		

        if (ConfigFileReader.ConfigProperties.AppType.equalsIgnoreCase("ios")) {
        	attribute = "visible";
        } else {
        	attribute = "displayed";
        }

		while (!(isMobileElementDisplayed(locator, 3)& Boolean.parseBoolean(getMobileElementAttribueValueDynamic(locator, attribute)))) {
			count = count + 1;
			verticalSwipeUpByPercentage(50.00, 50.00, 30.00);
			if (count == 10) {
				break;
			}
		}
	}
	
	

	/**
	 * Method scrolls up till the element preset
	 * 
	 * @param locator
	 */
	public void scrollUpTillElementPresentWithScreenDimensions(String locator, double start, double end) {
		int count = 0;
		String attribute;
		 
        if (ConfigFileReader.ConfigProperties.AppType.equalsIgnoreCase("ios")) {
        	attribute = "visible";
        } else {
        	attribute = "displayed";
        }

		while (!(isMobileElementDisplayed(locator, 3)& Boolean.parseBoolean(getMobileElementAttribueValueDynamic(locator, attribute)))) {
			count = count + 1;
			verticalSwipeUpByPercentage(50.00, end, start);
			if (count == 10) {
				break;
			}
		}

	}
	
	

	public void verticalSwipeUpByPercentage(double anchorPercentage, double startPercentage, double endPercentage) {

		Dimension size = DriverManager.getDriver().manage().window().getSize();
		int anchor = (int) (size.width / 2);
		int startPoint = (int) (size.height * startPercentage) / 100;
		int endPoint = (int) (size.height * endPercentage) / 100;

		new TouchAction(DriverManager.getDriver()).press(PointOption.point(anchor, endPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(anchor, startPoint)).release().perform();
	}

	/**
	 * Method handles the default waits for elements
	 *
	 * @param locator
	 * @return
	 */
	public MobileElement waitforElement(String locator) {
		long duration = ConfigProperties.DEFAULT_WAIT_TIME;
		wait = new WebDriverWait(DriverManager.getDriver(), duration);
		try {
			return (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(uiElement.getMobileLocator(locator)));
		} catch (Exception e) {
			Loggers.logErrorMessage("Unable to find the element " + locator, true);
			return null;
//            throw new NoSuchElementException(
//                    "Element '" + locator + "' is not present after " + duration + " attempts");
		}
	}

	public MobileElement waitforElement(String locator, String valueToBeReplaced) {
		long duration = ConfigProperties.DEFAULT_WAIT_TIME;
		wait = new WebDriverWait(DriverManager.getDriver(), duration);
		try {
			return (MobileElement) wait.until(ExpectedConditions
					.presenceOfElementLocated(uiElement.getMobileLocator(locator, valueToBeReplaced)));
		} catch (Exception e) {
			Loggers.logErrorMessage("Unable to find the element " + locator, true);
			throw new NoSuchElementException(
					"Element '" + locator + "' is not present after " + duration + " attempts");
		}
	}

	/**
	 * Method handles the default waits for elements to be clickable
	 *
	 * @param locator
	 * @param duration
	 */
	public MobileElement waitforElementToClick(String locator, long duration) {

		wait = new WebDriverWait(DriverManager.getDriver(), duration);
		try {
			return (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(uiElement.getMobileLocator(locator)));

		} catch (Exception e) {
			Loggers.logErrorMessage("Unable to find the element  " + locator, true);
			throw new NoSuchElementException(
					"Element '" + locator + "' is not present after " + duration + " attempts");
		}
	}

	/**
	 * Method handles the dynamic waits for elements
	 *
	 * @param duration
	 * @param locator
	 * @return
	 */
	public MobileElement waitforElement(String locator, long duration) {
		wait = new WebDriverWait(DriverManager.getDriver(), duration);
		try {
			return (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(uiElement.getMobileLocator(locator)));
		} catch (Exception e) {
			Loggers.logErrorMessage("Unable to find the element " + locator, true);
			System.out.println();
			throw new NoSuchElementException(
					"Element '" + locator + "' is not present after " + duration + " attempts ");
		}
	}

	
	/**
	 * Method handles the dynamic waits for elements
	 *

	 * @param locator
	 * @return
	 */
	public MobileElement waitforDynamicElementWithShortDuration(String locator, String valueToBeReplaced, long waittime) {
		
		wait = new WebDriverWait(DriverManager.getDriver(), waittime);
		try {
			return (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(uiElement.getMobileLocator(locator, valueToBeReplaced)));
		} catch (Exception e) {
			Loggers.logErrorMessage("Unable to find the element " + locator, true);
			System.out.println();
			throw new NoSuchElementException(
					"Element '" + locator + "' is not present");
		}
	}


	/**
	 * Method handles the waits for elements
	 *
	 * @param locator
	 * @return
	 */
	public WebElement waitforWebElement(String locator) {
		long duration = ConfigProperties.DEFAULT_WAIT_TIME;
		wait = new WebDriverWait(DriverManager.getDriver(), duration);
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(uiElement.getLocator(locator)));
		} catch (Exception e) {
			Loggers.logErrorMessage("Unable to find the element " + locator, true);
			log.error("Unable to find the element " + locator);
			throw new NoSuchElementException(
					"Element '" + locator + "' is not present after " + duration + " attempts");
		}
	}

    public MobileElement waitforElementShortDurationWithoutScreenshot(String locator) {
        wait = new WebDriverWait(DriverManager.getDriver(), ConfigProperties.IMPLICIT_WAIT_TIME);
        try {
            return (MobileElement) wait
                    .until(ExpectedConditions.presenceOfElementLocated(uiElement.getMobileLocator(locator)));
        } catch (Exception e) {
            Loggers.logInfoMessage("Unable to find the element " + locator);
            System.out.println();
            return null;
        }
    }


	public List<MobileElement> softWaitForElement(String locator) {
		try {
			return DriverManager.getDriver().findElements(uiElement.getMobileLocator(locator));
		} catch (Exception e) {
			Loggers.logErrorMessage("Failed with error : " + e.getStackTrace(), true);
		}
		return null;
	}

	/**
	 * Method handles the waits for Alert popup
	 */
	public void waitforAlert() {
		long duration = ConfigProperties.DEFAULT_WAIT_TIME;
		wait = new WebDriverWait(DriverManager.getDriver(), duration);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Method performs click Action on Web UI element
	 *
	 * @param locator
	 */
	public void webElementclick(String locator) {
		waitforWebElement(locator);
		getWebElement(locator).click();
	}

	/**
	 * Method performs click Action on Mobile UI element
	 *
	 * @param locator
	 */
	public void mobileElementclick(String locator) {

		try {
			waitforElement(locator, ConfigProperties.DEFAULT_WAIT_TIME);
			waitforElementToClick(locator, ConfigProperties.DEFAULT_WAIT_TIME);
			getMobileElement(locator).click();
			Loggers.logInfoMessage(locator + " element found and tapped");
		} catch (NoSuchElementException e) {
			Loggers.logErrorMessage(locator + " element not found", true);
			Loggers.logInfoMessage("mobile element not clicked");
			throw new NoSuchElementException("exception occured while tapping on the element " + e.getStackTrace());
		}
	}

	/**
	 * Method performs click Action on Mobile UI element
	 *

	 * @throws InterruptedException
	 */
	public void mobileElementclick(MobileElement element, String elemenetName) {

		try {
			element.click();
			Loggers.logInfoMessage(element + " element found and tapped");
		} catch (NoSuchElementException e) {
			Loggers.logErrorMessage(element + " element not found", true);
			Loggers.logInfoMessage("mobile element not clicked");
			throw new NoSuchElementException("exception occured while tapping on the element " + e.getStackTrace());
		}
	}

	/**
	 * 'Method performs click Action on Mobile UI element
	 *
	 * @param locator
	 * @throws InterruptedException
	 */
	public void mobileElementclick(String locator, String dynamicTestValue) {
		try {
			MobileElement element = waitforElement(locator, dynamicTestValue);
			element.click();
		} catch (NoSuchElementException e) {
			Loggers.logInfoMessage(locator + " element not found");
			Loggers.logInfoMessage("mobile element not clicked");
			throw new NoSuchElementException("exception occured while tapping on the element " + e.getStackTrace());
		}
	}

	/**
	 * Method verifies the web Element visibility
	 *
	 * @param locator
	 * @return
	 */
	public boolean isWebElementDisplayed(String locator) {
		waitforWebElement(locator);
		boolean flag = false;
		try {
			if (getWebElement(locator).isDisplayed())
				flag = true;
			Loggers.logInfoMessage("UI element " + locator + " is displayed in screen");
		} catch (Exception e) {
			test.log(Status.INFO, ExceptionUtils.getStackTrace(e));
		}
		return flag;
	}

	/**
	 * Method verifies the mobile Element visibility
	 *
	 * @param locator
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isMobileElementDisplayed(String locator) {
		List<MobileElement> elementList = getMobileElements(locator);
		if (elementList.size() > 0) {
			return isMobileElementDisplayed(locator, ConfigProperties.DEFAULT_WAIT_TIME);
		} else {
			return false;
		}
	}
	
	/**
	 * Method verifies the mobile Element visibility
	 *
	 * @param locator
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isDynamicMobileElementDisplayed(String locator, String dynamicTestValue) {
		boolean flag = false;
		try {
			waitforElement(locator, dynamicTestValue);
			flag = true;
			Loggers.logInfoMessage("UI element " + locator + " is displayed in screen");
		} catch (Exception e) {
			flag = false;
			Loggers.logInfoMessage("UI element " + locator + " is not displayed with exception" + e);
		}
		return flag;
	}

	/**
	 * Method verifies the mobile Element visibility
	 *
	 * @param locator
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isDynamicMobileElementDisplayed(String locator, String dynamicTestValue, long duration) {
		boolean flag = false;
		try {
			waitforDynamicElementWithShortDuration(locator, dynamicTestValue, duration);
			flag = true;
			Loggers.logInfoMessage("UI element " + locator + " is displayed in screen");
		} catch (Exception e) {
			flag = false;
			Loggers.logInfoMessage("UI element " + locator + " is not displayed with exception" + e);
		}
		return flag;
	}
	
	/**
	 * Method verifies the mobile Element visibility
	 *
	 * @param locator
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isMobileElementDisplayed(String locator, long weight) {
		boolean flag = false;
		try {
			waitforElement(locator, weight);
			flag = true;
			Loggers.logInfoMessage("UI element " + locator + " is displayed in screen");
		} catch (Exception e) {
			flag = false;
			Loggers.logInfoMessage("UI element " + locator + " is not displayed with exception" + e);
		}
		return flag;
	}

	/**
	 * Method is used to perform horizontal swipe based on X and Y coordinates
	 *
	 * @param startPercentage   
	 * @param endPercentage
	 * @param anchorPercentage    
	 */
	public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = DriverManager.getDriver().manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage) / 100;
		int startPoint = (int) (size.width * startPercentage) / 100;
		int endPoint = (int) (size.width * endPercentage) / 100;
		new TouchAction((PerformsTouchActions) DriverManager.getDriver()).press(PointOption.point(startPoint, anchor))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endPoint, anchor))
				.release().perform();
	}

	/**
	 * Method is used to perform vertical swipe based on X and Y coordinates
	 *
	 * @param startPercentage   
	 * @param endPercentage
	 * @param anchorPercentage    
	 */
	public void verticalSwipeByPercentage(double anchorPercentage, double startPercentage, double endPercentage) {
		Dimension size = DriverManager.getDriver().manage().window().getSize();
		int anchor = (int) (size.width / 2);
		int startPoint = (int) (size.height * startPercentage) / 100;
		int endPoint = (int) (size.height * endPercentage) / 100;
		new TouchAction(DriverManager.getDriver()).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(anchor, endPoint))
				.release().perform();
	}

	/**
	 * Method selects the value from the dropdown and will loop through till if
	 * finds
	 *
	 * @param locator
	 * @throws InterruptedException
	 */
	public void scrollDownAndClickIfElementPresent(String locator, int noOfScrolls) {
		
			int count = 0; 
			String attribute;
			
			if (ConfigFileReader.ConfigProperties.AppType.equalsIgnoreCase("ios")) {
	        	attribute = "visible";
	        } else {
	        	attribute = "displayed";
	        }

			while (!(isMobileElementDisplayed(locator, 3)& Boolean.parseBoolean(getMobileElementAttribueValueDynamic(locator, attribute)))) {
			count = count + 1;
				verticalSwipeByPercentage(50.00, 85.00, 30.00);
				if (count == noOfScrolls) {
					break;
				}
			}
	}
	
	/**
	 * Method selects the value from the dropdown and will loop through till if
	 * finds
	 *
	 * @param locator
	 * @throws InterruptedException
	 */
	public void scrollDownAndClickIfElementPresent(String locator) {
		
		String attribute;
		
		if (ConfigFileReader.ConfigProperties.AppType.equalsIgnoreCase("ios")) {
        	attribute = "visible";
        } else {
        	attribute = "displayed";
        }
		
		
		for (int i = 0; i < 10; i++) {
			if (isMobileElementDisplayed(locator, 2)& Boolean.parseBoolean(getMobileElementAttribueValueDynamic(locator, attribute))) {
				mobileElementclick(locator);
				break;
			} else {
				verticalSwipeByPercentage(50.00, 85.00, 30.00);
			}
		}
	}


	/**
	 * Method selects the value from the dropdown and will loop through till if
	 * finds
	 *
	 * @param locator
	 * @throws InterruptedException
	 */
	public void scrollDownTillElementPresent(String locator, int noOfScrools) {
		String attribute;
		if (ConfigFileReader.ConfigProperties.AppType.equalsIgnoreCase("ios")) {
        	attribute = "visible";
        } else {
        	attribute = "displayed";
        }
		
		for (int i = 0; i < noOfScrools; i++) {
			if (isMobileElementDisplayed(locator, 2) & Boolean.parseBoolean(getMobileElementAttribueValueDynamic(locator, attribute))){
				break;
			} else {
				verticalSwipeByPercentage(50.00, 50.00, 30.00);
			}
		}
	}

		/**
	 * Method selects the value from the dropdown and will loop through till if
	 * finds
	 *
	 * @param locator
	 * @throws InterruptedException
	 */
	public void scrollDownTillElementPresent(String locator) {
		
		String attribute;
		if (ConfigFileReader.ConfigProperties.AppType.equalsIgnoreCase("ios")) {
        	attribute = "visible";
        } else {
        	attribute = "displayed";
        }
	
		for (int i = 0; i < 10; i++) {
			if (isMobileElementDisplayed(locator, 2)& Boolean.parseBoolean(getMobileElementAttribueValueDynamic(locator, attribute))) {
				break;
			} else {
				verticalSwipeByPercentage(50.00, 50.00, 30.00);
			}
		}
	}
	
	/**
	 * Method selects the value from the dropdown and will loop through till if
	 * finds
	 *
	 * @param locator
	 * @throws InterruptedException
	 */
	public void scrollDownTillElementPresentDynamicLocator(String locator, String replaceLocatorValue, int noOfScrools, long timeduration) {
		for (int i = 0; i < noOfScrools; i++) {
			if (isDynamicMobileElementDisplayed(locator, replaceLocatorValue, timeduration)) {
				break;
			} else {
				verticalSwipeByPercentage(50.00, 50.00, 30.00);
			}
		}
	}
	
	/**
	 * Method selects the value from the dropdown and will loop through till if
	 * finds
	 */
	public void verticalSwipe() {
		Dimension size = DriverManager.getDriver().manage().window().getSize();
		int xanchorPercentage = size.width / 2;
		int startPoint = (int) (size.height * 0.80);
		int endPoint = (int) (size.height * 0.20);
		new TouchAction(DriverManager.getDriver()).press(PointOption.point(xanchorPercentage, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(xanchorPercentage, endPoint)).release().perform();
	}

	public void javascriptsSwipe() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}

	public void javascriptsSwipeToElement(MobileElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scroll", scrollObject);
	}

	/**
	 * Method hides the keyboard
	 */
	public void hideKeyboard() {
		DriverManager.getDriver().hideKeyboard();
	}

	/**
	 * Method Launches the Keyboard
	 */
	public void launchKeyboard() {
		DriverManager.getDriver().getKeyboard();
	}

	MobileDriver driver = DriverManager.getDriver();

	/**
	 * Method performs signature action on signature pad
	 *
	 * @param locator
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public static void signatureSwipe(String locator, int startX, int startY, int endX, int endY) {
		MobileElement ele = DriverManager.getDriver().findElement(uiElement.getMobileLocator(locator));
		int elementX = ele.getLocation().getX();
		int elementY = ele.getLocation().getY();
		TouchAction action = new TouchAction(DriverManager.getDriver());
		action.longPress(PointOption.point(elementX + (ele.getSize().width / 2), elementY + (ele.getSize().height / 4)))
				.moveTo(PointOption.point(elementX + (ele.getSize().width / 2), elementY + (ele.getSize().height / 2)))
				.release().perform();
	}

	/**
	 * Method performs moving the element to X and Y coordinates
	 *
	 * @param locator
	 * @param xOffset
	 * @param yOffset
	 */
	public void moveToElement(String locator, int xOffset, int yOffset) {
		MobileElement ele = (MobileElement) DriverManager.getDriver().findElement(uiElement.getMobileLocator(locator));
		Actions action = new Actions(DriverManager.getDriver());
		action.dragAndDropBy(ele, xOffset, yOffset);
		action.perform();
	}

	/**
	 * Method performs tap action on X and Y coordinates
	 */
	public void tapOusideElement() {
		TouchAction action = new TouchAction(DriverManager.getDriver()).press(PointOption.point(100, 100)).release()
				.perform();
		
	}

	public void tapOnElement(String locator) {
		MobileElement ele = DriverManager.getDriver().findElement(uiElement.getMobileLocator(locator));
		TouchActions action = new TouchActions(driver);
		action.singleTap(ele);
		action.perform();
	}

	public MobileElement getMobileElementIfExistsAndDisplayed(String locator) {
		List<MobileElement> elements = DriverManager.getDriver().findElements(uiElement.getMobileLocator(locator));
		if (elements.size() > 0) {
			if (elements.get(0).isDisplayed()) {
				return elements.get(0);
			} else {
				return null;
			}

		} else {
			return null;
		}
		
	}
	
	/**
	 * Method performs scroll Right/Left action on given UI element by passing start and end positions.
	 * 
	 * @param locator
	 * @param startPosition
	 * @param endPosition
	 */
	public void swipeRightOrLeftOnElement(String locator, int startPosition, int endPosition) {
		
		Map<String, Integer> screencoordinates = screenXYcoordinatesHorizontal(locator, startPosition, endPosition);		
		swipeTouchActions(screencoordinates.get("startPercentage"),screencoordinates.get("endPercentage"),screencoordinates.get("anchorPercentage"));		
		
	}
	
	
	/**
	 * Method performs scroll up/down action on given UI element by passing start and end positions.
	 * 
	 * @param locator
	 * @param startPosition
	 * @param endPosition
	 */
	public void swipeUpOrDownOnElement(String locator,int startPosition, int endPosition) {
		
		Map<String, Integer> screencoordinates = screenXYcoordinatesVertical(locator, startPosition, endPosition);		
		swipeTouchActions(screencoordinates.get("startPercentage"),screencoordinates.get("endPercentage"),screencoordinates.get("anchorPercentage"));		
	}
	
	
	/**
	 * Method performs TocuhActions to move an element
	 * 
	 * @param startPercentage
	 * @param endPercentage
	 * @param anchorPercentage
	 */
	public void swipeTouchActions(int startPercentage, int endPercentage, int anchorPercentage) {
		
		TouchAction action = new TouchAction(DriverManager.getDriver());
		action.press(PointOption.point(endPercentage, anchorPercentage))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startPercentage,anchorPercentage))
		.release().perform();
		
	}

	/**
	 * Method returns the given element Start and End coordinates of X axis
	 *   
	 * @param locator
	 * @param startPosition
	 * @param endPosition
	 * @return list of anchorPercentage, startPercentage, endPercentage
	 */
	public Map<String, Integer> screenXYcoordinatesVertical(String locator,int startPosition, int endPosition) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		MobileElement element = getMobileElement(locator);
		
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int upperY = element.getLocation().getY();
		int lowerY = upperY + element.getSize().getHeight();

		int startPercentage =(upperY + lowerY) * startPosition/10;
		int endPercentage = (upperY + lowerY )* endPosition/10;
		int anchorPercentage = (leftX + rightX) * 1/2;
		map.put("startPercentage", startPercentage);
		map.put("endPercentage", endPercentage);
		map.put("anchorPercentage", anchorPercentage);
		
		return map;
		
	} 
	
	/**
	 * Method returns the given element Start and End coordinates of Y axis
	 *     
	 * @param locator
	 * @param startPosition
	 * @param endPosition
	 * @return list of anchorPercentage, startPercentage, endPercentage
	 */
	public Map<String, Integer> screenXYcoordinatesHorizontal(String locator,int startPosition, int endPosition) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		MobileElement element = getMobileElement(locator);
		
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int upperY = element.getLocation().getY();
		int lowerY = upperY + element.getSize().getHeight();

		int startPercentage =(leftX + rightX) * startPosition/10;
		int endPercentage = (leftX + rightX )* endPosition/10;
		int anchorPercentage = (upperY + lowerY) * 1/2;
		map.put("startPercentage", startPercentage);
		map.put("endPercentage", endPercentage);
		map.put("anchorPercentage", anchorPercentage);
		
		return map;

	} 
	
	
	/**
	 * Method returns current focused month in calendar
	 * 
	 * @return
	 */
	public String getCurrentFocusedMonth(String locator, String value){
	    String month = getMobileElementAttribueValueDynamic(locator, value);
	    String[] monthName = month.split(" ");
	    
	    return monthName[1];
	}
	
	public Integer getCurrentFocusedMonthIndex(String locator, String value ) {
	    String monthName = getCurrentFocusedMonth(locator, value);
	    switch (monthName) {
	        case "January":
	            return 1;
	        case "February":
	            return 2;
	        case "March":
	            return 3;
	        case "April":
	            return 4;
	        case "May":
	            return 5;
	        case "June":
	            return 6;
	        case "July":
	            return 7;
	        case "August":
	            return 8;
	        case "September":
	            return 9;
	        case "October":
	            return 10;
	        case "November":
	            return 11;
	        case "December":
	            return 12;
	        default:
	            return 1;
	    }
	}
	
	public void selectMonthFromCalender(int month, String datewheelpicker_previousMonth, String datewheelpicker_nextMonth, String dateSelectedloc, String value){
	    int monthIndex = getCurrentFocusedMonthIndex(dateSelectedloc, value);
	    int clicks;
	    int i;
	    if(month < monthIndex) {
	        clicks = monthIndex - month;
	        for (i = 0; i < clicks ; i++) {
	            mobileElementclick(datewheelpicker_previousMonth);
	        }
	    }
	            else {
	                clicks = month - monthIndex;
	                for (i = 0; i < clicks ; i++) {
	                    mobileElementclick(datewheelpicker_nextMonth);
	                }
	            }
	        }
	
	/**
	 * Method returns current focused date in calendar
	 * 
	 * @return
	 */
	public String getCurrentFocusedDate(String locator, String value){
		
	    String date = getMobileElementAttribueValueDynamic(locator, value);
	    String[] dateSelected = date.split(" ");
	    
	    return dateSelected[0];
	}
	
	
	/**
	 * Method performs current calendar day selection
	 * 
	 * @param datewheelpicker_monthHeader
	 * @param dateselection_indexdatebutton
	 * @param date_confirm_button
	 * @return
	 */
	public boolean selectAnyDateFromCalendar(int selectDate, String datewheelpicker_monthHeader, String dateselection_indexdatebutton, String date_confirm_button) {    
		waitforElement(datewheelpicker_monthHeader);	   
	   
		selectDate = selectDate + 1;
	   
	    String strdateGr = String.valueOf(selectDate);
	    mobileElementclick(dateselection_indexdatebutton, strdateGr);
	    mobileElementclick(date_confirm_button);
	    return true;
	}
	
	
	/**
	 * Method performs current calendar day selection
	 * 
	 * @param datewheelpicker_monthHeader
	 * @param dateselection_indexdatebutton
	 * @param date_confirm_button
	 * @return
	 */
	public boolean selectCurrentDateFromCalendar(String datewheelpicker_monthHeader, String dateselection_indexdatebutton, String date_confirm_button, String selectedDatelocator, String value) {    
		waitforElement(datewheelpicker_monthHeader);	    
	    String dateInString = getCurrentFocusedDate(selectedDatelocator, value);
	    int dateGr = Integer.parseInt(dateInString);
	    dateGr = dateGr + 1;
	   
	    String strdateGr = String.valueOf(dateGr);
	    mobileElementclick(dateselection_indexdatebutton, strdateGr);
	    mobileElementclick(date_confirm_button);
	    return true;
	}
	
	
	/**
	 * Method performs past calendar days selection based on the given noofdaysselection parameter 
	 * 
	 * @param noOfDaysSelection
	 * @param datewheelpicker_monthHeader
	 * @param date_confirm_button
	 * @param datewheelpicker_previousMonth
	 * @param datesIndex
	 * @param dateselection_indexdatebutton
	 */
	public void selectPastDateFromCalendar(int noOfDaysSelection, String datewheelpicker_monthHeader, String date_confirm_button, String datewheelpicker_previousMonth, String datesIndex, String dateselection_indexdatebutton, String dateSelectedlocator, String value) {
	    
		waitforElement(datewheelpicker_monthHeader);	    
	    String dateInString = getCurrentFocusedDate(dateSelectedlocator, value);
	    int selectedDate = Integer.parseInt(dateInString);
	    int temp;
	    int selectionDate;
	    List<MobileElement> noOfdays;
	    
	    if (selectedDate < noOfDaysSelection) {
	        mobileElementclick(datewheelpicker_previousMonth);
	        waitforElement(datesIndex,ConfigProperties.IMPLICIT_WAIT_TIME);
	        noOfdays = getMobileElements(datesIndex);   
		    temp = selectedDate - noOfDaysSelection;
		    selectionDate = (noOfdays.size()-1) + temp; 
		    String strdateGr = String.valueOf(selectionDate);
		    mobileElementclick(dateselection_indexdatebutton, strdateGr);
	    } else {
	    	selectionDate = selectedDate - noOfDaysSelection;
	    	String strdateGr = String.valueOf(selectionDate);
		    mobileElementclick(dateselection_indexdatebutton, strdateGr);
	    }	   
	    mobileElementclick(date_confirm_button);
	}
	
	/**
	 * Method performs future calendar days selection based on the given noofdaysselection parameter
	 * 
	 * @param noOfDaysSelection
	 * @param datewheelpicker_monthHeader
	 * @param dateselection_indexdatebutton
	 * @param date_confirm_button
	 * @param datewheelpicker_nextMonth
	 * @param datesIndex
	 */
	public void selectFutureDateFromCalendar(int noOfDaysSelection, String datewheelpicker_monthHeader, 
			String dateselection_indexdatebutton, String date_confirm_button, String datewheelpicker_nextMonth, String datesIndex, String dateSelectedlocator, String value) {
	    
		waitforElement(datewheelpicker_monthHeader);	    
	    String dateInString = getCurrentFocusedDate(dateSelectedlocator, value);
	    int selectedDate = Integer.parseInt(dateInString);
	    int availabledays;
	    int selectionDate;
	    List<MobileElement> noOfdays = getMobileElements(datesIndex);
	    int calenderDays = noOfdays.size()- 1;
	    availabledays = calenderDays - selectedDate;
	    
	    if (availabledays < noOfDaysSelection) {
	    	
	    	selectionDate = noOfDaysSelection - availabledays;
	    	selectionDate = selectionDate + 1;
	        mobileElementclick(datewheelpicker_nextMonth);
		    String selectDate = String.valueOf(selectionDate);
		    mobileElementclick(dateselection_indexdatebutton, selectDate);
	    } else {
	    	
	    	selectionDate = selectedDate + noOfDaysSelection + 1;
	    	String strdateGr = String.valueOf(selectionDate);
		    mobileElementclick(dateselection_indexdatebutton, strdateGr);
	    }	
	    
	    mobileElementclick(date_confirm_button);
	}
	

	/**
	 * Method performs select given year in calendar
	 * 

	 * @param wheelpicker_defaultSelectedyear
	 * @param wheelpicker_selectYear
	 * @param wheelpicker_yearScroller
	 * @return
	 */
	public boolean selectYearFromCalendar(int selectyear, String wheelpicker_defaultSelectedyear, String wheelpicker_selectYear,String wheelpicker_yearScroller) {
	    boolean yearSelection = false;
	
	    String selectYear = String.valueOf(selectyear);
	    String getPreviousSelectedYear = getMobileElementText(wheelpicker_defaultSelectedyear);
	    if (!getPreviousSelectedYear.equals(String.valueOf(selectYear))) {
	        mobileElementclick(wheelpicker_defaultSelectedyear);
	        do {
	        } while (!isDynamicMobileElementDisplayed(wheelpicker_selectYear,selectYear ));
	        if (isDynamicMobileElementDisplayed(wheelpicker_selectYear,selectYear)) {
	            mobileElementclick(wheelpicker_selectYear, String.valueOf(selectYear));
	            yearSelection = true;
	        }
	        
	    }
	    return yearSelection;
	}
	
	public void swipeFromOneElementToAnother(String locatorOfElementWhichNeedsToBeDragged,String locatorOfElementToWhichDragActionNeedsToBePerformed) {
        TouchAction touchAction = new TouchAction(DriverManager.getDriver());
        touchAction
                .longPress(LongPressOptions.longPressOptions().withElement(
                        ElementOption.element(waitforElement("locatorOfElementWhichNeedsToBeDragged"))))
                .moveTo(PointOption.point(waitforElement("locatorOfElementToWhichDragActionNeedsToBePerformed").getCenter()))
                .release().perform();
    }
		
}
