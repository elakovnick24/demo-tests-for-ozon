package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            authorization = $("[data-widget='profileMenuAnonymous']"),
            enterOrRegistrationButton = $(".ui-k6 .at4b >div:nth-child(2) .ui-j3 "),
            personalAccountButton = $(".ui-k6 .at4b >div:nth-child(3) .ui-j3 "),
            popUpHeader = $(".ui-k6 .at4b"),
            searchField = $("[placeholder='Искать на Ozon']"),
            textResultsHeader = $("[data-widget='fulltextResultsHeader']"),
            firstResult = $("x9j jy:first-child"),
            searchContainElement = $("aia7 ai7a");


    @Step("Открыть главную страницу")
    public MainPage openPage() {
        //stickyHeader.shouldBe(visible);
        open("");
        return this;
    }

    @Step("Проверить отображение поп-апа при наведении курсора мыши на кнопку 'Войти'")
    public MainPage authorizationOnTheSiteVisible() {
        authorization.hover().shouldBe(visible);
        popUpHeader.shouldBe(visible);

        return this;
    }

    @Step("Проверка заголовка и кнопок в поп-апе")
    public MainPage checkingTextInAuthorizationPopUp() {
        popUpHeader.hover().shouldHave(text("Войдите, чтобы делать покупки, отслеживать заказы и пользоваться персональными скидками и баллами."));
        enterOrRegistrationButton.shouldHave(text("Войти или зарегистрироваться"));
        personalAccountButton.shouldHave(text("Личный кабинет"));

        return this;
    }

    @Step("Нажать на Войти или зарегистрироваться")
    public MainPage tapEnterOrRegistration() {
        enterOrRegistrationButton.click();

        return this;
    }

    @Step("Нажать Личный Кабинет")
    public MainPage tapPersonalAccount() {
        personalAccountButton.click();

        return this;
    }


    @Step("Установить курсор в поле поиска")
    public MainPage setCursorToSearchField() {
        searchField.click();

        return this;
    }

    @Step("Ввести '{value}' в поле поиска")
    public MainPage inputValueToSearchField(String value) {
        searchField.sendKeys(value);

        return this;
    }

    @Step("Нажать Enter")
    public MainPage pressEnter() {
        searchField.pressEnter();

        return this;
    }

    @Step("Проверка заголовка на соответствие запросу")
    public MainPage checkResultsHeader(String value) {
        textResultsHeader.shouldHave(text(value));

        return this;
    }

    @Step("Найти первый товар в результурующей выдаче по запросу")
    public MainPage findFirstResultGood() {
        firstResult.shouldBe(visible);

        return this;
    }

   @Step("Строка поиска содержит фильтр '{filter}'")
    public MainPage searchFieldContainFilter(String filter) {
        searchContainElement.shouldHave(text(filter));

        return this;
    }

}
