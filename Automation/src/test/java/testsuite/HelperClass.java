package testsuite;

import org.openqa.selenium.By;

public class HelperClass extends PageLocator {
	
	
//author by Bhavya
	public void navigaateToUat() throws Throwable {
		click(settingsicon ,"settingicon");
		click(uat25 , "uat25");
	}
	public void navigateToEnroll() throws Throwable {
		
	click(enroll ,"enrollbutton");
	}
	
	public void selectCompany() throws Throwable {
	click(companysearch , "company_search");
	
	}
	
}
