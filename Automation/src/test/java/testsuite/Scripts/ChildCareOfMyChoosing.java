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
import support.Logger;

public class ChildCareOfMyChoosing extends HelperClass {
	
	@Test (dataProvider = "getTestData")
		public void enrollTest(Hashtable<String, String> data) throws Throwable{
		logInfoMessage("Test A child care of my choosing");
		  try {
	            TestEngine.testDescription
	                    .put(HtmlReportSupport.tc_name, " TC-03 Case 3 : A child care of my choosing");
	        Logger.logInfoMessage("Setting UAT25");
			navigateToUat();
			Logger.logInfoMessage("Navigate to enroll screen");
			navigateToEnroll();
			Logger.logInfoMessage("Seect company for enroll");
	        selectCompanySearch(data.get("CompanyName"), Integer.parseInt(data.get("xcod")), Integer.parseInt(data.get("ycod")));
	        enroll( data.get("birthdate"), data.get("firstname"), data.get("lastname"), data.get("homeaddress"), data.get("zip"), data.get("email"), data.get("password"));
	        if (isElementDisplayed(Unauthorised, "Unauthorised")) {
				  APacheError();
	        }
	        Logger.logInfoMessage("selecting my kid option");
			mykid();
			Logger.logInfoMessage("Selecting BackupDays");
	        navigatetousemybackupdays();
	        navigatetoBookNow() ;
	        clickno();
			Logger.logInfoMessage("Selecting the date");
	        selectdate( data.get("Month"), data.get("date"), data.get("year"));
	        Logger.logInfoMessage("Selecting the time");
	        selecttime(data.get("fromdate"), data.get("todate"));
	        Logger.logInfoMessage("Selecting the Chaild");
			selectchild(data.get("childfirstname"), data.get("childlastname"), data.get("childbirthdate"), data.get("gender"));
			Logger.logInfoMessage("Selecting the reasons for Care");
	        CareReason(data.get("careReason"));
	        Logger.logInfoMessage("Selecting In-Center");
	        CareType(data.get("careType"));
	        navigateToAboutYourCenter();
	        addNetworkCenter(data.get("bussinessName"), data.get("zipcode"), data.get("phoneNumber"), data.get("totaldailycost"));
	        navigateToReviewYourClaim() ;
	        navigateToYouAreAllSet();
	        navigateBackToHome() ;
	        flag = true;
	        }
	        catch (Exception e) {
	            Reporter.failureReport(" When Regular care is unavailable ",
	                    "Failed");
	            e.printStackTrace();
	            flag = false;
	        }finally {
	            if (flag) {
					Logger.logInfoMessage("Added the NetWork Center when Regular care is unavailable Sucessfully");
	                Reporter.SuccessReport("NetWork Center when Regular care is unavailable",
	                        "Added Sucessfully");
	            } else {
					Logger.logInfoMessage("Failed to Add the NetWork Center when Regular care is unavailable");
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
