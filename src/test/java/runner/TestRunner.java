package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features ="C:\\Users\\prasa\\IdeaProjects\\Page_Object_Model\\src\\test\\resources\\feature\\loginpage.feature",
    glue ={"stepdefs"}
    ,plugin={"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"},
    monochrome = true,
    publish = true) //publish on cloude
    public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
