package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import models.dictionary.AteDictionary;
import models.dictionary.AteDictionaryFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.IOException;

import static pages.base.ConstantsUIAteDistionary.*;

//****************************************************************************************************************************************************************************
//План тестирования:
// 1. Создать новый АТЕ со значениями согласно попарного тестирования. С помощью фильтра отобрать созданный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение добавилось
// 2. Сделать попытку создания дубликата АТЕ с валидными значениями (не должно пропустить)
// 3. Изменить созданный АТЕ (все поля). С помощью фильтра отобрать измененный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение изменилось
// 4. Удалить измененный АТЕ. С помощью фильтра сделать попытку отобрать удаленный АТЕ (задействовав сразу все поля фильтра) - убедится, что значение не найдено
//****************************************************************************************************************************************************************************

@Log4j2
public class AteDictionaryCRUDTest extends BaseTest {

    @BeforeMethod(description = "Войти в административную часть КЗ СПБ под ролью 'Администратор'. Перейти на страницу 'Справочник АТЕ'") //действия, выполняемые перед каждым тестом
    public void precondition(ITestContext context) {
        loginPage
                .openPage()
                .login(adminLogin, adminPassword)
                .closeNotificationWindow();
        ateDictionaryPage
                .openPage();
    }

    @Description("Добавить новый АТЕ. Добавление произвести под ролью 'Администратор', как наиболее характерной для добавления АТЕ") //описание теста в Allure
    @Test(priority = 1, description = "Добавить новый АТЕ (валидные значения)") //приоритет теста, название теста в Allure
    public void createATE_admin(ITestContext context) throws InterruptedException, IOException {

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при добавлении нового АТЕ");
        Thread.sleep(1000);

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
                .tableCellValueShouldHave("0", 3, newAte.getGovernment());
    }

    @Description("Произвести редактирование АТЕ. Редактирование произвести под ролью 'Администратор', как наиболее характерной для редактирования АТЕ") //описание теста в Allure
    @Test(priority = 2, description = "Отредактировать АТЕ (валидные значения)") //приоритет теста, название теста в Allure
    public void updateATE_admin(ITestContext context) throws InterruptedException, IOException {

        log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при редактировании АТЕ");
        Thread.sleep(1000);

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для отбора ранее созданного тестового АТЕ");
        AteDictionary ate = AteDictionaryFactory.get("Брестская обл.", "г. Берёза", "Берёзовский РИК");

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования ранее созданного АТЕ");
        AteDictionary updateAte = AteDictionaryFactory.get("Витебская обл.", "г. Берёза_1", "Берёзовский РИК_1");

        ateDictionaryPage
                .showFilters()
                .filterData(ate)
                .openUpdateDialog("0")
                .updateATE(ATE_UPDATE_TITLE, updateAte);
        ateDictionaryFilterPage
                .filterData(updateAte)
                .tableCellValueShouldHave("0", 1, updateAte.getParentName())
                .tableCellValueShouldHave("0", 2, updateAte.getName())
                .tableCellValueShouldHave("0", 3, updateAte.getGovernment());
    }

    @Description("Произвести удаление АТЕ. Удаление произвести под ролью 'Администратор', как наиболее характерной для удаления АТЕ") //описание теста в Allure
    @Test(priority = 2, description = "Удалить АТЕ") //приоритет теста, название теста в Allure
    public void deleteATE_admin(ITestContext context) throws InterruptedException, IOException {

        //log.debug("Тест " + context.getAttribute("testName") + ": добавить ожидание, чтобы после перехода на страницу в фоне сформировался список наименований родителей с целью последующего выбора из данного списка при редактировании АТЕ");
        //Thread.sleep(1000);

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для отбора ранее созданного тестового АТЕ");
        AteDictionary ate = AteDictionaryFactory.get("Витебская обл.", "г. Берёза", "Берёзовский РИК");

        log.debug("Тест " + context.getAttribute("testName") + ": создать объект с тестовыми данными для редактирования ранее созданного АТЕ");
        AteDictionary deleteAte = AteDictionaryFactory.get("Витебская обл.", "г. Берёза_1", "Берёзовский РИК_1");

        ateDictionaryPage
                .showFilters()
                .filterData(ate)
                .openUpdateDialog("0")
                .updateATE(ATE_UPDATE_TITLE, deleteAte);
        ateDictionaryFilterPage
                .filterData(deleteAte)
                .tableCellValueShouldHave("0", 1, deleteAte.getParentName())
                .tableCellValueShouldHave("0", 2, deleteAte.getName())
                .tableCellValueShouldHave("0", 3, deleteAte.getGovernment());
    }
}
