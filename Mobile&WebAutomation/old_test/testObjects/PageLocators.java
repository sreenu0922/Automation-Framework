package com.desktopWeb.testObjects;

import org.openqa.selenium.By;

import com.ctaf.accelerators.ActionEngine;

public class PageLocators extends ActionEngine{
	
	public static By learnBaicWindowclose = By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']");
	
	//HomePage - menu
	public static By menu = By.xpath("//a[@aria-label='navigation menu']");
	public static By menuHome = By.xpath("//*[@id='navlinks']/li[1]/a");
	public static By menuAbout = By.xpath("//*[@id='navlinks']/li/a[contains(text(),'About')]");
	public static By menuConsultations = By.xpath("//*[@id='navlinks']/li/a[contains(text(),'Consultations')]");
	public static By menuContactus = By.xpath("//*[@id='navlinks']/li/a[contains(text(),'Contact us')]");
	public static By menuLogin = By.xpath("//li/a/span[contains(text(),'Join')]");
	public static By menuSignOut = By.xpath("//span[text()='Sign Out']");
	
	public static By returnToWebsite = By.xpath("//a[contains(@href, 'index.php?cID=')]");
	
	//Project title and desc on page
	public static By onpageProjectTitle = By.xpath("//h1[@class='banner-content-heading']");
	public static By onpageProjectDesc = By.xpath("//div[@class='banner-content-desc']/p");
	
	//Active Project Page
	public static By activeProjctARB = By.xpath("//article[@data-project-name='Aboriginal Representative Body']");
	public static By activeProjectLGBIT = By.xpath("//article[@data-project-name='LGBTI Equality Roadshow']");
	
	//Validate project Page
	public static String titleprojectARB = "Engage Victoria :: Aboriginal Representative Body";
	public static String titleprojectLGBIT = "Engage Victoria :: LGBTI Equality Roadshow";
	public static By valeleLARB = By.xpath("//h1[contains(text(),'Community Consultation on Aboriginal Representation')]");
	public static By valeleLGBIT = By.xpath("//h1[contains(text(),'LGBTI Equality Roadshow')]");
		
	//Home Page - verify presence of web element
	public static By engageviclogo = By.xpath("//img[@src='/packages/custom_vic/themes/the_hive_vic/img/engage-vic-logo.png']");
	
	//Website Search
	public static By searchSite = By.xpath("//*[@id='searchsite']");
	public static By searchSiteButn = By.xpath("//img[@src='/packages/custom_vic/themes/the_hive_vic/img/icon-search-grey.png']");
	
	//Search website result page
	public static By searchWSKeyword = By.xpath("//input[@id='query']");
	public static By searchResult = By.xpath("//div[@class='searchResult']");
	
	public static By heroblock_engagevictoria = By.xpath("//h1[@class='banner-content-heading mod-lg']");
	public static By heroblock_txt = By.xpath("//p[text()='Share ideas here and have your say about what matters to you ']");
	public static By heroblock_img = By.xpath("//div[contains(@style, 'background-image:url(/application/files/3214/8118/3884/FAMILY_Small.jpg);')]");
	//public static By heroblock_img = By.xpath("//div[contains(@style, 'background-image: url(\"/application/files/3214/8118/3884/FAMILY_Small.jpg\");')]");
	
	public static By txt_imlookingfor = By.xpath("//span[contains(text(), 'm looking for consultations relating to ')]");
	public static By dropdwnCategory = By.xpath("//select[@name='category']");
	public static By categorySearchbtn = By.xpath("//form/button[@type='submit' and text()='Search']");
	
	//Section on Consultations page :: Search result
	public static By categoryCurrentPrj = By.xpath("//section[@id='hive-block-49']");
	public static By categoryResultCurrentPrj = By.xpath("//section[@id='hive-block-49']/div");
	
	public static By categoryUpdatePrj = By.xpath("//section[@id='hive-block-79']");
	public static By categoryResultUpdatePrj = By.xpath("//section[@id='hive-block-79']/div");
	
	public static By categoryPastPrj = By.xpath("//section[@id='hive-block-80']");
	public static By categoryResultPastPrj = By.xpath("//section[@id='hive-block-80']/div");
	
	//WebSite Feature
	public static By websiteFeature = By.xpath("//div[@class='row home-messages']");
	
	public static By sectionActiveProjects = By.xpath("//section[@class='hive-block projects-list']");
	//public static By sectionfootersubscribe = By.xpath("//section[@class='footer-subscribe']");
	
	//Footer
	public static By sectionsubscribe = By.xpath("//section[@class='action-items has_subscribe']");
	public static By sectionfooter = By.xpath("//footer[@class='footer']");
	
	//Stay Informed
	public static By sectionStayInformed = By.xpath("//div[@class='footer-subscribe-inner']");
	public static By txtStayInformed = By.xpath("//h3[text()='Stay Informed']");
	public static By txtThisyouropp = By.xpath("//p[contains(text(),'This is your opportunity to create a "
			+ "better Victoria by participating in the projects that make our state great. "
			+ "Share your ideas and exchange views with other communities.')]");
	public static By susbscribeemail = By.xpath("//input[@id='informed--email']");
	public static By susbscribeSignupbtn = By.xpath("//strong[text()='Sign up today']");
	
	//Footer links
	public static By footercopyrightlnk = By.xpath("//ul[@class='links-list']/li/a[text()='Copyright']");
	public static By footerprivacylnk = By.xpath("//ul[@class='links-list']/li/a[text()='Privacy']");
	public static By footertermsofUselnk = By.xpath("//ul[@class='links-list']/li/a[text()='Terms of Use']");
	public static By footeraccessibilitylnk = By.xpath("//ul[@class='links-list']/li/a[text()='Accessibility']");
	public static By footermoderationlnk = By.xpath("//ul[@class='links-list']/li/a[text()='Moderation']");
	public static By footercommunityGuidelineslnk = By.xpath("//ul[@class='links-list']/li/a[text()='Community Guidelines']");
	public static By footeraboutUslnk = By.xpath("//ul[@class='links-list']/li/a[text()='About Us']");
	public static By footersiteMaplnk = By.xpath("//ul[@class='links-list']/li/a[text()='Site Map']");
	public static By footercontactUslnk = By.xpath("//ul[@class='links-list']/li/a[text()='Contact Us']");
	
	public static By footercopyright = By.xpath("//div[@class='footer-copyright']/small");
	public static By footerGovOfVicfooterlnk = By.xpath("//a[text()='The State Government of Victoria']");
	
	public static By footerTheHive = By.xpath("//img[@alt='Powered by The Hive']");
	
	public static By footerSignOut = By.xpath("//a[contains(text(),'Sign Out')]");
	
	//Login/Out - from footer
	public static By loginfromfooter = By.xpath("//a[contains(text(), 'Log In to Site')]");
	public static By signoutfromfooter = By.xpath("//a[contains(text(),'Sign Out')]");
	
