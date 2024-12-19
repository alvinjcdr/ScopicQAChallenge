package support;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class PageObject extends BasePage {
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;

    public LoginPage getLoginPage() {
        return (loginPage == null) ? new LoginPage(driver) : loginPage;
    }
    public HomePage getHomePage() {
        return (homePage == null) ? new HomePage(driver) : homePage;
    }
    public ProductsPage getProductsPage() {
        return (productsPage == null) ? new ProductsPage(driver) : productsPage;
    }
    public CheckoutPage getCheckoutPage() {
        return (checkoutPage == null) ? new CheckoutPage(driver) : checkoutPage;
    }
}
