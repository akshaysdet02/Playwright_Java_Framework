package application.pages;

import application.pageSelectors.HomePageSelectors;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomePage extends AbstractPage {
    public HomePage(Page page) {
        super(page);
    }

    @Override
    public boolean isPageDisplayed() {
        return isElementVisible(HomePageSelectors.homePageTab);
    }

    @Override
    public boolean isTitleCorrect(String pageTitle) {
        return false;
    }

    public void clickOnHomePageTab(){
        clickSafe(HomePageSelectors.homePageTab);
    }

    public String getUserNameDisplayedOnHomePage(){
        return getWebElementText(HomePageSelectors.userName);
    }

    public String getUserDesignationDisplayedOnHomePage(){
        return getWebElementText(HomePageSelectors.designation);
    }

    public String getMonthDisplayedInTopEarnersHeading(){
        return getWebElementText(HomePageSelectors.topEarnersHeading);
    }

    public String getRewardPoints(){
        return getWebElementText(HomePageSelectors.userRewardPoints);
    }

    public String getRedeemedMerchandise(){
        return getWebElementText(HomePageSelectors.merchandiseRedeem);
    }

    public boolean checkRewardPointsLabelIsDisplayedOnHomePage(){
        return isElementVisible(HomePageSelectors.myRewardPointsLabel);
    }

    public boolean checkMerchandiseRedeemedLabelIsDisplayedOnHomePage(){
        return isElementVisible(HomePageSelectors.merchandiseRedeemedLabel);
    }

    public boolean verifyRewardPointIsNumeric(){
        return isNumeric(getRewardPoints());
    }

    public boolean verifyMerchandiseRedeemedIsNumeric(){
        return isNumeric(getRedeemedMerchandise());
    }

    public HashMap<String,String> getNamesAndDesignationOfTopEarnersOfCurrentMonth(){
        HashMap<String,String> namesAndDesignation = new HashMap<>();
        List<String> listOfNamesAndDesignations = getListOfTextOfElements((HomePageSelectors.namesAndDesignationOfTopEarners));
        for(int i=0 ;i<listOfNamesAndDesignations.size();i+=1){
            for(int j = i ;j<=i+1;j++){
                namesAndDesignation.put(listOfNamesAndDesignations.get(j),listOfNamesAndDesignations.get(j+1));
            }
        }
        return namesAndDesignation;
    }

    public void printNamesOfTopEarnersAndTheirDesignation(){
        HashMap<String,String> nameOfTopEarnersAndDesignation = getNamesAndDesignationOfTopEarnersOfCurrentMonth();
        Iterator<Map.Entry<String,String>> it = nameOfTopEarnersAndDesignation.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next().getKey()+", "+it.next().getValue());
        }
    }

    public void clickOnRedeemNow(){
        clickSafe(HomePageSelectors.redeemNowCta);
    }
}
