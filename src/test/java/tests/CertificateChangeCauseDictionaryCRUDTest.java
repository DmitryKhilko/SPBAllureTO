package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import models.dictionary.CertificateChangeCauseDictionary;
import models.dictionary.CertificateChangeCauseDictionaryFactory;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import tests.base.BaseClassTest;
import java.io.IOException;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.*;
import static pages.dictionary.CertificateChangeCauseDictionaryCreatePage.*;
import static pages.dictionary.CertificateChangeCauseDictionaryUpdatePage.*;
import static tests.base.Users.*;

//****************************************************************************************************************************************************************************
//План тестирования:
// 1. Создать новую причину изменения СПБ АТЕ. С помощью сортировки добавленную запись поднять наверх - убедится, что значение добавилось
// TODO 2. Сделать попытку создания дубликата АТЕ с валидными значениями (не должно пропустить) - контроль дубликатов не реализован в данном справочнике в КЗ СПБ
// 3. Изменить созданный АТЕ (все поля). C помощью фильтра отобрать измененный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение изменилось
// 4. Удалить измененный АТЕ. С помощью фильтра сделать попытку отобрать удаленный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение не найдено
// TODO 5. Произвести попытку создания нового АТЕ с невалидными значения
// TODO 6. Произвести попытку редактирования АТЕ с невалидными значениями
//****************************************************************************************************************************************************************************

@Log4j2
public class CertificateChangeCauseDictionaryCRUDTest extends BaseClassTest {

    @Description("Создать новую причину изменения сертификата профессионального бухгалтера с валидными значениями параметров. Создание произвести под ролью 'Администратор', как наиболее характерной для добавления причины изменения сертификата профессионального бухгалтера") //описание теста в Allure
    @Test(priority = 1, description = "Создать новую причину изменения СПБ (валидные значения)") //приоритет теста, название теста в Allure
    public void createChangeCause_admin(ITestContext context) throws InterruptedException, IOException {
         loginPage
                .openPage()
                .login(adminLogin, adminPassword)
                .closeNotificationWindow();
        certificateChangeCauseDictionaryPage
                .openPage();

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований признаков изменения с целью последующего выбора из данного списка при создании новой причины изменения СПБ");
        Thread.sleep(1500);

        certificateChangeCauseDictionaryPage
                .openAddDialog();

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE + "'");
        CertificateChangeCauseDictionary newChangeCause = CertificateChangeCauseDictionaryFactory.get("Тест_наименование", "Дубликат");

        //TODO кода исправят сортировку в таблице, нужно сначала сортировать по убыванию дат, тогда добавленная строка будет первой и в метод tableCellValueShouldHave подставлять индекс строки = 0. Так тест будет устойчивей
        certificateChangeCauseDictionaryCreatePage
                .createNewChangeCause(CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE, newChangeCause)
                .tableCellValueShouldHave("7", 1, newChangeCause.getName())
                .tableCellValueShouldHave("7", 2, newChangeCause.getSign())
                .tableCellValueShouldHave("7", 3, createChangeCauseDateTime)
                .tableCellValueShouldHave("7", 4, adminLogin);
    }

    @Description("Произвести редактирование причину изменения сертификата профессионального бухгалтера с валидными значениями параметров. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования причину изменения сертификата профессионального бухгалтера")
    @Test(priority = 2, description = "Отредактировать причину изменения СПБ (валидные значения)")
    public void updateChangeCause_admin(ITestContext context) throws InterruptedException, IOException {

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований признаков изменения с целью последующего выбора из данного списка при редактировании причины изменения СПБ");
        Thread.sleep(1500);

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования ранее созданной причины изменения СПБ");
        CertificateChangeCauseDictionary updateChangeCause = CertificateChangeCauseDictionaryFactory.get("Тест_наименование_проверка изменения", "Изменение");

        //TODO кода исправят сортировку в таблице, нужно сначала сортировать по убыванию дат, тогда добавленная строка будет первой и в метод tableCellValueShouldHave подставлять индекс строки = 0. Так тест будет устойчивей
        certificateChangeCauseDictionaryPage
                .openUpdateDialog("7")
                .updateChangeCause(CERTIFICATE_CHANGE_CAUSE_UPDATE_TITLE, updateChangeCause)
                .tableCellValueShouldHave("7", 1, updateChangeCause.getName())
                .tableCellValueShouldHave("7", 2, updateChangeCause.getSign())
                .tableCellValueShouldHave("7", 3, updateChangeCauseDateTime)
                .tableCellValueShouldHave("7", 4, adminLogin);
    }

    @Description("Произвести удаление причину изменения сертификата профессионального бухгалтера. Удаление произвести под ролью 'Администратор', как наиболее характерной для удаления причины изменения сертификата профессионального бухгалтера")
    @Test(priority = 3, description = "Удалить причину изменения СПБ")
    public void deleteChangeCause_admin(ITestContext context) {

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для проверки успешности удаления причины изменения СПБ");
        CertificateChangeCauseDictionary deleteChangeCause = CertificateChangeCauseDictionaryFactory.get("Тест_наименование_проверка изменения", "Изменение");

        //TODO кода исправят сортировку в таблице, нужно сначала сортировать по убыванию дат, тогда добавленная строка будет первой и в метод deleteChangeCause подставлять индекс строки = 0. Так тест будет устойчивей
        certificateChangeCauseDictionaryPage
                .deleteChangeCause("7")
                .tableDataShouldNotBeVisible(deleteChangeCause.getName());
    }
}
