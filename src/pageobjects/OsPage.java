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

    @FindBy(xpath = "//input[@placeholder='Search by name']")
    WebElement searchField;

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

    public boolean checkUserCantSubmitEmtpyForm() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(saveButton);
            step++;
            System.out.println(step + " Click save button");

            driverWaits.waitFiveSeconds();
            return driverWaits.waitUntilVisible(50, osNameField);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFormNotSubmitWithoutOsName() {
        try {
            int step = 0;

            driverActions.typeText(osVersionField, "11");
            step++;
            System.out.println(step + " Type version");

            driverActions.clickOnWebElementWithActionsClass(saveButton);
            step++;
            System.out.println(step + " Click save button");

            driverWaits.waitFiveSeconds();
            return driverWaits.waitUntilVisible(50, osNameField);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFormNotSubmitWithoutVersion() {
        try {
            int step = 0;

            driverActions.typeText(osVersionField, "");

            driverActions.typeText(osNameField, "Windows");
            step++;
            System.out.println(step + " Type name");

            driverActions.clickOnWebElementWithActionsClass(saveButton);
            step++;
            System.out.println(step + " Click save button");

            driverWaits.waitFiveSeconds();
            return driverWaits.waitUntilVisible(50, osVersionField);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkAddOsFunctionality() {
        try {
            int step = 0;

            driverActions.typeText(osNameField, TestData.getRandomFirstName());
            step++;
            System.out.println(step + " Type name");

            driverActions.typeText(osVersionField, TestData.getRandomNumber());
            step++;
            System.out.println(step + " Type version");

            driverActions.clickOnWebElementWithActionsClass(saveButton);
            step++;
            System.out.println(step + " Click save button");

            return driverActions.waitUntilInvisibilityOfElement(osNameField);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkSearchFieldIsPresent() {
        try {
            int step = 0;

            return driverWaits.waitUntilVisible(50, searchField);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}