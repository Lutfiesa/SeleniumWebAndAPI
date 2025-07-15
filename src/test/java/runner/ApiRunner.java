package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDef"},
        features = {"src/test/resources/feature"},
        plugin = {"pretty"},
        tags = "@api"
)

public class ApiRunner{
}
