package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClickTest extends TestBase{
    @Test
    public void testRightClick() {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        var hotSpot = driver.findElement(By.id("hot-spot"));
        var actions = new Actions(driver);

        actions.contextClick(hotSpot).perform();

        var alert = driver.switchTo().alert();
        System.out.println("Context Menu Alert Text: " + alert.getText());
        alert.accept();
    }
}
