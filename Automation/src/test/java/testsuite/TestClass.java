package testsuite;

import org.testng.annotations.Test;

public class TestClass extends HelperClass{


    //@author: Archana Dasari
    @Test
    public void validateSignInAmazon() throws Throwable {

        String password = "@lt12345";
        String email = "8897741110";
        amazonSignIn(url, email, password);
    }
}
