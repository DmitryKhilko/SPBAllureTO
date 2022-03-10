package pages.base;

import org.testng.ITestContext;

public class ConstantsUILogin extends BasePage {

    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с элементами интерфейса страницы логина
    //****************************************************************************************************************************************************************************

    public static final String LOGIN_PAGE_TITLE = "Авторизация"; //заголовок страницы
    public static final String LOGIN_LABEL = "Логин"; //название поля для ввода логина
    public static final String PASSWORD_LABEL = "Пароль"; //название поля для ввода пароля
    public static final String LOGIN_BUTTON = "Войдите";

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUILogin(ITestContext context) {
        super(context);
    }
}