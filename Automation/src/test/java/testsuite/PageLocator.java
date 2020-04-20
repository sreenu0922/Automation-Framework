package testsuite;

import org.openqa.selenium.By;
import accelerators.ActionEngine;

public class PageLocator extends ActionEngine {

	//When do you need care for -Jagadish
		public static By choosedate = By.xpath("//*[contains(@resource-id,'choose_another_date')]");	
		public static  By month(String month) {
			return  By.xpath("//*[@text='"+month+"']");
			}
		public static  By day(String day) {
			return  By.xpath("//*[@text='"+day+"']");
			}
		public static  By year(String year) {
			return  By.xpath("//*[@text='"+year+"']");
			}
		public static By dateOk = By.xpath("//*[contains(@text,'OK')]");
		public static By datecontinue = By.xpath("//*[contains(@text,'Continue')]");
		
		//Select start and end times -Jagadish
		public static  By fromtime(String fromtime) {
			return  By.xpath("//*[@text='"+fromtime+"']");
			}
		public static  By totime(String totime) {
			return  By.xpath("//*[@text='"+totime+"']");
			}
		public static By timenext = By.xpath("//*[contains(@text,'NEXT')]");
		
		//What do you need care for -Jagadish
		public static By existingchild = By.xpath("//*[contains(@resource-id,'child_name')]");
		public static By addanotherchild = By.xpath("//*[contains(@resource-id,'add_child_button')]");
		public static By done = By.xpath("//*[contains(@text,'Done')]");
		public static By boy = By.xpath("//*[contains(@text,'Boy')]");
		public static By girl = By.xpath("//*[contains(@text,'Girl')]");
		public static By childfirstname = By.xpath("//*[contains(@resource-id,'first_name')]");
		public static By childlastname = By.xpath("//*[contains(@resource-id,'last_name')]");
		public static By birthday = By.xpath("//*[contains(@resource-id,'birth_day')]");
}
