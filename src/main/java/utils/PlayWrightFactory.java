package utils;

import com.microsoft.playwright.*;


public class PlayWrightFactory {
    private static final ThreadLocal<Page> browserThreadLocal = new ThreadLocal<>();
    private static Browser browser;

    public static Page getPlaywrightBrowser(){
        if (browserThreadLocal.get() == null) {
            browserThreadLocal.set(initializePlaywrightBrowser());
        }
        return browserThreadLocal.get();
    }

    public static Page initializePlaywrightBrowser() {
        String browserName = ConfigLoader.getInstance().getBrowserName();
        Playwright playwright = Playwright.create();
        switch(browserName.toLowerCase()){
            case "chrome" :
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox" :
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari" :
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Incorrect browsername: "+browserName+" passed");
                break;
        }
       return browser.newContext().newPage();
    }



}