package by.it_academy.tests.ui_test;

import by.it_academy.onliner.ui_framework.page_object.HomePage;
import org.testng.annotations.*;

import static by.it_academy.onliner.ui_framework.framework.DriverConfigurator.setUpDriver;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public static final String BASE_URL = "https://www.onliner.by/";
    protected HomePage homePage;

    @BeforeMethod
    public void startBrowser() {
        open(BASE_URL);
        homePage = new HomePage();
    }

    @BeforeClass
    @Parameters(value = {"browser"})
    public synchronized void setUp(String browser) {
        setUpDriver(browser);
    }

    @AfterMethod
    public void closeBrowser() {
        closeWebDriver();
    }
}
