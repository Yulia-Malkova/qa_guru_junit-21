package guru.qa.tests;

import guru.qa.data.Currency;
import guru.qa.pages.MainPage;
import guru.qa.pages.SectionPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import static com.codeborne.selenide.Selenide.open;

public class WildberriesTest extends TestBase {

    MainPage mainPage = new MainPage();
    SectionPage sectionPage = new SectionPage();

    @BeforeEach()
    void setUp() {
        open("https://www.wildberries.ru/");
    }

    @ParameterizedTest(name = "Пользователь может перейти в раздел {0} каталога через меню")
    @ValueSource(
            strings = {"Женщинам", "Обувь", "Детям"}
    )
    void userCanNavigateToCatalogSectionViaMenu(String sectionName) {
        mainPage
                .waitUntilCurrencyDropdownLoads()
                .openMenu()
                .clickOnSection(sectionName);

        sectionPage
                .checkSectionName(sectionName);
    }

    @ParameterizedTest(name = "Раздел каталога {0} содержит подраздел {1}")
    @CsvFileSource(resources = "/userCanOpenItemCardInCatalogSection.csv")
    void userCanOpenItemCardInCatalogSection(String sectionName, String subSectionName) {
        mainPage
                .waitUntilCurrencyDropdownLoads()
                .openMenu()
                .hoverOnSection(sectionName)
                .checkSubsectionNameInChosenSection(subSectionName);
    }

    @ParameterizedTest(name = "Пользователь может поменять валюту на {0}")
    @EnumSource(Currency.class)
    void userCanChangeCurrency(Currency c) {
        mainPage
                .waitUntilCurrencyDropdownLoads()
                .hoverOnCurrencyDropdown()
                .changeCurrency(c.getName())
                .waitUntilCurrencyDropdownLoads()
                .checkCurrencyChange(c.toString());
    }
}