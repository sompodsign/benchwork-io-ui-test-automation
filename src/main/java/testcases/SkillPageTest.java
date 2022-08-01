package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SkillPage;
import pages.PagesFactory;


public class SkillPageTest extends BaseTest {
    SkillPage SkillPage;

    @Test(priority = 1)
    public void validateSkillPageLoadSuccessfully() {
        try {
            initializeTest("SkillPage loading test",
                    "This test verifies that the Skill page is loaded successfully",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkSkillPageLoaded();
            Assert.assertTrue(result, "Skill page is not loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void validateTableMessage() {
        try {
            initializeTest("Table message test",
                    "This test verifies that the table message is displayed",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkTableMessage();
            Assert.assertTrue(result, "Table message is not displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void validateShowTableButtonFunctionality() {
        try {
            initializeTest("Show Table Button Functionality",
                    "This test verifies that the Show Table Button Functionality is working",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkShowTableButtonFunctionality();
            Assert.assertTrue(result, "Show Table Button Functionality is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void validateShowTableButtonHidesTheTableOnSecondClick() {
        try {
            initializeTest("Show Table Button hides the table on second click",
                    "This test verifies that the Show Table Button hides the table on second click",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkShowTableButtonHidesTheTableOnSecondClick();
            Assert.assertTrue(result, "Show Table Button hides the table on second click");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void validateSearchInputFieldShowingOnShowTableButtonClick() {
        try {
            initializeTest("Search input field showing on Show Table Button click",
                    "This test verifies that the Search input field showing on Show Table Button click",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkSearchInputFieldShowingOnShowTableButtonClick();
            Assert.assertTrue(result, "Search input field showing on Show Table Button click");
        } catch (Exception e) {
            e.printStackTrace();
    }}

    @Test(priority = 6)
    public void validateContextMenuButtonWorkingForTableRows() {
        try {
            initializeTest("Context menu button working for table rows",
                    "This test verifies that the Context menu button working for table rows",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkContextMenuButtonWorkingForTableRows();
            Assert.assertTrue(result, "Context menu button working for table rows");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 7)
    public void validateAllTableColumnsAreVisible() {
        try {
            initializeTest("All table columns are visible",
                    "This test verifies that all table columns are visible",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkAllTableColumnsAreVisible();
            Assert.assertTrue(result, "All table columns are not visible");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8)
    public void validateAddSkillFunctionality() {
        try {
            initializeTest("Add Skill Button Functionality",
                    "This test verifies that the Add Skill Button Functionality is working",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkAddSkillButtonFunctionality();
            Assert.assertTrue(result, "Add Skill Button Functionality is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9)
    public void validateCancelButtonFunctionalityOnAddSkillPage() {
        try {
            initializeTest("Cancel Button Functionality on Add Skill Page",
                    "This test verifies that the Cancel Button Functionality on Add Skill Page is working",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkCancelButtonFunctionalityOnAddSkillPage();
            Assert.assertTrue(result, "Cancel Button Functionality on Add Skill Page is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10)
    public void validateAddSkillFormGetsFillUpCorrectly() {
        try {
            initializeTest("Add Skill Form gets fill up correctly",
                    "This test verifies that the Add Skill Form gets fill up correctly",
                    "Integration Testing");

            SkillPage = PagesFactory.getSkillPage();
            boolean result = SkillPage.checkAddSkillFormGetsFillUpCorrectly();
            Assert.assertTrue(result, "Add Skill Form gets fill up correctly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}