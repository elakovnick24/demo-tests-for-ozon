package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.MainPage;
import tests.pages.components.FilterComponent;

public class FilterTests extends BaseTest{
    MainPage mainPage = new MainPage();
    FilterComponent filterComponent = new FilterComponent();
    String filter = "Цифровые товары";

    @DisplayName("Фильтрация по категории для поиска товаров")
    @Test
    public void filteringForCategory() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        mainPage.openPage();
        filterComponent.tapFilter();
        filterComponent.filterOpened();
        filterComponent.chooseFilter();
        mainPage.searchFieldContainFilter(filter);
    }

}
