package pages.dictionary;

import elements.ButtonDialogWindow;
import elements.DropDownDialogWindow;
import elements.InputDialogWindow;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.AteDictionary;
import org.testng.ITestContext;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.exactText;
import static pages.base.ConstantsUIAteDistionary.*;

@Log4j2
public class AteDictionaryUpdatePage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы диалогового окна 'Редактирование позиции в справочник АТЕ'; переменные, используемые в методах диалогового окна
    //****************************************************************************************************************************************************************************


    //****************************************************************************************************************************************************************************
    //Методы диалогового окна 'Редактирование позиции в справочник АТЕ'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public AteDictionaryUpdatePage(ITestContext context) {
        super(context);
    }

    @Step("Отредактировать ATE")
    public AteDictionaryPage updateATE(String title, AteDictionary ateDictionary) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшееся диалоговое окно заголовок '" + title + "'");
        titleDialogWindow.shouldHave(exactText(title));
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать из раскрывающегося списка '" + ATE_UPDATE_PARENT_NAME_LABEL + "' значение '" + ateDictionary.getParentName() + "'");
        new DropDownDialogWindow(ATE_UPDATE_PARENT_NAME_LABEL).selectOption(ateDictionary.getParentName());
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода '" + ATE_UPDATE_NAME_LABEL + "' значение '" + ateDictionary.getName() + "'");
        new InputDialogWindow(ATE_UPDATE_NAME_LABEL).write(ateDictionary.getName());
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода '" + ATE_UPDATE_GOVERNMENT_LABEL + "' значение '" + ateDictionary.getGovernment() + "'");
        new InputDialogWindow(ATE_UPDATE_GOVERNMENT_LABEL).write(ateDictionary.getGovernment());
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_UPDATE_BUTTON_OK + "' для изменения АТЕ");
        new ButtonDialogWindow(ATE_UPDATE_BUTTON_OK).click();
        log.debug("Тест " + context.getAttribute("testName") + ": сохранить дату и время редактирования АТЕ для проверки успешности редактирования АТЕ");
        dateTime = cellDateTime();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'AteDictionaryPage'");
        return new AteDictionaryPage(context);
    }
}
