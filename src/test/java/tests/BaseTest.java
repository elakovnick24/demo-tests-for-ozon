package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ozon.config.Project;
import ozon.helpers.AllureAttachments;
import ozon.helpers.DriverUtils;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    public static void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://www.ozon.ru/";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "91");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        /*
        String remoteUrl = System.getProperty("remoteUrl");
        String user = System.getProperty("user");
        String password = System.getProperty("password");
        Configuration.remote = "https://" + user + ":" + password + "@" + remoteUrl;
         */

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

        @AfterEach
        public void addAttachments() {
            String sessionId = DriverUtils.getSessionId();

            AllureAttachments.addScreenshotAs("Last screenshot");
            AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
            AllureAttachments.addBrowserConsoleLogs();

            Selenide.closeWebDriver();

//            if (Project.isVideoOn()) {
//                AllureAttachments.addVideo(sessionId);
//            }
        }

}
