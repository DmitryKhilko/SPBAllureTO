package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class Table {

    String cellLocator = "//tr[@index='%s']/td[%s]"; //любая ячейка s-строки и s-столбца таблицы
    //String cellButtonLocator = "//div[@class='ant-table-scroll']//tr[@index='%s']//i[contains(@aria-label, '%s')]/ancestor::button"; //кнопки удаления и редактирования в n-й строке (//div[@class='ant-table-scroll']//tr[@index='0']//i[@aria-label='icon: edit'])
    String cellButtonLocator = "//tr[@index='%s']//td[@class='ant-table-fixed-columns-in-body action-column']//i[contains(@aria-label, '%s')]/ancestor::button"; //кнопки удаления и редактирования в n-й строке (//div[@class='ant-table-scroll']//tr[@index='0']//i[@aria-label='icon: edit'])




    String indexRow;
    int indexColumn;
    String action;

    //Конструктор для подстановки переменных в методы
    public Table(String indexRow, int indexColumn) {
        this.indexRow = indexRow;
        this.indexColumn = indexColumn;
    }

    //Конструктор для подстановки переменных в методы
    public Table(String indexRow, String action) {
        this.indexRow = indexRow;
        this.action = action;
    }

    //Метод, возвращающий элемент - ячейку таблицы
    public SelenideElement cell() {
        return $(By.xpath(String.format(cellLocator, this.indexRow, this.indexColumn)));
    }

    //Метод нажатия на кнопки удаления или редактирования в n-й строке
    public void clickCellButton() {
        //Обычный клик не срабатывал. Использовал команду "actions().moveToElement(element).click(element).perform();" (https://ru.selenide.org/2019/12/12/advent-calendar-actions/)
        actions().moveToElement($(By.xpath(String.format(cellButtonLocator, this.indexRow, this.action)))).click($(By.xpath(String.format(cellButtonLocator, this.indexRow, this.action)))).perform();
    }
}
