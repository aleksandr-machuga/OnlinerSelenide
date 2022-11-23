package by.it_academy.onliner.ui_framework.page_object;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;

public class HomePage {
    private ElementsCollection navigationLinks = $$x("//a[@class='b-main-navigation__link']");
    private static final String CATALOG = "Каталог";

    @Step("Click catalog link")
    public CatalogPage clickCatalogLink() {
        navigationLinks.findBy(text(CATALOG)).click();
        return new CatalogPage();
    }
}
