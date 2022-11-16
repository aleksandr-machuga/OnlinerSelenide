package by.it_academy.tests.ui_test;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class OnlinerTest extends BaseTest {
    public static final String COMPUTERS = "Компьютеры и";
    private static final List<String> CATALOG_SECTIONS = Arrays.asList("Prime", "Электроника", COMPUTERS,
            "Бытовая техника", "Дом и", "Стройка и", "Авто и", "Красота и", "Детям и", "Работа и");
    public static final String ACCESSORIES = "Комплектующие";
    private static final List<String> MENU_OPTIONS = Arrays.asList
            ("Ноутбуки, компьютеры, мониторы", ACCESSORIES, "Хранение данных", "Сетевое оборудование");

    @Test
    public void testCatalogSectionsPresence() {
        homePage.clickCatalogLink()
                .verifySectionsExist(CATALOG_SECTIONS);
    }

    @Test
    public void testComputersMenu() {
        homePage.clickCatalogLink()
                .clickCatalogSection(COMPUTERS)
                .verifySectionMenuVisible()
                .verifyMenuOptionsVisible(MENU_OPTIONS);
    }

    @Test
    public void testAccessoriesElementsContent() {
        homePage.clickCatalogLink()
                .clickCatalogSection(COMPUTERS)
                .clickAsideMenuOption(ACCESSORIES)
                .verifyMenuElementsContent();
    }
}
