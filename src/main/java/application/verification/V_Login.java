package application.verification;

import application.pages.HomePage;
import application.pages.LoginPage;
import com.microsoft.playwright.Page;

public class V_Login extends V_Base{
    LoginPage _page;
    HomePage _hPage;
    public V_Login(Page page){
        _page = new LoginPage(page);
        _hPage = new HomePage(page);
    }


    public void Verify_User_Is_On_Login_Page(){
        verifyConditionIsTrue(_page.isPageDisplayed());
    }

    public void Verify_User_Is_Successfully_Logged_In(){
        verifyConditionIsTrue(_hPage.isPageDisplayed());
    }
}
