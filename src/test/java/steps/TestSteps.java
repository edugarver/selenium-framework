package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.BrowserDriver;

public class TestSteps {

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
        productsPage.addProduct(product);
    }

    @Given("^user navigates to '(.+)'$")
    public void userNavigatesTo(String page) {
        navigationBar.navigateTo(page);
    }

    @Given("^user removes the product '(.+)' from cart$")
    public void userRemovesProductFromCart(String product) {
        cartPage.removeProduct(product);
    }

    @When("^user places the order$")
    public void userPlacesOrder() {
        cartPage.placeOrder();
    }

    @Then("^successful order message is displayed$")
    public void successfulOrderMessageIsDisplayed() {
        Assert.assertTrue(orderSuccessfulPage.isSuccessfulMessageOrderDisplayed());
    }

    @Then("^order id is displayed$")
    public void orderIdIsDisplayed() {
        Assert.assertTrue(orderSuccessfulPage.isOrderIdDisplayed());
    }

    @Given("^user purchases product '(.+)'$")
    public void userPurchasesProduct(String product) {
        productsPage.addProduct(product);
        navigationBar.navigateTo("cart");
        cartPage.placeOrder();
    }

    @Given("^user notes down the order id$")
    public void userNoteDownOrderId() {
        orderId = orderSuccessfulPage.getOrderId();
    }

    @Given("^user searches the order id$")
    public void userSearchesOrderId() {
        ordersPage.searchOrder(orderId);
    }

    @Given("^user deletes the order$")
    public void userDeletesOrder() {
        ordersPage.deleteOrder(orderId);
    }

    @Then("^the order is not displayed$")
    public void orderIsNotDisplayed() {
        Assert.assertFalse(ordersPage.isOrderDisplayed(orderId));
    }

}
