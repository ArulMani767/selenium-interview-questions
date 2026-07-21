package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClickTest extends TestBase {
    @Test
    public void testDoubleClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        var button = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me')]"));
        var actions = new Actions(driver);

        actions.doubleClick(button).perform();

        var alert = driver.switchTo().alert();
        alert.accept();
    }
}
