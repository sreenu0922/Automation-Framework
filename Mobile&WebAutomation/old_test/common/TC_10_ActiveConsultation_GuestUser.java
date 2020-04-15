package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_10_ActiveConsultation_GuestUser extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC10_ActiveConsultation_GuestUser(String emailid, String passwd, String consultationname,
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			login(emailid, passwd, "Footer");
			Thread.sleep(5000);
			navigateConsultation(consultationname);
			Reporter.SuccessReport("TC10_ActiveConsultation_GuestUser", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC10_ActiveConsultation_GuestUser", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
    		{
    			xls.getCellValue("Email Id", "Value 3"),
    			xls.getCellValue("Password", "Value 3"),
    			xls.getCellValue("Consultation Name", "Value 3"),
    			"Verify navigation to Active Project from Home for Guest User"
    		}};
	}

}
