package application.pageSelectors;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePageSelectors {

    public static String homePageTab = "//a[text()='Home']";
    public static String userName = "//span[text()='Akshay Patil']";
    public static String designation = "//span[text()='SDET']";

    public static String topEarnersHeading = "//header[@class='if61Du25VpqyiM0LAfTs']/div";

    public static String myRewardPointsLabel ="//span[text()='My reward points']";
    public static String userRewardPoints =  "//span[text()='My reward points']/following-sibling::span";
    public static String merchandiseRedeemedLabel =  "//span[text()='//span[text()='Merchandise redeemed till date']";
    public static String merchandiseRedeem = "//span[text()='Merchandise redeemed till date']/following-sibling::span";
    public static String namesAndDesignationOfTopEarners = "//div[@class='oS7kcv3wtvYRwoXFTwqy']/div";

    public static String redeemNowCta = "//span[text()='Redeem Now']";

}
