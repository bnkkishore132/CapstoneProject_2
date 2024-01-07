package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*@CucumberOptions(features = "src/test/resources", 
 * 				glue = "com.webdriveruniversity.stepdefinitions")
public class runner extends AbstractTestNGCucumberTests {
}*/

@CucumberOptions(features = {"src/test/resources/features/Capstone.feature"}, 
				 glue = {"Stepdefinitions.Stepdefinition"},
				 tags = "@testcapstone",
				 plugin ={"pretty","json:target/Capstone.feature.json"}
				 )
public class runner extends AbstractTestNGCucumberTests{
	
}
