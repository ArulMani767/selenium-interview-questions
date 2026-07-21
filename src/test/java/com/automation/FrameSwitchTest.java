package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
//Switch To and Handle iFrames
public class FrameSwitchTest extends TestBase {
    @Test
    public void testFrameSwitch() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");
        var editor = driver.findElement(By.id("tinymce"));

        editor.clear();
        editor.sendKeys("Automating inside an iframe");

        driver.switchTo().defaultContent();
    }
}
