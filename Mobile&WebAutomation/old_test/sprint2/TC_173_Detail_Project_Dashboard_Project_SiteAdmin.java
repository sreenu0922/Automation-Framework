package com.desktopWeb.scripts.sprint2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_173_Detail_Project_Dashboard_Project_SiteAdmin extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC173_Detail_Project_Dashboard_Project_SiteAdmin(String emailid, String passwd, String project, String newprojectName,
			String choice, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToDashboardProject();
			openProjectFromDashboardProject(project);
			navigateToSetting();
			detailDesc(newprojectName);
			//savePage();
			//workflow("submittoworkflow", "Testing");
			Reporter.SuccessReport("TC173_Detail_Project_Dashboard_Project_SiteAdmin", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC173_Detail_Project_Dashboard_Project_SiteAdmin", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 4"),
	    			xls.getCellValue("Password", "Value 4"),
	    			xls.getCellValue("Project", "Value 4"),
	    			xls.getCellValue("New Project Name", "Value 4"),
	    			xls.getCellValue("Workflow1", "Value 4"),
	    			"Verify Dashboard/Project/EDit Project by Site Admin"
	    		}};
	}

}
