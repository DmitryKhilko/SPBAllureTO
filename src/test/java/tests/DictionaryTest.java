package tests;

import com.google.common.collect.Table;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import models.dictionary.*;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.IOException;

import static pages.base.ConstantsUIAteDistionary.*;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.*;
import static pages.base.ConstantsUIMessage.*;
import static pages.base.ConstantsUIRoleDistionary.*;
import static pages.dictionary.AteDictionaryCreatePage.*;
import static pages.dictionary.AteDictionaryUpdatePage.*;
import static pages.dictionary.CertificateChangeCauseDictionaryCreatePage.*;
import static pages.dictionary.CertificateChangeCauseDictionaryUpdatePage.*;
import static pages.dictionary.RoleDictionaryUpdatePage.*;
import static tests.base.Users.*;

@Log4j2
public class DictionaryTest extends BaseTest {

    @BeforeMethod(description = "Перейти на страницу 'Справочник АТЕ' под ролью 'Администратор'") //действия, выполняемые перед каждым тестом
    public void precondition(ITestContext context) {
        loginPage
                .openPage()
                .login(adminLogin, adminPassword)
                .closeNotificationWindow();
    }

//****************************************************************************************************************************************************************************
//План тестирования страницы 'Справочник АТЕ':
// 1. Создать новый АТЕ со значениями согласно попарного тестирования. С помощью фильтра отобрать созданный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение добавилось
// TODO 2. Сделать попытку создания дубликата АТЕ с валидными значениями (не должно пропустить) - контроль дубликатов не реализован в данном справочнике в КЗ СПБ
// 3. Изменить созданный АТЕ (все поля). C помощью фильтра отобрать измененный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение изменилось
// 4. Удалить измененный АТЕ. С помощью фильтра сделать попытку отобрать удаленный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение не найдено
// TODO 5. Произвести попытку создания нового АТЕ с невалидными значения
// TODO 6. Произвести попытку редактирования АТЕ с невалидными значениями
//****************************************************************************************************************************************************************************

    @Test(priority = 1, description = "Создать новый АТЕ с помощью UI (валидные значения)") //приоритет теста, название теста в Allure
    @Description("Проверить создание нового АТЕ с помощью UI с валидными значениями параметров. Создание произвести под ролью 'Администратор', как наиболее характерной для добавления АТЕ. После проверки создания нового АТЕ удалить АТЕ (используя API)") //описание теста в Allure
    public void createATE_UI(ITestContext context) throws InterruptedException, IOException {

        ateDictionaryPage
                .openPage();

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при создании нового АТЕ");
        Thread.sleep(1000);
        ateDictionaryPage
                .openAddDialog();
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + ATE_CREATE_TITLE + "'");
        AteDictionary newAte = AteDictionaryFactory.get("Брестская обл.", "г. Тестовый", "Тестовый РИК");
        ateDictionaryCreatePage
                .createNewATE(ATE_CREATE_TITLE, newAte)
                .showFilters()
                .filterData(newAte)
                .tableCellValueShouldHave("0", 1, newAte.getParentName())
                .tableCellValueShouldHave("0", 2, newAte.getName())
                .tableCellValueShouldHave("0", 3, newAte.getGovernment())
                .tableCellValueShouldHave("0", 4, adminLogin)
                .tableCellValueShouldHave("0", 5, createATEDateTime)
                .deleteATE("0"); //TODO удалить АТЕ с помощью API
    }

    @Test(priority = 2, description = "Отредактировать АТЕ с помощью UI (валидные значения)")
    @Description("Создать АТЕ (используя API). Проверить редактирование ATE с помощью UI с валидными значениями параметров. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования АТЕ. После проверки редактирования АТЕ, удалить АТЕ (используя API)")
    public void updateATE_UI(ITestContext context) throws InterruptedException, IOException {

        ateDictionaryPage
                .openPage();

        //TODO создание АТЕ произвести с помощью API
        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при создании нового АТЕ");
        Thread.sleep(1000);
        ateDictionaryPage
                .openAddDialog();
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + ATE_CREATE_TITLE + "'");
        AteDictionary newAte = AteDictionaryFactory.get("Брестская обл.", "г. Тестовый_1", "Тестовый РИК_1");
        ateDictionaryCreatePage
                .createNewATE(ATE_CREATE_TITLE, newAte);

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при редактировании АТЕ");
        Thread.sleep(1000);
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для отбора ранее созданного тестового АТЕ");
        AteDictionary ate = AteDictionaryFactory.get("Брестская обл.", "г. Тестовый_1", "Тестовый РИК_1");
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования ранее созданного АТЕ");
        AteDictionary updateAte = AteDictionaryFactory.get("Витебская обл.", "г. Тестовый_update", "Тестовый РИК_update");
        ateDictionaryPage
                .showFilters()
                .filterData(ate)
                .openUpdateDialog("0")
                .updateATE(ATE_UPDATE_TITLE, updateAte);
        ateDictionaryFilterPage
                .filterData(updateAte)
                .tableCellValueShouldHave("0", 1, updateAte.getParentName())
                .tableCellValueShouldHave("0", 2, updateAte.getName())
                .tableCellValueShouldHave("0", 3, updateAte.getGovernment())
                .tableCellValueShouldHave("0", 4, adminLogin)
                .tableCellValueShouldHave("0", 5, updateDateTime)
                .deleteATE("0"); //TODO удалить АТЕ с помощью API
    }

    @Test(priority = 3, description = "Удалить АТЕ с помощью UI")
    @Description("Создать АТЕ (используя API). Проверить удаление АТЕ с помощью UI. Удаление произвести под ролью 'Администратор', как наиболее характерной для удаления АТЕ")
    public void deleteATE_UI(ITestContext context) throws InterruptedException, IOException {

        ateDictionaryPage
                .openPage();

        //TODO создание АТЕ произвести с помощью API
        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при создании нового АТЕ");
        Thread.sleep(1000);
        ateDictionaryPage
                .openAddDialog();
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + ATE_CREATE_TITLE + "' и последующего удаления созданного АТЕ");
        AteDictionary ate = AteDictionaryFactory.get("Брестская обл.", "г. Тестовый_2", "Тестовый РИК_2");
        ateDictionaryCreatePage
                .createNewATE(ATE_CREATE_TITLE, ate);

        ateDictionaryPage
                .showFilters()
                .filterData(ate)
                .deleteATE("0")
                .tableDataShouldNotBeVisible();
    }

