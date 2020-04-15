package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_15_CommonChecks_InvalidEmailIDPWD extends HelperClass {
		
		ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
		
		@Test(dataProvider = "testData")
		public void TC15_CommonChecks_InvalidEmailIDPWD(String emailid, String passwd,
				String testdescription) throws Throwable {
			try{
				TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
				
				handleAuthPopup();
				verifyInvalidLoginMessage(emailid, passwd, "menu");
				Thread.sleep(5000);
				verifyInvalidLoginMessage(emailid, passwd, "footer");
				Reporter.SuccessReport("TC15_CommonChecks_InvalidEmailIDPWD", "Passed");
			}catch(Exception e){
				Reporter.failureReport("TC15_CommonChecks_InvalidEmailIDPWD", "Failed");
				e.printStackTrace();
			}
		}
		
		@DataProvider(name="testData")
		public Object[][] createdata1() {
		    return new Object[][] { 
		    		{
		    			xls.getCellValue("Invalid Email Id", "Value 1"),
		    			xls.getCellValue("Invalid Password", "Value 1"),
		    			"Verify error message while login from Menu and footer with Invalid Email id"
		    		}
		    	};
		}
}

