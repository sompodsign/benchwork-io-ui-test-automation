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

}
