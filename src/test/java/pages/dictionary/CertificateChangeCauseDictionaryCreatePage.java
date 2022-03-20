package pages.dictionary;

import elements.ButtonDialogWindow;
import elements.DropDownDialogWindow;
import elements.InputDialogWindow;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.CertificateChangeCauseDictionary;
import org.testng.ITestContext;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.exactText;
import static pages.base.ConstantsUICertificateChangeCauseDictionary.*;

@Log4j2
public class CertificateChangeCauseDictionaryCreatePage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы диалогового окна 'Добавление позиции в справочник причин изменения сертификата профессионального бухгалтера'; переменные, используемые в методах диалогового окна
    //****************************************************************************************************************************************************************************


    //***************************************************************************************************************************************
    //Методы диалогового окна 'Добавление позиции в справочник причин изменения сертификата профессионального бухгалтера'
    //***************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public CertificateChangeCauseDictionaryCreatePage(ITestContext context) {
        super(context);
    }

    @Step("Создать новую причину изменения СПБ")
    public CertificateChangeCauseDictionaryPage createNewChangeCause(String title, CertificateChangeCauseDictionary certificateChangeCauseDictionary) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшееся диалоговое окно заголовок '" + title + "'");
        titleDialogWindow.shouldHave(exactText(title));
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода '" + CERTIFICATE_CHANGE_CAUSE_CREATE_NAME_LABEL + "' значение '" + certificateChangeCauseDictionary.getName() + "'");
        new InputDialogWindow(CERTIFICATE_CHANGE_CAUSE_CREATE_NAME_LABEL).write(certificateChangeCauseDictionary.getName());
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать из раскрывающегося списка '" + CERTIFICATE_CHANGE_CAUSE_CREATE_SIGN_LABEL + "' значение '" + certificateChangeCauseDictionary.getSign() + "'");
        new DropDownDialogWindow(CERTIFICATE_CHANGE_CAUSE_CREATE_SIGN_LABEL).selectOption1(certificateChangeCauseDictionary.getSign());
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + CERTIFICATE_CHANGE_CAUSE_CREATE_BUTTON_OK + "' для создания новой причины изменения СПБ");
        new ButtonDialogWindow(CERTIFICATE_CHANGE_CAUSE_CREATE_BUTTON_OK).click();
        log.debug("Тест " + context.getAttribute("testName") + ": сохранить дату и время создания новой причины изменения СПБ для проверки успешности создания новой причины изменения СПБ");
        dateTime = cellDateTime();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'CertificateChangeCauseDictionaryPage'");
        return new CertificateChangeCauseDictionaryPage(context);
    }
}
