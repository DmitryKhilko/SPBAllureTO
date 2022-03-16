package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import java.io.IOException;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class Table {

    //*****************************************************************************************************************************************************************************
    //Локаторы элемента; переменные, используемые в методах элемента
    //*****************************************************************************************************************************************************************************
    String tableHeaderLocator = "//tr/th[%s]"; //любой заголовок таблицы s-столбца таблицы
    String tableHeaderSortUpLocator = "//tr/th[%s]//span[contains(@style,'display')]//i[@aria-label='icon: caret-up']"; //в заголовке s-столбца стрелочка вверх (символ сортировки по возрастанию)
    String tableHeaderSortDownLocator = "//tr/th[%s]//span[contains(@style,'display')]//i[@aria-label='icon: caret-down']"; //в заголовке s-столбца стрелочка вниз (символ сортировки по убыванию)
    String tableCellLocator = "//tr[@index='%s']/td[%s]"; //любая ячейка s-строки и s-столбца таблицы
    String tableCellButtonLocator = "//tr[@index='%s']//td[@class='ant-table-fixed-columns-in-body action-column']//i[contains(@aria-label, '%s')]/ancestor::button"; //кнопки удаления и редактирования в n-й строке (//div[@class='ant-table-scroll']//tr[@index='0']//i[@aria-label='icon: edit'])
    String buttonConfirmDeletionLocator = "//div[@class='ant-popover-inner-content']//span[text()='%s']/ancestor::button"; //кнопки 'Да', 'Нет' всплывающего окошка "Вы уверены?", появляющегося после нажатия кнопки удаления в строке таблицы
    String tableEmptyDescriptionLocator = "//div[@class='ant-table-scroll']//p[@class='ant-empty-description']"; //если после фильтрации нет данных в таблице, в таблице отображается элемент 'Нет данных'
    String tableSearchRemuveValueLocator = "//tbody[@class='ant-table-tbody']//div[text()='%s']"; //после удаления строки проверка удаления - отсутствия удаленного значения в таблице
    String indexRow; //номер строки таблицы
    int indexColumn; //номер столбца таблицы
    String action; //признак, какую кнопку выбирает пользователь в строке таблицы: карандаш (action = 'edit') или корзину (action = 'delete')
    String confirm; //признак, какую кнопку выбирает пользователь (confirm = 'Да' или confirm = 'Нет') во всплывающем окошке "Вы уверены?", появляющемся после нажатия кнопки удаления в строке таблицы
    String name; //для поиска удаленного из таблицы названия
    //public SelenideElement messageNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]//div[contains(@class,'message')]")); //заголовок окна окна уведомлений (например при возникновении ошибки сортировки)
    public SelenideElement messageNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]/span/div[contains(@class,'notification')]")); //окно уведомлений (например при возникновении ошибки сортировки)

    //*****************************************************************************************************************************************************************************
    //Методы элемента
    //*****************************************************************************************************************************************************************************

    //Конструктор для подстановки переменных в методы tableHeaderSortDown() и tableHeaderSortUp()
    public Table(int indexColumn) {
        this.indexColumn = indexColumn;
    }

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



    //TODO необходимо доделать, не получилось увидеть уведомление об ошибке
    //Метод сортировки по убыванию столбца таблицы (щелчки по заголовку столбца до тех пор, пока стрелочка 'вниз' не станет цветной)
    //Данный метод должен отлавливать ошибки сортировки (появляются после щелчка по заголовку таблицы)
    public void tableHeaderSortDownSearchBags() throws InterruptedException, IOException {
        if ($(By.xpath(String.format(tableHeaderSortDownLocator, this.indexColumn))).getAttribute("class").contains("off")) {
            $(By.xpath(String.format(tableHeaderLocator, this.indexColumn))).click();
            Thread.sleep(100); //делаем задержку, чтобы после щелчка по заголовку столбца таблицы могло появится окно уведомлений, например, об ошибке, связанной с сортировкой
            messageNotificationWindow.shouldNotBe(visible); //при зеленом тесте - окно уведомлений не появляется
            if ($(By.xpath(String.format(tableHeaderSortDownLocator, this.indexColumn))).getAttribute("class").contains("off")) {
                $(By.xpath(String.format(tableHeaderLocator, this.indexColumn))).click();
                Thread.sleep(9900); //делаем задержку, чтобы после щелчка по заголовку столбца таблицы могло появится окно уведомлений, например, об ошибке, связанной с сортировкой
                messageNotificationWindow.shouldNotBe(visible); //при зеленом тесте - окно уведомлений не появляется
            }
        }
    }

    //Метод сортировки по убыванию столбца таблицы (щелчки по заголовку столбца до тех пор, пока стрелочка 'вниз' не станет цветной)
    public void tableHeaderSortDown() {
        if ($(By.xpath(String.format(tableHeaderSortDownLocator, this.indexColumn))).getAttribute("class").contains("off")) {
            $(By.xpath(String.format(tableHeaderLocator, this.indexColumn))).click();
            if ($(By.xpath(String.format(tableHeaderSortDownLocator, this.indexColumn))).getAttribute("class").contains("off")) {
                $(By.xpath(String.format(tableHeaderLocator, this.indexColumn))).click();
            }
        }
    }

    //Метод сортировки по возрастанию столбца таблицы (щелчки по заголовку столбца до тех пор, пока стрелочка 'вверх' не станет цветной)
    public void tableHeaderSortUp() {
        if ($(By.xpath(String.format(tableHeaderSortUpLocator, this.indexColumn))).getAttribute("class").contains("off")) {
            $(By.xpath(String.format(tableHeaderLocator, this.indexColumn))).click();
            if ($(By.xpath(String.format(tableHeaderSortUpLocator, this.indexColumn))).getAttribute("class").contains("off")) {
                $(By.xpath(String.format(tableHeaderLocator, this.indexColumn))).click();
            }
        }
    }

    //TODO доделать, не получилось снять сортировку
    //Метод снятия сортировки со столбца (щелчки по заголовку столбца до тех пор, пока стрелочки 'вверх' и 'вниз' не станут серыми)
    public void tableHeaderUnSort() {
        if ($(By.xpath(String.format(tableHeaderSortUpLocator, this.indexColumn))).getAttribute("class").contains("on") & $(By.xpath(String.format(tableHeaderSortDownLocator, this.indexColumn))).getAttribute("class").contains("off")) {
            $(By.xpath(String.format(tableHeaderLocator, this.indexColumn))).click();
            if ($(By.xpath(String.format(tableHeaderSortUpLocator, this.indexColumn))).getAttribute("class").contains("off") & $(By.xpath(String.format(tableHeaderSortDownLocator, this.indexColumn))).getAttribute("class").contains("on")) {
                $(By.xpath(String.format(tableHeaderLocator, this.indexColumn))).click();
            }
        }
    }

    //Метод, возвращающий элемент - ячейку таблицы
    public SelenideElement cell() {
        return $(By.xpath(String.format(tableCellLocator, this.indexRow, this.indexColumn)));
    }

    //Метод нажатия на кнопки удаления или редактирования в n-й строке
    public void clickCellButton() {
        //Обычный клик не срабатывал. Использовал команду "actions().moveToElement(element).click(element).perform();" (https://ru.selenide.org/2019/12/12/advent-calendar-actions/)
        actions().moveToElement($(By.xpath(String.format(tableCellButtonLocator, this.indexRow, this.action)))).click($(By.xpath(String.format(tableCellButtonLocator, this.indexRow, this.action)))).perform();
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
