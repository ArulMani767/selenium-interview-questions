package com.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.listeners.RetryAnalyzer;

public class FlakyTestRetryDemoTest extends TestBase {
    private static int attempt = 0;

    // Attach RetryAnalyzer using retryAnalyzer parameter in @Test annotation
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testFlakyScenario() {
        attempt++;
        System.out.println("Executing testFlakyScenario - Attempt: " + attempt);

        // Simulate a flaky test that fails twice and succeeds on the 3rd attempt
        if (attempt < 3) {
            Assert.fail("Simulated failure on attempt " + attempt);
        }

        driver.get("https://google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"), "Title check passed!");
    }
}
