package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_17_Contactus_CommunityUser extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC17_Contactus_CommunityUser(String emailid, String passwd, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			login(emailid, passwd, "menu");
			verifyContactUs(emailid, "menu");
			verifyContactUs(emailid, "footer");
			Reporter.SuccessReport("TC17_Contactus_CommunityUser", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC17_Contactus_CommunityUser", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 2"),
	    			xls.getCellValue("Password", "Value 2"),
	    			"Verify Contact us functionality from Menu and footer for Community User"
	    		}};
	}

}
