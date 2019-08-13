package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

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

    public boolean isSuccessfulMessageOrderDisplayed() {
        return orderSuccessfulMessage.isDisplayed();
    }

    public boolean isOrderIdDisplayed() {
        return orderId.isDisplayed();
    }

    public String getOrderId() {
        return order.getAttribute("autoclass");
    }
}
