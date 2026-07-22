package com.automation;

import java.io.File;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadVerifyTest  extends TestBase{
    @Test
    public void testFileDownload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        String fileName = "some-file.txt"; // Target file
        File downloadDir = new File(System.getProperty("user.home") + "/Downloads");

        // Trigger Download
        driver.findElement(By.linkText(fileName)).click();

        // Verification Loop
        File downloadedFile = new File(downloadDir, fileName);
        boolean isDownloaded = false;

        for (int i = 0; i < 10; i++) {
            if (downloadedFile.exists() && downloadedFile.length() > 0) {
                isDownloaded = true;
                break;
            }
            Thread.sleep(1000); // Wait 1 second before polling again
        }

        Assert.assertTrue(isDownloaded, "File download failed or file is empty!");
        System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
    }
}
