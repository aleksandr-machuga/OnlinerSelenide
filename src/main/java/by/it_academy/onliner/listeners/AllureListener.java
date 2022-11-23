package by.it_academy.onliner.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static by.it_academy.onliner.api_framework.utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

public class AllureListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        takeScreenshotAndAttachToAllureReport();
    }
}
