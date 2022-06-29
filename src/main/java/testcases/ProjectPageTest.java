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
}