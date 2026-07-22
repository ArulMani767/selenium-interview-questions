package com.automation;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class InfiniteScrollTest extends TestBase{
    @Test
    public void testInfiniteScroll() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        var js = (JavascriptExecutor) driver;

        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        for (int i = 0; i < 5; i++) { // Scroll 5 times
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1500); // Wait for dynamic content load

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                System.out.println("Reached end of page.");
                break;
            }
            lastHeight = newHeight;
        }
    }
}
