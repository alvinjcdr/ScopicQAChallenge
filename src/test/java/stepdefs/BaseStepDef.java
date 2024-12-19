package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.BasePage;

public class BaseStepDef extends BasePage {

    @Given("user navigate to Swag Labs website")
    public void user_navigate_to_swag_labs_website() {
        loadProperties();
        getBrowser();
        openUrl();
    }

    @Then("close browser")
    public void close_browser() {
        browserQuit();
    }

    @When("user clicks back in browser")
    public void clickBackInBrowser() throws Exception {
        clickNavigateBack(3000);
    }

    @When("user reloads page")
    public void reloadPage() {
        reloadThePage();
    }

    @Then("verify that {string} page is displayed")
    public void verifyThatPageIsDisplayed(String pageName) {
        verifyPageIsDisplayed(pageName);
    }
}