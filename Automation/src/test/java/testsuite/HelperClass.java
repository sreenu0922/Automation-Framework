package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Random;

public class HelperClass extends PageLocator {
    //Written by Vinay Gajula
    public void SelectChild() throws Throwable {
        click(SelectChild, "Selecting the Child");
        click(SelectDone, "Clicking the Done Button");
    }

    public void CareReason(String selectReason) throws Throwable {
        click(By.xpath(SelectReason.replace("#", selectReason)), "Selecting the Reasons");
    }

    //If we select No_Button we need to use below method
    public void Felt(String symptoms) throws Throwable {
        click(fell, "Selecting No Button");
        click(By.xpath(Symptoms.replace("#", "symptoms")), "Selecting Reasons");
        click(fellnext, "clicking the next button");

    }

    //If we select Yes_Button we need to use below method
    public void Felt1() throws Throwable {
        click(fell1, "Selecting Yes Button");
        click(Returntoben,"Going to return to Benefits Page");

    }
        public void CareType (String typeofCare) throws Throwable {
            click(By.xpath(TypeofCare.replace("#", typeofCare)), "Selecting the care");

    }
	
	
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
	
	public void selectdate(String month,String day,String year) throws Throwable
	{
		click(birthdate, "choosedate");
		scrollTo(year, 2);
		scrollTo(day, 2);
		scrollTo(month, 2);
		click(okdate, "selectdate");
	}
	
	
	public void enroll() throws Throwable
	{
		
		selectdate("may", "27", "1990");
		sendkey((WebElement)firstname, "sangeetha");
		Thread.sleep(2000);
		sendkey((WebElement)lastname, "nulu");
		sendkey((WebElement) homeaddress, "P.O.Box 100");
		sendkey((WebElement)zip, "02451");
		sendkey((WebElement)email, "sangeethan@gmail.cm");
		sendkey((WebElement)password, "Letmein1");
		click(enrollbutton, "clickonenrollbutton");
	}
	
	
	public void clickno() throws Throwable
	{
		click(nobutton, "no");
	}


	public void clickyes() throws Throwable
	{
		click(yesbutton, "yes");
	}
	
	
	public void billing() throws Throwable
	{
		
		
		sendkey((WebElement) creditcard, "4111 1111 1111 1111");
		sendkey((WebElement)month, "0523");
		sendkey((WebElement)cvv, "123");
		sendkey((WebElement)zip1, "02451");
		click(submitrequest, "click on submit ");
			
	}
	
	//Author Sreeranga
	// Navigate to use my backup days
	public void navigatetousemybackupdays() throws Throwable {
		click(BackUpDays,"Backupdays");
		
	}
	
	// NAvigate to Book Now Button
	public void navigatetoBookNow() throws Throwable {

		click(BookNow , "BookNowButton");

	}


}
