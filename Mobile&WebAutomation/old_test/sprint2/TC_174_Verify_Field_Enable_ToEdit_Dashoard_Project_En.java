package com.desktopWeb.scripts.sprint2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_174_Verify_Field_Enable_ToEdit_Dashoard_Project_En extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC174_Verify_Field_Enable_ToEdit_Dashoard_Project_En(String emailid, String passwd, String project, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToDashboardProject();
			openProjectFromDashboardProject(project);
			navigateToSetting();
			VerifyFieldsEnableToEditOnProjectPage("Engagement Manager");
			Reporter.SuccessReport("TC174_Verify_Field_Enable_ToEdit_Dashoard_Project_En", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC174_Verify_Field_Enable_ToEdit_Dashoard_Project_En", "Failed");
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
	    			"Verify Dashboard/Project/Fields to be editable by Engagement Manager"
	    		}};
	}

}
