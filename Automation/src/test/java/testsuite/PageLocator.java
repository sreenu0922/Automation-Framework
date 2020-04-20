package testsuite;

import org.openqa.selenium.By;

import accelerators.ActionEngine;

public class PageLocator extends ActionEngine {
	
	public static By menu = By.xpath("//a[@aria-label='navigation menu']");
	
	
	
	
	
	
	/*@author srinivas n 20th April 2020
	 * adding elements for incenter care selection
	 * 
	 * verify the recommended care center
	 * Select 1st care center
	 * Select 2nd care center
	 * 
	 */
	public static By lsChoseCareCenter = By.id("com.care.wps.debug:id/choice_one");
	public static By txRecommed= By.xpath("//*[@text='Recommended' ] ");
	
	//care center list
	public static By lstCareCenter= By.xpath("//*[@resource-id='com.care.wps.debug:id/care_center_item_layout']");
	
	

}
