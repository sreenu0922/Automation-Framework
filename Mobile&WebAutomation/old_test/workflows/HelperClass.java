package com.desktopWeb.workflows;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ctaf.utilities.Reporter;
import com.desktopWeb.testObjects.PageLocators;

public class HelperClass extends PageLocators{
	
	public void handleAuthPopup() throws IOException, InterruptedException{
		//Runtime.getRuntime().exec("C:\\Users\\E002917\\workspace\\DPC_chrome\\src\\test\\java\\com\\desktopWeb\\scripts\\autoit\\auth_popup.exe");
		//Thread.sleep(40000);
	}
	
	public void verifyWebElementHomePage() throws Throwable{
		logger.info("in verifyWebElementHomePage");
		//Verify header
		isElementDisplayed(menu,"Hamburger Menu");
		isElementDisplayed(engageviclogo, "Engage Victoria Logo");
		isElementDisplayed(searchSite,"Search Site");
		
		//Verify hero block
		isElementDisplayed(heroblock_engagevictoria,"Text - Engage Victoria' on hero block ");
		isElementDisplayed(heroblock_txt,"Text - Share ideas here and have your say about what"
				+ " matters to you");
		isElementDisplayed(heroblock_img,"Image on hero block");
		
		//Verify Advance search section
		isElementDisplayed(txt_imlookingfor,"Text - I'm looking for consultations relating to");		
		isElementDisplayed(categorySearchbtn,"Drop Down for Category");
		isElementDisplayed(categoryhelpmefinebtn,"Help me find a consultation");
		
		//Website feature section
		isElementDisplayed(websiteFeature,"WebSite feature section");
		
		//Active Consultation section
		isElementDisplayed(sectionActiveProjects,"Active Consultation section");
		
		//Stay Informed section
		isElementDisplayed(sectionStayInformed,"Stay informed section");
		isElementDisplayed(susbscribeemail, "Sign up email");
		isElementDisplayed(susbscribeSignupbtn, "Sign up Today");
		
		
		//Footer section
		isElementDisplayed(sectionsubscribe, "Footer section with Links");
		isElementDisplayed(sectionfooter,"Footer section with copyright message");
		
		
		//FooterLinks
		isElementDisplayed(footercopyrightlnk,"Footer Link - Copyright");
		isElementDisplayed(footerprivacylnk,"Footer Link - Privacy");
		isElementDisplayed(footertermsofUselnk,"Footer Link - Terms of Use");
		isElementDisplayed(footeraccessibilitylnk,"Footer Link - Accessibility");
		isElementDisplayed(footermoderationlnk,"Footer Link - Moderation");
		isElementDisplayed(footercommunityGuidelineslnk,"Footer Link - Community Guidelines");
		isElementDisplayed(footeraboutUslnk,"Footer Link - About Us");
		isElementDisplayed(footercontactUslnk,"Footer Link - Contact Us");
		isElementDisplayed(footersiteMaplnk,"Footer Link - Site Map");
		
		}
	
	public void verifyHamberger() throws Throwable{
		logger.info("in verifyHamburger");
		Thread.sleep(10000);
		boolean islogin = false;
		// check if user has login
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if((driver.findElements(loginfromfooter).size()!=1)){
			islogin = true;
		}
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		//Click on hamberger menu	
		click(menu, "Menu");
		Thread.sleep(15000);
		//Verify the presence of items in Haberger Menu
		isElementDisplayed(menuHome,"Hamberger Menu/Home");
		isElementDisplayed(menuAbout,"Hamberger Menu/About");
		isElementDisplayed(menuConsultations,"Hamberger Menu/Consultation");
		isElementDisplayed(menuContactus,"Hamberger Menu/Contact us");
		if(islogin){
			isElementDisplayed(menuSignOut, "Sign Out");
		}else isElementDisplayed(menuLogin,"Hamberger Menu/Login");
		
		//Verify item Menu/Home
		click(menuHome,"Menu/Home");
		assertTitle(titleHome);
		assertElementPresent(heroblock_img, "Hero Block image on home page");
		Thread.sleep(10000);
		
		//Verify item Menu/About
		click(menu, "Menu");
		Thread.sleep(10000);
		click(menuAbout, "Click on Menu/About");
		assertTitle(titleAbout);
		assertElementPresent(valeleAbout, "About Page");
		clickOnBreadcrumbs();
		
		Thread.sleep(10000);
		//Verify item Menu/Consultation
		click(menu, "Menu");
		Thread.sleep(5000);
		click(menuConsultations, "Click on Menu/Consultation");
		assertTitle(titleConsultations);
		assertElementPresent(valeleConsultations, "Consultation page");
		clickOnBreadcrumbs();
		
		//Verify item Menu/Contact us
		Thread.sleep(10000);
		click(menu, "Menu");
		Thread.sleep(5000);
		click(menuContactus, "Click on Menu/Contact us");
		assertTitle(titleContactus);
		assertElementPresent(valeleContactus, "Contact page");
		clickOnBreadcrumbs();
		
		Thread.sleep(10000);
		click(menu, "Menu");
		Thread.sleep(10000);
		//Verify item Menu/Login .. first verify if some user has login 
		if(!islogin){
			click(menuLogin, "Click on Menu/Login");
			assertElementPresent(valeleLogin, "Login page");
			click(loginCross, "Close login window");
		}else{
			Thread.sleep(5000);
			isElementDisplayed(menuSignOut, "Menu/SignOut");
			click(menu, "Menu");
		}
		
	}
	
	public void clickOnBreadcrumbs() throws Throwable{
		logger.info("in clickOnBreadcrumbs");
		//Click on Home/..
		scrollandClick(breadcrumbs);
	}
	
	public void verifyInvalidLoginMessage(String emailid, String passwd, String from) throws Throwable{
		logger.info("in verifyInvalidLoginMessage");
		if(from.equalsIgnoreCase("menu")){
			click(menu,"Menu");
			click(menuLogin, "Click on Menu/Login");
		}else if (from.equalsIgnoreCase("Footer")){
			click(loginfromfooter, "Link to login from footer");
		}
		
		//Enter invalid UserID or Password
		type(loginEmail, emailid, "Email Address");
		type(loginPassword, passwd, "Password");
		click(loginloginbtn, "Login");
		
		//verify error message - Invalid email address or password. 
		assertText(loginErrorMsg, "Please enter a valid email address.");
		
		click(loginCross, "Close window");
		click(menu, "Menu");
	}
	
	public void login(String emailid, String password, String from) throws Throwable{
		logger.info("in login");
		if(!password.equalsIgnoreCase("guest")){
		
			//Open login window
			if (from.equalsIgnoreCase("Footer")){
				click(loginfromfooter, "Link to login from footer");
			}else if(from.equalsIgnoreCase("Menu")){
				click(menu,"Menu");
				click(menuLogin, "Click on Menu/Login");
			}
		
			//Enter username, password and select login button
			type(loginEmail, emailid, "Email address");
			type(loginPassword, password, "Password");
			click(loginloginbtn, "Login button");
			Thread.sleep(5000);
		}
		
	}
	
	public void resetPasswordLinktoEmail(String email) throws Throwable{
		logger.info("in resetpasswordLinktoEmail");
		//navigate to forgot password link
		click(menu,"Menu");
		click(menuLogin, "Menu/Login");
		
		//Select forgot password
		click(loginForgotPwd,"Forgot password");
		
		//enter email address to recover password
		type(forgotpwdemail,email,"Email address");
		click(forgotresetbtn, "Reset and Email Password");
		Thread.sleep(5000);
		
		assertText(forgotPwdMes, "If there is an account associated with this email, "
				+ "instructions for resetting your password have been sent.");
	
		click(resetPwdCross, "Close window");
		
		click(menu, "Menu");
	}
	
