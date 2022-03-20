package pages.dictionary;

import elements.Button;
import elements.Table;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.CERTIFICATE_CHANGE_CAUSE_BUTTON_ADD;
import static pages.base.URLs.*;

@Log4j2
public class RoleDictionaryPage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы страницы 'Справочник ролей'; переменные, используемые в методах
    //****************************************************************************************************************************************************************************


    //****************************************************************************************************************************************************************************
    //Методы страницы 'Справочник ролей'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public RoleDictionaryPage(ITestContext context) {
        super(context);
    }

    @Step("Открыть страницу 'Справочник ролей'")
    public RoleDictionaryPage openPage() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу '" + BASE_URL + ROLE_DICTIONARY_PAGE_URL + "'");
        open(BASE_URL + ROLE_DICTIONARY_PAGE_URL);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'RoleDictionaryPage'");
        return this;
    }

    @Step("Получить значение ячейки таблицы: строка '{indexRow}', столбец '{indexColumn}'")
    public String tableCellValue(String indexRow, int indexColumn) {
        log.debug("Тест " + context.getAttribute("testName") + ": получить значение ячейки таблицы (строка '" + indexRow + "', столбец '" + indexColumn + "')");
        return new Table(indexRow, indexColumn).cell().getText();
    }

    @Step("Проверить наличие роли в таблице: в строке '{indexRow}' должно присутствовать значение '{text}'")
    public RoleDictionaryPage tableCellValueShouldHave(String indexRow, int indexColumn, String text) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить наличие роли в таблице - в строке '" + indexRow + "' должно присутствовать значение '" + text + "'");
        new Table(indexRow, indexColumn).cell().shouldHave(text(text));
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'RoleDictionaryPage'");
        return this;
    }

    @Step("Нажать кнопку 'Редактировать' в строке таблицы для редактирования роли")
    public RoleDictionaryUpdatePage openUpdateDialog(String indexRow) {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Редактировать' в строке таблицы для редактирования роли");
        new Table(indexRow, "edit").clickCellButton();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'RoleDictionaryUpdatePage'");
        return new RoleDictionaryUpdatePage(context);
    }

    @Step("Отсортировать в таблице значения столбца '{indexColumn}' по убыванию")
    public RoleDictionaryPage tableHeaderSortDown(int indexColumn) {
        log.debug("Тест " + context.getAttribute("testName") + ": отсортировать в таблице значения столбца '" + indexColumn + "' по убыванию");
        new Table(indexColumn).tableHeaderSortDown();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'RoleDictionaryPage'");
        return this;
    }

    @Step("Отсортировать в таблице значения столбца '{indexColumn}' по возрастанию")
    public RoleDictionaryPage tableHeaderSortUp(int indexColumn) {
        log.debug("Тест " + context.getAttribute("testName") + ": отсортировать в таблице значения столбца '" + indexColumn + "' по возрастанию");
        new Table(indexColumn).tableHeaderSortUp();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'RoleDictionaryPage'");
        return this;
    }
}
