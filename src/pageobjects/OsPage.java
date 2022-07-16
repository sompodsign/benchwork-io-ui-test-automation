package pageobjects;

import applicationsettings.ApplicationSettings;
import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Factory;
import pages.PagesFactory;
import testdata.TestData;


public class OsPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    //
    @FindBy(xpath = "//a[.='OS']")
    WebElement osOption;

    @FindBy(xpath = "//h4[normalize-space()='OS']")
    WebElement osHeader;

    @FindBy(xpath = "//button[normalize-space()='Add OS']")
    WebElement addOsButton;

    @FindBy(xpath = "//input[@id='name']")
    WebElement osNameField;

    @FindBy(xpath = "//input[@id='version']")
    WebElement osVersionField;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    //


    public OsPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkOsPageLoading() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(osOption);
            step++;
            System.out.println(step + " Click os menu icon");

            return driverWaits.waitUntilVisible(50, osHeader);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkAddOsButtonFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(addOsButton);
            step++;
            System.out.println(step + " Click add os button");

            return driverWaits.waitUntilVisible(50, osNameField);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public boolean checkCancelButtonFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(cancelButton);
            step++;
            System.out.println(step + " Click cancel button");

            return driverActions.waitUntilInvisibilityOfElement(osNameField);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkOsNameFieldOnTheModal() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(addOsButton);
            step++;
            System.out.println(step + " Click add os button");

            return driverWaits.waitUntilVisible(50, osNameField);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkTypeFieldOnthePage() {
        try {
            int step = 0;

            return driverWaits.waitUntilVisible(50, osVersionField);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}