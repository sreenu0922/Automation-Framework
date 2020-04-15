package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_153_Verify_Page_News_Page_Version_NewPage_En extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC153_Verify_Page_News_Page_Version_NewPage_En(String emailid, String passwd, String projectname,
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToNewsPage();
			pageLocation(projectname);
			detailName("Testing Version New Page");
			savePage();
			workflow("submittoworkflow", "Testing");
			navigateToSetting();
			newPageVersion("Testing Version New Page");
			Reporter.SuccessReport("TC153_Verify_Page_News_Page_Version_NewPage_En", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC153_Verify_Page_News_Page_Version_NewPage_En", "Failed");
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
	    			"Verify Authoring/Page/Project_Sub_Page/Version New Page by Engagement Manager"
	    		}};
	}
}
