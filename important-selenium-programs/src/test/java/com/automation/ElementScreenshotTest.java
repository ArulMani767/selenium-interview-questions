package com.automation;

import java.io.IOException;
import java.io.File;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;
//Capture Element-Level Screenshot
public class ElementScreenshotTest extends TestBase {
    @Test
    public void testElementScreenshot() throws IOException {
        driver.get("https://the-internet.herokuapp.com/");

        var header = driver.findElement(By.className("heading"));
        var srcFile = header.getScreenshotAs(OutputType.FILE);
        var destFile = new File("header_logo.png");

        FileHandler.copy(srcFile, destFile);
        System.out.println("Saved element screenshot to: " + destFile.getAbsolutePath());
    }
}
