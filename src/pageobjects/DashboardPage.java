package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;

public class DashboardPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: Dashboard elements
    @FindBy(xpath = "//span[normalize-space()='Total Client']")
    WebElement totalClientCard;

    @FindBy(xpath = "//span[normalize-space()='Total Project']")
    WebElement totalProjectCard;

    @FindBy(xpath = "//span[normalize-space()='Total Product']")
    WebElement totalProductCard;

    @FindBy(xpath = "//span[normalize-space()='Total Vendor']")
    WebElement totalVendorCard;
    // END: Dashboard elements

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkDashboardPageLoaded() {
        return driver.getCurrentUrl().contains("dashboard");
    }

    public boolean checkTopCardsOnDashboard() {
        try {
            int step = 0;

            Assert.assertTrue(totalClientCard.isDisplayed(), "Total Client card is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Total Client card is displayed on Dashboard");
            Assert.assertTrue(totalProjectCard.isDisplayed(), "Total Project card is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Total Project card is displayed on Dashboard");
            Assert.assertTrue(totalProductCard.isDisplayed(), "Total Product card is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Total Product card is displayed on Dashboard");
            Assert.assertTrue(totalVendorCard.isDisplayed(), "Total Vendor card is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Total Vendor card is displayed on Dashboard");
            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}