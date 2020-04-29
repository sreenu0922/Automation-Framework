package testsuite;

import org.testng.annotations.Test;

public class TestClass extends HelperClass{
	
	public void loginTest() throws Throwable{
		navigateToUat();
		login();
		
	}
	
	@Test
	public void enrollTest() throws Throwable{
		navigateToUat();
		
		navigateToEnroll();
		
		
		//selectCompanyforenroll("ACME");
		
		selectCompanySearch("acme");
		Thread.sleep(2000);
		
		enroll();
		
		 if(isElementDisplayed(Unauthorised,"Unauthorised"))
	        {
	            APacheError();
	        }
		
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
        
        //selectchild();
        SelectChild();

        //Selecting the reasons for Care
        CareReason("My regular care is unavailable.");

        //Selecting In-Center
        CareType("In-center");
        
        
        
        navigateToAboutYourCenter();
        addNetworkCenter("BussinessName","02541", "1234567890"," 1205");

        navigateToReviewYourClaim() ;
        
        swipe(AndroidDriver, DIRECTION.DOWN);
        navigateToYouAreAllSet();
        
        navigateBackToHome() ;
        
	}
	


}
