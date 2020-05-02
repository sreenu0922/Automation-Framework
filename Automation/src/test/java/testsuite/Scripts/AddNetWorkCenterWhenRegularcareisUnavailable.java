package testsuite.Scripts;

import accelerators.TestEngine;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.CommonDataProvider;
import support.HtmlReportSupport;
import support.Reporter;
import testsuite.HelperClass;

import java.util.Hashtable;

public class AddNetWorkCenterWhenRegularcareisUnavailable extends HelperClass {

    @Test(dataProvider = "getTestData")
    public void TestAddNetWorkCenterWhenRegularcareisUnavailable(Hashtable<String, String> data) throws Throwable {
        //@author :  Bhavya and Archana
        //@scenario : Login->myKid->use my backup days->Add Chidren-> my regular care is unavailable->in centre->A child care of my choosing->____-> Payment

        try {
            TestEngine.testDescription
                    .put(HtmlReportSupport.tc_name, " TC-01 Case 1 : Add the NetworkCenter When regular care is unavailable");
            //Navigate to UAT25
            navigateToUat();
            Thread.sleep(3000);
            //Clicking on login
            login(data.get("useremail"), data.get("userpass"), 80, 100);
            if (isElementDisplayed(Unauthorised, "Unauthorised")) {
                APacheError();
            }
            //Selecting Mykid
            mykid();
            //Selecting BackupDays
            navigatetousemybackupdays();
            //Clicking BookNow button
            navigatetoBookNow();
            //Clicking No Button
            clickno();
            //Selecting the date
            selectdate("May", "03", "2020");
            //Selecting the time
            selecttime("08:30 AM", "05:00 PM");
            //Selecting the Chaild
            SelectChild();
            //Selecting the reasons for Care
            CareReason("My regular care is unavailable.");
            //Selecting In-Center
            CareType("In-center");
            //click on a child care of center of my choosing
            navigateToAboutYourCenter();
            //tell us about ur center
            addNetworkCenter(data.get("bussinessName"), data.get("zipcode"), data.get("phoneNumber"), data.get("totaldailycost"));
            //click on next button
            navigateToReviewYourClaim();
            //click on ur all set
            navigateToYouAreAllSet();
            //click on abck home
            navigateBackToHome();
            flag = true;
        }
        catch (Exception e) {
            Reporter.failureReport("Add the NetWork Center when Regular care is unavailable ",
                    "Failed with ");
            e.printStackTrace();
            flag = false;
        }finally {
            if (flag) {
                Reporter.SuccessReport("Added the NetWork Center when Regular care is unavailable",
                        "was  Sucessful with ");
            } else {

                Reporter.failureReport("Added the NetWork Center when Regular care is unavailable",
                        "Failed to Add the NetWork Center when Regular care is unavailable");
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