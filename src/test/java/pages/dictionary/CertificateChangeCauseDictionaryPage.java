package pages.dictionary;

import elements.Button;
import elements.Table;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.CertificateChangeCauseDictionary;
import org.testng.ITestContext;
import pages.base.BasePage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.*;
import static pages.base.URLs.*;

@Log4j2
public class CertificateChangeCauseDictionaryPage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы страницы 'Справочник причин изменения сертификата профессионального бухгалтера'; переменные, используемые в методах панели фильтров окна
    //****************************************************************************************************************************************************************************


    //****************************************************************************************************************************************************************************
    //Методы страницы 'Справочник причин изменения сертификата профессионального бухгалтера'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public CertificateChangeCauseDictionaryPage(ITestContext context) {
        super(context);
    }

    @Step("Открыть страницу 'Справочник причин изменения сертификата профессионального бухгалтера'")
    public CertificateChangeCauseDictionaryPage openPage() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу '" + BASE_URL + CERTIFICATE_CHANGE_CAUSE_DICTIONARY_PAGE_URL + "'");
        open(BASE_URL + CERTIFICATE_CHANGE_CAUSE_DICTIONARY_PAGE_URL);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'CertificateChangeCauseDictionaryPage'");
        return this;
    }

    @Step("Нажать кнопку 'Добавить' для добавления новой причины изменения СПБ")
    public CertificateChangeCauseDictionaryCreatePage openAddDialog() {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + CERTIFICATE_CHANGE_CAUSE_BUTTON_ADD + "'");
        new Button(CERTIFICATE_CHANGE_CAUSE_BUTTON_ADD).click();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'CertificateChangeCauseDictionaryCreatePage'");
        return new CertificateChangeCauseDictionaryCreatePage(context);
    }

     @Step("Проверить наличие причины изменения СПБ в таблице: в строке '{indexRow}' должно присутствовать значение '{text}'")
    public CertificateChangeCauseDictionaryPage tableCellValueShouldHave(String indexRow, int indexColumn, String text) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить наличие причины изменения СПБ в таблице - в строке '" + indexRow + "' должно присутствовать значение '" + text + "'");
        new Table(indexRow, indexColumn).cell().shouldHave(text(text));
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'CertificateChangeCauseDictionaryPage'");
        return this;
    }

    @Step("Нажать кнопку 'Редактировать' в строке таблицы для редактирования причины изменения СПБ")
    public CertificateChangeCauseDictionaryUpdatePage openUpdateDialog(String indexRow) {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Редактировать' в строке таблицы для редактирования причины изменения СП");
        new Table(indexRow, "edit").clickCellButton();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'CertificateChangeCauseDictionaryUpdatePage'");
        return new CertificateChangeCauseDictionaryUpdatePage(context);
    }

    @Step("Удалить причину изменения СПБ")
    public CertificateChangeCauseDictionaryPage deleteChangeCause(String indexRow) {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Удалить' в строке таблицы для удаления причины изменения СПБ");
        new Table(indexRow, "delete").clickCellButton();
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку 'Да' всплывающего окошка 'Вы уверены?'");
        new Table("Да").clickConfirmButton();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'CertificateChangeCauseDictionaryPage'");
        return this;
    }

    @Step("Проверить отсутствие причины изменения СПБ в таблице - отсутствует строка с наименованием причины '{text}'")
    public CertificateChangeCauseDictionaryPage tableDataShouldNotBeVisible(String text) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить отсутствие причины изменения СПБ в таблице в таблице - отсутствует строка с наименованием причины '" + text + "'");
        new Table(text).tableDataShouldNotBeVisible();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'CertificateChangeCauseDictionaryPage'");
        return this;
    }

    @Step("Отсортировать в таблице значения столбца '{indexColumn}' по убыванию")
    public CertificateChangeCauseDictionaryPage tableHeaderSortDown(int indexColumn) {
        log.debug("Тест " + context.getAttribute("testName") + ": отсортировать в таблице значения столбца '" + indexColumn + "' по убыванию");
        new Table(indexColumn).tableHeaderSortDown();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'CertificateChangeCauseDictionaryPage'");
        return this;
    }

    @Step("Отсортировать в таблице значения столбца '{indexColumn}' по возрастанию")
    public CertificateChangeCauseDictionaryPage tableHeaderSortUp(int indexColumn) {
        log.debug("Тест " + context.getAttribute("testName") + ": отсортировать в таблице значения столбца '" + indexColumn + "' по возрастанию");
        new Table(indexColumn).tableHeaderSortUp();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'CertificateChangeCauseDictionaryPage'");
        return this;
    }

    @Step("Снять сортировку в таблице со столбца '{indexColumn}'")
    public CertificateChangeCauseDictionaryPage tableHeaderUnSort(int indexColumn) {
        log.debug("Тест " + context.getAttribute("testName") + ": снять сортировку в таблице со столбца '" + indexColumn + "'");
        new Table(indexColumn).tableHeaderUnSort();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'CertificateChangeCauseDictionaryPage'");
        return this;
    }
}
