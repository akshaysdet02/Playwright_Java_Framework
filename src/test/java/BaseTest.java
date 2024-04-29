import application.actions.Action_LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.PlayWrightFactory;

import java.nio.file.Paths;

public class BaseTest extends PlayWrightFactory implements ITestListener {
    protected Page page = PlayWrightFactory.getPlaywrightBrowser();
    private static final String SCREENSHOT_PATH = "failed_screenshots/";

    private static final ExtentReports extent = new ExtentReports();


    @BeforeTest
    public void setUp() {
        new Action_LoginPage(page).launchUrl();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testCaseName = result.getMethod().getMethodName();
        captureScreenshot(testCaseName);
    }

    @AfterMethod
    public void logTestResultsInExtentReport(ITestResult result) {
        ExtentSparkReporter spark = new ExtentSparkReporter("extentReport/report.html");
        extent.attachReporter(spark);
        if (result.isSuccess()) {
            extent.createTest(result.getMethod().getMethodName()).assignCategory(result.getTestClass().getName())
                    .log(Status.PASS, "Test Case Success");
        } else {
            extent.createTest(result.getMethod().getMethodName()).assignCategory(result.getTestClass().getName())
                    .log(Status.FAIL, "Test Case Failed");
        }
        extent.flush();
    }


    @AfterTest
    public void TearDown() {
        new Action_LoginPage(page).
                logOutOfCoditasClap();
        this.page.context().browser().close();
    }

    private void captureScreenshot(String testName) {
        try {
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(SCREENSHOT_PATH + testName + ".png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}