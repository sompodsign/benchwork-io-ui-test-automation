package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ProjectPage;
import pageobjects.TechnicalManagerPage;
import pages.PagesFactory;


public class ProjectPageTest extends BaseTest {
    ProjectPage projectPage;

    @Test(priority = 1)
    public void validateProjectPageLoadSuccessfully() {
        try {
            initializeTest("ProjectPage loading test",
                    "This test verifies that the Project page is loaded successfully",
                    "Integration Testing");

            projectPage = PagesFactory.getProjectPage();
            boolean result = projectPage.checkProjectPageLoaded();
            Assert.assertTrue(result, "Project page is not loaded successfully");
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

            projectPage = PagesFactory.getProjectPage();
            boolean result = projectPage.checkTableMessage();
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

            projectPage = PagesFactory.getProjectPage();
            boolean result = projectPage.checkShowTableButtonFunctionality();
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

            projectPage = PagesFactory.getProjectPage();
            boolean result = projectPage.checkShowTableButtonHidesTheTableOnSecondClick();
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

            projectPage = PagesFactory.getProjectPage();
            boolean result = projectPage.checkSearchInputFieldShowingOnShowTableButtonClick();
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

            projectPage = PagesFactory.getProjectPage();
            boolean result = projectPage.checkContextMenuButtonWorkingForTableRows();
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

            projectPage = PagesFactory.getProjectPage();
            boolean result = projectPage.checkAllTableColumnsAreVisible();
            Assert.assertTrue(result, "All table columns are not visible");
        } catch (Exception e) {
            e.printStackTrace();
    }

}