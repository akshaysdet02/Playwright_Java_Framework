package application.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.Page;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPage {

    protected final Page page;

    public AbstractPage(Page pageObject) {
        this.page = pageObject;
    }

    public abstract boolean isPageDisplayed();

    public abstract boolean isTitleCorrect(String pageTitle);

    public void waitForPageLoad() {
        page.waitForLoadState(LoadState.LOAD);
    }

    public Page switchToPage(int windowNumber) {
        return this.page.context().pages().get(windowNumber);
    }

    public String getWebElementText(String selector) {
        return page.waitForSelector(selector).textContent();
    }

    public boolean isElementVisible(String selector) {
        boolean flag = false;
        try{
          flag = page.waitForSelector(selector).isVisible();
        }
        catch (Exception ae){
            System.out.println("Element is not visible in 30 secs with selector: "+selector);
        }
        return flag;
    }

    public void clickSafe(String selector) {
        page.waitForSelector(selector).click();

    }

    public void waitForSelector(String selector) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(40000));
    }

    public void fillTextInField(String selector, String text) {
        page.waitForSelector(selector).fill(text);
    }

    public String getCurrentMonth() {
        LocalDate currentDate = LocalDate.now();
        return String.valueOf(Month.valueOf(currentDate.getMonth().toString()));
    }

    public boolean isNumeric(String numericString) {
        return numericString.matches("[0-9]+");
    }

    public List<String> getListOfTextOfElements(String querySelector) {
        List<ElementHandle> elements = null;
        List<String> listOfElementText = null;

        try {
            elements = page.querySelectorAll(querySelector);
            listOfElementText = new ArrayList<>();
            for (ElementHandle element : elements) {
                listOfElementText.add(element.textContent());
            }
        } catch (NullPointerException ne) {
            System.out.println("list of elements is null, check querySelector: " + querySelector);
            ne.printStackTrace();
        }

        return listOfElementText;
    }

    public List<ElementHandle> getListOfElements(String querySelector) {
        waitForSelector(querySelector);
        List<ElementHandle> elements = null;
        try {
            elements = page.querySelectorAll(querySelector);

        } catch (NullPointerException ne) {
            System.out.println("list of elements is null, check querySelector: " + querySelector);
            ne.printStackTrace();
        }

      return elements;
    }

    public boolean elementIsEnable(String selector){
        waitForSelector(selector);
        return page.waitForSelector(selector).isEnabled();
    }


}

