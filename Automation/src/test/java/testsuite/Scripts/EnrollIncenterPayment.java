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
        selectchild(data.get("childfirstname"), data.get("childlastname"), data.get("childbirthday"), data.get("childtype"));
        CareReason(data.get("carereason"));
        CareType (data.get("caretype"));
        click(txRecommed,"reco");
        refreshPreferedCenters(data.get("centerzipcode"),data.get("range"));
        selectCareCenter(Integer.parseInt(data.get("carecenter")));
        navigateToEmergenyContact();
        addPrimmaryContact(data.get("primarycontactno"),data.get("primarycontactrelation"));
        addBkpContact(data.get("firstName1"),data.get("lastName1"),data.get("phoneNumber1"),data.get("address11"),data.get("address21"),data.get("zip1"),data.get("relationship1"));
        addBkpContact2(data.get("firstName2"),data.get("lastName2"),data.get("phoneNumber2"),data.get("address12"),data.get("address22"),data.get("zip2"),data.get("relationship2"));
        addPediatricianInfo(data.get("pediatricianname"),data.get("pediatricianno"),data.get("pediatricianvisit"));
        addHospitalInfo(data.get("hospitalname"),data.get("hospitaladdress1"),data.get("hospitaladdress2"),data.get("hospitalzip"));
        addInsuranceInfo(data.get("insurancename"),data.get("insuranceno"));
        navigateToAllergiesQuestion();
        selectQuestion(data.get("question1"),Boolean.parseBoolean(data.get("allergies")));
        selectSpecialNeedInfo(Integer.parseInt(data.get("specailcare")));
        selectQuestion(data.get("question2"),Boolean.parseBoolean(data.get("medication")));
        selectQuestion(data.get("question3"),Boolean.parseBoolean(data.get("medication")));
        selectQuestion(data.get("question4"),Boolean.parseBoolean(data.get("photos")));
    }

    @DataProvider
    public static Object[][] getTestData() {
        return CommonDataProvider.getData("enrollpayment");
    }
}
