package pages;

import elements.Button;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.AteDictionary;
import org.testng.ITestContext;
import pages.base.BasePage;

import static pages.base.ConstantsUIAteDistionary.*;

@Log4j2
public class AteDictionaryFilterPage extends BasePage {

    //***************************************************************************************************************************************
    //Локаторы страницы
    //***************************************************************************************************************************************



    public AteDictionaryFilterPage(ITestContext context) {
        super(context);
    }

    //***************************************************************************************************************************************
    //Методы страницы
    //***************************************************************************************************************************************
    @Step("Произвести отбор АТЕ")
    public AteDictionaryPage filterData(AteDictionary ateDictionary) {
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + ATE_FILTER_PARENT_NAME_LABEL + "' значение '" + ateDictionary.getParentName() + "'");
        new Input(ATE_FILTER_PARENT_NAME_LABEL).write(ateDictionary.getParentName());
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + ATE_FILTER_NAME_LABEL + "' значение '" + ateDictionary.getName() + "'");
        new Input(ATE_FILTER_NAME_LABEL).write(ateDictionary.getName());
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + ATE_FILTER_GOVERNMENT_LABEL + "' значение '" + ateDictionary.getGovernment() + "'");
        new Input(ATE_FILTER_GOVERNMENT_LABEL).write(ateDictionary.getGovernment());
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ATE_FILTER_BUTTON_APPLY + "' для отбора АТЕ");
        new Button(ATE_FILTER_BUTTON_APPLY).clickButton();
        return new AteDictionaryPage(context); //Инициализуем страницу, на которую переходим
    }

}
