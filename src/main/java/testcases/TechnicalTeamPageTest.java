package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TechnicalManagerPage;
import pages.PagesFactory;


public class TechnicalTeamPageTest extends BaseTest {
    TechnicalManagerPage technicalManagerPage;

    @Test(priority = 1)
    public void validateTeamPageLoadSuccessfully() {
        try {
            initializeTest("TeamPage loading test",
                    "This test verifies that the Technical team page is loaded successfully",
                    "Integration Testing");

            technicalManagerPage = PagesFactory.getTechnicalTeamPage();
            boolean result = technicalManagerPage.checkTechnicalTeamPageLoaded();
            Assert.assertTrue(result, "Technical team  is not loaded successfully");
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

            technicalManagerPage = PagesFactory.getTechnicalTeamPage();
            boolean result = technicalManagerPage.checkInviteTechnicalTeamButtonFunctionality();
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

            technicalManagerPage = PagesFactory.getTechnicalTeamPage();
            boolean result = technicalManagerPage.checkUserCantSubmitEmptyInvitation();
            Assert.assertTrue(result, "User can submit empty invitation");
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

            technicalManagerPage = PagesFactory.getTechnicalTeamPage();
            boolean result = technicalManagerPage.checkInvitationSendFunctionality();
            Assert.assertTrue(result, "Invitation send functionality is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}