package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

/**
 * Class that models the orders page
 */
public class OrdersPage {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "search-field")
    private WebElement searchField;

    /**
     * Searches an order based on the order id
     * @param orderId id of the order that we want to display
     */
    public void searchOrder(String orderId) {
        searchField.sendKeys(orderId);
    }

    /**
     * Deletes the order given by id
     * @param orderId
     */
    public void deleteOrder(String orderId) {
        By deleteOrderButtonLocator = By.cssSelector("div[autoclass='" + orderId + "'] .cart-icon");
        driver.findElement(deleteOrderButtonLocator).click();
    }

    /**
     * Checks if the order identified by the given id is shown in the site or not
     * @param orderId
     * @return
     */
    public boolean isOrderDisplayed(String orderId) {
        By orderLocator = By.cssSelector("div[autoclass='" + orderId + "']");
        WebElement order = null;
        try {
            order = driver.findElement(orderLocator);
        } catch (NoSuchElementException ignored) {
        }
        return order != null;
    }

}
