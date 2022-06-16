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
    @FindBy(xpath = "//button[normalize-space()='Register Now']")
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

    @FindBy(xpath = "//span[.='Please enter Organization name']")
    WebElement organizationErrorMessage;

    // END: Registration page elements


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    /**
     * This method reads the counter from properties file and returns the value
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
     * @return email with unique alias
     */
    public String generateAliasGmail() throws IOException {
        writeCounter(readCounter());
        return "hello.neuraledge" + readCounter() + "@gmail.com";

    }

    /**
     * This method is used to register a new user
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

            driverActions.typeText(organizationNameInput, TestData.getRandomFullName());
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

        }
        catch (Exception e) {
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

        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}