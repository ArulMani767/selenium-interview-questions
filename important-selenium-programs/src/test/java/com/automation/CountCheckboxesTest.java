package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CountCheckboxesTest extends TestBase {

    //Count and Select Active Checkboxes

    @Test
    public void testCountCheckboxes() {
        driver.get("https://testing.qaautomationlabs.com/checkbox.php");

        var checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Total checkboxes: " + checkboxes.size());

        for (var checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
}
