package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_02_CommonChecks_HomePage_HamburgerMenu_Login_Signout_CommunityUser extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC02_CommonChecks_HomePage_HambergerMenu_Login_Signout_CommunityUser(String emailid, String passwd, 
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			click(menu, "Menu");
			verifyWebElementHomePage();
			verifyHamberger();
			signOut("Menu");
			Reporter.SuccessReport("TC_02_CommonChecks_HomePage_HambergerMenu_Login_Signout_CommunityUser", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_02_CommonChecks_HomePage_HambergerMenu_Login_Signout_CommunityUser", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 2"),
	    			xls.getCellValue("Password", "Value 2"),
	    			"Verify login from Menu, the presence of Hamburger Menu, Links present in Hamburger, Engage Victoria Logo, Search Site, "
	    			+ "Engage Victoria' on hero block, text -  Share ideas here and have your say about what matters to you,"
	    			+ " Image on hero block, Advance search section, Website feature section, "
	    			+ "Active Consultation section, Stay Informed section, Footer section, sign out from footer for Community User"
	    		}};
	}

}
