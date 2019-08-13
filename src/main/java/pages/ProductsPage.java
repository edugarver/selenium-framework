package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

public class ProductsPage {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public void addProduct(String title) {
        String formattedTitle = title.toLowerCase().replace(" ", "-");
        By productLocator = By.cssSelector("button[autoclass='"+ formattedTitle + "']");
        driver.findElement(productLocator).click();
    }

}
