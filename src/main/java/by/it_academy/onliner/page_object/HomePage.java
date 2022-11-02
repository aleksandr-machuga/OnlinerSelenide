package by.it_academy.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;

public class HomePage {
    private ElementsCollection navigationLinks = $$x("//a[@class='b-main-navigation__link']");
    private static final String CATALOG = "Каталог";

    public CatalogPage clickCatalogLink() {
        navigationLinks.findBy(text(CATALOG)).click();
        return new CatalogPage();
    }
}
