package application.verification;
import application.pages.RewardsPage;
import com.microsoft.playwright.Page;

import java.util.Objects;

public class V_RewardsPage extends V_Base{
    RewardsPage _page;
     public V_RewardsPage(Page page){
         _page = new RewardsPage(page);
     }

    public void verify_user_is_on_rewardsPage(){
        verifyConditionIsTrue(_page.isPageDisplayed());
    }

    public void verifyListOfMerchandiseDisplayedOnRewardsPageIsNotNull(){
       verifyConditionIsTrue(Objects.nonNull(_page.getNamesOfAllMerchandiseOnRewardsPage()));
    }

    public void verifyMerchandiseDetailsAreDisplayedForWearables(){
         verifyConditionIsTrue(_page.verifyMerchandiseDetailsForWearablesAreDisplayed());
    }
    public void verifyMerchandiseDetailsAreDisplayedForUtilities(){
         verifyConditionIsTrue(_page.verifyMerchandiseDetailsForUtilityItemsAreDisplayed());
    }


}
