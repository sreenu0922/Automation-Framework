package testsuite;

import org.testng.annotations.Test;

public class TestClass extends HelperClass{

    public String useremail = "bhavya444@care.com";
    public String userpass = "letmein1";
    public String bussinessName = "google";
    public String zipcode = "02451";
    public String phoneNumber = "9989089089";
    public String totaldailycost = "$2.20";
    @Test
    public void Test() throws Throwable {
        /* @author :  Bhavya and Archana
           @scenario : Login->myKid->use my backup days->Add Chidren-> my regular care is unavailable->in centre->A child care of my choosing->____-> Payment */

        //Navigate to UAT25
        navigateToUat();

        Thread.sleep(3000);
        //Clicking on login

        login(useremail,userpass);
        if(isElementDisplayed(Unauthorised,"Unauthorised"))
        {
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
        selectdate( "Apr", "30", "2020");

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
        addNetworkCenter(bussinessName,zipcode, phoneNumber, totaldailycost);
        //click on next button
        navigateToReviewYourClaim();
        //click on ur all set
        navigateToYouAreAllSet();
        //click on abck home
        navigateBackToHome();

    }
}
