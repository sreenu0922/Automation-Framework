package accelerators;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import support.ConfiguratorSupport;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
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
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import support.Reporter;

public class TestEngine extends HtmlReportSupport {

    public static int stepNum = 0;
    public static int PassNum = 0;
    public static int FailNum = 0;
    public static int passCounter = 0;
    public static int failCounter = 0;
    public static String method = "";
    public static String testName = "";
    public static ITestContext itc;
    public static String groupNames = null;

    public static boolean flag = false;
    //public static Logger log = Logger.getLogger("TestEngine.class.getName()");

    public static Map<String, String> testDescription = new LinkedHashMap<String, String>();
    public static Map<String, String> testResults = new LinkedHashMap<String, String>();
    public static String timeStamp = ReportStampSupport.timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
    public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");


    //DeviceName is common for IOS and Android
    public static String DeviceName = configProps.getProperty("DeviceName");
    public static String browserType = configProps.getProperty("browserType");
    public static String url = configProps.getProperty("URL");

    public static String iOSplatformName = configProps.getProperty("iOSplatformName");
    public static String iOSplatformVersion = configProps.getProperty("iOSplatformVersion");
    public static String UDID = configProps.getProperty("UDID");
    public static String iOSappPath = configProps.getProperty("iOSappPath");
    public static String iOSDeviceName = configProps.getProperty("DeviceName");
    public static String iOSBundleId = configProps.getProperty("BundleID");


    public static String AndroidplatformName = configProps.getProperty("AndroidplatformName");
    public static String AndroidplatformVersion = configProps.getProperty("AndroidplatformVersion");
    public static String appPackage = configProps.getProperty("appPackage");
    public static String appActivity = configProps.getProperty("appActivity");
    public static String apkPath = configProps.getProperty("apkPath");


    public static AppiumDriver AndroidDriver = null;
    public static AppiumDriver Iosdriver = null;
    public static RemoteWebDriver driver = null;


