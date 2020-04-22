package testsuite;


import java.util.List;

import org.openqa.selenium.WebElement;

public class HelperClass extends PageLocator {

	
	//Author Sreeranga
	// Navigate to use my backup days
	public void navigatetousemybackupdays() throws Throwable {
		click(BackUpDays,"Backupdays");
		
	}
	
	// NAvigate to Book Now Button
	public void navigatetoBookNow() throws Throwable {

		click(BookNow , "BookNowButton");

	}

	
	
	/*
	 * @author srinivas n 22nd April 2020
	 * 
	 * navigateToPreferredCenters
	 * navigateToAboutYourCenter
	 * networkCenter
	 * navigateToReviewYourClaim
	 * navigateToYouAreAllSet
	 * navigateBackToHome
	 * 
	 * refreshPreferedCenters
	 * selectCareCenter
	 * navigateEmergenyContact
	 * primmaryContact
	 * backupContact
	 * navigatePediatrician
	 * pediatricianInfo
	 * hospitalInfo
	 * insuranceInfo
	 * navigateallergiesQuestion
	 * specialNeedInfo
	 * 
	 * Question(String titel,boolean flag,String description)
	 * describe
	 */
	public void navigateToPreferredCenters()
	{
		try{
		click(lsChoseCareCenterType1,"A Care@Work Backup Care center");
			
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	
	public void navigateToAboutYourCenter()
	{
		try{
		click(lsChooseCareCenterType2,"A child care center of my choosing");
			
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	public void networkCenter(String BussinessName,String Zipcode,String PhoneNumber,String Totaldailycost){
		try {
			type(txtBusineesName,BussinessName,"Bussiness Name");
			type(txtZipcode,Zipcode,"Zipcode");
			type(txtPhonenumber,PhoneNumber,"Phone Number ");
			type(txtTotalDailyCost,Totaldailycost,"Totaldaily cost ");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void navigateToReviewYourClaim()
	{
		try{
		click(btnNext1,"Next button in Tell us about your center");
			
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void navigateToYouAreAllSet()
	{
		try{
		click(chkConfirm,"Check mark for confirm");
		
		click(btnSubmit,"Submit button in Review your claim");
			
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void navigateBackToHome()
	{
		try{
				
		click(btnGoBackToHome,"Go back to home button in You're all set");
			
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	// Refresh preferred centers list based on location and radius
	
	public void refreshPreferedCenters(String location,String radius)
	{
		try{
				
		click(btnRefine,"Refine buutton");
		type(frmLocation,location,"loation zipcode");
		
		type(frmSearchRadius,radius,"Radius in miles");
		
		//click(frmSearchRadius,"Search Radius");
		
		//type(milespDropdown,radius,"Radius in miles");
		
		//click(btnMilesDone,"Done in miles dropdown");
		
		click(BtnDone,"Done button");
			
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
public void selectCareCenter(int index)
	
	{
		List<WebElement> elements  = driver.findElements(lstCareCenter);
		elements.get(index).click();
	}
	
	// Navigate to Add emergency contacts screen
	public void navigateEmergenyContact()
	{
		try{
				
		click(btnNext,"Next button");
			
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	//relationship is : Mother,Father,Parent, Grandfather,Grandmother, Aunt, Uncle, Neighbor, Stepmother, Stepfather and other
	public void primmaryContact(String phoneNumber,String relationship){
		try {
			type(txtYourPhoneNumber,phoneNumber,"Phone Number");
			type(ddlPrimaryContactRelationship,relationship,"Relationship to child");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//"Relationship to child : Mother,Father,Parent, Grandfather,Grandmother, Aunt, Uncle, Neighbor, Stepmother, Stepfather and other
	public void backupContact(String firstName,String lastName,String phoneNumber,String address1,String address2,String city,String relationship,Boolean b){
		try {
			type(txtFirstName,firstName,"FirstName");
			type(txtLastName,lastName,"LastName");
			type(txtPhoneNumber,phoneNumber,"Phone Number");
			type(txtAddressLine1,relationship,"Relationship to child");
			type(txtAddressLine2,phoneNumber,"Phone Number");
			type(txtCityState,relationship,"Relationship to child");
			type(ddlRelationshipToChild,phoneNumber,"Phone Number");
			if(b)
			click(rdoCanPickupChild,"Relationship to child");
			
			click(btnBackupContactDone1,"Done");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
// navigate to pediatrician & insurance information
	
	public void navigatePediatrician()
	{
		try{
				
		click(btnBackupContactsNext,"Next button");
			
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	//Date Of Last Visit:date format DD/MM/YYYY eg: 21/10/2019
	public void pediatricianInfo(String pediatricianName,String numeber,String Date){
		
		try {
		type(txtPediatricianName,pediatricianName,"Pediatrician Name");
		
			type(txtPediatricianPhoneNumber,numeber,"Pediatrician Phone Number");
		
		type(txtDateOfLastVisit,Date,"Date Of Last Visit");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void hospitalInfo(String hospitalName,String address,String address1,String zipcode){
		
		try {
			type(txtHospitalName,hospitalName,"Hospital Name");
		
			type(txtHospitalAddressLine1,address,"Hospital Address Line1");
		
			type(txtHospitalAddressLine2,address1,"Hospital Address Line2");
		
			type(txtHospitalZip,zipcode,"Hospital Zip code");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public void insuranceInfo(String insuranceCompany,String policyNumber){
	
	try {
		
		type(txtInsuranceCompanyName,insuranceCompany,"Insurance Company Name");
	
		type(txtInsurancePolicyNumber,policyNumber,"Insurance Policy Number");
	
		} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//Navigation for  history of allergies? question screen

public void navigateAllergiesQuestion()
{
	try{
			
	click(btnPediationNext,"Next button");
		
} catch (Throwable e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}


public void Question(String titel,boolean flag)
{
	try {
	if(flag)
		
			click(btnYesButton,"Yes button");
		
	else
		click(btnNoButton,"No button");
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



	
public void allergyInfo(int option,String allergyDetails, String reactionDetail)
{
	try {
		switch(option){
	case 1:
		
			click(chkMedications,"Medications");
		
		type(txtAllergyDetail,allergyDetails,"allergy details");
		type(txtReactionDetail,reactionDetail,"Reaction Detail");
		break;
	case 2:
		click(chkFood,"Food");
		type(txtAllergyDetail,allergyDetails,"allergy details");
		type(txtReactionDetail,reactionDetail,"Reaction Detail");
		
		break;
	case 3:
		click(chkRespiratory,"Respiratory");
		type(txtAllergyDetail,allergyDetails,"allergy details");
		type(txtReactionDetail,reactionDetail,"Reaction Detail");
		
		break;
	case 4:
		click(chkBeesting,"Beesting");
		type(txtAllergyDetail,allergyDetails,"allergy details");
		type(txtReactionDetail,reactionDetail,"Reaction Detail");
		
		break;
	case 5:
		click(chkOtherr,"other");
		type(txtAllergyDetail,allergyDetails,"allergy details");
		type(txtReactionDetail,reactionDetail,"Reaction Detail");
		
		break;
		
	default:
		System.out.println("There is no value");
		}
	
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
}

//Special needs information 1-12 options available
public void specialNeedInfo(int option)
{
	try {
		switch(option){
	case 1:
		
			click(chkPhysical,"Physical therapy");
		
		break;
	case 2:
		click(chkSpeech,"Speech therapy");
		
		
		break;
	case 3:
		click(chkOccupational,"Occupational therapy");
		
		break;
	case 4:
		click(chkApplied,"Applied behavior analusis");
		
		break;
	case 5:
		click(chkMobility,"Mobility device");
		break;
	case 6:
		click(chkCommunication,"Communication Device");
		break;
	case 7:
		click(chkFeeding,"  Feeding tube");
		
		break;
	case 8:
		click(chkVisual,"Visual support");
		
		break;
	case 9:
		click(chkAuditory,"Auditory support");
		
		break;
	case 10:
		click(chkChild,"Child therapist at center");
		
		break;
	case 11:
		click(chkOther,"Other");
		
		break;
		
	default:
		System.out.println("There is no value");
		}
	
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	
	try {
		click(btnSpecialNeedNext,"Special Need Next");
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public void Question(String titel,boolean flag,String description)
{
	try {
	if(flag)
	{
			click(btnYesButton,"Yes button");
	describe(description);
	}	
	else
		click(btnNoButton,"No button");
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void describe(String description)
{
	try {
		type(txtDescriptio,description,"type description");
		
		click(btnDescriptionNext,"Next button");
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
