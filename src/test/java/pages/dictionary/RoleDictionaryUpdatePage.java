package pages.dictionary;

import elements.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.CertificateChangeCauseDictionary;
import models.dictionary.RoleDictionary;
import org.testng.ITestContext;
import pages.LoginPage;
import pages.base.BasePage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.exactText;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.*;
import static pages.base.ConstantsUILogin.LOGIN_LABEL;
import static pages.base.ConstantsUILogin.PASSWORD_LABEL;
import static pages.base.ConstantsUIRoleDistionary.ROLE_UPDATE_BUTTON_OK;
import static pages.base.ConstantsUIRoleDistionary.ROLE_UPDATE_NAME_LABEL;

@Log4j2
public class RoleDictionaryUpdatePage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы диалогового окна 'Редактирование позиции в справочнике ролей'; переменные, используемые в методах диалогового окна
    //****************************************************************************************************************************************************************************
    public static String updateRoleDateTime; //дата и время редактирования роли

    //****************************************************************************************************************************************************************************
    //Методы диалогового окна 'Редактирование позиции в справочнике ролей'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public RoleDictionaryUpdatePage(ITestContext context) {
        super(context);
    }

    @Step("Отредактировать роль")
    public RoleDictionaryPage updateRole(String title, RoleDictionary roleDictionary) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшееся диалоговое окно заголовок '" + title + "'");
        titleDialogWindow.shouldHave(exactText(title));
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + ROLE_UPDATE_NAME_LABEL + "' значение '" + roleDictionary.getName() + "'");
        new InputDialogWindow(ROLE_UPDATE_NAME_LABEL).write(roleDictionary.getName());
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ROLE_UPDATE_BUTTON_OK + "' для изменения роли");
        new ButtonDialogWindow(ROLE_UPDATE_BUTTON_OK).click();
        log.debug("Тест " + context.getAttribute("testName") + ": сохранить дату и время редактирования роли для проверки успешности редактирования роли");
        updateRoleDateTime = cellDateTime();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'RoleDictionaryPage'");
        return new RoleDictionaryPage(context);
    }

    //Не получилось вывести сообщение об ошибке!!!!
    @Step("Произвести попытку сохранить роль с пустым наименованием")
    public RoleDictionaryUpdatePage updateRoleEmptyName(String title, RoleDictionary roleDictionary, String message) throws InterruptedException, IOException {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшееся диалоговое окно заголовок '" + title + "'");
        titleDialogWindow.shouldHave(exactText(title));
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода '" + ROLE_UPDATE_NAME_LABEL + "' значение '" + roleDictionary.getName() + "'");
        Thread.sleep(2000);
        new InputDialogWindow(ROLE_UPDATE_NAME_LABEL).write(roleDictionary.getName());
        Thread.sleep(2000);
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + ROLE_UPDATE_BUTTON_OK + "' для изменения роли");
        new ButtonDialogWindow(ROLE_UPDATE_BUTTON_OK).click();
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, вывелось ли под полем ввода сообщение об ошибке '" + message + "'");
        new InputErrorMessage(ROLE_UPDATE_NAME_LABEL).message().shouldHave(exactText(message));
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'RoleDictionaryUpdatePage'");
        return this;
    }

//        roleDictionaryUpdatePage
//                .nameErrorMessageShouldHave(INPUT_ERROR_MESSAGE);
}
