package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ClientPage;
import pages.PagesFactory;


public class ClientPageTest extends BaseTest {
    ClientPage clientPage;

    @Test(priority = 1)
    public void validateClientPageLoadsSuccessfully() {
        try {
            initializeTest("Client page test",
                    "Verify that client page is loaded successfully",
                    "Integration Testing");

            clientPage = PagesFactory.getClientPage();
            boolean result = clientPage.checkClientPageLoaded();
            Assert.assertTrue(result, "Client page is not loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void validateShowTableButtonTogglesTheTable() {
        try {
            initializeTest("Client page test",
                    "Verify that show table button toggles the table",
                    "Integration Testing");

            clientPage = PagesFactory.getClientPage();
            boolean result = clientPage.checkShowTableButtonTogglesTheTable();
            Assert.assertTrue(result, "Show table button toggles the table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void validateSearchBox() {
        try {
            initializeTest("Client page test",
                    "Verify that search box is working",
                    "Integration Testing");

            clientPage = PagesFactory.getClientPage();
            boolean result = clientPage.checkSearchBox();
            Assert.assertTrue(result, "Search box is working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void validateTableCloseFunctionality() {
        try {
            initializeTest("Client page test",
                    "Verify that table close functionality is working",
                    "Integration Testing");

            clientPage = PagesFactory.getClientPage();
            boolean result = clientPage.checkTableCloseFunctionality();
            Assert.assertTrue(result, "Table close functionality is working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void validateAddClientButtonFunctionality() {
        try {
            initializeTest("Client page test",
                    "Verify that add client button functionality is working",
                    "Integration Testing");

            clientPage = PagesFactory.getClientPage();
            boolean result = clientPage.checkAddClientButtonFunctionality();
            Assert.assertTrue(result, "Add client button functionality is working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void validateUserCanCloseTheModal() {
        try {
            initializeTest("Client page test",
                    "Verify that user can close the modal",
                    "Integration Testing");

            clientPage = PagesFactory.getClientPage();
            boolean result = clientPage.checkUserCanCloseTheModal();
            Assert.assertTrue(result, "User can close the modal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void validateUserCanTypeOnAddClientNameField() {
        try {
            initializeTest("Client page test",
                    "Verify that user can type on add client name field",
                    "Integration Testing");

            clientPage = PagesFactory.getClientPage();
            boolean result = clientPage.checkUserCanTypeOnAddClientNameField();
            Assert.assertTrue(result, "User can type on add client name field");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
