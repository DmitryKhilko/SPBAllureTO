package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Table {

    //*****************************************************************************************************************************************************************************
    //Локаторы элемента; переменные, используемые в методах элемента
    //*****************************************************************************************************************************************************************************
    String cellLocator = "//tr[@index='%s']/td[%s]"; //любая ячейка s-строки и s-столбца таблицы
    String cellButtonLocator = "//tr[@index='%s']//td[@class='ant-table-fixed-columns-in-body action-column']//i[contains(@aria-label, '%s')]/ancestor::button"; //кнопки удаления и редактирования в n-й строке (//div[@class='ant-table-scroll']//tr[@index='0']//i[@aria-label='icon: edit'])
    String buttonConfirmDeletionLocator = "//div[@class='ant-popover-inner-content']//span[text()='%s']/ancestor::button"; //кнопки 'Да', 'Нет' всплывающего окошка "Вы уверены?", появляющегося после нажатия кнопки удаления в строке таблицы
    String tableEmptyDescriptionLocator = "//div[@class='ant-table-scroll']//p[@class='ant-empty-description']"; //если после фильтрации нет данных в таблице, в таблице отображается элемент 'Нет данных'
    String tableSearchRemuveValueLocator = "//tbody[@class='ant-table-tbody']//div[text()='%s']"; //после удаления строки проверка удаления - отсутствия удаленного значения в таблице
    String indexRow; //номер строки таблицы
    int indexColumn; //номер столбца таблицы
    String action; //признак, какую кнопку выбирает пользователь в строке таблицы: карандаш (action = 'edit') или корзину (action = 'delete')
    String confirm; //признак, какую кнопку выбирает пользователь (confirm = 'Да' или confirm = 'Нет') во всплывающем окошке "Вы уверены?", появляющемся после нажатия кнопки удаления в строке таблицы
    String name; //для поиска удаленного из таблицы названия

    //*****************************************************************************************************************************************************************************
    //Методы элемента
    //*****************************************************************************************************************************************************************************
    //Конструктор для подстановки переменных в метод cell()
    public Table(String indexRow, int indexColumn) {
        this.indexRow = indexRow;
        this.indexColumn = indexColumn;
    }

    //Конструктор для подстановки переменных в метод clickCellButton()
    public Table(String indexRow, String action) {
        this.indexRow = indexRow;
        this.action = action;
    }

    //Конструктор для подстановки переменных в метод clickConfirmButton()
    public Table(String confirm) {
        this.confirm = confirm;
    }

    //Пустой конструктор для подстановки переменных в метод tableEmptyDescription()
    public Table() {
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

    //Метод нажатия на кнопки 'Да' или 'Нет' всплывающего окошка "Вы уверены?" после нажатия кнопки удаления в строке таблицы
    public void clickConfirmButton() {
        $(By.xpath(String.format(buttonConfirmDeletionLocator, this.confirm))).hover(); //сначала наводим курсор на кнопку, чтобы убрать всплывающую подсказку (в противном случае не нажимается кнопка)
        $(By.xpath(String.format(buttonConfirmDeletionLocator, this.confirm))).click(); //нажимаем на кнопку
    }

    //Метод, возвращающий элемент индикации отсутствия записей в таблице - 'Нет данных'
    public SelenideElement tableEmptyDescription() {
        return $(By.xpath(tableEmptyDescriptionLocator));
    }

    //Метод проверяющий отсутствие в таблице удаленной строки (отсутствует в таблице искомое наименование)
    public void tableDataShouldNotBeVisible() {
        $(By.xpath(String.format(tableSearchRemuveValueLocator, this.name))).shouldNotBe(visible);
    }
}
