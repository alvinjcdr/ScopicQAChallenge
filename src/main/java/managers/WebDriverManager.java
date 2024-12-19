package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WebDriverManager {
    public static WebDriver driver;
    public static Properties properties;
    private final String PROPERTY_FILE_PATH = "src\\main\\resources\\properties\\envprop.properties";


    /**
     * This method loads all the properties from the Environment Properties File
     */
    public void loadProperties() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH));
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + PROPERTY_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method gets the Driver Browser.
     * Currently set to only run on Chrome Driver running on latest version - 131
     */
    public void getBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        System.setProperty(
                "webdriver.chrome.driver", System.getProperty("user.dir") +
                        properties.getProperty("chromeDriver"));
        driver = new ChromeDriver(options);
        openUrl();
    }

    /**
     * Get url from the property file
     */
    public void openUrl(){
        driver.get(properties.getProperty("websiteUrl"));
    }

    /**
     * Quit browser when run is done
     */
    public void browserQuit() {
        driver.quit();
    }
}
