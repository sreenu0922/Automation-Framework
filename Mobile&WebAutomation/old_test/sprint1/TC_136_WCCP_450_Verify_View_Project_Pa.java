package com.desktopWeb.scripts.sprint1;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_136_WCCP_450_Verify_View_Project_Pa extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC136_WCCP_450_Verify_View_Project_Pa(String emailid, String passwd, String projectname1, String projectname2, 
			String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToDashboardProject();
			verifyProjectinDashboardProjectList(projectname1);
			verifyProjectinDashboardProjectList(projectname2);
			Reporter.SuccessReport("TC136_WCCP_450_Verify_View_Project_Pa", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC136_WCCP_450_Verify_View_Project_Pa", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 3"),
	    			xls.getCellValue("Password", "Value 3"),
	    			xls.getCellValue("Project 1", "Value 3"),
	    			xls.getCellValue("Project 2", "Value 3"),
	    			"WCCP-450 Verify View Projects in Dashboard/Project/Project List for Project Author"
	    		}};
	}

}
