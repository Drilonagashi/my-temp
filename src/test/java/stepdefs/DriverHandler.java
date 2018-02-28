package stepdefs;

import generalUtils.Randomizer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class DriverHandler {

    protected static WebDriver driver;
    protected static AppiumDriver androidDriver;
    protected static AppiumDriver iosDriver;

    protected String randomGenerated = Randomizer.getInstance().getRand();
    protected int numericRandomGenerated = Randomizer.getInstance().getNumericRand();

    public static void setIosDriver(AppiumDriver webDriver) {
        iosDriver = webDriver;
    }
    public static void setAndroidDriver(AndroidDriver andDriver) {
        androidDriver = andDriver;
    }

    public static WebDriver setWebDriver(WebDriver webDriver) {
        driver = webDriver;
        return driver;
    }

    public static void closeApp(AppiumDriver drv) {
        if(drv.equals(iosDriver)) {
            iosDriver.closeApp();
            iosDriver.quit();
        } else if(drv.equals(androidDriver)) {
            androidDriver.closeApp();
            androidDriver.quit();
        }
    }

    public static void removeApp(AppiumDriver drv) {
        if(drv.equals(iosDriver)) {
            iosDriver.removeApp("");
        } else if(drv.equals(androidDriver)) {
            androidDriver.removeApp("");
        }
    }

    public static void installApp(AppiumDriver drv) {
        if(drv.equals(iosDriver)) {
            iosDriver.installApp("");
        } else if(drv.equals(androidDriver)) {
            androidDriver.installApp("");
        }

    }

    public static void setWebsiteDriver(WebDriver webDriver) {
        driver = webDriver;
    }


    public static void closeDriver() {
        driver.close();
    }
}