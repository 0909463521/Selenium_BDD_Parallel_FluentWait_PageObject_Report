package parallel.stepDefinations;



import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.aventstack.extentreports.ExtentTest;
import junit.framework.Assert;
import org.testng.annotations.Parameters;
import pageObject.LoginPage;
import services.FluentWaitCode;
import services.listener.ExtentReportListener;
import services.listener.ITestListenerImpl;



public class stepDefination extends FluentWaitCode {
    private  FluentWaitCode fluentWaitCode;

    public stepDefination(FluentWaitCode fluentWaitCode) {
        this.fluentWaitCode = fluentWaitCode;
    }

    LoginPage lp;
    @Parameters({"browserName"})
    @Given("Initialize the browser with (.+) in$")
    public void initialize_the_browser_with_chrome(String browserName) throws Throwable {
        // 123
        ExtentTest logInfo = null;

        try{
             ;

            fluentWaitCode.driver = setup(browserName);
            FluentWaitCode.getNode().createNode(new GherkinKeyword("Given"), "Step 1")
                    .pass(MarkupHelper.createLabel("pass",ExtentColor.GREEN))
                    .info(MediaEntityBuilder.createScreenCaptureFromPath(FluentWaitCode.captureScreenShot(driver).getAbsolutePath()).build());


        } catch (AssertionError | Exception e) {
            FluentWaitCode.getNode().createNode(new GherkinKeyword("Given"), "Step 1")
                    .info(MediaEntityBuilder.createScreenCaptureFromPath(FluentWaitCode.captureScreenShot(driver).getAbsolutePath()).build())
                    .fail(e);

        }



    }
    @Given("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_Site(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        ExtentTest logInfo = null;

        try{

            fluentWaitCode.driver.get(arg1);
            FluentWaitCode.getNode().createNode(new GherkinKeyword("Given"), "Step 2")
                    .pass(MarkupHelper.createLabel("pass",ExtentColor.GREEN))
                    .info(MediaEntityBuilder.createScreenCaptureFromPath(FluentWaitCode.captureScreenShot(driver).getAbsolutePath()).build());


        } catch (AssertionError | Exception e) {
            FluentWaitCode.getNode().createNode(new GherkinKeyword("Given"), "Step 2")
                    .info(MediaEntityBuilder.createScreenCaptureFromPath(FluentWaitCode.captureScreenShot(driver).getAbsolutePath()).build())
                    .fail(e);
        }




    }
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {

        ExtentTest logInfo = null;

        try{

            lp =new LoginPage( fluentWaitCode.driver);
            lp.getEmail().sendKeys(username);
            lp.getPassword().sendKeys(password);
            lp.getLogin().click();
            FluentWaitCode.getNode().createNode(new GherkinKeyword("When"), "Step 3")
                    .pass(MarkupHelper.createLabel("pass",ExtentColor.GREEN))
                    .info(MediaEntityBuilder.createScreenCaptureFromPath(FluentWaitCode.captureScreenShot(driver).getAbsolutePath()).build());

        } catch (AssertionError | Exception e) {
            FluentWaitCode.getNode().createNode(new GherkinKeyword("Given"), "Step 3")
                    .info(MediaEntityBuilder.createScreenCaptureFromPath(FluentWaitCode.captureScreenShot(driver).getAbsolutePath()).build())
                    .fail(e);

        }


    }
    @Then("^Verify that user is succesfully logged in$")
    public void verify_that_user_is_succesfully_logged_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions


        try{

            String txtyourlocation = lp.yourLocation().getText();
            System.out.println(txtyourlocation);
            Assert.assertEquals("Your location1",txtyourlocation);
            FluentWaitCode.getNode().createNode(new GherkinKeyword("Given"), "Step 4")
                    .pass(MarkupHelper.createLabel("pass",ExtentColor.GREEN))
                    .info(MediaEntityBuilder.createScreenCaptureFromPath(FluentWaitCode.captureScreenShot(driver).getAbsolutePath()).build());


        } catch (AssertionError | Exception e) {
            FluentWaitCode.getNode().createNode(new GherkinKeyword("Given"), "Step 4")
                    .info(MediaEntityBuilder.createScreenCaptureFromPath(FluentWaitCode.captureScreenShot(driver).getAbsolutePath()).build())
                    .fail(e);
        }
    }
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
        fluentWaitCode.driver.quit();
    }


}
