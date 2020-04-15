package com.desktopWeb.scripts.common;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_06_loginviaFooter_CommonCheck_FooterLinks_SearchSite_CommunityUser extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC06_loginviaFooter_CommonCheck_FooterLinks_SearchSite_CommunityUser(String emailid, String passwd, String keyword, 
			String category, String consultationname, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			handleAuthPopup();
			login(emailid, passwd, "footer");
			Thread.sleep(10000);
			searchConsultation(category, "menu");
			navigateConsultation(consultationname);
			verifySearchSite(keyword);
			verifyFooterLinks();
			Reporter.SuccessReport("TC06_loginviaFooter_CommonCheck_FooterLinks_SearchSite_CommunityUser", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC06_loginviaFooter_CommonCheck_FooterLinks_SearchSite_CommunityUser", "Failed");
			e.printStackTrace();
	}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 2"),
	    			xls.getCellValue("Password", "Value 2"),
	    			xls.getCellValue("Keyword", "Value 2"),
	    			xls.getCellValue("Category", "Value 2"),
	    			xls.getCellValue("Consultation Name", "Value 2"),
	    			"Verify login from footer, Advance Search from Menu, navigate to Active Consultation from seach result, Site Search, fucntionality of Links - "
	    	    			+ "Copyright, Privacy, Term of Use, Accessibility, Moderation, Community Guidelines, About Us, "
	    	    			+ "Contact Us, Site Map, The State Government of Victoria, Navigation to The Hive page for Community User"
	    		}};
	}

}
