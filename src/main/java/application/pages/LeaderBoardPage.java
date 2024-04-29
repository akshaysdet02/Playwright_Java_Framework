package application.pages;

import com.microsoft.playwright.Page;

public class LeaderBoardPage extends AbstractPage{

    public LeaderBoardPage(Page pageObject) {
        super(pageObject);
    }

    @Override
    public boolean isPageDisplayed() {
        return false;
    }

    @Override
    public boolean isTitleCorrect(String pageTitle) {
        return false;
    }
}
