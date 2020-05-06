package testsuite;



import java.time.Duration;
import java.util.Hashtable;
import java.util.List;

import com.sun.glass.events.SwipeGesture;
import io.appium.java_client.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.remote.server.handler.interactions.touch.Down;

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

	public static void navigateToNext() throws Throwable {
		click(btnPediationNext,"nextbutton");
		Thread.sleep(2000);

	}

	public static void popuphandling() throws Throwable {
		Thread.sleep(2000);
		click(Allowclick,"Handling popup");
		Thread.sleep(2000);
	}

	public static void APacheError() throws Throwable {
		click(Unauthorised, "Selecting done");
	}

    public static void SelectChild() throws Throwable {
        click(SelectChild, "Selecting the Child");
        click(SelectDone, "Clicking the Done Button");
    }

	public static void SelectingPhysical() throws Throwable {
		click(chkPhysical, "Selecting the Child");
	}

    public static void CareReason(String selectReason) throws Throwable {
        click(By.xpath(SelectReason.replace("#", selectReason)), "Selecting the Reasons");
    }

	//If we select No_Button we need to use below method
	public static void Felt(String symptoms) throws Throwable {
		click(fell, "Selecting No Button");
		click(By.xpath(Symptoms.replace("#", "symptoms")), "Selecting Reasons");
		click(fellnext, "clicking the next button");

	}

	//If we select Yes_Button we need to use below method
	public static void Felt1() throws Throwable {
		click(fell1, "Selecting Yes Button");
		click(Returntoben,"Going to return to Benefits Page");

	}
	public static void CareType (String typeofCare) throws Throwable {
		click(By.xpath(TypeofCare.replace("#", typeofCare)), "Selecting the care");

    }

	//@author by Bhavya

	public static void addBkpContact(String firstName,String lastName,String phoneNumber,String address1,String address2,String zip,String relationship) throws Throwable {
		click(cboChooseBackupContact1,"selecting the button");
		Thread.sleep(2000);
		hideKeyboard();
		type(bkpfirstname,firstName,"firstname");
		type(bkpLastName, lastName,"lastname");
		type(bkpPhoneNumber, phoneNumber,"phonenumber");
		type(bkpAddress1, address1,"address1");
		type(bkpAddress2, address2,"address2");
		type(bkpZip, zip,"zip");
		type(bkpRelationShip, relationship,"relationship");

		click(btnBackupContactDone1, "Done");

	}

	public static void addBkpContact2(String firstName,String lastName,String phoneNumber,String address1,String address2,String zip,String relationship) throws Throwable{
		click(cboChooseBackupContact2,"selecting the button");
		Thread.sleep(2000);
		hideKeyboard();
		type(bkpfirstname,firstName,"firstname");
		type(bkpLastName, lastName,"firstname");
		type(bkpPhoneNumber, phoneNumber,"firstname");
		type(bkpAddress1, address1,"firstname");
		type(bkpAddress2, address2,"firstname");
		type(bkpZip, zip,"firstname");
		type(bkpRelationShip, relationship,"firstname");

		click(btnBackupContactDone1, "Done");

		click(nextbutton,"Next button");
		Thread.sleep(2000);
	}
	
  //@author by Bhavya

	//created on : 21-04-2020
	//click on settings icon
	//select uat25
	//click on uat25
	public static void navigateToUat() throws Throwable {
		Thread.sleep(5000);
		click(settingsicon ,"settingicon");
		Thread.sleep(5000);
		swipeVertical(0.8,0.1,0.9, 2000);
		Thread.sleep(2000);
		click(uat25,"uat25");
		Thread.sleep(2000);

	}
	//@author by Bhavya
	//created on : 21-04-2020
	//click on enroll
	public static void navigateToEnroll() throws Throwable {

		click(enroll ,"enrollbutton");
		Thread.sleep(5000);

	}

	//@author by Bhavya
	//created on : 21-04-2020

	//select company serach as acme

	public static void selectCompanySearch(String companyname, int xcod, int ycod) throws Throwable {

		click(companysearch,  "companysearch");
		type(companysearch, companyname, "companysearch");
		Thread.sleep(5000);
		WebElement dropDownLoc = driver.findElementByXPath("//*[contains(@resource-id,'company_search')]");
		int leftX = dropDownLoc.getLocation().getX();
		int rightX = leftX + dropDownLoc.getSize().getWidth();
		int middleX = (rightX + leftX) / 2;
		int upperY = dropDownLoc.getLocation().getY();
		int lowerY = upperY + dropDownLoc.getSize().getHeight();
		int middleY = (upperY + lowerY) / 2;

		// AndroidDriver.hideKeyboard();
		int x = leftX + xcod;
		int y = middleY + ycod;
		clickByCondindates(x, y);

	}

	//@author by Bhavya
	//created on : 21-04-2020


	//login flow with email and password

	public void login(String useremail,String userpass, int xcod, int ycod)throws Throwable{

		click(Login ,"loginbutton");
		Thread.sleep(2000);
		//click(companysearch , "company_search");
		Thread.sleep(2000);
		selectCompanySearch("acme", xcod ,ycod);

		type(emailfield,useremail,"email");
		Thread.sleep(2000);
		type(passwordfield, userpass,"password");
		Thread.sleep(2000);
		click(login1 , "loginbutton1");

	}

	public static void Swipedown() throws Throwable {
		Thread.sleep(2000);
		swipe(AndroidDriver, DIRECTION.DOWN);
	}

