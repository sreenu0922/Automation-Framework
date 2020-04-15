package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_18_Contactus_GuestUser extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC18_Contactus_GuestUser(String emailid, String passwd, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			verifyContactUs(emailid, "menu");
			verifyContactUs(emailid, "footer");
			Reporter.SuccessReport("TC18_Contactus_GuestUser", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC18_Contactus_GuestUser", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 3"),
	    			xls.getCellValue("Password", "Value 3"),
	    			"Verify Contact us functionality from Menu and footer for Guest User"
	    		}};
	}

}
