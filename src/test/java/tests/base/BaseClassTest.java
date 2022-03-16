package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import pages.dictionary.*;

@Log4j2
public abstract class BaseClassTest {

    public LoginPage loginPage;
    public HeaderPage headerPage;
    public AteDictionaryPage ateDictionaryPage;
    public AteDictionaryCreatePage ateDictionaryCreatePage;
    public AteDictionaryUpdatePage ateDictionaryUpdatePage;
    public AteDictionaryFilterPage ateDictionaryFilterPage;
    public CertificateChangeCauseDictionaryPage certificateChangeCauseDictionaryPage;
    public CertificateChangeCauseDictionaryCreatePage certificateChangeCauseDictionaryCreatePage;
    public CertificateChangeCauseDictionaryUpdatePage certificateChangeCauseDictionaryUpdatePage;

    @Parameters({"BROWSER"})
    @BeforeClass(description = "Настроить и открыть браузер") //предусловие
    public void setUp(@Optional("chrome") String browser, ITestContext context, ITestResult result) {

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

        //Инициализация страниц, описанные в пакете pages, с которыми производится работа в тестах
        loginPage = new LoginPage(context);
        headerPage = new HeaderPage(context);
        ateDictionaryPage = new AteDictionaryPage(context);
        ateDictionaryCreatePage = new AteDictionaryCreatePage(context);
        ateDictionaryUpdatePage = new AteDictionaryUpdatePage(context);
        ateDictionaryFilterPage = new AteDictionaryFilterPage(context);
        certificateChangeCauseDictionaryPage = new CertificateChangeCauseDictionaryPage(context);
        certificateChangeCauseDictionaryCreatePage = new CertificateChangeCauseDictionaryCreatePage(context);
        certificateChangeCauseDictionaryUpdatePage = new CertificateChangeCauseDictionaryUpdatePage(context);
    }

    @BeforeMethod(description = "Запустить выполнение теста") //предусловие
    public void beginTest(ITestContext context, ITestResult result) {
        context.setAttribute("testName", result.getMethod().getMethodName()); //передаем имя выполняемого теста в методы тестового фреймворка для наглядного формирования логов
        log.info("Тест " + result.getMethod().getMethodName() + ": запустить выполнение теста");
    }

    @AfterMethod(alwaysRun = true, description = "Закончить выполнение теста") //постусловие
    public void endTest(ITestContext context, ITestResult result) {
        log.info("Тест " + result.getMethod().getMethodName() + ": закончить выполнение теста"); //команда лога, куда передается имя выполняемого теста
    }
}
