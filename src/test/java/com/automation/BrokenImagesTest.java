package com.automation;

import java.net.HttpURLConnection;
import java.net.URI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

// Check for Broken Links using HTTP Response Codes
public class BrokenImagesTest extends TestBase {
    @Test
    public void testBrokenImages() {
        driver.get("https://the-internet.herokuapp.com/broken_images");

        var images = driver.findElements(By.tagName("img"));
        System.out.println("Total images found: " + images.size());

        for (var img : images) {
            var src = img.getAttribute("src");

            // Filter out empty sources or Base64 inline images
            if (src == null || src.isBlank() || src.startsWith("data:image")) {
                continue;
            }

            try {
                var connection = (HttpURLConnection) URI.create(src).toURL().openConnection();
                connection.setRequestMethod("HEAD");
                connection.setConnectTimeout(3000);
                connection.connect();

                if (connection.getResponseCode() >= 400) {
                    System.out.println("Broken Image [" + connection.getResponseCode() + "]: " + src);
                }
            } catch (Exception e) {
                System.out.println("Failed to reach Image URL: " + src);
            }
        }
    }
}
