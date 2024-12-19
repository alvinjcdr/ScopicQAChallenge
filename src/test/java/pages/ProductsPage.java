package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//select[@class ='product_sort_container']")
    WebElement sortEle;
    @FindBy(xpath = "//option[@value= 'za']")
    WebElement sortedEle;


    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Click Product Sort
     * @throws Exception exception
     */
    public void clickProductSort() throws Exception {
        waitUntilClickable(sortEle);
        sortEle.click();
    }

    /**
     * Verify Product Sorting
     * @throws Exception exception
     */
    public void verifyProductNameSorting() throws Exception {
        ArrayList<String> obtainedELemListOrig = new ArrayList<>();
        List<WebElement> elementListAZ = driver.findElements(By.xpath("//div[@class = 'inventory_item_name ']"));
        for(WebElement eleAZ : elementListAZ) {
            obtainedELemListOrig.add(eleAZ.getText());
        }
        ArrayList<String> originalProductList = new ArrayList<>(obtainedELemListOrig);

        //Verify Default Sort
        Collections.sort(originalProductList);
        Assert.assertEquals(originalProductList, obtainedELemListOrig);


        clickProductSort();
        waitUntilClickable(sortedEle);
        sortedEle.click();

        ArrayList<String> obtainedListSorted = new ArrayList<>();
        List<WebElement> elementListZA = driver.findElements(By.xpath("//div[@class = 'inventory_item_name ']"));
        for(WebElement eleZA : elementListZA) {
            obtainedListSorted.add(eleZA.getText());
        }
        ArrayList<String> sortedProductList = new ArrayList<>(obtainedListSorted);

        //Verify Sorting DESC
        Collections.reverse(originalProductList);
        Assert.assertEquals(originalProductList, sortedProductList);
    }

    /**
     * Add to Cart Items base from count param
     * @param firstItemsCount String
     * @throws Exception exception
     */
    public void addToCartItems(String firstItemsCount) throws Exception {
        int i = 0;
        int count = Integer.parseInt(firstItemsCount);
        List<WebElement> addToCartProducts = driver.findElements(By.xpath
                ("//button[contains(@id,'add-to-cart')]"));
        for(WebElement product : addToCartProducts) {
            while(i<count) {
                product.click();
                i++;
                waitTillElementsLoadsByMilliSec(500);
                break;
            }
        }
    }



}
