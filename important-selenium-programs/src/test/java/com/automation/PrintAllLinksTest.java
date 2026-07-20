package com.automation;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

//Extract and Print All Hyperlinks from a Web Page

public class PrintAllLinksTest extends TestBase {
   
    @Test
    public void testPrintLinks() {
        driver.get("https://www.flipkart.com/");

        var links = driver.findElements(By.tagName("a"));
        System.out.println("Total anchor tags found: " + links.size());

        for (var link : links) {
            var url = link.getAttribute("href");
            if (url != null && !url.isBlank()) {
                System.out.println(url);
            }
        }
    }
}
