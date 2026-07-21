package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class DynamicLoadingTest extends TestBase {
    @Test
    public void testExplicitWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start button")).click();

        // Explicit Wait for element visibility
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var finishText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4"))
        );

        System.out.println("Loaded Text: " + finishText.getText());
    }
}
