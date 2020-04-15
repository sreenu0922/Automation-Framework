package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_118_Design_Project_Sub_Page_Template_En extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC118_Design_Project_Sub_Page_Template_en(String emailid, String passwd, String project, String pagetemplate,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToProjectSubPage();
			designTemplate(pagetemplate);
			savePage();
			workflow("submittoworkflow", "Testing");
			Reporter.SuccessReport("TC118_Design_Project_Sub_Page_Template_en", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC118_Design_Project_Sub_Page_Template_en", "Failed");
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
	    			xls.getCellValue("Page Template", "Value 1"),
	    			xls.getCellValue("Workflow", "Value 1"),
	    			"Verify Authoring/Page/Project_Sub_Page/Design by Engage Manager Funtionality"
	    		}};
	}
}
