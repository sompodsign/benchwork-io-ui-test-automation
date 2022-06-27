package main.java.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.DashboardPage;
import pages.PagesFactory;


public class DashboardPageTest extends BaseTest {
    DashboardPage dashboard;

    @Test(priority = 1)
    public void validateDashboardPageLoadSuccessfully() {
        try {
            initializeTest("Dashboard loading test", "This test verifies that the Dashboard is loaded successfully", "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkDashboardPageLoaded();
            Assert.assertTrue(result, "Dashboard is not loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void validateTopCardsOnDashboard() {
        try {
            initializeTest("Top cards on Dashboard", "This test verifies that the top cards are displayed on Dashboard", "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkTopCardsOnDashboard();
            Assert.assertTrue(result, "Top cards are not displayed on Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 3)
    public void validateLanguageSummarySectionFunctionalities() {
        try {
            initializeTest("Language Summary Section Functionalities", "This test verifies that the Language Summary Section Functionalities are working", "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkLanguageSummarySectionFunctionalities();
            Assert.assertTrue(result, "Language Summary Section Functionalities are not working");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}