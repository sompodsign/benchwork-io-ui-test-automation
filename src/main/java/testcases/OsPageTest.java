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
    public void validateOsNameFieldOnTheModal(){
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
    public void validateTypeFieldOnthePage(){
        try {
            initializeTest("type field test", "this test verifies that type field works properly", "intigration test");

            osPage = PagesFactory.getOsPage();

            boolean result = osPage.checkTypeFieldOnthePage();
            Assert.assertTrue(result, "type field not working");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
