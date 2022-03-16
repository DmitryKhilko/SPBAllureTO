package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static pages.base.ConstantsUIPortalLogin.*;
import static tests.base.Users.*;

@Log4j2
public class PortalTest extends BaseTest {

    @BeforeMethod(description = "Открыть страницу портала") //действия, выполняемые перед каждым тестом
    public void precondition(ITestContext context) {
        portalPage
                .openPage()
                .loginDialogOpen(PORTAL_LOGIN_PAGE_HYPERLINK);
    }

    @Description("Войти на портал под ролью 'Сотрудник УЦ Минфина'. Проверить после входа в приложение:...") //описание теста в Allure
    @Test(priority = 1, description = "Войти в приложение под ролью 'Сотрудник УЦ Минфина' (логин валидный; пароль валидный)") //приоритет теста, название теста в Allure
    public void loginValidUsernameAndPassword_employeeTCMinfin(ITestContext context) {
        portalPage
                .login(employeeTCMinfinLogin, employeeTCMinfinPassword);
    }
}
