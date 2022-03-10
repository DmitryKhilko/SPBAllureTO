package pages;

import elements.Button;
import elements.Table;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static pages.base.ConstantsUIAteDistionary.*;
import static pages.base.URLs.*;

@Log4j2
public class AteDictionaryPage extends BasePage {

    //***************************************************************************************************************************************
    //Локаторы страницы
    //***************************************************************************************************************************************


    public AteDictionaryPage(ITestContext context) {
        super(context);
    }

    //***************************************************************************************************************************************
    //Методы страницы
    //***************************************************************************************************************************************

    //TODO!!! Во всех методах добавить команду лога: log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'AteDictionaryPage'"); или log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'AteDictionaryCreatePage'");


    @Step("Открыть страницу 'Справочник АТЕ'")
    public AteDictionaryPage openPage() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу '" + BASE_URL + ATEDICTIONARY_PAGE_URL + "'");
        open(BASE_URL + ATEDICTIONARY_PAGE_URL);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'AteDictionaryPage'");
        return this;
    }

    @Step("Нажать кнопку 'Добавить' для добавления нового АТЕ")
    public AteDictionaryCreatePage openAddDialog() {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_BUTTON_ADD + "'");
        new Button(ATE_BUTTON_ADD).clickButton();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'AteDictionaryCreatePage'");
        return new AteDictionaryCreatePage(context);
    }

    @Step("Отобразить панель фильтра на странице")
    public AteDictionaryFilterPage showFilters() {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_BUTTON_SHOW_FILTERS + "'");
        new Button(ATE_BUTTON_SHOW_FILTERS).clickButton();
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, что кнопка '" + ATE_BUTTON_SHOW_FILTERS + "' изменила название на '" + ATE_BUTTON_HIDE_FILTERS + "'");
        new Button(ATE_BUTTON_HIDE_FILTERS).Button().shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": проверить факт отображения панели фильтра на странице - видимость кнопки '" + ATE_FILTER_BUTTON_APPLY + "'");
        new Button(ATE_FILTER_BUTTON_APPLY).Button().shouldBe(visible);
        return new AteDictionaryFilterPage(context); //переходим после действия на нужную страницу
    }

    @Step("Скрыть панель фильтра на странице")
    public AteDictionaryPage hideFilters() {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_BUTTON_HIDE_FILTERS + "'");
        new Button(ATE_BUTTON_HIDE_FILTERS).clickButton();
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, что кнопка '" + ATE_BUTTON_HIDE_FILTERS + "' изменила название на '" + ATE_BUTTON_SHOW_FILTERS + "'");
        new Button(ATE_BUTTON_SHOW_FILTERS).Button().shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": проверить факт скрытия панели фильтра на странице - невидимость кнопки '" + ATE_FILTER_BUTTON_APPLY + "'");
        new Button(ATE_FILTER_BUTTON_APPLY).Button().shouldNotBe(visible);
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить наличие АТЕ в таблице: в строке '{indexRow}' должно присутствовать значение '{text}'")
    public AteDictionaryPage tableCellValueShouldHave(String indexRow, int indexColumn, String text) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить наличие АТЕ в таблице - в строке '" + indexRow + "' должно присутствовать значение '" + text + "'");
        new Table(indexRow, indexColumn).cell().shouldHave(exactText(text));
        return this; //возвращаем текущую страницу
    }

    @Step("Нажать кнопку 'Редактировать' в строке таблицы для редактирования АТЕ")
    public AteDictionaryUpdatePage openUpdateDialog(String indexRow) {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Редактировать' в строке таблицы для редактирования АТЕ");
        new Table(indexRow, "edit").clickCellButton();
        return new AteDictionaryUpdatePage(context); //переходим после действия на нужную страницу
    }
}
