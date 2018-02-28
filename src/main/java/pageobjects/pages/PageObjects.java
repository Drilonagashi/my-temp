package pageobjects.pages;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

import static pageobjects.pages.PageObjectUtils.scrollToTop;
import static pageobjects.pages.PageObjectUtils.spinnerWait;

public interface PageObjects {
    WebDriver driver = WebDriverFactory.getInstance().getWebDriver();
    List<Pair<PageObjectUtils.LocatorType, String>> locatorPairs = new ArrayList<>();

    WebDriverWait wait = new WebDriverWait(driver, 20);

    default String getPageTitle() {
        return driver.getTitle();
    }

    default void clickElement() throws InterruptedException {
        spinnerWait();
        WebElement element = getElement();
        scrollToTop();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException ignored){ }
        element.click();
    }

    default WebElement getElement() throws InterruptedException {
        initializeMap();
        return PageObjectUtils.getElementFromPairs(locatorPairs);
    }

    void initializeMap();

}
