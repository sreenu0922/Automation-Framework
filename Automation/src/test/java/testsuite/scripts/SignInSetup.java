package testsuite.scripts;

import org.testng.annotations.Test;
import testsuite.workflows.SignInhelper;


public class SignInSetup extends SignInhelper {

    @Test
    public void validateSignInAmazon() throws Throwable {

        String password = "@lt12345";
        String email = "8897741110";
        amazonSignIn(url, email, password);

    }
}
