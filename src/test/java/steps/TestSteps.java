package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.BrowserDriver;

import java.util.logging.Logger;

/**
 * Class that contains the Java translation from the cucumber steps in the feature file
 */
public class TestSteps {

    private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());

    private CartPage cartPage = new CartPage();
    private OrdersPage ordersPage = new OrdersPage();
    private ProductsPage productsPage = new ProductsPage();
    private OrderSuccessfulPage orderSuccessfulPage = new OrderSuccessfulPage();
    private NavigationBar navigationBar = new NavigationBar();

    private static String orderId = "";

    @Given("^user navigates to url '(.+)'$")
    public void userNavigatesToUrl(String url) {
        BrowserDriver.loadPage(url);
    }

    @Given("^user adds the product '(.+)' to cart$")
    public void userAddsProductToCart(String product) {
        LOGGER.info("Adding product '" + product + "' to cart");
        productsPage.addProduct(product);
    }

    @Given("^user navigates to '(.+)'$")
    public void userNavigatesTo(String page) {
        LOGGER.info("navigating to '" + page + "' page");
        navigationBar.navigateTo(page);
    }

    @Given("^user removes the product '(.+)' from cart$")
    public void userRemovesProductFromCart(String product) {
        LOGGER.info("Removing product '" + product + "' from cart");
        cartPage.removeProduct(product);
    }

    @When("^user places the order$")
    public void userPlacesOrder() {
        LOGGER.info("Placing the order");
        cartPage.placeOrder();
    }

    @Then("^successful order message is displayed$")
    public void successfulOrderMessageIsDisplayed() {
        LOGGER.info("Checking if successful order message is displayed");
        Assert.assertTrue(orderSuccessfulPage.isSuccessfulMessageOrderDisplayed());
    }

    @Then("^order id is displayed$")
    public void orderIdIsDisplayed() {
        LOGGER.info("Checking if the order id is displayed");
        Assert.assertTrue(orderSuccessfulPage.isOrderIdDisplayed());
    }

    @Given("^user purchases product '(.+)'$")
    public void userPurchasesProduct(String product) {
        LOGGER.info("Purchasing the product '" + product + "'");
        productsPage.addProduct(product);
        navigationBar.navigateTo("cart");
        cartPage.placeOrder();
    }

    @Given("^user notes down the order id$")
    public void userNoteDownOrderId() {
        LOGGER.info("Saving the value of the order id");
        orderId = orderSuccessfulPage.getOrderId();
    }

    @Given("^user searches the order id$")
    public void userSearchesOrderId()
    {
        LOGGER.info("Searching in orders by the order id");
        ordersPage.searchOrder(orderId);
    }

    @Given("^user deletes the order$")
    public void userDeletesOrder() {
        LOGGER.info("Deleting the order");
        ordersPage.deleteOrder(orderId);
    }

    @Then("^the order is not displayed$")
    public void orderIsNotDisplayed() {
        LOGGER.info("Checking that previous order is not displayed anymore");
        Assert.assertFalse(ordersPage.isOrderDisplayed(orderId));
    }

}
