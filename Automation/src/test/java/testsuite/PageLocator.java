package testsuite;

import org.openqa.selenium.By;

import accelerators.ActionEngine;

public class PageLocator extends ActionEngine {









	///////////////////////// Sravan  /////////////////////////
	//Android Mobile
	public static By androidPhone = By.id("etPhoneNumber");
	public static By androidCheck = By.id("cbAgreeTerms");
	public static By androidLogin = By.id("btnLogin");

	//iOS Mobile
	public static By iosButtons = By.id("Buttons");
	public static By iosCatelog = By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']");
	public static By iosSearch = By.id("Search");

	//Android Web
	public static By AndroidWebSearchTextField= By.xpath("//*[contains(@text,'Search for Products, Brands and More')]");

	//iOS Web
	public static By iOSWebSafariGoogle= By.id("m_login_email");
	public static By iOSWebSafariFB= By.id("m_login_email");


}
