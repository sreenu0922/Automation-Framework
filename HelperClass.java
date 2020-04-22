package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass extends PageLocator {
	
	public void NavigationMykids() throws Throwable{
		try{
			waitForElementPresent(OptionSelectMykids,"OptionSelectMykids");
			if (isElementDisplayed(OptionSelectMykids, "OptionSelectMykids")){
				click(OptionSelectMykids, "OptionSelectMykids");
				System.out.println("Clicked on My kids");
			}else{
				System.out.println("Did not click on My kids");
			}
		}	catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
	}


