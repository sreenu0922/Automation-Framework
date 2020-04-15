package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_143_Verify_Project_Sub_Page_Version_Approve_Pa extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC143_Verify_Project_Sub_Page_Version_Approve_Pa(String emailid, String passwd, String project, 
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToProjectSubPage();
			detailName("Testing Version Approve");
			savePage();
			workflow("submittoworkflow", "Testing");
			navigateToSetting();
			approveVersion();
			Reporter.SuccessReport("TC143_Verify_Project_Sub_Page_Version_Approve_Pa", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC143_Verify_Project_Sub_Page_Version_Approve_Pa", "Failed");
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
	    			"Verify Authoring/Page/Project_Sub_PageVersion Approve by Consultation Manager"
	    		}};
	}
}
