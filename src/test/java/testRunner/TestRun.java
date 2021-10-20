package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;


import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
(
features= {".//Features/"},
glue="stepDefinitions",
dryRun=false,
monochrome=true,
plugin= {"pretty","html:test_output"},
tags="@sanity or @functional or ~@regression"
)
public class TestRun {

}
