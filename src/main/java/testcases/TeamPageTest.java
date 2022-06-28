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
}