package stepdefs;

import io.cucumber.java.en.When;
import pages.ProductsPage;
import support.BasePage;
import support.PageObject;

public class ProductsPageStepDef extends BasePage {

    ProductsPage productsPage;

    public ProductsPageStepDef(PageObject pom) {
        productsPage = pom.getProductsPage();
    }

    @When("user clicks product sort")
    public void clickSort() throws Exception {
        productsPage.clickProductSort();
    }

    @When("verify product name sorting")
    public void verifyProductNameSorting() throws Exception {
        productsPage.verifyProductNameSorting();
    }

    @When("add to cart first {string} items")
    public void addToCartItems(String firstItemsCount) throws Exception {
        productsPage.addToCartItems(firstItemsCount);
    }

}
