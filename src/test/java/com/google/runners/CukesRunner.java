package com.google.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/google/step_definitions",
        dryRun = false,
        tags = "@rtslabs"
)
public class CukesRunner {

}
