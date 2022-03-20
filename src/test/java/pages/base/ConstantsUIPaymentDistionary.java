package pages.base;

import org.testng.ITestContext;

public class ConstantsUIPaymentDistionary extends BasePage {

    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с элементами интерфейса страницы 'Справочник оплат'
    //****************************************************************************************************************************************************************************

    //страница 'PaymentDictionaryPage' (собственно сама страница 'Справочник оплат')

    //страница 'PaymentDictionaryCreatePage' (диалоговое окно создания вида оплат)
    public static final String PAYMENT_CREATE_TITLE= "Добавление позиции в справочник оплат";
    public static final String PAYMENT_CREATE_NAME_LABEL= "Наименование";
    public static final String PAYMENT_CREATE_BUTTON_CANCEL = "Отмена";
    public static final String PAYMENT_CREATE_BUTTON_OK = "OK";


    //страница 'PaymentDictionaryUpdatePage' (диалоговое окно редактирования вида оплат)
    public static final String PAYMENT_UPDATE_TITLE= "Редактирование позиции в справочнике оплат";
    public static final String PAYMENT_UPDATE_NAME_LABEL= "Наименование";
    public static final String PAYMENT_UPDATE_BUTTON_CANCEL = "Отмена";
    public static final String PAYMENT_UPDATE_BUTTON_OK = "OK";

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUIPaymentDistionary(ITestContext context) {
        super(context);
    }
}
