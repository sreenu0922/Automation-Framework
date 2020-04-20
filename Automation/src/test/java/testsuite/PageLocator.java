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
	public static By txRecommed = By.xpath("//*[@text='Recommended' ] ");
	
	//care center list
	public static By lstCareCenter = By.xpath("//*[@resource-id='com.care.wps.debug:id/care_center_item_layout']");
	public static By btnRefine = By.id("com.care.wps.debug:id/refine_cta");
	public static By btnNext = By.id("com.care.wps.debug:id/next_cta");
	//After click on next button app was displaying dilogbox below are elemets for dilogbox
	public static By dlgText = By.id("com.care.wps.debug:id/dialog_description");
	public static By dlgButtonOk = By.id("com.care.wps.debug:id/dialog_positive_button");
	
	//After click on Refine button app was displaying change location and radious below are elemtes related to change location and radious
	public static By frmLocation = By.id("com.care.wps.debug:id/location");
	public static By frmSearchRadius = By.id("com.care.wps.debug:id/search_radius");
	public static By milespDropdown = By.xpath("//* [@class='android.widget.TextView' ] ");
	public static By btnMilesDone = By.id("com.care.wps.debug:id/done");
	public static By BtnCancel = By.id("com.care.wps.debug:id/cancel");
	public static By BtnDone = By.id("com.care.wps.debug:id/done");
	
	
	

}
