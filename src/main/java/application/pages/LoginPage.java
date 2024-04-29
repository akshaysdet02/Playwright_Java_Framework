package application.pages;

import application.pageSelectors.LoginPageSelectors;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.ConfigLoader;
import java.util.Objects;

public class LoginPage extends AbstractPage {
    public LoginPage(Page page) {
        super(page);
    }

    @Override
    public boolean isPageDisplayed() {
        return page.isVisible(LoginPageSelectors.coditasClapLogo);
    }

    @Override
    public boolean isTitleCorrect(String pageTitle) {
        String actualPageTitle = page.title();
        return Objects.equals(actualPageTitle, "Coditas Clap");
    }

    public void navigateToLoginPage() {
        page.navigate(ConfigLoader.getInstance().getUrl());
    }

    public void clickOnSignInWithGoogle() {
        FrameLocator fl =page.frameLocator(LoginPageSelectors.googleBtnIframe);
        Locator gButton= fl.locator(LoginPageSelectors.signInGoogleBtn);
        gButton.click();
        page.waitForTimeout(5000);
        page.mainFrame();
        System.out.println("number of windows: " + page.context().pages().size());
    }

    public void loginToCoditasClap() {
        clickOnSignInWithGoogle();
        page.waitForTimeout(2000);
        Page newPage = switchToPage(1);
        newPage.waitForSelector(LoginPageSelectors.userName).fill(ConfigLoader.getInstance().getEmailId());
        newPage.waitForSelector(LoginPageSelectors.nextBtn).click();
        newPage.waitForSelector(LoginPageSelectors.password).fill(ConfigLoader.getInstance().getPassword());
        newPage.waitForSelector(LoginPageSelectors.nextBtn).click();
        page.waitForTimeout(5000);
    }

    public void logOutFromCoditasClap() {
        clickSafe(LoginPageSelectors.profileNavigationButton);
        clickSafe(LoginPageSelectors.logoutButton);
    }

}
