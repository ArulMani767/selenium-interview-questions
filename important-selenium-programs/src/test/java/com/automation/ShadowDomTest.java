package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
// Access Elements Inside Shadow DOM
public class ShadowDomTest extends TestBase {
    @Test
    public void testShadowDom() {
        driver.get("https://the-internet.herokuapp.com/shadowdom");

        var shadowHost = driver.findElement(By.xpath("(//my-paragraph)[1]"));
        var shadowRoot = shadowHost.getShadowRoot();

        var textElement = shadowRoot.findElement(By.cssSelector("span"));
        System.out.println("Text from inside Shadow Root: " + textElement.getText());
    }
}
