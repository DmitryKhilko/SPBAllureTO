package pages.base;

import org.testng.ITestContext;

public class ConstantsUIPortalLogin extends BasePage {

    //****************************************************************************************************************************************************************************
    //Портал КЗ СПБ
    //Константы, связанные с элементами интерфейса страницы логина
    //****************************************************************************************************************************************************************************

    public static final String PORTAL_LOGIN_PAGE_HYPERLINK = "Войти"; //гиперссылка на стартовой странице для вызова диалогового окна входа
    public static final String PORTAL_LOGIN_LABEL = "Экранное имя"; //название поля для ввода логина
    public static final String PORTAL_PASSWORD_LABEL = "Пароль"; //название поля для ввода пароля
    public static final String PORTAL_LOGIN_BUTTON = "Войти";

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUIPortalLogin(ITestContext context) {
        super(context);
    }
}
