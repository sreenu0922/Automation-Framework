package testsuite;

import org.openqa.selenium.remote.server.handler.interactions.touch.Down;
import org.testng.annotations.Test;

public class TestClass extends HelperClass {

    //@Sangeetha and Vinay
    @Test
    public void test() throws Throwable {
        //Written by Sangeetha Nulu and Vinay Gajula

        //Navigate to UAT25
        navigateToUat();

        //Clicking on login
        login();

        //Select Company Name
        selectCompanyforenroll("acme");

        //Username and password
        loginsendkeys();

        //Handing Apache Error
        APacheError();

    //Selecting Mykid
        mykid();

        //Selecting BackupDays
        navigatetousemybackupdays();

        //Clicking BookNow button
        navigatetoBookNow();

        //Clicking No Button
        clickno();

        //Selecting the date
        selectdate( "May", "03", "2020");

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


        //Adding Primary Contact
        addPrimmaryContact( "9533769769","Mother");

        //Adding Backup Contact1
        addBkpContact("GAJULA","VINAY","9080099880","MOULA ALI","HYDERABAD","02451","Mother");

        //Adding Backup Contact2
        addBkpContact2("GAJULA","VINAY","9080099880","MOULA ALI","HYDERABAD","02451","Mother");

        //Adding Pediatrician
        addPediatricianInfo("Sangeetha","9876987989","04/25/2020");

        //Adding Hospital Info
        addHospitalInfo("fernandez","Moula Ali","hyderabad","02451");

       //Adding Insurance info
        addInsuranceInfo("StarHealth","87766554433");


        //Selecting the question then click Yes or No
        selectQuestion("No button", false);

        //Select SpecialNeedInfo
        SelectingPhysical();

        //Selecting Questions
        selectQuestion("Medication",false,"false");

        selectQuestion("Medication1",false,"false");

        selectQuestion("Medication2",false,"false");

        selectQuestion("Medication2",false,"false");


        //Final Step Billing
        billing();
    }
}
