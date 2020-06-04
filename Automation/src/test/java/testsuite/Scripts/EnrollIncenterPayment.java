package testsuite.Scripts;

import accelerators.TestEngine;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.CommonDataProvider;
import support.HtmlReportSupport;
import support.Reporter;
import testsuite.HelperClass;
import support.Logger;

import java.util.Hashtable;

public class EnrollIncenterPayment extends HelperClass {

    @Test(dataProvider = "getTestData")
    public void testEnrollIncenterPayment(Hashtable<String, String> data) throws Throwable {
        logInfoMessage(" Test To enroll , select the in-centre and complete the payment");
        try {
        TestEngine.testDescription
                .put(HtmlReportSupport.tc_name, " TC-04 Case 4  :To enroll , select the in-centre and complete the payment");
        Logger.logInfoMessage("Setting UAT25");
        navigateToUat();
        Logger.logInfoMessage("Enroll the user");
        navigateToEnroll();
        selectCompanySearch(data.get("company"), Integer.parseInt(data.get("xcord")), Integer.parseInt(data.get("ycord")));
        enroll(data.get("enrollbirthdate"),data.get("enrollfirstname"),data.get("enrolllastname"),data.get("enrolladdress"),data.get("enrollzip"),data.get("enrollusername"),data.get("enrollpassword"));
        click(done, "done");
        Logger.logInfoMessage("Selecting Care Reason");
        CareReason(data.get("careto"));
        Logger.logInfoMessage("Navigate to use my backupdays");
        navigatetousemybackupdays();
        Logger.logInfoMessage("Navigate to BookNow");
        navigatetoBookNow();
        clickno();
        Logger.logInfoMessage("Select Date");
        selectdate(Integer.parseInt(data.get("days")));
        Logger.logInfoMessage("Select time");
        selecttime(data.get("fromtime"),data.get("totime"));
        Logger.logInfoMessage("Select child");
        selectchild(data.get("childfirstname"), data.get("childlastname"), data.get("childbirthday"), data.get("childtype"));
        Logger.logInfoMessage("Select Care Reason");
        CareReason(data.get("carereason"));
        Logger.logInfoMessage("Select Care Type");
        CareType (data.get("caretype"));
        click(txRecommed,"reco");
        Logger.logInfoMessage("Refresh Prefered Centers");
        refreshPreferedCenters(data.get("centerzipcode"),data.get("range"));
        Logger.logInfoMessage("Select Care Center");
        selectCareCenter(Integer.parseInt(data.get("carecenter")));
        Logger.logInfoMessage("Navigate To Emergeny Contact");
        navigateToEmergenyContact();
        Logger.logInfoMessage("Add Primmary Contact");
        addPrimmaryContact(data.get("primarycontactno"),data.get("primarycontactrelation"));
        Logger.logInfoMessage("Add Back Up Contacts");
        addBkpContact(data.get("firstName1"),data.get("lastName1"),data.get("phoneNumber1"),data.get("address11"),data.get("address21"),data.get("zip1"),data.get("relationship1"));
        addBkpContact2(data.get("firstName2"),data.get("lastName2"),data.get("phoneNumber2"),data.get("address12"),data.get("address22"),data.get("zip2"),data.get("relationship2"));
        Logger.logInfoMessage("Add Pediatrician Info");
        addPediatricianInfo(data.get("pediatricianname"),data.get("pediatricianno"),data.get("pediatricianvisit"));
        Logger.logInfoMessage("Add Hospital Info");
        addHospitalInfo(data.get("hospitalname"),data.get("hospitaladdress1"),data.get("hospitaladdress2"),data.get("hospitalzip"));
        Logger.logInfoMessage("Add Insurance Info");
        addInsuranceInfo(data.get("insurancename"),data.get("insuranceno"));
        Logger.logInfoMessage("Navigate To Allergies Question");
        navigateToAllergiesQuestion();
        Logger.logInfoMessage("Select Questions");
        selectQuestion(data.get("question1"),Boolean.parseBoolean(data.get("allergies")));
        selectSpecialNeedInfo(Integer.parseInt(data.get("specailcare")));
        selectQuestion(data.get("question2"),Boolean.parseBoolean(data.get("medication")));
        selectQuestion(data.get("question3"),Boolean.parseBoolean(data.get("medication")));
        selectQuestion(data.get("question4"),Boolean.parseBoolean(data.get("photos")));
        flag = true;
       }
        catch (Exception e) {
            Reporter.failureReport("To enroll , select the in-centre and complete the payment",
                    "Failed ");
            Logger.logInfoMessage("Failed To enroll , select the in-centre and complete the payment");
            e.printStackTrace();
            flag = false;
        }finally {
            if (flag) {
                Reporter.SuccessReport("To enroll , select the in-centre and complete the payment",
                        " was Sucessful ");
                Logger.logInfoMessage("To enroll , select the in-centre and complete the payment was Sucessful");
            } else {
                Reporter.failureReport("To enroll , select the in-centre and complete the payment",
                        "Failed to enroll , select the in-centre and complete the payment");
                Logger.logInfoMessage("Failed to enroll , select the in-centre and complete the payment");
                Assert.assertTrue(flag == true,
                        "Failed to enroll , select the in-centre and complete the payment");
            }
        }
    }

    @DataProvider
    public static Object[][] getTestData() {
        return CommonDataProvider.getData("enrollpayment");
    }
}
