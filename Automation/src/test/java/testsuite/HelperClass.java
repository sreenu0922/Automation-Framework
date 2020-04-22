package testsuite;

import org.openqa.selenium.By;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class HelperClass extends PageLocator {
	/*MethodName: scrollTo(String text, int index)
	 * Description: scroll up and down the application until particular text is visible at particular dcroll view index
	 * input parameters: text : which is string Eg - "2020" for finding the year
	 *					index : if there are three scroll view , mentions which scroll view need to be searched
	 *Output parameters: Null
	 *created By : Jagadish
	 *created On : 21-04-2020  
	 */
	public static void scrollTo(String text, int index) {
		((FindsByAndroidUIAutomator<MobileElement>) driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(" + index
						+ ")).scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0))");

	}

	/*MethodName: selectdate(String month, String day, String year)
	 * *Description: Select the date, month and year in datewheel picker by scrolling
	 * input parameters: month : provide the month as displayed in the application Eg; Apr
	 *					day :provide the day as displayed in the application Eg; 20
	 *					year: provide the year as displayed in the application Eg; 2020
	 *Output parameters: Null
	 *created By : Jagadish
	 *created On : 21-04-2020  
	 */
	public static void selectdate(String month, String day, String year) throws Throwable {
		click(choosedate, "choosedate");
		scrollTo(year, 2);
		scrollTo(day, 1);
		scrollTo(month, 0);
		if (isElementDisplayed(boy, "childexist")) {
			click(done, "done");
		} else {
			click(dateOk, "dateOk");
			click(datecontinue, "datecontinue");
		}
	}
	
	/*MethodName: selecttime(String from, String to)
	 * *Description: Select the from and to time in datewheel picker by scrolling
	 * input parameters: from : provide the from date as displayed in the application Eg; 10:00 AM
	 *					to :provide the today as displayed in the application Eg; 06:00 PM
	 *Output parameters: Null
	 *created By : Jagadish
	 *created On : 21-04-2020  
	 */
	public static void selecttime(String from, String to) throws Throwable {
		scrollTo(from, 0);
		scrollTo(to, 1);
		click(timenext, "timenext");
	}
	
	/*MethodName: selectchild()
	 * *Description: Select the child if already existing or create new child 
	 * input parameters: Null
	 *Output parameters: Null
	 *created By : Jagadish
	 *created On : 21-04-2020  
	 */
	public static void selectchild() throws Throwable {
		if (isElementDisplayed(boy, "childexist")) {
			click(boy, "clicked");
			type(childfirstname, "test123", "firstname");
			type(childlastname, "dummy", "lastname");
			click(birthday, "birthday");
			selectdate("2016", "11", "14");
		} else {
			click(existingchild, "existingchild");
			click(done, "done");
		}
	}
}
