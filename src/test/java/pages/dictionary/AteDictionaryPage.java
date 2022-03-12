package pages.dictionary;

import elements.Button;
import elements.Table;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static pages.base.ConstantsUIAteDistionary.*;
import static pages.base.URLs.*;

@Log4j2
public class AteDictionaryPage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы страницы 'Справочник АТЕ'; переменные, используемые в методах панели фильтров окна
    //****************************************************************************************************************************************************************************


    //****************************************************************************************************************************************************************************
    //Методы страницы 'Справочник АТЕ'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public AteDictionaryPage(ITestContext context) {
        super(context);
    }

    @Step("Открыть страницу 'Справочник АТЕ'")
    public AteDictionaryPage openPage() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу '" + BASE_URL + ATE_DICTIONARY_PAGE_URL + "'");
        open(BASE_URL + ATE_DICTIONARY_PAGE_URL);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'AteDictionaryPage'");
        return this;
    }

    @Step("Нажать кнопку 'Добавить' для добавления нового АТЕ")
    public AteDictionaryCreatePage openAddDialog() {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_BUTTON_ADD + "'");
        new Button(ATE_BUTTON_ADD).click();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'AteDictionaryCreatePage'");
        return new AteDictionaryCreatePage(context);
    }

    @Step("Отобразить панель фильтра на странице")
    public AteDictionaryFilterPage showFilters() {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_BUTTON_SHOW_FILTERS + "'");
        new Button(ATE_BUTTON_SHOW_FILTERS).click();
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, что кнопка '" + ATE_BUTTON_SHOW_FILTERS + "' изменила название на '" + ATE_BUTTON_HIDE_FILTERS + "'");
        new Button(ATE_BUTTON_HIDE_FILTERS).Button().shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": проверить факт отображения панели фильтра на странице - видимость кнопки '" + ATE_FILTER_BUTTON_APPLY + "'");
        new Button(ATE_FILTER_BUTTON_APPLY).Button().shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'AteDictionaryFilterPage'");
        return new AteDictionaryFilterPage(context);
    }

    @Step("Скрыть панель фильтра на странице")
    public AteDictionaryPage hideFilters() {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_BUTTON_HIDE_FILTERS + "'");
        new Button(ATE_BUTTON_HIDE_FILTERS).click();
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, что кнопка '" + ATE_BUTTON_HIDE_FILTERS + "' изменила название на '" + ATE_BUTTON_SHOW_FILTERS + "'");
        new Button(ATE_BUTTON_SHOW_FILTERS).Button().shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": проверить факт скрытия панели фильтра на странице - невидимость кнопки '" + ATE_FILTER_BUTTON_APPLY + "'");
        new Button(ATE_FILTER_BUTTON_APPLY).Button().shouldNotBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'AteDictionaryPage'");
        return this;
    }

    @Step("Проверить наличие АТЕ в таблице: в строке '{indexRow}' должно присутствовать значение '{text}'")
    public AteDictionaryPage tableCellValueShouldHave(String indexRow, int indexColumn, String text) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить наличие АТЕ в таблице - в строке '" + indexRow + "' должно присутствовать значение '" + text + "'");
        new Table(indexRow, indexColumn).cell().shouldHave(text(text));
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'AteDictionaryPage'");
        return this;
    }

    @Step("Нажать кнопку 'Редактировать' в строке таблицы для редактирования АТЕ")
    public AteDictionaryUpdatePage openUpdateDialog(String indexRow) {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Редактировать' в строке таблицы для редактирования АТЕ");
        new Table(indexRow, "edit").clickCellButton();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'AteDictionaryUpdatePage'");
        return new AteDictionaryUpdatePage(context);
    }

    @Step("Удалить АТЕ")
    public AteDictionaryPage deleteATE(String indexRow) {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Удалить' в строке таблицы для удаления АТЕ");
        new Table(indexRow, "delete").clickCellButton();
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Да' всплывающего окошка 'Вы уверены?'");
        new Table("Да").clickConfirmButton();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'AteDictionaryPage'");
        return this;
    }

    @Step("Проверить отсутствие АТЕ в таблице - отображено сообщение 'Нет данных'")
    public AteDictionaryPage tableDataShouldNotBeVisible() {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить отсутствие АТЕ в таблице - отображено сообщение 'Нет данных'");
        new Table().tableEmptyDescription().shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'AteDictionaryPage'");
        return this;
    }
}
