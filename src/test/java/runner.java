import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty","html:target/cucumber-report/cucumber-html-report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,features = {"src/test/resources/features"}
        ,glue = {"stepDefs"}
        ,tags = "@Test7"
)
public class runner extends AbstractTestNGCucumberTests {}