	public void forgotPassword(String emailid, String emailpassword, String newpassword) throws Throwable{
		logger.info("in forgotPassword");
		try{
			//Initiate forgot password
			resetPasswordLinktoEmail(emailid);
			
			//wait for email to come
			Thread.sleep(10000);
			
			//resetPassword(emailid, emailpassword, newpassword);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void resetPassword(String emailid, String emailpassword, String newpassword) throws Throwable{
		logger.info("in resetPassword");
		String emailaccurl = "https://www.gmail.com";
		
		//Access url to email account
		driver.get(emailaccurl);
		//enter email id
		type(loginemailID, emailid, "Email ID");
		//select next button
		click(emailNextbtn, "Next button");
		//enter password
		Thread.sleep(2000);
		type(emailPasswd, emailpassword, "Email Password");
		//Signin button
		click(emailsignInbtn, "Sign in button");
		//select email with subject - Forgot Password
		click(emailResetPwdsubject, "open forgot email");
		//select reset passwd url
		//String resetpwdURL = getAttribute(emailreseturl, "href", "Reset passowrd URL");

		click(emailreseturl, "Password reset link");
					
		switchWindowByTitle("Engage Victoria :: Home");
		
		//set new password
		type(resetPwdnwPwd, newpassword, "New password");
		type(resetPwdcnfPwd, newpassword, "Confirm Password");
		click(resetPwdbtn, "Reset password button");
		
		//Verify msg - Password successfully changed.
		String successMsg = driver.findElement(pwdchangedmsg).getText();
		Assert.assertEquals(successMsg,"Password successfully changed.");
		
		//navigate to home page
		click(gotohmpg, "Go to home page");
		assertTitle(titleHome);
	}
	
	public void changePassword(String emailid, String currentpwd, String newpwd) throws Throwable{
		logger.info("in changePassword");
		//login to application with existing password		
		login(emailid, currentpwd, "Menu");
		
		//Select Dashboard
		click(menuDashboard, "Select Dashboard");
		
		//Click on profile link at the end of Dashboard
		click(dashboardLinktoProfile, "Dashboard/Profile");
		
		//Click Edit Profile
		click(accountEditProfile, "Edit Profile");
		
		//Enter new Password and save
		type(EditprofileNewPwd, currentpwd, "New password"); 
		type(EditprofileConfirmPwd, currentpwd, "New password");
		click(EditprofileSave, "Save button");
	
	}
	
	public void signOut(String from) throws Throwable{
		logger.info("in signOut");
		if(from.equalsIgnoreCase("Menu")){
			scrollTo(menu);
			clickTo(menu);
			click(menuSignOut, "Menu/Sign Out");
		}else if(from.equalsIgnoreCase("footer")){
			scrollandClick(signoutfromfooter);
		}
	}
	
	public void verifyFooterLinks() throws Throwable{
		logger.info("in verifyFooterLinks");
		//verify all links present in footer
		click(footercopyrightlnk, "Footer/Copyright");
		assertTitle(titleCopyRight);
		assertElementPresent(valeleCopyRight, "Copyright page");
		clickOnBreadcrumbs();
		
		click(footerprivacylnk, "Footer/Privacy");
		assertTitle(titlePrivacyPolicy);
		assertElementPresent(valelePrivacyPolicy, "Privacy Policy page");
		clickOnBreadcrumbs();
		
		click(footertermsofUselnk, "Footer/Term of Use");
		assertTitle(titleTermsofUse);
		assertElementPresent(valeleTermsofUse, "Terms of Use page");
		clickOnBreadcrumbs();
		
		click(footeraccessibilitylnk, "Footer/Accessibility");
		assertTitle(titleAccessibility);
		assertElementPresent(valeleAccessibility, "Accessibility page");
		clickOnBreadcrumbs();
		
		click(footermoderationlnk, "Footer/Moderation");
		assertTitle(titleModerationPolicy);
		assertElementPresent(valeleModerationPolicy, "Moderation Policy page");
		clickOnBreadcrumbs();
		
		click(footercommunityGuidelineslnk, "Footer/Community Guidelines");
		assertTitle(titleCommunityGuidelines);
		assertElementPresent(valeleCommunityGuidelines, "Community Guidelines page");
		clickOnBreadcrumbs();
		
		click(footeraboutUslnk, "Footer/About Us");
		assertTitle(titleAbout);
		assertElementPresent(valeleAbout, "About page");
		clickOnBreadcrumbs();
		
		click(footercontactUslnk, "Footer/Contact Us");
		assertTitle(titleContactus);
		assertElementPresent(valeleContactus, "Contact Us page");
		clickOnBreadcrumbs();
		
		click(footersiteMaplnk, "Footer/Site Map");
		assertTitle(titleSitemap);
		assertElementPresent(valeleSitemap, "Site Map page");
		clickOnBreadcrumbs();
		
		click(footerGovOfVicfooterlnk, "Footer/The State Government of Victoria.");
		switchWindowByTitle(titleGovofVic);
		assertTitle(titleGovofVic);
		assertElementPresent(valeleGovofVic, "The State Government of Victoria page");
		
		switchWindowByTitle(titleHome);
		click(footerTheHive, "The Hive");
		switchWindowByTitle(titleTheHive);
		assertTitle(titleTheHive);
		assertElementPresent(valeleTheHive, "The Hive page");
		
	}
	
	public void signup(String interest, String from) throws Throwable{
		logger.info("in signup");
		String screenname = getRandomString(10);
		String signemailid = screenname+"@login";
		String signpasswd = "passworD4321";
		String postcode = "3000"; 
		
		
		//Enter email address in stay informed and select sign up today
		if(from.equalsIgnoreCase("footer")){
			type(susbscribeemail, signemailid, "Email id");
			click(susbscribeSignupbtn, "Sign up button");
		}else if (from.equalsIgnoreCase("menu")){
			click(menu, "Menu");
			click(menuLogin, "Login");
			click(menuLoginSignin, "Sign in");
		}
		
		//Enter details in sign up window
		type(signinScreenName, screenname, "Screen name");
		type(signinEmail, signemailid, "Email id");
		type(signinPwd, signpasswd, "Password");
		type(signinPostcode, postcode, "Postcode");
		type(signinInterests, interest, "Interest");
		String xpathInterest = "//li/div";
		click(By.xpath(xpathInterest), "Interest");
		click(signinCreateAcc, "Create Account");
		Thread.sleep(5000);
		click(signinDoneClose, "Close button");
		assertTitle(titleHome);
		click(menu, "Menu");
	}
	
	
	public void navigateConsultation(String consultationname) throws Throwable{
		logger.info("in navigateConsultation");
		//Section - Active project
		String xpathSection = "//article[contains(@data-project-name,'"+consultationname+"')]";
		String xpathValidateElement = "//li[contains(text(),'"+consultationname+"')]";
		String windowTitle	= "Engage Victoria :: "+consultationname;
		
		//Select project and verify navigation to project page
		Thread.sleep(5000);
		click(By.xpath(xpathSection), "Selected Project");
		//Thread.sleep(5000);
		assertTitle(windowTitle);
		assertElementPresent(By.xpath(xpathValidateElement), consultationname+ " is present");
		
		//clickOnBreadcrumbs();
		
	}
	
	public void verifySearchSite(String keyword) throws Throwable{
		logger.info("in verifySearchSite");
		//enter keyword in Website search box and verify the search content
		type(searchSite, keyword, "Search String");
		click(searchSiteButn,"Seach button");
		
		//verify navigation to search page Search page 
		assertTitle(titleSearch);
		assertElementPresent(valeleSearch, "Search page");
		
		//Verify Search box is showing keyword
		assertValue(keyword, searchWSKeyword, "value", "Query Textbox");
		
		//verify search result
		List<WebElement> SearchResults = getElements(searchResult);
		
		Reporter.SuccessReport("Website Search Result", "Found " + SearchResults.size() +" Search results");
		
		//Return to home page via Breadcrumbs
		clickOnBreadcrumbs();
	}
	
	public void searchConsultation(String category, String from) throws Throwable{
		logger.info("in searchConsultation");
		if(from.equalsIgnoreCase("menu")){
			scrollTo(menu);
			clickTo(menu);
			Thread.sleep(10000);
			click(menuConsultations, "Menu/Consultation");
		}
		selectByValue(dropdwnCategory, category, "Search Cosultation");
		click(categorySearchbtn, "Clicked on search button");
		verifySearchResult();
	}
	
	public void scrollandClick(By loc) throws Throwable{
		logger.info("in scrollandClick");
		try{
			/*Thread.sleep(5000);
			JavascriptExecutor jse = driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(loc));
			Thread.sleep(5000);
			jse.executeScript("arguments[0].click();", driver.findElement(loc));
			*/
			
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(loc))
			.click()
			.perform();
			
			Reporter.SuccessReport("Click", "Successfully Click on "+loc.toString());
		}catch(Exception e){
			Reporter.failureReport("Click", "Unable to click "+loc.toString());
		}
	}
	
