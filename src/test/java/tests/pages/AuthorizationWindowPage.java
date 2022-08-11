package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationWindowPage {
    private final SelenideElement
            logo = $("[alt='Логотип OzonId']"),
            headerText = $(".ab8t > div:nth-child(2)"),
            subHeaderText = $(".ab8t > div:nth-child(3)"),
            inputPhoneField = $(byName("phone")),
            inputPhoneFieldText = $(".ui-ba0 .ui-a6a"),
            signInButton = $(byText("Sign in"));


    @Step("Проверить наличие элементов поп-апа при авторизации/регистрации по номеру телефона")
    public AuthorizationWindowPage checkingElementsWindowForAuthOrRegistrationByNumber(String phone) {
        logo.shouldBe(visible);
        headerText.shouldHave(text("Enter your phone number"));
        subHeaderText.shouldHave(text("We'll send you a code or call you. You don't need to answer the call. You can receive the code by e-mail or SMS"));
        inputPhoneFieldText.shouldHave(text("Phone number"));
        inputPhoneField.sendKeys(phone);
        signInButton.click();

        return this;
    }


}
