package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_151_Location_Page_News_Page_Location_En extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC151_Location_Page_News_Page_Location_En(String emailid, String passwd, String project, String newname,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToNewsPage();
			pageLocation(project);
			changeLocation(project);
			savePage();
			workflow("submittoworkflow", "Testing");
			Reporter.SuccessReport("TC151_Location_Page_News_Page_Location_En", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC151_Location_Page_News_Page_Location_En", "Failed");
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
	    			xls.getCellValue("Workflow", "Value 1"),
	    			xls.getCellValue("Choice", "Value 1"),
	    			"Verify Authoring/Page/News_Page/Location funtionality for Engagement Manager"
	    		}};
	}
}
