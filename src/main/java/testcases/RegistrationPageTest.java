package main.java.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.RegistrationPage;
import pages.PagesFactory;

public class RegistrationPageTest extends BaseTest {

    RegistrationPage registrationPage;

    @Test
    public void validateRegisterAsAgencyFunctionality() {

        try {

            initializeTest("Validate Registration Functionality", "This test will verify that user is able to register to the application with valid credential", "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            System.out.println("\nStarting register into the site.\\n");
            boolean loginResult = registrationPage.registerAsAgency();
            Assert.assertTrue(loginResult, "Registration failed");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
