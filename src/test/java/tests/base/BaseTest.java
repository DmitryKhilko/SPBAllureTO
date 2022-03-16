package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HeaderPage;
import pages.LoginPage;
import pages.PortalPage;
import pages.dictionary.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public abstract class BaseTest {

    public LoginPage loginPage;
    public HeaderPage headerPage;
    public AteDictionaryPage ateDictionaryPage;
    public AteDictionaryCreatePage ateDictionaryCreatePage;
    public AteDictionaryUpdatePage ateDictionaryUpdatePage;
    public AteDictionaryFilterPage ateDictionaryFilterPage;
    public CertificateChangeCauseDictionaryPage certificateChangeCauseDictionaryPage;
    public CertificateChangeCauseDictionaryCreatePage certificateChangeCauseDictionaryCreatePage;
    public CertificateChangeCauseDictionaryUpdatePage certificateChangeCauseDictionaryUpdatePage;
    public PortalPage portalPage;

    @Parameters({"BROWSER"})
    @BeforeMethod(description = "Настроить и открыть браузер") //предусловие
    public void setUp(@Optional("chrome") String browser, ITestContext context, ITestResult result) {
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

        //Configuration.headless = true; //браузер запускается без UI. Тесты ускоряются и становятся более стабильными. Браузер использует меньше ОЗУ (где-то в 3 раза). Этот режим просто необходим при параллелоьном запуске тестов
        Configuration.browserPosition = "0x0"; //команда задает позицию левого верхнего угла браузера. Без нее браузер при запуске смещен немного вправо, что может привести к невидимости каких-то элементов.
        Configuration.browserSize = "1920x1080"; //задает разрешение, с каким запускается браузер. Этот параметр, как и виды браузеров важен и может потребоваться тестировать на разных разрешениях.
        Configuration.timeout = 10000; // неявное ожидание в милисекундах (10 секунд), указывающее на то, какое максимальное количество времени Selenium будет дожидаться появления элемента (аналог implicitlyWait)
        Configuration.savePageSource = false; //при падении теста не сохраняет Page source (file:/D:/Projects/SPB/build/reports/tests/1644796597073.11.html)

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false)); //Для взаимодействия Selenide и Allure (https://ru.selenide.org/documentation/reports.html#allure-report)

        context.setAttribute("testName", result.getMethod().getMethodName()); //передаем имя выполняемого теста в методы тестового фреймворка для наглядного формирования логов

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
        portalPage = new PortalPage(context);
    }

    @AfterMethod(alwaysRun = true, description = "Закрыть браузер") //постусловие
    public void tearDown(ITestResult result) {
        getWebDriver().quit(); //явным образом после каждого теста, расположенного в классе, закрываем браузер, так как по умолчанию в Selenide браузер закрывается по завершению всех методов класса
        log.info("Тест " + result.getMethod().getMethodName() + ": закончить выполнение теста"); //команда лога, куда передается имя выполняемого теста
    }
}
