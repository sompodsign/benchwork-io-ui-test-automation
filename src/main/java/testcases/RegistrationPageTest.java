package main.java.testcases;
import helper.DriverActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.RegistrationPage;
import pages.PagesFactory;

public class RegistrationPageTest extends BaseTest {

    RegistrationPage registrationPage;

    @Test(priority = 0)
    public void validateRegisterAsEnterPriseFunctionality() {

        try {

            initializeTest("Validate Registration Functionality", "This test will verify " +
                    "that user is able to register to the application as enterprise with valid credential",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            System.out.println("\nStarting register into the site.\\n");
            boolean loginResult = registrationPage.registerAsAgency("enterprise");
            Assert.assertTrue(loginResult, "Registration failed");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Test(priority = 1)
    public void validateRegisterAsAgencyFunctionality() {

        try {

            initializeTest("Validate Registration Functionality", "This test will verify" +
                    " that user is able to register to the application with valid credential",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            System.out.println("\nStarting register into the site.\\n");

            boolean loginResult = registrationPage.registerAsAgency("agency");
            Assert.assertTrue(loginResult, "Registration failed");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 2)
    public void validateUserNotAbleToSubmitRegistrationFormWithOutOrganizationName() {

        try {

            initializeTest("Validate Registration Functionality without org name", "This" +
                            " test will verify" +
                            " that user is not able to register without organization name and " +
                            "shows an error message",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            System.out.println("\nStarting register into the site.\\n");

            boolean result = registrationPage.checkFormNotSubmitWithoutOrganization("agency");
            Assert.assertTrue(result, "No error message shown for organization field");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
