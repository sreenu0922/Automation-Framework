package testsuite;

public class HelperClass extends PageLocator {

	
	//Author Sreeranga
	// Navigate to use my backup days
	public void navigatetousemybackupdays() throws Throwable {
		click(BackUpDays,"Backupdays");
		
	}
	
	// NAvigate to Book Now Button
	public void navigatetoBookNow() throws Throwable {

		click(BookNow , "BookNowButton");

	}

}
