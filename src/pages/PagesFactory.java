

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


}
