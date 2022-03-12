package pages;

import com.codeborne.selenide.SelenideElement;
import elements.NotificationWindow;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import pages.base.BasePage;
import java.time.Duration;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static pages.base.ConstantsUIMenu.VMENU_09;

@Log4j2
public class HeaderPage extends BasePage {

    //****************************************************************************************************************************************************************************
    //Локаторы пунктов горизонтального и вертикального меню, заголовков страниц; переменные, используемые в методах
    //****************************************************************************************************************************************************************************
    public SelenideElement horizontalSubmenuItem = $(By.xpath("//li[contains(@class,'ant-menu-submenu-selected')]//span[contains(text(),'···')]")); // '...' - за которым скрываются непомещающиеся пункты меню

    public SelenideElement userNameMenuItemInvisible = $(By.xpath("//div[contains(@class, 'ant-menu-submenu-popup')]//div[@class = 'submenu-username']")); // имя пользователя, когда при входе оно скрыто за '...'
    public SelenideElement userNameMenuItemVisible = $(By.xpath("//div[@class = 'submenu-username']")); // имя пользователя, когда при входе оно не скрыто за '...'

    public String horizontalMenuItemVisibleLocator = "//li[contains(@class,'ant-menu-item')]/a[text()='%s']"; // пункты меню страницы после входа в приложение, не скрытые за '...'
    public String horizontalMenuItemInvisibleLocator = "//li[@class='ant-menu-item']//a[text()='%s']"; // пункты меню страницы после входа в приложение, скрытые за '...', или после клика по текущему пользователю
    public String exitMenuItemInvisibleLocator = "//li[text()='%s']"; // пункт меню 'Выйти' (особый локатор)

    public String verticalMenuItemLocator = "//div[contains(@class,'ant-layout-sider-children')]//li[contains(text(),'%s')]"; // пункты меню боковых слайд-баров
    public String verticalMenuGroupLocator = "//div[contains(@class,'ant-layout-sider-children')]//div[contains(text(),'%s')]"; // группы пунктов меню боковых слайд-баров

    //Заголовки страниц. Вынужден был объединить в один локатор для минимизации методов. Ниже перечислены исходные локаторы:
    //    public SelenideElement pageTitle = $(By.xpath("//h3[contains(@class,'ant-typography')]")); //заголовки страниц
    //    public SelenideElement pageTabTitle = $(By.xpath("//div[contains(@class,'ant-tabs')][@aria-selected='true']")); //заголовки вкладок (где на странице нет заголовка)
    //    public SelenideElement pageTitleKB = $(By.xpath("//div/h3")); //заголовки страниц в базе данных знаний
    //    public SelenideElement pageTitleUserProfil = $(By.xpath("//div[contains(@class,'ant-card-head-title')]")); //заголовок в профиле пользователя
    public SelenideElement pageTitle = $(By.xpath("//h3[contains(@class,'ant-typography')]|//div[contains(@class,'ant-tabs')][@aria-selected='true']|//div/h3|//div[contains(@class,'ant-card-head-title')]|//h1[contains(@class,'ant-typography')]"));

    //****************************************************************************************************************************************************************************
    //Методы связанные с наличием или отсутствием пунктов горизонтального и вертикального меню, заголовков страниц
    //****************************************************************************************************************************************************************************
    //Конструктор для передачи в команду log имени теста
    public HeaderPage(ITestContext context) {
        super(context);
    }

