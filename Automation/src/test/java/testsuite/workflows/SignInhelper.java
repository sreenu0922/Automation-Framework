package testsuite.workflows;

import accelerators.ActionEngine;

import static testsuite.PageLocator.*;


public class SignInhelper extends ActionEngine {

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