//****************************************************************************************************************************************************************************
//План тестирования страницы 'Справочник оплат':
// TODO 1. Создать новый вид оплаты. Реализовать после добавления функционала удаления
// TODO 2. Сделать попытку создания дубликата вида оплаты с валидными значениями (не должно пропустить) - контроль дубликатов не реализован в данном справочнике в КЗ СПБ
// 3. Изменить вид оплаты (все поля).
// TODO 4. Удалить созданных вид оплаты. Функционал еще не реализован
// TODO 5. Произвести попытку создания нового АТЕ с невалидными значения
// TODO 6. Произвести попытку редактирования АТЕ с невалидными значениями
//****************************************************************************************************************************************************************************

    @Ignore
    @Test(priority = 11, description = "Отредактировать вид оплаты с помощью UI (валидные значения)")
    @Description("Проверить редактирование вида оплаты с валидными значениями параметров. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования роли.")
    public void updatePayment_UI(ITestContext context) {

        roleDictionaryPage
                .openPage()
                .tableHeaderSortUp(1);
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с исходным названием вида оплаты");
        RoleDictionary Role = RoleDictionaryFactory.get(roleDictionaryPage.tableCellValue("0",1));
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования вида оплаты");
        RoleDictionary updateRole = RoleDictionaryFactory.get(Role.getName() + "_update");

        roleDictionaryPage
                //редактируем вид оплаты
                .openUpdateDialog("0")
                .updateRole(ROLE_UPDATE_TITLE, updateRole)
                .tableCellValueShouldHave("0", 1, updateRole.getName())
                .tableCellValueShouldHave("0", 2, adminLogin)
                .tableCellValueShouldHave("0", 3, updateRoleDateTime)
                //возвращаем исходные значения для вида оплаты
                .openUpdateDialog("0")
                .updateRole(ROLE_UPDATE_TITLE, Role)
                .tableCellValueShouldHave("0", 1, Role.getName())
                .tableCellValueShouldHave("0", 2, adminLogin)
                .tableCellValueShouldHave("0", 3, updateRoleDateTime);
    }

