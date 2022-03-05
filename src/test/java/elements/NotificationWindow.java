package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NotificationWindow {
    //Элементы окна уведомлений
    public SelenideElement closeButtonNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]/a"));
    public SelenideElement descriptionNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]//div[contains(@class,'description')]"));

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
