package by.it_academy.onliner.ui_framework.page_object;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;

public class HomePage {
    private ElementsCollection navigationLinks = $$x("//a[@class='b-main-navigation__link']");
    private static final String CATALOG = "Каталог";
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @Step("Click catalog link")
    public CatalogPage clickCatalogLink() {
        navigationLinks.findBy(text(CATALOG)).click();
        LOGGER.info("Open catalog");
        return new CatalogPage();
    }
}
