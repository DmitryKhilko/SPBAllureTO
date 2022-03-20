package pages.base;

import org.testng.ITestContext;

public class ConstantsUIRoleDistionary extends BasePage {

    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с элементами интерфейса страницы 'Справочник ролей'
    //****************************************************************************************************************************************************************************

    //страница 'RoleDictionaryPage' (собственно сама страница 'Справочник ролей')

    //страница 'AteDictionaryUpdatePage' (диалоговое окно редактирования АТЕ)
    public static final String ROLE_UPDATE_TITLE= "Редактирование позиции в справочнике ролей";
    public static final String ROLE_UPDATE_NAME_LABEL= "Наименование";
    public static final String ROLE_UPDATE_BUTTON_CANCEL = "Отмена";
    public static final String ROLE_UPDATE_BUTTON_OK = "OK";

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUIRoleDistionary(ITestContext context) {
        super(context);
    }
}
