package com.desktopWeb.scripts.sprint2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_181_WCCP_408_En_Launch_Project extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC181_WCCP_408_En_Launch_Project(String emailid_sa, String passwd, String emailid_en,
			String emailid_cm, String projectname, String projectdesc, String projectdept, 
			String projecttype, String projectsatus, String username, String userrole, String golive, 
			String testdescription) throws Throwable {
		try{	
			String pagename = "new sub page";
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			
			//Admin create a project and assign an engagement manager to the department assigned
			login(emailid_en, passwd, "Menu");
			Thread.sleep(5000);
			navigateToDashboardProject();
			click(projectLaunchProject, "Launch New Project");
			projectname = createProject(projectname, projectdesc, projectdept, projecttype, projectsatus, username, userrole, golive);
			signOut("menu");
			
						
			Reporter.SuccessReport("TC181_WCCP_408_En_Launch_Project", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC181_WCCP_408_En_Launch_Project", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 4"),
	    			xls.getCellValue("Password", "Value 4"),
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Email Id", "Value 2"),
	    			xls.getCellValue("Project Name", "Value 4"),
	    			xls.getCellValue("Project Desc", "Value 4"),
	    			xls.getCellValue("Project Dept", "Value 4"),
	    			xls.getCellValue("Project Type", "Value 4"),
	    			xls.getCellValue("Project Status", "Value 4"),
	    			xls.getCellValue("User Name", "Value 4"),
	    			xls.getCellValue("User Role", "Value 4"),
	    			xls.getCellValue("Golive", "Value 4"),
	    			"Verify TC181_WCCP_408_En_Launch_Project"
	    		}};
	}

}
