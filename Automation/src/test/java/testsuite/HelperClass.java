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
		
		click(lsChoseCareCenterType1,"A Care@Work Backup Care center");
			
		}
	//@author srinivas n 22nd April 2020
	public void navigateToAboutYourCenter() 
	{
		
		click(lsChooseCareCenterType2,"A child care center of my choosing");
			
	
		}
	
	//@author srinivas n 22nd April 2020
	public void addNetworkCenter(String BussinessName,String Zipcode,String PhoneNumber,String Totaldailycost){
		
			type(txtBusineesName,BussinessName,"Bussiness Name");
			type(txtZipcode,Zipcode,"Zipcode");
			type(txtPhonenumber,PhoneNumber,"Phone Number ");
			type(txtTotalDailyCost,Totaldailycost,"Totaldaily cost ");
			
		}
	
	//@author srinivas n 22nd April 2020
	public void navigateToReviewYourClaim()
	{
	
		click(btnNext1,"Next button in Tell us about your center");
		
	}
	
	//@author srinivas n 22nd April 2020
	public void navigateToYouAreAllSet()
	{
		
		click(chkConfirm,"Check mark for confirm");
		
		click(btnSubmit,"Submit button in Review your claim");
			
	}
	
	//@author srinivas n 22nd April 2020
	public void navigateBackToHome()
	{
		
				
		click(btnGoBackToHome,"Go back to home button in You're all set");
			
	
	}
	
	
	//@author srinivas n 22nd April 2020
	// Refresh preferred centers list based on location and radius
	
	public void refreshPreferedCenters(String location,String radius)
	{
		
				
		click(btnRefine,"Refine buutton");
		type(frmLocation,location,"loation zipcode");
		
		type(frmSearchRadius,radius,"Radius in miles");
		
				
		click(BtnDone,"Done button");
			
	}
	
	
	//@author srinivas n 22nd April 2020
public void selectCareCenter(int index)
	
	{
		List<WebElement> elements  = driver.findElements(lstCareCenter);
		elements.get(index).click();
	}
	
//@author srinivas n 22nd April 2020
	// Navigate to Add emergency contacts screen
	public void navigateToEmergenyContact()
	{
		
				
		click(btnNext,"Next button");
			
	}
	
	//@author srinivas n 22nd April 2020
	//relationship is : Mother,Father,Parent, Grandfather,Grandmother, Aunt, Uncle, Neighbor, Stepmother, Stepfather and other
	public void addPrimmaryContact(String phoneNumber,String relationship){
		
			type(txtYourPhoneNumber,phoneNumber,"Phone Number");
			type(ddlPrimaryContactRelationship,relationship,"Relationship to child");
		
	}
	
	
	
	//@author srinivas n 22nd April 2020
	//"Relationship to child : Mother,Father,Parent, Grandfather,Grandmother, Aunt, Uncle, Neighbor, Stepmother, Stepfather and other
	//@param Boolean flag = true then select checkbox can pickup/drop off child
	public void addBackupContact(String firstName,String lastName,String phoneNumber,String address1,String address2,String city,String relationship,Boolean flag){
	
			type(txtFirstName,firstName,"FirstName");
			type(txtLastName,lastName,"LastName");
			type(txtPhoneNumber,phoneNumber,"Phone Number");
			type(txtAddressLine1,relationship,"Relationship to child");
			type(txtAddressLine2,phoneNumber,"Phone Number");
			type(txtCityState,relationship,"Relationship to child");
			type(ddlRelationshipToChild,phoneNumber,"Phone Number");
			if(flag)
			click(rdoCanPickupChild,"Relationship to child");
			
			click(btnBackupContactDone1,"Done");
			
		
	}
	
	//@author srinivas n 22nd April 2020
// navigate to pediatrician & insurance information
	
	public void navigateToPediatrician()
	{
		
				
		click(btnBackupContactsNext,"Next button");
			
	
	}
	
	//@author srinivas n 22nd April 2020
	//Date Of Last Visit:date format DD/MM/YYYY eg: 21/10/2019
	public void addPediatricianInfo(String pediatricianName,String numeber,String Date){
		
		
		type(txtPediatricianName,pediatricianName,"Pediatrician Name");
		
		type(txtPediatricianPhoneNumber,numeber,"Pediatrician Phone Number");
		
		type(txtDateOfLastVisit,Date,"Date Of Last Visit");
		
	}
	
	//@author srinivas n 22nd April 2020
public void addHospitalInfo(String hospitalName,String address,String address1,String zipcode){
		
		
			type(txtHospitalName,hospitalName,"Hospital Name");
		
			type(txtHospitalAddressLine1,address,"Hospital Address Line1");
		
			type(txtHospitalAddressLine2,address1,"Hospital Address Line2");
		
			type(txtHospitalZip,zipcode,"Hospital Zip code");
		
	}
//@author srinivas n 22nd April 2020
public void addInsuranceInfo(String insuranceCompany,String policyNumber){
	
		type(txtInsuranceCompanyName,insuranceCompany,"Insurance Company Name");
	
		type(txtInsurancePolicyNumber,policyNumber,"Insurance Policy Number");
	
	}

//@author srinivas n 22nd April 2020
//Navigation for  history of allergies? question screen

public void navigateToAllergiesQuestion()
{
	
			
	click(btnPediationNext,"Next button");
		

}


public void selectQuestion(String titel,boolean flag)
{
	
	if(flag)
		
			click(btnYesButton,"Yes button");
		
	else
		click(btnNoButton,"No button");
	
}



	
public void addAllergyInfo(int option,String allergyDetails, String reactionDetail)
{
	
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
	
	}

//Special needs information 1-12 options available
public void selectSpecialNeedInfo(int option)
{
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
	
	

		click(btnSpecialNeedNext,"Special Need Next");

}


public void selectQuestion(String titel,boolean flag,String description)
{

	if(flag)
	{
			click(btnYesButton,"Yes button");
	addDescribe(description);
	}	
	else
		click(btnNoButton,"No button");
	
}

public void addDescribe(String description)
{
	
		type(txtDescriptio,description,"type description");
		
		click(btnDescriptionNext,"Next button");
	
	
}
}
