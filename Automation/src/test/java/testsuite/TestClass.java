package testsuite;

import org.testng.annotations.Test;

public class TestClass extends HelperClass{

	
    	 //@Sangeetha and Vinay
        @Test
        public void test() throws Throwable {
            //Written by Sangeetha Nulu and Vinay Gajula

            //Navigate to UAT25
            navigateToUat();
            //Clicking on login
            

            //Clicking on login
            login("sangeethanulu@gmail.com","Letmein1");

            //Select Company Name
           // selectCompanySearch("acme");

            
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
            selectdate( "May", "02", "2020");

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
            
            //click on pop-up
            popuphandling();

            //Selecting the Tender loving Child Care Center
            selectCareCenter(3);

            //Selecting the next buttion
            navigateToEmergenyContact();

            //Primary Contact
            addPrimmaryContact( "9111111111","Mother");

            /*//Clicking Next
            navigateToEmergenyContact();
*/
            /*//Backup Contact1
            addBackupContact("sangeetha","nulu","9000000000","String address1","String address2","String city","Mother",false);

            //Backup Contact2
            addBackupContact("sangeetha","nulu","9222222222","String address1","String address2","String city","Mother",false);

           //clicking next button
            navigateToPediatrician();*/
            
          //Adding Backup Contact1
            addBkpContact("sangeetha","nulu","9222222222","kphb","HYDERABAD","02451","Mother");

            //Adding Backup Contact2
            addBkpContact2("sangeetha","nulu","9333333333","kphb","HYDERABAD","02451","Mother");

            //Adding Pediatrician
            addPediatricianInfo("Sangeetha","9876987989","04/25/2020");

            //Adding Hospital Info
            addHospitalInfo("lotus","kphb","hyderabad","02451");

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
