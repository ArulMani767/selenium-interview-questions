package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
//Handle Auto-Suggest Dropdowns Dynamically
public class AutoSuggestDropdownTest extends TestBase {
    @Test
    public void testAutoSuggest() throws InterruptedException {
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(1500);

        var suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
        for (var option : suggestions) {
            if (option.getText().equalsIgnoreCase("selenium webdriver")) {
                option.click();
                break;
            }
        }
    }
}
