package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static pages.base.ConstantsUILogin.*;
import static pages.base.ConstantsUIMenu.*;

@Log4j2
public class LoginTest extends BaseTest {

    @BeforeMethod(description = "Открыть страницу логина") //действия, выполняемые перед каждым тестом
    public void precondition(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave(LOGIN_PAGE_TITLE);
    }


    @Description("Войти в приложение под ролью 'Суперпользователь'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли; работоспособность пунктов горизонтального и вертикального меню") //описание теста в Allure
    @Test(priority = 1, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль валидный)") //приоритет теста, название теста в Allure
    public void loginValidUsernameAndPassword_superUser(ITestContext context) {
        loginPage
                .login(superuserLogin, superuserPassword)
                .closeNotificationWindow()
                //пункт меню "Профиль пользователя"
                .userNameClick(superuserName)
                .submenuItemUserNameClick(VMENU_0701)
                .pageTitleShouldHave(VMENU_0701_TITLE)
                //пункт меню "Почта"
                .userNameClick(superuserName)
                .submenuItemUserNameClick(VMENU_08)
                .verticalMenuItemClick(VMENU_0801).pageTitleShouldHave(VMENU_0801_TITLE)
                .verticalMenuItemClick(VMENU_0802).pageTitleShouldHave(VMENU_0802_TITLE)
                .verticalMenuItemClick(VMENU_0803).pageTitleShouldHave(VMENU_0803_TITLE)
                //пункт меню "Изменить пароль"
                .userNameClick(superuserName)
                .submenuItemUserNameClick(VMENU_0702)
                .pageTitleShouldHave(VMENU_0702_TITLE)
                //раздел "Администрирование"
                .horizontalSubmenuItemClick(GMENU_06)
                .verticalMenuGroupClick(VMENU_GROUP0601)
                .verticalMenuItemClick(VMENU_0601).pageTitleShouldHave(VMENU_0601_TITLE)
                .verticalMenuItemClick(VMENU_0602).pageTitleShouldHave(VMENU_0602_TITLE)
                .verticalMenuItemClick(VMENU_0603).pageTitleShouldHave(VMENU_0603_TITLE)
                .verticalMenuItemClick(VMENU_0604).pageTitleShouldHave(VMENU_0604_TITLE)
                .verticalMenuItemClick(VMENU_0605).pageTitleShouldHave(VMENU_0605_TITLE)
                .verticalMenuItemClick(VMENU_0606).pageTitleShouldHave(VMENU_0606_TITLE)
                .verticalMenuItemClick(VMENU_0607).pageTitleShouldHave(VMENU_0607_TITLE)
                .verticalMenuItemClick(VMENU_0608).pageTitleShouldHave(VMENU_0608_TITLE)
                .verticalMenuItemClick(VMENU_0609).pageTitleShouldHave(VMENU_0609_TITLE)
                .verticalMenuGroupClick(VMENU_GROUP0603)
                .verticalMenuItemClick(VMENU_0610).pageTitleShouldHave(VMENU_0610_TITLE)
                .verticalMenuItemClick(VMENU_0611).pageTitleShouldHave(VMENU_0611_TITLE)
                .verticalMenuItemClick(VMENU_0612).pageTitleShouldHave(VMENU_0612_TITLE)
                //раздел "Квалификационный экзамен"
                .horizontalMenuItemClick(GMENU_01)
                .verticalMenuItemClick(VMENU_0101).pageTitleShouldHave(VMENU_0101_TITLE)
                .verticalMenuItemClick(VMENU_0102).pageTitleShouldHave(VMENU_0102_TITLE)
                .verticalMenuItemClick(VMENU_0103).pageTitleShouldHave(VMENU_0103_TITLE)
                .verticalMenuItemClick(VMENU_0104).pageTitleShouldHave(VMENU_0104_TITLE)
                .verticalMenuItemClick(VMENU_0105).pageTitleShouldHave(VMENU_0105_TITLE)
                .verticalMenuItemClick(VMENU_0106).pageTitleShouldHave(VMENU_0106_TITLE)
                //раздел "Подтверждение квалификации"
                .horizontalMenuItemClick(GMENU_02)
                .verticalMenuItemClick(VMENU_0201).pageTitleShouldHave(VMENU_0201_TITLE)
                .verticalMenuItemClick(VMENU_0202).pageTitleShouldHave(VMENU_0202_TITLE)
                .verticalMenuItemClick(VMENU_0203).pageTitleShouldHave(VMENU_0203_TITLE)
                .verticalMenuItemClick(VMENU_0204).pageTitleShouldHave(VMENU_0204_TITLE)
                .verticalMenuItemClick(VMENU_0205).pageTitleShouldHave(VMENU_0205_TITLE)
                //раздел "Ведение реестра сертификатов"
                .horizontalMenuItemClick(GMENU_03)
                .verticalMenuItemClick(VMENU_0301).pageTitleShouldHave(VMENU_0301_TITLE)
                .verticalMenuItemClick(VMENU_0302).pageTitleShouldHave(VMENU_0302_TITLE)
                .verticalMenuItemClick(VMENU_0303).pageTitleShouldHave(VMENU_0303_TITLE)
                .verticalMenuItemClick(VMENU_0304).pageTitleShouldHave(VMENU_0304_TITLE)
                .verticalMenuItemClick(VMENU_0305).pageTitleShouldHave(VMENU_0305_TITLE)
                //раздел "Курирование деятельности по сертификации"
                .horizontalMenuItemClick(GMENU_04)
                .verticalMenuItemClick(VMENU_0401).pageTitleShouldHave(VMENU_0401_TITLE)
                .verticalMenuItemClick(VMENU_0402).pageTitleShouldHave(VMENU_0402_TITLE)
                .verticalMenuItemClick(VMENU_0403).pageTitleShouldHave(VMENU_0403_TITLE)
                .verticalMenuItemClick(VMENU_0404).pageTitleShouldHave(VMENU_0404_TITLE)
                .verticalMenuItemClick(VMENU_0405).pageTitleShouldHave(VMENU_0405_TITLE)
                .verticalMenuItemClick(VMENU_0406).pageTitleShouldHave(VMENU_0406_TITLE)
                //раздел "Подготовка базы данных знаний"
                .horizontalMenuItemClick(GMENU_05)
                .verticalMenuItemClick(VMENU_0501).pageTitleShouldHave(VMENU_0501_TITLE)
                .verticalMenuItemClick(VMENU_0502).pageTitleShouldHave(VMENU_0502_TITLE)
                .verticalMenuItemClick(VMENU_0503).pageTitleShouldHave(VMENU_0503_TITLE)
                .verticalMenuItemClick(VMENU_0504).pageTitleShouldHave(VMENU_0504_TITLE)
                .verticalMenuItemClick(VMENU_0505).pageTitleShouldHave(VMENU_0505_TITLE)
                .verticalMenuItemClick(VMENU_0506).pageTitleShouldHave(VMENU_0506_TITLE);
    }

