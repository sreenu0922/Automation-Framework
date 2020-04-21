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
	public static By lsChoseCareCenterType1 = By.id("choice_one");
	public static By txRecommed = By.xpath("//*[@text='Recommended' ] ");
	public static By lsChooseCareCenterType2 = By.id("choice_two");
	

	//select care center type 2(tell us about your center) app displaying list of care centers
	By txtBusineesName = By.id("full_name_edt");
	public static By txtZipcode= By.id("city_state_zip");
	public static By txtPhonenumber=By.id("phone_number");
	public static By txtTotalDailyCost=By.id("dolar_rate");
	public static By btnNext1=By.id("get_reimbursed");
	
	//Review your claim
	
	public static By chkConfirm = By.xpath("(//* [contains(@resource-id,'right_view' ) ])[3]");
	public static By btnSubmit = By.id("cta_submit");
	public static By btnCancel = By.id("cancel");
	
	//You're all set
	public static By btnCloseButton = By.id("close_button");
	public static By btnGoBackToHome = By.id("go_back");
	
	//select care center type 1 app displaying list of care centers
	public static By lstCareCenter = By.xpath("//*[@resource-id='com.care.wps.debug:id/care_center_item_layout']");
	public static By btnRefine = By.id("refine_cta");
	public static By btnNext = By.id("next_cta");
	//After click on next button with out select care center app was displaying dilogbox below are elemets for dilogbox
	public static By dlgText = By.id("dialog_description");
	public static By dlgButtonOk = By.id("dialog_positive_button");
	
	//After click on Refine button app was displaying change location and radious below are elemtes related to change location and radious
	public static By frmLocation = By.id("location");
	public static By frmSearchRadius = By.id("search_radius");
	public static By milespDropdown = By.xpath("//* [@class='android.widget.TextView' ] ");
	public static By btnMilesDone = By.id("done");
	public static By BtnCancel = By.id("cancel");
	public static By BtnDone = By.id("done");
	
	// After click on next app was navigate to Add emergency contacts page
	
	//Primary contacts
	public static By txtYourPhoneNumber = By.id("primary_phone_number");
	public static By ddlPrimaryContactRelationship = By.id("primary_contact_relationship");
	public static By ddlRelationshipToClient = By.xpath("//* [@class='android.widget.TextView']");
	public static By btnDone = By.id("done");
	
	//Backup contact1
	public static By cboChooseBackupContact1 = By.id("backup_contact_one");
	
	public static By txtFirstName = By.id("first_name");
	public static By txtLastName = By.id("last_name");
	public static By txtPhoneNumber = By.id("phone_number");
	public static By txtAddressLine1 = By.id("address_line_1");
	public static By txtAddressLine2 = By.id("address_line_1");
	public static By txtCityState = By.id("address_line_1");
	public static By ddlRelationshipToChild = By.id("relationship_to_child");
	public static By ddlSelectionRelationType = By.xpath("//*[@class='android.widget.TextView']");
	public static By btnDDLSelectionDone = By.id("cta");
	public static By btnNavigationUp = By.id("navigate_up");
	public static By btnNavigationDown = By.id("navigate_down");
	public static By rdoCanPickupChild = By.id("canPickupChild");
	public static By btnBackupContactDone1= By.id("backup_contact_done_cta");
	
	
	//Backup contact2
		public static By cboChooseBackupContact2 = By.id("backup_contact_two");
		
		public static By txtFirstName2 = By.id("first_name");
		public static By txtLastName2 = By.id("last_name");
		public static By txtPhoneNumber2 = By.id("phone_number");
		public static By txtAddressLine12 = By.id("address_line_1");
		public static By txtAddressLine22 = By.id("address_line_1");
		public static By txtCityState2 = By.id("address_line_1");
		public static By ddlRelationshipToChild2 = By.id("relationship_to_child");
		public static By ddlSelectionRelationType2 = By.xpath("//*[@class='android.widget.TextView']");
		public static By btnDDLSelectionDone2 = By.id("cta");
		public static By btnNavigationUp2 = By.id("navigate_up");
		public static By btnNavigationDown2 = By.id("navigate_down");
		public static By rdoCanPickupChild2 = By.id("canPickupChild");
		public static By btnBackupContactDone2= By.id("backup_contact_done_cta");
		
	public static By btnBackupContactsNext = By.id("next");
	
	// Add pediatrician & insurance information
	public static By txtTitle = By.id("title");
	//PEDIATRICIAN INFO
	public static By txtPediatricianTitle = By.id("pediatrician_title");
	public static By txtPediatricianName = By.id("pediatrician_name");
	public static By txtPediatricianPhoneNumber = By.id("pediatrician_phone_number");
	public static By txtDateOfLastVisit = By.id("last_phy_exam_date");
	
	//HOSPITAL INFO
	public static By txtHospitalTitle = By.id("hospital_title");
	public static By txtHospitalName = By.id("hospital_name");
	public static By txtHospitalAddressLine1 = By.id("hospital_address_line1");
	public static By txtHospitalAddressLine2 = By.id("hospital_address_line2");
	public static By txtHospitalZip = By.id("hospital_city_state_zip");
	
	//INSURANCE INFO
	public static By txtInsuranceTitle = By.id("insurance_title");
	
	public static By txtInsuranceCompanyName = By.id("insurance_company_name");
	public static By txtInsurancePolicyNumber = By.id("insurance_policy_number");
	public static By btnPediationNext = By.id("next_button");
	
	
	//Does cd have a history of allergies?
	
	public static By txtQuestion = By.id("question");
	public static By btnYes = By.id("yes_button");// navigate to Allergy information
	public static By btnNo = By.id("no_button");//No button navigate to Special needs information
	
	//Allergy information
	
	By chkMedications = By.xpath("(//*[@class='android.widget.CheckBox'])[1]");
	By chkFood = By.xpath("(//*[@class='android.widget.CheckBox'])[2]");
	By chkRespiratory = By.xpath("(//*[@class='android.widget.CheckBox'])[3]");
	By chkBeesting = By.xpath("(//*[@class='android.widget.CheckBox'])[4]");
	By chkOtherr = By.xpath("(//*[@class='android.widget.CheckBox'])[5]");
	
	//Special needs information
	public static By txtSpecialNeedsTitle = By.id("title");
	
	//check that apply
	public static By chkPhysical = By.id("physical_checkbox");
	public static By chkSpeech = By.id("speech_checkbox");
	public static By chkOccupational = By.id("occupational_checkbox");
	public static By chkApplied = By.id("applied_checkbox");
	public static By chkMobility = By.id("mobility_checkbox");
	public static By chkCommunication = By.id("communication_checkbox");
	public static By chkFeeding = By.id("feeding_checkbox");
	public static By chkVisual = By.id("visual_checkbox");
	public static By chkAuditory = By.id("auditory_checkbox");
	public static By chkChild = By.id("child_checkbox");
	public static By chkOther = By.id("other_checkbox");
	
	public static By btnSpecialNeedNext = By.id("next_button");
	
	//Does cd take any medications that will need to be administered during backup care?
	public static By txtQuestionTitle = By.id("question");
	public static By btnYesButton = By.id("yes_button"); //navigate to Please describe screen
	public static By btnNoButton = By.id("no_button"); //click on no again question
	
	//Please describe
	public static By txtDescriptio = By.id("describe");
	public static By btnDescriptionNext = By.id("next");
	
	/*Is there anything we should know about cd to ensure the best quality care?
	*question
	*yes_button //navigate to Please describe screen
	*no_button
	*
	*Please describe
	*describe
	*next
	*
	* //Can the daycare center take photos or videos of your child?
	*question
	*yes_button// navigate to review request
	*no_button //navigate to review request
	*	
	*	Reuse above locators for question, Yes button, No button , Description and Next button
	*/
	
	
	
	

	//author Sreeranga
	
	//Select Use my backUp days
	public static By  BackUpDays= By.id("use_my_backup_days");
	//select BookNow Button
	public static By BookNow = By.id("ctabutton");
	
	
	}



