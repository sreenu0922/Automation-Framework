package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_139_Design_Project_Sub_Page_Template_Pa extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC139_Design_Project_Sub_Page_Template_Pa(String emailid, String passwd, String project, String pagetemplate,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToProjectSubPage();
			type(DetailsPjName, "Testing Design", "Project Name");
			designTemplate(pagetemplate);
			savePage();
			workflow("submittoworkflow", "Testing");
			Reporter.SuccessReport("TC139_Design_Project_Sub_Page_Template_Pa", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC139_Design_Project_Sub_Page_Template_Pa", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 3"),
	    			xls.getCellValue("Password", "Value 3"),
	    			xls.getCellValue("Project", "Value 3"),
	    			xls.getCellValue("Page Template", "Value 3"),
	    			xls.getCellValue("Workflow", "Value 3"),
	    			"Verify Authoring/Page/Project_Sub_Page/Design by Project Author"
	    		}};
	}
}
