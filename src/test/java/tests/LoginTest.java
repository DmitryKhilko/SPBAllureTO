package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

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
                .userNameShouldHave(superuserName)
                .menuItemShouldBeVisible("Квалификационный экзамен")
                .menuItemShouldBeVisible("Подтверждение квалификации")
                .menuItemShouldBeVisible("Ведение реестра сертификатов")
                .menuItemShouldBeVisible("Курирование деятельности по сертификации")
                .menuItemShouldBeVisible("Подготовка базы данных знаний")
                .submenuItemShouldBeVisible("Администрирование");
    }

    @Description("Войти в приложение под ролью 'Администратор'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли")
    @Test(priority = 2, description = "Войти в приложение под ролью 'Администратор' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_Admin(ITestContext context) {
        loginPage
                .login(adminLogin, adminPassword)
                .closeNotificationWindow()
                .userNameShouldHave(adminName)
                .menuItemShouldNotVisible("Квалификационный экзамен")
                .menuItemShouldNotVisible("Подтверждение квалификации")
                .menuItemShouldNotVisible("Ведение реестра сертификатов")
                .menuItemShouldNotVisible("Курирование деятельности по сертификации")
                .menuItemShouldNotVisible("Подготовка базы данных знаний")
                .menuItemShouldBeVisible("Администрирование");
    }

    @Description("Войти в приложение под ролью 'Специалист Минфина'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли")
    @Test(priority = 3, description = "Войти в приложение под ролью 'Специалист Минфина' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_specialistMinfin(ITestContext context) {
        loginPage
                .login(specialistMinfinLogin, specialistMinfinPassword)
                .closeNotificationWindow()
                .userNameShouldHave(specialistMinfinName)
                .menuItemShouldBeVisible("Квалификационный экзамен")
                .menuItemShouldBeVisible("Подтверждение квалификации")
                .menuItemShouldBeVisible("Ведение реестра сертификатов")
                .menuItemShouldBeVisible("Курирование деятельности по сертификации")
                .menuItemShouldBeVisible("Подготовка базы данных знаний")
                .submenuItemShouldNotVisible("Администрирование");
    }

    @Description("Войти в приложение под ролью 'Секретарь КК'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли")
    @Test(priority = 4, description = "Войти в приложение под ролью 'Секретарь КК' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_secretaryCommission(ITestContext context) {
        loginPage
                .login(secretaryCommissionLogin, secretaryCommissionPassword)
                .closeNotificationWindow()
                .userNameShouldHave(secretaryCommissionName)
                .menuItemShouldBeVisible("Квалификационный экзамен")
                .menuItemShouldBeVisible("Подтверждение квалификации")
                .menuItemShouldNotVisible("Ведение реестра сертификатов")
                .menuItemShouldNotVisible("Курирование деятельности по сертификации")
                .menuItemShouldNotVisible("Подготовка базы данных знаний")
                .menuItemShouldNotVisible("Администрирование");
    }

    @Description("Войти в приложение под ролью 'Член КК'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли")
    @Test(priority = 5, description = "Войти в приложение под ролью 'Член КК' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_memberCommission(ITestContext context) {
        loginPage
                .login(memberCommissionLogin, memberCommissionPassword)
                .closeNotificationWindow()
                .userNameShouldHave(memberCommissionName)
                .menuItemShouldBeVisible("Квалификационный экзамен")
                .menuItemShouldBeVisible("Подтверждение квалификации")
                .menuItemShouldNotVisible("Ведение реестра сертификатов")
                .menuItemShouldNotVisible("Курирование деятельности по сертификации")
                .menuItemShouldBeVisible("Подготовка базы данных знаний")
                .menuItemShouldNotVisible("Администрирование");
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
