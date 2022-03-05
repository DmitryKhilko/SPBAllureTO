package pages.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import utils.PropertyReader;

@Log4j2
public abstract class BasePage {

    //Адреса веб-страниц приложения, берущиеся из параметров CI или файла config.property
    public static final String BASE_URL = System.getenv().getOrDefault("SPB_BASEURL", PropertyReader.getProperty("spb.baseurl"));
    public static final String LOGIN_PAGE_URL = System.getenv().getOrDefault("SPB_LOGINPAGEURL", PropertyReader.getProperty("spb.loginpageurl"));

    public ITestContext context;

    //Конструктор для передачи в команду log имени теста
    public BasePage(ITestContext context) {
        this.context = context;
    }

}
