package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HelperClass extends PageLocator {
	
	
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
	
	
	
	
}
