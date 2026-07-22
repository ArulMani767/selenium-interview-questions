package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

//Sequentially Click Multiple Links Without Stale Element Errors
public class ClickMultipleLinksTest extends TestBase {
    @Test
    public void testClickMultipleLinks() {
        driver.get("https://news.ycombinator.com/");

        for (int i = 0; i < 5; i++) {
            var links = driver.findElements(By.cssSelector("span.titleline > a"));
            if (i >= links.size()){
                break;
        }
            System.out.println("Clicking: " + links.get(i).getText());
            links.get(i).click();
            driver.navigate().back();
        }
    }
}
