package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

// Read and Extract Data from a Dynamic Web Table
public class ReadWebTableTest extends TestBase {
    @Test
    public void testReadWebTable() {
        driver.get("https://testing.qaautomationlabs.com/web-table.php");

        var rows = driver.findElements(By.xpath("//table//tbody/tr"));
        for (var row : rows) {
            var cols = row.findElements(By.tagName("td"));
            if (!cols.isEmpty()) {
                System.out.println("ID: " + cols.get(0).getText() +
                        " | Name: " + cols.get(1).getText() +
                        " | Country: " + cols.get(2).getText());
            }
        }
    }
}
