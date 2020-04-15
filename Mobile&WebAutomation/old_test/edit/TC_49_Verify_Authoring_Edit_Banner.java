package com.desktopWeb.scripts.edit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_49_Verify_Authoring_Edit_Banner extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Automation Test Data");
	
	@Test(dataProvider = "testData")
	public void TC49_Verify_Authoring_tools_Edit_Banner(String emailid, String passwd, String project, String blocktitle, String blockdesc, String flow,
			String comment, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateConsultation(project);
			saveEditPage();
			verifyEditToolsBanner(blocktitle, blockdesc, flow, comment);
			Reporter.SuccessReport("TC49_Verify_Authoring_tools_Edit_Banner", "Passed");
		}catch(Exception e){
			e.printStackTrace();
			Reporter.failureReport("TC49_Verify_Authoring_tools_Edit_Banner", "Failed");
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("Project", "Value 1"),
	    			xls.getCellValue("Block Title", "Value 1"),
	    			xls.getCellValue("Block Desc", "Value 1"),
	    			xls.getCellValue("Workflow", "Value 1"),
	    			xls.getCellValue("Comment", "Value 1"),
	    			"Verify Authoring Tools and Edit Banner"
	    		}};
	}

}
