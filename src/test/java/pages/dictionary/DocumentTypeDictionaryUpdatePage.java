package pages.dictionary;

import elements.ButtonDialogWindow;
import elements.InputDialogWindow;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.DocumentTypeDictionary;
import org.testng.ITestContext;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.exactText;
import static pages.base.ConstantsUIDocumentTypeDistionary.*;

@Log4j2
public class DocumentTypeDictionaryUpdatePage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы диалогового окна 'Редактирование позиции в справочнике типов документов'; переменные, используемые в методах диалогового окна
    //****************************************************************************************************************************************************************************


    //****************************************************************************************************************************************************************************
    //Методы диалогового окна 'Редактирование позиции в справочнике типов документов'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public DocumentTypeDictionaryUpdatePage(ITestContext context) {
        super(context);
    }

    @Step("Отредактировать тип документа")
    public DocumentTypeDictionaryPage updateDocumentType(String title, DocumentTypeDictionary documentTypeDictionary) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшееся диалоговое окно заголовок '" + title + "'");
        titleDialogWindow.shouldHave(exactText(title));
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + DOCUMENT_TYPE_UPDATE_NAME_LABEL + "' значение '" + documentTypeDictionary.getName() + "'");
        new InputDialogWindow(DOCUMENT_TYPE_UPDATE_NAME_LABEL).write(documentTypeDictionary.getName());
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + DOCUMENT_TYPE_UPDATE_BUTTON_OK + "' для изменения типа документа");
        new ButtonDialogWindow(DOCUMENT_TYPE_UPDATE_BUTTON_OK).click();
        log.debug("Тест " + context.getAttribute("testName") + ": сохранить дату и время редактирования типа документа для проверки успешности редактирования типа документа");
        dateTime = cellDateTime();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'DocumentTypeDictionaryPage'");
        return new DocumentTypeDictionaryPage(context);
    }
}
