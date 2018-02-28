package website;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import selenium.WebDriverFactory;
import stepdefs.DriverHandler;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true,

        features = "src/test/java/website",
        format = {"pretty", "html:html-reports"},
        glue = "stepdefs/websitesteps")

public class WebsiteTestsInit {

    @Before
    public static void InitilizeTests() {
        DriverHandler.setWebDriver(WebDriverFactory.getInstance().getWebDriver());
    }

    @After
    public static void TearDown() {
        DriverHandler.closeDriver();
    }
}