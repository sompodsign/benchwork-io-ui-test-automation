package main.java.testcases;
import helper.DriverActions;
import main.java.testdataprovider.TestDataProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pages.PagesFactory;

public class LogoutTest extends BaseTest {

    @FindBy(xpath = "//div[@class='flex items-center cursor-pointer']")
    WebElement profileIcon;

    @FindBy(xpath = "//button[.=\"Logout\"]")
    WebElement logoutButton;

    @FindBy(xpath = "//h5[.=\"Welcome Back!\"]")
    WebElement welcomeBackText;

    @Test(priority = 1)
    public void testLogout() {
        DriverActions driverActions;
        try {
            initializeTest("test logout", "Logout", "Integration Testing");

            System.out.println("Checking if logout");

            driverActions = PagesFactory.getDriverActionsObject();
            Thread.sleep(1000);
            driverActions.clickOnWebElementWithActionsClass(profileIcon);
            System.out.println("Clicked on profile icon");

            driverActions.clickOnWebElementWithActionsClass(logoutButton);
            System.out.println("Clicked on logout button");

            Assert.assertTrue(welcomeBackText.isDisplayed(), "User is not logged out");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }
    }

}
