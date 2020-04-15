package com.desktopWeb.scripts.addUpdate;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_53_Design_Update_Template extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Setting");
	
	@Test(dataProvider = "testData")
	public void TC53_Design_Update_Template(String emailid, String passwd, String project, String pagetemplate,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateConsultation(project);
			navigateToUpdate();
			Thread.sleep(5000);
			designTemplate(pagetemplate);
			savePage();
			workflow(choice, "Test Design");
			isElementDisplayed(onPageUpdateNews, "New Title");
			Reporter.SuccessReport("TC53_Design_Update_Template", "Passed");
		}catch(Exception e){
			e.printStackTrace();
			Reporter.failureReport("TC53_Design_Update_Template", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("Project", "Value 1"),
	    			xls.getCellValue("Page Template News Full", "Value 1"),
	    			xls.getCellValue("WorkFlow", "Value 1"),
	    			"Verify Authoring/Update/Design Funtionality"
	    		}};
	}
}
