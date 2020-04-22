package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HelperClass extends PageLocator {
	
	
    //@author by Bhavya
	//created on : 21-04-2020
	//click on settings icon
	//select uat25
	//click on uat25
	public void navigateToUat() throws Throwable {
		click(settingsicon ,"settingicon");
		Thread.sleep(2000);
		swipeVertical(0.8,0.1,0.9, 2000);
		Thread.sleep(2000);
		click(uat25,"uat25");
		Thread.sleep(2000);
		
	}
	//@author by Bhavya
	//created on : 21-04-2020
	//click on enroll
	public void navigateToEnroll() throws Throwable {
		
	click(enroll ,"enrollbutton");
	Thread.sleep(2000);
	
	}
	//@author by Bhavya
	//created on : 21-04-2020
	//select company serach as acme
	public void selectCompanyforenroll(String companyname) throws Throwable {
	//click(companysearch , "company_search");
	Thread.sleep(2000);
	type(companysearch, companyname ,"companysearch");
	int x = driver.manage().window().getSize().getHeight();
    int y = driver.manage().window().getSize().getWidth();
    int s = (int) (y * 9.02 / 100);
    Thread.sleep(5000);
    clickByCondindates(285, 903);
	
	}
	
	//@author by Bhavya
	//created on : 21-04-2020
	//login flow with email and password
	public void login()throws Throwable{
		
		click(Login ,"loginbutton");
		Thread.sleep(2000);
		click(companysearch1 , "company_search");
		Thread.sleep(2000);
		type(companysearch,"acme","companysearch");
		Thread.sleep(2000);
		sendkey((WebElement)emailfield,"bhavya444@care.com");
		Thread.sleep(2000);
		sendkey((WebElement)passwordfield,"letmein1");
		Thread.sleep(2000);
		click(login1 , "loginbutton1");
		
		
	}
	
}
