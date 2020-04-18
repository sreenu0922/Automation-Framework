package testsuite;

import org.openqa.selenium.By;

public class HelperClass extends PageLocator {

	//@author: archana dasari
	public void amazonSignIn(String url, String username, String pswd) throws Throwable {
		waitForElementPresent(helloSignIn, "helloSignIn");
		click(helloSignIn, "helloSignIn");
		waitForElementPresent(email, "email");
		type(email, username, "Email");
		waitForElementPresent(continueBtn, "Continue button");
		click(continueBtn, "Continue button");
		waitForElementPresent(password, "Pwd");
		type(password, pswd, "Pwd");
		waitForElementPresent(logIn, "logIn button");
		click(logIn, "logIn button");
	}
}
