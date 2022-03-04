package pages.base;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class BasePage {

    //Адреса веб-страниц приложения, берущиеся из параметров CI или файла config.property
    public static final String BASE_URL = System.getenv().getOrDefault("SPB_BASEURL", PropertyReader.getProperty("spb.baseurl"));
    public static final String LOGIN_PAGE_URL = System.getenv().getOrDefault("SPB_LOGINPAGEURL", PropertyReader.getProperty("spb.loginpageurl"));

    //Элементы информационных окошек
    public SelenideElement closeButtonNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]/a"));
    public SelenideElement descriptionNotificationWindow = $(By.xpath("//div[contains(@class,'notification')]//div[contains(@class,'description')]"));

    public ITestContext context;

    //Конструктор для передачи в команду log имени теста
    public BasePage(ITestContext context) {
        this.context = context;
    }

}
