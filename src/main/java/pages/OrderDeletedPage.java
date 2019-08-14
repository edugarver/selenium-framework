package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

public class OrderDeletedPage {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();

    public OrderDeletedPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "order-deleted")
    private WebElement orderDeletedMessage;

    /**
     * Checks if the message that states that the order was deleted is displayed or not
     * @return
     */
    public boolean isOrderDeletedMessageDisplayed() {
        return orderDeletedMessage.isDisplayed();
    }
}
