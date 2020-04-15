package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_156_Design_Page_News_Page_Template_Cm extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC156_Design_Page_News_Page_Template_Cm(String emailid, String passwd, String project, String pagetemplate,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToNewsPage();
			pageLocation(project);
			designTemplate("News Full");
			savePage();
			workflow("submittoworkflow", "Testing");
			Reporter.SuccessReport("TC156_Design_Page_News_Page_Template_Cm", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC156_Design_Page_News_Page_Template_Cm", "Failed");
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
	    			xls.getCellValue("Page Template", "Value 2"),
	    			xls.getCellValue("WorkFlow", "Value 2"),
	    			"Verify Authoring/Page/News_Page/Design funtionality by Consultation Manager"
	    		}};
	}
}
