package testsuite;

public class HelperClass extends PageLocator {
//Written by Vinay Gajula
    public void Care() throws Throwable {
        click(SelectChild, "Selecting the Child");
        Thread.sleep(2000);
        click(SelectDone, "Clicking the Done Button");
        Thread.sleep(2000);
        click(SelectReason, "Reason Selected");
        Thread.sleep(2000);
        click(TypeofCare, "Selecting type of care");
    }
}
