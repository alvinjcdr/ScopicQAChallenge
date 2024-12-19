package support;

import managers.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class BasePage extends WebDriverManager {

    public static SoftAssert softAssert = new SoftAssert();

    public void waitTillElementsLoadsByMilliSec(int ms) throws Exception {
        Thread.sleep(ms);
    }
    public void waitUntilClickable(WebElement ele) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }
    public void waitUntilVisible(WebElement ele) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(ele));
    }
    public void waitForPresenceOfTheElementLocatedBy(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void clickNavigateBack(int... waitTimeInSeconds) throws Exception {
        int waitTime = waitTimeInSeconds.length == 0 ? 2000 : waitTimeInSeconds[0];
        driver.navigate().back();
        waitTillElementsLoadsByMilliSec(waitTime);
    }

    public void verifyTrue(boolean condition, String msg){
        softAssert.assertTrue(condition,msg);
    }
    public void verifyEquals(String actual, String expected, String msg){
        softAssert.assertEquals(actual,expected,msg);
    }
    public void verifyNotEquals(String actual, String expected, String msg){
        softAssert.assertNotEquals(actual,expected,msg);
    }
    public WebElement waitForElementToBeDisplayed(WebElement element, int... timeOutInSeconds) {
        int timeOut = timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 60;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class, TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public void reloadThePage() {
        driver.navigate().refresh();
    }
    public void verifyPageIsDisplayed(String pageName) {
        String title = driver.getCurrentUrl();
        verifyTrue(title.toLowerCase().contains(pageName), pageName + " is displayed");
    }
}
