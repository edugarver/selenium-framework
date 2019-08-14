package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

/**
 * Class that models the order successful page
 */
public class OrderSuccessfulPage {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();

    public OrderSuccessfulPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "order-successful")
    private WebElement orderSuccessfulMessage;

    @FindBy(className = "order")
    private WebElement order;

    @FindBy(className = "order-id")
    private WebElement orderId;

    /**
     * Checks if the message that states that the order was successful is displayed or not
     * @return
     */
    public boolean isSuccessfulOrderMessageDisplayed() {
        return orderSuccessfulMessage.isDisplayed();
    }

    /**
     * Checks if the order id is displayed or not
     * @return
     */
    public boolean isOrderIdDisplayed() {
        return orderId.isDisplayed();
    }

    /**
     * @return the value of the order id that was just placed
     */
    public String getOrderId() {
        return order.getAttribute("autoclass");
    }
}
