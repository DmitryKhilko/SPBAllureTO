package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Button {

    String buttonLocator = "//span[text()='%s']/ancestor::button";
    String buttonName;

    public Button(String buttonName) {
        this.buttonName = buttonName;
    }

    //Метод, возвращающий элемент - кнопку
    public SelenideElement Button() {
        return $(By.xpath(String.format(buttonLocator, this.buttonName)));
    }

    //Метод нажатия на кнопку
    public void clickButton() {
        $(By.xpath(String.format(buttonLocator, this.buttonName))).click();
    }
}
