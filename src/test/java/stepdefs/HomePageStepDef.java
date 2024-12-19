package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import support.BasePage;
import support.PageObject;

public class HomePageStepDef extends BasePage {

    HomePage homePage;

    public HomePageStepDef(PageObject pom) {
        homePage = pom.getHomePage();
    }

    @When("user clicks the main menu")
    public void clickMainMenu() throws Exception {
        homePage.clickMainMenu();
    }

    @When("user logout")
    public void clickLogout() throws Exception {
        homePage.logoutUser();
    }

    @Then("verify {string} is found in shopping cart badge")
    public void verifyCartBadge(String count) throws Exception {
        homePage.verifyCartBadge(count);
    }

    @When("user click shopping cart")
    public void clickShoppingCart() throws Exception {
        homePage.clickShoppingCart();
    }
}
