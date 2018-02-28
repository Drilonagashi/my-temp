package pageobjects.pages;

import org.openqa.selenium.WebElement;
import pageobjects.PageElementIds;



public enum SpecificPageElements implements PageObjects {

    SpecificElement(PageObjectUtils.LocatorType.NAME, "valueOfNameAttribute"),
    OtherSpecificElement(PageObjectUtils.LocatorType.CLASSNAME, "valueOfClassAttribute"),
    OtherElement(PageObjectUtils.LocatorType.ID, "valueOfIDAttribute");

    public PageObjectUtils.LocatorType locator;
    public String id;

    SpecificPageElements(PageObjectUtils.LocatorType locator, String id) {
        this.locator = locator;
        this.id = id;
    }

    @Override
    public void initializeMap() {}

    @Override
    public WebElement getElement() {
        return PageObjectUtils.locateElement(driver, locator, id);
    }

    public static String getWebsiteUrl() {
        return PageElementIds.LoginPageIds.WEBSITE_URL.getUrl();
    }
}
