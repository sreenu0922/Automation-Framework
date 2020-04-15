package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_11_HelpmeFindCons_SiteAdmin  extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC11_HelpmeFindCons_SiteAdmin(String emailid, String passwd, String keyword, String location, String category,
			String dept, String projectgroup, String status, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			login(emailid, passwd, "menu");
			helpMeFoundConsutation(keyword, location, category, dept, projectgroup, status);
			Reporter.SuccessReport("TC11_HelpmeFindCons_SiteAdmin", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC11_HelpmeFindCons_SiteAdmin", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("Keyword", "Value 1"),
	    			xls.getCellValue("Location", "Value 1"),
	    			xls.getCellValue("Category", "Value 1"),
	    			xls.getCellValue("Department", "Value 1"),
	    			xls.getCellValue("Project Group", "Value 1"),
	    			xls.getCellValue("Project Status", "Value 1"),
	    			"Verify help Me Found Consutation fuucntionality for Site Admin"
	    		}};
	}

}
