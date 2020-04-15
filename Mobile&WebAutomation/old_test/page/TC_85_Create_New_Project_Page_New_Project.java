package com.desktopWeb.scripts.page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_85_Create_New_Project_Page_New_Project extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Create Project");
	
	@Test(dataProvider = "testData")
	public void TC85_Create_New_Project_Page_New_Project(String emailid, String passwd, String projectname, String projectdesc, 
			String projectdept, String projecttype, String projectsatus, String username, String userrole, String golive, 
			String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			//navigateConsultation(project);
			navigateToProjectPage();
			createProject(projectname, projectdesc, projectdept, projecttype, projectsatus, username, userrole, golive);
			Reporter.SuccessReport("TC85_Create_New_Project_Page_New_Project", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC85_Create_New_Project_Page_New_Project", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("Project Name", "Value 1"),
	    			xls.getCellValue("Project Desc", "Value 1"),
	    			xls.getCellValue("Project Dept", "Value 1"),
	    			xls.getCellValue("Project Type", "Value 1"),
	    			xls.getCellValue("Project Status", "Value 1"),
	    			xls.getCellValue("User Name", "Value 1"),
	    			xls.getCellValue("User Role", "Value 1"),
	    			xls.getCellValue("Golive", "Value 1"),
	    			"Verify Authoring/Page/Site_Sub_Page/Details Funtionality"
	    		}};
	}

}