	//Login Page
	public static By loginEmail = By.xpath("//input[@id='loginFormEmail']");
	public static By loginemailID = By.xpath("//input[@id='Email']");
	public static By loginPassword = By.xpath("//input[@id='loginFormPassword']");
	public static By loginloginbtn = By.xpath("//div/button[text()='Log in']");
	public static By loginForgotPwd = By.xpath("//div/button[text()='Forgot your password?']");
	public static By loginSignUp = By.xpath("//button[text()='Sign up']");
	public static By loginErrorMsg = By.xpath("//span[@id='loginFormEmail-error']");
	public static By loginCross = By.xpath("//*[@id='loginModal']/div/div/div/button/span");
	public static By resetPwdCross = By.xpath("//*[@id='resetPasswordModal']/div/div/div/button/span");
											
	//breadcrumbs link
	public static By breadcrumbs = By.xpath("//a[text()='Home']");
	
	//Title to verify next page
	public static String titleHome = "Engage Victoria :: Home";
	public static String titleCopyRight = "Engage Victoria :: Copyright";
	public static String titlePrivacyPolicy = "Engage Victoria :: Privacy Policy";
	public static String titleTermsofUse = "Engage Victoria :: Terms of Use";
	public static String titleAccessibility = "Engage Victoria :: Accessibility";
	public static String titleModerationPolicy = "Engage Victoria :: Moderation Policy";
	public static String titleAbout = "Engage Victoria :: About Us";
	public static String titleCommunityGuidelines = "Engage Victoria :: Community Guidelines";
	public static String titleContactus = "Engage Victoria :: Contact us";
	public static String titleSitemap = "Engage Victoria :: Site map";
	public static String titleConsultations = "Engage Victoria :: Consultations";
	public static String titleSearch = "Engage Victoria :: Search";
	public static String titleTheHive = "The Hive :: Home";
	public static String titleGovofVic = "Victorian Government";
	
	//web elements to verify next page 
	public static By valeleCopyRight = By.xpath("//h1[contains(text(),'Copyright')]");
	public static By valelePrivacyPolicy = By.xpath("//h1[@class='mod-lg' and contains(text(),'Privacy Policy')]");
	public static By valeleTermsofUse = By.xpath("//h1[contains(text(),'Terms of Use')]");
	public static By valeleAccessibility = By.xpath("//h1[contains(text(),'Accessibility')]");
	public static By valeleModerationPolicy = By.xpath("//h1[contains(text(),'Moderation Policy')]");
	public static By valeleAbout = By.xpath("//h1[contains(text(),'About')]");
	public static By valeleCommunityGuidelines = By.xpath("//h1[contains(text(),'Community Guidelines')]");
	public static By valeleContactus = By.xpath("//h1[contains(text(),'Contact us')]");
	public static By valeleSitemap = By.xpath("//h1[contains(text(),'Site map')]");
	public static By valeleConsultations = By.xpath("//h1[contains(text(),'Consultations')]");
	public static By valeleLogin = By.xpath("//h1[text()='Welcome back']");
	public static By valeleGovofVic = By.xpath("//a[text()='Vic.gov.au']");
	public static By valeleSearch = By.xpath("//h1[contains(text(),'Search')]");
	public static By valeleTheHive = By.xpath("//img[@id='the-hive-logo']");
	
	//Contact us
	public static By contactusName = By.xpath("//input[@id='Question18']");
	public static By contactusEmail = By.xpath("//input[@id='Question19']");
	public static By contactusOrg = By.xpath("//input[@id='Question21']");
	
	//Test data - I need help with a consultation
	public static By contactusQueryNature = By.xpath("//select[@id='Question24']");
	public static By contactusComment = By.xpath("//textarea[@id='Question22']");
	public static By contactusPrivacyStatement = By.xpath("//label[@id='FieldQuestion23']");
	public static By contactusSubmit = By.xpath("//button[@class='btn']");
	public static By contactusSuccessMsg = By.xpath("//div[contains(text(),'Thank you for your enquiry."
			+ " We will be in contact with you shortly')]");
	
	//Auto revert email on query
	public static By emailContactSubject = By.xpath("//div[2]/span[text()='info']");
	public static By emailContactmsg = By.xpath("//p[text()='Thank you for your "
			+ "submission of the form Engage Victoria contact us through Engage Victoria']");
	
	//Forgot password
	public static By forgotpwdemail = By.xpath("//input[@id='resetPasswordEmail']");
	public static By forgotresetbtn = By.xpath("//button[text()='Reset and Email Password']");
	
	public static By forgotPwdMes= By.xpath("//div[@class='error-message alert alert-success']");
	
	//login to Email
	public static By emailNextbtn = By.xpath("//input[@id='next']");
	public static By emailPasswd = By.xpath("//input[@id='Passwd']");
	public static By emailsignInbtn = By.xpath("//input[@id='signIn']");
	public static By emailgmailicon = By.xpath("//img[contains(@src,'gmail_512dp.png')]");
	public static By emailResetPwdsubject = By.xpath("//div[2]/span[text()='Forgot Password']");
	public static By emailreseturl = By.xpath("//p/a[contains(@data-saferedirecturl,'https')]");
	
	//Home Page after Login
	public static By menuDashboard = By.xpath("//a[@data-launch-panel='dashboard']");
	
	//DashBoard->>>
	public static By dashboardLinktoProfile = By.xpath("//a[contains(@href,'account')]");
	public static By dashboardModeration = By.xpath("//section/ul/li/a[text()='Moderation ']");
	public static By dashboardProject = By.xpath("//a[contains(@href, 'dashboard/projects')]");
	public static By projectLaunchProject = By.xpath("//a[@title='Launch New Project']");
	public static By dashboardReports = By.xpath("//section/ul/li/a[text()='Reports']");
	public static By dashboardAnalytics = By.xpath("//section/ul/li/a[text()='Analytics']");
	public static By dashboardFiles = By.xpath("//section/ul/li/a[text()='Files']");
	public static By dashboardMembers = By.xpath("//section/ul/li/a[text()='Members']");
	public static By dashboardSitemap = By.xpath("//section/ul/li/a[text()='Sitemap']");
	public static By dashboardActivityfeed = By.xpath("//section/ul/li/a[text()='Activity Feed']");
	public static By dashboardHiveSetting = By.xpath("//section/ul/li/a[text()='Hive Settings']");

	
	
	//Dashboard/Activity Feed
	public static By activityfeedProject = By.xpath("//div[@class='ccm-dashboard-content-full']/div[2]//a[1]/span");
	public static By activityfeedPage = By.xpath("//div[@class='ccm-dashboard-content-full']/div[2]//a[2]/span");
	
	//Dashboard/Moderation
	public static By projectComment = By.xpath("//textarea[@class='form-control visionSubmission']");
	public static By projectCommentSubmit = By.xpath("//button[@class='btn pull-right submit']");

