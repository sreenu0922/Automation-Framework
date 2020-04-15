package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_04_ForgotPwdChangePwd_SiteAdmin  extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC04_ForgotPwdChangePwd_SiteAdmin(String emailid, String emailpwd, String currentpwd, String newpwd, 
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			forgotPassword(emailid, emailpwd, newpwd);
			changePassword(emailid, currentpwd, newpwd);
			
			Reporter.SuccessReport("TC04_ForgotPwdChangePwd_SiteAdmin", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC04_ForgotPwdChangePwd_SiteAdmin", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Email Password", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("New Password", "Value 1"),
	    			"Verfiy Forgot Password and change Password fucntionaity for Site Admin"
	    		}};
	}
}
