package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_128_Verify_Project_Sub_Page_Version_Duplicate_Cm extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC128_Verify_Project_Sub_Page_Version_Duplicate_Cm(String emailid, String passwd, String projectname,
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToProjectSubPage();
			detailName("Testing Version Duplicate");
			savePage();
			workflow("submittoworkflow", "Testing");
			Thread.sleep(25000);
			navigateToSetting();
			duplicateVersion();
			Reporter.SuccessReport("TC128_Verify_Project_Sub_Page_Version_Duplicate_Cm", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC128_Verify_Project_Sub_Page_Version_Duplicate_Cm", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 2"),
	    			xls.getCellValue("Password", "Value 2"),
	    			xls.getCellValue("Project", "Value 2"),
	    			"Verify Authoring/Page/Project_Sub_Page/Version Duplicate by Consultation Manager"
	    		}};
	}
}
