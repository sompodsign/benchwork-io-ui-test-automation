package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;
import testdata.TestData;

public class TeamPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: TeamPage elements
    @FindBy(xpath = "//span[normalize-space()='Teams']")
    WebElement teamLink;

    @FindBy(xpath = "//h4[normalize-space()='Teams']")
    WebElement teamHeader;

    @FindBy(xpath = "//button[normalize-space()='Invite Team']")
    WebElement inviteTeamButton;

    @FindBy(xpath = "//*[.='Invite Team Business Manager']")
    WebElement inviteTeamBusinessManagerModal;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//button[normalize-space()='Back']")
    WebElement backButton;

    @FindBy(xpath = "//div[contains(text(),'an invite has been sent to')]")
    WebElement inviteTeamSuccessMessage;

    @FindBy(xpath = "//*[contains(text(), 'Please enter team business manage')]")
    WebElement inviteTeamBusinessManagerErrorMessage;

    // END: TeamPage elements

    public TeamPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkTeamPageLoaded() {
        try {
            driverActions.clickOnWebElementWithActionsClass(teamLink);
            return driverWaits.waitUntilVisible(20, teamHeader);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkInviteTeamButtonFunctionality() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(inviteTeamButton);
            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTeamBusinessManagerModal),
                    "Invite Team Business Manager Modal is not loaded successfully");
            step++;
            System.out.println("Step " + step + ": Invite Team Business Manager Modal loaded successfully");

            driverActions.clickOnWebElementWithActionsClass(backButton);
            Assert.assertTrue(driverActions.waitUntilInvisibilityOfElement(inviteTeamBusinessManagerModal),
                    "Invite Team Business Manager Modal is not closed successfully");

            step++;
            System.out.println("Step " + step + ": Invite Team Business Manager Modal closed successfully");

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUserCantSubmitEmptyInvitation() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(inviteTeamButton);
            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTeamBusinessManagerModal),
                    "Invite Team Business Manager Modal is not loaded successfully");
            step++;
            System.out.println("Step " + step + ": Invite Team Business Manager Modal loaded successfully");

            driverActions.clickOnWebElementWithActionsClass(sendButton);
            step++;
            System.out.println("Step " + step + ": clicked send button");

            return driverActions.waitUntilInvisibilityOfElement(inviteTeamBusinessManagerModal);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkInvitationSendFunctionality() {
        try {
            int step = 0;

//            driverWaits.waitFiveSeconds();
//            driverActions.clickOnWebElementWithActionsClass(inviteTeamButton);
//            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTeamBusinessManagerModal),
//                    "Invite Team Business Manager Modal is not loaded successfully");
//            step++;
//            System.out.println("Step " + step + ": Invite Team Business Manager Modal loaded successfully");

            driverActions.typeText(emailField, TestData.getRandomEmail());
            driverActions.clickOnWebElementWithActionsClass(sendButton);
            Assert.assertTrue(driverWaits.waitUntilVisible(20, inviteTeamSuccessMessage),
                    "Invite Team Success Message is not loaded successfully");
            step++;
            System.out.println("Step " + step + ": Invite Team Success Message loaded successfully");

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
