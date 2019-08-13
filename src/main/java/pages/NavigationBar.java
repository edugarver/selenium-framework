package pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

public class NavigationBar {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();

    public NavigationBar() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "products")
    private WebElement productsLink;
    @FindBy(className = "cart")
    private WebElement cartLink;
    @FindBy(className = "orders")
    private WebElement ordersLink;

    public void navigateTo(String page) {
        if ("products".equalsIgnoreCase(page)) {
            productsLink.click();
        } else if ("cart".equalsIgnoreCase(page)) {
            cartLink.click();
        } else if ("orders".equalsIgnoreCase(page)) {
            ordersLink.click();
        } else {
            throw new NotFoundException("Link not found");
        }
    }
}