	public static By rejectReason = By.xpath("//select[@id='reason']");
	public static By rejectSubmit = By.xpath("//input[@type='submit']");
	
	
	//Moderation/First Comment in Awaiting
	public static By awaitingfirstCommentId = By.xpath("//div[@id='awaiting']/div[1]");
	public static By awaitingfirstCommentOverallStatus = By.xpath("//div[@id='awaiting']/div[1]/div/span/b");
	public static By awaitingfirstCommentApprove = By.xpath("//div[@id='awaiting']/div[1]/div[4]/div/a[1]");
	public static By awaitingfirstCommentReject = By.xpath("//div[@id='awaiting']/div[1]/div[4]/div/a[2]");
	public static By awaitingfirstCommentRefer = By.xpath("//div[@id='awaiting']/div[1]/div[4]/div/a[3]");
	public static By awaitingfirstCommentTxt = By.xpath("//div[@id='awaiting']/div[1]/div[3]/p");
	
	//Moderation/First Comment in Recently
	public static By recentfirstCommentId = By.xpath("//div[@id='recent']/div[1]");
	public static By recentfirstCommentOverallStatus = By.xpath("//div[@id='recent']/div[1]/div/span/b");
	public static By recentfirstCommentApprove = By.xpath("//div[@id='recent']/div[1]/div[4]/div/a[1]");
	public static By recentfirstCommentReject = By.xpath("//div[@id='recent']/div[1]/div[4]/div/a[2]");
	public static By recentfirstCommentRefer = By.xpath("//div[@id='recent']/div[1]/div[4]/div/a[3]");
	public static By recentfirstCommentTxt = By.xpath("//div[@id='recent']/div[1]/div[3]/p");
	
	//Moderation/First Comment in Review
	public static By reviewfirstCommentId = By.xpath("//div[@id='review']/div[1]");
	public static By reviewfirstCommentOverallStatus = By.xpath("//div[@id='review']/div[1]/div/span/b");
	public static By reviewfirstCommentApprove = By.xpath("//div[@id='review']/div[1]/div[4]/div/a[1]");
	public static By reviewfirstCommentReject = By.xpath("//div[@id='review']/div[1]/div[4]/div/a[2]");
	public static By reviewfirstCommentTxt = By.xpath("//div[@id='review']/div[1]/div[3]/p");
	
	//Dashboard/Members
	public static By membersAddUserDropDwn = By.xpath("//button[@data-toggle='dropdown']");
	public static By membersCommUser = By.xpath("//a[contains(@href,'community/add')]");
	public static By membersSiteUser = By.xpath("//a[contains(@href,'site/add')]");
	public static By membersUserName = By.xpath("//input[@id='uName']");
	public static By membersPassword = By.xpath("//input[@id='uPassword']");
	public static By membersEmail = By.xpath("//input[@id='uEmail']");
	public static By membersFirstName = By.xpath("//input[@id='akID[37][value]']");
	public static By membersLastName = By.xpath("//input[@id='akID[38][value]']");
	public static By membersAddBtn = By.xpath("//input[@type='submit']");
	public static By membersSiteAdmin = By.xpath("//input[@type='checkbox']");
	public static By membersActiveDeletebtn = By.xpath("//button[@type='submit']");
	public static By valeleMember = By.xpath("//div[@class='alert alert-info']");
	public static By memberSearchUser = By.xpath("//input[@type='search']");
	public static By memberCommunityUser = By.xpath("//ul[@class='nav nav-tabs']/li/a[contains(text(),'Community Members')]");
	public static By memberSiteUser = By.xpath("//ul[@class='nav nav-tabs']/li/a[contains(text(),'Site Users')]");
	public static By memberAllUser = By.xpath("//ul[@class='nav nav-tabs']/li/a[contains(text(),'All Users')]']");
	public static By memberSearchbtn = By.xpath("//button[@class='btn btn-primary pull-right']");
	public static By memberSelectGroup = By.xpath("//section/div/div[2]/div[6]/div[2]/span");
	public static By memberSelectGroupSubmit = By.xpath("//button[@class='btn btn-primary btn-sm editable-submit']");
	
	public static By removePermittedUserBtn = By.xpath("//span[@class='fa fa-remove']");
	
	
	//Dashboard/Sitemember
	public static By sitememberVisit = By.xpath("//a[text()='Visit']");
	
	//Dashboard/Hive Setting
	public static By hivesettingModerationMethod = By.xpath("//a[contains(@href, 'moderation_method')]");
	public static By hivesettingBannedWords = By.xpath("//a[contains(@href, 'banned_words')]");
	
	public static By moderationmethodReason = By.xpath("//input[@name='newReasonText']");
	public static By moderationmethodAdd = By.xpath("//button[@class='add-sortable-reason btn btn-default']");
	public static By moderationmethodDelete = By.xpath("//ul[@id='sortable-reasons']/li[6]/button");
	
	//Dashboard/Results
	public static By resultsForm = By.xpath("//a[text()='Forms' and @class='']");
	public static By resultsOpenPageOne = By.xpath("//tbody/tr[1]/td[3]/form/div/a[2]");
	
	//Account
	public static By accountEditProfile = By.xpath("//a[contains(@href,'profile')]");
	
	//Edit Profile
	public static By EditprofileNewPwd = By.xpath("//input[@id='uPasswordNew']");
	public static By EditprofileConfirmPwd = By.xpath("//input[@id='uPasswordNewConfirm']");
	public static By EditprofileSave = By.xpath("//input[@type='submit']");
	
	//find consultation
	public static By categoryhelpmefinebtn = By.xpath("//button[text()='Help me find a consultation']");
	public static By fndConsKeyword = By.xpath("//*[@id='keywords']");
	public static By fndConsLocation = By.xpath("//*[@id='s2id_autogen2']");
	public static By fndConsCategory = By.xpath("//*[@id='s2id_autogen3']");
	public static By fndConsDepartment = By.xpath("//*[@id='s2id_autogen4']");
	public static By fndConsProjectGrp = By.xpath("//*[@id='s2id_autogen5']");
	public static By fndConsStatusAll = By.xpath("//label[@for='status-all']");
	public static By fndConsStatusOpen = By.xpath("//label[@for='status-open']");
	public static By fndConsStatusActive = By.xpath("//label[@for='status-active']");
	public static By fndConsStatusClosed = By.xpath("//label[@for='status-closed']");
	public static By fndConsSearch = By.xpath("//div/button[text()='Search']");
	
	//Sign in page
	public static By menuLoginSignin = By.xpath("//button[@data-target='#signUpModal']");
	public static By signinScreenName = By.xpath("//input[@id='signupFormName']");
	public static By signinEmail = By.xpath("//input[@id='signupFormEmail']");
	public static By signinPwd = By.xpath("//input[@id='signupFormPassword']");
	public static By signinPostcode = By.xpath("//input[@id='signupFormPostcode']");
	public static By signinInterests = By.xpath("//input[@id='s2id_autogen1']");
	public static By signinCheckbx = By.xpath("//label[@for='signupFormNotify']");
	public static By signinCreateAcc = By.xpath("//button[text()='Create Account']");
	public static By signinDoneClose = By.xpath("//button[text()='Close' and @class='btn btn-blue btn-block']");
	
	//reset password window
	public static By resetPwdnwPwd = By.xpath("//input[@id='uPassword']");
	public static By resetPwdcnfPwd = By.xpath("//input[@id='uPasswordConfirm']");
	public static By resetPwdbtn = By.xpath("//button[@class='btn btn-blue']");
	
