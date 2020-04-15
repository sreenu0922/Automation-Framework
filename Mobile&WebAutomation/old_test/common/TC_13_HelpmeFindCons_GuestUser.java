package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_13_HelpmeFindCons_GuestUser  extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC13_HelpmeFindCons_GuestUser(String emailid, String passwd, String keyword, String location, String category,
			String dept, String projectgroup, String status, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			login(emailid, passwd, "menu");
			helpMeFoundConsutation(keyword, location, category, dept, projectgroup, status);
			Reporter.SuccessReport("TC13_HelpmeFindCons_GuestUser", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC13_HelpmeFindCons_GuestUser", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] {
	    	{
	    			xls.getCellValue("Email Id", "Value 3"),
	    			xls.getCellValue("Password", "Value 3"),
	    			xls.getCellValue("Keyword", "Value 3"),
	    			xls.getCellValue("Location", "Value 3"),
	    			xls.getCellValue("Category", "Value 3"),
	    			xls.getCellValue("Department", "Value 3"),
	    			xls.getCellValue("Project Group", "Value 3"),
	    			xls.getCellValue("Project Status", "Value 3"),
	    			"Verify help Me Found Consutation fuucntionality for Guest User"
	    	}};
	}

}