//	public static void loginsendkeys()throws Throwable {
//		Thread.sleep(5000);
//		type(emailfield,"gajulavinay1@care.com","Email");
//		Thread.sleep(2000);
//		type(passwordfield,"letmein1","Password");
//
//		Thread.sleep(2000);
//		selectCompanySearch("acme");
//
//		type(emailfield,useremail,"email");
//	}

//	public static void loginsendkeys()throws Throwable {
//		Thread.sleep(10000);
//		type(emailfield,"gajulavinay1@care.com","d");
//		Thread.sleep(2000);
//		type(passwordfield, userpass,"password");
//		Thread.sleep(2000);
//		click(login1, "loginbutton1");
//
//	}




	public static void enroll() throws Throwable{
		type(birthdate,"04/22/1992","select dob");
		//selectdate("May", "27", "1990");
		type(firstname, "sangeetha","firstname");
		Thread.sleep(2000);
		type(lastname, "nulu","lastname");
		type(homeaddress, "P.O.Box 100","address");
		type(zip, "02451","zip");
		type(email, "01jag3@gmail.com","mail");
		type(password, "123456789","pass");
		click(enrollbutton, "clickonenrollbutton");
	
	}
	
	public static void clickno() throws Throwable
	{
		click(nobutton, "no");
	}


	public static void clickyes() throws Throwable
	{
		click(yesbutton, "yes");
	}

	
	public static void mykid() throws Throwable {
		click(Selectingmykid, "Selecting the Child");
	}


	public static void billing() throws Throwable
	{
		Thread.sleep(2000);
		swipe(AndroidDriver, DIRECTION.DOWN);
		type(creditcard, "4111 1111 1111 1111", "cc number");
		type(month, "0524", "month and year");
		type(cvv, "123", "cvv number");
		type(zip1, "02451", "zip code");

		click(submitrequest, "click on submit ");

	}

	//Author Sreeranga
	// Navigate to use my backup days
	public static void navigatetousemybackupdays() throws Throwable {
		click(BackUpDays,"Backupdays");

	}

	// NAvigate to Book Now Button
	public static void navigatetoBookNow() throws Throwable {
		
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

	public static void navigateToPreferredCenters() throws Throwable
	{
		click(lsChoseCareCenterType1,"A Care@Work Backup Care center");
	}

	//@author srinivas n 22nd April 2020
	public static void navigateToAboutYourCenter() throws Throwable
	{
		click(lsChooseCareCenterType2,"A child care center of my choosing");
	}

	//@author srinivas n 22nd April 2020
	public static void addNetworkCenter(String BussinessName,String Zipcode,String PhoneNumber,String Totaldailycost)throws Throwable{

		type(txtBusineesName,BussinessName,"Bussiness Name");
		type(txtZipcode,Zipcode,"Zipcode");
		type(txtPhonenumber,PhoneNumber,"Phone Number ");
		type(txtTotalDailyCost,Totaldailycost,"Totaldaily cost ");
		hideKeyboard();
	}

	//@author srinivas n 22nd April 2020
	public static void navigateToReviewYourClaim() throws Throwable
	{
		click(btnNext1,"Next button in Tell us about your center");
	}
	//@author srinivas n 22nd April 2020
	public static void navigateToYouAreAllSet() throws Throwable
	{
		//swipeVertical(0.8,0.1,0.9, 2000);
		Thread.sleep(3000);
		swipe(AndroidDriver, DIRECTION.DOWN);
		click(chkConfirm,"Check mark for confirm");
		click(btnSubmit,"Submit button in Review your claim");

	}

	//@author srinivas n 22nd April 2020
	public static void navigateBackToHome() throws Throwable
	{

		click(btnGoBackToHome,"Go back to home button in You're all set");

	}


	//@author srinivas n 22nd April 2020
	// Refresh preferred centers list based on location and radius

	public static void refreshPreferedCenters(String location,String radius) throws Throwable{		
		if(isElementDisplayed(Deny,"Deny")){
			click(Deny,"Deny");
		}

		click(btnRefine,"Refine buutton");
		type(frmLocation,location,"loation zipcode");

		type(frmSearchRadius,radius,"Radius in miles");

		click(BtnDone,"Done button");
		Thread.sleep(2000);
		if(isElementDisplayed(Deny,"Deny")){
			click(Deny,"Deny");
		}	
	}


	//@author srinivas n 22nd April 2020
	public static void selectCareCenter(int index) throws Throwable {
		List<WebElement> elements  = driver.findElements(lstCareCenter);
		elements.get(index).click();
	}


	public static void next() throws Throwable {
		click(btnNext,"Done button");
	}

	

//@author srinivas n 22nd April 2020
	// Navigate to Add emergency contacts screen
	public static void navigateToEmergenyContact() throws Throwable
	{
		if(isElementDisplayed(Deny,"Deny")){
			click(Deny,"Deny");
		}		
		click(btnNext,"Next button");
		
	}

	
	//@author srinivas n 22nd April 2020
	//relationship is : Mother,Father,Parent, Grandfather,Grandmother, Aunt, Uncle, Neighbor, Stepmother, Stepfather and other
	public static void addPrimmaryContact(String phoneNumber,String relationship)throws Throwable{
		
			type(txtYourPhoneNumber,phoneNumber,"Phone Number");
			type(ddlPrimaryContactRelationship,relationship,"Relationship to child");

	}
	public static void Primarynext() throws Throwable {
		click(nextbutton,"Next button");
		Thread.sleep(4000);
	}
	
	//@param number ==1 backup contact 1 other wise backup contact 2
	//@author srinivas n 28th April 2020
			
	public static void selectBackupContact(int number) throws Throwable{
		
		if (number==1){
			click(cboChooseBackupContact1,"Backup contact 1");
		}else{
			click(cboChooseBackupContact2,"Backup contact 2");
		}
	}
	
	//@author srinivas n 22nd April 2020
	//"Relationship to child : Mother,Father,Parent, Grandfather,Grandmother, Aunt, Uncle, Neighbor, Stepmother, Stepfather and other
	//@param Boolean flag = true then select checkbox can pickup/drop off child

	public static void addBackupContact(String firstName,String lastName,String phoneNumber,String address1, String address2,String zipcode,String relationship,Boolean flag) throws Throwable{
	
			type(txtFirstName,firstName,"FirstName");
			type(txtLastName,lastName,"LastName");
			type(txtPhoneNumber,phoneNumber,"Phone Number");
			type(txtAddressLine1,address1,"Address line 1");
			type(txtAddressLine2,address2,"Address line 2");
			type(txtCityState,zipcode,"City state");
			type(ddlRelationshipToChild,relationship,"Relationship To Child");

			if(flag)
			click(rdoCanPickupChild,"Relationship to child");

		click(btnBackupContactDone1,"Done");


	}

	public static void addBackupContactnext() throws Throwable {
		click(btnBackupContactDone1next,"Done");

}

	//@author srinivas n 22nd April 2020
	// navigate to pediatrician & insurance information

	public static void navigateToPediatrician() throws Throwable
	{
		click(btnBackupContactsNext,"Next button");
	}

	//@author srinivas n 22nd April 2020
	//Date Of Last Visit:date format DD/MM/YYYY eg: 21/10/2019

	public static void addPediatricianInfo(String pediatricianName,String numeber,String Date) throws Throwable {
		Thread.sleep(1000);
		hideKeyboard();
		type(txtPediatricianName,pediatricianName,"Pediatrician Name");

		type(txtPediatricianPhoneNumber,numeber,"Pediatrician Phone Number");

		type(txtDateOfLastVisit,Date,"Date Of Last Visit");


//	public static void addPediatricianInfo(String pediatricianName,String number,String Date) throws Throwable {
//
//		Thread.sleep(2000);
//		hideKeyboard();
//		type(txtPediatricianName,pediatricianName,"Vinay Gajula");
//		type(txtPediatricianPhoneNumber,number,"9566778899");
//		type(txtDateOfLastVisit,Date,"05/01/2020");
//		Thread.sleep(2000);
//		swipe(AndroidDriver, DIRECTION.DOWN);


		
	}

	//@author srinivas n 22nd April 2020

//public static void addHospitalInfo(String hospitalName,String address,String address1){

//
//	public static void addHospitalInfo(String hospitalName,String address,String address1,String zipcode){
//
//
//		type(txtHospitalName,hospitalName,"Hospital Name");
//
//		type(txtHospitalAddressLine1,address,"Hospital Address Line1");
//
//		type(txtHospitalAddressLine2,address1,"Hospital Address Line2");
//
//		type(txtHospitalZip,zipcode,"Hospital Zip code");
//
//	}


			
		public static void addHospitalInfo(String hospitalName,String address,String address1,String zip) throws Throwable {
			type(txtHospitalName,hospitalName,"Hospital Name");
			type(txtHospitalAddressLine1,address,"Hospital Address Line1");
			type(txtHospitalAddressLine2,address1,"Hospital Address Line2");
			type(txtHospitalZip,zip,"zip");
	}



	//@author srinivas n 22nd April 2020
	public static void addInsuranceInfo(String insuranceCompany,String policyNumber) throws Throwable {	
		type(txtInsuranceCompanyName,insuranceCompany,"Insurance Company Name");
		type(txtInsurancePolicyNumber,policyNumber,"Insurance Policy Number");
	}

	//@author srinivas n 22nd April 2020
	//Navigation for  history of allergies? question screen

	public static void navigateToAllergiesQuestion() throws Throwable
	{
		click(btnPediationNext,"Next button");
	}


	public static void selectQuestion(String titel, boolean flag) throws Throwable
	{
		if(flag)

			click(btnYesButton,"Yes button");

		else
			click(btnNoButton,"No button");
	}




	public static void addAllergyInfo(int option,String allergyDetails, String reactionDetail) throws Throwable
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
	public static void selectSpecialNeedInfo(int option) throws Throwable
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

	
	
	  public static void enroll(String birthDate, String firstName, String lastName, String homeAddress, String zipcode, String emailid,
				String passWord) throws Throwable {
			// TODO Auto-generated method stub
		  type(birthdate,birthDate,"select dob");
			
			type(firstname, firstName,"firstname");
			Thread.sleep(2000);
			type(lastname, lastName,"lastname");
			type(homeaddress, homeAddress,"address");
			type(zip, zipcode,"zip");
			type(email, emailid,"mail");
			type(password, passWord,"pass");
			click(enrollbutton, "clickonenrollbutton");
			
		}

/*check this code**********	
		if(flag) {
			click(btnYesButton,"Yes button");
			addDescribe(description);
		}else
			click(btnNoButton,"No button");
*/

//	public static void selectQuestion(String titel,boolean flag,String description) throws Throwable
//	{
//
//		if(flag)
//		{
//			click(btnYesButton,"Yes button");
//			addDescribe(description);
//		}
//		else
//			click(btnNoButton,"No button");
//
//	}

//	public static void addDescribe(String description) throws Throwable
//	{
//
//		click(btnYesButton,"Yes button");
//		addDescribe(description);
//		Thread.sleep(2000);
//	}	
//	else
//		click(btnNoButton,"No button");
//	   Thread.sleep(2000);
//	
//}
//
//
//		type(txtDescriptio,description,"type description");
//
//		click(btnDescriptionNext,"Next button");
//
//	}

	/*MethodName: selectdate(String month, String day, String year)
	  Description: Select the date, month and year in datewheel picker by scrolling
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


	
//	public static void selectdate(String month,String day,String year) throws Throwable
//	{
//		click(birthdate, "choosedate");
//		scrollTo(year, 2);
//		scrollTo(day, 2);
//		scrollTo(month, 2);
//		click(okdate, "selectdate");
//	}
	


	/*MethodName: selecttime(String from, String to)
	  Description: Select the from and to time in datewheel picker by scrolling
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
	  Description: Select the child if already existing or create new child
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

