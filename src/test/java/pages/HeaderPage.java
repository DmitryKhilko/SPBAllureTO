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

@Log4j2
public class HeaderPage extends BasePage {

    public SelenideElement appTitleButton= $(By.xpath("//div[contains(@class,'app-title')]")); //заголовок приложения (в левом верхнем углу)
    public SelenideElement horizontalSubmenuItem = $(By.xpath("//li[contains(@class,'ant-menu-submenu-selected')]//span[contains(text(),'···')]")); // '...' - за которым скрываются непомещающиеся пункты меню

 //   public SelenideElement userNameMenuItem = $(By.xpath("//div[contains(@class, 'ant-menu-submenu-popup')]//div[@class = 'submenu-username']|//div[@class = 'submenu-username']")); // имя пользователя, когда при входе оно скрыто за '...' + имя пользователя, когда при входе оно скрыто за '...'
    public SelenideElement userNameMenuItemInvisible = $(By.xpath("//div[contains(@class, 'ant-menu-submenu-popup')]//div[@class = 'submenu-username']")); // имя пользователя, когда при входе оно скрыто за '...'
    public SelenideElement userNameMenuItemVisible = $(By.xpath("//div[@class = 'submenu-username']")); // имя пользователя, когда при входе оно не скрыто за '...'

    public String horizontalMenuItemVisibleLocator = "//li[contains(@class,'ant-menu-item')]/a[text()='%s']"; // пункты меню страницы после входа в приложение, не скрытые за '...'
    public String horizontalMenuItemInvisibleLocator = "//li[@class='ant-menu-item']//a[text()='%s']"; // пункты меню страницы после входа в приложение, скрытые за '...', или после клика по текущему пользователю
    public String exitMenuItemInvisibleLocator = "//li[text()='%s']"; // Выйти (особый локатор)

    public String verticalMenuItemLocator = "//div[contains(@class,'ant-layout-sider-children')]//li[contains(text(),'%s')]"; // пункты меню боковых слайд-баров
    public String verticalMenuGroupLocator = "//div[contains(@class,'ant-layout-sider-children')]//div[contains(text(),'%s')]"; // группы пунктов меню боковых слайд-баров
    public SelenideElement pageTitle = $(By.xpath("//h3[contains(@class,'ant-typography')]|//div[contains(@class,'ant-tabs')][@aria-selected='true']|//div/h3|//div[contains(@class,'ant-card-head-title')]|//h1[contains(@class,'ant-typography')]")); //заголовки страниц
//    public SelenideElement pageTitle = $(By.xpath("//h3[contains(@class,'ant-typography')]")); //заголовки страниц
//    public SelenideElement pageTabTitle = $(By.xpath("//div[contains(@class,'ant-tabs')][@aria-selected='true']")); //заголовки вкладок (где на странице нет заголовка)
//    public SelenideElement pageTitleKB = $(By.xpath("//div/h3")); //заголовки страниц в базе знаний
//    public SelenideElement pageTitleUserProfil = $(By.xpath("//div[contains(@class,'ant-card-head-title')]")); //заголовки страниц в базе знаний

    public HeaderPage(ITestContext context) {
        super(context);
    }

    @Step("Дождаться появления окна уведомлений об успешном входе и закрыть его")
    public HeaderPage closeNotificationWindow() {
        log.debug("Тест " + context.getAttribute("testName") + ": дождаться появления окна уведомлений об успешном входе и закрыть его");
        new NotificationWindow().close();
        return this; //возвращаем текущую страницу
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
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в горизонтальном меню наличие пункта '{menuItem}'")
    public HeaderPage horizontalMenuItemShouldBeVisible(String menuItem) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в горизонтальном меню наличие пункта '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemVisibleLocator, menuItem))).shouldBe(visible);
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в подменю горизонтального меню (расположенного в пункте '...') наличие пункта '{menuItem}'")
    public HeaderPage horizontalSubmenuItemShouldBeVisible(String menuItem) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в подменю (скрытого '...') горизонтального меню наличие пункта '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemInvisibleLocator, menuItem))).shouldBe(visible);
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в горизонтальном меню отсутствие пункта '{menuItem}'")
    public HeaderPage horizontalMenuItemShouldNotVisible(String menuItem) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в горизонтальном меню отсутствие пункта '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemVisibleLocator, menuItem))).shouldNot(visible);
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в подменю горизонтального меню (расположенного в пункте '...') отсутствие пункта '{menuItem}'")
    public HeaderPage horizontalSubmenuItemShouldNotVisible(String menuItem) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в подменю горизонтального меню (расположенного в пункте '...') отсутствие пункта '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemInvisibleLocator, menuItem))).shouldNot(visible);
        return this; //возвращаем текущую страницу
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
        return this; //возвращаем текущую страницу
    }

