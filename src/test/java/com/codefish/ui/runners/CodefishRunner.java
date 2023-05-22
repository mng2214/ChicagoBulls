package com.codefish.ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = "com/codefish/ui/stepdef",
        dryRun = false,
        tags = "@cartFunctionality",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CodefishRunner {
}
