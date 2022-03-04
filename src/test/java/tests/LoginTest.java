package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

//**************************************************************************************************************************************************************
// Позитивный тест
// 1. Войти в приложение (логин валидный; пароль валидный). Вход осуществить для: суперпользователя; Администратора; Сотрудника Минфина; Секретаря КК; члена КК
// Негативные тесты. Роль - суперпользователь
// 2. Войти в приложение (логин пустой; пароль валидный). Роль - суперпользователь.
// 3. Войти в приложение (логин валидный; пароль пустой). Роль - суперпользователь.
// 4. Войти в приложение (логин невалидный; пароль валидный). Роль - суперпользователь.
// 5. Войти в приложение (логин валидный; пароль невалидный). Роль - суперпользователь.
// 6. Войти в приложение (3 раза подряд; логин невалидный; пароль валидный). Роль - суперпользователь. Проверка блокировки пользователя
// 7. Войти в приложение (3 раза подряд; логин валидный; пароль невалидный). Роль - суперпользователь. Проверка блокировки пользователя
//**************************************************************************************************************************************************************

@Log4j2
public class LoginTest extends BaseTest {

    @BeforeMethod(description = "Открыть страницу логина") //действия, выполняемые перед каждым тестом
    public void precondition(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave("Авторизация");
    }

    @Description("Войти в приложение под ролью 'Суперпользователь'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли") //описание теста в Allure
    @Test(priority = 1, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль валидный)") //приоритет теста, название теста в Allure
    public void loginValidUsernameAndPassword_SuperUser(ITestContext context) {
        loginPage
                .login(superuserLogin, superuserPassword)
                .closeNotificationWindow()
                .userNameShouldHave(superuserName);
    }

    @Description("Войти в приложение под ролью 'Администратор'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли")
    @Test(priority = 2, description = "Войти в приложение под ролью 'Администратор' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_Admin(ITestContext context) {
        loginPage
                .login(adminLogin, adminPassword)
                .closeNotificationWindow()
                .userNameShouldHave(adminName);
    }

    @Description("Войти в приложение под ролью 'Специалист Минфина'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли")
    @Test(priority = 3, description = "Войти в приложение под ролью 'Специалист Минфина' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_specialistMinfin(ITestContext context) {
        loginPage
                .login(specialistMinfinLogin, specialistMinfinPassword)
                .closeNotificationWindow()
                .userNameShouldHave(specialistMinfinName);
    }

    @Description("Войти в приложение под ролью 'Секретарь КК'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли")
    @Test(priority = 4, description = "Войти в приложение под ролью 'Секретарь КК' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_secretaryCommission(ITestContext context) {
        loginPage
                .login(secretaryCommissionLogin, secretaryCommissionPassword)
                .closeNotificationWindow()
                .userNameShouldHave(secretaryCommissionName);
    }

    @Description("Войти в приложение под ролью 'Член КК'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли")
    @Test(priority = 5, description = "Войти в приложение под ролью 'Член КК' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_memberCommission(ITestContext context) {
        loginPage
                .login(memberCommissionLogin, memberCommissionPassword)
                .closeNotificationWindow()
                .userNameShouldHave(memberCommissionName);
    }

    @Description("Сделать попытку входа в приложение с пустым полем ввода логина")
    @Test(priority = 6, description = "Войти в приложение под ролью 'Суперпользователь' (логин пустой; пароль валидный)")
    public void loginEmptyUsernameAndValidPassword_SuperUser(ITestContext context) {
        loginPage
                .login("", superuserPassword);
        loginPage
                .loginErrorMessageShouldHave("Поле обязательно!");
    }

    @Description("Сделать попытку входа в приложение с пустым полем ввода пароля")
    @Test(priority = 7, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль пустой)")
    public void loginValidUsernameAndEmptyPassword_SuperUser(ITestContext context) {
        loginPage
                .login(superuserLogin, "");
        loginPage
                .passwordErrorMessageShouldHave("Поле обязательно!");
    }

    @Description("Сделать попытку входа в приложение с некорректным значением логина")
    @Test(priority = 8, description = "Войти в приложение под ролью 'Суперпользователь' (логин невалидный; пароль валидный)")
    public void loginInvalidUsernameAndValidPassword_SuperUser(ITestContext context) {
        loginPage
                .login("123", superuserPassword);
        loginPage
                .descriptionNotificationWindowShouldHave("Ошибка авторизации: Неправильный логин или пароль");
    }

    @Description("Сделать попытку входа в приложение с некорректным значением пароля")
    @Test(priority = 9, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль невалидный)")
    public void loginValidUsernameAndInvalidPassword_SuperUser(ITestContext context) {
        loginPage
                .login(superuserLogin, "123");
        loginPage
                .descriptionNotificationWindowShouldHave("Ошибка авторизации: Неправильный логин или пароль");
    }

    //TODO Сделать тест на блокировку пользователя после 5 (настройка безопасности) неправильных вводов логина или пароля
}
