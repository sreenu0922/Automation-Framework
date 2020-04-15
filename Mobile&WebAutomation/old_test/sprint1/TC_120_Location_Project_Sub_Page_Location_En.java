package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_120_Location_Project_Sub_Page_Location_En extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC120_Location_Project_Sub_Page_Location_En(String emailid, String passwd, String project,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToProjectSubPage();
			changeLocation("Testing Change Location");
			savePage();
			workflow(choice, "Testing");
			Reporter.SuccessReport("TC120_Location_Project_Sub_Page_Location_En", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC120_Location_Project_Sub_Page_Location_En", "Failed");
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
	    			xls.getCellValue("Workflow", "Value 1"),
	    			"Verify Authoring/Page/Project_Sub_Page/Location by Engagement Manager Funtionality"
	    		}};
	}
}
