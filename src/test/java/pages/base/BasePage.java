package pages.base;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class BasePage {

    //*****************************************************************************************************************************************************************************
    //Локаторы страниц и переменные: локаторы одинаковы на многих страницах, но их не имеет смысла выносить в elements (только один метод или вообще нет методов); общие для всех страниц переменные
    //*****************************************************************************************************************************************************************************
    public static final SelenideElement titleDialogWindow = $(By.xpath("//div[@class='ant-modal-title']")); //заголовок диалогового окна
    public ITestContext context; //переменная для использования в коде свойств теста

    //*****************************************************************************************************************************************************************************
    //Методы страниц: общие для всех страниц
    //*****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public BasePage(ITestContext context) {
        this.context = context;
    }

    //Метод вычисления текущей местной даты и времени для проверки отображения в таблице даты и времени внесения изменений в строку (http://proglang.su/java/date-and-time; https://rukovodstvo.net/posts/id_815/)
    public static String cellDateTime(){
        LocalDateTime dateTime = LocalDateTime.now(); // Gets the current date and time
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        //TODO На данный момент время на тестовом сервере отстает на 1,5 минуты, поэтому проверка времени сейчас вообще невозможна. После настройки тестового сервера можно кроме даты проверять еще и 'HH:mm'б секунды - врядли
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dateTime.format(formatter);
    }
}
