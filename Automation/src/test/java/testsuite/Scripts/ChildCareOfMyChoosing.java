package testsuite.Scripts;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import accelerators.TestEngine;
import support.CommonDataProvider;
import support.HtmlReportSupport;
import support.Reporter;
import testsuite.HelperClass;

public class ChildCareOfMyChoosing extends HelperClass {
	
	@Test (dataProvider = "getTestData")
		public void enrollTest(Hashtable<String, String> data) throws Throwable{
			
		  try {
	            TestEngine.testDescription
	                    .put(HtmlReportSupport.tc_name, " TC-01 Case 2 : A child care of my choosing");
	            	
		//Setting UAT25
			navigateToUat();
			
			//Navigate to enroll screen
			navigateToEnroll();

			//Seect company for enroll
	        selectCompanySearch(data.get("CompanyName"), 80, 100);
			
			Thread.sleep(2000);
			
			//enroll with type birthdate,firstname, lastname,homeaddress, zip, email,password and click on enrollbutton
			
		//enroll();
			enroll( data.get("birthdate"), data.get("firstname"), data.get("lastname"), data.get("homeaddress"), data.get("zip"), data.get("email"), data.get("password"));
			
		            APacheError();
		       
			
			// selecting my kid option
			mykid();

	        //Selecting BackupDays
	        navigatetousemybackupdays();
	        
	        navigatetoBookNow() ;
	        clickno();

	        //Selecting the date
	        selectdate( data.get("Month"), data.get("date"), data.get("year"));

	        //Selecting the time
	        selecttime(data.get("fromdate"), data.get("todate"));

	        //Selecting the Chaild
	        selectchild();
	       
	        //Selecting the reasons for Care
	        CareReason("My regular care is unavailable.");

	        //Selecting In-Center
	        CareType("In-center");
	        	
	        navigateToAboutYourCenter();
	        addNetworkCenter(data.get("bussinessName"), data.get("zipcode"), data.get("phoneNumber"), data.get("totaldailycost"));

	        navigateToReviewYourClaim() ;
	        
	        
	        navigateToYouAreAllSet();
	        
	        navigateBackToHome() ;
	        
	        flag = true;
	        }
	        catch (Exception e) {
	            Reporter.failureReport(" when Regular care is unavailable ",
	                    "Failed with ");
	            e.printStackTrace();
	            flag = false;
	        }finally {
	            if (flag) {
	                Reporter.SuccessReport("Added the NetWork Center when Regular care is unavailable",
	                        "was  Sucessful with ");
	            } else {

	                Reporter.failureReport("Added the NetWork Center when Regular care is unavailable",
	                        "Failed to Add the NetWork Center when Regular care is unavailable");
	                Assert.assertTrue(flag == true,
	                        "Failed to Add the NetWork Center when Regular care is unavailable");
	            }
	        }
	    }

	  

		@DataProvider
	    public static Object[][] getTestData() {
	        return CommonDataProvider.getData("mychoosing");
	    }


	
	
}
