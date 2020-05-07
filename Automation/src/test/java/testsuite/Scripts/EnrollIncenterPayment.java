package testsuite.Scripts;

import accelerators.TestEngine;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.CommonDataProvider;
import support.HtmlReportSupport;
import testsuite.HelperClass;

import java.util.Hashtable;

public class EnrollIncenterPayment extends HelperClass {

    @Test(dataProvider = "getTestData")
    public void testEnrollIncenterPayment(Hashtable<String, String> data) throws Throwable {
        TestEngine.testDescription
                .put(HtmlReportSupport.tc_name, " TC-02 Case 1 :To enroll , select the incentre and complete the payment");
        navigateToUat();
        navigateToEnroll();
        selectCompanySearch(data.get("company"), Integer.parseInt(data.get("xcord")), Integer.parseInt(data.get("ycord")));
        enroll(data.get("enrollbirthdate"),data.get("enrollfirstname"),data.get("enrolllastname"),data.get("enrolladdress"),data.get("enrollzip"),data.get("enrollusername"),data.get("enrollpassword"));
        click(done, "done");
        CareReason(data.get("careto"));
        navigatetousemybackupdays();
        navigatetoBookNow();
        clickno();
        selectdate(Integer.parseInt(data.get("days")));
        selecttime(data.get("fromtime"),data.get("totime"));
        selectchild(data.get("childfirstname"), data.get("childlastname"), data.get("childbirthdate"), data.get("gender"));
        CareReason(data.get("carereason"));
        CareType (data.get("caretype"));
        click(txRecommed,"reco");
        refreshPreferedCenters(data.get("centerzipcode"),data.get("range"));
        selectCareCenter(Integer.parseInt(data.get("carecenter")));
        navigateToEmergenyContact();
        addPrimmaryContact(data.get("primarycontactno"),data.get("primarycontactrelation"));
        selectBackupContact(1);
        addBackupContact(data.get("backupcontact1firstname"),data.get("backupcontact1lastname"),data.get("backupcontact1no"),data.get("backupcontact1address1"),data.get("backupcontact1address2"),data.get("backupcontact1zip"),data.get("backupcontact1relation"),true);
        selectBackupContact(2);
        addBackupContact(data.get("backupcontact2firstname"),data.get("backupcontact2lastname"),data.get("backupcontact2no"),data.get("backupcontact2address1"),data.get("backupcontact2address2"),data.get("backupcontact2zip"),data.get("backupcontact2relation"),true);
        navigateToPediatrician();
        addPediatricianInfo(data.get("pediatricianname"),data.get("pediatricianno"),data.get("pediatricianvisit"));
        addHospitalInfo(data.get("hospitalname"),data.get("hospitaladdress1"),data.get("hospitaladdress2"),data.get("hospitalzip"));
        addInsuranceInfo(data.get("insurancename"),data.get("insuranceno"));
        navigateToAllergiesQuestion();
        selectQuestion(data.get("question1"),Boolean.parseBoolean(data.get("allergies")));
        selectSpecialNeedInfo(Integer.parseInt(data.get("specailcare")));
        selectQuestion(data.get("question2"),Boolean.parseBoolean(data.get("medication")));
        selectQuestion(data.get("question3"),Boolean.parseBoolean(data.get("medication")));
        selectQuestion(data.get("question4"),Boolean.parseBoolean(data.get("photos")));
        //billing();

    }

    @DataProvider
    public static Object[][] getTestData() {
        return CommonDataProvider.getData("enrollpayment");
    }
}
