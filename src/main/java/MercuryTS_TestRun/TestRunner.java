package MercuryTS_TestRun;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty","html:target/cucumberreport","html:target/htmlreport"},
features={"H:\\Basic Java\\Java projects\\Maven_CucumberDemo\\src\\test\\resources\\FeatureCollection\\Login.feature"},
glue={"MercuryTS_main"},
tags={"@SmokeTest"})
public class TestRunner {

	
}
