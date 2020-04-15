package com.desktopWeb.scripts.roles_permission;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_182_Verify_Dashboard_Create_Community_User_En extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Dashboard");
	
	@Test(dataProvider = "testData")
	public void TC182_Verify_Dashboard_Create_Community_User_En(String emailid, String passwd, String issiteuser, String issiteadmin, 
			String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToDashboardMembers();
			addUser(issiteuser, issiteadmin);
			Reporter.SuccessReport("TC182_Verify_Dashboard_Create_Community_User_En", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC182_Verify_Dashboard_Create_Community_User_En", "Failed");
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
