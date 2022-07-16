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
}
