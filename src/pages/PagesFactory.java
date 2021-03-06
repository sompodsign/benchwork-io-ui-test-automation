

package pages;

import org.openqa.selenium.support.PageFactory;

import helper.DriverActions;

import helper.DriverWaits;

import pageobjects.*;
import browserutility.Browser;

public final class PagesFactory {

    private static <T> T GetPage(Class<T> className) {
        return PageFactory.initElements(Browser.getWebDriver(), className);
    }

    public static DriverActions getDriverActionsObject() {
        return GetPage(DriverActions.class);
    }

    public static DriverWaits getDriverWaitsObject() {
        return GetPage(DriverWaits.class);
    }

    public static HomePage getHomePage() {
        return GetPage(HomePage.class);
    }

    public static RegistrationPage getRegistrationPage() {return GetPage(RegistrationPage.class);}

    public static LoginPage getLoginPage() {return GetPage(LoginPage.class);}

    public static DashboardPage getDashboardPage() {return GetPage(DashboardPage.class);}

    public static TeamPage getTeamPage() {return GetPage(TeamPage.class);}

    public static TechnicalManagerPage getTechnicalTeamPage() {return GetPage(TechnicalManagerPage.class);}

    public static ProjectPage getProjectPage() {return GetPage(ProjectPage.class);}

    public static OsPage getOsPage() {return GetPage(OsPage.class);}

    public static ProfilePage getProfilePage() {return GetPage(ProfilePage.class);}

    public static ManageRequestsPage getManageRequestsPage() {return GetPage(ManageRequestsPage.class);}

    public static ClientPage getClientPage() {return GetPage(ClientPage.class);}

    public static ProductPage getProductPage() {return GetPage(ProductPage.class);}

    public static SkillPage getSkillPage() {return GetPage(SkillPage.class);}


}
