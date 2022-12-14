package pages.base;

import org.testng.ITestContext;

public class ConstantsUIMessage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с сообщениями на страницах
    //****************************************************************************************************************************************************************************

    //сообщения окон уведомлений
    public static final String MESSAGE_NOTIFICATION_WINDOW_01 = "Ошибка авторизации: Неправильный логин или пароль";

    //сообщение о незаполненных полях ввода
    public static final String INPUT_ERROR_MESSAGE = "Поле обязательно!";

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUIMessage(ITestContext context) {
        super(context);
    }
}
