package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DatePickerTest extends TestBase {
    @Test
    public void testSelectDate() {
        driver.get("https://jqueryui.com/datepicker/");

        // Switch to frame containing datepicker
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        driver.findElement(By.id("datepicker")).click();

        String targetMonthYear = "December 2026";
        String targetDay = "25";

        while (true) {
            String currentMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();

            if (currentMonthYear.equalsIgnoreCase(targetMonthYear)) {
                break;
            }
            // Click Next Month arrow
            driver.findElement(By.xpath("//span[text()='Next']")).click();
        }

        // Select Day
        driver.findElement(By.xpath("//a[text()='" + targetDay + "']")).click();
        System.out.println("Selected Date Successfully.");
    }
}
