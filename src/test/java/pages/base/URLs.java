package pages.base;

import org.testng.ITestContext;
import utils.PropertyReader;

public class URLs extends BasePage{

    //Адреса веб-страниц административной части КЗ СПБ
    public static final String BASE_URL = System.getenv().getOrDefault("SPB_BASEURL", PropertyReader.getProperty("spb.baseurl")); // значение берется из параметров CI или файла config.property
    public static final String BASE_URL_PORTAL = System.getenv().getOrDefault("SPB_BASEURLPORTAL", PropertyReader.getProperty("spb.baseurlportal")); // значение берется из параметров CI или файла config.property
    public static final String LOGIN_PAGE_URL = "/accountants/login";
    public static final String ATEDICTIONARY_PAGE_URL = "/accountants/administration/ateDictionary"; //Справочник АТЕ

    //Адреса веб-страниц портала

    public URLs(ITestContext context) {
        super(context);
    }


}
