package pages.base;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class BasePage {

    public SelenideElement loginButton = $(By.xpath("//button[@type='submit']")); //кнопка "Войти" как в административной части КЗ СПБ, так и на портале

    //Переменная для использования в коде свойств теста
    public ITestContext context;

    //Конструктор для передачи в команду log имени теста
    public BasePage(ITestContext context) {
        this.context = context;
    }

}
