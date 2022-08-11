package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.MainPage;

public class SearchTests extends BaseTest{
    MainPage mainPage = new MainPage();
    String value = "Ноутбуки";

    @DisplayName("Поиск и отображение первого товара в результатах")
    @Test
    public void searchAndDisplayedFirstGoodInResult() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        mainPage.openPage()
                .setCursorToSearchField()
                .inputValueToSearchField(value)
                .pressEnter()
                //Из-за капчи эти шаги не проходят
                .checkResultsHeader(value)
                .findFirstResultGood();
    }

}
