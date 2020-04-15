package com.desktopWeb.scripts.sprint2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_179_WCCP_418_2 extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC179_WCCP_418_2(String emailid_sa, String passwd, String emailid_en,
			String emailid_pa, String projectname, String projectdesc, String projectdept, 
			String projecttype, String projectsatus, String username, String userrole, String golive, 
			String testdescription) throws Throwable {
		try{	
			String pagename = "new sub page";
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			
			//Admin create a project and assign an EM/PA/CM to the department assigned
			login(emailid_sa, passwd, "Menu");
			Thread.sleep(5000);
			navigateToDashboardProject();
			click(projectLaunchProject, "Launch New Project");
			projectname = createProject(projectname, projectdesc, projectdept, projecttype, projectsatus, username, userrole, golive);
			signOut("menu");
			
			//Project Author create and submit for approval a new page
			login(emailid_pa, passwd, "Menu");
			navigateToProjectSubPage();
			String subpagename = createSubPage(pagename, projectname);
			Thread.sleep(5000);
			savePage();
			Thread.sleep(5000);
			workflow("submittoworkflow", "workflow");
			Thread.sleep(35000);
			signOut("Menu");
			
			//Verify that the EM for that department will receive notification when PA submits for approval, and Reject
			login(emailid_en, passwd, "Menu");
			navigateToSubPage(subpagename);
			rejectPage();
			signOut("menu");
			Thread.sleep(5000);
			
			
			/*
			 * Verify that the PA Also receives a workflow notification with rejection comments to review and edit content
			 * Review the comments
			 * Edit the content 
			 * Save changes and 
			 * Resubmit to workflow
			*/
			login(emailid_pa, passwd, "Menu");
			navigateToSubPage(subpagename);
			navigateToSetting();
			click(pageSettingDetails, "Details");
			Thread.sleep(5000);
			type(DetailsPJDesc, "Update Description - "+getRandomString(4), "Project Desc");
			click(DetailsSubmit, "Submit");
			Thread.sleep(20000);
			signOut("menu");
			Thread.sleep(5000);

			//Verify that the EM receives a Re-submission for Approval Request
			login(emailid_en, passwd, "Menu");
			navigateToSubPage(subpagename);
			Thread.sleep(5000);
			approvePage();
			
			Reporter.SuccessReport("TC_179_WCCP_418_2", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_179_WCCP_418_2", "Failed");
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
	    			xls.getCellValue("Email Id", "Value 3"),
	    			xls.getCellValue("Project Name", "Value 4"),
	    			xls.getCellValue("Project Desc", "Value 4"),
	    			xls.getCellValue("Project Dept", "Value 4"),
	    			xls.getCellValue("Project Type", "Value 4"),
	    			xls.getCellValue("Project Status", "Value 4"),
	    			xls.getCellValue("User Name", "Value 4"),
	    			xls.getCellValue("User Role", "Value 4"),
	    			xls.getCellValue("Golive", "Value 4"),
	    			"Verify TC_179_WCCP_418_2"
	    		}};
	}

}
