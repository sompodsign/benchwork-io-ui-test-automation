package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helper.DriverActions;
import helper.DriverWaits;
import pages.PagesFactory;

public class HomePage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    // START: Homepage elements
    @FindBy(xpath = "//h4[normalize-space()='Welcome to Consultant Management']")
    WebElement welcomeMessage;
    // END: Homepage elements

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkHomePageLoaded() {
        try {
            return driverWaits.waitUntilVisible(20, welcomeMessage);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}