    @Step("Дождаться появления окна уведомлений об успешном входе и закрыть его")
    public HeaderPage closeNotificationWindow() {
        log.debug("Тест " + context.getAttribute("testName") + ": дождаться появления окна уведомлений об успешном входе и закрыть его");
        new NotificationWindow().close();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    //***************************************************************************************************************************************
    //Проверка наличия или отсутствия пунктов горизонтального меню в зависимости от роли
    //***************************************************************************************************************************************

    @Step("Проверить в горизонтальном меню наличие пункта '{userName}' (пользователь, под которым вошли в приложение)")
    public HeaderPage userNameShouldHave(String userName) {
        if (horizontalSubmenuItem.exists()) { // если пункт '...' виден
            log.debug("Тест " + context.getAttribute("testName") + ": при наличии в горизонтальном меню пункта '...' открыть вложенное меню, нажав на '...'");
            horizontalSubmenuItem.click();
            log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли вложенное меню имя пользователя '" + userName + "', под которым зашли в приложение");
            userNameMenuItemInvisible.shouldHave(exactText(userName));
        } else { // если пункт '...' не виден
            log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли горизонтальное меню имя пользователя '" + userName + "', под которым зашли в приложение");
            userNameMenuItemVisible.shouldHave(exactText(userName));
        }
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Проверить в горизонтальном меню наличие пункта '{menuItem}'")
    public HeaderPage horizontalMenuItemShouldBeVisible(String menuItem) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в горизонтальном меню наличие пункта '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemVisibleLocator, menuItem))).shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Проверить в подменю горизонтального меню (расположенного в пункте '...') наличие пункта '{menuItem}'")
    public HeaderPage horizontalSubmenuItemShouldBeVisible(String menuItem) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в подменю (скрытого '...') горизонтального меню наличие пункта '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemInvisibleLocator, menuItem))).shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Проверить в горизонтальном меню отсутствие пункта '{menuItem}'")
    public HeaderPage horizontalMenuItemShouldNotVisible(String menuItem) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в горизонтальном меню отсутствие пункта '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemVisibleLocator, menuItem))).shouldNot(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Проверить в подменю горизонтального меню (расположенного в пункте '...') отсутствие пункта '{menuItem}'")
    public HeaderPage horizontalSubmenuItemShouldNotVisible(String menuItem) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в подменю горизонтального меню (расположенного в пункте '...') отсутствие пункта '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemInvisibleLocator, menuItem))).shouldNot(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    //***************************************************************************************************************************************
    //Проверка работоспособности пунктов горизонтального и вертикального меню в зависимости от роли
    //***************************************************************************************************************************************

    @Step("Выбрать в горизонтальном меню пункт '{menuItem}'")
    public HeaderPage horizontalMenuItemClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": ожидать появления в горизонтальном меню пункта  '" + menuItem + "', так как горизонтальное меню нестабильно");
        $(By.xpath(String.format(horizontalMenuItemVisibleLocator, menuItem))).shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть в горизонтальном меню по пункту '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemVisibleLocator, menuItem))).click();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Выбрать в подменю горизонтального меню (расположенного в пункте '...') пункт '{menuItem}'")
    public HeaderPage horizontalSubmenuItemClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": при наличии в горизонтальном меню пункта '...' открыть вложенное меню, нажав на '...'");
        horizontalSubmenuItem.click();
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть в подменю горизонтального меню по пункту '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemInvisibleLocator, menuItem))).click();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Раскрыть группу вертикального меню '{verticalMenuGroup}'")
    public HeaderPage verticalMenuGroupClick(String verticalMenuGroup) {
        log.debug("Тест " + context.getAttribute("testName") + ": раскрыть в вертикальном меню группу '" + verticalMenuGroup + "'");
        $(By.xpath(String.format(verticalMenuGroupLocator, verticalMenuGroup))).click();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Проверить наличие и выбрать в вертикальном меню пункт '{menuItem}'")
    public HeaderPage verticalMenuItemClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить наличие в вертикальном меню пункта '" + menuItem + "'");
        $(By.xpath(String.format(verticalMenuItemLocator, menuItem))).shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть по пункту вертикального меню '" + menuItem + "'");
        $(By.xpath(String.format(verticalMenuItemLocator, menuItem))).click();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Проверить, открылась ли страница с заголовком '{openPageTitle}'")
    public HeaderPage pageTitleShouldHave(String openPageTitle) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, открылась ли страница с заголовком '" + openPageTitle + "'");
        //pageTitle.shouldHave(exactText(openPageTitle), Duration.ofSeconds(20));
        pageTitle.shouldHave(exactText(openPageTitle));
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Проверить отсутствие в вертикальном меню пункта '{menuItem}'")
    public HeaderPage verticalMenuItemShouldNotVisible(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить отсутствие в вертикальном меню пункта '" + menuItem + "'");
        $(By.xpath(String.format(verticalMenuItemLocator, menuItem))).shouldNot(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    //***************************************************************************************************************************************
    //Проверка работоспособности пунктов меню, скрытых под текущим пользователем (Профиль, Почта, Изменить пароль, Выход)
    //***************************************************************************************************************************************

    @Step("Выбрать в горизонтальном меню пункт '{userName}' (пользователь, под которым вошли в приложение)")
    public HeaderPage userNameClick(String userName) {
        if (horizontalSubmenuItem.exists()) { // если пункт '...' виден
            log.debug("Тест " + context.getAttribute("testName") + ": при наличии в горизонтальном меню пункта '...' открыть вложенное меню, нажав на '...'");
            horizontalSubmenuItem.click();
            log.debug("Тест " + context.getAttribute("testName") + ": кликнуть по пункту меню с именем текущего пользователя '" + userName + "'");
            userNameMenuItemInvisible.click();
            //Периодически вложенное в имя пользователя меню раскрывается вверх. При этом не видно часть пунктов вложенного меню.
            // Но при этом всегда остается видимым пункт меню 'Выход'. Чтобы отобразились все пункты меню, нужно навести курсор на пункт меню 'Выход' (.hover())
            log.debug("Тест " + context.getAttribute("testName") + ": навести курсор мыши на пункт подменю '"+ VMENU_09 +"', чтобы отобразились все пункты подменю");
            $(By.xpath(String.format(exitMenuItemInvisibleLocator, VMENU_09))).hover();
        } else { // если пункт '...' не виден
            log.debug("Тест " + context.getAttribute("testName") + ": кликнуть по пункту меню с именем текущего пользователя '" + userName + "'");
            userNameMenuItemVisible.click();
        }
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Выбрать пункт '{menuItem}' в подменю пункта меню с именем текущего пользователя")
    public HeaderPage submenuItemUserNameClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть в подменю горизонтального меню по пункту '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemInvisibleLocator, menuItem))).click();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }

    @Step("Выбрать пункт '{menuItem}' в подменю пункта меню с именем текущего пользователя")
    public HeaderPage logoutSubmenuItemClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть в подменю горизонтального меню по пункту '" + menuItem + "'");
        $(By.xpath(String.format(exitMenuItemInvisibleLocator, menuItem))).click();
        log.debug("Тест " + context.getAttribute("testName") + ": остаться на текущей странице 'HeaderPage'");
        return this;
    }
}