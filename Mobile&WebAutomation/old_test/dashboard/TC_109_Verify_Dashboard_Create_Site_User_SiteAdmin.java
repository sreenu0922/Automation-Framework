package com.desktopWeb.scripts.dashboard;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_109_Verify_Dashboard_Create_Site_User_SiteAdmin extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Dashboard");
	
	@Test(dataProvider = "testData")
	public void TC109_Verify_Dashboard_Create_Site_User_SiteAdmin(String emailid, String passwd, String usertype, String issiteadmin, 
			String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToDashboardMembers();
			addUser(usertype, issiteadmin);
			Reporter.SuccessReport("TC109_Verify_Dashboard_Create_Site_User_SiteAdmin", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC109_Verify_Dashboard_Create_Site_User_SiteAdmin", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("SiteUserYes", "Value 1"),
	    			xls.getCellValue("SiteAdminYes", "Value 1"),
	    			"Verify Authoring/Dashboard/Member/Add Site User + Site Admin"
	    		}};
	}

}
