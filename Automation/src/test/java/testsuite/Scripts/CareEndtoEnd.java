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

public class CareEndtoEnd extends HelperClass {
    @Test(dataProvider = "getTestData")
    public void testEndtoEndCareScenario(Hashtable<String, String> data) throws Throwable {
        //@author :  Vinay Gajula and Sangeetha
        
        //@scenario : Login->myKid->use my backup days->Add Chidren-> my regular care is unavailable->in centre->A Care@Work Backup Care center->selectCareCenter-->addPrimmaryContact-->addBkpContact-->addBkpContact2-->addPediatricianInfo-->addHospitalInfo-->addInsuranceInfo-->navigateToAllergiesQuestion-->SelectingPhysical-->billing

        try {
            TestEngine.testDescription
                    .put(HtmlReportSupport.tc_name, " TC-02 Case 2 : Care Login to Payment End to End Scenario");
            //Navigate to UAT25
            navigateToUat();
            //Clicking on login
            login(data.get("useremail"),data.get("userpass") ,80, 150);
            //Handing Apache Error
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
            selectdate( data.get("month"),data.get("day"),data.get("year"));
            //Selecting the time
            selecttime("08:30 AM", "05:00 PM");
            //Selecting the Child
            SelectChild();
            //Selecting the reasons for Care
            CareReason("My regular care is unavailable.");
            //Selecting In-Center
            CareType("In-center");
            //Recomended
            navigateToPreferredCenters();
            //popup handling
            popuphandling();
            //Selecting the Tender loving Child Care Center
            selectCareCenter(3);
            //Clicking Next button
            next();
            //Adding Primary Contact
            addPrimmaryContact(data.get("phoneNumber0"), data.get("relationship1"));
            //Adding Backup Contact1
            addBkpContact(data.get("firstName1"),data.get("lastName1"),data.get("phoneNumber1"),data.get("address11"),data.get("address21"),data.get("zip1"),data.get("relationship1"));
            //Adding Backup Contact2
            addBkpContact2(data.get("firstName2"),data.get("lastName2"),data.get("phoneNumber2"),data.get("address12"),data.get("address22"),data.get("zip2"),data.get("relationship2"));
            //Adding Pediatrician
            //addPediatricianInfo("FamousDoctor","9533679769","04/25/2020");
            addPediatricianInfo(data.get("pediatricianName"),data.get("number"),data.get("Date"));
            //Swiping Down
            Swipedown();
            //Adding Hospital Info
            //addHospitalInfo("fernandez","Bogulkunta","Hyderabad","02451");
            addHospitalInfo(data.get("hospitalName"),data.get("address13"),data.get("address23"),data.get("zip3"));
            //Swiping Down
            Swipedown();
            //Adding Insurance info
            //addInsuranceInfo("StarHealth","87766554433");
            addInsuranceInfo(data.get("insuranceCompany"),data.get("policyNumber"));
            //Navigate to next
            navigateToAllergiesQuestion();
            //Selecting the question then click Yes or No
            selectQuestion("No button", false);
            //Select SpecialNeedInfo
            SelectingPhysical();
            //Navigate to next
            navigateToAllergiesQuestion();
            //Selecting Questions
            selectQuestion("Medication",false);
            selectQuestion("Medication1",false);
            selectQuestion("Medication2",false);

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
            } else {

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