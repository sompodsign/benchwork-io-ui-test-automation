package main.java.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.RegistrationPage;
import pages.PagesFactory;

public class RegistrationPageTest extends BaseTest {

    RegistrationPage registrationPage;

    @Test
    public void testRegistrationPageLoaded() {
        try {
            initializeTest("testRegistrationPageLoaded", "Registration page loaded", "Integration Testing");

            System.out.println("Checking if registration page loaded");

            registrationPage = PagesFactory.getRegistrationPage();
            boolean result = registrationPage.checkRegistrationPageLoaded();
            Assert.assertTrue(result, "Registration page not loaded");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

    @Test(priority = 0)
    public void validateRegisterAsEnterPriseFunctionality() {

        try {

            initializeTest("Validate Registration Functionality", "This test will verify " +
                    "that user is able to register to the application as enterprise with valid credential",
                    "Integration Testing");

            System.out.println("\nStarting register into the site.\\n");
            registrationPage = PagesFactory.getRegistrationPage();

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

            System.out.println("\nStarting register into the site.\\n");
            registrationPage = PagesFactory.getRegistrationPage();

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

            System.out.println("\nStarting register into the site.\\n");
            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithoutOrganization("agency");
            Assert.assertTrue(result, "No error message shown for organization field");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 3)
    public void validateUserNotAbleToSubmitAnEmptyForm() {
        try {
            initializeTest("Validate Registration Functionality with empty form", "This" +
                            " test will verify that user is not able to submit an empty form",
                    "Integration Testing");

            boolean result = registrationPage.checkEmptyFormSubmit();
            Assert.assertTrue(result, "No error message shown for empty form");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 4)
    public void validateUserNotAbleToSubmitWithoutOrganizationTypeSelected() {
        try {
            initializeTest("Validate Registration Functionality without org type selected", "This" +
                            " test will verify that user is not able to submit without organization type selected",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithoutOrganizationType();
            Assert.assertTrue(result, "No error message shown for organization type field");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 5)
    public void validateUserNotAbleToSubmitFormWithoutFirstName(){
        try {
            initializeTest("Validate Registration Functionality without first name", "This" +
                            " test will verify that user is not able to submit without first name",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithoutFirstName();
            Assert.assertTrue(result, "No error message shown for first name field");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 6)
    public void validateUserNotAbleToSubmitFormWithoutLastName(){
        try {
            initializeTest("Validate Registration Functionality without last name", "This" +
                            " test will verify that user is not able to submit without last name",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithoutLastName();
            Assert.assertTrue(result, "No error message shown for last name field");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 7)
    public void validateUserNotAbleToSubmitFormWithoutEmail() {
        try {
            initializeTest("Validate Registration Functionality without email", "This" +
                            " test will verify that user is not able to submit without email",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithoutEmail();
            Assert.assertTrue(result, "No error message shown for email field");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 8)
    public void validateUserNotAbleToSubmitFormWithoutPassword() {
        try {
            initializeTest("Validate Registration Functionality without password", "This" +
                            " test will verify that user is not able to submit without password",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithoutPassword();
            Assert.assertTrue(result, "No error message shown for password field");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 9)
    public void validateUserNotAbleToSubmitFormWithoutConfirmPassword() {
        try {
            initializeTest("Validate Registration Functionality without confirm password", "This" +
                            " test will verify that user is not able to submit without confirm password",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithoutConfirmPassword();
            Assert.assertTrue(result, "No error message shown for confirm password field");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 10)
    public void validateUserNotAbleToRegisterWithInvalidEmail() {
        try {
            initializeTest("Validate Registration Functionality with invalid email", "This" +
                            " test will verify that user is not able to register with invalid email",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithInvalidEmail();
            Assert.assertTrue(result, "No error message shown for invalid email field");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test(priority = 11)
    public void validateUserNotAbleToRegisterWithPasswordMismatch() {
        try {
            initializeTest("Validate Registration Functionality with password mismatch", "This" +
                            " test will verify that user is not able to register with password mismatch",
                    "Integration Testing");

            registrationPage = PagesFactory.getRegistrationPage();

            boolean result = registrationPage.checkFormNotSubmitWithPasswordMismatch();
            Assert.assertTrue(result, "No error message shown for password mismatch field");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
