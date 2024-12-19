package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import support.BasePage;
import support.PageObject;

public class CheckoutPageStepDef extends BasePage {

    CheckoutPage checkoutPage;

    public CheckoutPageStepDef(PageObject pom) {
        checkoutPage = pom.getCheckoutPage();
    }

    @When("user click Checkout button")
    public void clickCheckout() throws Exception {
        checkoutPage.clickCheckout();
    }

    @When("user fills up details with {string}, {string}, and {string} and continue")
    public void enterDetailsAndContinue(String firstName, String lastName, String postal) throws Exception {
        checkoutPage.enterDetailsAndContinue(firstName, lastName, postal);
    }

    @When("user click Finish button")
    public void clickFinishButton() throws Exception {
        checkoutPage.clickFinishButton();
    }

    @Then("verify that checkout success message is displayed")
    public void verifyCheckoutComplete() {
        checkoutPage.verifyCheckoutComplete();
    }
}
