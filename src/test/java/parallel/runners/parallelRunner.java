package parallel.runners ;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;



@CucumberOptions(
        features = {"src/test/java/parallel/features/"}
        ,glue = {"parallel/stepDefinations"}

)
public class parallelRunner extends AbstractTestNGCucumberTests  {

    @Override
    @DataProvider (parallel = true)
    //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}