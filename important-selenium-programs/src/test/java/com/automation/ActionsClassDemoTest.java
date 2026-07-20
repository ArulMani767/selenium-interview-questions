package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClassDemoTest extends TestBase {
    @Test
    public void testActionsClassMethods() {
        // Instantiate the Actions class by passing the driver
        var actions = new Actions(driver);

        // 1. Mouse Hover (moveToElement)
        driver.get("https://the-internet.herokuapp.com/hovers");
        var userAvatar = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(userAvatar).perform();
        System.out.println("1. Mouse hover performed over avatar.");

        // 2. Right-Click / Context Click (contextClick)
        driver.get("https://the-internet.herokuapp.com/context_menu");
        var hotSpot = driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotSpot).perform();
        driver.switchTo().alert().accept();
        System.out.println("2. Right-click performed and alert accepted.");

        // 3. Double-Click (doubleClick)
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        var doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me')]"));
        actions.doubleClick(doubleClickBtn).perform();
        driver.switchTo().alert().accept();
        System.out.println("3. Double-click performed and alert accepted.");

        // 4. Keyboard Actions (keyDown, keyUp, sendKeys)
        driver.get("https://www.google.com");
        var searchBox = driver.findElement(By.name("q"));
        actions.keyDown(searchBox, Keys.SHIFT)
               .sendKeys("selenium actions class")
               .keyUp(Keys.SHIFT)
               .perform();
        System.out.println("4. Typed text in UPPERCASE using SHIFT key combination.");
    }
}
