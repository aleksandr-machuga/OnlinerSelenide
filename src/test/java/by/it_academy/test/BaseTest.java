package by.it_academy.test;

import by.it_academy.onliner.framework.DriverConfigurator;
import by.it_academy.onliner.page_object.HomePage;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static final String BASE_URL = "https://www.onliner.by/";
    protected HomePage homePage;

    @BeforeMethod
    public void startBrowser() {
        Selenide.open(BASE_URL);
        homePage = new HomePage();
    }

    @BeforeTest
    public void setUp() {
        DriverConfigurator.setUpDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