	public void scrollTo(By loc) throws Throwable{
		logger.info("in scrollTo");
		try{
			Thread.sleep(5000);
			JavascriptExecutor jse = driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(loc));
			Thread.sleep(5000);
			logger.info("Successfully scroll on "+loc.toString());
		}catch(Exception e){
			e.printStackTrace();
			logger.info("Unable to scroll to "+loc.toString());
		}
		Thread.sleep(5000);
	}
	
	public void clickTo(By loc) throws Throwable{
		logger.info("in clickTo");
		try{
			Thread.sleep(5000);
			JavascriptExecutor jse = driver;
			jse.executeScript("arguments[0].click();", driver.findElement(loc));
			logger.info("Successfully Click on "+loc.toString());
		}catch(Exception e){
			e.printStackTrace();
			logger.info("Unable to click "+loc.toString());
		}	
	}

	public void clickByEnterT(By loc) throws Throwable{
		logger.info("in clickTo");
		try{
			driver.findElement(loc).sendKeys(Keys.ENTER);
			logger.info("Successfully Click on "+loc.toString());
		}catch(Exception e){
			e.printStackTrace();
			logger.info("Unable to click "+loc.toString());
		}	
	}
	public void verifySearchResult() throws Throwable{
		logger.info("in verifySearchResult");
		//Verify Consultations page
		assertTitle(titleConsultations);
		assertElementPresent(valeleConsultations, "Consultation Page");
		
		List<WebElement> currentProjects = getElements(categoryResultCurrentPrj);
		List<WebElement> updatedProjects = getElements(categoryResultUpdatePrj);
		List<WebElement> pastProjects = getElements(categoryResultPastPrj);
		
		Reporter.SuccessReport("Cosultation Search Result", "Found " + currentProjects.size() +" Current Consultation");
		Reporter.SuccessReport("Cosultation Search Result", "Found " + updatedProjects.size() +" Updated Consultation");
		Reporter.SuccessReport("Cosultation Search Result", "Found " + pastProjects.size() +" Past Consultation");
		
		//Return to home page via Breadcrumbs
		clickOnBreadcrumbs();
	}
	
	public void helpMeFoundConsutation(String keyword, String location, String category, String dept,
		String projectgroup, String status) throws Throwable{
		
		logger.info("in helpMeFoundConsultation");
		
		//Select Help me find a consultation
		scrollandClick(categoryhelpmefinebtn);
		Thread.sleep(5000);
		
		type(fndConsKeyword, keyword, "Entered Consultation keyword");
		
		click(fndConsLocation,"Selected Location");
		click(By.xpath("//div[text()='"+location+"']"), "Location");
		isElementDisplayed(By.xpath("//div[text()='"+location+"']"), "Location");
		
		click(fndConsCategory, "Selected Category");
		click(By.xpath("//div[text()='"+category+"']"), "Category");
		isElementDisplayed(By.xpath("//div[text()='"+category+"']"), "Category");
		
		click(fndConsDepartment, "Selected departement");
		click(By.xpath("//div[text()='"+dept+"']"), "departement");
		isElementDisplayed(By.xpath("//div[text()='"+dept+"']"), "Department");
		
		click(fndConsProjectGrp, "Selected project group");
		click(By.xpath("//div[text()='"+projectgroup+"']"), "project group");
		isElementDisplayed(By.xpath("//div[text()='"+location+"']"), "Project Group");

		switch (status.toLowerCase()){
			case "all": click(fndConsStatusAll, "Selected All as status"); break;
			case "open": click(fndConsStatusOpen, "Selected Open as status"); break;
			case "active": click(fndConsStatusActive, "Selected Active as status"); break;
			case "closed": click(fndConsStatusClosed, "Selected Closed as status"); break;
		}
		
		click(fndConsSearch, "Selected Search button"); 
		
		verifySearchResult();

	}
	
	public void switchWindowByTitle(String title){
		logger.info("in switchWindowByTitle");
		boolean flag = false;
		Set<String> handles= driver.getWindowHandles();
		
		System.out.println("Total windows are: "+handles.size());
		
		for(String handle : handles){
			driver.switchTo().window(handle);
			if((driver.getTitle()).contains(title)){
				System.out.print("Window found");
				flag = true;
				break;
			}
		}
		if(!flag) System.out.print("No such window found");
	} 
	

	public static String getRandomString(int lengthOfChar) {
		logger.info("in getRandomString");
		return RandomStringUtils.randomAlphabetic(lengthOfChar);	
	}
	
	public static String getRandomNumber(int lengthOfChar) {
		logger.info("in getRandomNumber");
		return RandomStringUtils.randomNumeric(lengthOfChar);	
	}
	
	
	public void verifyContactUs(String emailid, String from) throws Throwable{
		logger.info("in verifyContactUs");
		String name = getRandomString(7);
		String org = getRandomString(12);
		String comment = getRandomString(11);
		int querynature = Integer.parseInt(randomNumber(1,3));

		
		if(from.equalsIgnoreCase("Menu")){
			scrollandClick(menu); //, "Menu");
			click(menuContactus, "Menu/Contact");
		}else if(from.equalsIgnoreCase("footer")){
			click(footercontactUslnk, "footer/Contact");	
		}else if(from.equalsIgnoreCase("form")){
			navigateToHiveSettingResultForm();
			click(resultsOpenPageOne, "Open Page");
		}
			
		type(contactusName, name, "Name");
		type(contactusEmail, emailid, "Email Id");
		type(contactusOrg, org, "Organisation");
		selectByIndex(contactusQueryNature, querynature, "Query Nature");
		type(contactusComment, comment, "Comment");
		click(contactusPrivacyStatement, "Checkbox for Accept Privacy");
		click(contactusSubmit, "Submit Button");
		Thread.sleep(8000);
		isElementDisplayed(contactusSuccessMsg, "Success message");
		Thread.sleep(5000);
		clickOnBreadcrumbs();
	}
	
	public static String randomNumber(Integer min, Integer max){
		logger.info("in randomNumber");
		Random rand = new Random();
		Integer num = rand.nextInt((max - min) + 1) + min;
		return String.valueOf(num);
	}
	
	//*****************************************
	
	public void verifyAuthroing() throws Throwable{
		logger.info("in verifyAuthroing");
		//verify the presence of page edit tools
		isElementDisplayed(Authoringtoolbar, "Authroing Toolbar");
		isElementDisplayed(authToolsEditpage, "Edit Page");
		isElementDisplayed(authToolsPagesetting, "Page Setting");
		isElementDisplayed(authToolsTools, "Tools");
		isElementDisplayed(authToolsAddupdate, "Add Update");
		isElementDisplayed(authToolsDashboard, "Dashboard");
		isElementDisplayed(authToolsSitemap, "Page");
	}
	
	public void verifyEditToolsBanner(String blocktitle, String blockdesc, String flow, String comment) throws Throwable{
		logger.info("in verifyEditToolsBanner");
		//select Authoring tool - Edit
		click(authToolsEditpage, "Edit Page");
		Thread.sleep(5000);
		//select hero block 
		JSClick(heroBlockSection, "Hero block");
		//click edit block
		Thread.sleep(2000);
		click(toolsEditBlock, "Edit block");
		//edit title
		type(editHeroBlockTitle, blocktitle, "Title");
		//edit description
		type(editHeroBlockDesc, blockdesc, "Description");
		//save changes
		click(editHeroBlockSave, "Save");
		
		//Save page
		savePage();
		
		//next step
		workflow(flow, comment);
		
		//assert changes
		if (flow.equalsIgnoreCase("submittoworkflow") || flow.equalsIgnoreCase("savechanges")){
			assertText(onpageProjectTitle, blocktitle);
			assertText(onpageProjectDesc, blockdesc);
		}
	}
	
	public void verifySettingToolsOptions() throws Throwable{
		logger.info("in verifySettingToolsOptions");
		isElementDisplayed(pageSettingDetails, "Details");
		isElementDisplayed(pageSettingDesign, "Design");
		isElementDisplayed(pageSettingSEO, "SEO");
		isElementDisplayed(pageSettingLocation, "Location");
		isElementDisplayed(pageSettingVersions, "Versions");
		isElementDisplayed(pageSettingMobilePreview, "Mobile Preview");
		isElementDisplayed(pageSettingDelete, "Delete");	
	}
		
	public void navigateToSetting() throws Throwable{
		logger.info("in navigateToSetting");
		//select Settings from Authoring menu
		click(authToolsPagesetting, "Settings");
		Thread.sleep(5000);
	}
	
	public void navigateToUpdate() throws Throwable{
		logger.info("in navigateToUpdate");
		//select Settings from Authoring menu
		click(authToolsAddupdate, "Update");
	}
	
	public void navigateToProjectSubPage() throws Throwable{
		logger.info("in navigateToProjectSubPage");
		click(authToolsSitemap, "Page");
		click(newPageProjectSubPage, "Project Sub Page");
	}

	public void navigateToSiteSubPage() throws Throwable{
		logger.info("in navigateToSiteSubPage");
		click(authToolsSitemap, "Page");
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.findElements(sitemapNewPageMore).size()==1){
			click(sitemapNewPageMore, "More");
		}
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		click(newPageSiteSubPage, "Site Sub Page");
	}
	
	public void navigateToProjectPage() throws Throwable{
		logger.info("in navigateToProjectPage");
		click(authToolsSitemap, "Page");
		click(sitemapNewPageMore, "More");
		click(newPageProjectPage, "Project Page");
	}
	
	public void navigateToNewsPage() throws Throwable{
		logger.info("in navigateToNewsPage");
		click(authToolsSitemap, "Page");
		if(driver.findElements(sitemapNewPageMore).size()>0){
			click(sitemapNewPageMore, "More");
		}
		click(newPageNewsPage, "News Page");
	}
	
	public void navigateToPageHome() throws Throwable{
		logger.info("in navigateToPageHome");
		click(authToolsSitemap, "Page");
		click(PageHome,"Page/Home");
	}
	
	public void navigateToPageAbout() throws Throwable{
		logger.info("in navigateToPageAbout");
		click(authToolsSitemap, "Page");
		click(PageAbout, "Page/About");
	}
	public void navigateToPageConsultation() throws Throwable{
		logger.info("in navigateToPageConsultation");
		click(authToolsSitemap, "Page");
		click(PageConsultation, "Page/Consultations");
	}
	public void navigateToPageContactUs() throws Throwable{
		logger.info("in navigateToPageContactUs");
		click(authToolsSitemap, "Page");
		click(PageContactUs, "Page/ContactUs");
	}
	public void navigateToPageSearch() throws Throwable{
		click(authToolsSitemap, "Page");
		click(PageSearch, "Page/Search");
	}
	public void navigateToPageCopyRights() throws Throwable{
		click(authToolsSitemap, "Page");
		click(PageCopyrights, "Page/Copyrights");
	}
	public void navigateToPagePrivacyPolicy() throws Throwable{
		click(authToolsSitemap, "Page");
		click(PagePrivacyPolicy, "Page/Privacy Policy");
	}
	public void navigateToPageAccessibility() throws Throwable{
		click(authToolsSitemap, "Page");
		click(PageAccessibility, "Page/Accessibility");
	}
	public void navigateToPageModerationPolicy() throws Throwable{
		click(authToolsSitemap, "Page");
		click(PageModerationPolicy, "Page/Moderation Policy");
	}
	public void navigateToPageCommunityGuide() throws Throwable{
		click(authToolsSitemap, "Page");
		click(PageCommunityGuidelines, "Page/Community Guide");
	}
	public void navigateToPageSiteMap() throws Throwable{
		click(authToolsSitemap, "Page");
		click(PageSitemap, "Page/Site map");
	}
	public void navigateToPageNewPage() throws Throwable{
		click(authToolsSitemap, "Page");
		click(newPageNewsPage, "News Page");
	}

	public void navigateToDashboard() throws Throwable{
		click(authToolsDashboard, "Dashboard");
	}
	
	public void navigateToDashboardProject() throws Throwable{
		click(authToolsDashboard, "Dashboard");
		click(dashboardProject, "Dashboard/Project");
	}
	
	public void navigateToModeration() throws Throwable{
		click(authToolsDashboard, "Dashboard");
		click(dashboardModeration, "Moderation");
	}
	
	public void navigateToDashboardMembers() throws Throwable{
		click(authToolsDashboard, "Dashboard");
		click(dashboardMembers, "Dashboard/Memebers");
	}

	public void navigateToPage() throws Throwable{
		click(authToolsSitemap, "Page");
	}
	
	public void navigateToDashboardSitemap() throws Throwable{
		click(authToolsDashboard, "Dashboard");
		click(dashboardSitemap, "Dashboard/Sitemap");
	}
	
	public void navigateToModerationMethod() throws Throwable{
		click(authToolsDashboard, "Dashboard");
		click(dashboardHiveSetting, "Dashboard/Hive Setting");
		click(hivesettingModerationMethod, "Moderation Method");
	}

	public void navigateToHiveSettingResultForm() throws Throwable{
		click(authToolsDashboard, "Dashboard");
		click(dashboardReports, "Dashboard/Reports");
		click(resultsForm, "Reports/Form");
	}
	public void verifyPageSitemapsLinks() throws Throwable{	
		click(authToolsSitemap, "Authroing/Page");
		click(sitemapExpand, "Expand Sitemap");
		
		//verify all links present in footer
		click(PageHome, "Page/Sitemap/Home");
		assertTitle(titleHome);
		
		click(authToolsSitemap, "Authroing/Page");
		
		click(PagePrivacyPolicy, "Page/Sitemap/Privacy");
		assertTitle(titlePrivacyPolicy);
		assertElementPresent(valelePrivacyPolicy, "Privacy Policy page");

		click(authToolsSitemap, "Authroing/Page");
		
		click(PageTermofUse, "Page/Sitemap/Term of Use");
		assertTitle(titleTermsofUse);
		assertElementPresent(valeleTermsofUse, "Terms of Use page");

		click(authToolsSitemap, "Authroing/Page");
		
		click(PageAccessibility, "Page/Sitemap/Accessibility");
		assertTitle(titleAccessibility);
		assertElementPresent(valeleAccessibility, "Accessibility page");

		click(authToolsSitemap, "Authroing/Page");
		
		click(PageModerationPolicy, "Page/Sitemap/Moderation");
		assertTitle(titleModerationPolicy);
		assertElementPresent(valeleModerationPolicy, "Moderation Policy page");

		click(authToolsSitemap, "Authroing/Page");
		
		click(PageCommunityGuidelines, "Page/Sitemap/Community Guidelines");
		assertTitle(titleCommunityGuidelines);
		assertElementPresent(valeleCommunityGuidelines, "Community Guidelines page");

		click(authToolsSitemap, "Authroing/Page");
		
		click(PageAbout, "Page/Sitemap/About");
		assertTitle(titleAbout);
		assertElementPresent(valeleAbout, "About page");

		click(authToolsSitemap, "Authroing/Page");
		
		click(PageContactUs, "Page/Sitemap/Contact Us");
		assertTitle(titleContactus);
		assertElementPresent(valeleContactus, "Contact Us page");

		click(authToolsSitemap, "Authroing/Page");
		
		click(PageSitemap, "Page/Sitemap/Site Map");
		assertTitle(titleSitemap);
		assertElementPresent(valeleSitemap, "Site Map page");

		click(authToolsSitemap, "Authroing/Page");
		
		click(PageSearch, "Page/Sitemap/Search");
		assertTitle(titleSearch);
		assertElementPresent(valeleSearch, "Search page");
		
		click(authToolsSitemap, "Authroing/Page");
		
		click(PageConsultation, "Page/Sitemap/Consultation");
		assertTitle(titleConsultations);
		assertElementPresent(valeleConsultations, "Consultation Page");
		
		click(authToolsSitemap, "Authroing/Page");
		
		click(PageSitemap, "Page/Sitemap/Sitemap");
		assertTitle(titleSitemap);
		assertElementPresent(valeleSitemap, "Sitemap Page");
	}
	
	public void verifyDashboardSitemapsLinks() throws Throwable{	
		navigateToDashboardSitemap();
		click(sitemapExpand, "Expand Sitemap");
		
		//verify all links present in footer
		click(PageHome, "Page/Sitemap/Home");
		click(sitememberVisit, "Visit");
		
		assertTitle(titleHome);
		
		navigateToDashboardSitemap();
		
		click(PagePrivacyPolicy, "Page/Sitemap/Privacy");
		click(sitememberVisit, "Visit");
		assertTitle(titlePrivacyPolicy);
		assertElementPresent(valelePrivacyPolicy, "Privacy Policy page");

		navigateToDashboardSitemap();
		
		click(PageTermofUse, "Page/Sitemap/Term of Use");
		click(sitememberVisit, "Visit");
		assertTitle(titleTermsofUse);
		assertElementPresent(valeleTermsofUse, "Terms of Use page");

		navigateToDashboardSitemap();
		
		click(PageAccessibility, "Page/Sitemap/Accessibility");
		click(sitememberVisit, "Visit");
		assertTitle(titleAccessibility);
		assertElementPresent(valeleAccessibility, "Accessibility page");

		navigateToDashboardSitemap();
		
		click(PageModerationPolicy, "Page/Sitemap/Moderation");
		click(sitememberVisit, "Visit");
		assertTitle(titleModerationPolicy);
		assertElementPresent(valeleModerationPolicy, "Moderation Policy page");

		navigateToDashboardSitemap();
		
		click(PageCommunityGuidelines, "Page/Sitemap/Community Guidelines");
		click(sitememberVisit, "Visit");
		assertTitle(titleCommunityGuidelines);
		assertElementPresent(valeleCommunityGuidelines, "Community Guidelines page");

		navigateToDashboardSitemap();
		
		click(PageAbout, "Page/Sitemap/About");
		click(sitememberVisit, "Visit");
		assertTitle(titleAbout);
		assertElementPresent(valeleAbout, "About page");

		navigateToDashboardSitemap();
		
		click(PageContactUs, "Page/Sitemap/Contact Us");
		click(sitememberVisit, "Visit");
		assertTitle(titleContactus);
		assertElementPresent(valeleContactus, "Contact Us page");

		navigateToDashboardSitemap();
		
		click(PageSitemap, "Page/Sitemap/Site Map");
		click(sitememberVisit, "Visit");
		assertTitle(titleSitemap);
		assertElementPresent(valeleSitemap, "Site Map page");

		navigateToDashboardSitemap();
		
		click(PageSearch, "Page/Sitemap/Search");
		click(sitememberVisit, "Visit");
		assertTitle(titleSearch);
		assertElementPresent(valeleSearch, "Search page");
		
		navigateToDashboardSitemap();
		
		click(PageConsultation, "Page/Sitemap/Consultation");
		click(sitememberVisit, "Visit");
		assertTitle(titleConsultations);
		assertElementPresent(valeleConsultations, "Consultation Page");
		
		navigateToDashboardSitemap();
		
		click(PageSitemap, "Page/Sitemap/Sitemap");
		click(sitememberVisit, "Visit");
		assertTitle(titleSitemap);
		assertElementPresent(valeleSitemap, "Sitemap Page");
	}

	public void adddeleteModeration(String reason) throws Throwable{
		navigateToModerationMethod();
		type(moderationmethodReason, reason, "Reason");
		click(moderationmethodAdd, "Add");
		
		if(driver.findElements(By.xpath("//ul[@id='sortable-reasons']/li")).size()==6){
			click(moderationmethodDelete, "Delete");
			//Thread.sleep(5000);
			//Alert();
		}
	}
	public void addUser(String issiteuser, String issiteadmin) throws Throwable{
		
		String username = getRandomString(12);
		String fisrtname = getRandomString(6);
		String lastname = getRandomString(5);
		String passwd = "AutomationUser2017";
		String emailid = getRandomString(8)+"@gmail.com";
		
		click(membersAddUserDropDwn, "Add User");
		if(issiteuser.equalsIgnoreCase("yes")){
			click(membersSiteUser, "Site User");
			type(membersFirstName, fisrtname, "First Name");
			type(membersLastName, lastname, "Last Name");
		}else click(membersCommUser, "Community User");
		
		type(membersUserName, username, "User Name");
		type(membersEmail, emailid, "Email ID");
		type(membersPassword, passwd, "Password");
		
		if(issiteadmin.equalsIgnoreCase("yes")){
			click(membersSiteAdmin, "Nominate as Site Admin");
		}
		
		click(membersAddBtn, "Add User");
		Thread.sleep(5000);
		isElementDisplayed(valeleMember, "User created successfully.");

		deleteUser();
		activateUser();
		deleteUser();
	}
		
	public void deleteUser() throws Throwable{
		//Delete user to avoid over data
		click(membersActiveDeletebtn, "Delete User");
		Thread.sleep(5000);
		isElementDisplayed(valeleMember, "User deactivated successfully.");
	}
	
	public void activateUser() throws Throwable{
		//Delete user to avoid over data
		click(membersActiveDeletebtn, "Activate User");
		Thread.sleep(5000);
		isElementDisplayed(valeleMember, "User activated successfully.");
	}
	
	public void detailDesc(String newprojectDesc) throws Throwable{
		
		newprojectDesc = newprojectDesc+" - "+getRandomString(2);
		click(pageSettingDetails, "Details");
		type(DetailsPJDesc, newprojectDesc, "Project Desc");
		click(DetailsSubmit, "Submit");
	}
	
	public void createNewsPage(String newspagename, String projectname, String choice) throws Throwable{
		click(pageSettingDetails, "Details");
		
		Thread.sleep(5000);
		type(DetailsPjName, newspagename, "Page Name");
		
		pageLocation(projectname);
		
		click(DetailsSubmit, "Submit");
		
		Thread.sleep(5000);
		savePage();
		submittoWorkflow("Add Page");

		approveCancelPage(choice);
		//assertText(valeleBreadcrumbNews, newprojectName);
		
		Thread.sleep(5000);
		assertTitle("Engage Victoria :: "+newspagename);
	}
	
	public String detailName(String newprojectName) throws Throwable{
		newprojectName = newprojectName+" - "+getRandomString(4);
		click(pageSettingDetails, "Details");
		type(DetailsPjName, newprojectName, "Project Name");
		
		if(driver.findElements(DetailsChooseaPage).size()==1){
			pageLocation("New Project for Test Execution");
		}
		
		click(DetailsSubmit, "Submit");
		Thread.sleep(5000);
		return newprojectName;
		
	}
	
	public void designTemplate(String pagetemplate) throws Throwable{
		click(pageSettingDesign, "Design");
		Thread.sleep(5000);
		switch (pagetemplate.toLowerCase()){
		case "rightslider":
			click(DesignExpand, "Expand");
			click(DesignRightSlider, "RightSlider");
			break;
		case "full":
			click(DesignExpand, "Expand");
			click(DesignFull, "Full");
			break;
		case "narrow":
			click(DesignExpand, "Expand");
			click(DesignNarrow, "Narrow");
			break;
		case "news full":
			isElementDisplayed(DesignNewsFull, "News Full");
			break;
		}
		click(pageSettingBack, "Back Page");
		Thread.sleep(3000);
		click(pageSettingDetails, "Detail");
		Thread.sleep(5000);
		if(getAttribute(DetailsPjName, "value", "Project Name").length()<=0){
			type(DetailsPjName, "Testing Design", "Project Name");
		}
		
		if(driver.findElements(DetailsChooseaPage).size()==1){
			pageLocation("New Project for Test Execution");
		}
		Thread.sleep(5000);
		click(DetailsSubmit, "Submit");
		Thread.sleep(10000);
	}
	
	public void seoName(String metadesc) throws Throwable{
		click(pageSettingSEO, "SEO");
		metadesc = metadesc+getRandomString(4);
		type(seoMetaDesc, metadesc, "SEO Name");
		Thread.sleep(3000);
		click(pageSettingDetails, "Detail");
		if(getAttribute(DetailsPjName, "value", "Project Name").length()<=0){
			type(DetailsPjName, "Testing SEO", "Project Name");
		}
		
		if(driver.findElements(DetailsChooseaPage).size()==1){
			pageLocation("New Project for Test Execution");
		}
		click(DetailsSubmit, "Submit");
		Thread.sleep(10000);
	}
	
	public void pageLocation(String projectname) throws Throwable{
		logger.info("in PageLocation");
		String xpath = "//li/span/a[text()='"+projectname+"']";
		JSClick(DetailsChooseaPage, "ChoosePage");
		Thread.sleep(45000);
		click(locSiteMapExpand, "Expand Home");
		Thread.sleep(5000);
		click(By.xpath(xpath), "Project");
		Thread.sleep(30000);
	}
	
	public void changeLocation(String projectname) throws Throwable{
		click(pageSettingLocation, "Location");
		click(locLocation, "Location");
		click(locSiteMapHome, "Home");
		Thread.sleep(5000);
		click(pageSettingDetails, "Detail");
		
		if(getAttribute(DetailsPjName, "value", "Project Name").length()<=0){
			type(DetailsPjName, "Testing Location", "Project Name");
		}
		
		if(driver.findElements(DetailsChooseaPage).size()==1){
			pageLocation("New Project for Test Execution");
		}
		
		Thread.sleep(5000);
		click(DetailsSubmit, "Submit");
		Thread.sleep(10000);
	}
	/*Need to write functon to verify 
	 * approve version
	 * reject version
	 * see version
	 */
	public void approveVersion() throws Throwable{
		click(pageSettingVersions, "Version");
		Thread.sleep(15000);
		String xpath_row = "//table/tbody/tr[1]";
		String xpath = "//table/tbody/tr[1]/td[4]/a";
		//String xpath = "//a[@data-launch-versions-menu='ccm-panel-page-versions-version-menu-"+versionnumber+"']";
		mouseOverElement(driver.findElement(By.xpath(xpath_row)), "First Version");
		//click(By.xpath(xpath_row), "First Version");
		Thread.sleep(10000);
		click(By.xpath(xpath), "Version 1");
		Thread.sleep(5000);
		click(versionApprove, "Approve");
		//assertTextMatching(valeleVersionApprove, "Approved by", "Verify text");		
	}
	
	public void duplicateVersion() throws Throwable{
		click(pageSettingVersions, "Version");
		Thread.sleep(15000);
		String xpath_row = "//table/tbody/tr[1]";
		String xpath = "//table/tbody/tr[1]/td[4]/a";
		mouseOverElement(driver.findElement(By.xpath(xpath_row)), "First Version");
		Thread.sleep(5000);
		click(By.xpath(xpath), "Version option");
		Thread.sleep(5000);
		click(versionDuplicate, "Duplicate Version");
		Thread.sleep(5000);
		assertTextMatching(valeleVersionDuplicate, "Copy of Version:", "Verify text");
		
	}
	
	public void newPageVersion(String pagename) throws Throwable{
		click(pageSettingVersions, "Version");
		Thread.sleep(15000);
		String xpath_row = "//table/tbody/tr[1]";
		String xpath = "//table/tbody/tr[1]/td[4]/a";
		mouseOverElement(driver.findElement(By.xpath(xpath_row)), "First Version");
		Thread.sleep(5000);
		click(By.xpath(xpath), "Version option");
		Thread.sleep(5000);
		click(versionNewPage, "New Page");
		//Thread.sleep(20000);
		//assertValue(pagename, DetailsPjName, "Value", "Page Name");
	}
	
	public void verifyMobilePreview() throws Throwable{
		click(pageSettingMobilePreview, "Mobile Perivew");
		Thread.sleep(5000);
		
		isElementDisplayed(mobileiphone6, "iphone6");
		isElementDisplayed(mobileiphone6plus, "iphone6 Plus");
		isElementDisplayed(mobileiphone5s, "iphone5s");
		isElementDisplayed(mobileSamsungGs5, "Samsung G s5");
		isElementDisplayed(mobileipad, "ipad");
		
		click(mobileiphone6, "iPhone6");
		isElementDisplayed(mobileDeviceiphone6, "iPhone6 Device");
		
		Thread.sleep(5000);
		click(mobilelandscape, "Landscape");
		assertValue("width: 667px; height: 375px;", mobileFrame, "style", "Mobile Frame");
		
		Thread.sleep(5000);
		click(mobilePortrait, "Portrait");
		assertValue("width: 375px; height: 667px;", mobileFrame, "style", "Mobile Frame");
		
		click(authToolsPagesetting, "Page Setting");
		Thread.sleep(5000);
	}
	
	//need to create test for this, project should have sub page
	public void verifyDeletePagewithSubPage() throws Throwable{
		click(pageSettingDelete, "Delete");
		
		assertText(deleteErrormsg, "Before you can delete this page, you must delete all of its child pages.");
		click(deleteCancelbtn, "Cancel");
		
		click(authToolsPagesetting, "Page Setting");
	}
	
	public void verifyDeletePage() throws Throwable{
		click(pageSettingDelete, "Delete");
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver.findElements(By.xpath("//div[@class='alert alert-error']")).size()==1){
			assertText(By.xpath("//div[@class='alert alert-error']"), "Before you can delete this page, "
					+ "you must delete all of its child pages.");
		}else if(driver.findElements(deleteDeletebtn).size()==1){
			click(deleteDeletebtn, "Delete Page");
		}
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	}
	
	public void verifyToolsOptions() throws Throwable{
		click(authToolsTools, "Tools");
	
		isElementDisplayed(toolsAddButton, "Add Button");
		//isElementDisplayed(toolsAddNavigation, "Add Sub Nav");
		isElementDisplayed(toolsAddWebMap, "Add Web Map");
		isElementDisplayed(toolsAddImageGallery, "Add Image Gallery");
		isElementDisplayed(toolsAddImageSlider, "Add Image Slider");
		isElementDisplayed(toolsAddVideo, "Add Video");
		isElementDisplayed(toolsAddSwipe, "Add Swipe");
		isElementDisplayed(toolsAddDocumentLibrary, "Add Document Library");
		isElementDisplayed(toolsAddFAQ, "Add FAQ");
		isElementDisplayed(toolsAddKeyDates, "Add Key Dates");
		isElementDisplayed(toolsAddLinks, "Add Links");
		isElementDisplayed(toolsAddTimeline, "Add Timeline");
		isElementDisplayed(toolsAddSubscriptionForm, "Add Subscription Form");
		isElementDisplayed(toolsAddContactUs, "Add Contact Us");
		isElementDisplayed(toolsAddNewsFeed, "Add News Feed");
		isElementDisplayed(toolsAddFeatureGrid, "Add Feature Grid");
		isElementDisplayed(toolsAddAccordion, "Add Accordion");
		isElementDisplayed(toolsAddForm, "Add Form");
		isElementDisplayed(toolsAddQuickPoll, "Add Quick Poll");
		isElementDisplayed(toolsAddConversation, "Add Conversation");
		isElementDisplayed(toolsAddSocialMap, "Add Social Map");
		isElementDisplayed(toolsAddVisionerInput, "Add Visioner Input");
		isElementDisplayed(toolsAddVisionerResults, "Add Visioner Results");
		isElementDisplayed(toolsAddForum, "Add Forum");
		
		click(authToolsTools, "Tools");
	}
	
	public void addContent(String content) throws Throwable{
		openTools();
		click(toolsAddContent, "Content");
		Thread.sleep(5000);
		type(addContentEditbox, content, "Add Content");
		Thread.sleep(5000);
		click(addContentSave, "Save");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added content on page");
		//approvePage();
		Thread.sleep(10000);
		assertElementPresent(By.xpath("//p[text()='"+content+"']"), "Content on page");
	}
	
	public void deletePageBlock(String project) throws Throwable{
		navigateConsultation(project);
		click(authToolsEditpage, "Edit Page");
		click(emptyMainArea, "Main Area");
		click(toolsDeleteBlock, "Delete Block");
		isElementDisplayed(deleteBlockMessage, "Delete Block message");
		savePage();
		workflow("submittoworkflow", "removed content on page");
		approvePage();
	}
	
	public void addHTML(String htmlcontent) throws Throwable{
		openTools();
		click(toolsAddHTML, "HTML");
		Thread.sleep(8000);
		driver.findElement(addhtmleditor1).sendKeys(htmlcontent);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		workflow("submittoworkflow", "Added HTML on page");
		assertText(valeleHTML, "Hello Victoria");
	}
	
	public void addBlockQuote(String quote, String quoteby) throws Throwable{
		openTools();
		click(toolsAddBlockQuote, "Block Quote");
		Thread.sleep(5000);
		type(blockQuoteText, quote, "Quote");
		Thread.sleep(5000);
		type(blockQuoteAuthor, quoteby, "Author");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Quote on page");
		Thread.sleep(10000);
		assertTextMatching(valeleQuote, quote, "Quote");
		assertTextMatching(valeleQuoteAuthor, quoteby, "Author");
	}
	
	public void addHeading(String heading) throws Throwable{
		openTools();
		click(toolsAddHeading, "Add Heading");
		Thread.sleep(5000);
		type(headingHeading, heading, "Heading");
		selectByVisibleText(headingHeadingtype, "Heading Level 2", "Heading Level");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Heading on page");
		Thread.sleep(10000);
		assertText(valeleHeading, heading);
	}
	
	public void addDivider() throws Throwable{
		openTools();
		click(toolsAddDivider, "Add Divider");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Heading on page");
		Thread.sleep(10000);
		isElementDisplayed(valeleDivider, "Divider");
	}
	
	public void addImage(String imagealtdesc, String imagecaption) throws Throwable{
		openTools();
		click(toolsAddImage, "Add Image");
		
		Thread.sleep(5000);
		click(imageSelect, "Select Image");
		click(image1, "Select first image");
		
		Thread.sleep(5000);
		type(imageAlternativeDesc, imagealtdesc, "Image Alternative Description");
		type(imageCaption, imagecaption, "Image Caption");
		click(Addbutton, "Add");
		
		Thread.sleep(5000);
		savePage();
		workflow("submittoworkflow", "Added Image on page");
		
		Thread.sleep(10000);
		assertValue(imagealtdesc, valeleImage, "alt", "Image");
		assertText(valeleImageCaption, imagecaption);
		
	}
	
	public void addflexi(String flexititle, String flexicontent) throws Throwable{
		openTools();
		click(toolsAddFlexi, "Add Flexi");
		Thread.sleep(5000);
		type(flexiTitle, flexititle, "Flexi Title");
		type(flexiContent, flexicontent, "Flexi Content");
		click(Addbutton, "Add");
		Thread.sleep(8000);
		savePage();
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(10000);
		assertText(valeleFlexiTitle, flexititle);
		assertText(valeleFlexiContent, flexicontent);

	}
	
	public void addTabsStart(String tabheading) throws Throwable{
		openTools();
		click(toolsAddTabsStart, "Tabs Start");
		Thread.sleep(5000);
		type(tabHeading, tabheading, "Tab Heading");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		workflow("submittoworkflow", "Added tab on page");
		Thread.sleep(10000);
		//assertText(valeletab, "Tabheading");
	}
	
	public void addButton(String buttontext, String buttonurl) throws Throwable{
		openTools();
		click(toolsAddButton, "Add Button");
		Thread.sleep(5000);
		type(buttonText, buttontext, "Button Text");	
		type(buttonURL, buttonurl, "Button URL");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(10000);
		assertText(valeleButton, buttontext);
		assertValue(buttonurl+"/", valeleButton, "href", "Button");
	}
	
	public void addWebMap(String location) throws Throwable{
		openTools();
		click(toolsAddWebMap, "Add WebMap");
		Thread.sleep(5000);
		type(mapLocation, location, "Location");	
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		workflow("submittoworkflow", "Added WebMap on page");
		Thread.sleep(10000);
		isElementDisplayed(valelemap, "WebMap");
		
	}
	
	public void addImageGallary(String imagecaption, String projectname) throws Throwable{
		openTools();
		click(toolsAddImageGallery, "Add Image Galary");
		Thread.sleep(5000);
		click(addItemButton, "Add Item");
		click(imagegalleryImageSelect, "Select Image");
		Thread.sleep(5000);
		click(imagegalleryImage1, "Select first image");
		Thread.sleep(5000);
		type(imagegalleryCaption, imagecaption, "Image Caption");
		Thread.sleep(5000);
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(10000);
		isElementDisplayed(valeleimagegalleryBlock, "Image Galary");
		//assertValue(imagecaption, valeleimagegalleryBlock, "data-name", "Image");
		}
	
	public void addImageSlider(String imagetitle, String projectname) throws Throwable{
		openTools();
		click(toolsAddImageSlider, "Add Image Slider");
		Thread.sleep(5000);
		click(addItemButton, "Add Item");
		Thread.sleep(5000);
		type(imagesliderTitle, imagetitle, "Image Title");
		click(imagegalleryImageSelect, "Select Image");
		Thread.sleep(5000);
		//addImageToProject(projectname);
		//Thread.sleep(3000);
		click(imagegalleryImage1, "Select first image");
		Thread.sleep(5000);
		click(innerAddbutton, "Add");
		Thread.sleep(3000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(10000);
		isElementDisplayed(valeleImagesliderBlock, "Image Slider");
		assertText(valeleImagesliderTitle, imagetitle);
	}
	
	public void addVideo(String videotitle, String playertype, String videourl) throws Throwable{
		openTools();
		click(toolsAddVideo, "Add Video");
		Thread.sleep(5000);
		type(videoTitle, videotitle, "Video Title");
		type(videoURL, videourl, "Video URL");
		selectByVisibleText(videoPlayerType, playertype, "Player Type");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(10000);
		isElementDisplayed(valeleVideoFrame, "Video frame");
		assertText(valelevideotitle, videotitle);
	}
	
	public void addSwipe() throws Throwable{
		openTools();
		click(toolsAddSwipe, "Add Swipe");
		Thread.sleep(5000);
		click(swipeImage1Select, "Image Select");
		click(swipeImage1, "Image 1");
		Thread.sleep(5000);
		click(swipeImage2Select, "Image Select");
		click(swipeImage2, "Image 2");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(10000);
		isElementDisplayed(valeleswipe2020, "20-20 Slider");
		isElementDisplayed(valeleswipeImg1, "Image 1");
		isElementDisplayed(valeleswipeImg2, "Image 2");
	}
	
	public void addForm(String questiontype, String question, String questiondesc) throws Throwable{
		openTools();
		click(toolsAddForm, "Add Form");
		Thread.sleep(15000);
		selectByVisibleText(formSelectQuesType, questiontype, "Question Type");
		Thread.sleep(5000);
		type(formQuestion, question, "Question");
		type(formQuesDesc, questiondesc, "Description");
		click(formAddQuestion, "Add Question");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(10000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		
		Thread.sleep(10000);
		assertText(valeleformQuestion, question);
		assertText(valeleformQuesDesc, questiondesc);
	}
	
	public void addQuickPoll(String question) throws Throwable{
		openTools();
		click(toolsAddQuickPoll, "Add quick poll");
		Thread.sleep(5000);
		type(quickpollQuestion, question, "Question");
		type(quickpollOption, "Yes", "Yes");
		click(quickpllAddOption, "Add option");
		type(quickpollOption, "No", "No");
		click(quickpllAddOption, "Add option");
		
		click(Addbutton, "Add");
		Thread.sleep(8000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		assertText(valeleQuickPollQuestion, question);
		isElementDisplayed(valeleQuickPollYes, "Yes");
		isElementDisplayed(valeleQuickPollNo, "No");
		isElementDisplayed(valeleQuickPollSubmit, "Submit");
	}
	
	public void addConversation(String title) throws Throwable{
		openTools();
		click(toolsAddConversation, "Add Conversation");
		Thread.sleep(5000);
		type(conversationTitle, title, "Title");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		//Thread.sleep(10000);
		//assertText(valeleconversationTitle, title);
	}
	
	public void addsocialMap(String location) throws Throwable{
		openTools();
		click(toolsAddSocialMap, "Social Map");
		Thread.sleep(5000);
		type(socialMapLocation, location, "Location");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(5000);
		//approvePage();
		Thread.sleep(25000);
		isElementDisplayed(valelesocialMap, "Social Map");
	}
	
	public void addVisionerInput(String question, String desc) throws Throwable{
		openTools();
		click(toolsAddVisionerInput, "Visioner Input");
		Thread.sleep(5000);
		type(visionerInputQuestion, question, "Question");
		type(visionerInputQuestionDesc, desc, "Question Description");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(25000);
		//approvePage();
		assertText(valelevisionerInputQuestion, question);
		assertText(valelevisionerInputQuestionDesc, desc);
		//assertText(valelevisionerInputTextArea, "Tell us your idea");
	}
	
	public void addVisionerResult(String idea) throws Throwable{
		openTools();
		click(toolsAddVisionerResults, "Visioner Result");
		Thread.sleep(5000);
		selectByVisibleText(visionerResultIdea, idea, "Idea");
		click(visionerResultDisplayVotingYes, "Display Voting");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		Thread.sleep(25000);
		assertText(valelevisionerResult, "No submissions yet.");
	}
	
	public void addForum(String question) throws Throwable{
		openTools();
		click(toolsAddForum, "Forum");
		Thread.sleep(5000);
		click(forumActiveYes, "Active");
		type(forumQuestion, question, "Question");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		Thread.sleep(25000);
		assertText(valleleforumQuestion, question);
		assertText(valeleforumReadnContribute, "Read and Contribute");
		isElementDisplayed(valeleforumStatus, "Voting");
	}
	
	public void addDocumentLibrary(String title, String heading) throws Throwable{
		openTools();
		click(toolsAddDocumentLibrary, "Document Library");
		Thread.sleep(5000);
		click(addItemButton, "Add Item");
		click(documentLibFileSelect, "Select Document");
		click(documentLibFile1, "File 1");
		type(documentLibDocTitle, title, "Document lib Title");
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		click(addGroup, "Add Group");
		type(documentLibGroupHeading, heading, "Group Heading");		
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//assertText(valeleDocTitle, title);
		//assertText(valeleDocGroupHeading, "Heading");
		//isElementDisplayed(valeleDocImage, "Image");
	}
	
	public void addFAQ(String question, String answer, String heading) throws Throwable{
		openTools();
		click(toolsAddFAQ, "FAQ");
		Thread.sleep(5000);
		click(addItemButton, "Add Item");
		type(faqQuestion, question, "Question");
		type(faqAnswer, answer, "Answer");		
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		//click(addGroup, "Add Group");
		//type(documentLibGroupHeading, heading, "Group Heading");
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		Thread.sleep(25000);
		assertText(valeleFAQ, question);
		//assertText(valeleFAQGroupHeading, "Heading");
	}
	
	public void addKeyDate(String title) throws Throwable{
		openTools();
		click(toolsAddKeyDates, "Key Dates");
		Thread.sleep(5000);
		click(addItemButton, "Add Item");
		Thread.sleep(3000);
		type(keydateTitle, title, "Title");
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		Thread.sleep(25000);
		assertText(valeleKeyTitle, title);
	}
	
	public void addLink(String title, String url, String heading) throws Throwable{
		openTools();
		click(toolsAddLinks, "Link");
		Thread.sleep(5000);
		click(linksAddLinks, "Link");
		Thread.sleep(5000);
		type(linksTitle, title, "Title");
		type(linksURL, url, "URL");
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		//click(addGroup, "Add Group");	
		//Thread.sleep(5000);
		//type(linksGroupHeading, heading, "Heading");
		//click(Addbutton, "Add");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		Thread.sleep(25000);
		assertText(valelelinkstitle, title);
		//assertText(valelelinkgroupheading, heading);
	}
	
	public void addTimeline(String title, String status, String heading) throws Throwable{
		openTools();
		click(toolsAddTimeline, "Timeline");
		Thread.sleep(5000);
		click(timelineAddStage, "Add Stage");
		type(timelineStageTitle, title, "Title");
		selectByVisibleText(timelineStageStatus, status, "Status");
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		Thread.sleep(25000);
		assertText(valeleTiemline, title);
	}
	
	public void addContactUs(String name, String phone) throws Throwable{
		openTools();
		click(toolsAddContactUs, "Contact us");
		Thread.sleep(5000);
		type(contactUsName, name, "Name");
		type(contactUsPhone, phone, "Phone");		
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		Thread.sleep(25000);
		assertText(valeleContactUsName, name);
		assertText(valeleContactUsPhone, phone);
	}
	
	public void addNewsFeed(String title, String desc) throws Throwable{
		openTools();
		click(toolsAddNewsFeed, "News Feed");
		Thread.sleep(5000);
		type(newsFeedTitle, title, "Title");
		type(newsFeedDesc, desc, "Description");		
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		Thread.sleep(25000);
		assertText(valeleNewsFeedTitle, title);
		assertText(valeleNewsFeedDesc, desc);
	}
	
	public void addFeature(String title) throws Throwable{
		openTools();
		click(toolsAddFeatureGrid, "Feature");
		Thread.sleep(5000);
		click(addFeatureButton, "Add Feature");
		Thread.sleep(5000);
		click(featureImageSelect, "Select Image");
		Thread.sleep(5000);
		click(featureimage1, "Image");	
		type(featureTitle, title, "Title");
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(5000);
		savePage();
		workflow("submittoworkflow", "Added Image on page");
		//assertText(valeleFeatureTitle, title);
	}
	
	public void addAccodion(String question, String answer) throws Throwable{
		openTools();
		click(toolsAddAccordion, "Accordion");
		Thread.sleep(5000);
		click(addItemButton, "Add Item");
		Thread.sleep(5000);
		type(accordionQuestion, question, "Question");
		type(accordionAnswer, answer, "Answer");
		Thread.sleep(5000);
		click(innerAddbutton, "Add");
		Thread.sleep(5000);
		click(Addbutton, "Add");
		Thread.sleep(10000);
		savePage();
		Thread.sleep(5000);
		workflow("submittoworkflow", "Added Image on page");
		//approvePage();
		Thread.sleep(25000);
		assertText(valeleAccodion, question);
	}
	
	public void addImageToProject(String projectname) throws Throwable{
		click(By.xpath("//div[@id='s2id_autogen6']/ul"), "File Set");
		Thread.sleep(5000);
		String xpath = "//ul/li/div[text()='"+projectname+"']";
		click(By.xpath(xpath), "Project");
		click(fileManagerSearch, "Search");
	}
	
	public void openTools() throws Throwable{
		logger.info("In openTools");
		Thread.sleep(5000);
		click(authToolsEditpage, "Edit");
		Thread.sleep(3000);
		click(emptyMainArea, "Main Area");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver.findElements(toolsDeleteBlock).size()==1){
			click(toolsDeleteBlock, "Delete Block");
			Thread.sleep(5000);
			scrollToTop();
			click(emptyMainArea, "Main Area");
			Thread.sleep(5000);
			click(toolsaddBlock, "Add block");
		}else click(toolsaddBlock, "Add block");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
	
	public void verifySubPageOptions() throws Throwable{
		isElementDisplayed(newPageProjectSubPage, "Sub-Page");
		isElementDisplayed(newPageSiteSubPage, "Site Sub-Page");
		isElementDisplayed(newPageProjectPage, "Project Page");
		isElementDisplayed(newPageNewsPage, "News Page");	
	}

	public String createProject(String projectname, String projectdesc, String projectdept, String projecttype, String projectsatus, 
			String username, String userrole, String golive) throws Throwable{
		//Fill project details on first page
		projectname = projectname +" - "+ getRandomString(4);
		type(ProjectName, projectname, "Project Name");
		type(ProjectDesc, projectdesc, "Project Description");
		Thread.sleep(25000);
		click(nextButton, "Next Button");
		Thread.sleep(5000);
		
		//Fill project details on page 2
		scrollandClick(ProjectTemplate);
		selectByVisibleText(ProjectDept, projectdept, "Project Department");
		selectByVisibleText(ProjectType, projecttype, "Project Type");
		selectByVisibleText(ProjectStatus, projectsatus, "Project Status");
		
		//Add project image, location and 
		clickTo(ProjectImageSelect); //, "Project image");
		Thread.sleep(5000);
		click(projectImage1, "Select project image");
		Thread.sleep(5000);
		//add location, category, color
		clickTo(projectCategoryAllCategory); //, "All category");
		clickTo(projectLocationVictoria); //, "Location Victoria");
		clickTo(Projectcolor); //, "Project Color");
		
		//select project logo
		clickTo(projectSelectLogo); //, "Project logo");
		click(projectLogo1, "Select Project logo");
		
		//select project group 
		click(projectGroupAnotherPartnership, "Anothter Partnership");
		
		click(nextButton, "Next Button");
		
		//User Role
		String [] userroles = userrole.split(",");
		String [] usernames = username.split(",");
		for (int i=0; i<userroles.length; i++){
			addPermittedUser(usernames[i], userroles[i], i);
		}
		
		//Launch Project
		click(launchProjectbtn, "Launch Project");
		
		//verify page draft popup
		isElementDisplayed(popupTxtMessage, "Page Draft popup");
		
		if(golive.equalsIgnoreCase("yes")){
			click(popupSubmitforApproval, "Submit for approval");
		}else click(popupHide, "Hide");
		
		//verify title
		assertTitle("Engage Victoria :: "+projectname);
		return projectname;
	}
	
	public void navigateToSubPage(String subpagename) throws Throwable{
		logger.info("in navigateToSubPage");
		
		String xpath = "//a[text()='"+subpagename+"']";
		
		Thread.sleep(5000);
		click(authToolsSitemap, "Page");
		Thread.sleep(35000);
		List <WebElement> ele = driver.findElements(By.xpath("//span[@class='dynatree-expander']"));
		if(ele.size()==1){
			click(By.xpath("//span[@class='dynatree-expander']"),"Expand");
			Thread.sleep(15000);
			ele = driver.findElements(By.xpath("//span[@class='dynatree-expander']"));
		}
		Thread.sleep(5000);
		if(isElementDisplayed(By.xpath(xpath), "Sub page")){
			click(By.xpath(xpath), "SubPage");
		}else{
			ele.get(ele.size()-1).click();
			Thread.sleep(20000);
			click(By.xpath(xpath), "SubPage");
		}
		Thread.sleep(5000);
	}
	
	public void rejectPage() throws Throwable{
		logger.info("in cancelPage");
		click(popupRejectPage, "Reject Page");
		Thread.sleep(3000);
		type(rejectReasonPopup,"Reject Page", "Reject Reason");
		click(submitRejection, "Submit Rejection");
		Thread.sleep(5000);
	}

	public String createSubPage(String pagename, String projectname) throws Throwable{
		pagename = pagename+" - "+getRandomString(4);
		click(pageSettingDetails, "Details");
		Thread.sleep(10000);
		type(DetailsPjName, pagename, "Page Name");
		Thread.sleep(25000);
		selectByVisibleText(DetailsPageLocation, projectname, "Page Location");
		click(DetailsSubmit, "Submit");
		return pagename;
	}
	
	public void addPermittedUser(String username, String userrole, int i) throws Throwable{
		type(projectUserName, username, "Project user name");
		Thread.sleep(3000);
		click(projectUserNameSel1, "User");
		String xpath = "//*[@id='tab3']/div/div[1]/span[2]/table/tbody/tr["+(i+2)+"]/td[2]/select";
		Thread.sleep(3000);
		selectByVisibleText(By.xpath(xpath), userrole, "User Role");
	}
	
	public void addPermittedUserAfterward(String username, String userrole, int i) throws Throwable{
		scrollToEnd();
		type(projectUserName, username, "Project user name");
		Thread.sleep(3000);
		click(projectUserNameSel1, "User");
		Thread.sleep(5000);
		List<WebElement> ele = driver.findElements(By.xpath("//select[@name='akID[34][role][]']"));
		Thread.sleep(3000);
		Select s1 = new Select(ele.get(1));
		s1.selectByVisibleText(userrole);
		//selectByVisibleText(By.xpath(xpath), userrole, "User Role");
	}
	
	public int removePermittedUser(int numuserremove) throws Throwable{
		int permitteduser = driver.findElements(removePermittedUserBtn).size();
		try{
			if(permitteduser>=numuserremove){
				for(int i=0; i<numuserremove;i++){
					click(removePermittedUserBtn, "Delete User");
					}
				}
			return permitteduser;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getPermittedUser() throws Throwable{
		int permitteduser = driver.findElements(removePermittedUserBtn).size();
		return permitteduser;
	}
	
	//********Dashboard
	public void verifyDashboardOptions() throws Throwable{
		click(authToolsDashboard, "Dashboard");
		isElementDisplayed(dashboardModeration, "Moderation");
		isElementDisplayed(dashboardProject, "Project");
		isElementDisplayed(dashboardActivityfeed, "Activity Feed");
		isElementDisplayed(dashboardReports, "Reports");
		isElementDisplayed(dashboardAnalytics, "Analytics");
		isElementDisplayed(dashboardFiles, "Files");
		isElementDisplayed(dashboardMembers, "Members");
		isElementDisplayed(dashboardSitemap, "Sitemap");
		isElementDisplayed(dashboardHiveSetting, "Hive Setting");
	}
	
	public void addCommenttoProject(String project, String projectcomment) throws Throwable{
		
		navigateConsultation(project);	
		type(projectComment, projectcomment, "Project Comment");
		click(projectCommentSubmit, "Sumbmit");
		Thread.sleep(5000);
	}

	public String getCommentID(String comment) throws Throwable{
		Thread.sleep(8000);
		assertText(awaitingfirstCommentTxt, comment);
		return getAttribute(awaitingfirstCommentId, "data-feedbackid", "Comment Id");
	}
	public void approveAwaitingComment(String commentid, String commenttext) throws Throwable{

		assertValue(commentid, awaitingfirstCommentId, "data-feedbackid", "Comment ID");
		click(awaitingfirstCommentApprove, "Approve Comment");
		Thread.sleep(8000);
		assertText(recentfirstCommentOverallStatus, "APPROVED");
		assertText(recentfirstCommentTxt, commenttext);
	}
	
	public void rejectAwaitingComment(String commentid, String commenttext, String reason) throws Throwable{
		
		assertValue(commentid, awaitingfirstCommentId, "data-feedbackid", "Comment ID");
		click(awaitingfirstCommentReject, "Reject");
		selectByVisibleText(rejectReason, reason, "Reason for rejection");
		click(rejectSubmit, "Sumbit");
		Thread.sleep(8000);
		assertText(recentfirstCommentOverallStatus, "REJECTED");
		assertText(recentfirstCommentTxt, commenttext);
	}
	
	public void referAwaitingComment(String commentid, String commenttext, String reason) throws Throwable{
		
		assertValue(commentid, awaitingfirstCommentId, "data-feedbackid", "Comment ID");
		click(awaitingfirstCommentRefer, "Refer");
		selectByVisibleText(rejectReason, reason, "Reason for refer");
		click(rejectSubmit, "Sumbit");
		Thread.sleep(8000);
		assertText(reviewfirstCommentOverallStatus, "REFERRED");
		assertText(reviewfirstCommentTxt, commenttext);
	}
	
	public void approveRecentComment(String commentid, String commenttext) throws Throwable{
		
		assertValue(commentid, recentfirstCommentId, "data-feedbackid", "Comment ID");
		click(recentfirstCommentApprove, "Approve Comment");
		Thread.sleep(8000);
		assertText(recentfirstCommentOverallStatus, "APPROVED");
		assertText(recentfirstCommentTxt, commenttext);
	}
	
	public void rejectRecentComment(String commentid, String commenttext, String reason) throws Throwable{
		
		assertValue(commentid, recentfirstCommentId, "data-feedbackid", "Comment ID");
		click(recentfirstCommentReject, "Reject");
		selectByVisibleText(rejectReason, reason, "Reason for rejection");
		click(rejectSubmit, "Sumbit");
		Thread.sleep(8000);
		assertText(recentfirstCommentOverallStatus, "REJECTED");
		assertText(recentfirstCommentTxt, commenttext);
	}
	
	public void referRecentComment(String commentid, String commenttext, String reason) throws Throwable{
		
		assertValue(commentid, recentfirstCommentId, "data-feedbackid", "Comment ID");
		click(recentfirstCommentRefer, "Refer");
		selectByVisibleText(rejectReason, reason, "Reason for refer");
		click(rejectSubmit, "Sumbit");
		Thread.sleep(8000);
		assertText(reviewfirstCommentOverallStatus, "REFERRED");
		assertText(reviewfirstCommentTxt, commenttext);
	}
	
	public void approveReviewComment(String commentid, String commenttext) throws Throwable{
		
		assertValue(commentid, reviewfirstCommentId, "data-feedbackid", "Comment ID");
		click(reviewfirstCommentApprove, "Approve");
		Thread.sleep(8000);
		assertText(recentfirstCommentOverallStatus, "APPROVED");
		assertText(recentfirstCommentTxt, commenttext);
	}
	
	public void rejectReviewComment(String commentid, String commenttext, String reason) throws Throwable{
		
		assertValue(commentid, reviewfirstCommentId, "data-feedbackid", "Comment ID");
		click(reviewfirstCommentReject, "Reject");
		selectByVisibleText(rejectReason, reason, "Reason for rejection");
		click(rejectSubmit, "Sumbit");
		Thread.sleep(8000);
		assertText(recentfirstCommentOverallStatus, "REJECTED");
		assertText(recentfirstCommentTxt, commenttext);
	}
	
	public void verifyEditSubPage(String pagename, String pagedesc, String choice) throws Throwable{
		
		String xpath = "//a[text()='"+pagename+"']";
		scrollandClick(By.xpath(xpath));
		click(authToolsPagesetting, "Setting");
		type(subpagePageDesc, pagedesc, "Page Description");
		click(DetailsSubmit, "Submit");
		Thread.sleep(8000);
		//SubmitforApprovaPage();
		//Thread.sleep(5000);
		//workflow(choice, "Edit Draft Page");
		//Thread.sleep(5000);
		//assertText(onPageUpdateDesc, pagedesc);
	}
	
	public void verifyProjectinDashboardProjectList(String projectname) throws Throwable{
		String xpath = "//h4/a[contains(text(),'"+projectname+"')]";
		isElementDisplayed(By.xpath(xpath), "Project");
	}
	
	public void searchUserUsingEmailAddress(String usertype, String emailid) throws Throwable{
		
		switch (usertype.toLowerCase()){
		case "site user": click(memberSiteUser, "Site User"); break;
		case "community user": click(memberCommunityUser, "All User"); break;
		case "all user": click(memberAllUser, "All User"); break;
		}
		
		type(memberSearchUser, emailid, "Email Id");
		click(memberSearchbtn, "Search");
		
		Thread.sleep(5000);
		
		click(By.xpath("//td/a[@href='#']"), "User");
		
	}
	
	public void verifyGrantPermissionToDeptAgency(String dept) throws Throwable{
		
		click(memberSelectGroup, "Select Group");
		Thread.sleep(2000);
		click(By.xpath("//label/span[contains(text(), '"+dept+"')]"), "Department");
		Thread.sleep(2000);
		click(memberSelectGroupSubmit, "Okay");
		Thread.sleep(5000);
		assertTextMatching(memberSelectGroup, dept, "Department");
	}
	
	public void verifyRevokePermissionToDeptAgency(String dept) throws Throwable{
		Thread.sleep(2000);
		assertTextMatching(memberSelectGroup, dept, "Department");
		Thread.sleep(2000);
		click(memberSelectGroup, "Select Group");
		Thread.sleep(2000);
		click(By.xpath("//label/span[contains(text(), '"+dept+"')]"), "Department");
		Thread.sleep(2000);
		click(memberSelectGroupSubmit, "Okay");
	}
	
	public void workflow(String flow, String comment) throws Throwable{
		logger.info("in workflow");
		switch (flow.toLowerCase()){
		case "submittoworkflow": 
			submittoWorkflow(comment);
			Thread.sleep(40000);
			break;
		case "savechanges": 
			saveChanges(comment);
			Thread.sleep(40000);
			break;
		case "disgardchanges": 
			disgardChanges(comment);
			Thread.sleep(40000);
			break;
		}
	}
	
	public void savePage() throws Throwable{
		click(authToolsSaveorExitpage, "Save Page");
		Thread.sleep(5000);
	}
	
	public void submittoWorkflow(String versioncomment) throws Throwable{
		logger.info("in sumbitWorkflow");
		Thread.sleep(5000);
		type(versionComment, versioncomment, "Version Comment");
		click(versionSubmittoChng, "Submit to Change");
	}
	
	public void saveChanges(String versioncomment) throws Throwable{
		logger.info("in saveChanges");
		type(versionComment, versioncomment, "Version Comment");
		click(versionSavechng, "Save Change");
	}
	
	public void disgardChanges(String versioncomment) throws Throwable{
		logger.info("in disgardChanges");
		type(versionComment, versioncomment, "Version Comment");
		click(versionDisgardChng, "Disgard Change");
	}
		
	public void approveCancelPage(String choice) throws Throwable{
		logger.info("in approveCancelPage");
		switch (choice.toLowerCase()){
		case "approve": approvePage(); break;
		case "cancel": cancelPage(); break;
		case "ignor": break;
		}
	}
	
	public void cancelPage() throws Throwable{
		logger.info("in cancelPage");
		click(popupCancelPage, "Cancel Page");
	}
	
	public void approvePage() throws Throwable{
		logger.info("in approvePage");
		click(popupApprovePage, "Approve Page");
	}
	
	public void SubmitforApprovaPage() throws Throwable{
		logger.info("in approvePage");
		click(popupSubmitforApproval, "Submit for Approval");
	}
	
	public void selectUpdate() throws Throwable{
		logger.info("in selectUpdate");
		click(authToolsAddupdate, "Add Update");
	}
	
	public void workflowPop(String choice) throws Throwable{
		logger.info("in workflowPop");
		switch (choice.toLowerCase()){
		case "submitforapproval": click(popupSubmitforApproval, "Submit for Approval"); break;
		}
	}
	
	public static void explicityWait(By Locator, String locatorName) throws InterruptedException{
		logger.info("in explicityWait");
		waitForever(Locator);
		WebDriverWait wdw = new WebDriverWait(driver, 30);
		WebElement ele = null;
		//check if web ELement is click able
		ele = wdw.until(ExpectedConditions.elementToBeClickable(Locator));		
	}
	
	public static void waitForever(By loc) throws InterruptedException{
		WebElement ele = driver.findElement(loc);
		int i=0;
		for(i=0;i<=29;i++){
			if(ele.isDisplayed()) break;
			else Thread.sleep(1000);
		}
		for(i=0;i<=29;i++){
			if(ele.isEnabled()) break;
			else Thread.sleep(1000);
		}		
	}
	
	public void addUpdate(String pagename, String newstitle, String newsdesc) throws Throwable{
		click(authToolsAddupdate, "Add Update");
		type(DetailsPjName, newstitle, "News Title");
		type(AddupdateDescp, newsdesc, "News Description");
		click(DetailsSubmit, "Submit");
		
		//verify news title and description
		assertText(onPageUpdateNews, newstitle);
		assertText(onPageUpdateDesc, newsdesc);
		
		//save
		click(authToolsSaveorExitpage, "Save page");
		
		//Submit work flow
		submittoWorkflow("Add News: "+newstitle);
		
		//Approve page
		approvePage();
		
		//verify breadcrump
		assertText(valeleBreadcrumbHome, "Home");
		assertText(valeleBreadcrumbPage, pagename);
		assertText(valeleBreadcrumbNews, newstitle);
	}
	
	public void verifyPageOption() throws Throwable{
		click(authToolsSitemap, "Page");
		isElementDisplayed(pageNewPage, "New page");
		isElementDisplayed(pagePageDraft, "Draft Page");
		isElementDisplayed(pageSitemap, "Site Map");
	}	
	
	public void saveEditPage() throws Throwable{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver.findElements(authExit).size()==1){
			click(authExit, "Exit");
		}else if(driver.findElements(authSave).size()==1){
			click(authSave, "Save");
			workflow("disgardchanges", "Disgard Changes");
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void findAndClick(By loc, String locname) throws Throwable{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver.findElements(loc).size()==1){
			click(loc, locname);
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void scrollToTop() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-300)", "");
		Thread.sleep(5000);
	}
	
	public void scrollToEnd() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(250,250)", "");
		Thread.sleep(5000);
	}
	
	public void openProjectFromDashboardProject(String project) throws Throwable{
		type(dashboardProjectKeyword, project, "Project");
		click(dashboardProjectSearch, "Search");
		Thread.sleep(5000);
		click(By.xpath("//a[contains(text(), '"+project+"')]"), "Project");
	}
	
	public void VerifyFieldsEnableToEditOnProjectPage(String role) throws Throwable{
		logger.info("in VerifyFieldsEnableToEditOnProjectPage");
		
		isEnabled(DetailsPjName, "Project Name");
		isEnabled(DetailsPencil, "Project URL");
		isEnabled(DetailsPJDesc, "Project Desc");
		isEnabled(DetailsPJLoc, "Location");
		isEnabled(projectSelectLogo, "Project Logo");
		isEnabled(Projectcolor, "Project Color");
		if(!role.equalsIgnoreCase("project author")){
			isEnabled(ProjectStatus, "Project Status");
			isEnabled(ProjectType, "Project Type");
			isEnabled(ProjectDept, "Department");
			isEnabled(DetailsPJCate, "Category");
			isEnabled(projectUserName, "Permitted User");
		}
	}
	
	public void verifyActivityFeed(String project, String subpage) throws Throwable{
		navigateToActivityFeed();
		assertText(activityfeedProject, project);
		assertText(activityfeedPage, subpage);
	}
	
	public void navigateToActivityFeed() throws Throwable{
		logger.info("in navigateToModerationMethod");
		click(authToolsDashboard, "Dashboard");
		Thread.sleep(5000);
		click(dashboardActivityfeed, "Dashboard/ActivityFeed");
		Thread.sleep(5000);
	}
	
}