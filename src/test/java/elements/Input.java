package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Input {

    //*****************************************************************************************************************************************************************************
    //Локаторы элемента; переменные, используемые в методах элемента
    //*****************************************************************************************************************************************************************************
    String inputLocator = "//label[@title='%s']/ancestor::div[contains(@class, 'ant-row ant-form-item')]//input[contains(@class, 'ant-input')]"; //локатор поля ввода. На страницах и в панели фильтра они одинаковы
    String label; //название поля ввода

    //*****************************************************************************************************************************************************************************
    //Методы элемента
    //*****************************************************************************************************************************************************************************
    //Конструктор для подстановки переменных в методы элемента
    public Input(String label) {
        this.label = label;
    }

    //Метод, вводящий тест в поле ввода
    public void write(String text) {
        $(By.xpath(String.format(inputLocator, this.label))).clear();
        $(By.xpath(String.format(inputLocator, this.label))).setValue(text);
    }
}
