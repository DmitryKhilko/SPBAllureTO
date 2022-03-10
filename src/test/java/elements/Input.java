package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {

    String inputLocator = "//label[@title='%s']/ancestor::div[contains(@class, 'ant-row ant-form-item')]//input[contains(@class, 'ant-input')]";
    String inputErrorMessageLocator = "//label[contains(@title,'%s')]/ancestor::div[contains(@class, 'ant-row ant-form-item')]//div[@class='ant-form-explain']"; //если не заполнен Input под ним сообщение появляется
    String label;

    public Input(String label) {
        this.label = label;
    }

    //Метод, вводящий тест в Input
    public void write(String text) {
        $(By.xpath(String.format(inputLocator, this.label))).clear();
        $(By.xpath(String.format(inputLocator, this.label))).setValue(text);
    }

    //Метод, возвращающий веб-элемент - сообщение об ошибке при незаполненном или неправильно заполненном поле ввода
    public SelenideElement inputErrorMessage() {
        return $(By.xpath(String.format(inputErrorMessageLocator, this.label)));
    }
}
