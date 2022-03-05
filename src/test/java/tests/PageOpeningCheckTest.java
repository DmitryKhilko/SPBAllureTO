package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

@Log4j2
public class PageOpeningCheckTest extends BaseTest {

    @BeforeMethod(description = "Открыть страницу логина") //действия, выполняемые перед каждым тестом
    public void precondition(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave("Авторизация");
    }

    @Description("Войти в приложение под ролью 'Суперпользователь'. Проверить после входа в приложение: работоспособность пунктов меню (подменю)") //описание теста в Allure
    @Test(priority = 1, description = "Проверить работоспособность пунктов меню (подменю) под ролью 'Суперпользователь'") //приоритет теста, название теста в Allure
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
}
