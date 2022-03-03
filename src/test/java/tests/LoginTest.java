package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static com.codeborne.selenide.Condition.exactText;
import static pages.LoginPage.LOGIN_PAGE_URL;
import static pages.base.BasePage.BASE_URL;

//**************************************************************************************************************************************************************
// Позитивный тест
// 1. Войти в приложение (логин валидный; пароль валидный). Вход осуществить для: суперпользователя; Администратора; Сотрудника Минфина; Секретаря КК; члена КК
// Негативные тесты. Роль - суперпользователь
// 2. Войти в приложение (логин пустой; пароль валидный)
// 3. Войти в приложение (логин валидный; пароль пустой)
// 4. Войти в приложение (логин невалидный; пароль валидный)
// 5. Войти в приложение (логин валидный; пароль невалидный)
// 6. Войти в приложение (3 раза подряд; логин невалидный; пароль валидный). Проверка блокировки пользователя
// 7. Войти в приложение (3 раза подряд; логин валидный; пароль невалидный). Проверка блокировки пользователя
//**************************************************************************************************************************************************************

@Log4j2
public class LoginTest extends BaseTest {

//    @BeforeMethod(description = "Открыть страницу логина") //действия, выполняемые перед каждым тестом
//    public void precondition(ITestContext context) {
//        loginPage
//                .openPage()
//                .pageTitleShouldHave("Авторизация");
//    }


    //Добавить @DataProvider для подстановки в данный тест 4-х видов пользователей

    @Description("Открыть страницу логина. Войти в приложение. Проверить после входа в приложение наличие пункта меню с именем текущего пользователя") //описание теста в Allure
    @Test(priority = 1, description = "Войти в приложение (логин валидный; пароль валидный)")//приоритет теста, название теста в Allure
    public void loginValidUsernameAndPassword(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave("Авторизация")
                .login("hitan@mail.ru","Hh111111111")
                .closeNotificationWindow()
                .userNameShouldHave("Хилько Т.Ю.");
    }

    @Description("Открыть страницу логина. Сделать попытку входа в приложение с пустым полем ввода логина")
    @Test(priority = 2, description = "Войти в приложение (логин пустой; пароль валидный)")
    public void loginEmptyUsernameAndValidPassword(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave("Авторизация")
                .login("","Hh111111111");
        loginPage
                .loginErrorMessageShouldHave("Поле обязательно!");
    }

    @Description("Открыть страницу логина. Сделать попытку входа в приложение с пустым полем ввода пароля")
    @Test(priority = 3, description = "Войти в приложение (логин валидный; пароль пустой)")
    public void loginValidUsernameAndEmptyPassword(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave("Авторизация")
                .login("hitan@mail.ru","");
        loginPage
                .passwordErrorMessageShouldHave("Поле обязательно!");
    }

    @Description("Открыть страницу логина. Сделать попытку входа в приложение с некорректным значением логина")
    @Test(priority = 4, description = "Войти в приложение (логин невалидный; пароль валидный)")
    public void loginInvalidUsernameAndValidPassword(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave("Авторизация")
                .login("123","Hh111111111");
        loginPage
                .descriptionNotificationWindowShouldHave("Ошибка авторизации: Неправильный логин или пароль");
    }

    @Description("Открыть страницу логина. Сделать попытку входа в приложение с некорректным значением пароля")
    @Test(priority = 4, description = "Войти в приложение (логин валидный; пароль невалидный)")
    public void loginValidUsernameAndInvalidPassword(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave("Авторизация")
                .login("hitan@mail.ru","123");
        loginPage
                .descriptionNotificationWindowShouldHave("Ошибка авторизации: Неправильный логин или пароль");
    }

    //TODO Сделать тест на блокировку пользователя после 5 (настройка безопасности) неправильных вводов логина или пароля
}
