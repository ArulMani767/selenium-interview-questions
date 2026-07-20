package com.automation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class FluentWaitTest extends TestBase {
    @Test
    public void testFluentWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start button")).click();

        var wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        var element = wait.until(d -> d.findElement(By.id("finish")));
        System.out.println("Element loaded text: " + element.getText());
    }
}
