package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import models.dictionary.CertificateChangeCauseDictionary;
import models.dictionary.CertificateChangeCauseDictionaryFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.IOException;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.*;
import static pages.base.ConstantsUILogin.LOGIN_PAGE_TITLE;
import static pages.dictionary.CertificateChangeCauseDictionaryCreatePage.*;
import static pages.dictionary.CertificateChangeCauseDictionaryUpdatePage.*;
import static tests.base.Users.*;

//****************************************************************************************************************************************************************************
//План тестирования:
// 1. Создать новую причину изменения СПБ. С помощью сортировки добавленную запись поднять наверх - убедится, что значение добавилось
// TODO 2. Сделать попытку создания дубликата причины изменения СПБ с валидными значениями (не должно пропустить) - контроль дубликатов не реализован в данном справочнике в КЗ СПБ
// 3. Изменить причину изменения СПБ (все поля). С помощью сортировки добавленную запись поднять наверх - убедится, что значение изменено
// 4. Удалить причину изменения СПБ. Произвести поиск удаленной строки - убедится, что значение "Наименование" не найдено в таблице
// TODO 5. Произвести попытку создания новой причины изменения СПБ с невалидными значениями
// TODO 6. Произвести попытку редактирования новой причины изменения СПБ с невалидными значениями
//****************************************************************************************************************************************************************************

@Log4j2
public class CertificateChangeCauseDictionaryTest extends BaseTest {

    @BeforeMethod(description = "Перейти на страницу 'Справочник причин изменения сертификата профессионального бухгалтера' под ролью 'Администратор'") //действия, выполняемые перед каждым тестом
    public void precondition(ITestContext context) {
        loginPage
                .openPage()
                .pageTitleShouldHave(LOGIN_PAGE_TITLE)
                .openPage()
                .login(adminLogin, adminPassword)
                .closeNotificationWindow();
        certificateChangeCauseDictionaryPage
                .openPage();
    }

    @Description("Проверить создание новой причины изменения СПБ с валидными значениями параметров. Создание произвести под ролью 'Администратор', как наиболее характерной для создания причины изменения СПБ. После проверки создания причины изменения СПБ удалить ее (используя API)") //описание теста в Allure
    @Test(priority = 1, description = "Создать новую причину изменения СПБ с помощью UI (валидные значения)") //приоритет теста, название теста в Allure
    public void createChangeCause_UI(ITestContext context) throws InterruptedException, IOException {

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований признаков изменения с целью последующего выбора из данного списка при создании новой причины изменения СПБ");
        Thread.sleep(1000);
        certificateChangeCauseDictionaryPage
                .openAddDialog();
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE + "'");
        CertificateChangeCauseDictionary newChangeCause = CertificateChangeCauseDictionaryFactory.get("AAТест_наименование", "Дубликат");
        certificateChangeCauseDictionaryCreatePage
                .createNewChangeCause(CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE, newChangeCause)
                .tableHeaderSortUp(1)
                .tableCellValueShouldHave("0", 1, newChangeCause.getName())
                .tableCellValueShouldHave("0", 2, newChangeCause.getSign())
                .tableCellValueShouldHave("0", 3, adminLogin)
                .tableCellValueShouldHave("0", 4, createChangeCauseDateTime)
                .deleteChangeCause("0"); //TODO удалить причину изменения СПБ с помощью API;

    }

    @Description("Создать причину изменения СПБ (используя API). Проверить редактирование причины изменения СПБ с валидными значениями параметров. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования причины изменения СПБ. После проверки редактирования причины изменения СПБ, удалить ее (используя API)")
    @Test(priority = 2, description = "Отредактировать причину изменения СПБ с помощью UI (валидные значения)")
    public void updateChangeCause_UI(ITestContext context) throws InterruptedException, IOException {

        //TODO создание причины изменения СПБ произвести с помощью API
        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований признаков изменения с целью последующего выбора из данного списка при создании новой причины изменения СПБ");
        Thread.sleep(1000);
        certificateChangeCauseDictionaryPage
                .openAddDialog();
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE + "'");
        CertificateChangeCauseDictionary newChangeCause = CertificateChangeCauseDictionaryFactory.get("ААТест_наименование", "Дубликат");
        //TODO кода исправят сортировку в таблице, нужно сначала сортировать по убыванию дат, тогда добавленная строка будет первой и в метод tableCellValueShouldHave подставлять индекс строки = 0. Так тест будет устойчивей
        certificateChangeCauseDictionaryCreatePage
                .createNewChangeCause(CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE, newChangeCause)
                .tableHeaderSortUp(1);

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований признаков изменения с целью последующего выбора из данного списка при редактировании причины изменения СПБ");
        Thread.sleep(1000);
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования созданной причины изменения СПБ");
        CertificateChangeCauseDictionary updateChangeCause = CertificateChangeCauseDictionaryFactory.get("ААТест_наименование_update", "Изменение");
        certificateChangeCauseDictionaryPage
                .openUpdateDialog("0")
                .updateChangeCause(CERTIFICATE_CHANGE_CAUSE_UPDATE_TITLE, updateChangeCause)
                .tableCellValueShouldHave("0", 1, updateChangeCause.getName())
                .tableCellValueShouldHave("0", 2, updateChangeCause.getSign())
                .tableCellValueShouldHave("0", 3, adminLogin)
                .tableCellValueShouldHave("0", 4, updateChangeCauseDateTime)
                .deleteChangeCause("0"); //TODO удалить причину изменения СПБ с помощью API
    }

    @Description("Создать причину изменения СПБ (используя API). Проверить удаление причины изменения СПБ с помощью UI. Удаление произвести под ролью 'Администратор', как наиболее характерной для удаления причины изменения СПБ")
    @Test(priority = 3, description = "Удалить причину изменения СПБ с помощью UI")
    public void deleteChangeCause_UI(ITestContext context) throws InterruptedException, IOException {

        //TODO создание причины изменения СПБ произвести с помощью API
        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований признаков изменения с целью последующего выбора из данного списка при создании новой причины изменения СПБ");
        Thread.sleep(1000);
        certificateChangeCauseDictionaryPage
                .openAddDialog();
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE + "'");
        CertificateChangeCauseDictionary changeCause = CertificateChangeCauseDictionaryFactory.get("ААТест_наименование", "Дубликат");
        certificateChangeCauseDictionaryCreatePage
                .createNewChangeCause(CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE, changeCause)
                .tableHeaderSortUp(1);

        certificateChangeCauseDictionaryPage
                .deleteChangeCause("0")
                .tableDataShouldNotBeVisible(changeCause.getName());
    }
}
