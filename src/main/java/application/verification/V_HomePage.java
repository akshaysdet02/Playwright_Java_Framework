package application.verification;

import application.pages.HomePage;
import com.microsoft.playwright.Page;

import java.util.Objects;

public class V_HomePage extends V_Base {
    HomePage _page;
    public V_HomePage(Page page){
        _page = new HomePage(page);
    }

    public void verify_user_is_on_homePage(){
         verifyConditionIsTrue(_page.isPageDisplayed());
    }

    public void verifyUserNameDisplayedIsValid(String expectedUserName, String actualUserName){
        verifyEqual(expectedUserName, actualUserName);
    }
    public void verifyUserDesignationDisplayedIsValid(String expectedDesignation, String actualDesignation){
        verifyEqual(expectedDesignation, actualDesignation);
    }

    public void verifyCurrentMonthIsDisplayedInTopEarnersHeading(String currentMonth, String actualMonth){
        verifyEqual(currentMonth, actualMonth);
    }

    public void verifyRewardPointsAreDisplayedWithLabelAndIsNumeric(){
        verifyConditionIsTrue(_page.verifyRewardPointIsNumeric() && _page.checkRewardPointsLabelIsDisplayedOnHomePage());
    }

    public void verifyMerchandiseRedeemedIseDisplayedWithLabelAndIsNumeric(){
        verifyConditionIsTrue(_page.verifyMerchandiseRedeemedIsNumeric() && _page.checkMerchandiseRedeemedLabelIsDisplayedOnHomePage());
    }

    public void verifyTopEarnersNamesAndDesignationIsDisplayedInTopEarnersSectionIsNotNull(){
      verifyConditionIsTrue(Objects.nonNull(_page.getNamesAndDesignationOfTopEarnersOfCurrentMonth()));
    }
}
