package by.it_academy.onliner.ui_framework.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {
    private final SelenideElement asideMenu = $("div.catalog-navigation-list__category[style='display: block;']");
    private final ElementsCollection sectionOptions =
            $$("div[class*='aside-item_active'] a.catalog-navigation-list__dropdown-item");
    private final ElementsCollection catalogItems =
            $$("li[class*='catalog-navigation-classifier__item']:not([class*='brand'])");
    private final ElementsCollection asideMenuItems =
            $$("div[style='display: block;'] div.catalog-navigation-list__aside-item");
    public static final String QUANTITY_KEYWORD = "товар";
    public static final String PRICE_KEYWORD = "р.";
    private static final String SECTION_OPTION_TITLE_CSS = "span.catalog-navigation-list__dropdown-title";
    private static final String SECTION_OPTION_DESCRIPTION_XPATH =
            ".//span[@class='catalog-navigation-list__dropdown-description']";
    public static final Duration DURATION = Duration.ofSeconds(5);

    public CatalogPage verifySectionsExist(List<String> catalogSections) {
        catalogItems.shouldHave(textsInAnyOrder(catalogSections));
        return this;
    }

    public CatalogPage clickCatalogSection(String section) {
        catalogItems.findBy(text(section)).click();
        return this;
    }

    public CatalogPage verifySectionMenuVisible() {
        asideMenu.shouldBe(visible, DURATION);
        return this;
    }

    public CatalogPage verifyMenuOptionsVisible(List<String> menuOptions) {
        asideMenuItems.shouldHave(containExactTextsCaseSensitive(menuOptions));
        return this;
    }

    public CatalogPage clickAsideMenuOption(String option) {
        asideMenuItems.findBy(text(option)).click();
        return this;
    }

    public CatalogPage verifyMenuElementsContent() {
        sectionOptions.asFixedIterable().forEach(element -> verifyMenuElementContent(element));
        return this;
    }

    private CatalogPage verifyMenuElementContent(SelenideElement element) {
        element.$(SECTION_OPTION_TITLE_CSS).shouldBe(visible, DURATION);
        element.$x(SECTION_OPTION_DESCRIPTION_XPATH).shouldHave(text(QUANTITY_KEYWORD), text(PRICE_KEYWORD));
        return this;
    }
}
