package tests.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FilterComponent {

    public void tapFilter() {
        $("[title='Везде']").click();

    }

    public void filterOpened() {
        //C помощью JS Executor делаем окно видимым
        executeJavaScript("document.querySelector('data-widget=searchContextPopup').style.opacity = 100");
        $("[data-widget='searchContextPopup']").shouldBe(visible);
    }

    public void chooseFilter() {
        $(byText("Цифровые товары")).click();
    }


}
