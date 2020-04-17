package accelerators;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.HasTouchScreen;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class ActionEngine extends TestEngine {
    public WebDriverWait wait;

    public static boolean flag = false;
    static boolean b = true;

    /*

    example -- Click
    */
    @SuppressWarnings("finally")
    public static boolean click(By locator, String locatorName) throws Throwable {
        Thread.sleep(2000);
        boolean flag = false;
        try {
            driver.findElement(locator).click();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
			if (!flag) {
				Reporter.failureReport("Click", "Unable to click on " + locatorName);
				return flag;
			} else if (b && flag) {
				Reporter.SuccessReport("Click", "Successfully click on " + locatorName);

		}*/
        return flag;
    }
	 

	/*
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
            flag = true;
        } catch (IOException e) {
            //Assert.assertTrue(flag,"Unable to take Screenshot");
            e.printStackTrace();
        } finally {
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

    //Author Vinay Gajula

    public static void singletTap(By locator) throws Exception {
        TouchActions actions=new TouchActions(driver);
        MobileElement ele = ((MobileElement) driver.findElement(locator));
        actions.singleTap(ele).perform();

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

}
