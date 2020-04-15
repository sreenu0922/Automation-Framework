package com.desktopWeb.scripts.addUpdate;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_55_Location_Update_Location extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Setting");
	
	@Test(dataProvider = "testData")
	public void TC55_Location_Update_Location(String emailid, String passwd, String project, String newname,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateConsultation(project);
			navigateToUpdate();
			changeLocation(project);
			savePage();
			workflow(choice, "Change Location");
			Thread.sleep(5000);
			assertText(valeleBreadcrumbHome, "Home");
			Reporter.SuccessReport("TC55_Location_Update_Location", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC55_Location_Update_Location", "Failed");
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
	    			"Verify Authoring/Update/Location Funtionality"
	    		}};
	}
}
