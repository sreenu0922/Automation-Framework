package com.desktopWeb.scripts.dashboard;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_110_Verify_Dashboard_Create_Community_User extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Dashboard");
	
	@Test(dataProvider = "testData")
	public void TC110_Verify_Dashboard_Create_Community_User(String emailid, String passwd, String issiteuser, String issiteadmin, 
			String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToDashboardMembers();
			addUser(issiteuser, issiteadmin);
			Reporter.SuccessReport("TC110_Verify_Dashboard_Create_Community_User", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC110_Verify_Dashboard_Create_Community_User", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("SiteUserNo", "Value 1"),
	    			xls.getCellValue("SiteAdminNo", "Value 1"),
	    			"Verify Authoring/Dashboard/Member/Add Community User"
	    		}};
	}

}
