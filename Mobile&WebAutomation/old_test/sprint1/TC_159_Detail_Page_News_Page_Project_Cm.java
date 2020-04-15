package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_159_Detail_Page_News_Page_Project_Cm extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC159_Detail_Page_News_Page_Project_Cm(String emailid, String passwd, String project, String newprojectName,
			String choice, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToNewsPage();
			pageLocation(project);
			detailName(newprojectName);
			savePage();
			workflow("submittoworkflow", "Testing");
			Reporter.SuccessReport("TC159_Detail_Page_News_Page_Project_Cm", "Passed");
		}catch(Exception e){
			e.printStackTrace();
			Reporter.failureReport("TC159_Detail_Page_News_Page_Project_Cm", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 2"),
	    			xls.getCellValue("Password", "Value 2"),
	    			xls.getCellValue("Project", "Value 2"),
	    			xls.getCellValue("New Project Name", "Value 2"),
	    			xls.getCellValue("WorkFlow", "Value 2"),
	    			"Verify Authoring/Page/News_Page/Details funtionality by Consultation Manager"
	    		}};
	}

}
