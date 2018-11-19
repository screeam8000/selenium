import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"selenium/src/main/java/steps"},
        plugin = {"json:target/cucumber-report.json",
                "pretty",
                "html:target/cucumber-reports"
//                "return:return.txt"
        },
        tags = {"@web"})


public class Runner {
}

