package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {
    @Test
    public void testFileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");

        var fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(System.getProperty("user.dir") + "/pom.xml");

        driver.findElement(By.id("file-submit")).click();
    }
}
