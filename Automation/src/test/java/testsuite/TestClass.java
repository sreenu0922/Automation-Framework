package testsuite;

import org.testng.annotations.Test;

public class TestClass extends HelperClass{

@Test
public void test() throws Throwable {
 //Written by Vinay Gajula

 //Selecting the Chaild
 SelectChild();

 //Selecting the reasons for Care
 CareReason("My regular care is unavailable.");
 //CareReason("My work schedule has changed.");
 //CareReason("My child is not feeling well.");
 //CareReason("Sick employee or spouse.");
 //CareReason("At home parent is out or unavailable.");
 //CareReason("Other reasons.");

 //If you need to click No button After Selecting the #My child is not feeling well then Felt1 should run
 //Felt("Fever under 100°F");
 //Felt("Stuffy/runny nose");
 //Felt("Cough");
 //Felt("Sore throat");

 //If you need to click Yes button After Selecting the #My child is not feeling well then Felt1 should run
 //Felt1();

 //Select in center or in home
 CareType("In-center");
 //CareType("In-home");

}

}
