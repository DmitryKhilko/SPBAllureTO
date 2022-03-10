package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.AteDictionary;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static pages.base.ConstantsUIAteDistionary.*;

@Log4j2
public class AteDictionaryUpdatePage extends BasePage {

    //***************************************************************************************************************************************
    //Локаторы диалогового окна 'Редактирование позиции в справочник АТЕ'
    //***************************************************************************************************************************************

    //TODO!!! Создать элементы InputDialogWindow и DropDownDialogWindow (в диалоговых окнах они одинаковы как для создания, так и для редактирования)

    public SelenideElement ateUpdateTitle = $(By.xpath("//div[@class='ant-modal-title']")); //заголовок диалогового окна
    public static final String ateUpdateDropdownLocator = "//div[@class='ant-modal-content']//label[contains(@title,'%s')]/ancestor::div[contains(@class, 'ant-row ant-form-item')]//input[contains(@class, 'ant-input')]"; //раскрывающийся список "Наименование родителя": поле
    public static final String ateUpdateDropdownListLocator = "//div[@class='ant-modal-content']//li[contains(@title,'%s')]"; //раскрывающийся список "Наименование родителя": собственно список значений
    public static final String ateUpdateInputLocator = "//div[@class='ant-modal-content']//label[@title='%s']/ancestor::div[contains(@class, 'ant-row ant-form-item')]//input[contains(@class, 'ant-input')]"; //поля ввода "Наименование", "Орган управления"
    public static final String ateUpdateButtonLocator = "//div[@class='ant-modal-content']//span[text()='%s']/ancestor::button"; //кнопки 'OK', 'Отмена'

    public AteDictionaryUpdatePage(ITestContext context) {
        super(context);
    }

    @Step("Отредактировать ATE")
    public AteDictionaryPage updateATE(String titleDialogWindow, AteDictionary ateDictionary) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшееся диалоговое окно редактирования АТЕ заголовок '" + titleDialogWindow + "'");
        ateUpdateTitle.shouldHave(exactText(titleDialogWindow));
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать из раскрывающегося списка  '" + ATE_UPDATE_PARENT_NAME_LABEL + "' значение '" + ateDictionary.getParentName() + "'");
        $(By.xpath(String.format(ateUpdateDropdownLocator, ATE_UPDATE_PARENT_NAME_LABEL))).click(); //раскрыть список кликом
        //$(By.xpath(String.format(ateUpdateDropdownListLocator, ateDictionary.getParentName()))).shouldBe(visible); //дождаться отображения в списке нужного значения наименования родителя
        $(By.xpath(String.format(ateUpdateDropdownListLocator, ateDictionary.getParentName()))).click(); //выбрать кликом нужное значение наименование родителя
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + ATE_UPDATE_NAME_LABEL + "' значение '" + ateDictionary.getName() + "'");
        $(By.xpath(String.format(ateUpdateInputLocator, ATE_UPDATE_NAME_LABEL))).clear();
        $(By.xpath(String.format(ateUpdateInputLocator, ATE_UPDATE_NAME_LABEL))).setValue(ateDictionary.getName());
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + ATE_UPDATE_GOVERNMENT_LABEL + "' значение '" + ateDictionary.getGovernment() + "'");
        $(By.xpath(String.format(ateUpdateInputLocator, ATE_UPDATE_GOVERNMENT_LABEL))).clear();
        $(By.xpath(String.format(ateUpdateInputLocator, ATE_UPDATE_GOVERNMENT_LABEL))).setValue(ateDictionary.getGovernment());
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_UPDATE_BUTTON_OK + "' для изменения АТЕ");
        $(By.xpath(String.format(ateUpdateButtonLocator, ATE_UPDATE_BUTTON_OK))).click();
        return new AteDictionaryPage(context); //Инициализуем страницу, на которую переходим
    }
}
