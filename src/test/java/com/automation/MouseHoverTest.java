package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

//Perform Mouse Hover Actions
public class MouseHoverTest extends TestBase{
    @Test
    public void testMouseHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        var avatar = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        var actions = new Actions(driver);

        actions.moveToElement(avatar).perform();
        System.out.println("Caption displayed: " + driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[1]")).getText());
    }
}
