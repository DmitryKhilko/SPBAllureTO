package pages.dictionary;

import elements.Table;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static pages.base.URLs.*;

@Log4j2
public class DocumentTypeDictionaryPage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы страницы 'Справочник типов документов'; переменные, используемые в методах
    //****************************************************************************************************************************************************************************


    //****************************************************************************************************************************************************************************
    //Методы страницы 'Справочник типов документов'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public DocumentTypeDictionaryPage(ITestContext context) {
        super(context);
    }

    @Step("Открыть страницу 'Справочник типов документов'")
    public DocumentTypeDictionaryPage openPage() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу '" + BASE_URL + DOCUMENT_TYPE_DICTIONARY_PAGE_URL + "'");
        open(BASE_URL + DOCUMENT_TYPE_DICTIONARY_PAGE_URL);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'RoleDictionaryPage'");
        return this;
    }

    @Step("Проверить наличие типа документа в таблице: в строке '{indexRow}' должно присутствовать значение '{text}'")
    public DocumentTypeDictionaryPage tableCellValueShouldHave(String indexRow, int indexColumn, String text) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить наличие типа документа в таблице - в строке '" + indexRow + "' должно присутствовать значение '" + text + "'");
        new Table(indexRow, indexColumn).cell().shouldHave(text(text));
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'DocumentTypeDictionaryPage'");
        return this;
    }

    @Step("Нажать кнопку 'Редактировать' в строке '{indexRow}' таблицы для редактирования типа документов")
    public DocumentTypeDictionaryUpdatePage openUpdateDialog(String indexRow) {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Редактировать' в строке '" + indexRow + "' таблицы для редактирования типа документов");
        new Table(indexRow, "edit").clickCellButton();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'DocumentTypeDictionaryUpdatePage'");
        return new DocumentTypeDictionaryUpdatePage(context);
    }

    @Step("Отсортировать в таблице значения столбца '{indexColumn}' по убыванию")
    public DocumentTypeDictionaryPage tableHeaderSortDown(int indexColumn) {
        log.debug("Тест " + context.getAttribute("testName") + ": отсортировать в таблице значения столбца '" + indexColumn + "' по убыванию");
        new Table(indexColumn).tableHeaderSortDown();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'RoleDictionaryPage'");
        return this;
    }

    @Step("Отсортировать в таблице значения столбца '{indexColumn}' по возрастанию")
    public DocumentTypeDictionaryPage tableHeaderSortUp(int indexColumn) {
        log.debug("Тест " + context.getAttribute("testName") + ": отсортировать в таблице значения столбца '" + indexColumn + "' по возрастанию");
        new Table(indexColumn).tableHeaderSortUp();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'RoleDictionaryPage'");
        return this;
    }
}
