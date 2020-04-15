package com.desktopWeb.scripts.page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_69_Detail_Project_Sub_Page_Project extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Setting");
	
	@Test(dataProvider = "testData")
	public void TC69_Detail_Project_Sub_Page_Project(String emailid, String passwd, String project, String newprojectName,
			String choice, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToProjectSubPage();
			selectByVisibleText(pageDetailPageLocation, project, "Page location");
			detailName(newprojectName);
			savePage();
			workflow(choice, "workflow");
			Reporter.SuccessReport("TC69_Detail_Project_Sub_Page_Project", "Passed");
		}catch(Exception e){
			e.printStackTrace();
			Reporter.failureReport("TC69_Detail_Project_Sub_Page_Project", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("Project", "Value 1"),
	    			xls.getCellValue("New Project Name", "Value 1"),
	    			xls.getCellValue("WorkFlow", "Value 1"),
	    			"Verify Authoring/Page/Project_Sub_Page/Details Funtionality"
	    		}};
	}

}
