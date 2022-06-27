package main.java.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pages.PagesFactory;


public class DashboardPageTest extends BaseTest {
    HomePage homePage;

    @Test(priority = 1)
    public void validateHomePageLoadSuccessfully() {
        try {
            initializeTest("Homepage loading test", "This test verifies that the homepage is loaded successfully", "Integration Testing");

            homePage = PagesFactory.getHomePage();
            boolean result = homePage.checkHomePageLoaded();
            Assert.assertTrue(result, "Homepage is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}