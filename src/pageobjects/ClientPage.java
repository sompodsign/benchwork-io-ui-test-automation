package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PagesFactory;

public class ClientPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    @FindBy(xpath = "//span[normalize-space()='Client']")
    WebElement clientPageLink;

    @FindBy(xpath = "//h4[normalize-space()='Your Client']")
    WebElement clientPageHeader;

    @FindBy(xpath = "//button[normalize-space()='Show table']")
    WebElement showTableButton;

    @FindBy(xpath = "//button[normalize-space()='Add Client']")
    WebElement addClientButton;

    @FindBy(xpath = "//input[@placeholder='Search by name, team']")
    WebElement searchBox;

    @FindBy(xpath = "//td[normalize-space()='Name']")
    WebElement nameColumn;

    @FindBy(xpath = "//h3[contains(text(),'Add Client')]")
    WebElement addClientModalHeader;

    @FindBy(xpath = "//input[@id='clientName']")
    WebElement clientNameField;

    @FindBy(xpath = "//textarea[@id='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;



    public ClientPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkClientPageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(clientPageLink);
            System.out.println("Step " + ++step + ": Click on Client link");

            return driverWaits.waitUntilVisible(50, clientPageHeader);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkShowTableButtonTogglesTheTable() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(showTableButton);
            System.out.println("Step " + ++step + ": Click on Show table button");

            return driverWaits.waitUntilVisible(50, nameColumn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkSearchBox() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(searchBox);
            System.out.println("Step " + ++step + ": Click on Search box");

            return driverWaits.waitUntilVisible(50, nameColumn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkTableCloseFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(showTableButton);
            System.out.println("Step " + ++step + ": Click on Show table button");

            return !driverWaits.waitUntilVisible(5, nameColumn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkAddClientButtonFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(addClientButton);
            System.out.println("Step " + ++step + ": Click on Add Client button");

            return driverWaits.waitUntilVisible(50, addClientModalHeader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUserCanCloseTheModal() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(addClientButton);
            System.out.println("Step " + ++step + ": Click on Add Client button");

            driverActions.clickOnWebElementWithActionsClass(cancelButton);
            System.out.println("Step " + ++step + ": Click on Cancel button");

            return !driverWaits.waitUntilVisible(5, addClientModalHeader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUserCanTypeOnAddClientNameField(){
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(addClientButton);
            System.out.println("Step " + ++step + ": Click on Add Client button");

            driverActions.typeText(clientNameField, "Test");
            System.out.println("Step " + ++step + ": Type text into Client name field");

            return driver.findElement((By) clientNameField).getAttribute("value").equals("Test");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    }