    @Description("Войти в приложение под ролью 'Администратор'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли; работоспособность пунктов горизонтального и вертикального меню")
    @Test(priority = 2, description = "Войти в приложение под ролью 'Администратор' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_admin(ITestContext context) {
        loginPage
                .login(adminLogin, adminPassword)
                .closeNotificationWindow()
                //пункт меню "Профиль пользователя"
                .userNameClick(adminName)
                .submenuItemUserNameClick(VMENU_0701)
                .pageTitleShouldHave(VMENU_0701_TITLE)
                //пункт меню "Почта"
                .userNameClick(adminName)
                .submenuItemUserNameClick(VMENU_08)
                .verticalMenuItemShouldNotVisible(VMENU_0801)
                .verticalMenuItemClick(VMENU_0802).pageTitleShouldHave(VMENU_0802_TITLE)
                .verticalMenuItemShouldNotVisible(VMENU_0803)
                //пункт меню "Изменить пароль"
                .userNameClick(adminName)
                .submenuItemUserNameClick(VMENU_0702)
                .pageTitleShouldHave(VMENU_0702_TITLE)
                //раздел "Администрирование"
                .horizontalMenuItemClick(GMENU_06)
                .verticalMenuGroupClick(VMENU_GROUP0601)
                .verticalMenuItemClick(VMENU_0601).pageTitleShouldHave(VMENU_0601_TITLE)
                .verticalMenuItemClick(VMENU_0602).pageTitleShouldHave(VMENU_0602_TITLE)
                .verticalMenuItemClick(VMENU_0603).pageTitleShouldHave(VMENU_0603_TITLE)
                .verticalMenuItemClick(VMENU_0604).pageTitleShouldHave(VMENU_0604_TITLE)
                .verticalMenuItemClick(VMENU_0605).pageTitleShouldHave(VMENU_0605_TITLE)
                .verticalMenuItemClick(VMENU_0606).pageTitleShouldHave(VMENU_0606_TITLE)
                .verticalMenuItemClick(VMENU_0607).pageTitleShouldHave(VMENU_0607_TITLE)
                .verticalMenuItemClick(VMENU_0608).pageTitleShouldHave(VMENU_0608_TITLE)
                .verticalMenuItemClick(VMENU_0609).pageTitleShouldHave(VMENU_0609_TITLE)
                .verticalMenuGroupClick(VMENU_GROUP0603)
                .verticalMenuItemClick(VMENU_0610).pageTitleShouldHave(VMENU_0610_TITLE)
                .verticalMenuItemClick(VMENU_0611).pageTitleShouldHave(VMENU_0611_TITLE)
                .verticalMenuItemClick(VMENU_0612).pageTitleShouldHave(VMENU_0612_TITLE)
                //раздел "Квалификационный экзамен"
                .horizontalMenuItemShouldNotVisible(GMENU_01)
                //раздел "Подтверждение квалификации"
                .horizontalMenuItemShouldNotVisible(GMENU_02)
                //раздел "Ведение реестра сертификатов"
                .horizontalMenuItemShouldNotVisible(GMENU_03)
                //раздел "Курирование деятельности по сертификации"
                .horizontalMenuItemShouldNotVisible(GMENU_04)
                //раздел "Подготовка базы данных знаний"
                .horizontalMenuItemShouldNotVisible(GMENU_05);
    }

