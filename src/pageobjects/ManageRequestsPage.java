package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;
import testdata.TestData;

public class ManageRequestsPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    @FindBy(xpath = "//span[normalize-space()='Manage Requests']")
    WebElement manageRequestsPageLink;

    @FindBy(xpath = "//h4[normalize-space()='Manage Request']")
    WebElement manageRequestPageHeader;

    @FindBy(xpath = "//button[normalize-space()='Show table']")
    WebElement showTableButton;

    @FindBy(xpath = "//input[@placeholder='Search by name, team']")
    WebElement searchByNameTeamInput;

    @FindBy(xpath = "//td[normalize-space()='Name']")
    WebElement nameColumn;

    @FindBy(xpath = "//span[normalize-space()='Select']")
    WebElement selectColumn;


    public ManageRequestsPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkTechnicalTeamPageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(manageRequestsPageLink);
            System.out.println("Step " + ++step + ": Click on Manage Requests link");

            return driverWaits.waitUntilVisible(50, manageRequestPageHeader);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkShowTableButtonIsVisible() {
        try {
            int step = 0;

            return driverWaits.waitUntilVisible(50, showTableButton);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkShowTableButtonFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(showTableButton);
            System.out.println("Step " + ++step + ": Click on Show table button");

            return driverWaits.waitUntilVisible(50, nameColumn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkShowTableButtonSecondClickFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(showTableButton);
            System.out.println("Step " + ++step + ": Click on Show table button");

            return !driverWaits.waitUntilVisible(5, nameColumn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
