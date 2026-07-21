package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Click200ButtonsTest extends TestBase {
    @Test
    public void testClick200Buttons() {
        driver.get("https://example.com/buttons-page"); // Replace with target URL

        for (int i = 0; i < 200; i++) {
            var buttons = driver.findElements(By.tagName("button"));
            if (i >= buttons.size())
                break;

            System.out.println("Clicking button: " + (i + 1));
            buttons.get(i).click();
        }
    }
}
