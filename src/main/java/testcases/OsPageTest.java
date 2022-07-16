package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.OsPage;
import pages.PagesFactory;


public class OsPageTest extends BaseTest {
    OsPage osPage;

    @Test(priority = 0)
    public void validateOsPageLoaded() {
        try {
            initializeTest("os page test", "this test verifies that os page loads properly", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkOsPageLoading();
            Assert.assertTrue(result, "os page not loaded");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void validateAddOsButtonFunctionality() {
        try {
            initializeTest("add os button test", "this test verifies that add os button works properly", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkAddOsButtonFunctionality();
            Assert.assertTrue(result, "add os button not working");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void validateCancelButtonFunctionality() {
        try {
            initializeTest("cancel button test", "this test verifies that cancel button works properly", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkCancelButtonFunctionality();
            Assert.assertTrue(result, "cancel button not working");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void validateOsNameFieldOnTheModal() {
        try {
            initializeTest("os name field test", "this test verifies that os name field works properly", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkOsNameFieldOnTheModal();
            Assert.assertTrue(result, "os name field not working");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 4)
    public void validateTypeFieldOnthePage() {
        try {
            initializeTest("type field test", "this test verifies that type field works properly", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkTypeFieldOnthePage();
            Assert.assertTrue(result, "type field not working");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 5)
    public void validateUserCantSubmitEmtpyForm() {
        try {
            initializeTest("empty form test", "this test verifies that user cant submit empty form", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkUserCantSubmitEmtpyForm();
            Assert.assertTrue(result, "user can submit empty form");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 6)
    public void validateFormNotSubmitWithoutOsName(){
        try {
            initializeTest("empty os name test", "this test verifies that user cant submit form without os name", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkFormNotSubmitWithoutOsName();
            Assert.assertTrue(result, "user can submit form without os name");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 7)
    public void validateFormNotSubmitWithoutVersion() {
        try {
            initializeTest("empty version test", "this test verifies that user cant submit form without version", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkFormNotSubmitWithoutVersion();
            Assert.assertTrue(result, "user can submit form without version");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 8)
    public void validateAddOsFunctionality() {
        try {
            initializeTest("add os test", "this test verifies that add os works properly", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkAddOsFunctionality();
            Assert.assertTrue(result, "add os not working");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 9)
    public void validateSearchFieldIsPresent() {
        try {
            initializeTest("search field test", "this test verifies that search field is present", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkSearchFieldIsPresent();
            Assert.assertTrue(result, "search field is not present");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
