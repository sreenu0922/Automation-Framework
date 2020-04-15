package com.desktopWeb.scripts.tools;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_19_Add_Content extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Tools");
	
	@Test(dataProvider = "testData")
	public void TC19_Add_Content(String emailid, String passwd, String project, String content,
			String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateConsultation(project);
			saveEditPage();
			addContent(content);
			Reporter.SuccessReport("TC_19_Add_Content", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_19_Add_Content", "Failed");
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
	    			xls.getCellValue("Content", "Value 1"),
	    			"Verify Add HTML to page"
	    		}};
	}

}