	//Password successfully changed.
	public static By pwdchangedmsg = By.xpath("//div[@class='alert mod-alert-success']");
	public static By gotohmpg = By.xpath("//a[@class='btn btn-block']");
	
	//tools bar
	public static By Authoringtoolbar = By.xpath("//ul[@class='ccm-toolbar-item-list']");
	public static By authToolsEditpage = By.xpath("//li[@data-guide-toolbar-action='edit-page']");
	public static By authEdit = By.xpath("//span[@class='ccm-toolbar-accessibility-title "
			+ "ccm-toolbar-accessibility-title-edit-mode' and contains(text(),'Edit')]");
	public static By authExit = By.xpath("//span[@class='ccm-toolbar-accessibility-title"
			+ " ccm-toolbar-accessibility-title-edit-mode'and contains(text(),'Exit')]");
	public static By authSave = By.xpath("//span[@class='ccm-toolbar-accessibility-title"
			+ " ccm-toolbar-accessibility-title-edit-mode'and contains(text(),'Save')]");
	public static By authToolsSaveorExitpage = By.xpath("//li[@data-guide-toolbar-action='check-in']");
	public static By authToolsPagesetting = By.xpath("//li[@data-guide-toolbar-action='page-settings']");
	//public static By toolsTools = By.xpath("data-launch-panel='add-block']");
	public static By authToolsTools = By.xpath("//li[@data-guide-toolbar-action='add-content']");
	
	//use toolsDetailsPjName, toolsDetailsURL and toolsDetailsSubmit under: ******************Setting/Details/ Elements
	public static By authToolsAddupdate = By.xpath("//li[@class='pull-left']");
	public static By AddupdateDescp = By.xpath("//textarea[contains(@id,'description')]");
	//Validate Add update action
	public static By onPageUpdateNews = By.xpath("//h1[@class='text-center']");
	public static By onPageUpdateDesc = By.xpath("//header[@class='text-center']/p/strong");	
	
	public static By authToolsDashboard = By.xpath("//li[@data-guide-toolbar-action='dashboard']");
	public static By authToolsSitemap = By.xpath("//li[@data-guide-toolbar-action='sitemap']");
	
	
	//Pages
	public static By pageNewPage = By.xpath("//div[@class='ccm-panel-content-inner']/h5[1]");
	public static By pageSitemap = By.xpath("//div[@class='ccm-panel-content-inner']/h5[2]");
	public static By pagePageDraft = By.xpath("//div[@class='ccm-panel-content-inner']/h5[3]");	
	
	public static By sitemapExpand = By.xpath("//span[@class='dynatree-expander']");
	public static By sitemapNewPageMore = By.xpath("//a[contains(text(),'More')]");
	public static By newPageProjectSubPage = By.xpath("//li/a[contains(text(),'Project Sub-page')]");
	public static By newPageSiteSubPage = By.xpath("//li/a[contains(text(),'Site Sub-page')]");
	public static By newPageProjectPage = By.xpath("//li/a[contains(text(),'Project Page')]");
	public static By newPageNewsPage = By.xpath("//li/a[contains(text(),'News Page')]");
	
	public static By PageHome = By.xpath("//ul/li/span/a[text()='Home']");
	public static By PageAbout = By.xpath("//ul/li/span/a[text()='About Us']");
	public static By PageConsultation = By.xpath("//ul/li/span/a[text()='Consultations']");
	public static By PageContactUs = By.xpath("//ul/li/span/a[text()='Contact us']");
	public static By PageSearch = By.xpath("//ul/li/span/a[text()='Search']");
	public static By PageCopyrights = By.xpath("//ul/li/span/a[text()='Copyright']");
	public static By PagePrivacyPolicy = By.xpath("//ul/li/span/a[text()='Privacy Policy']");
	public static By PageTermofUse = By.xpath("//ul/li/span/a[text()='Terms of Use']");
	public static By PageAccessibility = By.xpath("//ul/li/span/a[text()='Accessibility']");
	public static By PageModerationPolicy = By.xpath("//ul/li/span/a[text()='Moderation Policy']");
	public static By PageCommunityGuidelines = By.xpath("//ul/li/span/a[text()='Community Guidelines']");
	public static By PageSitemap = By.xpath("//ul/li/span/a[text()='Site map']");
	
	public static By pageSettingBack = By.xpath("//a[@data-panel-navigation='back']");
	
	public static By pageDetailPageLocation = By.xpath("//select[@id='cParentID']");
	
	//********Page Setting options 
	public static By pageSettingDetails = By.xpath("//menu/li/a[contains(text(), 'Details')]");
	public static By pageSettingDesign = By.xpath("//menu/li/a[contains(text(), 'Design')]");
	public static By pageSettingSEO = By.xpath("//menu/li/a[contains(text(), 'SEO')]");
	public static By pageSettingLocation = By.xpath("//menu/li/a[contains(text(), 'Location')]");
	public static By pageSettingVersions = By.xpath("//menu/li/a[contains(text(), 'Versions')]");
	public static By pageSettingMobilePreview = By.xpath("//menu/li/a[contains(text(), 'Mobile Preview')]");
	public static By pageSettingDelete = By.xpath("//menu/li/a[contains(text(), 'Delete Page')]");
	
	//********Version/Options
	public static By versionApprove = By.xpath("//div[@class='ccm-popover-inverse popover fade bottom']"
			+ "/div/ul/li/a[text()='Approve']");
	public static By versionDuplicate = By.xpath("//div[@class='ccm-popover-inverse popover fade bottom']"
			+ "/div/ul/li/a[text()='Duplicate']");
	public static By versionNewPage = By.xpath("//div[@class='ccm-popover-inverse popover fade bottom']"
			+ "/div/ul/li/a[text()='New Page']");
	public static By versionDelete = By.xpath("//div[@class='ccm-popover-inverse popover fade bottom']"
			+ "/div/ul/li/a[text()='Delete']");
	
	public static By valeleVersionApprove = By.xpath("//*[@id='ccm-panel-page-versions']/table/tbody/tr/td[3]/p[4]");
	public static By valeleVersionDuplicate = By.xpath("//tr[1]/td[@class='ccm-panel-page-versions-details']/p[3]/small");
	
	//******************Setting/Details/ Elements
	public static By DetailsPjName = By.xpath("//input[contains(@id,'name')]");
	public static By DetailsPencil = By.xpath("//i[@class='fa fa-pencil']");
	public static By DetailsURL = By.xpath("//input[contains(@id,'url_slug')]");
	public static By DetailsPJDesc = By.xpath("//textarea[contains(@id, 'description')]");
	//***Dept, status and type xpath is same as below-->
	public static By DetailsSubmit = By.xpath("//div/button[@type='button' and text()='Submit']");
	public static By DetailsChooseaPage = By.xpath("//a[@data-page-selector-link='choose']");
	
	//******************Setting/Design/ Elements
	public static By DesignExpand = By.xpath("//span[contains(text(),'Expand')]");
	public static By DesignRightSlider = By.xpath("//input[@value='13']");
	public static By DesignFull = By.xpath("//input[@value='5' and @name='pTemplateID']");
	public static By DesignNarrow = By.xpath("//input[@value='17']");
	public static By DesignNewsFull = By.xpath("//input[@value='14']");
	
