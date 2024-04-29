import application.actions.Action_RewardsPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class RewardsPageTest extends BaseTest{

    Page _rewardsPage = page;

    @Test(description = "names of merchandise on rewards page")
    public void verifyNamesOfMerchandiseAreDisplayedOnRewardsPageAndPrintThem(){
        new Action_RewardsPage(_rewardsPage).
                verifyNameOfMerchandiseAreDisplayedAndPrintThem();
    }

    @Test(description = "verify merchandise details")
    public void verifyMerchandiseDetailsForWearableProductsAreDisplayedUponClickOnMerchandise(){
       new Action_RewardsPage(_rewardsPage).
               verifyProductDetailsDisplayedForWearables();
    }

    @Test(description = "verify merchandise details for utility items")
    public void verifyMerchandiseDetailsForUtilityProductsAreDisplayedUponClickOnMerchandise(){
        new Action_RewardsPage(_rewardsPage).
                verifyProductDetailsDisplayedForUtilityItems();
    }

}
