package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.*;

public class WaitForInvisibilityTest extends TestBase {
    @Test
    public void testWaitForInvisibility() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#checkbox-example button")).click();

        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait specifically for loading spinner to disappear
        boolean isHidden = wait.until(
            ExpectedConditions.invisibilityOfElementLocated(By.id("loading"))
        );

        System.out.println("Spinner disappeared successfully: " + isHidden);
    }
}
