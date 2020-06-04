package testsuite.Scripts;

import accelerators.TestEngine;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.CommonDataProvider;
import support.HtmlReportSupport;
import support.Logger;
import support.Reporter;
import testsuite.HelperClass;

import java.util.Hashtable;

public class AddNetWorkCenterWhenRegularcareisUnavailable extends HelperClass {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddNetWorkCenterWhenRegularcareisUnavailable.class);

    @Test(dataProvider = "getTestData")
    public void TestAddNetWorkCenterWhenRegularcareisUnavailable(Hashtable<String, String> data) throws Throwable {
        //@author :  Bhavya and Archana
        //@scenario : Login->myKid->use my backup days->Add Chidren-> my regular care is unavailable->in centre->A child care of my choosing->____-> Payment
        logInfoMessage("Test add the NetworkCenter When regular care is unavailable scenario");
        try {
            TestEngine.testDescription
                    .put(HtmlReportSupport.tc_name, " TC-01 Case 1 : Add the NetworkCenter When regular care is unavailable");
            Logger.logInfoMessage("Navigated to Uat25");
            navigateToUat();
            Logger.logInfoMessage("Clicking on login");
            login(data.get("userEmail"), data.get("userPass"), Integer.parseInt(data.get("xcod")), Integer.parseInt(data.get("ycod")));
            if (isElementDisplayed(Unauthorised, "Unauthorised")) {
                APacheError();
            }
            Logger.logInfoMessage("Selecting Mykid");
            mykid();
            Logger.logInfoMessage("Selecting BackupDays");
            navigatetousemybackupdays();
            Logger.logInfoMessage("Clicking BookNow button");
            navigatetoBookNow();
            Logger.logInfoMessage("Clicking No Button");
            clickno();
            Logger.logInfoMessage("Selecting the date");
            selectdate(data.get("month"), data.get("day"), data.get("year"));
            Logger.logInfoMessage("Selecting the time");
            selecttime(data.get("from"), data.get("to"));
            Logger.logInfoMessage("Selecting the Chaild");
            SelectChild();
            Logger.logInfoMessage("Selecting the reasons for Care");
            CareReason(data.get("careReason"));
            Logger.logInfoMessage("Selecting In-Center");
            CareType(data.get("careType"));
            Logger.logInfoMessage("click on a child care of center of my choosing");
            navigateToAboutYourCenter();
            Logger.logInfoMessage("tell us about ur center");
            addNetworkCenter(data.get("bussinessName"), data.get("zipCode"), data.get("phoneNumber"), data.get("totalDailyCost"));
            Logger.logInfoMessage("click on next button");
            navigateToReviewYourClaim();
            Logger.logInfoMessage("click on ur all set");
            navigateToYouAreAllSet();
            Logger.logInfoMessage("click on back home");
            navigateBackToHome();
            flag = true;
        }
        catch (Exception e) {
            Reporter.failureReport("Add the NetWork Center when Regular care is unavailable ",
                    "Failed ");
            Logger.logInfoMessage("Add the NetWork Center when Regular care is unavailable Failed");
            e.printStackTrace();
            flag = false;
        }finally {
            if (flag) {
                Reporter.SuccessReport("Added the NetWork Center when Regular care is unavailable",
                        "was  Sucessful ");
                Logger.logInfoMessage("Added the NetWork Center when Regular care is unavailable was Sucessful");
            } else {

                Reporter.failureReport("Added the NetWork Center when Regular care is unavailable",
                        "Failed to Add the NetWork Center when Regular care is unavailable");
                Logger.logInfoMessage("Failed to Add the NetWork Center when Regular care is unavailable");
                Assert.assertTrue(flag == true,
                        "Failed to Add the NetWork Center when Regular care is unavailable");
            }
        }
    }

    @DataProvider
    public static Object[][] getTestData() {
        return CommonDataProvider.getData("addnetworkcenter");
    }
}