	public static By saveChanges = By.xpath("//button[@class='pull-right btn btn-success']");
	
	public static By DetailsPJCate = By.xpath("//fieldset[@class='topics_33']//span[@class='dynatree-checkbox']");
	public static By DetailsPJLoc = By.xpath("//fieldset[@class='topics_32']//span[@class='dynatree-checkbox']");
	
	public static By popupRejectPage = By.xpath("//button[@class='btn btn-xs btn-default js-reject-btn']");
	public static By rejectReasonPopup = By.xpath("//textarea[@name='reason']");
	public static By submitRejection = By.xpath("//button[text()='Submit Rejection']");
	
	public static By DetailsPageLocation = By.xpath("//select[@id='cParentID']");
	
	//******************Edit/ Elements - project name and desc
	//public static By heroBlockSection = By.xpath("//div[@id='ccm-menu-click-proxy']");
	public static By heroBlockSection = By.xpath("//div[@class='banner-img mod-size-medium']");
	public static By editHeroBlockTitle = By.xpath("//input[@id='bannerTitle']");
	public static By editHeroBlockDesc = By.xpath("//div[@class='redactor-editor']");
	public static By editHeroBlockSave = By.xpath("//button[text()='Save']");
	//----->>>Tools bar save page xpath is above");
	
	//Edit/Block
	public static By toolsaddBlock = By.xpath("//*[@id='ccm-popover-menu-container']/div/div[2]/ul/li[1]/a[text()='Add Block']");
	public static By toolsDeleteBlock = By.xpath("//*[@id='ccm-popover-menu-container']/div/div[2]/ul/li[3]/a[text()='Delete']");
	public static By toolsEditBlock = By.xpath("//*[@id='ccm-popover-menu-container']/div/div[2]/ul/li[1]/a[text()='Edit Block']");
	public static By addBlockMessage = By.xpath("//*[text()='The block has been added successfully.']");
	public static By deleteBlockMessage = By.xpath("//*[text()='The block has been removed successfully.']");
	
	
	//****************Setting/SEO/Element
	public static By seoMetaDesc = By.xpath("//textarea[@id='akID[2][value]']");
	
	//*****Setting/Location
	public static By locLocation=By.xpath("//button[@name='location']");
	public static By locChooseLocation=By.xpath("//button[text()='Choose Location']");
	public static By locSiteMapExpand = By.xpath("//*[@id='ccm-tab-content-sitemap']/div/ul/li/span/span[1]");
	public static By locSiteMapHome = By.xpath("//span/a[text()='Home']");
	public static By locGo = By.xpath("//a[@onclick='ConcreteSitemap.submitDragRequest()']");
	
	//********Setting/versions/Element
	public static By versionver1ckbx = By.xpath("//input[@class='ccm-flat-checkbox' and @value='1']");
	public static By versionComment = By.xpath("//textarea[@id='ccm-check-in-comments']");
	public static By versionSubmittoChng = By.xpath("//button[@id='ccm-check-in-publish']");
	public static By versionDisgardChng = By.xpath("//button[@id='ccm-check-in-discard']");
	public static By versionSavechng = By.xpath("//button[@id='ccm-check-in-preview']");	
	public static By onpageVersionnum = By.xpath("//a[@data-tab='view-version-1']");
	
	//*******Setting/Mobile Preview/Element
	public static By mobileiphone6 = By.xpath("//span[text()='iPhone 6']");
	public static By mobileiphone6plus = By.xpath("//span[text()='iPhone 6 Plus']");
	public static By mobileiphone5s = By.xpath("//span[text()='iPhone 5s']");
	public static By mobileSamsungGs5 = By.xpath("//span[text()='Samsung Galaxy S5']");
	public static By mobileipad = By.xpath("//span[text()='iPad']");
	public static By mobilePortrait = By.xpath("//button[contains(@class, 'pull-left btn btn-default ccm-device-portrait')]");
	public static By mobilelandscape = By.xpath("//button[contains(@class, 'pull-left btn btn-default ccm-device-landscape')]");
	
	public static By mobileDeviceiphone6 = By.xpath("//div[@class='ccm-device-iphone6']");
	public static By mobileDeviceiphone6plus = By.xpath("//div[@class='ccm-device-iphone6']");
	public static By mobileDeviceiphone5s = By.xpath("//div[@class='ccm-device-iphone6']");
	public static By mobileDeviceSamsungGs5 = By.xpath("//div[@class='ccm-device-iphone6']");
	public static By mobileDeviceipad = By.xpath("//div[@class='ccm-device-iphone6']");

	//landscape - style="width: 667px; height: 375px;"
	//portrait - style="width: 375px; height: 667px;"
	public static By mobileFrame = By.xpath("//iframe[@class='ccm-display-frame']");
	
	//*******Setting/Delete Page/Element
	public static By deleteErrormsg = By.xpath("//div[@class='alert alert-error']");
	public static By deleteCancelbtn = By.xpath("//input[@class='btn btn-default']");
	public static By deleteDeletebtn = By.xpath("//button[@data-dialog-action='submit']");
	
	
	//****************Tools
	public static By toolsAddContent = By.xpath("//a[@data-dialog-title='Add Text']");	
	public static By toolsAddHTML = By.xpath("//a[@data-dialog-title='Add HTML']");
	public static By toolsAddBlockQuote = By.xpath("//a[@data-dialog-title='Add Block Quote']");
	public static By toolsAddHeading = By.xpath("//a[@data-dialog-title='Add Heading']");
	public static By toolsAddDivider = By.xpath("//a[@data-dialog-title='Add Divider']");
	public static By toolsAddImage = By.xpath("//a[@data-dialog-title='Add Image']");
	public static By toolsAddFlexi = By.xpath("//a[@data-dialog-title='Add Flexi Content']");
	public static By toolsAddTabsStart = By.xpath("//a[@data-dialog-title='Add Tabs Start']");
	public static By toolsAddTabsEnd = By.xpath("//a[@data-dialog-title='Add Tabs End']");
	public static By toolsAddButton = By.xpath("//a[@data-dialog-title='Add Button']");
	//public static By toolsAddNavigation = By.xpath("//a[@data-dialog-title='Add Sub Nav']");
	public static By toolsAddWebMap = By.xpath("//a[@data-dialog-title='Add Web Map']");
	public static By toolsAddImageGallery = By.xpath("//a[@data-dialog-title='Add Image Gallery']");
	public static By toolsAddImageSlider = By.xpath("//a[@data-dialog-title='Add Image Slider']");
	public static By toolsAddVideo = By.xpath("//a[@data-dialog-title='Add Video']");
	public static By toolsAddSwipe = By.xpath("//a[@data-dialog-title='Add Swipe']");
	public static By toolsAddDocumentLibrary = By.xpath("//a[@data-dialog-title='Add Document Library']");
	public static By toolsAddFAQ = By.xpath("//a[@data-dialog-title='Add FAQ']");
	public static By toolsAddKeyDates = By.xpath("//a[@data-dialog-title='Add Key Dates']");
	public static By toolsAddLinks = By.xpath("//a[@data-dialog-title='Add Links']");
	public static By toolsAddTimeline = By.xpath("//a[@data-dialog-title='Add Timeline']");
	public static By toolsAddSubscriptionForm = By.xpath("//a[@data-dialog-title='Add Subscription Form']");
	public static By toolsAddContactUs = By.xpath("//a[@data-dialog-title='Add Contact Us']");
	public static By toolsAddNewsFeed = By.xpath("//a[@data-dialog-title='Add News Feed']");
	public static By toolsAddFeatureGrid = By.xpath("//a[@data-dialog-title='Add Feature Grid']");
	public static By toolsAddAccordion = By.xpath("//a[@data-dialog-title='Add Accordion']");
	public static By toolsAddForm = By.xpath("//a[@data-dialog-title='Add Form']");
	public static By toolsAddQuickPoll = By.xpath("//a[@data-dialog-title='Add Quick Poll']");
	public static By toolsAddConversation = By.xpath("//a[@data-dialog-title='Add Conversation']");
	public static By toolsAddSocialMap = By.xpath("//a[@data-dialog-title='Add Social Map']");
	public static By toolsAddVisionerInput = By.xpath("//a[@data-dialog-title='Add Visioner Input']");
	public static By toolsAddVisionerResults = By.xpath("//a[@data-dialog-title='Add Visioner Results']");
	public static By toolsAddForum = By.xpath("//a[@data-dialog-title='Add Forum']");
	
	
	//Tools/Content - functionality
	public static By addContentEditbox = By.xpath("//div[@class='redactor-editor']");
	public static By addContentSave = By.xpath("//button[@id='ccm-redactor-save-button']");
	//Validate - add context
	public static By valeleContent = By.xpath("//p[text()='hello world']");

