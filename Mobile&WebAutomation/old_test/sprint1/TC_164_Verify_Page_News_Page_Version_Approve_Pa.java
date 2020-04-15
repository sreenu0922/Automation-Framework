package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_164_Verify_Page_News_Page_Version_Approve_Pa extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC164_Verify_Page_News_Page_Version_Approve_Pa(String emailid, String passwd, String project, 
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateConsultation(project);
			navigateToNewsPage();
			type(DetailsPjName, "Testing Version Approve", "Project Name");
			pageLocation(project);
			Thread.sleep(5000);
			approveVersion();
			Reporter.SuccessReport("TC164_Verify_Page_News_Page_Version_Approve_Pa", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC164_Verify_Page_News_Page_Version_Approve_Pa", "Failed");
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
	    			"Verify Authoring/Page/News_Page_Version Approve funtionality by Project Author"
	    		}};
	}
}
