package by.it_academy.tests.ui_test;

import by.it_academy.onliner.ui_framework.listeners.AllureListener;
import by.it_academy.onliner.ui_framework.page_object.HomePage;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static by.it_academy.onliner.ui_framework.framework.DriverConfigurator.setUpDriver;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Listeners(AllureListener.class)
public class BaseTest {

    public static final String BASE_URL = "https://www.onliner.by/";
    protected HomePage homePage;
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void startBrowser() {
        open(BASE_URL);
        homePage = new HomePage();
        LOGGER.info("Browser start");
    }

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(@Optional String browser) {
        setUpDriver(browser);
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterMethod
    public void closeBrowser() {
        closeWebDriver();
        LOGGER.info("Browser close");
    }
}
