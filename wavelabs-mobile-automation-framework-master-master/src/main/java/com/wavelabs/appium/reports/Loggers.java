package com.wavelabs.appium.reports;

import com.wavelabs.appium.utils.ConfigFileReader;
import org.apache.log4j.Logger;
import org.testng.Reporter;
import com.epam.reportportal.service.ReportPortal;
import com.aventstack.extentreports.Status;
import com.wavelabs.appium.base.BasePage;

import java.io.File;
import java.util.Calendar;

import static com.wavelabs.appium.base.BasePage.captureScreenshot;

public class Loggers {
    public static Logger log = BasePage.log;

    /**
     * Logs a message to the system.out, and the Test Reporter.
     *
     * @param inMessage
     */
    public static void logInfoMessage(String inMessage) {
        String consoleMessage = inMessage;
        ReportPortal.emitLog(inMessage, "DEBUG", Calendar.getInstance().getTime());
        Reporter.log(inMessage);
        if (BasePage.test != null) {
            BasePage.test.log(Status.INFO, inMessage);
        }
    }

    public static void logWarningMessage(String inMessage) {
        String consoleMessage = inMessage;
        ReportPortal.emitLog(inMessage, "WARN", Calendar.getInstance().getTime());
        Reporter.log(inMessage);
        if (BasePage.test != null) {
            BasePage.test.log(Status.INFO, inMessage);
        }
    }

    public static void logInfoMessageWithScreenshot(String inMessage) {
        String consoleMessage = inMessage;
        if(ConfigFileReader.ConfigProperties.SCREENSHOT_ON_PASS){
            String screenpath = captureScreenshot("rp_screenshot");
            File screenshot = new File(screenpath);
            ReportPortal.emitLog(inMessage, "INFO", Calendar.getInstance().getTime(), screenshot);
        }else{
            ReportPortal.emitLog(inMessage, "INFO", Calendar.getInstance().getTime());
        }
        Reporter.log(inMessage);
        if (BasePage.test != null) {
            BasePage.test.log(Status.INFO, inMessage);
        }
    }
    public static void logErrorMessage(String inMessage, Boolean bold) {
        String reportMessage = inMessage;
        String consoleMessage = inMessage;
        if (bold) {
            reportMessage = "<strong>" + inMessage + "</strong>";
        }

        String screenpath = captureScreenshot("rp_screenshot");
        File screenshot = new File(screenpath);
        ReportPortal.emitLog(inMessage, "ERROR", Calendar.getInstance().getTime(), screenshot);
        log.error(consoleMessage);
        Reporter.log(reportMessage);
        if (BasePage.test != null) {
            BasePage.test.log(Status.INFO, reportMessage);
        }
    }
}