	//Add Button
	public static By Addbutton = By.xpath("//button[text()='Add']");
	
	//Add Button - inner window
	public static By innerAddbutton = By.xpath("//input[@type='submit' and @value='Add']");
	
	//Save Button
	public static By Savebutton = By.xpath("//button[text()='Save']");
	
	//Add Item
	public static By addItemButton = By.xpath("//button[@title='Add Item']");
	
	//Add group
	public static By addGroup = By.xpath("//button[@title='Add Group']");
	
	
	//Tools/HTML
	public static By addhtmleditor = By.xpath("//div[@class='ace_gutter-cell ']");
	public static By addhtmleditor1 = By.xpath("//textarea[@class='ace_text-input']");
	public static By addhtmleditor2 = By.xpath("//div[@class='ace_line']");
	public static By valeleHTML = By.xpath("//div[contains(@id,'HTMLBlock')]/h2");
	
	//*******Tools/Block Quote
	public static By blockQuoteText = By.xpath("//textarea[@id='quote']");
	public static By blockQuoteAuthor = By.xpath("//input[@id='author']");
	public static By valeleQuote = By.xpath("//aside/div[@class='hive-block-inner']");
	public static By valeleQuoteAuthor = By.xpath("//aside/footer/small/em");
	
	
	//*******Tools/Heading
	public static By headingHeading = By.xpath("//input[@id='theHiveHeading']");
	public static By headingHeadingtype = By.xpath("//select[@id='headingSize']"); // Select Heading Level 2.. drop down
	public static By valeleHeading = By.xpath("//div[@class='hive-block-heading']/h2");
	
	
	//*******Tools/Divider ...just click on add button
	public static By valeleDivider = By.xpath("//*[@id='content']/div/div/div[1]");
	
	//*******Files
	public static By fileManagerFileSet = By.xpath("//input[@id='s2id_autogen7']");
	public static By fileManagerSearch = By.xpath("//button[@class='btn btn-primary pull-right']");
	
	//*******Tools/Image
	public static By imageSelect = By.xpath("//div[@class='ccm-file-selector-choose-new']");
	public static By image1 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[1]");
	public static By imageAlternativeDesc = By.xpath("//input[@id='altText']");
	public static By imageCaption = By.xpath("//div[@class='redactor-editor']");
	public static By valeleImage = By.xpath("//img[@class='hive-image']"); //verify alt - imageAlternativeDesc
	public static By valeleImageCaption = By.xpath("//figcaption/em/p"); //verify text - imageCaption
	
	//*******Tools/Flexi
	public static By flexiTitle = By.xpath("//input[@id='title']");
	public static By flexiContent = By.xpath("//div[@class='redactor-editor']");
	//public static By flexiContent = By.xpath("//div[@class='redactor-editor']");
	public static By valeleFlexiTitle = By.xpath("//div[@class='hive-block-flexi-content hive-block']/div/h3");
	public static By valeleFlexiContent = By.xpath("//div[@class='hive-block-flexi-content hive-block']/div/div/p");
	
	//*******Tools/Add Tab Start
	public static By tabHeading = By.xpath("//input[@id='heading']");
	public static By valeletab = By.xpath("//a[@role='tab']"); //verifytabHeading
	
	//********Tools/Button
	public static By buttonText = By.xpath("//input[@id='text']");
	public static By buttonURL = By.xpath("//input[@id='link_url']");
	public static By valeleButton = By.xpath("//div[@class='hive-block-button text-left']/a"); //verify text and href
	
	//**********Tools/Navigation
	public static By navigationTitle = By.xpath("//input[@id='title']");
	public static By navigationShowTitle = By.xpath("//input[@id='showTitle']");
	public static By valeleNavigation = By.xpath("div[@class='the-hive-sub-nav panel panel-default']/div/h3"); //verify title
	
	//**********Tools/map
	public static By mapLocation = By.xpath("//input[@id='mapLocation']"); //enter Victoria Australia
	public static By valelemap = By.xpath("//div[@class='hive-block-web-map hive-block']"); //isElementDisplayed

	//**********Tools/image gallery
	public static By imagegalleryImageSelect = By.xpath("//div[@class='ccm-file-selector-choose-new']");
	public static By imagegalleryImage1 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[1]");
	public static By imagegalleryCaption = By.xpath("//div[@class='redactor-editor']");
	public static By valeleimagegalleryBlock = By.xpath("//div[@class='hive-block-image-gallery hive-block']");  //isElementDisplay
	public static By valeleimagegalleryTitle = By.xpath("//div[contains(@class,'hive-block-image-gallery-img')]"); //---attribute data-name=imagegalleryCaption
	
