package com.desktopWeb.scripts.sprint1;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_116_WCCP_446_Verify_PM_Dept_Agency_Permission_To_En_Manager extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC116_WCCP_446_Verify_PM_Dept_Agency_Permission_To_En_Manager(String emailid, String passwd, String usertype, 
			String useremail, String dept, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			navigateToDashboardMembers();
			searchUserUsingEmailAddress(usertype, useremail);
			verifyGrantPermissionToDeptAgency(dept);
			verifyRevokePermissionToDeptAgency(dept);
			Reporter.SuccessReport("TC116_WCCP_446_Verify_PM_Dept_Agency_Permission_To_En_Manager", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC116_WCCP_446_Verify_PM_Dept_Agency_Permission_To_En_Manager", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 4"),
	    			xls.getCellValue("Password", "Value 4"),
	    			xls.getCellValue("User Type", "Value 1"),
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Department/Agency", "Value 1"),
	    			"WCCP-446 Verify Product Manager assign Dept/Agency to En Manager"
	    		}};
	}

}
