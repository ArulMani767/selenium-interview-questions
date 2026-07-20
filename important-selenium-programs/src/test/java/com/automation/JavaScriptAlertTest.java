package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
//Handle Simple JavaScript Alert Popups
public class JavaScriptAlertTest extends TestBase {
    @Test
    public void testJSAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        var alert = driver.switchTo().alert();

        System.out.println("Alert Message: " + alert.getText());
        alert.accept();
    }
}
