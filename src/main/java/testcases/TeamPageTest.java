package main.java.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PagesFactory;
import pageobjects.TeamPage;


public class TeamPageTest extends BaseTest {
    TeamPage teampage;

    @Test(priority = 1)
    public void validateTeamPageLoadSuccessfully() {
        try {
            initializeTest("TeamPage loading test",
                    "This test verifies that the homepage is loaded successfully",
                    "Integration Testing");

            teampage = PagesFactory.getTeamPage();
            boolean result = teampage.checkTeamPageLoaded();
            Assert.assertTrue(result, "Teampage is not loaded successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void validateInviteTeamButtonFunctionality() {
        try {
            initializeTest("Invite Team Button Functionality",
                    "This test verifies that the Invite Team Button Functionality is working",
                    "Integration Testing");

            teampage = PagesFactory.getTeamPage();
            boolean result = teampage.checkInviteTeamButtonFunctionality();
            Assert.assertTrue(result, "Invite Team Button Functionality is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void validateUserCantSubmitEmptyInvitation() {
        try {
            initializeTest("User can't submit empty invitation",
                    "This test verifies that the user can't submit empty invitation",
                    "Integration Testing");

            teampage = PagesFactory.getTeamPage();
            boolean result = teampage.checkUserCantSubmitEmptyInvitation();
            Assert.assertTrue(result, "User can't submit empty invitation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void validateInvitationSendFunctionality() {
        try {
            initializeTest("Invitation send functionality",
                    "This test verifies that the invitation send functionality is working",
                    "Integration Testing");

            teampage = PagesFactory.getTeamPage();
            boolean result = teampage.checkInvitationSendFunctionality();
            Assert.assertTrue(result, "Invitation send functionality is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}