package com.automation;

import java.net.HttpURLConnection;
import java.net.URI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BrokenLinksInWebPage extends TestBase {
    @Test
    public void testBrokenLinksOnPage() {
        driver.get("https://the-internet.herokuapp.com/broken_images");

        var links = driver.findElements(By.tagName("a"));

        for (var link : links) {
            String url = link.getAttribute("href");

            if (url == null || url.isBlank() || !url.startsWith("http")) {
                continue;
            }

            try {
                var connection = (HttpURLConnection) URI.create(url).toURL().openConnection();
                connection.setRequestMethod("HEAD");
                connection.setConnectTimeout(3000);
                connection.connect();

                if (connection.getResponseCode() >= 400) {
                    System.out.println("Broken Link [" + connection.getResponseCode() + "]: " + url);
                }
            } catch (Exception e) {
                System.out.println("Failed to connect: " + url);
            }
        }
    }
}
