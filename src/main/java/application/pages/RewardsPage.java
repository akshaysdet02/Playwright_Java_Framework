package application.pages;

import application.pageSelectors.HomePageSelectors;
import application.pageSelectors.RewardsPageSelectors;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class RewardsPage extends AbstractPage {

    public RewardsPage(Page pageObject) {
        super(pageObject);
    }

    @Override
    public boolean isPageDisplayed() {
        return isElementVisible(RewardsPageSelectors.redeemLabel);
    }

    @Override
    public boolean isTitleCorrect(String pageTitle) {
        return false;
    }

    public void clickOnRewardsPageTab(){
        clickSafe(RewardsPageSelectors.rewardsTab);
    }

    public void printNamesOfMerchandiseDisplayedOnRewardsPage() {
        getNamesOfAllMerchandiseOnRewardsPage().forEach(System.out::println);
    }

    public List<String> getNamesOfAllMerchandiseOnRewardsPage() {
        waitForSelector(RewardsPageSelectors.merchandiseProducts);
        return getListOfTextOfElements(RewardsPageSelectors.merchandiseProducts);
    }

    public void selectMerchandiseOnRewardsPage(String merchandiseName) {
        List<ElementHandle> merchandiseElements = getListOfElements(RewardsPageSelectors.merchandiseProducts);
        for (ElementHandle elementHandle : merchandiseElements) {
            String elementText = elementHandle.textContent();
            if(elementText.equalsIgnoreCase(merchandiseName))  elementHandle.click();
        }
    }

    public boolean verifyMerchandiseDetailsForWearablesAreDisplayed(){
        return isElementVisible(RewardsPageSelectors.merchandisePoints) &&
                isElementVisible(RewardsPageSelectors.selectSizeLabel) &&
                isElementVisible(RewardsPageSelectors.selectQuantityLabel) &&
                isElementVisible(RewardsPageSelectors.defaultQuantity) &&
                isElementVisible(RewardsPageSelectors.decreaseQuantityButton) &&
                elementIsEnable(RewardsPageSelectors.increaseQuantityButton) &&
                elementIsEnable(RewardsPageSelectors.sizeChart);
    }

   public boolean verifyMerchandiseDetailsForUtilityItemsAreDisplayed(){
        return  isElementVisible(RewardsPageSelectors.merchandisePoints) &&
                isElementVisible(RewardsPageSelectors.selectQuantityLabel) &&
                isElementVisible(RewardsPageSelectors.defaultQuantity) &&
                isElementVisible(RewardsPageSelectors.decreaseQuantityButton) &&
                elementIsEnable(RewardsPageSelectors.increaseQuantityButton) ;
   }

   public void closeMerchandiseDetailPopup(){
        clickSafe(RewardsPageSelectors.merchandiseDetailsCloseBtn);
   }

}
