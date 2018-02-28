package selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebDriverFactory {

    private String browserName, browserVersion;

    private WebDriverFactory() {
    }

    public WebDriver getWebDriver() { return driver;}

    private static WebDriverFactory ourInstance = new WebDriverFactory();

    public static WebDriverFactory getInstance() {
        return ourInstance;
    }

    private WebDriver driver = createWebDriver();


    private WebDriver createWebDriver() {
        WebDriver driver = null;
        switch (System.getProperty("websiteBrowser").toLowerCase()) {
            case "chrome": {
                if (System.getProperty("os.name").contains("Windows"))
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
                else
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                browserName = ((ChromeDriver) driver).getCapabilities().getBrowserName();
                browserVersion = ((ChromeDriver) driver).getCapabilities().getVersion();
                break;
            }
            case "firefox":
                if (System.getProperty("os.name").contains("Windows"))
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
                else
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.cache.disk.enable", false);
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                capability.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
                driver = new FirefoxDriver(firefoxProfile);
                browserName = ((FirefoxDriver) driver).getCapabilities().getBrowserName();
                browserVersion = ((FirefoxDriver) driver).getCapabilities().getVersion();
                break;
            case "safari":
                driver = new SafariDriver();
                browserName = ((SafariDriver) driver).getCapabilities().getBrowserName();
                browserVersion = ((SafariDriver) driver).getCapabilities().getVersion();
                break;
            case "explorer":
                File file = new File(System.getProperty("user.dir") + "/src/main/resources/IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                driver = new InternetExplorerDriver();
                browserName = ((InternetExplorerDriver) driver).getCapabilities().getBrowserName();
                browserVersion = ((InternetExplorerDriver) driver).getCapabilities().getVersion();
                break;
        }

        if(driver != null) {
            driver.manage().window().setSize(new Dimension(1920, 1500));
            driver.manage().window().maximize();
            System.out.println("Using browser with version: " + browserName + " " + browserVersion);
        }
        return driver;
    }
}