//****************************************************************************************************************************************************************************
//План тестирования справочника 'Справочник причин изменения сертификата профессионального бухгалтера':
// 1. Создать новую причину изменения СПБ. С помощью сортировки добавленную запись поднять наверх - убедится, что значение добавилось
// TODO 2. Сделать попытку создания дубликата причины изменения СПБ с валидными значениями (не должно пропустить) - контроль дубликатов не реализован в данном справочнике в КЗ СПБ
// 3. Изменить причину изменения СПБ (все поля). С помощью сортировки добавленную запись поднять наверх - убедится, что значение изменено
// 4. Удалить причину изменения СПБ. Произвести поиск удаленной строки - убедится, что значение "Наименование" не найдено в таблице
// TODO 5. Произвести попытку создания новой причины изменения СПБ с невалидными значениями
// TODO 6. Произвести попытку редактирования новой причины изменения СПБ с невалидными значениями
//****************************************************************************************************************************************************************************


    @Test(priority = 21, description = "Создать новую причину изменения СПБ с помощью UI (валидные значения)") //приоритет теста, название теста в Allure
    @Description("Проверить создание новой причины изменения СПБ с валидными значениями параметров. Создание произвести под ролью 'Администратор', как наиболее характерной для создания причины изменения СПБ. После проверки создания причины изменения СПБ удалить ее (используя API)") //описание теста в Allure
    public void createChangeCause_UI(ITestContext context) throws InterruptedException, IOException {

        certificateChangeCauseDictionaryPage
                .openPage();

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

    @Test(priority = 22, description = "Отредактировать причину изменения СПБ с помощью UI (валидные значения)")
    @Description("Создать причину изменения СПБ (используя API). Проверить редактирование причины изменения СПБ с валидными значениями параметров. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования причины изменения СПБ. После проверки редактирования причины изменения СПБ, удалить ее (используя API)")
    public void updateChangeCause_UI(ITestContext context) throws InterruptedException, IOException {

        certificateChangeCauseDictionaryPage
                .openPage();

        //TODO создание причины изменения СПБ произвести с помощью API
        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований признаков изменения с целью последующего выбора из данного списка при создании новой причины изменения СПБ");
        Thread.sleep(1000);
        certificateChangeCauseDictionaryPage
                .openAddDialog();
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE + "'");
        CertificateChangeCauseDictionary newChangeCause = CertificateChangeCauseDictionaryFactory.get("ААТест_наименование_1", "Дубликат");
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

    @Test(priority = 23, description = "Удалить причину изменения СПБ с помощью UI")
    @Description("Создать причину изменения СПБ (используя API). Проверить удаление причины изменения СПБ с помощью UI. Удаление произвести под ролью 'Администратор', как наиболее характерной для удаления причины изменения СПБ")
    public void deleteChangeCause_UI(ITestContext context) throws InterruptedException, IOException {

        certificateChangeCauseDictionaryPage
                .openPage();

        //TODO создание причины изменения СПБ произвести с помощью API
        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований признаков изменения с целью последующего выбора из данного списка при создании новой причины изменения СПБ");
        Thread.sleep(1000);
        certificateChangeCauseDictionaryPage
                .openAddDialog();
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE + "'");
        CertificateChangeCauseDictionary changeCause = CertificateChangeCauseDictionaryFactory.get("ААТест_наименование_2", "Дубликат");
        certificateChangeCauseDictionaryCreatePage
                .createNewChangeCause(CERTIFICATE_CHANGE_CAUSE_CREATE_TITLE, changeCause)
                .tableHeaderSortUp(1);

        certificateChangeCauseDictionaryPage
                .deleteChangeCause("0")
                .tableDataShouldNotBeVisible(changeCause.getName());
    }

//****************************************************************************************************************************************************************************
//План тестирования справочника 'Справочник ролей':
// 1. Изменить роль (все поля). С помощью сортировки измененную запись поднять наверх - убедится, что значение изменено
// TODO 2. Произвести попытку редактирования роли с невалидными значениями
//****************************************************************************************************************************************************************************

    @Test(priority = 31, description = "Отредактировать роль с помощью UI (валидные значения)")
    @Description("Проверить редактирование роли с валидными значениями параметров. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования роли. ")
    public void updateRole_UI(ITestContext context) {

        roleDictionaryPage
                .openPage()
        .tableHeaderSortUp(1);
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с исходным названием роли");
        RoleDictionary Role = RoleDictionaryFactory.get(roleDictionaryPage.tableCellValue("0",1));
        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования роли");
        RoleDictionary updateRole = RoleDictionaryFactory.get(Role.getName() + "_update");

        roleDictionaryPage
                 //редактируем роль
                .openUpdateDialog("0")
                .updateRole(ROLE_UPDATE_TITLE, updateRole)
                .tableCellValueShouldHave("0", 1, updateRole.getName())
                .tableCellValueShouldHave("0", 2, adminLogin)
                .tableCellValueShouldHave("0", 3, updateRoleDateTime)
                //возвращаем исходные значения для роли
                .openUpdateDialog("0")
                .updateRole(ROLE_UPDATE_TITLE, Role)
                .tableCellValueShouldHave("0", 1, Role.getName())
                .tableCellValueShouldHave("0", 2, adminLogin)
                .tableCellValueShouldHave("0", 3, updateRoleDateTime);
    }

    @Ignore
    //TODO Почему-то после ввода '' в поле ввода 'Наименование' не появляется сообщение об ошибке! Так же сделать метод проверки появления ошибки отдельно (как завершающий ассерт)
    @Test(priority = 32, description = "Отредактировать роль с помощью UI (наименование пустое)")
    @Description("Проверить попытку редактирования роли с пустым значением наименования. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования роли.")
    public void updateRoleNameEmpty_UI(ITestContext context) throws InterruptedException, IOException {

        roleDictionaryPage
                .openPage();

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования роли");
        RoleDictionary updateRole = RoleDictionaryFactory.get("");
        roleDictionaryPage
                .tableHeaderSortUp(1)
                //изменяем название роли
                .openUpdateDialog("0")
                .updateRoleEmptyName(ROLE_UPDATE_TITLE, updateRole, INPUT_ERROR_MESSAGE);
//        roleDictionaryUpdatePage
//                .nameErrorMessageShouldHave(INPUT_ERROR_MESSAGE);
    }
}
