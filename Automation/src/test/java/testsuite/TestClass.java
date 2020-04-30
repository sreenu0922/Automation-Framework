package testsuite;

import org.openqa.selenium.remote.server.handler.interactions.touch.Down;
import org.testng.annotations.Test;


public class TestClass extends HelperClass{

    public String useremail = "bhavya444@care.com";
    public String userpass = "letmein1";
    public String bussinessName = "google";
    public String zipcode = "02451";
    public String phoneNumber = "9989089089";
    public String totaldailycost = "$2.20";
	
	public void loginTest() throws Throwable{
		navigateToUat();
		login();
		
	}
	
	@Test (priority=1)
	public void enrollTest() throws Throwable{
		
		//Setting UAT25
		navigateToUat();
		
		//Navigate to enroll screen
		navigateToEnroll();
		
		
	
		//Seect company for enroll
        selectCompanySearch("acme", 80, 100);
		
		Thread.sleep(2000);
		
		//enroll with type birthdate,firstname, lastname,homeaddress, zip, email,password and click on enrollbutton
		
		enroll();
		// app was display apache error skip that error
		 if(isElementDisplayed(Unauthorised,"Unauthorised"))
	        {
	            APacheError();
	        }
	}
	
	//Dashboard screen after login or enroll
	@Test (priority=2)
	public void myKidTest() throws Throwable{
		
		// selecting my kid option
		mykid();

        //Selecting BackupDays
        navigatetousemybackupdays();
        
        navigatetoBookNow() ;
        clickno();

        //Selecting the date
        selectdate( "May", "04", "2020");

        //Selecting the time
        selecttime("08:30 AM", "05:00 PM");

        //Selecting the Chaild
        selectchild();
        Thread.sleep(2000);
        selectchild();
        //selectchild();
       // SelectChild();

        //Selecting the reasons for Care
        CareReason("My regular care is unavailable.");

        //Selecting In-Center
        CareType("In-center");
        
	}
	
	
	
	
	/*After select in-center app have two flows one for recommand another for A child care of my choosing
	below method for A child care of my choosing
	*/
	@Test (priority=3)
	public void childCareOfMyChoosingTest() throws Throwable{
        
	
        navigateToAboutYourCenter();
        addNetworkCenter("BussinessName","02541", "1234567890"," 1205");

        navigateToReviewYourClaim() ;
        
        
        navigateToYouAreAllSet();
        
        navigateBackToHome() ;
        
	}



    //@Sangeetha and Vinay
    @Test
    public void test() throws Throwable {
        //Written by Sangeetha Nulu and Vinay Gajula

        //Navigate to UAT25
        navigateToUat();

        //Clicking on login
        login(useremail,userpass, 80, 150);

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

        //Clicking Next button
        next();


        //Adding Primary Contact
        addPrimmaryContact( "9533679769","Mother");

        //Adding Backup Contact1
        addBkpContact("Vinay","Vanhi","9533679769","MOULA ALI","HYDERABAD","02451","Father");

        //Adding Backup Contact2
        addBkpContact2("Sangeetha","Nulu","9533679769","Hitech","HYDERABAD","02451","Mother");

        //Adding Pediatrician
        addPediatricianInfo("FamousDoctor","9533679769","04/25/2020");

        //Swiping Down
        Swipedown();

        //Adding Hospital Info
        addHospitalInfo("fernandez","Bogulkunta","Hyderabad","02451");

        //Swiping Down
        Swipedown();

        //Adding Insurance info
        addInsuranceInfo("StarHealth","87766554433");

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

        selectQuestion("Medication2",false);

        //Final Step Billing
        //billing();

    }

    @Test
    public void Test() throws Throwable {
         //@author :  Bhavya and Archana
         //@scenario : Login->myKid->use my backup days->Add Chidren-> my regular care is unavailable->in centre->A child care of my choosing->____-> Payment

        //Navigate to UAT25
        navigateToUat();
        Thread.sleep(3000);
        //Clicking on login
        login(useremail,userpass, 80, 100);
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
        selectdate( "May", "01", "2020");
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
