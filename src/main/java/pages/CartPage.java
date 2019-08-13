package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

public class CartPage {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.btn-success")
    private WebElement placeOrderButton;

    public void removeProduct(String title) {
        String formattedTitle = title.toLowerCase().replace(" ", "-");
        By productLocator = By.cssSelector("div[autoclass='"+ formattedTitle + "']");
        driver.findElement(productLocator).click();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
}
