package com.desktopWeb.scripts.sprint2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_175_Verify_Field_Enable_ToEdit_Dashoard_Project_Cm extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC175_Verify_Field_Enable_ToEdit_Dashoard_Project_Cm(String emailid, String passwd, String project, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToDashboardProject();
			openProjectFromDashboardProject(project);
			navigateToSetting();
			VerifyFieldsEnableToEditOnProjectPage("Consultation Manager");
			Reporter.SuccessReport("TC175_Verify_Field_Enable_ToEdit_Dashoard_Project_Cm", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC175_Verify_Field_Enable_ToEdit_Dashoard_Project_Cm", "Failed");
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
	    			"Verify Dashboard/Project/Fields to be editable by Consultation Manager"
	    		}};
	}

}
