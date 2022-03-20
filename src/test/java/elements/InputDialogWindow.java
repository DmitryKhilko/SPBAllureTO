package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class InputDialogWindow {

    //*****************************************************************************************************************************************************************************
    //Локаторы элемента; переменные, используемые в методах элемента
    //*****************************************************************************************************************************************************************************
    String inputLocator = "//div[@class='ant-modal-content']//label[@title='%s']/ancestor::div[contains(@class, 'ant-row ant-form-item')]//input[contains(@class, 'ant-input')]"; //поля ввода диалоговых окон. Данные локатор отличается от иных полей ввода на div[@class='ant-modal-content']
    String label;//название поля ввода

    //*****************************************************************************************************************************************************************************
    //Методы элемента
    //*****************************************************************************************************************************************************************************
    //Конструктор для подстановки переменных в методы элемента
    public InputDialogWindow(String label) {
        this.label = label;
    }

    //Метод, вводящий тест в поле ввода
    public void write(String text) {
        $(By.xpath(String.format(inputLocator, this.label))).clear();
        $(By.xpath(String.format(inputLocator, this.label))).setValue(text);
    }
}
