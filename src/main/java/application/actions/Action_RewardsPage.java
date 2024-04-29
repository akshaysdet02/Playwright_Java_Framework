package application.actions;

import application.pages.RewardsPage;
import application.verification.V_RewardsPage;
import com.microsoft.playwright.Page;

public class Action_RewardsPage {
    RewardsPage rewardsPage;
    V_RewardsPage v_rewardsPage;

    public Action_RewardsPage(Page page){
        rewardsPage = new RewardsPage(page);
    }

    public Action_RewardsPage verifyNameOfMerchandiseAreDisplayedAndPrintThem(){
        rewardsPage.clickOnRewardsPageTab();
        v_rewardsPage.verify_user_is_on_rewardsPage();
        v_rewardsPage.verifyListOfMerchandiseDisplayedOnRewardsPageIsNotNull();
        rewardsPage.printNamesOfMerchandiseDisplayedOnRewardsPage();
        return this;
    }

    public Action_RewardsPage verifyProductDetailsDisplayedForWearables(){
        v_rewardsPage.verify_user_is_on_rewardsPage();
        rewardsPage.selectMerchandiseOnRewardsPage("Coditas Dark Blue Tshirt");
        v_rewardsPage.verifyMerchandiseDetailsAreDisplayedForWearables();
        rewardsPage.closeMerchandiseDetailPopup();
        return this;
    }

    public Action_RewardsPage verifyProductDetailsDisplayedForUtilityItems(){
        v_rewardsPage.verify_user_is_on_rewardsPage();
        rewardsPage.selectMerchandiseOnRewardsPage("Coditas Mug");
        v_rewardsPage.verifyMerchandiseDetailsAreDisplayedForUtilities();
        rewardsPage.closeMerchandiseDetailPopup();
        return this;
    }

}
