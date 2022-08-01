package main.java.testcases;
import main.java.testdataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import pages.PagesFactory;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 0)
    public void testLoginPageLoaded() {
        try {
            initializeTest("test login page loaded", "Login page loaded",
                    "Integration Testing");

            System.out.println("Checking if login page loaded");

            loginPage = PagesFactory.getLoginPage();
            boolean result = loginPage.checkLoginPageLoaded();
            Assert.assertTrue(result, "Login page not loaded");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

    @Test(priority = 1, dependsOnMethods = "testLoginPageLoaded")
    public void validateUserNotAbleToSubmitAnEmptyLoginForm() {
        try {
            initializeTest(
                    "test login page loaded",
                    "This test verifies that user is not able to submit an empty login form",
                    "Integration Testing");

            loginPage = PagesFactory.getLoginPage();
            boolean result = loginPage.checkEmptyLoginFormSubmit();
            Assert.assertTrue(result, "Failed to submit an empty login form");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }
    }

    @Test(priority = 2, dependsOnMethods = "testLoginPageLoaded")
    public void validateUserNotAbleToLoginWithOutEnteringAnEmail() {
        try {
            initializeTest(
                    "test login page loaded",
                    "This test verifies that user is not able to login with out entering an email",
                    "Integration Testing");

            loginPage = PagesFactory.getLoginPage();
            boolean result = loginPage.checkLoginWithOutEnteringAnEmail();
            Assert.assertTrue(result, "User is able to login with out entering an email");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }
    }

    @Test(priority = 4, dependsOnMethods = "testLoginPageLoaded")
    public void validateUserNotAbleToLoginWithWrongEmail() {
        try {
            initializeTest(
                    "test login page loaded",
                    "This test verifies that user is not able to login with wrong email",
                    "Integration Testing");

            loginPage = PagesFactory.getLoginPage();
            boolean result = loginPage.checkLoginWithWrongEmail();
            Assert.assertTrue(result, "User is able to login with wrong email");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }
    }


        @Test(dataProvider = "credentials", dataProviderClass = TestDataProvider.class, priority = 5)
        public void validateLoginFunctionality(String email, String password) {

            try {

                initializeTest("Validate Login Functionality", "This test will verify that user" +
                        " is able to login to the application with valid credential", "Integration Testing");

                loginPage = PagesFactory.getLoginPage();

                System.out.println("\nStarting login into the site.\\n");
                boolean loginResult = loginPage.login(email, password);
                Assert.assertTrue(loginResult, "Login failed");

            } catch (Exception ex) {
                System.out.println(ex);

            }
        }

}
