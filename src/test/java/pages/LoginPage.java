package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Input;
import elements.NotificationWindow;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.base.ConstantsUI.*;
import static pages.base.URLs.*;

@Log4j2
public class LoginPage extends BasePage {

    public SelenideElement loginPageTitle = $(By.xpath("//h1[@class='page-title']"));
    //public SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));

    //Конструктор для передачи в команду log имени теста
    public LoginPage(ITestContext context) {
        super(context);
    }

    @Step("Открыть страницу логина приложения")
    public LoginPage openPage() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу логина '" + BASE_URL + LOGIN_PAGE_URL + "'");
        open(BASE_URL + LOGIN_PAGE_URL);
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить, содержит ли открывшаяся страница заголовок '{title}'")
    public LoginPage pageTitleShouldHave(String title) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшаяся страница заголовок '" + title + "'");
        loginPageTitle.shouldHave(exactText(title));
        return this; //возвращаем текущую страницу
    }

    @Step("Ввести логин, пароль и войти в приложение")
    public HeaderPage login(String userName, String userPassword) {
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода логина значение '" + userName + "'");
        new Input(LOGIN_LABEL).write(userName);
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода пароля значение '" + userPassword + "'");
        new Input(PASSWORD_LABEL).write(userPassword);
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + loginButton.getText() + "' для входа в приложение");
        loginButton.click(); //нажимаем на кнопку "Войдите"
        return new HeaderPage(context); //Инициализуем страницу, на которую переходим
    }

    @Step("Проверить, вывелось ли сообщение об ошибке '{message}' при пустом поле ввода логина")
    public LoginPage loginErrorMessageShouldHave(String message) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, вывелось ли сообщение об ошибке '" + message + "' при пустом поле ввода логина");
        new Input(LOGIN_LABEL).inputErrorMessage().shouldHave(exactText(message));
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить, вывелось ли сообщение об ошибке '{message}' при пустом поле ввода пароля")
    public LoginPage passwordErrorMessageShouldHave(String message) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, вывелось ли сообщение об ошибке '" + message + "' при пустом поле ввода пароля");
        new Input(PASSWORD_LABEL).inputErrorMessage().shouldHave(exactText(message));
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить, вывелось ли уведомление об ошибке '{message}' при некорректном значении логина или пароля")
    public LoginPage descriptionNotificationWindowShouldHave(String message) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, вывелось ли уведомление об ошибке '" + message + "' при некорректном значении логина или пароля");
        new NotificationWindow().descriptionShouldHave(message);
        return this; //возвращаем текущую страницу
    }
}
