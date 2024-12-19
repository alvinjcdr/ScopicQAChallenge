package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.BasePage;

public class HomePage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuIcon;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutBtn;
    @FindBy(xpath = "//span[@class = 'shopping_cart_badge']")
    WebElement shoppingCartBadge;
    @FindBy(xpath = "//a[@class = 'shopping_cart_link']")
    WebElement shoppingCartIcon;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Click main menu
     * @throws Exception exception
     */
    public void clickMainMenu() throws Exception {
        waitUntilVisible(menuIcon);
        menuIcon.click();
    }


    /**
     * Click Logout
     * @throws Exception exception
     */
    public void logoutUser() throws Exception {
        waitUntilClickable(logoutBtn);
        logoutBtn.click();
    }

    /**
     * Verify Cart Badge display count
     * @param count String
     * @throws Exception exception
     */
    public void verifyCartBadge(String count) throws Exception {
        waitUntilVisible(shoppingCartBadge);
        String cartItem = shoppingCartBadge.getText();
        verifyEquals(cartItem, count, "Cart badge displays the correct item count");

    }

    /**
     * Click Shopping Cart
     * @throws Exception exception
     */
    public void clickShoppingCart() throws Exception {
        waitUntilClickable(shoppingCartIcon);
        shoppingCartIcon.click();

    }
}
