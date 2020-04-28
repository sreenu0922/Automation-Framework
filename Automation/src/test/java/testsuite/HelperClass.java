package testsuite;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Random;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class HelperClass extends PageLocator {
	
	

	/*MethodName: scrollTo(String text, int index)
	 * Description: scroll up and down the application until particular text is visible at particular dcroll view index
	 * input parameters: text : which is string Eg - "2020" for finding the year
	 *					index : if there are three scroll view , mentions which scroll view need to be searched
	 *Output parameters: Null
	 *created By : Jagadish
	 *created On : 21-04-2020  
	 */
	public static void scrollTo(String text, int index) {
		((FindsByAndroidUIAutomator<MobileElement>) driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(" + index
						+ ")).scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0))");

	}
  
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
        type(companysearch, companyname, "companysearch");

        WebElement dropDownLoc = driver.findElementByXPath("//*[contains(@resource-id,'company_search')]");
        int leftX = dropDownLoc.getLocation().getX();
        int rightX = leftX + dropDownLoc.getSize().getWidth();
        int middleX = (rightX + leftX) / 2;
        int upperY = dropDownLoc.getLocation().getY();
        int lowerY = upperY + dropDownLoc.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        AndroidDriver.hideKeyboard();
        int x = leftX + 80;
        int y = middleY + 150;
        clickByCondindates(x, y);
	
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
		Thread.sleep(10000);
		type(emailfield,"bhavya444@care.com","d");
		Thread.sleep(2000);
		type(passwordfield,"letmein1","");
		Thread.sleep(2000);
		click(login1 , "loginbutton1");
		
		
	}
	
	
	
	public void enroll() throws Throwable
	{
		type(birthdate,"04/22/1992","select dob");
		//selectdate("May", "27", "1990");
		type(firstname, "sangeetha","firstname");
		Thread.sleep(2000);
		type(lastname, "nulu","lastname");
		type(homeaddress, "P.O.Box 100","address");
		type(zip, "02451","zip");
		type(email, "jag3@gmail.com","mail");
		type(password, "123456789","pass");
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
	public void navigateToPreferredCenters() throws Throwable 
	{
		click(lsChoseCareCenterType1,"A Care@Work Backup Care center");		
	}
	
	//@author srinivas n 22nd April 2020
	public void navigateToAboutYourCenter() throws Throwable 
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
	public void navigateToReviewYourClaim() throws Throwable
	{
	
		click(btnNext1,"Next button in Tell us about your center");
		
	}
	
	//@author srinivas n 22nd April 2020
	public void navigateToYouAreAllSet() throws Throwable
	{
		
		click(chkConfirm,"Check mark for confirm");
		
		click(btnSubmit,"Submit button in Review your claim");
			
	}
	
	//@author srinivas n 22nd April 2020
	public void navigateBackToHome() throws Throwable
	{
				
		click(btnGoBackToHome,"Go back to home button in You're all set");		
	
	}
	
	
	//@author srinivas n 22nd April 2020
	// Refresh preferred centers list based on location and radius
	
	public void refreshPreferedCenters(String location,String radius) throws Throwable
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
	public void navigateToEmergenyContact() throws Throwable
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
	public void addBackupContact(String firstName,String lastName,String phoneNumber,String address1,String address2,String city,String relationship,Boolean flag) throws Throwable{
			
			click(cboChooseBackupContact1,"backup contact1");
			type(txtFirstName,firstName,"FirstName");
			type(txtLastName,lastName,"LastName");
			type(txtPhoneNumber,phoneNumber,"Phone Number");
			type(txtAddressLine1,address1,"Relationship to child");
			type(txtAddressLine2,address2,"Phone Number");
			type(txtCityState,city,"Relationship to child");
			type(ddlRelationshipToChild,relationship,"Phone Number");
			if(flag)
			click(rdoCanPickupChild,"Relationship to child");
			
			click(btnBackupContactDone1,"Done");
			
		
	}
	
	//@author srinivas n 22nd April 2020
// navigate to pediatrician & insurance information
	
	public void navigateToPediatrician() throws Throwable
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

public void navigateToAllergiesQuestion() throws Throwable
{
	click(btnPediationNext,"Next button");	
}


public void selectQuestion(String titel,boolean flag) throws Throwable
{
	if(flag)
		
		click(btnYesButton,"Yes button");
		
	else
		click(btnNoButton,"No button");	
}



	
public void addAllergyInfo(int option,String allergyDetails, String reactionDetail) throws Throwable
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
public void selectSpecialNeedInfo(int option) throws Throwable
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


public void selectQuestion(String titel,boolean flag,String description) throws Throwable
{

	if(flag)
	{
		click(btnYesButton,"Yes button");
		addDescribe(description);
	}	
	else
		click(btnNoButton,"No button");
	
}

public void addDescribe(String description) throws Throwable
{
	
		type(txtDescriptio,description,"type description");
		
		click(btnDescriptionNext,"Next button");
	
}

	/*MethodName: selectdate(String month, String day, String year)
	 * *Description: Select the date, month and year in datewheel picker by scrolling
	 * input parameters: month : provide the month as displayed in the application Eg; Apr
	 *					day :provide the day as displayed in the application Eg; 20
	 *					year: provide the year as displayed in the application Eg; 2020
	 *Output parameters: Null
	 *created By : Jagadish
	 *created On : 21-04-2020  
	 */
	public static void selectdate(String month, String day, String year) throws Throwable {
		if(isElementDisplayed(By.xpath(date.replace("#",month+" "+day)), "searching date exists")) {
			click(By.xpath(date.replace("#",month+" "+day))," clickin on date");
			click(datecontinue, "datecontinue");
		}else {
			if(isElementDisplayed(choosedate, "choosedate")) {
				click(choosedate, "choosedate");
			}
			scrollTo(year, 2);
			scrollTo(day, 1);
			scrollTo(month, 0);
			if (isElementDisplayed(boy, "childexist")) {
				click(done, "done");
			} else {
				click(dateOk, "dateOk");
				if(isElementDisplayed(datecontinue, "datecontinue")) {
					click(datecontinue, "datecontinue");
				}
			}
		}
		
		
	}
	
	
	/*MethodName: selecttime(String from, String to)
	 * *Description: Select the from and to time in datewheel picker by scrolling
	 * input parameters: from : provide the from date as displayed in the application Eg; 10:00 AM
	 *					to :provide the today as displayed in the application Eg; 06:00 PM
	 *Output parameters: Null
	 *created By : Jagadish
	 *created On : 21-04-2020  
	 */
	public static void selecttime(String from, String to) throws Throwable {
		scrollTo(from, 0);
		scrollTo(to, 1);
		click(timenext, "timenext");
	}
	
	/*MethodName: selectchild()
	 * *Description: Select the child if already existing or create new child 
	 * input parameters: Null
	 *Output parameters: Null
	 *created By : Jagadish
	 *created On : 21-04-2020  
	 */
	public static void selectchild() throws Throwable {
		if (isElementDisplayed(boy, "childexist")) {
			click(boy, "clicked");
			type(childfirstname, "testtest", "firstname");
			type(childlastname, "dummy", "lastname");
			type(birthday, "03/21/2016","");
			click(timenext,"next");
		} 
		if(isElementDisplayed(existingchild, "existingchild")){
			click(existingchild, "existingchild");
			click(done, "done");
		}
	}

}

