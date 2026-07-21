package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ElementStateTest extends TestBase  {
    @Test
    public void testElementState() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        var checkbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        System.out.println("Is Displayed: " + checkbox.isDisplayed());
        System.out.println("Is Enabled: " + checkbox.isEnabled());
        System.out.println("Is Selected: " + checkbox.isSelected());
    }
}
