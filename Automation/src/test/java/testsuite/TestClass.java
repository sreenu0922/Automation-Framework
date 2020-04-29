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
        selectdate( "Apr", "30", "2020");

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

        //Selecting the next buttion
        next();

       /* //Primary Contact
        addPrimmaryContact( "9533769769","Mother");*/

       //Primary Contact Next button
        Primarynext();
/*

        //Backup Contact1
        addBackupContact("Vinay","gajula","9533679878","String address1","String address2","String city","Mother",false);
        //Backup Contact2
        addBackupContact("Vinay","gajula","9533679878","String address1","String address2","String city","Mother",false);

        //Added Pediatrician
        addPediatricianInfo("Sangeetha","9876987989","30-04-2020");

        //Hospital Info
        addHospitalInfo("hospitalName","address","address1","02451");

       //Insurance info
        addInsuranceInfo("StarHealth","9754544553677377388");*/

        //Hide Keyboard
        hideKeyboard();
        //Ped insurance next
        navigateToNext1();

        //To launch the keyboard
        //launchKeyboard();

        //Selecting Yes or No
        selectQuestion("No button", false);

        //Select SpecialNeedInfo
        SelectingPhysical();

        //Next Navigate
        navigateToNext();

        //Selecting Questions
        selectQuestion("Medication",false,"false");
        Thread.sleep(2000);
        selectQuestion("Medication1",false,"false");
        Thread.sleep(2000);
        selectQuestion("Medication2",false,"false");
        Thread.sleep(2000);
        selectQuestion("Medication2",false,"false");
        Thread.sleep(2000);

        //Final Step Billing
        billing();
    }
}
