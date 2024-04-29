package application.pageSelectors;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPageSelectors {


    //method to initialize all locators

    public static String googleBtnIframe = "iframe[title='Sign in with Google Button']";
    public static String signInGoogleBtn = "(//span[text()='Sign in with Google'])[1]";
    public static String userName = "//input[@type='email']";
    public static String password = "//input[@type='password']";
    public static String nextBtn = "//span[text()='Next']";
    public static String coditasClapLogo = "//div[@class='name-logo-container']/img";

    public static String profileNavigationButton = "button.profile-navigator-button";
    public static String logoutButton = "//div[text()='Log out']";



}


