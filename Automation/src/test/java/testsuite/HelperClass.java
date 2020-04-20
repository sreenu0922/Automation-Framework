package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HelperClass extends PageLocator {
//Written by Vinay Gajula
    public void SelectChild() throws Throwable {
        click(SelectChild, "Selecting the Child");
        click(SelectDone, "Clicking the Done Button");
    }

    public void CareReason() throws Throwable {
        List<WebElement> links = LocatorStrategy(driver.findElementByXPath("(//android.view.ViewGroup//android.widget.ImageView)"));
      //List<WebElement> links =driver.findElements(By.xpath("(//android.view.ViewGroup//android.widget.ImageView)"));
      int randmNu=randomNumber(0,links.size());
      By SelectReason= By.id(SelectReason1+"["+randmNu+"]");
      System.out.println("Reason Selected "+SelectReason);
          }

    public void CareType() throws Throwable {
        List<WebElement> links = LocatorStrategy(driver.findElementByXPath("(//android.widget.FrameLayout//android.widget.RelativeLayout/android.widget.LinearLayout)"));
        //List<WebElement> links =driver.findElements(By.xpath("(//android.widget.FrameLayout//android.widget.RelativeLayout/android.widget.LinearLayout)"));
        int randmNu=randomNumber(0,links.size());
        By TypeofCare= By.id(TypeofCare1+"["+randmNu+"]");
        System.out.println("Selected TypeofCare"+TypeofCare);

         }
}
