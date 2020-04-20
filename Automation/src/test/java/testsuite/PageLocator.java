package testsuite;

import accelerators.ActionEngine;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageLocator extends ActionEngine {
    //Written by Vinay Gajula
    public static By SelectChild=By.id("child_name");
    public static By SelectDone=By.id("next_cta");
    public static By SelectReason1=By.xpath("//*[contains(@text,'My regular care is unavailable.')]");
    public static By SelectReason2=By.xpath("//*[contains(@text,'My work schedule has changed.')]");
    public static By SelectReason3=By.xpath("//*[contains(@text,'My child is not feeling well.')]");
    public static By SelectReason4=By.xpath("//*[contains(@text,'Sick employee or spouse.')]");
    public static By SelectReason5=By.xpath("//*[contains(@text,'At home parent is out or unavailable.')]");
    public static By SelectReason6=By.xpath("//*[contains(@text,'Other reasons.')]");
    public static By TypeofCare1=By.id("in_center_layout");
    public static By TypeofCare2=By.id("in_home_text");




    }


