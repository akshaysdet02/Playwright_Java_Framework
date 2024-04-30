import application.actions.Action_LoginPage;
import application.actions.Action_RewardsPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BaseTest.class)
public class RewardsPageTest extends BaseTest{

    Page _rewardsPage = page;

    @BeforeClass
    public void loginToCoditasClap() {
        new Action_LoginPage(_rewardsPage).VerifyUserIsAbleToLoginIntoCoditasClap();
    }

    @Test(description = "names of merchandise on rewards page",priority = 9)
    public void verifyNamesOfMerchandiseAreDisplayedOnRewardsPageAndPrintThem(){
        new Action_RewardsPage(_rewardsPage).
                verifyNameOfMerchandiseAreDisplayedAndPrintThem();
    }

    @Test(description = "verify merchandise details",priority = 10)
    public void verifyMerchandiseDetailsForWearableProductsAreDisplayedUponClickOnMerchandise(){
       new Action_RewardsPage(_rewardsPage).
               verifyProductDetailsDisplayedForWearables();
    }

    @Test(description = "verify merchandise details for utility items",priority = 11)
    public void verifyMerchandiseDetailsForUtilityProductsAreDisplayedUponClickOnMerchandise(){
        new Action_RewardsPage(_rewardsPage).
                verifyProductDetailsDisplayedForUtilityItems();
    }

}
