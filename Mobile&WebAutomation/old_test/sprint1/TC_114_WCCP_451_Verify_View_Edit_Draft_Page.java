package com.desktopWeb.scripts.sprint1;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_114_WCCP_451_Verify_View_Edit_Draft_Page extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC114_WCCP_451_Verify_View_Edit_Draft_Page(String emailid, String passwd, String pagename, 
			String pagedesc, String choice, String othersdraftpage1, String othersdraftpage2, String testdescription) throws Throwable {
		try{	
			pagedesc = pagedesc + getRandomString(4);
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToPage();
			isElementNotDisplayed(By.xpath("//a[text()='"+othersdraftpage1+"']"), "Draft Page");
			isElementNotDisplayed(By.xpath("//a[text()='"+othersdraftpage2+"']"), "Draft Page");
			verifyEditSubPage(pagename, pagedesc, choice);
			Reporter.SuccessReport("TC114_WCCP_451_Verify_View_Edit_Draft_Page", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC114_WCCP_451_Verify_View_Edit_Draft_Page", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 2"),
	    			xls.getCellValue("Password", "Value 2"),
	    			xls.getCellValue("Draft Page Name", "Value 2"),
	    			xls.getCellValue("Page Desc", "Value 2"),
	    			xls.getCellValue("Workflow", "Value 2"),
	    			xls.getCellValue("Draft Page Name", "Value 1"),
	    			xls.getCellValue("Draft Page Name", "Value 3"),
	    			"WCCP-451 Verify View and edit draft page"
	    		}};
	}

}
