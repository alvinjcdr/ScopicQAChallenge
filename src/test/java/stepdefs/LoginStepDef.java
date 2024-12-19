package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import support.BasePage;
import support.PageObject;

public class LoginStepDef extends BasePage {

    LoginPage loginPage;

    public LoginStepDef(PageObject pom) {
        loginPage = pom.getLoginPage();
    }

    @When("user clicks the Login")
    public void clickLogin() throws Exception {
        loginPage.clickLogin();
    }

    @Then("verify error message {string} is displayed")
    public void verifyErrorMessageIsDisplayed(String errorMessage) throws Exception {
        loginPage.verifyErrorMessageIsDisplayed(errorMessage);
    }

    @When("user enter {string} username")
    public void enterUserName(String userName) throws Exception {
        loginPage.enterUserName(userName);
    }

    @When("user enter {string} password")
    public void enterPassword(String password) throws Exception {
        loginPage.enterPassword(password);
    }

    @Then("verify login page")
    public void verifyLoginPage() {
        loginPage.verifyLoginPageIsDisplayed();
    }
}
