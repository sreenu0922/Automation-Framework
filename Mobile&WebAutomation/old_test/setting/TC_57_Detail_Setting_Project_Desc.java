package com.desktopWeb.scripts.setting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_57_Detail_Setting_Project_Desc extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Setting");
	
	@Test(dataProvider = "testData")
	public void TC57_Detail_Setting_Project_Desc(String emailid, String passwd, String project, String newprojectdesc,
			String choice, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateConsultation(project);
			saveEditPage();
			navigateToSetting();
			detailDesc(newprojectdesc);
			//savePage();
			//submittoWorkflow("Add Description");
			
			Reporter.SuccessReport("TC_57_Detail_Setting_Project_Desc", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_57_Detail_Setting_Project_Desc", "Failed");
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
	    			xls.getCellValue("New Project Desc", "Value 1"),
	    			xls.getCellValue("WorkFlow", "Value 1"),
	    			"Verify Authoring/Setting/Details Funtionality"
	    		}};
	}

}
