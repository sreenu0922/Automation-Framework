package testsuite;

import org.openqa.selenium.By;

public class HelperClass extends PageLocator {





    //Sravan
    public void iOSApp() throws Throwable {
        click(iosButtons, "iosButtons");
        click(iosCatelog, "iosCatelog");
        click(iosSearch, "iosSearch");
    }

    public void iOSWeb() throws Throwable {
        String title = driver.getTitle();
        System.out.println("4242343242342343334434334343:"+title);
        driver.findElement(By.id("m_login_email")).sendKeys("12345678");
        driver.findElement(By.id("m_login_password")).sendKeys("12345678");

    }
}
