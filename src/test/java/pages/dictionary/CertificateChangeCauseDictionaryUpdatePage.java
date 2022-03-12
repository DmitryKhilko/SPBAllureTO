package pages.dictionary;

import elements.ButtonDialogWindow;
import elements.DropDownDialogWindow;
import elements.InputDialogWindow;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.AteDictionary;
import models.dictionary.CertificateChangeCauseDictionary;
import org.testng.ITestContext;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static pages.base.ConstantsUIAteDistionary.*;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.*;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.CERTIFICATE_CHANGE_CAUSE_CREATE_BUTTON_OK;

@Log4j2
public class CertificateChangeCauseDictionaryUpdatePage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы диалогового окна 'Редактирование позиции в справочнике причин изменения сертификата профессионального бухгалтера'; переменные, используемые в методах диалогового окна
    //****************************************************************************************************************************************************************************
    public static String updateChangeCauseDateTime; //дата и время редактирования причины изменения СПБ

    //****************************************************************************************************************************************************************************
    //Методы диалогового окна 'Редактирование позиции в справочнике причин изменения сертификата профессионального бухгалтера'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public CertificateChangeCauseDictionaryUpdatePage(ITestContext context) {
        super(context);
    }

    @Step("Отредактировать причину изменения СПБ")
    public CertificateChangeCauseDictionaryPage updateChangeCause(String title, CertificateChangeCauseDictionary certificateChangeCauseDictionary) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшееся диалоговое окно редактирования причины изменения СПБ заголовок '" + title + "'");
        titleDialogWindow.shouldHave(exactText(title));
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + CERTIFICATE_CHANGE_CAUSE_UPDATE_NAME_LABEL + "' значение '" + certificateChangeCauseDictionary.getName() + "'");
        new InputDialogWindow(CERTIFICATE_CHANGE_CAUSE_UPDATE_NAME_LABEL).write(certificateChangeCauseDictionary.getName());
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать из раскрывающегося списка  '" + CERTIFICATE_CHANGE_CAUSE_UPDATE_SIGN_LABEL + "' значение '" + certificateChangeCauseDictionary.getSign() + "'");
        new DropDownDialogWindow(CERTIFICATE_CHANGE_CAUSE_UPDATE_SIGN_LABEL).selectOption1(certificateChangeCauseDictionary.getSign());
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + CERTIFICATE_CHANGE_CAUSE_UPDATE_BUTTON_OK + "' для изменения причины изменения СПБ");
        new ButtonDialogWindow(CERTIFICATE_CHANGE_CAUSE_UPDATE_BUTTON_OK).click();
        log.debug("Тест " + context.getAttribute("testName") + ": сохранить дату и время редактирования новой причины изменения СПБ для проверки успешности редактирования причины изменения СПБ");
        updateChangeCauseDateTime = cellDateTime();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'CertificateChangeCauseDictionaryPage'");
        return new CertificateChangeCauseDictionaryPage(context);
    }
}
