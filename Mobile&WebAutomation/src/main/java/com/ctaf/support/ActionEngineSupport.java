package com.ctaf.support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class ActionEngineSupport extends AbstractWebDriverEventListener {

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		WebElement elem = driver.findElement(by);
		// draw a border around the found element
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.border='2px solid green'", elem);
			// ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",
			// elem, "color: yellow; border: 2px solid yellow;");
		}
	}
}
