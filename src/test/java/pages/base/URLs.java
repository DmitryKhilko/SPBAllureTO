package pages.base;

import org.testng.ITestContext;
import utils.PropertyReader;

public class URLs extends BasePage{

    //Адреса веб-страниц приложения
    public static final String BASE_URL = System.getenv().getOrDefault("SPB_BASEURL", PropertyReader.getProperty("spb.baseurl")); // значение берется из параметров CI или файла config.property
    public static final String LOGIN_PAGE_URL = "/accountants/login";

    public URLs(ITestContext context) {
        super(context);
    }


}
