package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    plugin = {
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        "html:target/htmlReports.html",
        "pretty"
    }
    //run the allure serve command in project terminal
)
public class TestRunner {
}

