package main.java.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ProfilePage;
import pages.PagesFactory;

public class ProfilePageTest extends BaseTest {

    ProfilePage profilePage;

    @Test(priority = 0)
    public void testProfilePageLoaded() {
        try {
            initializeTest("test login page loaded", "Login page loaded",
                    "Integration Testing");

            System.out.println("Checking if login page loaded");

            profilePage = PagesFactory.getProfilePage();
            boolean result = profilePage.checkLoginPageLoaded();
            Assert.assertTrue(result, "Login page not loaded");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

    @Test(priority = 1)
    public void validateProfilePageHeader() {
        try {
            initializeTest("validate profile page header", "Profile page header",
                    "Integration Testing");

            System.out.println("Checking if profile page header is correct");

            profilePage = PagesFactory.getProfilePage();
            boolean result = profilePage.validateProfilePageHeader();
            Assert.assertTrue(result, "Profile page header is not correct");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

    @Test(priority = 2)
    public void validateProfilePictureHeader() {
        try {
            initializeTest("validate profile picture header", "Profile picture header",
                    "Integration Testing");

            System.out.println("Checking if profile picture header is correct");

            profilePage = PagesFactory.getProfilePage();
            boolean result = profilePage.validateProfilePictureHeader();
            Assert.assertTrue(result, "Profile picture header is not correct");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

    @Test(priority = 3)
    public void validateNameFields(){
        try {
            initializeTest("validate name fields", "Name fields",
                    "Integration Testing");

            System.out.println("Checking if name fields are correct");

            profilePage = PagesFactory.getProfilePage();
            boolean result = profilePage.validateNameFields();
            Assert.assertTrue(result, "Name fields are not correct");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

    @Test(priority = 4)
    public void validateTitleField(){
        try {
            initializeTest("validate title field", "Title field",
                    "Integration Testing");

            System.out.println("Checking if title field is correct");

            profilePage = PagesFactory.getProfilePage();
            boolean result = profilePage.validateTitleField();
            Assert.assertTrue(result, "Title field is not correct");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

    @Test(priority = 5)
    public void validateEmailField() {
        try {
            initializeTest("validate email field", "Email field",
                    "Integration Testing");

            System.out.println("Checking if email field is correct");

            profilePage = PagesFactory.getProfilePage();
            boolean result = profilePage.validateEmailField();
            Assert.assertTrue(result, "Email field is not correct");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

}
