package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import accelerators.ActionEngine;

public class PageLocator extends ActionEngine {

	//Pravallika
	// Locators for Select care options page
	public static By CoronaAlert = By.xpath("//*[contains(@text,'Worried about coronavirus? Here's what you need to know >')]");
	public static By NeedforCarepage = By.xpath("//*[contains(@text,'Who do you need care for?')]");
	public static By OptionSelectMykids = By.xpath("//*[contains(@text,'My kids')]");
	public static By OptionSelectMyAdultLovedOnes = By.xpath("//*[contains(@text,'My adult loved ones')]");
	public static By OptionSelectMyPets = By.xpath("//*[contains(@text,'My pets')]");
	public static By OptionSelectMyhome = By.xpath("//*[contains(@text,'My home')]");
	public static By learnMoreAboutCare = By.xpath("//*[contains(@text,'Learn about my Care@Work benefits')]");
	public static By Settings = By.xpath("//*[contains(@id,'profile_settings')]");
	public static By PageHome_Title= By.xpath("//*[contains(@resource-id,'home_bg')]");
}
