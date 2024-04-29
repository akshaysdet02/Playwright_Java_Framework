package application.actions;
import application.pages.HomePage;
import application.verification.V_HomePage;
import application.verification.V_RewardsPage;
import com.microsoft.playwright.Page;
import utils.ConfigLoader;

public class Action_HomePage {
    HomePage _homePage;
    V_HomePage v_homePage;

    V_RewardsPage v_rewardsPage;

    public Action_HomePage(Page page) {
        _homePage = new HomePage(page);
        v_homePage = new V_HomePage(page);
        v_rewardsPage = new V_RewardsPage(page);

    }

    public Action_HomePage verifyUserIsOnHomePage() {
        _homePage.clickOnHomePageTab();
        v_homePage.verify_user_is_on_homePage();
        return this;
    }

    public Action_HomePage verifyCorrectUsernameAndDesignationIsDisplayedOnHomePage() {
        String actualUserName = _homePage.getUserNameDisplayedOnHomePage();
        String actualDesignation = _homePage.getUserDesignationDisplayedOnHomePage();
        v_homePage.verifyUserNameDisplayedIsValid(ConfigLoader.getInstance().getUserName(), actualUserName);
        v_homePage.verifyUserDesignationDisplayedIsValid(ConfigLoader.getInstance().getDesignation(), actualDesignation);
        return this;
    }

    public Action_HomePage verifyCurrentMonthIsDisplayedInTopEarnersHeading(){
        String actualMonthDisplayed = _homePage.getMonthDisplayedInTopEarnersHeading();
        String currentMonth = _homePage.getCurrentMonth();
        v_homePage.verifyCurrentMonthIsDisplayedInTopEarnersHeading(currentMonth,actualMonthDisplayed);
        return this;
    }

    public Action_HomePage verifyRewardPointsAreDisplayedBeforeRewardPointsLabel(){
        v_homePage.verifyRewardPointsAreDisplayedWithLabelAndIsNumeric();
        return this;
    }

    public Action_HomePage verifyMerchandiseRedeemedIsDisplayedBeforeMerchandiseRedeemedLabel(){
        v_homePage.verifyMerchandiseRedeemedIseDisplayedWithLabelAndIsNumeric();
        return this;
    }

    public Action_HomePage verifyNamesAndDesignationOfTopEarnersIsDisplayedUnderTopEarnersSectionAndPrintThem(){
        v_homePage.verifyTopEarnersNamesAndDesignationIsDisplayedInTopEarnersSectionIsNotNull();
        _homePage.printNamesOfTopEarnersAndTheirDesignation();
        return this;
    }

    public Action_HomePage verifyUserIsDirectedToRewardsPageUponClickingOnReedemNowCta(){
        v_homePage.verify_user_is_on_homePage();
        _homePage.clickOnRedeemNow();
        v_rewardsPage.verify_user_is_on_rewardsPage();
        return this;
    }

}
