package pageobjects;

import applicationsettings.ApplicationSettings;
import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;
import testdata.TestData;


public class ProfilePage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    @FindBy(xpath = "//h4[normalize-space()='My Profile']")
    WebElement myProfileHeader;

    @FindBy(xpath = "//h4[normalize-space()='Profile Photo']")
    WebElement profilePhotoHeader;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='title']")
    WebElement titleField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneField;





    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkLoginPageLoaded() {
        try {
            int step = 0;

            driver.get(ApplicationSettings.profileUrl);

            return driver.getCurrentUrl().equals(ApplicationSettings.profileUrl);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateProfilePageHeader() {
        try {
            int step = 0;

            return driverWaits.waitUntilVisible(50, myProfileHeader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateProfilePictureHeader() {
        try {
            int step = 0;

            return driverWaits.waitUntilVisible(50, profilePhotoHeader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateNameFields() {
        try {
            int step = 0;

            return driverWaits.waitUntilVisible(50, firstNameField) && driverWaits.waitUntilVisible(50, lastNameField);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateTitleField() {
        try {
            int step = 0;

            return driverWaits.waitUntilVisible(50, titleField);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateEmailField() {
        try {
            int step = 0;

            return driverWaits.waitUntilVisible(50, emailField);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}