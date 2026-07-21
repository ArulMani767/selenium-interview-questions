package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//Select Option from Static Dropdown by Text and Index
public class SelectDropdownTest extends TestBase{
    @Test
    public void testDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        var select = new Select(driver.findElement(By.id("single-select")));
        select.selectByVisibleText("Apple");

        System.out.println("Selected: " + select.getFirstSelectedOption().getText());
    }
}
