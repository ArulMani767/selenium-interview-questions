package com.automation;

import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

public class BrowserLogsTest extends TestBase {
    @Test
    public void testBrowserLogs() {
        driver.get("https://the-internet.herokuapp.com/");

        var logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (var entry : logEntries) {
            System.out.println(entry.getLevel() + " - " + entry.getMessage());
        }
    }
}
