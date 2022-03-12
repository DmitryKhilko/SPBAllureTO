package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import pages.base.BasePage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.base.ConstantsUIPortalLogin.*;
import static pages.base.URLs.*;

@Log4j2
public class PortalPage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы страницы логина портала КЗ СПБ; переменные, используемые в методах
    //****************************************************************************************************************************************************************************
    public SelenideElement loginHyperlink = $(By.xpath("//span[contains(@class,'taglib-icon-label')]")); //гиперссылка "Войти"
    public String inputLoginModalLocator = "//label[contains(text(),'%s')]/ancestor::div[contains(@class, 'input-text-wrapper')]/input[contains(@id, 'LoginPortlet')]"; //поля ввода диалогового окна "Войти"

    //****************************************************************************************************************************************************************************
    //Методы страницы логина административной части КЗ СПБ
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public PortalPage(ITestContext context) {
        super(context);
    }

    @Step("Открыть страницу портала")
    public PortalPage openPage() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу портала '" + BASE_URL_PORTAL + "'");
        open(BASE_URL_PORTAL);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'PortalPage'");
        return this;
    }

    @Step("Открыть диалоговое окно для ввода логина и пароля, перейдя по гиперссылке '{hyperlinkText}'")
    public PortalPage loginDialogOpen(String hyperlinkText) {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть диалоговое окно для ввода логина и пароля, перейдя по гиперссылке '" + hyperlinkText + "'");
        loginHyperlink.click();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'PortalPage'");
        return this;
    }

    @Step("Ввести логин, пароль и войти на портал")
    public PortalPage login(String userName, String userPassword) {
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода логина значение '" + userName + "'");
        $(By.xpath(String.format(inputLoginModalLocator, PORTAL_LOGIN_LABEL))).clear();
        $(By.xpath(String.format(inputLoginModalLocator, PORTAL_LOGIN_LABEL))).setValue(userName);
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода пароля значение '" + userPassword + "'");
        $(By.xpath(String.format(inputLoginModalLocator, PORTAL_PASSWORD_LABEL))).clear();
        $(By.xpath(String.format(inputLoginModalLocator, PORTAL_PASSWORD_LABEL))).setValue(userPassword);
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + PORTAL_LOGIN_BUTTON + "' для входа на портал");
        new Button(PORTAL_LOGIN_BUTTON).click(); //нажимаем на кнопку "Войдите"
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'PortalPage'");
        return this;
    }
}
