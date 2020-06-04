package testsuite.Scripts;

import accelerators.TestEngine;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.CommonDataProvider;
import support.HtmlReportSupport;
import support.Reporter;
import testsuite.HelperClass;
import support.Logger;

import java.util.Hashtable;

public class CareEndtoEnd extends HelperClass {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddNetWorkCenterWhenRegularcareisUnavailable.class);

    @Test(dataProvider = "getTestData")
    public void testEndtoEndCareScenario(Hashtable<String, String> data) throws Throwable {
        //@author :  Vinay Gajula and Sangeetha
         //@scenario : Login->myKid->use my backup days->Add Chidren-> my regular care is unavailable->in centre->A Care@Work Backup Care center->selectCareCenter-->addPrimmaryContact-->addBkpContact-->addBkpContact2-->addPediatricianInfo-->addHospitalInfo-->addInsuranceInfo-->navigateToAllergiesQuestion-->SelectingPhysical-->billing
        logInfoMessage("Care Login to Payment End to End Scenario");
        try {
            TestEngine.testDescription
                    .put(HtmlReportSupport.tc_name, " TC-02 Case 2 : Care Login to Payment End to End Scenario");
            Logger.logInfoMessage("Navigate to UAT25");
            navigateToUat();
            Logger.logInfoMessage("Clicking on login");
            login(data.get("userEmail"),data.get("userPass") ,Integer.parseInt(data.get("xcod")), Integer.parseInt(data.get("ycod")));
            Logger.logInfoMessage("Handing Apache Error");
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
            selectdate( data.get("month"),data.get("day"),data.get("year"));
            Logger.logInfoMessage("Selecting the time");
            selecttime(data.get("from"),data.get("to"));
            Logger.logInfoMessage("Selecting the Child");
            SelectChild();
            Logger.logInfoMessage("Selecting the reasons for Care");
            CareReason(data.get("careReason"));
            Logger.logInfoMessage("Selecting In-Center");
            CareType(data.get("careType"));
            Logger.logInfoMessage("Recomended");
            navigateToPreferredCenters();
            Logger.logInfoMessage("popup handling");
            popuphandling();
            Logger.logInfoMessage("Selecting the Tender loving Child Care Center");
            selectCareCenter(Integer.parseInt(data.get("selectCareCenter")));
            Logger.logInfoMessage("Clicking Next button");
            next();
            Logger.logInfoMessage("Adding Primary Contact");
            addPrimmaryContact(data.get("phoneNumber0"), data.get("relationship1"));
            Logger.logInfoMessage("Adding Backup Contact1");
            addBkpContact(data.get("firstName1"),data.get("lastName1"),data.get("phoneNumber1"),data.get("address11"),data.get("address21"),data.get("zip1"),data.get("relationship1"));
            Logger.logInfoMessage("Adding Backup Contact2");
            addBkpContact2(data.get("firstName2"),data.get("lastName2"),data.get("phoneNumber2"),data.get("address12"),data.get("address22"),data.get("zip2"),data.get("relationship2"));
            Logger.logInfoMessage("Adding Pediatrician");
            addPediatricianInfo(data.get("pediatricianName"),data.get("number"),data.get("Date"));
            Logger.logInfoMessage("Swiping Down");
            Swipedown();
            Logger.logInfoMessage("Adding Hospital Info");
            addHospitalInfo(data.get("hospitalName"),data.get("address13"),data.get("address23"),data.get("zip3"));
            Logger.logInfoMessage("Swiping Down");
            Swipedown();
            Logger.logInfoMessage("Adding Insurance info");
            //addInsuranceInfo("StarHealth","87766554433");
            addInsuranceInfo(data.get("insuranceCompany"),data.get("policyNumber"));
            Logger.logInfoMessage("Navigate to next");
            navigateToAllergiesQuestion();
            Logger.logInfoMessage("Selecting the question then click Yes or No");
            selectQuestion(data.get("selectQstnType1"), false);
            Logger.logInfoMessage("Select SpecialNeedInfo");
            SelectingPhysical();
            Logger.logInfoMessage("Navigate to next");
            navigateToAllergiesQuestion();
            Logger.logInfoMessage("Selecting Questions");
            selectQuestion(data.get("selectQstnType2"),false);
            selectQuestion(data.get("selectQstnType3"),false);
            selectQuestion(data.get("selectQstnType4"),false);
            //Final Step Billing
            //billing();
            flag = true;
        }
        catch (Exception e) {
            Reporter.failureReport("Care End to End Scenario",
                    "Failed with ");
            e.printStackTrace();
            flag = false;
        }finally {
            if (flag) {
                Reporter.SuccessReport("Executed Care End to End Scenario",
                        "Sucessful");
                Logger.logInfoMessage("Executed Care End to End Scenario Sucessfully");
            } else {
                Logger.logInfoMessage("Failed to Execute Care End to End Scenario");
                Reporter.failureReport("Care End to End Scenario",
                        "Failed to Execute Care End to End Scenario");
                Assert.assertTrue(flag == true,
                        "Failed to Execute Care End to End Scenario");
            }
        }
    }

    @DataProvider
    public static Object[][] getTestData() {
        return CommonDataProvider.getData("careendtoend");
    }
}
