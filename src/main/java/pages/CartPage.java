package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

/**
 * Class that models the cart page
 */
public class CartPage {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Place order button. Since this button is always there, it can be initialized at any moment
     */
    @FindBy(css = "button.btn-success")
    private WebElement placeOrderButton;

    /**
     * Method that removes one product from the cart. Each product has a remove button,
     * and the way to locate it is with a class called autoclass whose value is the title of the product.
     * That's why the element has to be initialized here
     * @param title Name of the product to be deleted
     */
    public void removeProduct(String title) {
        String formattedTitle = title.toLowerCase().replace(" ", "-");
        By productLocator = By.cssSelector("div[autoclass='"+ formattedTitle + "']");
        driver.findElement(productLocator).click();
    }

    /**
     * Method to place the order. It just clicks in the button
     */
    public void placeOrder() {
        placeOrderButton.click();
    }
}
