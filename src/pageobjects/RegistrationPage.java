package pageobjects;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

import applicationsettings.ApplicationSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.DriverActions;
import helper.DriverWaits;
import org.testng.Assert;
import pages.PagesFactory;
import testdata.TestData;


public class RegistrationPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // Start: Homepage elements
    @FindBy(xpath = "//button[contains(text(),'Register Now')]")
    WebElement registerButton;

    // END: Homepage elements

    // Start: Registration page elements
    @FindBy(xpath = "//h5[normalize-space()='Create Account']")
    WebElement createAccountHeader;

    @FindBy(xpath = "//input[@id='organizationName']")
    WebElement organizationNameInput;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//h4[normalize-space()='Agency']")
    WebElement agencyOption;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//h4[normalize-space()='Enterprise']")
    WebElement enterPriceOption;

    @FindBy(xpath = "//span[contains(text(),'Please enter Organization name')]")
    WebElement organizationErrorMessage;

    @FindBy(xpath = "//span[contains(text(),'Please enter Organization type')]")
    WebElement organizationTypeErrorMessage;

    @FindBy(xpath = "//span[contains(text(),'Please enter first name')]")
    WebElement firstNameErrorMessage;

    @FindBy(xpath = "//span[contains(text(),'Please enter last name')]")
    WebElement lastNameErrorMessage;

    @FindBy(xpath = "//span[contains(text(),'Please enter your email')]")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//span[contains(text(),'Please enter your password')]")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//span[contains(text(),'Please confirm your password')]")
    WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//h5[contains(text(),'Create Account')]")
    WebElement createAccountHeaderMessage;

    @FindBy(xpath = "//span[contains(text(),'Invalid email')]")
    WebElement invalidEmailErrorMessage;

    // END: Registration page elements


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    /**
     * This method reads the counter from properties file and returns the value
     *
     * @return
     */
    public int readCounter() {
        try {
            InputStream input = new FileInputStream("src/testdata/aliasCounter.properties");
            Properties prop = new Properties();
            prop.load(input);
            return Integer.parseInt(prop.getProperty("count"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * This method is used to write counter on properties file
     */
    public void writeCounter(int count) {

        try {
            OutputStream output = new FileOutputStream("src/testdata/aliasCounter.properties");
            Properties prop = new Properties();
            prop.setProperty("count", String.valueOf(count + 1));
            prop.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method is used to create email with unique alias
     *
     * @return email with unique alias
     */
    public String generateAliasGmail() throws IOException {
        writeCounter(readCounter());
        return "hello.neuraledge" + readCounter() + "@gmail.com";

    }

    public void typeInOrganizationField(String organizationName) {
        driverActions.typeText(organizationNameInput, organizationName);
    }

    public void clickOnContinueButton() throws Exception {
        driverActions.clickOnWebElementWithActionsClass(continueButton);
    }

    public void typeFirstName() {
        driverActions.typeText(firstNameInput, TestData.getRandomFirstName());
    }

    public void typeLastName() {
        driverActions.typeText(lastNameInput, TestData.getRandomLastName());
    }

    public void typeEmail() throws IOException {
        driverActions.typeText(emailInput, generateAliasGmail());
    }

    public void typePassword() {
        driverActions.typeText(passwordInput, "5946644Ss@");
    }

    public void typeConfirmPassword() {
        driverActions.typeText(confirmPasswordInput, "5946644Ss@");
    }

    public void clickOnCreateAccountButton() throws Exception {
        driverActions.clickOnWebElementWithActionsClass(createAccountButton);
    }

    // Start: Homepage Registration Page methods

    /**
     * this method verifies if "Create Account" header is visible
     */
    public boolean checkRegistrationPageLoaded() {
        try {
            driverActions.clickOnWebElementWithActionsClass(registerButton);
            return driverWaits.waitUntilVisible(20, createAccountHeader);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method is used to register a new user
     *
     * @return boolean
     */
    public boolean registerAsAgency(String registerAs) {
        try {
            int step = 0;

            if (Objects.equals(registerAs, "agency")) {
                driverActions.clearSession();
                driverActions.refreshPage();
                driver.get(ApplicationSettings.getUrl());
            }

            driverActions.clickOnWebElementWithActionsClass(registerButton);
            step++;
            System.out.println("Step " + step + ": Click on Register Now button");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, createAccountHeader), "Create Account header is not visible");
            step++;
            System.out.println("Step " + step + ": Verify that Create Account header is visible");

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter random full name");

            if (Objects.equals(registerAs, "agency")) {
                driverActions.clickOnWebElementWithActionsClass(agencyOption);
                step++;
                System.out.println("Step " + step + ": Click on agency option");
            } else {
                driverActions.clickOnWebElementWithActionsClass(enterPriceOption);
                step++;
                System.out.println("Step " + step + ": Click on enterprise option");
            }

            driverActions.clickOnWebElementWithActionsClass(continueButton);
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            driverActions.typeText(firstNameInput, TestData.getRandomFirstName());
            step++;
            System.out.println("Step " + step + ": Enter random first name");

            driverActions.typeText(lastNameInput, TestData.getRandomLastName());
            step++;
            System.out.println("Step " + step + ": Enter random last name");

            driverActions.typeText(emailInput, generateAliasGmail());
            step++;
            System.out.println("Step " + step + ": Enter email");

            driverActions.typeText(passwordInput, "5946644Ss@");
            step++;
            System.out.println("Step " + step + ": Enter password");

            driverActions.typeText(confirmPasswordInput, "5946644Ss@");
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            driverActions.clickOnWebElementWithActionsClass(createAccountButton);
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driver.getCurrentUrl().contains("/dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkFormNotSubmitWithoutOrganization(String registerAs) {
        try {
            int step = 0;

            if (Objects.equals(registerAs, "agency")) {
                driverActions.clearSession();
                driverActions.refreshPage();
                driver.get(ApplicationSettings.getUrl());
            }

            driverActions.clickOnWebElementWithActionsClass(registerButton);
            step++;
            System.out.println("Step " + step + ": Click on Register Now button");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, createAccountHeader), "Create Account header is not visible");
            step++;
            System.out.println("Step " + step + ": Verify that Create Account header is visible");

            if (Objects.equals(registerAs, "agency")) {
                driverActions.clickOnWebElementWithActionsClass(agencyOption);
                step++;
                System.out.println("Step " + step + ": Click on agency option");
            } else {
                driverActions.clickOnWebElementWithActionsClass(enterPriceOption);
                step++;
                System.out.println("Step " + step + ": Click on enterprise option");
            }

            driverActions.clickOnWebElementWithActionsClass(continueButton);
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            driverActions.typeText(firstNameInput, TestData.getRandomFirstName());
            step++;
            System.out.println("Step " + step + ": Enter random first name");

            driverActions.typeText(lastNameInput, TestData.getRandomLastName());
            step++;
            System.out.println("Step " + step + ": Enter random last name");

            driverActions.typeText(emailInput, generateAliasGmail());
            step++;
            System.out.println("Step " + step + ": Enter email");

            driverActions.typeText(passwordInput, "5946644Ss@");
            step++;
            System.out.println("Step " + step + ": Enter password");

            driverActions.typeText(confirmPasswordInput, "5946644Ss@");
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            driverActions.clickOnWebElementWithActionsClass(createAccountButton);
            driverWaits.waitOneSeconds();
            driverActions.clickOnWebElementWithActionsClass(createAccountButton);
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20, organizationErrorMessage);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkEmptyFormSubmit() {
        try {
            int step = 0;

            driverActions.clearSession();
            driverActions.refreshPage();
            driver.get(ApplicationSettings.getUrl());

            driverActions.clickOnWebElementWithActionsClass(registerButton);
            step++;
            System.out.println("Step " + step + ": Click on Register Now button");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, createAccountHeader), "Create Account header is not visible");
            step++;
            System.out.println("Step " + step + ": Verify that Create Account header is visible");

            driverActions.clickOnWebElementWithActionsClass(continueButton);
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            driverActions.clickOnWebElementWithActionsClass(createAccountButton);
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            driverActions.clickOnWebElementWithActionsClass(createAccountButton);
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20, organizationErrorMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkFormNotSubmitWithoutOrganizationType() {
        try {
            int step = 0;

            driverActions.clearSession();
            driverActions.refreshPage();
            driver.get(ApplicationSettings.getUrl());

            driverActions.clickOnWebElementWithActionsClass(registerButton);
            step++;
            System.out.println("Step " + step + ": Click on Register Now button");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, createAccountHeader), "Create Account header is not visible");
            step++;
            System.out.println("Step " + step + ": Verify that Create Account header is visible");

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter organization name");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");
//
            driverActions.typeText(firstNameInput, TestData.getRandomFirstName());
            step++;
            System.out.println("Step " + step + ": Enter random first name");

            driverActions.typeText(lastNameInput, TestData.getRandomLastName());
            step++;
            System.out.println("Step " + step + ": Enter random last name");

            driverActions.typeText(emailInput, generateAliasGmail());
            step++;
            System.out.println("Step " + step + ": Enter email");

            driverActions.typeText(passwordInput, "5946644Ss@");
            step++;
            System.out.println("Step " + step + ": Enter password");

            driverActions.typeText(confirmPasswordInput, "5946644Ss@");
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            driverActions.clickOnWebElementWithActionsClass(createAccountButton);
            driverWaits.waitOneSeconds();
            driverActions.clickOnWebElementWithActionsClass(createAccountButton);
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20, organizationTypeErrorMessage);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkFormNotSubmitWithoutFirstName() {
        try {
            int step = 0;

            driverActions.refreshPage();
            driver.get(ApplicationSettings.getUrl());

            driverActions.clickOnWebElementWithActionsClass(registerButton);
            step++;
            System.out.println("Step " + step + ": Click on Register Now button");

            Assert.assertTrue(driverWaits.waitUntilVisible(20, createAccountHeader), "Create Account header is not visible");
            step++;
            System.out.println("Step " + step + ": Verify that Create Account header is visible");

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter organization name");

            driverActions.clickOnWebElementWithActionsClass(agencyOption);
            step++;
            System.out.println("Step " + step + ": Click on agency option");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            typeLastName();
            step++;
            System.out.println("Step " + step + ": Enter last name");

            typeEmail();
            step++;
            System.out.println("Step " + step + ": Enter email");

            typePassword();
            step++;
            System.out.println("Step " + step + ": Enter password");

            typeConfirmPassword();
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            clickOnCreateAccountButton();
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            clickOnCreateAccountButton();
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");


            return driverWaits.waitUntilVisible(20, firstNameErrorMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFormNotSubmitWithoutLastName() {
        try {
            int step = 0;

            driverActions.refreshPage();

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter organization name");

            driverActions.clickOnWebElementWithActionsClass(agencyOption);
            step++;
            System.out.println("Step " + step + ": Click on agency option");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            typeFirstName();
            step++;
            System.out.println("Step " + step + ": Enter first name");

            typeEmail();
            step++;
            System.out.println("Step " + step + ": Enter email");

            typePassword();
            step++;
            System.out.println("Step " + step + ": Enter password");

            typeConfirmPassword();
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            clickOnCreateAccountButton();
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20, lastNameErrorMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFormNotSubmitWithoutEmail() {
        try {
            int step = 0;

            driverActions.refreshPage();

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter organization name");

            driverActions.clickOnWebElementWithActionsClass(agencyOption);
            step++;
            System.out.println("Step " + step + ": Click on agency option");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            typeFirstName();
            step++;
            System.out.println("Step " + step + ": Enter first name");

            typeLastName();
            step++;
            System.out.println("Step " + step + ": Enter last name");

            typePassword();
            step++;
            System.out.println("Step " + step + ": Enter password");

            typeConfirmPassword();
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            clickOnCreateAccountButton();
            clickOnCreateAccountButton();
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20, emailErrorMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFormNotSubmitWithoutPassword() {
        try {
            int step = 0;

            driverActions.refreshPage();

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter organization name");

            driverActions.clickOnWebElementWithActionsClass(agencyOption);
            step++;
            System.out.println("Step " + step + ": Click on agency option");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            typeFirstName();
            step++;
            System.out.println("Step " + step + ": Enter first name");

            typeLastName();
            step++;
            System.out.println("Step " + step + ": Enter last name");

            typeEmail();
            step++;
            System.out.println("Step " + step + ": Enter email");

            typeConfirmPassword();
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            clickOnCreateAccountButton();
            clickOnCreateAccountButton();
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20, passwordErrorMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFormNotSubmitWithoutConfirmPassword() {
        try {
            int step = 0;

            driverActions.refreshPage();

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter organization name");

            driverActions.clickOnWebElementWithActionsClass(agencyOption);
            step++;
            System.out.println("Step " + step + ": Click on agency option");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            typeFirstName();
            step++;
            System.out.println("Step " + step + ": Enter first name");

            typeLastName();
            step++;
            System.out.println("Step " + step + ": Enter last name");

            typeEmail();
            step++;
            System.out.println("Step " + step + ": Enter email");

            typePassword();
            step++;
            System.out.println("Step " + step + ": Enter password");

            clickOnCreateAccountButton();
            clickOnCreateAccountButton();
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20, confirmPasswordErrorMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFormNotSubmitWithInvalidEmail() {
        try {
            int step = 0;

            driverActions.refreshPage();

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter organization name");

            driverActions.clickOnWebElementWithActionsClass(agencyOption);
            step++;
            System.out.println("Step " + step + ": Click on agency option");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            typeFirstName();
            step++;
            System.out.println("Step " + step + ": Enter first name");

            typeLastName();
            step++;
            System.out.println("Step " + step + ": Enter last name");

            driverActions.typeText(emailInput, "invalidEmailgamil.com");
            step++;
            System.out.println("Step " + step + ": Enter email");

            typePassword();
            step++;
            System.out.println("Step " + step + ": Enter password");

            typeConfirmPassword();
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            clickOnCreateAccountButton();
            clickOnCreateAccountButton();
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driverWaits.waitUntilVisible(20, invalidEmailErrorMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkFormNotSubmitWithPasswordMismatch() {
        try {
            int step = 0;

            driverActions.refreshPage();

            typeInOrganizationField(TestData.getRandomFullName());
            step++;
            System.out.println("Step " + step + ": Enter organization name");

            driverActions.clickOnWebElementWithActionsClass(agencyOption);
            step++;
            System.out.println("Step " + step + ": Click on agency option");

            clickOnContinueButton();
            step++;
            System.out.println("Step " + step + ": Click on Continue button");

            typeFirstName();
            step++;
            System.out.println("Step " + step + ": Enter first name");

            typeLastName();
            step++;
            System.out.println("Step " + step + ": Enter last name");

            typeEmail();
            step++;
            System.out.println("Step " + step + ": Enter email");

            typePassword();
            step++;
            System.out.println("Step " + step + ": Enter password");

            driverActions.typeText(confirmPasswordInput, "invalidPassword");
            step++;
            System.out.println("Step " + step + ": Enter confirm password");

            clickOnCreateAccountButton();
            step++;
            System.out.println("Step " + step + ": Click on Create Account button");

            return driver.getCurrentUrl().contains("/register");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}