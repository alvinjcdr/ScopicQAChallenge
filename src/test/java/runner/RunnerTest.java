package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;

import static support.BasePage.softAssert;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"stepdefs"},
        tags = "@RegressionSuite",
        plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

)

public class RunnerTest {
    @AfterMethod(alwaysRun = true)
    public void assertAll(){
        softAssert.assertAll();
    }
}
