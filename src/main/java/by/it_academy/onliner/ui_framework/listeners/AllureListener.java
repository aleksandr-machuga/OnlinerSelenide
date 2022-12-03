package by.it_academy.onliner.ui_framework.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static by.it_academy.onliner.ui_framework.utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

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
