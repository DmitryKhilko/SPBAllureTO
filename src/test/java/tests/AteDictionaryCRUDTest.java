package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import models.dictionary.AteDictionary;
import models.dictionary.AteDictionaryFactory;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import tests.base.BaseClassTest;
import java.io.IOException;
import static pages.base.ConstantsUIAteDistionary.*;
import static pages.dictionary.AteDictionaryCreatePage.*;
import static pages.dictionary.AteDictionaryUpdatePage.*;
import static tests.base.Users.*;

//****************************************************************************************************************************************************************************
//План тестирования:
// 1. Создать новый АТЕ со значениями согласно попарного тестирования. С помощью фильтра отобрать созданный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение добавилось
// TODO 2. Сделать попытку создания дубликата АТЕ с валидными значениями (не должно пропустить) - контроль дубликатов не реализован в данном справочнике в КЗ СПБ
// 3. Изменить созданный АТЕ (все поля). С помощью фильтра отобрать измененный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение изменилось
// 4. Удалить измененный АТЕ. С помощью фильтра сделать попытку отобрать удаленный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение не найдено
// TODO 5. Произвести попытку создания нового АТЕ с невалидными значения
// TODO 6. Произвести попытку редактирования АТЕ с невалидными значениями
//****************************************************************************************************************************************************************************

@Log4j2
public class AteDictionaryCRUDTest extends BaseClassTest {

    @Description("Создать новый АТЕ с валидными значениями параметров. Создание произвести под ролью 'Администратор', как наиболее характерной для добавления АТЕ") //описание теста в Allure
    @Test(priority = 20, description = "Создать новый АТЕ (валидные значения)") //приоритет теста, название теста в Allure
    public void createATE_admin(ITestContext context) throws InterruptedException, IOException {
         loginPage
                .openPage()
                .login(adminLogin, adminPassword)
                .closeNotificationWindow();
        ateDictionaryPage
                .openPage();

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при добавлении нового АТЕ");
        Thread.sleep(1500);

        ateDictionaryPage
                .openAddDialog();

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для заполнения полей диалогового окна '" + ATE_CREATE_TITLE + "'");
        AteDictionary newAte = AteDictionaryFactory.get("Брестская обл.", "г. Берёза", "Берёзовский РИК");

        ateDictionaryCreatePage
                .createNewATE(ATE_CREATE_TITLE, newAte)
                .showFilters()
                .filterData(newAte)
                .tableCellValueShouldHave("0", 1, newAte.getParentName())
                .tableCellValueShouldHave("0", 2, newAte.getName())
                .tableCellValueShouldHave("0", 3, newAte.getGovernment())
                .tableCellValueShouldHave("0", 4, createDateTime)
                .tableCellValueShouldHave("0", 5, adminLogin);
    }

    @Description("Произвести редактирование АТЕ с валидными значениями параметров. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования АТЕ")
    @Test(priority = 21, description = "Отредактировать АТЕ (валидные значения)")
    public void updateATE_admin(ITestContext context) throws InterruptedException, IOException {

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при редактировании АТЕ");
        Thread.sleep(1500);

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для отбора ранее созданного тестового АТЕ");
        AteDictionary ate = AteDictionaryFactory.get("Брестская обл.", "г. Берёза", "Берёзовский РИК");

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования ранее созданного АТЕ");
        AteDictionary updateAte = AteDictionaryFactory.get("Витебская обл.", "г. Берёза_1", "Берёзовский РИК_1");

        ateDictionaryPage
                .openUpdateDialog("0")
                .updateATE(ATE_UPDATE_TITLE, updateAte);
        ateDictionaryFilterPage
                .filterData(updateAte)
                .tableCellValueShouldHave("0", 1, updateAte.getParentName())
                .tableCellValueShouldHave("0", 2, updateAte.getName())
                .tableCellValueShouldHave("0", 3, updateAte.getGovernment())
                .tableCellValueShouldHave("0", 4, updateDateTime)
                .tableCellValueShouldHave("0", 5, adminLogin);
    }

    @Description("Произвести удаление АТЕ. Удаление произвести под ролью 'Администратор', как наиболее характерной для удаления АТЕ")
    @Test(priority = 22, description = "Удалить АТЕ")
    public void deleteATE_admin(ITestContext context) {

        ateDictionaryPage
                .deleteATE("0")
                .tableDataShouldNotBeVisible();
    }
}
