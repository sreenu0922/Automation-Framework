package testsuite;

import accelerators.TestEngine;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.CommonDataProvider;
import support.HtmlReportSupport;
import support.Reporter;

import java.util.Hashtable;

public class TestClass extends HelperClass{

		
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

   }
