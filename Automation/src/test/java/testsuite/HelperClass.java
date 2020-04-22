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

    public void CareReason(String selectReason) throws Throwable {
        click(By.xpath(SelectReason.replace("#", selectReason)), "Selecting the Reasons");
    }

    //If we select No_Button we need to use below method
    public void Felt(String symptoms) throws Throwable {
        click(fell, "Selecting No Button");
        click(By.xpath(Symptoms.replace("#", "symptoms")), "Selecting Reasons");
        click(fellnext, "clicking the next button");

    }

    //If we select Yes_Button we need to use below method
    public void Felt1() throws Throwable {
        click(fell1, "Selecting Yes Button");
        click(Returntoben,"Going to return to Benefits Page");

    }
        public void CareType (String typeofCare) throws Throwable {
            click(By.xpath(TypeofCare.replace("#", typeofCare)), "Selecting the care");

        }

    }
