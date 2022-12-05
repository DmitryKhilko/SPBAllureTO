package tests;

import allure.AllureManual;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static pages.base.ConstantsUILogin.*;
import static pages.base.ConstantsUIMenu.*;
import static pages.base.ConstantsUIMessage.*;
import static tests.base.Users.*;

@Log4j2
public class LoginTest extends BaseTest {

    @BeforeMethod(description = "Открыть страницу логина") //действия, выполняемые перед каждым тестом
    public void precondition(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave(LOGIN_PAGE_TITLE);
    }

    @Description("Войти в приложение под ролью 'Суперпользователь'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли; работоспособность пунктов горизонтального и вертикального меню") //описание теста в Allure
    @Test(priority = 1, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль валидный)")
    @AllureId("84") //приоритет теста, название теста в Allure
    public void loginValidUsernameAndPassword_superUser(ITestContext context) {
        loginPage
                .login(superuserLogin, superuserPassword1);
    }

    @Description("Войти в приложение под ролью 'Администратор'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли; работоспособность пунктов горизонтального и вертикального меню")
    @Test(priority = 2, description = "Войти в приложение под ролью 'Администратор' (логин валидный; пароль валидный)")
    @AllureId("85")
    public void loginValidUsernameAndPassword_admin(ITestContext context) {
        loginPage
                .login(adminLogin, adminPassword)
                .userNameClick(adminName)
                .logoutSubmenuItemClick(VMENU_09);
    }

    @Description("Войти в приложение под ролью 'Специалист Минфина'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли; работоспособность пунктов горизонтального и вертикального меню")
    @Test(priority = 3, description = "Войти в приложение под ролью 'Специалист Минфина' (логин валидный; пароль валидный)")
    @AllureId("86")
    public void loginValidUsernameAndPassword_specialistMinfin(ITestContext context) {
        loginPage
                .login(specialistMinfinLogin, specialistMinfinPassword)
                .closeNotificationWindow();
    }

    @Description("Войти в приложение под ролью 'Секретарь КК'. Проверить после входа в приложение: работоспособность пунктов горизонтального и вертикального меню") //описание теста в Allure
    @Test(priority = 4, description = "Проверить работоспособность пунктов меню под ролью 'Секретарь КК'")
    @AllureId("87") //приоритет теста, название теста в Allure
    public void pageOpeningCheck_secretaryCommission(ITestContext context) {
        loginPage
                .login(secretaryCommissionLogin, secretaryCommissionPassword)
                .closeNotificationWindow()
                .userNameClick(secretaryCommissionName)
                .logoutSubmenuItemClick(VMENU_09);
    }

    @Description("Войти в приложение под ролью 'Член КК'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли; работоспособность пунктов горизонтального и вертикального меню")
    @Test(priority = 5, description = "Войти в приложение под ролью 'Член КК' (логин валидный; пароль валидный)")
    @AllureId("88")
    public void loginValidUsernameAndPassword_memberCommission(ITestContext context) {
        loginPage
                .login(memberCommissionLogin, memberCommissionPassword)
                .closeNotificationWindow()
                .userNameClick(memberCommissionName)
                .logoutSubmenuItemClick(VMENU_09);
    }

    @Description("Сделать попытку входа в приложение с пустым полем ввода логина")
    @Test(priority = 8, description = "Войти в приложение под ролью 'Суперпользователь' (логин пустой; пароль валидный)")
    public void loginEmptyUsernameAndValidPassword_SuperUser(ITestContext context) {
        loginPage
                .login("", superuserPassword);
        loginPage
                .loginErrorMessageShouldHave(INPUT_ERROR_MESSAGE);
    }

    @Description("Сделать попытку входа в приложение с пустым полем ввода пароля")
    @Test(priority = 9, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль пустой)")
    @AllureId("89")
    public void loginValidUsernameAndEmptyPassword_SuperUser(ITestContext context) {
        loginPage
                .login(superuserLogin, "");
        loginPage
                .passwordErrorMessageShouldHave(INPUT_ERROR_MESSAGE);
    }

    @Description("Сделать попытку входа в приложение с некорректным значением логина")
    @Test(priority = 10, description = "Войти в приложение под ролью 'Суперпользователь' (логин невалидный; пароль валидный)")
    @AllureId("90")
    public void loginInvalidUsernameAndValidPassword_SuperUser(ITestContext context) {
        loginPage
                .login("1234", superuserPassword);
        loginPage
                .descriptionNotificationWindowShouldHave(MESSAGE_NOTIFICATION_WINDOW_01);
    }

    @Description("Сделать попытку входа в приложение с некорректным значением пароля")
    @Test(priority = 11, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль невалидный)")
    @AllureId("91")
    public void loginValidUsernameAndInvalidPassword_SuperUser(ITestContext context) {
        loginPage
                .login(superuserLogin, "1234");
        loginPage
                .descriptionNotificationWindowShouldHave(MESSAGE_NOTIFICATION_WINDOW_01);
    }

    @Test(description = "Новый ручной тест")
    @AllureId("93")
    @AllureManual
    public void proba() {

    }
}
