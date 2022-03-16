package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NotificationWindow {
    //*****************************************************************************************************************************************************************************
    //Локаторы элемента (окна уведомлений); переменные, используемые в методах элемента
    //*****************************************************************************************************************************************************************************
    //Элементы окна уведомлений
    public SelenideElement closeButtonNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]/a")); //кнопка 'крестик' для закрытия окна уведомлений
    public SelenideElement messageNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]//div[contains(@class,'message')]")); //заголовок окна окна уведомлений
    public SelenideElement descriptionNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]//div[contains(@class,'description')]")); //текст сообщения окна уведомлений


    //*****************************************************************************************************************************************************************************
    //Методы элемента
    //*****************************************************************************************************************************************************************************
    //Метод, закрывающий окно уведомлений
    public void close() {
        closeButtonNotificationWindow.shouldBe(visible);
        closeButtonNotificationWindow.click();
    }

    //Метод, проверяющий содержание окном уведомления определенного сообщения
    public void descriptionShouldHave(String message) {
        descriptionNotificationWindow.shouldHave(exactText(message));
    }
}
