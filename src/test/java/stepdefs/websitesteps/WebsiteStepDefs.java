package stepdefs.websitesteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.WebDriverFactory;
import stepdefs.DriverHandler;

public class WebsiteStepDefs extends DriverHandler {

    @Given("^The precondition for the test - goes to website or logs in$")
    public void thePreconditionForTheTestGoesToWebsiteOrLogsIn() throws Throwable {
        if (driver == null) driver = WebDriverFactory.getInstance().getWebDriver();
        driver.navigate().to(System.getProperty("websiteUrl"));
    }

    @And("^The next step that gets repeated before every test$")
    public void theNextStepThatGetsRepeatedBeforeEveryTest() throws Throwable {
    }

    @When("^The step that the test is created for is executed in the when step$")
    public void theStepThatTheTestIsCreatedForIsExecutedInTheWhenStep() throws Throwable {
    }

    @And("^The test continues$")
    public void theTestContinues() throws Throwable {
    }

    @And("^The test continues some more$")
    public void theTestContinuesSomeMore() throws Throwable {
    }
    @Then("^The assertion that the test has passed and worked fine$")
    public void theAssertionThatTheTestHasPassedAndWorkedFine() throws Throwable {
    }
}
