package com.desktopWeb.scripts.tools;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_50_Verify_Authoring_Tools_Options extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Tools");
	
	@Test(dataProvider = "testData")
	public void TC50_Verify_Authoring_Tools_Options(String emailid, String passwd, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			verifyToolsOptions();
			Reporter.SuccessReport("TC50_Verify_Authoring_Tools_Options", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC50_Verify_Authoring_Tools_Options", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			"Verify Tools Options"
	    		}};
	}

}
