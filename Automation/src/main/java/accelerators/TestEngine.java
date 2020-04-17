package accelerators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import support.ConfiguratorSupport;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import accelerators.TestEngine;

import support.HtmlReportSupport;
import support.ReportStampSupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class TestEngine extends HtmlReportSupport{
	
	public static int stepNum = 0;
	public static int PassNum =0;
	public static int FailNum =0;
	public static int passCounter =0;
	public static int failCounter =0;
	
	public static boolean flag = false;
	
	public static Map<String, String> testDescription = new LinkedHashMap<String, String>();
	
	
	public static Map<String, String> testResults = new LinkedHashMap<String, String>();
	
	
	public static String timeStamp = ReportStampSupport.timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
	
	public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");
	
	public static String url = configProps.getProperty("URL");
	
	//DeviceName is common for IOS and Android 
	public static String DeviceName = configProps.getProperty("DeviceName");
	

	public static String browserType = configProps.getProperty("browserType");
	public static String iOSplatformName = configProps.getProperty("iOSplatformName");
	public static String iOSplatformVersion = configProps.getProperty("iOSplatformVersion");
	public static String UDID = configProps.getProperty("UDID");
	public static String iOSappPath = configProps.getProperty("iOSappPath");
	
	
	
	public static String AndroidplatformName = configProps.getProperty("AndroidplatformName");
	public static String AndroidplatformVersion = configProps.getProperty("AndroidplatformVersion");
	public static String appPackage = configProps.getProperty("appPackage");
	public static String appActivity = configProps.getProperty("appActivity");
	public static String apkPath = configProps.getProperty("apkPath");
	
	
	public static AppiumDriver AndroidDriver = null;
	public static AppiumDriver Iosdriver = null;
	public static WebDriver driver;

	@BeforeSuite
	public static void setupSuite() throws Throwable {
		
		if(browserType.equalsIgnoreCase("Android")) {
			
			DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
			capabilitiesForAppium.setCapability("deviceName",DeviceName);
			capabilitiesForAppium.setCapability("platformName","AndroidplatformName");
			capabilitiesForAppium.setCapability("platformVersion",AndroidplatformVersion);
			capabilitiesForAppium.setCapability("appPackage", appPackage);
			capabilitiesForAppium.setCapability("appActivity", appActivity);
			capabilitiesForAppium.setCapability("app",apkPath);
			
			AndroidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilitiesForAppium);
			driver = (AndroidDriver);
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);


		}
		else if(browserType.equalsIgnoreCase("iOS")) {
			//Sravan add for iOS
			
		}
		
		else if(browserType.equalsIgnoreCase("AndroidChrome")) {
			//Jagadish add for AndroidChrome
			
		}
		
		else if(browserType.equalsIgnoreCase("iOSSafari")) {
			//Sravan
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void setBrowerDriver() throws Throwable {
		
		if(browserType.equalsIgnoreCase("WinChrome")) {
			//Pravalika
		}
		else if(browserType.equalsIgnoreCase("WinFirefox")) {
			//Ranga 
		}
		else if(browserType.equalsIgnoreCase("Edge")) {
			//Sangeetha
		}
		else if(browserType.equalsIgnoreCase("safari")){
			//@author: Archana Dasari
			//enable the 'Allow Remote Automation' option in Safari's Develop menu to control Safari via WebDriver.
			driver  = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.get(url);
		}
		else if(browserType.equalsIgnoreCase("macChrome")) {
			//@author: Archana Dasari
			String driverPath = configProps.getProperty("macChromeDriverPath");
			String browserPath = System.getProperty("user.dir")+driverPath;
			System.setProperty("webdriver.chrome.driver", browserPath);
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.setAcceptInsecureCerts(true);
			driver = (new ChromeDriver(chromeOptions));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		}
		else if(browserType.equalsIgnoreCase("macFirefox")){
			//@author: Archana Dasari
			String driverPath = configProps.getProperty("macFirefoxDriverPath");
			String browserPath = System.getProperty("user.dir")+driverPath;
			System.setProperty("webdriver.gecko.driver", browserPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		}
	}

	public static String filePath() {
		String strDirectoy = "";		
		if (browserType.equalsIgnoreCase("ie")) {
			strDirectoy = "IE"+File.separator+"IE";
		} else if (browserType.equalsIgnoreCase("firefox")) {
			strDirectoy = "Firefox"+File.separator+"Firefox";
		} else if(browserType.equalsIgnoreCase("chrome")){
			strDirectoy = "Chrome"+File.separator+"Chrome";
		}else if(browserType.equalsIgnoreCase("edge")){
			strDirectoy = "Edge"+File.separator+"Edge";
		}else if(browserType.equalsIgnoreCase("Android")){
			strDirectoy = "Android"+File.separator+"Android";
		}else if(browserType.equalsIgnoreCase("iphone")){
			strDirectoy = "iPhone"+File.separator+"iPhone";
		}else if(browserType.equalsIgnoreCase("AndroidChrome")){
			strDirectoy = "AndroidChrome"+File.separator+"AndroidChrome";
		}else if(browserType.equalsIgnoreCase("iPhoneSafari")){
			strDirectoy = "iPhoneSafari"+File.separator+"iPhoneSafari";
		}

	if (strDirectoy != "") {
		new File(configProps.getProperty("screenShotPath") + strDirectoy
				+ "_" + timeStamp).mkdirs();
	}

	File results = new File(configProps.getProperty("screenShotPath") + strDirectoy
		+ "_" + timeStamp+File.separator+"Screenshots");
	if(!results.exists())
	{
		results.mkdir();
		HtmlReportSupport.copyLogos();
	}

	return configProps.getProperty("screenShotPath") + strDirectoy + "_"
			+ timeStamp + File.separator;

}
	
	
	@AfterMethod(alwaysRun = true)
	public static void tearDownMethod() throws Throwable
	{
		try{
		ReportStampSupport.calculateTestCaseExecutionTime();
		closeDetailedReport();
		if(FailNum!=0)
		{
			failCounter=failCounter+1;
			testResults.put(HtmlReportSupport.tc_name, "FAIL");
		}
		else
		{
			testResults.put(HtmlReportSupport.tc_name, "PASS");
			passCounter=passCounter+1;
		}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			if ((browserType.toLowerCase().contains("iphone"))) {
				//Iosdriver.closeApp();
			}else if(browserType.toLowerCase().contains("android")){ 
				//AndroidDriver2.closeApp();
				
			}else{
				//driver.quit();
				driver.close();
			}
		}
	}

}
