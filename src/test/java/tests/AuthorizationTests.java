package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.AuthorizationWindowPage;
import tests.pages.MainPage;

public class AuthorizationTests extends BaseTest {

    MainPage mainPage = new MainPage();
    AuthorizationWindowPage authorizationWindowPage = new AuthorizationWindowPage();
    String phone = "79366199907";

    @DisplayName("Регистрация нового пользователя")
    @Test
    public void registrationNewUser() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        mainPage.openPage()
                .authorizationOnTheSiteVisible()
                .checkingTextInAuthorizationPopUp()
                //Клик по кнопке производится но всплывает ошибка (видимо блочит автоматизацию)
                .tapEnterOrRegistration();


        //Эта проверка имела бы смысл, если тест прошел бы успешно
        authorizationWindowPage.checkingElementsWindowForAuthOrRegistrationByNumber(phone);
    }

}
