package elements;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class DropDownDialogWindow {

    //*****************************************************************************************************************************************************************************
    //Локаторы элемента; переменные, используемые в методах элемента
    //*****************************************************************************************************************************************************************************
    String dropdownLocator = "//div[@class='ant-modal-content']//label[contains(@title,'%s')]/ancestor::div[contains(@class, 'ant-row ant-form-item')]//input[contains(@class, 'ant-input')]"; //раскрывающийся список: поле ввода
    String dropdownOptionsLocator = "//div[@class='ant-modal-content']//li[contains(@title,'%s')]"; //раскрывающийся список: собственно список значений

    String dropdownLocator1 = "//div[@class='ant-modal customModal']//label[contains(@title,'%s')]/ancestor::div[@class='ant-row ant-form-item']//div[contains(@class, 'ant-col ant-form-item-control')]"; //второй тип раскрывающегося списка (диалог добавления причины изменения СПБ)
    String dropdownOptionsLocator1 = "//li[contains(text(),'%s')]"; //второй тип раскрывающегося списка: собственно список значений

    String label; //название раскрывающегося списка - "Наименование родителя"

    //*****************************************************************************************************************************************************************************
    //Методы элемента
    //*****************************************************************************************************************************************************************************
    //Конструктор для подстановки переменных в методы элемента
    public DropDownDialogWindow(String label) {
        this.label = label;
    }

    //Метод выбора значения из раскрывающегося списка
    public void selectOption(String option) {
        $(By.xpath(String.format(dropdownLocator, this.label))).click(); //раскрыть список кликом
        $(By.xpath(String.format(dropdownOptionsLocator, option))).click(); //выбрать кликом нужное значение списка
    }

    public void selectOption1(String option) {
        $(By.xpath(String.format(dropdownLocator1, this.label))).click(); //раскрыть список кликом
        $(By.xpath(String.format(dropdownOptionsLocator1, option))).click(); //выбрать кликом нужное значение списка
    }
}