    @Issue("2066") //ссылка на баг-репорт
    @Description("Войти в приложение под ролью 'Специалист Минфина'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли; работоспособность пунктов горизонтального и вертикального меню")
    @Test(priority = 3, description = "Войти в приложение под ролью 'Специалист Минфина' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_specialistMinfin(ITestContext context) {
        loginPage
                .login(specialistMinfinLogin, specialistMinfinPassword)
                .closeNotificationWindow()
                //пункт меню "Профиль пользователя"
                .userNameClick(specialistMinfinName)
                .submenuItemUserNameClick(VMENU_0701)
                .pageTitleShouldHave(VMENU_0701_TITLE)
                //пункт меню "Почта"
                .userNameClick(specialistMinfinName)
                .submenuItemUserNameClick(VMENU_08)
                .verticalMenuItemClick(VMENU_0801).pageTitleShouldHave(VMENU_0801_TITLE)
                .verticalMenuItemClick(VMENU_0802).pageTitleShouldHave(VMENU_0802_TITLE)
                .verticalMenuItemClick(VMENU_0803).pageTitleShouldHave(VMENU_0803_TITLE)
                //пункт меню "Изменить пароль"
                .userNameClick(specialistMinfinName)
                .submenuItemUserNameClick(VMENU_0702)
                .pageTitleShouldHave(VMENU_0702_TITLE)
                //раздел "Администрирование"
                .horizontalSubmenuItemShouldNotVisible(GMENU_06)
                //раздел "Квалификационный экзамен"
                .horizontalMenuItemClick(GMENU_01)
                .verticalMenuItemClick(VMENU_0101).pageTitleShouldHave(VMENU_0101_TITLE)
                .verticalMenuItemClick(VMENU_0102).pageTitleShouldHave(VMENU_0102_TITLE)
                .verticalMenuItemShouldNotVisible(VMENU_0103)
                .verticalMenuItemClick(VMENU_0104).pageTitleShouldHave(VMENU_0104_TITLE)
                .verticalMenuItemShouldNotVisible(VMENU_0105)
                .verticalMenuItemShouldNotVisible(VMENU_0106)
                //раздел "Подтверждение квалификации"
                .horizontalMenuItemClick(GMENU_02)
                .verticalMenuItemClick(VMENU_0201).pageTitleShouldHave(VMENU_0201_TITLE)
                .verticalMenuItemClick(VMENU_0202).pageTitleShouldHave(VMENU_0202_TITLE)
                .verticalMenuItemShouldNotVisible(VMENU_0203)
                .verticalMenuItemShouldNotVisible(VMENU_0204)
                .verticalMenuItemShouldNotVisible(VMENU_0205)
                //раздел "Ведение реестра сертификатов"
                .horizontalMenuItemClick(GMENU_03)
                .verticalMenuItemClick(VMENU_0301).pageTitleShouldHave(VMENU_0301_TITLE)
                .verticalMenuItemClick(VMENU_0302).pageTitleShouldHave(VMENU_0302_TITLE)
                .verticalMenuItemClick(VMENU_0303).pageTitleShouldHave(VMENU_0303_TITLE)
                .verticalMenuItemClick(VMENU_0304).pageTitleShouldHave(VMENU_0304_TITLE)
                .verticalMenuItemClick(VMENU_0305).pageTitleShouldHave(VMENU_0305_TITLE)
                //раздел "Курирование деятельности по сертификации"
                .horizontalMenuItemClick(GMENU_04)
                .verticalMenuItemClick(VMENU_0401).pageTitleShouldHave(VMENU_0401_TITLE)
                .verticalMenuItemClick(VMENU_0402).pageTitleShouldHave(VMENU_0402_TITLE)
                .verticalMenuItemClick(VMENU_0403).pageTitleShouldHave(VMENU_0403_TITLE)
                .verticalMenuItemClick(VMENU_0404).pageTitleShouldHave(VMENU_0404_TITLE)
                .verticalMenuItemClick(VMENU_0405).pageTitleShouldHave(VMENU_0405_TITLE)
                .verticalMenuItemClick(VMENU_0406).pageTitleShouldHave(VMENU_0406_TITLE)
                //раздел "Подготовка базы данных знаний"
                .horizontalMenuItemClick(GMENU_05)
                .verticalMenuItemClick(VMENU_0501).pageTitleShouldHave(VMENU_0501_TITLE)
                .verticalMenuItemClick(VMENU_0502).pageTitleShouldHave(VMENU_0502_TITLE)
                .verticalMenuItemClick(VMENU_0503).pageTitleShouldHave(VMENU_0503_TITLE)
                .verticalMenuItemClick(VMENU_0504).pageTitleShouldHave(VMENU_0504_TITLE)
                .verticalMenuItemClick(VMENU_0505).pageTitleShouldHave(VMENU_0505_TITLE)
                .verticalMenuItemClick(VMENU_0506).pageTitleShouldHave(VMENU_0506_TITLE);
    }

