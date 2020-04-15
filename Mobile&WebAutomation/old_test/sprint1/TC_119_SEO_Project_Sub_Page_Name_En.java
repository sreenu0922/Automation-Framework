package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_119_SEO_Project_Sub_Page_Name_En extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC119_SEO_Project_Sub_Page_Name_En(String emailid, String passwd, String project, String newname,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToProjectSubPage();
			seoName(newname);
			savePage();
			workflow("submittoworkflow", "Testing");
			Reporter.SuccessReport("TC119_SEO_Project_Sub_Page_Name_En", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC119_SEO_Project_Sub_Page_Name_En", "Failed");
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
	    			xls.getCellValue("SEO Meta Desc", "Value 1"),
	    			xls.getCellValue("WorkFlow", "Value 1"),
	    			"Verify Authoring/Page/Project_Sub_Page/SEO Funtionality by Engagement Manager"
	    		}};
	}
}
