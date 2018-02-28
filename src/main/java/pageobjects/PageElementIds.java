package pageobjects;

public class PageElementIds {
    public enum LoginPageIds {

        WEBSITE_URL {
            public String getUrl() {
                return (System.getProperty("websiteURL"));

            }
        };

        public abstract String getUrl();
    }
}
