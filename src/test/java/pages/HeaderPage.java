package pages;

import com.codeborne.selenide.SelenideElement;
import elements.NotificationWindow;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class HeaderPage extends BasePage {

    public SelenideElement subMenuMenuItem = $(By.xpath("//li[contains(@class,'ant-menu-submenu-selected')]//span[contains(text(),'···')]")); // '...' - за которым скрываются непомещающиеся пункты меню
    public SelenideElement userNameMenuItemInvisible = $(By.xpath("//div[contains(@class, 'ant-menu-submenu-popup')]//div[@class = 'submenu-username']")); // имя пользователя, когда при входе оно скрыто за '...'
    public SelenideElement userNameMenuItemVisible = $(By.xpath("//div[@class = 'submenu-username']")); // имя пользователя, когда при входе оно не скрыто за '...'
    public String menuItemVisibleLocator = "//li[contains(@class,'ant-menu-item')]/a[text()='%s']"; // пункты меню страницы после входа в приложение, не скрытые за '...'
    public String menuItemInvisibleLocator = "//li[@class='ant-menu-item']//a[text()='%s']"; // пункты меню страницы после входа в приложение, скрытые за '...'

    public HeaderPage(ITestContext context) {
        super(context);
    }

    @Step("Дождаться появления окна уведомлений об успешном входе и закрыть его")
    public HeaderPage closeNotificationWindow() {
        log.debug("Тест " + context.getAttribute("testName") + ": дождаться появления окна уведомлений об успешном входе и закрыть его");
        new NotificationWindow().close();
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в горизонтальном меню наличие пункта '{userName}' (пользователь, под которым вошли в приложение)")
    public HeaderPage userNameShouldHave(String userName) {
        if (subMenuMenuItem.exists()) { // если '...' видны
            log.debug("Тест " + context.getAttribute("testName") + ": при наличии в горизонтальном меню пункта '...' открыть вложенное меню, нажав на '...'");
            subMenuMenuItem.click();
            log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли вложенное меню имя пользователя '" + userName + "', под которым зашли в приложение");
            userNameMenuItemInvisible.shouldHave(exactText(userName));
        } else { // если '...' видны
            log.debug("Тест " + context.getAttribute("testName") + ": проверить, содержит ли горизонтальное меню имя пользователя '" + userName + "', под которым зашли в приложение");
            userNameMenuItemVisible.shouldHave(exactText(userName));
        }
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в горизонтальном меню наличие пункта '{menuItemName}'")
    public HeaderPage menuItemShouldBeVisible(String menuItemName) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в горизонтальном меню наличие пункта '" + menuItemName + "'");
        $(By.xpath(String.format(menuItemVisibleLocator, menuItemName))).shouldBe(visible);
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в подменю (скрытого '...') горизонтального меню наличие пункта '{menuItemName}'")
    public HeaderPage submenuItemShouldBeVisible(String menuItemName) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в подменю (скрытого '...') горизонтального меню наличие пункта '" + menuItemName + "'");
        $(By.xpath(String.format(menuItemInvisibleLocator, menuItemName))).shouldBe(visible);
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в горизонтальном меню отсутствие пункта '{menuItemName}'")
    public HeaderPage menuItemShouldNotVisible(String menuItemName) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в горизонтальном меню отсутствие пункта '" + menuItemName + "'");
        $(By.xpath(String.format(menuItemVisibleLocator, menuItemName))).shouldNot(visible);
        return this; //возвращаем текущую страницу
    }

    @Step("Проверить в подменю горизонтального меню (расположенного в пункте '...') отсутствие пункта '{menuItemName}'")
    public HeaderPage submenuItemShouldNotVisible(String menuItemName) {
        // в методе userNameShouldHave уже кликается по '...', чтобы раскрыть вложенное меню, в данном методе по '...' кликать не надо
        log.debug("Тест " + context.getAttribute("testName") + ": проверить в подменю горизонтального меню (расположенного в пункте '...') отсутствие пункта '" + menuItemName + "'");
        $(By.xpath(String.format(menuItemInvisibleLocator, menuItemName))).shouldNot(visible);
        return this; //возвращаем текущую страницу
    }
}