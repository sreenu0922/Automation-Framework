package testsuite;

import org.openqa.selenium.By;
import accelerators.ActionEngine;

public class PageLocator extends ActionEngine {
	
	//@author by Bhavya
	
		//Verify Settings icon
		//Verify Select uat25
		//verify click on enroll
		//verify acme from where do you work dropdown list
		
		public static By settingsicon = By.xpath("//*[contains(@resource-id,'settings')]");
		public static By uat25 = By.xpath("//*[contains(@text,'uat25')]");
		public static By enroll = By.xpath("//*[contains(@resource-id,'sign_up')]");
		
		//sendkeys method by giving acme
		public static By companysearch = By.xpath("//*[contains(@resource-id,'company_search')]");
		
		public static By selectacme = By.id("container");
		
		//verify login button
		public static By Login = By.id("sign_in");
		
		
		//again select acme
        public static By companysearch1 = By.xpath("//*[contains(@resource-id,'company_search')]");
		
		public static By selectacme1 = By.id("container");
		
		//verify email
		public static By emailfield= By.id("email");
		
		//verify password
		public static By passwordfied=By.id("passwd");
		
		//click on login
		
		public static By login = By.xpath("//*[contains(@text,'LOGIN')]");
		
		


}
