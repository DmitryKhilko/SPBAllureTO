package pages.base;

import org.testng.ITestContext;
import pages.base.BasePage;

public class ConstantsUIAteDistionary extends BasePage {

    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с элементами интерфейса страницы 'Справочник АТЕ'
    //****************************************************************************************************************************************************************************

    //страница 'AteDictionaryPage'
    public static final String ATE_BUTTON_ADD = "Добавить";
    public static final String ATE_BUTTON_SHOW_FILTERS = "Показать фильтры";
    public static final String ATE_BUTTON_HIDE_FILTERS = "Скрыть фильтры";

    //страница 'AteDictionaryCreatePage'
    public static final String ATE_CREATE_TITLE= "Добавление позиции в справочник АТЕ";
    public static final String ATE_CREATE_PARENT_NAME_LABEL= "Наименование родителя";
    public static final String ATE_CREATE_NAME_LABEL= "Наименование";
    public static final String ATE_CREATE_GOVERNMENT_LABEL= "Орган управления";
    public static final String ATE_CREATE_BUTTON_CANCEL = "Отмена";
    public static final String ATE_CREATE_BUTTON_OK = "OK";
    public static final String ATE_CREATE_ERROR_MESSAGE = "Поле обязательно!";

    //страница 'AteDictionaryUpdatePage'
    public static final String ATE_UPDATE_TITLE= "Редактирование позиции в справочнике АТЕ";
    public static final String ATE_UPDATE_PARENT_NAME_LABEL= "Наименование родителя";
    public static final String ATE_UPDATE_NAME_LABEL= "Наименование";
    public static final String ATE_UPDATE_GOVERNMENT_LABEL= "Орган управления";
    public static final String ATE_UPDATE_BUTTON_CANCEL = "Отмена";
    public static final String ATE_UPDATE_BUTTON_OK = "OK";
    public static final String ATE_UPDATE_ERROR_MESSAGE = "Поле обязательно!";


    //страница 'AteDictionaryFilterPage'
    public static final String ATE_FILTER_PARENT_NAME_LABEL= "Наименование родителя";
    public static final String ATE_FILTER_NAME_LABEL= "Наименование";
    public static final String ATE_FILTER_GOVERNMENT_LABEL= "Орган управления";
    public static final String ATE_FILTER_BUTTON_APPLY = "Применить";
    public static final String ATE_FILTER_BUTTON_RESET = "Сбросить";


    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUIAteDistionary(ITestContext context) {
        super(context);
    }
}
