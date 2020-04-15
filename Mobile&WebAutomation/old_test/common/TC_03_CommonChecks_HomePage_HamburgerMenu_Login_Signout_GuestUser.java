package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_03_CommonChecks_HomePage_HamburgerMenu_Login_Signout_GuestUser extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC03_CommonChecks_HomePage_HambergerMenu_Login_Signout_GuestUser(String emailid, String passwd, 
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			Thread.sleep(5000);
			verifyWebElementHomePage();
			verifyHamberger();

			Reporter.SuccessReport("TC_03_CommonChecks_HomePage_HambergerMenu_Login_Signout_GuestUser", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_03_CommonChecks_HomePage_HambergerMenu_Login_Signout_GuestUser", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 3"),
	    			xls.getCellValue("Password", "Value 3"),
	    			"Verify the presence of Hamburger Menu, Links present in Hamburger, Engage Victoria Logo, Search Site, "
	    			+ "Engage Victoria' on hero block, text -  Share ideas here and have your say about what matters to you,"
	    			+ " Image on hero block, Advance search section, Website feature section, "
	    			+ "Active Consultation section, Stay Informed section, Footer section for Guest User"
	    		}};
	}

}
