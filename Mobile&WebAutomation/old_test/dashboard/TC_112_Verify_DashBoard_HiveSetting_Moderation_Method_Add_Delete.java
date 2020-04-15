package com.desktopWeb.scripts.dashboard;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_112_Verify_DashBoard_HiveSetting_Moderation_Method_Add_Delete extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Dashboard");
	
	@Test(dataProvider = "testData")
	public void TC112_Verify_DashBoard_HiveSetting_Moderation_Method_Add_Delete(String emailid, String passwd, 
			String reason, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			adddeleteModeration(reason);
			Reporter.SuccessReport("TC112_Verify_DashBoard_HiveSetting_Moderation_Method_Add_Delete", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC112_Verify_DashBoard_HiveSetting_Moderation_Method_Add_Delete", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("Moderation Reason", "Value 1"),
	    			"Verify Dashboard/HiveSetting/Moderation Method Add Delete"
	    		}};
	}

}