    @Description("Войти в приложение под ролью 'Секретарь КК'. Проверить после входа в приложение: работоспособность пунктов горизонтального и вертикального меню") //описание теста в Allure
    @Test(priority = 4, description = "Проверить работоспособность пунктов меню под ролью 'Секретарь КК'") //приоритет теста, название теста в Allure
    public void pageOpeningCheck_secretaryCommission(ITestContext context) {
        loginPage
                .login(secretaryCommissionLogin, secretaryCommissionPassword)
                .closeNotificationWindow()
                //пункт меню "Профиль пользователя"
                .userNameClick(secretaryCommissionName)
                .submenuItemUserNameClick(VMENU_0701)
                .pageTitleShouldHave(VMENU_0701_TITLE)
                //пункт меню "Почта"
                .userNameClick(secretaryCommissionName)
                .submenuItemUserNameClick(VMENU_08)
                .verticalMenuItemClick(VMENU_0801).pageTitleShouldHave(VMENU_0801_TITLE)
                .verticalMenuItemClick(VMENU_0802).pageTitleShouldHave(VMENU_0802_TITLE)
                .verticalMenuItemClick(VMENU_0803).pageTitleShouldHave(VMENU_0803_TITLE)
                //пункт меню "Изменить пароль"
                .userNameClick(secretaryCommissionName)
                .submenuItemUserNameClick(VMENU_0702)
                .pageTitleShouldHave(VMENU_0702_TITLE)
                //раздел "Администрирование"
                .horizontalMenuItemShouldNotVisible(GMENU_06)
                //раздел "Квалификационный экзамен"
                .horizontalMenuItemClick(GMENU_01)
                .verticalMenuItemShouldNotVisible(VMENU_0101)
                .verticalMenuItemClick(VMENU_0102).pageTitleShouldHave(VMENU_0102_TITLE)
                .verticalMenuItemClick(VMENU_0103).pageTitleShouldHave(VMENU_0103_TITLE)
                .verticalMenuItemClick(VMENU_0104).pageTitleShouldHave(VMENU_0104_TITLE)
                .verticalMenuItemClick(VMENU_0105).pageTitleShouldHave(VMENU_0105_TITLE)
                .verticalMenuItemClick(VMENU_0106).pageTitleShouldHave(VMENU_0106_TITLE)
                //раздел "Подтверждение квалификации"
                .horizontalMenuItemClick(GMENU_02)
                .verticalMenuItemShouldNotVisible(VMENU_0201)
                .verticalMenuItemClick(VMENU_0202).pageTitleShouldHave(VMENU_0202_TITLE)
                .verticalMenuItemClick(VMENU_0203).pageTitleShouldHave(VMENU_0203_TITLE)
                .verticalMenuItemClick(VMENU_0204).pageTitleShouldHave(VMENU_0204_TITLE)
                .verticalMenuItemClick(VMENU_0205).pageTitleShouldHave(VMENU_0205_TITLE)
                //раздел "Ведение реестра сертификатов"
                .horizontalMenuItemShouldNotVisible(GMENU_03)
                //раздел "Курирование деятельности по сертификации"
                .horizontalMenuItemShouldNotVisible(GMENU_04)
                //раздел "Подготовка базы данных знаний"
                .horizontalMenuItemShouldNotVisible(GMENU_05);
    }

