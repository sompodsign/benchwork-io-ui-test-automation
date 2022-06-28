package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;
import testdata.TestData;

public class TechnicalManagerPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: TechnicalTeamPage elements
    @FindBy(xpath = "//span[normalize-space()='Technical Manager']")
    WebElement technicalManagerLink;

    @FindBy(xpath = "//h4[normalize-space()='Technical Manager']")
    WebElement technicalManagerHeader;

    @FindBy(xpath = "//button[normalize-space()='Invite Technical Manager']")
    WebElement inviteTechnicalManagerButton;

    @FindBy(xpath = "//*[.='Invite Client Technical Manager']")
    WebElement inviteTechnicalManagerModal;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//button[normalize-space()='Back']")
    WebElement backButton;

    @FindBy(xpath = "//div[contains(text(),'an invite has been sent to')]")
    WebElement inviteTechnicalTeamSuccessMessage;

    @FindBy(xpath = "//*[contains(text(), 'Please enter TechnicalTeam business manage')]")
    WebElement inviteTechnicalTeamBusinessManagerErrorMessage;

    // END: TechnicalTeamPage elements

    public TechnicalManagerPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkTechnicalTeamPageLoaded() {
        try {
            driverActions.clickOnWebElementWithActionsClass(technicalManagerLink);
            return driverWaits.waitUntilVisible(20, technicalManagerHeader);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkInviteTechnicalTeamButtonFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(inviteTechnicalManagerButton);
            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTechnicalManagerModal),
                    "Invite Technical TechnicalTeam Manager Modal is not loaded successfully");
            step++;
            System.out.println("Step " + step + ": Invite TechnicalTeam Business Manager Modal loaded successfully");

            driverActions.clickOnWebElementWithActionsClass(backButton);
            Assert.assertTrue(driverActions.waitUntilInvisibilityOfElement(inviteTechnicalManagerModal),
                    "Invite TechnicalTeam Business Manager Modal is not closed successfully");

            step++;
            System.out.println("Step " + step + ": Invite Teachnical TechnicalTeam Manager Modal closed successfully");

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUserCantSubmitEmptyInvitation() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(inviteTechnicalManagerButton);
            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTechnicalManagerButton),
                    "Invite TechnicalTeam Business Manager Modal is not loaded successfully");
            step++;
            System.out.println("Step " + step + ": Invite TechnicalTeam Business Manager Modal loaded successfully");

            driverActions.clickOnWebElementWithActionsClass(sendButton);
            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTechnicalManagerButton),
                    "Invite TechnicalTeam Business Manager Error Message is not loaded successfully");
            step++;
            System.out.println("Step " + step + ": Invite TechnicalTeam Business Manager Error Message loaded successfully");

            driverActions.clickOnWebElementWithActionsClass(backButton);
            Assert.assertTrue(driverActions.waitUntilInvisibilityOfElement(inviteTechnicalManagerModal),
                    "Invite TechnicalTeam Business Manager Modal is not closed successfully");

            step++;
            System.out.println("Step " + step + ": Invite TechnicalTeam Business Manager Modal closed successfully");

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkInvitationSendFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(inviteTechnicalManagerButton);
            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTechnicalManagerButton),
                    "Invite TechnicalTeam Business Manager Modal is not loaded successfully");
            step++;
            System.out.println("Step " + step + ": Invite TechnicalTeam Business Manager Modal loaded successfully");

            driverActions.typeText(emailField, TestData.getRandomEmail());
            driverActions.clickOnWebElementWithActionsClass(sendButton);
            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTechnicalManagerButton),
                    "Invite TechnicalTeam Success Message is not loaded successfully");
            step++;
            System.out.println("Step " + step + ": Invite TechnicalTeam Success Message loaded successfully");

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
