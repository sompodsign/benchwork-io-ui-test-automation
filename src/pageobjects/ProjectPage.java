package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;
import testdata.TestData;

public class ProjectPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: ProjectPage elements
    @FindBy(xpath = "//span[normalize-space()='Project']")
    WebElement projectLink;

    @FindBy(xpath = "//h4[normalize-space()='Your Project']")
    WebElement projectTitle;

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

    @FindBy(xpath = "//button[normalize-space()='Add Project']")
    WebElement addProjectButton;

    @FindBy(xpath = "//h3[@id='headlessui-dialog-title-:rlj:']")
    WebElement addProjectDialogTitle;

    @FindBy(xpath = "//button[@id='headlessui-listbox-button-:rll:']")
    WebElement clientNameDropdown;

    @FindBy(xpath = "//input[@id='projectName']")
    WebElement projectNameField;

    @FindBy(xpath = "//textarea[@id='description']")
    WebElement descriptionField;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;



    // END: ProjectPage elements

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkProjectPageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(projectLink);
            step++;
            System.out.println("Step " + step + ": Click on Project link");
            return driverWaits.waitUntilVisible(10, projectTitle);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
