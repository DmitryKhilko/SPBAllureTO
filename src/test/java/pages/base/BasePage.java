package pages.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import utils.PropertyReader;

@Log4j2
public abstract class BasePage {



    //Переменные, связанные с названиями пунктов меню
    //Пункты горизонтального меню


    //Переменные, связанные с заголовками страниц
    public static final String loginPageTitle = "Авторизация";


    //Переменная для использования в коде свойств теста
    public ITestContext context;

    //Конструктор для передачи в команду log имени теста
    public BasePage(ITestContext context) {
        this.context = context;
    }

}