    @Step("Выбрать в подменю горизонтального меню (расположенного в пункте '...') пункт '{menuItem}'")
    public HeaderPage horizontalSubmenuItemClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": при наличии в горизонтальном меню пункта '...' открыть вложенное меню, нажав на '...'");
        horizontalSubmenuItem.click();
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть в подменю горизонтального меню по пункту '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemInvisibleLocator, menuItem))).click();
        return this; //возвращаем текущую страницу
    }

    @Step("Раскрыть группу вертикального меню '{verticalMenuGroup}'")
    public HeaderPage verticalMenuGroupClick(String verticalMenuGroup) {
        log.debug("Тест " + context.getAttribute("testName") + ": раскрыть в вертикальном меню группу '" + verticalMenuGroup + "'");
        $(By.xpath(String.format(verticalMenuGroupLocator, verticalMenuGroup))).click();
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить наличие и выбрать в вертикальном меню пункт '{menuItem}'")
    public HeaderPage verticalMenuItemClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить наличие в вертикальном меню пункта '" + menuItem + "'");
        $(By.xpath(String.format(verticalMenuItemLocator, menuItem))).shouldBe(visible);
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть по пункту вертикального меню '" + menuItem + "'");
        $(By.xpath(String.format(verticalMenuItemLocator, menuItem))).click();
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить, открылась ли страница с заголовком '{openPageTitle}'")
    public HeaderPage pageTitleShouldHave(String openPageTitle) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить, открылась ли страница с заголовком '" + openPageTitle + "'");
        pageTitle.shouldHave(exactText(openPageTitle), Duration.ofSeconds(20));
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить отсутствие в вертикальном меню пункта '{menuItem}'")
    public HeaderPage verticalMenuItemShouldNotVisible(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить отсутствие в вертикальном меню пункта '" + menuItem + "'");
        $(By.xpath(String.format(verticalMenuItemLocator, menuItem))).shouldNot(visible);
        return this; //возвращаем текущую страницу
    }

    //***************************************************************************************************************************************
    //Проверка работоспособности пунктов меню, скрытым под текущим пользователем (Профиль, Почта, Изменить пароль, Выход)
    //***************************************************************************************************************************************

    @Step("Выбрать в горизонтальном меню пункт '{userName}' (пользователь, под которым вошли в приложение)")
    public HeaderPage userNameClick(String userName) {
//        log.debug("Тест " + context.getAttribute("testName") + ": ожидать появления в горизонтальном меню пункта '...'");
//        horizontalSubmenuItem.shouldBe(visible);
        if (horizontalSubmenuItem.exists()) { // если пункт '...' виден
            log.debug("Тест " + context.getAttribute("testName") + ": при наличии в горизонтальном меню пункта '...' открыть вложенное меню, нажав на '...'");
            horizontalSubmenuItem.click();
            log.debug("Тест " + context.getAttribute("testName") + ": кликнуть по пункту меню с именем текущего пользователя '" + userName + "'");
            userNameMenuItemInvisible.click();
        } else { // если пункт '...' не виден
            log.debug("Тест " + context.getAttribute("testName") + ": кликнуть по пункту меню с именем текущего пользователя '" + userName + "'");
            userNameMenuItemVisible.click();
        }
        return this; //возвращаем текущую страницу
    }

    @Step("Выбрать пункт '{menuItem}' в подменю пункта меню с именем текущего пользователя")
    public HeaderPage submenuItemUserNameClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть в подменю горизонтального меню по пункту '" + menuItem + "'");
        $(By.xpath(String.format(horizontalMenuItemInvisibleLocator, menuItem))).click();
        return this; //возвращаем текущую страницу
    }

    @Step("Выбрать пункт '{menuItem}' в подменю пункта меню с именем текущего пользователя")
    public HeaderPage logoutSubmenuItemClick(String menuItem) {
        log.debug("Тест " + context.getAttribute("testName") + ": кликнуть в подменю горизонтального меню по пункту '" + menuItem + "'");
        $(By.xpath(String.format(exitMenuItemInvisibleLocator, menuItem))).click();
        return this; //возвращаем текущую страницу
    }
}