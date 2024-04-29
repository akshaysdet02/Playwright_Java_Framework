
import application.actions.Action_LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BaseTest.class)
public class LoginTests extends BaseTest{
     Page _loginPage = page;


    @Test(description = "Test to check coditas login page is displayed",priority = 1)
    public void Verify_Coditas_Clap_Login_Page_Is_Displayed_Upon_Launching_Url(){
        new Action_LoginPage(_loginPage).
                VerifyUserIsOnLoginPage();
    }

    @Test(description = "login test",priority = 2)
    public void Verify_user_Is_Able_To_Login_With_Valid_Credentials() {
        new Action_LoginPage(_loginPage).
                VerifyUserIsAbleToLoginIntoCoditasClap();
    }

    @AfterClass
    public void logOut(){

    }

}