    @Description("Войти в приложение под ролью 'Член КК'. Проверить после входа в приложение: наличие пункта меню с именем текущего пользователя; наличие пунктов горизонтального меню, соответствующих роли; работоспособность пунктов горизонтального и вертикального меню")
    @Test(priority = 5, description = "Войти в приложение под ролью 'Член КК' (логин валидный; пароль валидный)")
    public void loginValidUsernameAndPassword_memberCommission(ITestContext context) {
        loginPage
                .login(memberCommissionLogin, memberCommissionPassword)
                .closeNotificationWindow()
                //пункт меню "Профиль пользователя"
                .userNameClick(memberCommissionName)
                .submenuItemUserNameClick(VMENU_0701)
                .pageTitleShouldHave(VMENU_0701_TITLE)
                //пункт меню "Почта"
                .userNameClick(memberCommissionName)
                .submenuItemUserNameClick(VMENU_08)
                .verticalMenuItemShouldNotVisible(VMENU_0801)
                .verticalMenuItemClick(VMENU_0802).pageTitleShouldHave(VMENU_0802_TITLE)
                .verticalMenuItemShouldNotVisible(VMENU_0803)
                //пункт меню "Изменить пароль"
                .userNameClick(memberCommissionName)
                .submenuItemUserNameClick(VMENU_0702)
                .pageTitleShouldHave(VMENU_0702_TITLE)
                //раздел "Администрирование"
                .horizontalMenuItemShouldNotVisible(GMENU_06)
                //раздел "Квалификационный экзамен"
                .horizontalMenuItemClick(GMENU_01)
                .verticalMenuItemShouldNotVisible(VMENU_0101)
                .verticalMenuItemClick(VMENU_0102).pageTitleShouldHave(VMENU_0102_TITLE)
                .verticalMenuItemShouldNotVisible(VMENU_0103)
                .verticalMenuItemShouldNotVisible(VMENU_0104)
                .verticalMenuItemShouldNotVisible(VMENU_0105)
                .verticalMenuItemShouldNotVisible(VMENU_0106)
                //раздел "Подтверждение квалификации"
                .horizontalMenuItemClick(GMENU_02)
                .verticalMenuItemShouldNotVisible(VMENU_0201)
                .verticalMenuItemClick(VMENU_0202).pageTitleShouldHave(VMENU_0202_TITLE)
                .verticalMenuItemShouldNotVisible(VMENU_0203)
                .verticalMenuItemShouldNotVisible(VMENU_0204)
                .verticalMenuItemShouldNotVisible(VMENU_0205)
                //раздел "Ведение реестра сертификатов"
                .horizontalMenuItemShouldNotVisible(GMENU_03)
                //раздел "Курирование деятельности по сертификации"
                .horizontalMenuItemShouldNotVisible(GMENU_04)
                //раздел "Подготовка базы данных знаний"
                .horizontalMenuItemClick(GMENU_05)
                .verticalMenuItemShouldNotVisible(VMENU_0501)
                .verticalMenuItemClick(VMENU_0502).pageTitleShouldHave(VMENU_0502_TITLE)
                .verticalMenuItemClick(VMENU_0503).pageTitleShouldHave(VMENU_0503_TITLE)
                .verticalMenuItemClick(VMENU_0504).pageTitleShouldHave(VMENU_0504_TITLE)
                .verticalMenuItemClick(VMENU_0505).pageTitleShouldHave(VMENU_0505_TITLE)
                .verticalMenuItemClick(VMENU_0506).pageTitleShouldHave(VMENU_0506_TITLE);
    }

