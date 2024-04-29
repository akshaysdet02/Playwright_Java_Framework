package application.actions;

import application.pages.HomePage;
import application.pages.LoginPage;
import application.verification.V_HomePage;
import application.verification.V_Login;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class Action_LoginPage {
    LoginPage _loginPage;
    V_HomePage v_homePage;
    V_Login v_login;

    public Action_LoginPage(Page page) {
        _loginPage = new LoginPage(page);
        v_homePage = new V_HomePage(page);
        v_login = new V_Login(page);
    }

    public void launchUrl() {
        _loginPage.navigateToLoginPage();
    }

    public void VerifyUserIsOnLoginPage() {
        v_login.Verify_User_Is_On_Login_Page();
    }

    public void VerifyUserIsAbleToLoginIntoCoditasClap() {
        _loginPage.loginToCoditasClap();
        v_login.Verify_User_Is_Successfully_Logged_In();
    }

    public void logOutOfCoditasClap(){
        _loginPage.logOutFromCoditasClap();
        v_login.Verify_User_Is_On_Login_Page();

    }
}
