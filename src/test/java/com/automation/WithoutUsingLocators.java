package com.automation;

import org.testng.annotations.Test;

public class WithoutUsingLocators extends TestBase {
    // we can use the program to check without using locators ;
    @Test
    public void withoutLocators() {
        driver.get("https://example-flight-site.com");

        // Get page title and URL
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page URL: " + driver.getCurrentUrl());

        // alternatively we can use

        // String pageSource = driver.getPageSource();
        // System.out.println("Page Source:\n" + pageSource);
    }
}