	//**********Tools/image slider
	public static By imagesliderTitle = By.xpath("//input[@name='imageTitle']");
	public static By imagesliderImageSelect = By.xpath("//div[@class='ccm-file-selector-choose-new']");
	public static By imagesliderImage1 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[1]");
	public static By valeleImagesliderBlock = By.xpath("//div[@class='hive-block-image-slider hive-block']");  //isElementDisplay
	public static By valeleImagesliderTitle = By.xpath("//div[contains(@class,'carousel-caption')]/h3"); //---Title
	
	
	//**********Tools/Video
	public static By videoPlayerType = By.xpath("//select[@id='VideoPlayer']"); //---Select YouTube
	public static By videoURL = By.xpath("//input[@id='VideoURL']");  //enter  http://youtu.be/hu3IfIwSjgM
	public static By videoTitle = By.xpath("//input[@id='VideoTitle']");
	public static By valelevideotitle = By.xpath("//div[@class='hive-video-wrapper hive-block']/div/h3");
	public static By valeleVideoFrame = By.xpath("//iframe[contains(@id,'youtubePlayer')]");  //--isElementDisplay
	
	
	//**********Tools/Swipe
	public static By swipeImage1Select = By.xpath("//div[@data-file-selector='first_fID']/div");
	public static By swipeImage1 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[1]");
	public static By swipeImage2Select = By.xpath("//div[@data-file-selector='second_fID']/div");
	public static By swipeImage2 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[2]");
	public static By valeleswipe2020 = By.xpath("//div[@class='twentytwenty-handle']");
	public static By valeleswipeImg1 = By.xpath("//div[@class='twentytwenty-container']/img[1]");
	public static By valeleswipeImg2 = By.xpath("//div[@class='twentytwenty-container']/img[2]");
	
	//**********Form
	//Select - Short Text (Input Text Field)
	public static By formSelectQuesType = By.xpath("//select[@id='inputType']");
	//Add data - type question here. Desc - Give answer here
	public static By formQuestion = By.xpath("//input[@id='question']");
	public static By formQuesDesc = By.xpath("//textarea[@id='description']");
	public static By formAddQuestion = By.xpath("//a[@id='addQuestion']");
	public static By valeleformQuestion = By.xpath("//label[contains(@id,'FieldQuestion')]");
	public static By valeleformQuesDesc = By.xpath("//p[contains(@id,'FieldDescription')]");
	public static By valeleformQuesTextbox = By.xpath("//input[contains(@name,'Question')");
	public static By valeleformSubmitQuestBtn = By.xpath("//button[@class='btn']");
	
	//***********Quick poll
	public static By quickpollQuestion = By.xpath("//input[@id='question']");
	public static By quickpollOption = By.xpath("//input[@name='optionValue']");
	public static By quickpllAddOption = By.xpath("//button[@class='add-option btn btn-default']");
	public static By valeleQuickPollQuestion = By.xpath("//div[@class='hive-block-poll hive-block']/div[2]/h4");  //---Question text
	public static By valeleQuickPollYes = By.xpath("//fieldset[@class='radio-list']/div[1]/div");   //---isElementDisplay
	public static By valeleQuickPollNo = By.xpath("//fieldset[@class='radio-list']/div[2]/div");  //---isElementDisplay
	public static By valeleQuickPollSubmit = By.xpath("//button[@class='btn mod-wide']"); //---isElementDisplay
	
	//***********Conversation
	public static By conversationTitle = By.xpath("//input[@id='callToAction']"); //enter - What is your idea?
	//Add
	public static By valeleconversationTitle = By.xpath("//*[contains(@id,'a')]//div[2]/h3");
	
	//***********Social Map
	public static By socialMapLocation = By.xpath("//input[@id='mapLocation']");  //enter -//input[@id='mapLocation']
	//Add
	public static By valelesocialMap = By.xpath("//div[contains(@class,'social-map')]");
	
	//***********Visioner Input
	public static By visionerInputQuestion = By.xpath("//input[@id='visionQuestion']");  
	public static By visionerInputQuestionDesc = By.xpath("//div[@class='redactor-editor']");
	public static By valelevisionerInputQuestion = By.xpath("//div[@class='vision-form-wrapper']/h3"); //verify text - visionerInputQuestion
	public static By valelevisionerInputQuestionDesc = By.xpath("//div[@class='vision-form-wrapper']/p[2]"); //verify text - visionerInputQuestionDesc
	public static By valelevisionerInputTextArea = By.xpath("//textarea[@class='form-control visionSubmission']"); //verify text Tell us your idea
	
	//***********Visioner Result
	public static By visionerResultIdea = By.xpath("//select[@id='qID']");  //--dropdown - Where should we start?
	public static By visionerResultDisplayVotingYes = By.xpath("//input[@id='displayVoting1']");
	public static By valelevisionerResult = By.xpath("//p[@class='alert mod-alert-info']"); //verify text - No submissions yet.
	
	//******Forum
	public static By forumActiveYes = By.xpath("//input[@id='forumActive1']");
	public static By forumQuestion = By.xpath("//input[@id='forumQuestion']");
	public static By valleleforumQuestion = By.xpath("//div[contains(@id, 'forumQuesWrapper')]/h3/a");
	public static By valeleforumReadnContribute = By.xpath("//a[@class='btn mod-lg pull-right']");  //validate text Read and Contribute
	public static By valeleforumStatus = By.xpath("//table[@class='statsInner']");  //isElementDisplay
	
	//******Document Library
	public static By documentLibFileSelect = By.xpath("//div[@class='ccm-file-selector-choose-new']");
	public static By documentLibFile1 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[1]");
	public static By documentLibDocTitle = By.xpath("//input[@name='docTitle']");
	public static By documentLibGroupHeading = By.xpath("//input[@name='groupHeading']");
	public static By valeleDocImage = By.xpath("//div[@class='hive-block-document-library hive-block']/div[2]/a/div/img"); //---use isElementDisplay
	public static By valeleDocTitle = By.xpath("//div[@class='hive-block-document-library hive-block']/div[2]/a/div[2]/div"); //---Doctitle
	public static By valeleDocGroupHeading = By.xpath("//div[@class='hive-block-document-library hive-block']/div[2]/h4"); //---Docgroupheading
	
	//*********FAQ
	public static By faqQuestion = By.xpath("//input[@name='faqQuestion']");
	public static By faqAnswer = By.xpath("//div[@class='redactor-editor']");
	public static By valeleFAQ = By.xpath("//div[@class='hive-block-faq hive-block']/div[2]/ul/li/a");
	public static By valeleFAQGroupHeading = By.xpath("//div[@class='hive-block-document-faq hive-block']/div[2]/h4"); //---Docgroupheading
	
	//*********Key Dates
	public static By keydateTitle = By.xpath("//input[@name='dateTitle']");
	public static By valeleKeyTitle = By.xpath("//div[@class='hive-block-key-dates hive-block']/div[2]/div/div/p");
	
	
	//*******Links
	public static By linksAddLinks = By.xpath("//button[@title='Add Link']");
	public static By linksTitle = By.xpath("//input[@name='linkTitle']");
	public static By linksURL = By.xpath("//input[@name='linkURL']");
	public static By linksGroupHeading = By.xpath("//input[@name='groupHeading']");
	public static By valelelinkstitle = By.xpath("//div[@class='hive-block-links hive-block']/div/ul/li/a");
	public static By valelelinkgroupheading = By.xpath("//h4[@class='group-heading'");	
	
	//******Timeline
	public static By timelineAddStage = By.xpath("//button[@title='Add Stage']");
	public static By timelineStageTitle = By.xpath("//input[@name='stageTitle']");
	public static By timelineStageStatus = By.xpath("//select[@name='stageStatus']"); //Select Active.......Add twice
	public static By valeleStageTitle = By.xpath("//li[contains(@class, 'timeline-item-collapse')]/div/p");
	public static By valeleTiemline = By.xpath("//div[@class='timeline-item']/p[2]");
	
