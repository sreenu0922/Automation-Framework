package testsuite;

import org.openqa.selenium.By;
import accelerators.ActionEngine;

public class PageLocator extends ActionEngine {

	/*@author : sangeethan
	page locators for activate your account
	*/
	public static By birthdate = By.xpath("//*[contains(@resource-id,'dynamic_view_layout')]");
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
