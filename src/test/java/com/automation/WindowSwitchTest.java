package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
//Switch Between Multiple Browser Windows / Tabs
public class WindowSwitchTest extends TestBase {
    @Test
    public void testWindowSwitch() {
        driver.get("https://the-internet.herokuapp.com/windows");

        var parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        var allWindows = driver.getWindowHandles();
        for (var window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Child Window Title: " + driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
    }
}