    @BeforeSuite
    public static void setupSuite(ITestContext ctx) throws Throwable {
        System.out.println("In Before sutie");
        itc = ctx;
        groupNames = ctx.getCurrentXmlTest().getIncludedGroups().toString();
        System.out.println("+++++"+groupNames);
        ReportStampSupport.calculateSuiteStartTime();

        if (browserType.equalsIgnoreCase("Android")) {

            String appPath = System.getProperty("user.dir")+apkPath;
            DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
            capabilitiesForAppium.setCapability("deviceName", DeviceName);
            capabilitiesForAppium.setCapability("platformName", AndroidplatformName);
            capabilitiesForAppium.setCapability("platformVersion", AndroidplatformVersion);
            capabilitiesForAppium.setCapability("appPackage", appPackage);
            capabilitiesForAppium.setCapability("appActivity", appActivity);
            capabilitiesForAppium.setCapability("app", appPath);

            AndroidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesForAppium);
            driver = (AndroidDriver);
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        }
         /*
        Author Sravan Reddy
        */
        else if (browserType.equalsIgnoreCase("iOS")) {
            try {
                //Sravan add for iOS
                System.out.println("In iphone block");

                String appPath = configProps.getProperty("iOSappPath");
                String ipaPath = configProps.getProperty("iOSipaPath");
                String temp = System.getProperty("user.dir") + ipaPath;
                String temp2 = System.getProperty("user.dir") + appPath;
                File ipa = new File(temp);
                File app = new File(temp2);

                DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
                capabilitiesForAppium.setCapability("deviceName", iOSDeviceName);
                capabilitiesForAppium.setCapability("platformName", "iOS");
                capabilitiesForAppium.setCapability("platformVersion", iOSplatformVersion);
                capabilitiesForAppium.setCapability("automationName", "XCUITest");

                capabilitiesForAppium.setCapability("newCommandTimeout", "8000");
                capabilitiesForAppium.setCapability("takesScreenshot", true);
                capabilitiesForAppium.setCapability("autoWebviewTimeout", "8000");
                capabilitiesForAppium.setCapability("locationServicesAuthorized", true);
                capabilitiesForAppium.setCapability("waitForAppScript", "target.elements().length > 0; $.delay(30000); $.acceptAlert();");

                if ((DeviceName.contains("Simulator")) || ((UDID.length() == 0))) {
                    System.out.println("++++ Using Simulator ++++");
                    System.out.println("app Path " + app.getCanonicalPath());
                    capabilitiesForAppium.setCapability("app", app.getCanonicalPath());

                } else {
                    System.out.println("+++++ Using Real Device +++++");
                    capabilitiesForAppium.setCapability("udid", UDID);
                    System.out.println("ipa Path " + ipa.getCanonicalPath());
                    capabilitiesForAppium.setCapability("app", ipa.getCanonicalPath());
                }
                Iosdriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesForAppium);
                driver = Iosdriver;
                // Iosdriver.resetApp();
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed launching app......");
            }
        } else if (browserType.equalsIgnoreCase("AndroidChrome")) {

			try {
				DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
				capabilitiesForAppium.setCapability("deviceName", DeviceName);
				capabilitiesForAppium.setCapability(CapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
				capabilitiesForAppium.setCapability("platformVersion", AndroidplatformVersion);
				//capabilitiesForAppium.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
				capabilitiesForAppium.setCapability("appPackage", "com.android.chrome");
				capabilitiesForAppium.setCapability("appActivity", "com.google.android.apps.chrome.Main");
				AndroidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
						capabilitiesForAppium);
				driver = (AndroidDriver);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
        /*
        Author Sravan Reddy
        */
        else if (browserType.equalsIgnoreCase("iOSSafari")) {
            try {
                //Sravan add for iOS
                System.out.println("In iphone browser block");
                DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
                capabilitiesForAppium.setCapability("deviceName", iOSDeviceName);
                capabilitiesForAppium.setCapability("platformName", "iOS");
                capabilitiesForAppium.setCapability("platformVersion", iOSplatformVersion);
                capabilitiesForAppium.setCapability("automationName", "XCUITest");
                capabilitiesForAppium.setCapability("browserName", "Safari");
                capabilitiesForAppium.setCapability("bundleid", iOSBundleId);

                capabilitiesForAppium.setCapability("newCommandTimeout", "8000");
                capabilitiesForAppium.setCapability("takesScreenshot", true);
                capabilitiesForAppium.setCapability("autoWebviewTimeout", "8000");
                capabilitiesForAppium.setCapability("locationServicesAuthorized", true);
                capabilitiesForAppium.setCapability("waitForAppScript", "target.elements().length > 0; $.delay(30000); $.acceptAlert();");


                Iosdriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesForAppium);
                driver = Iosdriver;
                // Iosdriver.resetApp();
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed launching app......");
            }
        }
        try {
            Reporter.reportCreater();
            HtmlReportSupport.currentSuit = ctx.getCurrentXmlTest().getSuite()
                    .getName();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setBrowerDriver(Method method) throws Throwable {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
        String formattedDate = sdf.format(date);
        ReportStampSupport.calculateTestCaseStartTime();

        if (browserType == "WinChrome") {
            //Pravalika
        }else if (browserType == "Edge") {
            //Sangeetha
        }else if(browserType=="WinFirefox") {
			//@author by Ranga

			System.setProperty("webdriver.gecko.driver", filePath());
			WebDriver driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		}
		else if(browserType=="Edge") {
			//@author by sangeethanulu
			System.setProperty("webdriver.edge.driver", filePath());
			WebDriver driver = new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();

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
		else if ((browserType.equalsIgnoreCase("AndroidChrome")) | (browserType.equalsIgnoreCase("iOSSafari"))) {
            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            driver.get(url);
        }
        HtmlReportSupport.tc_name = method.getName().toString() + "- "
                + formattedDate;
        String[] ts_Name = this.getClass().getName().toString().split("\\.");
        /*HtmlReportSupport.packageName = ts_Name[0] + "." + ts_Name[1] + "."
                + ts_Name[2];*/
        HtmlReportSupport.testHeader(HtmlReportSupport.tc_name, browserType);
        stepNum = 0;
        PassNum = 0;
        FailNum = 0;
        testName = method.getName();
        //logger.info("Current Test : "+testName);
	}

	public static String filePath() {
		String strDirectoy = "";
		if (browserType.equalsIgnoreCase("ie")) {
			strDirectoy = "IE" + File.separator + "IE";
		} else if (browserType.equalsIgnoreCase("firefox")) {
			strDirectoy = "Firefox" + File.separator + "Firefox";
		} else if (browserType.equalsIgnoreCase("chrome")) {
			strDirectoy = "Chrome" + File.separator + "Chrome";
		} else if (browserType.equalsIgnoreCase("edge")) {
			strDirectoy = "Edge" + File.separator + "Edge";
		} else if (browserType.equalsIgnoreCase("Android")) {
			strDirectoy = "Android" + File.separator + "Android";
		} else if (browserType.equalsIgnoreCase("iphone")) {
			strDirectoy = "iPhone" + File.separator + "iPhone";
		} else if (browserType.equalsIgnoreCase("AndroidChrome")) {
			strDirectoy = "AndroidChrome" + File.separator + "AndroidChrome";
		} else if (browserType.equalsIgnoreCase("iPhoneSafari")) {
			strDirectoy = "iPhoneSafari" + File.separator + "iPhoneSafari";
		}

		if (strDirectoy != "") {
			new File(configProps.getProperty("screenShotPath") + strDirectoy + "_" + timeStamp).mkdirs();
		}

		File results = new File(configProps.getProperty("screenShotPath") + strDirectoy + "_" + timeStamp
				+ File.separator + "Screenshots");
		if (!results.exists()) {
			results.mkdir();
			HtmlReportSupport.copyLogos();
		}

		return configProps.getProperty("screenShotPath") + strDirectoy + "_" + timeStamp + File.separator;

	}

	@AfterMethod(alwaysRun = true)
	public static void tearDownMethod() throws Throwable {
		try {
			ReportStampSupport.calculateTestCaseExecutionTime();
			closeDetailedReport();
			if (FailNum != 0) {
				failCounter = failCounter + 1;
				testResults.put(HtmlReportSupport.tc_name, "FAIL");
			} else {
				testResults.put(HtmlReportSupport.tc_name, "PASS");
				passCounter = passCounter + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((browserType.toLowerCase().contains("iphone"))) {

				// Iosdriver.closeApp();
			} else if (browserType.toLowerCase().contains("android")) {
				// AndroidDriver2.closeApp();

			} else {
				driver.quit();
				/* driver.close(); */
			}

		}
	}

    @AfterSuite(alwaysRun = true)
    public void tearDown(ITestContext ctx) throws Throwable {
        try{
            ReportStampSupport.calculateSuiteExecutionTime();

            HtmlReportSupport.createHtmlSummaryReport(browserType, url);
            closeSummaryReport();
            if (browserType.equalsIgnoreCase("iphone")) {
                //Iosdriver.removeApp(bundleID);
            }
            /*driver.quit();*/
        }catch(Exception e){
            e.printStackTrace();
        } /*finally {
			if (browser.contains("Android")) {
				RedPlanetUtils.stopAppium();
			} else if (browser.contains("iPhone")) {
				RedPlanetUtils.stopAppiumForIos();
			}
		}*/
    }


}
