package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import accelerators.ActionEngine;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageLocator extends ActionEngine {

    //Written by Vinay Gajula
    public static By SelectChild=By.id("child_name");
    public static By SelectDone=By.id("next_cta");
    public static String SelectReason="//*[contains(@text,'#')]";
    public static By fell=By.id("no_button");
    public static By fell1=By.id("yes_button");
    public static By Returntoben=By.id("dialog_positive_button");
    public static By fellnext=By.id("next_cta");
    public static String Symptoms="//*[contains(@text,'#')]";
    public static String TypeofCare="//*[contains(@text,'#')]";

    }
	
	//@author by Bhavya
	//created on : 20-04-2020
	
		//Verify Settings icon
		//Verify Select uat25
		//verify click on enroll
		//verify acme from where do you work dropdown list
		
		public static By settingsicon = By.xpath("//*[contains(@resource-id,'settings')]");
		public static By uat25 = By.xpath("//*[contains(@text,'uat25')]");
		public static By enroll = By.xpath("//*[contains(@resource-id,'sign_up')]");
		//sendkeys method by giving acme
		public static By companysearch = By.xpath("//*[contains(@resource-id,'company_search')]");
		//verify login button
		public static By Login = By.id("sign_in");
		//again select acme
        public static By companysearch1 = By.xpath("//*[contains(@resource-id,'company_search')]");
		//verify email
		public static By emailfield= By.id("email");
		//verify password
		public static By passwordfield=By.id("passwd");
		//click on login
		public static By login1 = By.xpath("//*[contains(@text,'LOGIN')]");
		
		
	//author Sreeranga
	
	//Select Use my backUp days
	public static By  BackUpDays= By.id("use_my_backup_days");
	//select BookNow Button
	public static By BookNow = By.id("ctabutton");
	
	
	}


	/*@author : sangeethan
	page locators for activate your account
	*/
	public static By birthdate = By.xpath("//*[contains(@resource-id,'date_edit_text')]");
	public static By okdate = By.xpath("//*[contains(@resource-id,'ok')]");
	public static By firstname = By.xpath("//*[contains(@resource-id,'first_name')]");
	public static By lastname = By.xpath("//*[contains(@resource-id,'last_name')]");
	public static By homeaddress = By.xpath("//*[contains(@resource-id,'address')]");
	public static By zip = By.xpath("//*[contains(@resource-id,'city_state_zip')]");
	public static By email = By.xpath("//*[contains(@resource-id,'email')]");
	public static By password = By.xpath("//*[contains(@resource-id,'password')]");
	public static By enrollbutton = By.xpath("//*[contains(@resource-id,'done_button')]");
	
	
	/*@author : sangeethan
	page locators for "please help us to protect the health of all families and care providers"
	*/
	public static By nobutton = By.xpath("//*[contains(@resource-id,'no_cta')]");
	public static By yesbutton = By.xpath("//*[contains(@resource-id,'yes_cta')]");
	
	
	/*@author : sangeethan
	 * page locators for billing page
     */
	public static By creditcard = By.xpath("//*[contains(@resource-id,'cc_edit_1')]");
	public static By month = By.xpath("//*[contains(@resource-id,'cc_cvv_2')]");
	public static By cvv = By.xpath("//*[contains(@resource-id,'cc_cvv_3')]");
	public static By zip1 = By.xpath("//*[contains(@resource-id,'cc_cvv_4')]");
	public static By submitrequest = By.xpath("//*[contains(@resource-id,'submit_button')]");
	
	
}

