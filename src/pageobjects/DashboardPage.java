package pageobjects;

import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;

import java.util.Random;

public class DashboardPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: Dashboard elements
    @FindBy(xpath = "//span[normalize-space()='Total Client']")
    WebElement totalClientCard;

    @FindBy(xpath = "//span[normalize-space()='Total Project']")
    WebElement totalProjectCard;

    @FindBy(xpath = "//span[normalize-space()='Total Product']")
    WebElement totalProductCard;

    @FindBy(xpath = "//span[normalize-space()='Total Vendor']")
    WebElement totalVendorCard;

    @FindBy(xpath = "//h4[normalize-space()='Language Summery']")
    WebElement languageSummarySection;

    @FindBy(xpath = "//h4[normalize-space()='Recent Consultant']")
    WebElement recentConsultantSection;

    @FindBy(xpath = "//td[normalize-space()='Name']")
    WebElement nameColumn;

    @FindBy(xpath = "//td[normalize-space()='Email']")
    WebElement emailColumn;

    @FindBy(xpath = "//td[normalize-space()='Role']")
    WebElement roleColumn;

    @FindBy(xpath = "//td[contains(text(),'Available')]")
    WebElement availableColumn;

    @FindBy(xpath = "(//td[@class='w-2'])[1]/div/div/button")
    WebElement editButton;

    @FindBy(xpath = "//button[contains(text(),'Active')]")
    WebElement activeButton;

    @FindBy(xpath = "//h4[normalize-space()='Recent Work Logs']")
    WebElement recentWorkLogsSection;

    @FindBy(xpath = "//button[normalize-space()='See All']")
    WebElement seeAllButton;

    @FindBy(xpath = "//td[normalize-space()='Ticket ID']")
    WebElement ticketIdColumn;

    @FindBy(xpath = "//td[normalize-space()='Date']")
    WebElement dateColumn;

    @FindBy(xpath = "//td[normalize-space()='Description']")
    WebElement descriptionColumn;

    @FindBy(xpath = "//td[normalize-space()='Start Time']")
    WebElement startTimeColumn;

    @FindBy(xpath = "//td[normalize-space()='End Time']")
    WebElement endTimeColumn;

    @FindBy(xpath = "//h4[normalize-space()='Recent Consultant']/following-sibling::div/button")
    WebElement filterButton;


    // END: Dashboard elements

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkDashboardPageLoaded() {
        return driver.getCurrentUrl().contains("dashboard");
    }

    public boolean checkTopCardsOnDashboard() {
        try {
            int step = 0;

            Assert.assertTrue(totalClientCard.isDisplayed(), "Total Client card is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Total Client card is displayed on Dashboard");
            Assert.assertTrue(totalProjectCard.isDisplayed(), "Total Project card is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Total Project card is displayed on Dashboard");
            Assert.assertTrue(totalProductCard.isDisplayed(), "Total Product card is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Total Product card is displayed on Dashboard");
            Assert.assertTrue(totalVendorCard.isDisplayed(), "Total Vendor card is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Total Vendor card is displayed on Dashboard");
            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkLanguageSummarySectionFunctionalities() {
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(10, languageSummarySection),
                    "Language Summary Section is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Language Summary Section is displayed on Dashboard");

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkRecentConsultantsSection() {
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(10, recentConsultantSection),
                    "Recent Consultants Section is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Recent Consultants Section is displayed on Dashboard");

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkRecentConsultantsSectionTable() {
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(10, recentConsultantSection),
                    "Recent Consultants Section is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Recent Consultants Section is displayed on Dashboard");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, nameColumn),
                    "Name column is not displayed on Recent Consultants Section");
            step++;
            System.out.println("Step " + step + ": Name column is displayed on Recent Consultants Section");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, emailColumn),
                    "Email column is not displayed on Recent Consultants Section");
            step++;
            System.out.println("Step " + step + ": Email column is displayed on Recent Consultants Section");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, roleColumn),
                    "Role column is not displayed on Recent Consultants Section");
            step++;
            System.out.println("Step " + step + ": Role column is displayed on Recent Consultants Section");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, availableColumn),
                    "Available column is not displayed on Recent Consultants Section");
            step++;
            System.out.println("Step " + step + ": Available column is displayed on Recent Consultants Section");

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkEditButtonFunctionalityForARow() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(editButton);
            step++;
            System.out.println("Step " + step + ": Click on Edit button");

            return driverWaits.waitUntilVisible(10, activeButton);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkRecentWorkLogsTable() {
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(10, recentWorkLogsSection),
                    "Recent Work Logs Section is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Recent Work Logs Section is displayed on Dashboard");

            driverActions.clickOnWebElementWithActionsClass(seeAllButton);
            step++;
            System.out.println("Step " + step + ": Click on See All button");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, ticketIdColumn),
                    "Ticket ID column is not displayed on Recent Work Logs Section");
            step++;
            System.out.println("Step " + step + ": Ticket ID column is displayed on Recent Work Logs Section");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, dateColumn),
                    "Date column is not displayed on Recent Work Logs Section");
            step++;
            System.out.println("Step " + step + ": Date column is displayed on Recent Work Logs Section");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, descriptionColumn),
                    "Description column is not displayed on Recent Work Logs Section");
            step++;
            System.out.println("Step " + step + ": Description column is displayed on Recent Work Logs Section");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, startTimeColumn),
                    "Start Time column is not displayed on Recent Work Logs Section");
            step++;
            System.out.println("Step " + step + ": Start Time column is displayed on Recent Work Logs Section");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, endTimeColumn),
                    "End Time column is not displayed on Recent Work Logs Section");
            step++;
            System.out.println("Step " + step + ": End Time column is displayed on Recent Work Logs Section");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, seeAllButton),
                    "See All button is not displayed on Recent Work Logs Section");
            step++;
            System.out.println("Step " + step + ": See All button is displayed on Recent Work Logs Section");

            driverActions.clickOnWebElementWithActionsClass(seeAllButton);
            step++;
            System.out.println("Step " + step + ": Click on See All button");

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkSeeAllButtonFunctionalityOfRecentWorkLogsSection() {
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(10, recentWorkLogsSection),
                    "Recent Work Logs Section is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Recent Work Logs Section is displayed on Dashboard");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, seeAllButton),
                    "See All button is not displayed on Recent Work Logs Section");
            step++;
            System.out.println("Step " + step + ": See All button is displayed on Recent Work Logs Section");

            driverActions.clickOnWebElementWithActionsClass(seeAllButton);
            step++;
            System.out.println("Step " + step + ": Click on See All button");

            return driverWaits.waitUntilVisible(10, ticketIdColumn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkRecentConsultantSectionFilterFunctionality() {
        try {
            int step = 0;

            Assert.assertTrue(driverWaits.waitUntilVisible(10, recentConsultantSection),
                    "Recent Consultants Section is not displayed on Dashboard");
            step++;
            System.out.println("Step " + step + ": Recent Consultants Section is displayed on Dashboard");

            Assert.assertTrue(driverWaits.waitUntilVisible(10, filterButton),
                    "Filter button is not displayed on Recent Consultants Section");
            step++;
            System.out.println("Step " + step + ": Filter button is displayed on Recent Consultants Section");

            driverActions.clickOnWebElementWithActionsClass(filterButton);
            step++;
            System.out.println("Step " + step + ": Click on Filter button");

            WebElement[] filterOptions = driver.findElements(By.xpath("//li[contains(.,'Option')]")).toArray(new WebElement[0]);
            driverActions.clickOnWebElementWithActionsClass(filterOptions[0]);
            step++;
            System.out.println("Step " + step + ": Click on Filter option");

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}