package pages.base;

import org.testng.ITestContext;

public class ConstantsUIDocumentTypeDistionary extends BasePage {

    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с элементами интерфейса страницы 'Справочник типов документов'
    //****************************************************************************************************************************************************************************

    //страница 'DocumentTypeDictionaryPage' (собственно сама страница 'Справочник типов документов')

    //страница 'DocumentTypeDictionaryUpdatePage' (диалоговое окно редактирования типа документа)
    public static final String DOCUMENT_TYPE_UPDATE_TITLE= "Редактирование позиции в справочнике типов документов";
    public static final String DOCUMENT_TYPE_UPDATE_NAME_LABEL= "Наименование";
    public static final String DOCUMENT_TYPE_UPDATE_BUTTON_CANCEL = "Отмена";
    public static final String DOCUMENT_TYPE_UPDATE_BUTTON_OK = "OK";

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUIDocumentTypeDistionary(ITestContext context) {
        super(context);
    }
}
