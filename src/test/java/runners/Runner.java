package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumber.html", "json:target/report.json", "pretty"},
            features = "src/test/resources/features",
            glue = "steps",
            tags = "@regressionTest",
            dryRun = false

    )

public class Runner {

}
