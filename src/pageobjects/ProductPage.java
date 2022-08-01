package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;

public class ProductPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: ProductPage elements
    @FindBy(xpath = "//span[normalize-space()='Product']")
    WebElement ProductLink;

    @FindBy(xpath = "//h4[normalize-space()='Your Product']")
    WebElement ProductTitle;

    @FindBy(xpath = "//input[@placeholder='Search by name, team']")
    WebElement searchBox;

    @FindBy(xpath = "//button[normalize-space()='Show table']")
    WebElement showTableButton;

    @FindBy(xpath = "//td[normalize-space()='Name']")
    WebElement nameColumn;

    @FindBy(xpath = "//td[normalize-space()='Client Name']")
    WebElement clientNameColumn;

    @FindBy(xpath = "//td[normalize-space()='Description']")
    WebElement descriptionColumn;

    @FindBy(xpath = "//td[normalize-space()='Status']")
    WebElement statusColumn;

    @FindBy(xpath = "//button[normalize-space()='Add Product']")
    WebElement addProductButton;

    @FindBy(xpath = "//h3[@id='headlessui-dialog-title-:rlj:']")
    WebElement addProductDialogTitle;

    @FindBy(xpath = "//button[@id='headlessui-listbox-button-:rll:']")
    WebElement clientNameDropdown;

    @FindBy(xpath = "//input[@id='productname']")
    WebElement ProductNameField;

    @FindBy(xpath = "//textarea[@id='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "(//td[@class='w-2'])[1]")
    WebElement rowContextButton;

    @FindBy(xpath = "//button[contains(text(),'Active')]")
    WebElement activeStatusButton;

    @FindBy(xpath = "//*[.='Click the button to see table']")
    WebElement tableMessage;

    @FindBy(xpath = "//*[.='Client 1']")
    WebElement client1;



    // END: ProductPage elements

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkProductPageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(ProductLink);
            step++;
            System.out.println("Step " + step + ": Click on Product link");
            return driverWaits.waitUntilVisible(10, ProductTitle);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkTableMessage() {
        try {

            driverWaits.waitUntilVisible(10, tableMessage);
            Assert.assertTrue(tableMessage.isDisplayed(), "Table message is not displayed");

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkShowTableButtonFunctionality() {
        try {
            int step = 0;
            driverWaits.waitFiveSeconds();
            driverActions.clickOnWebElementWithActionsClass(showTableButton);
            step++;
            System.out.println("Step " + step + ": Click on Show Table button");
            return driverWaits.waitUntilVisible(10, nameColumn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkShowTableButtonHidesTheTableOnSecondClick() {
           try {
                int step = 0;
                driverActions.clickOnWebElementWithActionsClass(showTableButton);
                step++;
                System.out.println("Step " + step + ": Click on Show Table button");

                return driverActions.waitUntilInvisibilityOfElement(nameColumn);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean checkSearchInputFieldShowingOnShowTableButtonClick() {
            try {
                int step = 0;
                driverActions.clickOnWebElementWithActionsClass(showTableButton);
                step++;
                System.out.println("Step " + step + ": Click on Show Table button");

                return driverWaits.waitUntilVisible(10, searchBox);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean checkContextMenuButtonWorkingForTableRows() {
            try {
                int step = 0;

                driverActions.refreshPage();
                step++;
                System.out.println("Step " + step + ": Refresh page");

                driverActions.clickOnWebElementWithActionsClass(showTableButton);
                step++;
                System.out.println("Step " + step + ": Click on Show Table button");

                driverActions.clickOnWebElementWithActionsClass(rowContextButton);
                step++;
                System.out.println("Step " + step + ": Click on Context Menu button");

                return driverWaits.waitUntilVisible(10, activeStatusButton);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean checkAllTableColumnsAreVisible() {
            try {
                int step = 0;

                driverActions.refreshPage();
                step++;
                System.out.println("Step " + step + ": Refresh page");

                driverActions.clickOnWebElementWithActionsClass(showTableButton);
                step++;
                System.out.println("Step " + step + ": Click on Show Table button");

                return driverWaits.waitUntilVisible(10, nameColumn) &&
                        driverWaits.waitUntilVisible(10, clientNameColumn) &&
                        driverWaits.waitUntilVisible(10, descriptionColumn) &&
                        driverWaits.waitUntilVisible(10, statusColumn);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean checkAddProductButtonFunctionality() {
            try {
                int step = 0;

                driverActions.refreshPage();
                step++;
                System.out.println("Step " + step + ": Refresh page");

                driverActions.clickOnWebElementWithActionsClass(addProductButton);
                step++;
                System.out.println("Step " + step + ": Click on Add Product button");

                return driverWaits.waitUntilVisible(10, addProductDialogTitle);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean checkCancelButtonFunctionalityOnAddProductPage() {
            try {
                int step = 0;

                driverActions.clickOnWebElementWithActionsClass(cancelButton);
                step++;
                System.out.println("Step " + step + ": Click on Cancel button");

                return driverActions.waitUntilInvisibilityOfElement(addProductDialogTitle);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean checkAddProductFormGetsFillUpCorrectly() {
            try {
                int step = 0;

                driverActions.clickOnWebElementWithActionsClass(addProductButton);
                step++;
                System.out.println("Step " + step + ": Click on Add Product button");

                driverActions.clickOnWebElementWithActionsClass(clientNameDropdown);
                step++;
                System.out.println("Step " + step + ": Click on Client Name dropdown");

                driverActions.clickOnWebElementWithActionsClass(client1);
                step++;
                System.out.println("Step " + step + ": Click on Client 1");

                driverActions.typeText(ProductNameField, "Test Product");
                step++;
                System.out.println("Step " + step + ": Enter Product Name");

                driverActions.typeText(descriptionField, "Test Description");
                step++;
                System.out.println("Step " + step + ": Enter Description");

                driverActions.clickOnWebElementWithActionsClass(saveButton);
                step++;
                System.out.println("Step " + step + ": Click on Save button");

                return driverActions.waitUntilInvisibilityOfElement(addProductDialogTitle);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
}
