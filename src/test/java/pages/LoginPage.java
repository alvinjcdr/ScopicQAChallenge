package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "login-button")
    WebElement loginBtn;
    @FindBy(xpath = "//h3[@data-test = 'error']")
    WebElement errorMessageHeader;
    @FindBy(id = "user-name")
    WebElement userNameTxt;
    @FindBy(id = "password")
    WebElement passwordTxt;
    @FindBy(id = "login_button_container")
    WebElement loginForm;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Click Login Button icon
     * @throws Exception exception
     */
    public void clickLogin() throws Exception {
        waitUntilClickable(loginBtn);
        loginBtn.click();
    }

    /**
     * verify error message is displayed
     * @throws Exception exception
     */
    public void verifyErrorMessageIsDisplayed(String errorMessage) throws Exception {
        switch (errorMessage) {
            case "username is required":
                verifyTrue(errorMessageHeader.getText().contains("Epic sadface: Username is required"),
                        "Username is blank");
                break;
            case "password is required":
                verifyTrue(errorMessageHeader.getText().contains("Epic sadface: Password is required"),
                        "Password is blank");
                break;
            case "credentials does not match":
                verifyTrue(errorMessageHeader.getText().contains("Epic sadface: Username and password do not match any user in this service"),
                        "Incorrect Credentials entered");
                break;
            case "locked out user":
                verifyTrue(errorMessageHeader.getText().contains("Epic sadface: Sorry, this user has been locked out"),
                        "Locked out user");
                break;
            default:
                throw new Exception("Invalid value Error Message to be verified entered");
        }
    }

    /**
     * Enter username
     * @param userName String
     * @throws Exception exception
     */
    public void enterUserName(String userName) throws Exception {
        waitUntilVisible(userNameTxt);
        userNameTxt.sendKeys(userName);
    }

    /**
     * Enter password
     * @param password String
     * @throws Exception exception
     */
    public void enterPassword(String password) throws Exception {
        waitUntilVisible(passwordTxt);
        passwordTxt.sendKeys(password);
    }

    /**
     * Verify that Login Page is displayed
     */
    public void verifyLoginPageIsDisplayed() {
        verifyTrue(loginForm.isDisplayed(), "login form is displayed");
    }
}
