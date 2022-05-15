package parallel.stepDefinations;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;

import services.FluentWaitCode;

public class testHook extends FluentWaitCode {

    private FluentWaitCode fluentWaitCode;

    public testHook(FluentWaitCode fluentWaitCode) {
        this.fluentWaitCode = fluentWaitCode;
    }
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Started execution for the scenario : " + scenario.getName());
        FluentWaitCode.startNode(scenario.getName());
        System.out.println(extentNodeMap);
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        fluentWaitCode.driver.quit();
    }

    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        System.out.println("Before every step " + scenario.getId());
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        //System.out.println("Before every step " + stepTestStep.getId());
    }


}