	//*******Subscription Form
	//#####MailChimp API Key is required#####
	
	//*******Contact Us
	public static By contactUsName = By.xpath("//input[@id='contactus_name']");
	public static By contactUsPhone = By.xpath("//input[@id='contactus_phone']"); //press add button
	public static By valeleContactUsName = By.xpath("//div[@class='contact-details text-left']/div/div[2]");
	public static By valeleContactUsPhone = By.xpath("//div[@class='contact-details text-left']/div[2]/div[2]");
	
	
	//*******News Feed
	public static By newsFeedTitle = By.xpath("//input[@id='title']");
	public static By newsFeedDesc = By.xpath("//textarea[@id='description']"); //press add button
	public static By valeleNewsFeedTitle = By.xpath("//div[contains(@id,'hive-block-news-feed')]/div/h3");
	public static By valeleNewsFeedDesc = By.xpath("//div[@class='hive-block-description']");
	
	//******Feature Grid
	public static By addFeatureButton = By.xpath("//button[@title='Add Feature']");
	public static By featureImageSelect = By.xpath("//div[@class='ccm-file-selector-choose-new']");
	public static By featureimage1 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[1]");
	public static By featureTitle = By.xpath("//input[@id='itemTitle']");  //PRess Save button twice
	public static By valeleFeatureTitle = By.xpath("//div/h3[@class='card-heading p-name']"); //verify Title
	
	//*******Accordion
	public static By accordionQuestion = By.xpath("//input[@name='accordionQuestion']");
	public static By accordionAnswer = By.xpath("//div[@class='redactor-editor']");  //Press add button and again click on add
	public static By valeleAccodion = By.xpath("//div[@class='panel-title']/h3");   //verify accordionQuestion
	
	//block area on page to add tools/...
	//public static By emptyMainArea = By.xpath("//div[text()='Empty Main Area']");
	//public static By emptySliderArea = By.xpath("//div[text()='Empty Sidebar Area']");
	public static By emptyMainArea = By.xpath("//main/div/div[1]");
	public static By emptySliderArea = By.xpath("//main/div/div[2]");
	
	//*******Create project********
	//create new project page 1
	public static By ProjectName = By.xpath("//input[@id='projectName']");
	public static By ProjectURL = By.xpath("//input[@id='projectUrl']");
	public static By ProjectDesc = By.xpath("//textarea[@id='projectDescription']");
	public static By nextButton = By.xpath("//a[text()='Next']");
	//public static By toolsTools = By.xpath("//input[@id='"+projectTemplate1+"']");
	public static By ProjectTemplate = By.xpath("//input[@id='projectTemplate1']");
	public static By ProjectDept = By.xpath("//select[@id='akID[40][atSelectOptionValue]']");
	public static By ProjectType = By.xpath("//select[@id='akID[21][atSelectOptionValue]']");
	public static By ProjectStatus = By.xpath("//select[@id='akID[20][atSelectOptionValue]']");
	
	public static By ProjectImageSelect = By.xpath("//div[@class='ccm-file-selector-choose-new']");
	public static By projectImage1 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[1]");
	//public static By toolsTools = By.xpath("//label/input[@value='"+colour+"']");
	public static By Projectcolor = By.xpath("//label/input[@value='1']");
	public static By projectSelectLogo = By.xpath("//div[contains(@data-file-selector, 'ccm-file-akID-35')]/div[@class='ccm-file-selector-choose-new']");
	public static By projectLogo1 = By.xpath("//table[@class='ccm-search-results-table']/tbody/tr[1]");
	public static By projectCategoryAllCategory = By.xpath("//div[6]/div/fieldset/div[1]/ul/li[1]/span/span[2]");
	public static By projectCategoryaboriginalRep = By.xpath("//div[6]/div/fieldset/div[1]/ul/li[2]/span/span[2]");
	public static By projectLocationVictoria = By.xpath("//div[7]/div/fieldset/div[1]/ul/li[1]/span/span[2]");
	public static By projectLocationMelbourne = By.xpath("//div[7]/div/fieldset/div[1]/ul/li[2]/span/span[2]");
	public static By projectGroupAnotherPartnership = By.xpath("//input[@value='35']");
	public static By projectGroupFamilyViolence = By.xpath("//input[@value='37']");
	public static By projectGroupNewGroup = By.xpath("//input[@value='39']");
	public static By projectGroupRegional = By.xpath("//input[@value='33']");
	public static By projectUserName = By.xpath("//input[@id='akID[34][value]_auto']");
	public static By projectUserNameSel1 = By.xpath("//li[@class='ui-menu-item']");
	
	public static By projectRoles = By.xpath("//table/tbody/tr/td/select");
	
	public static By projectRoleUser1 = By.xpath("//tr[2]/td[2]/select[@class='form-control']");
	public static By toolsRoleUser2 = By.xpath("//tr[3]/td[2]/select[@class='form-control']");
	public static By launchProjectbtn = By.xpath("//a[contains(text(),' Launch Project')]");
	
	public static By popupTxtMessage = By.xpath("//h3[text()='Page Draft.']");
	public static By popupSubmitforApproval = By.xpath("//a[text()='Submit for Approval']");
	public static By popupApprovePage = By.xpath("//button[@name='action_approve']");
	public static By popupHide = By.xpath("//a[text()='Hide']");
	public static By popupCancelPage = By.xpath("//button[@name='action_cancel']");
	public static By popupCompareVersion = By.xpath("//a[@dialog-title='Compare Versions']");	
	
	public static By valeleProjectDept = By.xpath("//h2[@class = 'department-name']");
	public static By valeleProjectName = By.xpath("//h2[@class = 'banner-content-heading']");
	public static By valeleProjectDesc = By.xpath("//h2[@class = 'banner-content-desc']");
	
	public static By valeleBreadcrumbHome = By.xpath("//nav[@class='breadcrumb']/ol/li[1]/a");
	public static By valeleBreadcrumbPage = By.xpath("//nav[@class='breadcrumb']/ol/li[2]/a");
	public static By valeleBreadcrumbNews = By.xpath("//nav[@class='breadcrumb']/ol/li[3]");
		
	public static By draftPageEnMn = By.xpath("//a[text()='For automation only draft page for en manager']");
	public static By draftPageCnMn = By.xpath("//a[text()='For automation only draft page for consultation manager']");
	public static By draftPagePjAu = By.xpath("//a[text()='For automation only draft page for project author']");
	
	//public static By menu4 = By.xpath("");
	
	public static By dashboardProjectProject = By.xpath("//a[contains(text(), 'New Project for Test Execution')]");
	
	//******* Create new sub-page*******
	public static By subpagePageName = By.xpath("//input[@id='ptComposer[36][name]']");
	public static By subpagePageDesc = By.xpath("//textarea[@id='ptComposer[37][description]']");
	
	
	public static By dashboardProjectKeyword = By.xpath("//input[@name='keywords']");
	public static By dashboardProjectSearch = By.xpath("//button[@type='submit']");
}
