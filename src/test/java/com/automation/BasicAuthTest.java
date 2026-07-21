package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
// Handle Basic Authentication Popups via URL
public class BasicAuthTest extends TestBase {
    @Test
    public void testBasicAuth() {
        // Embed credentials directly in URL: admin:admin@
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        var text = driver.findElement(By.cssSelector("p")).getText();
        System.out.println("Auth success text: " + text);
    }
}
