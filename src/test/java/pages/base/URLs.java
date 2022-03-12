package pages.base;

import org.testng.ITestContext;
import utils.PropertyReader;

public class URLs extends BasePage{

    //****************************************************************************************************************************************************************************
    //Константы, связанные с адресами веб-страниц административной части КЗ СПБ
    //****************************************************************************************************************************************************************************
    public static final String BASE_URL = System.getenv().getOrDefault("SPB_BASEURL", PropertyReader.getProperty("spb.baseurl")); //базовая страница. Значение берется из параметров CI или файла config.property
    public static final String LOGIN_PAGE_URL = "/accountants/login"; //страница логина
    public static final String ATE_DICTIONARY_PAGE_URL = "/accountants/administration/ateDictionary"; //справочник АТЕ
    public static final String PAYMENT_DICTIONARY_PAGE_URL = "/accountants/administration/diplomaChangeCauseDictionary"; //справочник оплат
    public static final String CERTIFICATE_CHANGE_CAUSE_DICTIONARY_PAGE_URL = "/accountants/administration/diplomaChangeCauseDictionary"; //справочник причин изменения сертификата профессионального бухгалтера


    //****************************************************************************************************************************************************************************
    //Константы, связанные с адресами веб-страниц портала КЗ СПБ
    //****************************************************************************************************************************************************************************
    public static final String BASE_URL_PORTAL = System.getenv().getOrDefault("SPB_BASEURLPORTAL", PropertyReader.getProperty("spb.baseurlportal")); //базовая страница. Значение берется из параметров CI или файла config.property

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public URLs(ITestContext context) {
        super(context);
    }
}
