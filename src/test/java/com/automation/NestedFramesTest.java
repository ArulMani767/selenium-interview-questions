package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NestedFramesTest extends TestBase{
    @Test
    public void testNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        var content = driver.findElement(By.id("content")).getText();
        System.out.println("Middle Frame Content: " + content);

        driver.switchTo().defaultContent();
    }
}
