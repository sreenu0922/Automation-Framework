package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_14_Signup_from_Menu_Footer extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC14_Signup_from_Menu_Footer(String interests, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			signup(interests, "menu");
			signOut("footer");
			signup(interests, "footer");
			Reporter.SuccessReport("TC14_Signup_from_Menu_Footer", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC14_Signup_from_Menu_Footer", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    	{
    			xls.getCellValue("Interest", "Value 1"),
    			"Verify Sign up from Menu and footer"
    		}
    	};
	}

}
