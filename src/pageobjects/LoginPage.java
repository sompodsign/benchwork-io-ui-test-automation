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

import java.io.*;
import java.util.Objects;
import java.util.Properties;


public class LoginPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // Start: Homepage elements
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    // END: Homepage elements

    // Start: Login page elements
    @FindBy(xpath = "//h5[normalize-space()='Welcome Back!']")
    WebElement welcomeBackText;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//span[contains(.,'Please enter your email')]")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//span[normalize-space()='Please enter your password']")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButtonOnLoginPage;

    @FindBy(xpath = "//span[contains(.,'Invalid email')]")
    WebElement invalidEmailErrorMessage;

    // END: Login page elements


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkLoginPageLoaded() {
        try {
            int step = 0;

            driverActions.clearSession();
            driver.get(ApplicationSettings.getUrl());
            Assert.assertTrue(driverWaits.waitUntilVisible(50,loginButton), "Login button not visible");
            step++;
            System.out.println("Step " + step + ": Login button visible");

            driverActions.clickOnWebElementWithActionsClass(loginButton);
            step++;
            System.out.println("Step " + step + ": Click on login button");

            return driverWaits.waitUntilVisible(50,welcomeBackText);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkEmptyLoginFormSubmit() {
        try {
            int step = 0;

                Assert.assertTrue(driverWaits.waitUntilVisible(50, welcomeBackText),
                        "Welcome back text not visible");
                step++;
                System.out.println("Step " + step + ": Welcome back text visible");

                driverActions.clickOnWebElementWithActionsClass(loginButton);
                step++;
                System.out.println("Step " + step + ": Click on login button");

                driverActions.clickOnWebElementWithActionsClass(loginButton);
                step++;
                System.out.println("Step " + step + ": Click on login button");

                return driverWaits.waitUntilVisible(50, emailErrorMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkLoginWithOutEnteringAnEmail() {
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(50, welcomeBackText),
                    "Welcome back text not visible");
            step++;
            System.out.println("Step " + step + ": Welcome back text visible");

            driverActions.typeText(passwordField, TestData.getBasicPassword());
            step++;
            System.out.println("Step " + step + ": Enter password");

            driverActions.clickOnWebElementWithActionsClass(loginButton);
            step++;
            System.out.println("Step " + step + ": Click on login button");

            return driverWaits.waitUntilVisible(50, emailErrorMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkLoginWithWrongEmail() {
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(50, welcomeBackText),
                    "Welcome back text not visible");
            step++;
            System.out.println("Step " + step + ": Welcome back text visible");

            driverActions.typeText(emailField, TestData.getWrongEmail());
            step++;
            System.out.println("Step " + step + ": Enter email");

            driverActions.clickOnWebElementWithActionsClass(loginButton);
            step++;
            System.out.println("Step " + step + ": Click on login button");

            return driverWaits.waitUntilVisible(50, invalidEmailErrorMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String email, String password) {
        System.out.println("Login with email: " + email + " and password: " + password);
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(50, welcomeBackText),
                    "Welcome back text not visible");
            step++;
            System.out.println("Step " + step + ": Welcome back text visible");

            driverActions.typeText(emailField, email);
            step++;
            System.out.println("Step " + step + ": Enter email");

            driverActions.typeText(passwordField, password);
            step++;
            System.out.println("Step " + step + ": Enter password");

            driverActions.clickOnWebElementWithActionsClass(loginButton);
            step++;
            System.out.println("Step " + step + ": Click on login button");

            return driver.getCurrentUrl().contains("dashboard");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}