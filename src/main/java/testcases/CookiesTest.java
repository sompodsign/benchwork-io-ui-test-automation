package main.java.testcases;
import helper.DriverActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PagesFactory;

public class CookiesTest extends BaseTest {

    @Test(priority = 1)
    public void testLogout() {
        DriverActions driverActions;
        try {
            initializeTest("test logout after removing cookies", "Logout", "Integration Testing");

            driverActions = PagesFactory.getDriverActionsObject();
            Thread.sleep(1000);

            driverActions.clearCookies();
            driverActions.refreshPage();
            Thread.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }
    }

}
