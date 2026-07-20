package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
// Perform Drag and Drop Action
public class DragAndDropTest extends TestBase {
    @Test
    public void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        var source = driver.findElement(By.id("column-a"));
        var target = driver.findElement(By.id("column-b"));

        new Actions(driver).dragAndDrop(source, target).perform();
    }
}
