package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemoTest extends TestBase {
    @Test
    public void testJavaScriptExecutorMethods() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");

        // Cast WebDriver to JavascriptExecutor
        var js = (JavascriptExecutor) driver;

        // 1. Get Page Title via JS
        var title = (String) js.executeScript("return document.title;");
        System.out.println("1. Page Title via JS: " + title);

        // 2. Type text into an Input Field via JS
        var usernameInput = driver.findElement(By.id("username"));
        js.executeScript("arguments[0].value='tomsmith';", usernameInput);
        System.out.println("2. Entered username using JS");

        // 3. Highlight an Element (Useful for debugging/demoing)
        var passwordInput = driver.findElement(By.id("password"));
        js.executeScript("arguments[0].style.border='3px solid red';", passwordInput);
        passwordInput.sendKeys("SuperSecretPassword!");
        System.out.println("3. Highlighted password field with red border");

        // 4. Click an Element via JS
        var loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        js.executeScript("arguments[0].click();", loginBtn);
        System.out.println("4. Clicked login button using JS");

        // 5. Scroll Down the Page
        js.executeScript("window.scrollBy(0, 500);");
        System.out.println("5. Scrolled down 500 pixels");

        // 6. Scroll an Element into View
        var footerLink = driver.findElement(By.linkText("Elemental Selenium"));
        js.executeScript("arguments[0].scrollIntoView(true);", footerLink);
        System.out.println("6. Scrolled footer link into view");

        // 7. Refresh Page via JS
        js.executeScript("history.go(0);");
        System.out.println("7. Refreshed page via JS");
    }
}
