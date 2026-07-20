package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
//Scroll Into View Using JavaScriptExecutor
public class ScrollToElementTest  extends TestBase{
    @Test
    public void testScrollToElement() {
        driver.get("https://the-internet.herokuapp.com/");

        var element = driver.findElement(By.linkText("WYSIWYG Editor"));
        var js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
