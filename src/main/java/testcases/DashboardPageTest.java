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

    @Test(priority = 4)
    public void validateRecentConsultantsSection() {
        try {
            initializeTest("Recent Consultants Section", "This test verifies that the Recent Consultants Section is working", "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkRecentConsultantsSection();
            Assert.assertTrue(result, "Recent Consultants Section is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void validateRecentConsultantsSectionTable() {
        try {
            initializeTest("Recent Consultants Section Table",
                    "This test verifies that the Recent Consultants Section Table is working",
                    "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkRecentConsultantsSectionTable();
            Assert.assertTrue(result, "Recent Consultants Section Table is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void validateEditButtonFunctionalityForARow() {
        try {
            initializeTest("Edit Button Functionality For A Row",
                    "This test verifies that the Edit Button Functionality For A Row is working",
                    "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkEditButtonFunctionalityForARow();
            Assert.assertTrue(result, "Edit Button Functionality For A Row is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void validateRecentWorkLogsTable() {
        try {
            initializeTest("Recent Work Logs Table",
                    "This test verifies that the Recent Work Logs Table is working",
                    "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkRecentWorkLogsTable();
            Assert.assertTrue(result, "Recent Work Logs Table is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8)
    public void validateSeeAllButtonFunctionalityOfRecentWorkLogsSection() {
        try {
            initializeTest("See All Button Functionality Of Recent Work Logs Section",
                    "This test verifies that the See All Button Functionality Of Recent Work Logs Section is working",
                    "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkSeeAllButtonFunctionalityOfRecentWorkLogsSection();
            Assert.assertTrue(result, "See All Button Functionality Of Recent Work Logs Section is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9)
    public void validateRecentConsultantSectionFilterFunctionality() {
        try {
            initializeTest("Recent Consultant Section Filter Functionality",
                    "This test verifies that the Recent Consultant Section Filter Functionality is working",
                    "Integration Testing");

            dashboard = PagesFactory.getDashboardPage();
            boolean result = dashboard.checkRecentConsultantSectionFilterFunctionality();
            Assert.assertTrue(result, "Recent Consultant Section Filter Functionality is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}