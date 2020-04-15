package com.desktopWeb.scripts.dashboard;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_97_Verify_Dashboard_Moderation_Awaiting_Reject extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Dashboard");
	
	@Test(dataProvider = "testData")
	public void TC97_Verify_Dashboard_Moderation_Awaiting_Reject(String emailid, String passwd, String projecttoaddcomment, 
			String projectcomment, String reason, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			projectcomment = projectcomment+getRandomString(6);
			login(emailid, passwd, "Menu");
			addCommenttoProject(projecttoaddcomment, projectcomment);
			navigateToModeration();
			String commentid = getCommentID(projectcomment);
			rejectAwaitingComment(commentid, projectcomment, reason);
			Reporter.SuccessReport("TC97_Verify_Dashboard_Moderation_Awaiting_Reject", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC97_Verify_Dashboard_Moderation_Awaiting_Reject", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("Project", "Value 1"),
	    			xls.getCellValue("Comment", "Value 1"),
	    			xls.getCellValue("Reason", "Value 1"),
	    			"Verify Dashboard_Moderation_Awaiting_Reject Options"
	    		}};
	}

}
