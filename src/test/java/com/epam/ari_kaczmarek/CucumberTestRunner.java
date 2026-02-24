package com.epam.ari_kaczmarek;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.epam.ari_kaczmarek.definitions"
)
public class CucumberTestRunner {
}