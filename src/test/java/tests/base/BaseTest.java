package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MailboxInboxPage;
import utils.PropertyReader;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public abstract class BaseTest {

    public String superuserLogin, superuserPassword, superuserName;
    public String adminLogin, adminPassword, adminName;
    public String specialistMinfinLogin, specialistMinfinPassword, specialistMinfinName;
    public String memberCommissionLogin, memberCommissionPassword, memberCommissionName;
    public String secretaryCommissionLogin, secretaryCommissionPassword, secretaryCommissionName;

    public LoginPage loginPage;
    public MailboxInboxPage mailboxInboxPage;
    public HeaderPage headerPage;

    @Parameters({"BROWSER"})
    @BeforeMethod(description = "Настроить и открыть браузер") //предусловие
    public void setUp(@Optional("chrome") String browser, ITestContext context, ITestResult result){
        log.info("Тест " + result.getMethod().getMethodName() + ": запустить выполнение теста в браузере '" + browser + "'");
        switch (browser) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "edge":
                Configuration.browser = "edge";
                break;
        }

        Configuration.headless = true; //браузер запускается без UI. Тесты ускоряются и становятся более стабильными. Браузер использует меньше ОЗУ (где-то в 3 раза). Этот режим просто необходим при параллелоьном запуске тестов
        Configuration.browserPosition = "0x0"; //команда задает позицию левого верхнего угла браузера. Без нее браузер при запуске смещен немного вправо, что может привести к невидимости каких-то элементов.
        Configuration.browserSize = "1920x1080"; //задает разрешение, с каким запускается браузер. Этот параметр, как и виды браузеров важен и может потребоваться тестировать на разных разрешениях.
        Configuration.timeout = 10000; // неявное ожидание в милисекундах (10 секунд), указывающее на то, какое максимальное количество времени Selenium будет дожидаться появления элемента (аналог implicitlyWait)
        Configuration.savePageSource = false; //при падении теста не сохраняет Page source (file:/D:/Projects/SPB/build/reports/tests/1644796597073.11.html)

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false)); //Для взаимодействия Selenide и Allure (https://ru.selenide.org/documentation/reports.html#allure-report)

        //Разобраться, как преобразовать PropertyReader, чтобы он мог обрабатывать кириллицу (описание проблемы в файле "Описание проекта SPB.docx")
        //Временное решение, пока не разберусь с кодировкой config.propertys - параметры с кириллицей объявить как переменные
        superuserLogin = System.getenv().getOrDefault("SPB_SUPERUSERLOGIN", PropertyReader.getProperty("spb.superuserLogin")); //команда, берущая значение для переменной или для настроек CI (SPB_SUPERUSERLOGIN) из настройки spb.superuserLogin файла config.properties
        superuserPassword = System.getenv().getOrDefault("SPB_SUPERUSERPASSWORD", PropertyReader.getProperty("spb.superuserPassword"));
        //superuserName = System.getenv().getOrDefault("SPB_SUPERUSERNAME", PropertyReader.getProperty("spb.superuserName"));
        superuserName = "Хилько Т.Ю.";

        adminLogin = System.getenv().getOrDefault("SPB_ADMINLOGIN", PropertyReader.getProperty("spb.adminLogin"));
        adminPassword = System.getenv().getOrDefault("SPB_ADMINPASSWORD", PropertyReader.getProperty("spb.adminPassword"));
        //adminName = System.getenv().getOrDefault("SPB_ADMINNAME", PropertyReader.getProperty("spb.adminName"));
        adminName = "Петров П.П.";

        specialistMinfinLogin = System.getenv().getOrDefault("SPB_SPECIALISTMINFINLOGIN", PropertyReader.getProperty("spb.specialistMinfinLogin"));
        specialistMinfinPassword = System.getenv().getOrDefault("SPB_SPECIALISTMINFINPASSWORD", PropertyReader.getProperty("spb.specialistMinfinPassword"));
        //specialistMinfinName = System.getenv().getOrDefault("SPB_SPECIALISTMINFINNAME", PropertyReader.getProperty("spb.specialistMinfinName"));
        specialistMinfinName = "Самохина И.В.";

        secretaryCommissionLogin = System.getenv().getOrDefault("SPB_SECRETARYCOMMISSIONLOGIN", PropertyReader.getProperty("spb.secretaryCommissionLogin"));
        secretaryCommissionPassword = System.getenv().getOrDefault("SPB_SECRETARYCOMMISSIONPASSWORD", PropertyReader.getProperty("spb.secretaryCommissionPassword"));
        //secretaryCommissionName = System.getenv().getOrDefault("SPB_SECRETARYCOMMISSIONNAME", PropertyReader.getProperty("spb.secretaryCommissionName"));
        secretaryCommissionName = "Свиридова Н.И.";

        memberCommissionLogin = System.getenv().getOrDefault("SPB_MEMBERCOMMISSIONLOGIN", PropertyReader.getProperty("spb.memberCommissionLogin"));
        memberCommissionPassword = System.getenv().getOrDefault("SPB_MEMBERCOMMISSIONPASSWORD", PropertyReader.getProperty("spb.memberCommissionPassword"));
        //memberCommissionName = System.getenv().getOrDefault("SPB_MEMBERCOMMISSIONNAME", PropertyReader.getProperty("spb.memberCommissionName"));
        memberCommissionName = "Савина Т.Н.";







        context.setAttribute("testName", result.getMethod().getMethodName()); //передаем имя выполняемого теста в методы тестового фреймворка для наглядного формирования логов

        //Инициализация страниц (которые описаны в пакете pages), с которыми мы будем работать в тестах
        loginPage = new LoginPage(context);
        mailboxInboxPage = new MailboxInboxPage(context);
        headerPage = new HeaderPage(context);
    }

    @AfterMethod(alwaysRun = true, description = "Закрыть браузер") //постусловие
    public void tearDown(ITestResult result) {
        getWebDriver().quit(); //явным образом после каждого теста, расположенного в классе, закрываем браузер, так как по умолчанию в Selenide браузер закрывается по завершению всех методов класса
        log.info("Тест " + result.getMethod().getMethodName() + ": закончить выполнение теста"); //команда лога, куда передается имя выполняемого теста
    }
}
