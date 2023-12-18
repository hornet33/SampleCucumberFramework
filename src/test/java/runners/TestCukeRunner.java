package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue= {"stepDefs"},
        plugin = {"pretty","html:target/HTMLReports/Junit-Report.html"}
)
public class TestCukeRunner {
}