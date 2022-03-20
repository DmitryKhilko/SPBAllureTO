package pages.dictionary;

import elements.ButtonDialogWindow;
import elements.InputDialogWindow;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.dictionary.PaymentDictionary;
import org.testng.ITestContext;
import pages.base.BasePage;
import static com.codeborne.selenide.Condition.exactText;
import static pages.base.ConstantsUIPaymentDistionary.*;

@Log4j2
public class PaymentDictionaryUpdatePage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы диалогового окна 'Редактирование позиции в справочнике оплат'; переменные, используемые в методах диалогового окна
    //****************************************************************************************************************************************************************************


    //****************************************************************************************************************************************************************************
    //Методы диалогового окна 'Редактирование позиции в справочнике оплат'
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public PaymentDictionaryUpdatePage(ITestContext context) {
        super(context);
    }

    @Step("Отредактировать вид оплаты")
    public PaymentDictionaryPage updatePayment(String title, PaymentDictionary paymentDictionary) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли открывшееся диалоговое окно заголовок '" + title + "'");
        titleDialogWindow.shouldHave(exactText(title));
        log.debug("Тест " + context.getAttribute("testName") + ": ввести в поле ввода  '" + PAYMENT_UPDATE_NAME_LABEL + "' значение '" + paymentDictionary.getName() + "'");
        new InputDialogWindow(PAYMENT_UPDATE_NAME_LABEL).write(paymentDictionary.getName());
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку '" + PAYMENT_UPDATE_BUTTON_OK + "' для изменения вида оплаты");
        new ButtonDialogWindow(PAYMENT_UPDATE_BUTTON_OK).click();
        log.debug("Тест " + context.getAttribute("testName") + ": сохранить дату и время редактирования вида оплаты для проверки успешности редактирования вида оплаты");
        dateTime = cellDateTime();
        log.debug("Тест " + context.getAttribute("testName") + ": перейти на страницу 'PaymentDictionaryPage'");
        return new PaymentDictionaryPage(context);
    }
}
