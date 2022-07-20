package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ManageRequestsPage;
import pageobjects.TechnicalManagerPage;
import pages.PagesFactory;


public class ManageRequestsPageTest extends BaseTest {
    ManageRequestsPage manageRequestsPage;

    @Test(priority = 1)
    public void validateManageRequestsPageLoadsSuccessfully() {
        try {
            initializeTest("Manage Requests page test",
                    "Verify that Manage Requests page is loaded successfully",
                    "Integration Testing");

            manageRequestsPage = PagesFactory.getManageRequestsPage();
            boolean result = manageRequestsPage.checkTechnicalTeamPageLoaded();
            Assert.assertTrue(result, "Manage Requests page is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void validateShowTableButtonIsVisible() {
        try {
            initializeTest("Manage Requests page test",
                    "Verify that Show table button is visible",
                    "Integration Testing");

            manageRequestsPage = PagesFactory.getManageRequestsPage();
            boolean result = manageRequestsPage.checkShowTableButtonIsVisible();
            Assert.assertTrue(result, "Show table button is not visible");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void validateShowTableButtonFunctionality() {
        try {
            initializeTest("Manage Requests page test",
                    "Verify that Show table button is functional",
                    "Integration Testing");

            manageRequestsPage = PagesFactory.getManageRequestsPage();
            boolean result = manageRequestsPage.checkShowTableButtonFunctionality();
            Assert.assertTrue(result, "Show table button is not functional");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void validateShowTableButtonSecondClickFunctionality() {
        try {
            initializeTest("Manage Requests page test",
                    "Verify that Show table button is functional",
                    "Integration Testing");

            manageRequestsPage = PagesFactory.getManageRequestsPage();
            boolean result = manageRequestsPage.checkShowTableButtonSecondClickFunctionality();
            Assert.assertTrue(result, "Show table button is not functional");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void validateTableIsVisibleAfterClickingShowTableButton() {
        try {
            initializeTest("Manage Requests page test",
                    "Verify that table is visible after clicking Show table button",
                    "Integration Testing");

            manageRequestsPage = PagesFactory.getManageRequestsPage();
            boolean result = manageRequestsPage.checkShowTableButtonFunctionality();
            Assert.assertTrue(result, "Table is not visible after clicking Show table button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}