import application.actions.Action_HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    Page _homePage = page;


    @Test(description = "To verify correct user name and designation is displayed on homepage")
    public void verify_valid_username_and_designation_is_displayed_on_homepage(){
         new Action_HomePage(_homePage).
                 verifyUserIsOnHomePage().
                 verifyCorrectUsernameAndDesignationIsDisplayedOnHomePage();
    }

    @Test(description = "verify current month is displayed on top earners heading")
    public void verify_current_month_is_displayed_on_top_earners_heading(){
        new Action_HomePage(_homePage).
                verifyCurrentMonthIsDisplayedInTopEarnersHeading();
    }

    @Test(description = "verify reward points and merchandise redeemed is present on profile card")
    public void verify_reward_points_and_merchandise_redeemed_along_with_valid_labels_are_displayed_on_profile_card_and_are_numeric(){
        new Action_HomePage(_homePage).
                verifyRewardPointsAreDisplayedBeforeRewardPointsLabel().
                verifyMerchandiseRedeemedIsDisplayedBeforeMerchandiseRedeemedLabel();
    }

    @Test
    public void verify_names_and_designations_of_top_earners_are_displayed_on_homepage(){
        new Action_HomePage(_homePage).
                verifyNamesAndDesignationOfTopEarnersIsDisplayedUnderTopEarnersSectionAndPrintThem();
    }

    @Test(description = "verify user is directed to rewards page upon clicking on Redeem Now cta")
    public void verify_rewards_page_is_displayed_upon_clicking_reedem_now_cta(){
        new Action_HomePage(_homePage).
                verifyUserIsDirectedToRewardsPageUponClickingOnReedemNowCta();
    }
}
