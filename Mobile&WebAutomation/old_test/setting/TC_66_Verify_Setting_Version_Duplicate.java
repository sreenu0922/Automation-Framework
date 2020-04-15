package com.desktopWeb.scripts.setting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_66_Verify_Setting_Version_Duplicate extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Setting");
	
	@Test(dataProvider = "testData")
	public void TC66_Verify_Setting_Version_Duplicate(String emailid, String passwd, String project, 
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateConsultation(project);
			navigateToSetting();
			duplicateVersion();
			Reporter.SuccessReport("TC66_Verify_Setting_Version_Duplicate", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC66_Verify_Setting_Version_Duplicate", "Failed");
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
	    			"Verify Authoring/Setting/Version Duplicate Funtionality"
	    		}};
	}
}
