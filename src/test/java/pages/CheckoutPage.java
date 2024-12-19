package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.BasePage;

public class CheckoutPage extends BasePage {

    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    @FindBy(id = "first-name")
    WebElement firstNameTxt;
    @FindBy(id = "last-name")
    WebElement lastNameTxt;
    @FindBy(id = "postal-code")
    WebElement postalTxt;
    @FindBy(id = "continue")
    WebElement continueBtn;
    @FindBy(id = "finish")
    WebElement finishBtn;
    @FindBy(id = "checkout_complete_container")
    WebElement checkoutBanner;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Click Checkout
     * @throws Exception exception
     */
    public void clickCheckout() throws Exception {
        waitUntilClickable(checkoutBtn);
        checkoutBtn.click();
    }

    /**
     * Enter Information details
     * @param firstName
     * @param lastName
     * @param postalCode
     * @throws Exception exception
     */
    public void enterDetailsAndContinue(String firstName, String lastName, String postalCode) throws Exception {
        waitUntilClickable(continueBtn);
        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
        postalTxt.sendKeys(postalCode);
        continueBtn.click();
    }

    /**
     * Click Finish button
     * @throws Exception exception
     */
    public void clickFinishButton() throws Exception {
        waitUntilClickable(finishBtn);
        finishBtn.click();
    }

    public void verifyCheckoutComplete() {
        verifyTrue(checkoutBanner.isDisplayed(), "Checkout Banner is displayed");
    }
}
