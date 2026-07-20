package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
// Locate Element by Contains and Starts-With Text
public class XPathFunctionsTest extends TestBase{
    @Test
    public void testXPathFunctions() {
        driver.get("https://the-internet.herokuapp.com/");

        var link = driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]"));
        System.out.println("Link Text: " + link.getText());
    }
}
