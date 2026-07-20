package com.automation;

import java.net.HttpURLConnection;
import java.net.URI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
// Check for Broken Links using HTTP Response Codes
public class BrokenLinksTest extends TestBase {
    @Test
    public void testBrokenLinks() {
        driver.get("https://the-internet.herokuapp.com/broken_images");

        var images = driver.findElements(By.tagName("img"));
        for (var img : images) {
            var src = img.getAttribute("src");
            try {
                var connection = (HttpURLConnection) new URI(src).toURL().openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                if (connection.getResponseCode() >= 400) {
                    System.out.println("Broken Link/Image: " + src);
                }
            } catch (Exception e) {
                System.out.println("Failed to reach: " + src);
            }
        }
    }
}
