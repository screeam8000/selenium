import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test"},
        glue = {"javaCourse"},
        plugin = {"json:target/cucumber-report.json",
                "pretty",
                "html:target/cucumber-reports",
                "javaCourse.reporter.AllureReporter"
        },
        tags = {"@web"})


public class Runner {
}

