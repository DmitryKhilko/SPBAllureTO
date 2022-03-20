package pages.base;

import org.testng.ITestContext;

public class ConstantsUICertificateChangeCauseDictionary extends BasePage {

    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с элементами интерфейса страницы 'Справочник причин изменения сертификата профессионального бухгалтера'
    //****************************************************************************************************************************************************************************

    //страница 'CertificateChangeCauseDictionaryPage' (собственно сама страница 'Справочник причин изменения сертификата профессионального бухгалтера')
    public static final String CERTIFICATE_CHANGE_CAUSE_BUTTON_ADD = "Добавить";

    //страница 'CertificateChangeCauseDictionaryCreatePage' (диалоговое окно создания новой причины изменения сертификата)
    public static final String CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE= "Добавление позиции в справочник причин изменения сертификата профессионального бухгалтера";
    public static final String CERTIFICATE_CHANGE_CAUSE_CREATE_NAME_LABEL= "Наименование";
    public static final String CERTIFICATE_CHANGE_CAUSE_CREATE_SIGN_LABEL= "Признак изменения (выдача, изм, аннул.)";
    public static final String CERTIFICATE_CHANGE_CAUSE_CREATE_BUTTON_CANCEL = "Отмена";
    public static final String CERTIFICATE_CHANGE_CAUSE_CREATE_BUTTON_OK = "OK";

    //страница 'CertificateChangeCauseDictionaryUpdatePage' (диалоговое окно редактирования причины изменения)
    public static final String CERTIFICATE_CHANGE_CAUSE_UPDATE_TITLE= "Редактирование позиции в справочнике причин изменения сертификата профессионального бухгалтера";
    public static final String CERTIFICATE_CHANGE_CAUSE_UPDATE_NAME_LABEL= "Наименование";
    public static final String CERTIFICATE_CHANGE_CAUSE_UPDATE_SIGN_LABEL= "Признак изменения (выдача, изм, аннул.)";
    public static final String CERTIFICATE_CHANGE_CAUSE_UPDATE_BUTTON_CANCEL = "Отмена";
    public static final String CERTIFICATE_CHANGE_CAUSE_UPDATE_BUTTON_OK = "OK";

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUICertificateChangeCauseDictionary(ITestContext context) {
        super(context);
    }
}