    @Description("Войти в приложение под ролью 'Суперпользователь'. Проверить работоспособность пункта 'Выйти' (выход из приложения)")
    @Test(priority = 6, description = "Выйти из приложения под ролью 'Суперпользователь'")
    public void logout_superUser(ITestContext context) {
        loginPage
                .login(superuserLogin, superuserPassword)
                .closeNotificationWindow()
                .userNameClick(superuserName)
                .logoutSubmenuItemClick(VMENU_09);
    }

    @Description("Войти в приложение под ролью 'Администратор'. Проверить работоспособность пункта 'Выйти' (выход из приложения)")
    @Test(priority = 7, description = "Выйти из приложения под ролью 'Администратор'")
    public void logout_admin(ITestContext context) {
        loginPage
                .login(adminLogin, adminPassword)
                .closeNotificationWindow()
                .userNameClick(adminName)
                .logoutSubmenuItemClick(VMENU_09);
    }

    @Description("Войти в приложение под ролью 'Специалист Минфина'. Проверить работоспособность пункта 'Выйти' (выход из приложения)")
    @Test(priority = 8, description = "Выйти из приложения под ролью 'Специалист Минфина'")
    public void logout_specialistMinfin(ITestContext context) {
        loginPage
                .login(specialistMinfinLogin, specialistMinfinPassword)
                .closeNotificationWindow()
                .userNameClick(specialistMinfinName)
                .logoutSubmenuItemClick(VMENU_09);
    }

    @Description("Войти в приложение под ролью 'Секретарь КК'. Проверить работоспособность пункта 'Выйти' (выход из приложения)")
    @Test(priority = 9, description = "Выйти из приложения под ролью 'Секретарь КК'")
    public void logout_secretaryCommission(ITestContext context) {
        loginPage
                .login(secretaryCommissionLogin, secretaryCommissionPassword)
                .closeNotificationWindow()
                .userNameClick(secretaryCommissionName)
                .logoutSubmenuItemClick(VMENU_09);
    }

    @Description("Войти в приложение под ролью 'Член КК'. Проверить работоспособность пункта 'Выйти' (выход из приложения)")
    @Test(priority = 10, description = "Выйти из приложения под ролью 'Член КК'")
    public void logout_memberCommission(ITestContext context) {
        loginPage
                .login(memberCommissionLogin, memberCommissionPassword)
                .closeNotificationWindow()
                .userNameClick(memberCommissionName)
                .logoutSubmenuItemClick(VMENU_09);
    }

    @Description("Сделать попытку входа в приложение с пустым полем ввода логина")
    @Test(priority = 11, description = "Войти в приложение под ролью 'Суперпользователь' (логин пустой; пароль валидный)")
    public void loginEmptyUsernameAndValidPassword_SuperUser(ITestContext context) {
        loginPage
                .login("", superuserPassword);
        loginPage
                .loginErrorMessageShouldHave(INPUT_ERROR_MESSAGE);
    }

    @Description("Сделать попытку входа в приложение с пустым полем ввода пароля")
    @Test(priority = 12, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль пустой)")
    public void loginValidUsernameAndEmptyPassword_SuperUser(ITestContext context) {
        loginPage
                .login(superuserLogin, "");
        loginPage
                .passwordErrorMessageShouldHave(INPUT_ERROR_MESSAGE);
    }

    @Description("Сделать попытку входа в приложение с некорректным значением логина")
    @Test(priority = 13, description = "Войти в приложение под ролью 'Суперпользователь' (логин невалидный; пароль валидный)")
    public void loginInvalidUsernameAndValidPassword_SuperUser(ITestContext context) {
        loginPage
                .login("123", superuserPassword);
        loginPage
                .descriptionNotificationWindowShouldHave(MESSAGE_NOTIFICATION_WINDOW_01);
    }

    @Description("Сделать попытку входа в приложение с некорректным значением пароля")
    @Test(priority = 14, description = "Войти в приложение под ролью 'Суперпользователь' (логин валидный; пароль невалидный)")
    public void loginValidUsernameAndInvalidPassword_SuperUser(ITestContext context) {
        loginPage
                .login(superuserLogin, "123");
        loginPage
                .descriptionNotificationWindowShouldHave(MESSAGE_NOTIFICATION_WINDOW_01);
    }

    //TODO Сделать тест на блокировку пользователя после 5 (настройка безопасности) неправильных вводов логина или пароля
}
