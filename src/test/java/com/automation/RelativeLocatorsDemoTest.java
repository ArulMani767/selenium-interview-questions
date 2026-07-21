package com.automation;

// Static import for RelativeLocators (RelativeBy class)
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RelativeLocatorsDemoTest extends TestBase {
    @Test
    public void testAllRelativeLocators() {
        driver.get("https://the-internet.herokuapp.com/login");

        // Reference Anchor Element: The "Username" Input Field
        WebElement usernameInput = driver.findElement(By.id("username"));

        // ---------------------------------------------------------------------
        // 1. BELOW: Find element visually below the reference element
        // ---------------------------------------------------------------------
        WebElement passwordInput = driver.findElement(
            with(By.tagName("input")).below(usernameInput)
        );
        passwordInput.sendKeys("SuperSecretPassword!");
        System.out.println("1. [below]: Located Password input below Username.");

        // ---------------------------------------------------------------------
        // 2. ABOVE: Find element visually above the reference element
        // ---------------------------------------------------------------------
        WebElement usernameLabel = driver.findElement(
            with(By.tagName("label")).above(passwordInput)
        );
        System.out.println("2. [above]: Located Label text above Password: " + usernameLabel.getText());

        // ---------------------------------------------------------------------
        // 3. TO LEFT OF: Find element positioned to the left
        // ---------------------------------------------------------------------
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        System.out.println("3. Found first checkbox, located at x=" + firstCheckbox.getLocation().getX());

        // Find element/text positioned immediately to the left or surrounding
        WebElement pageHeader = driver.findElement(By.tagName("h3"));
        System.out.println("3. Main Header text: " + pageHeader.getText());

        // ---------------------------------------------------------------------
        // 4. TO RIGHT OF: Find element positioned to the right
        // ---------------------------------------------------------------------
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addBtn = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addBtn.click(); // Spawns the "Delete" button to the right/below

        WebElement deleteBtn = driver.findElement(
            with(By.tagName("button")).toRightOf(addBtn)
        );
        System.out.println("4. [toRightOf]: Located Delete button text: " + deleteBtn.getText());

        // ---------------------------------------------------------------------
        // 5. NEAR: Find element within a pixel radius (Default is 50px)
        // ---------------------------------------------------------------------
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        // Find input box within 50px radius of its label
        WebElement emailInput = driver.findElement(
            with(By.tagName("input")).near(emailLabel)
        );
        emailInput.sendKeys("testuser@example.com");
        System.out.println("5. [near]: Entered text into input field near email label.");

        // ---------------------------------------------------------------------
        // 6. CHAINING MULTIPLE RELATIVE LOCATORS
        // Combine multiple relative conditions together
        // ---------------------------------------------------------------------
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement loginFormHeader = driver.findElement(By.tagName("h2"));
        WebElement submitButton = driver.findElement(By.className("radius"));

        // Find an input tag that is both BELOW the Header AND ABOVE the Submit button
        WebElement chainedInput = driver.findElement(
            with(By.tagName("input"))
                .below(loginFormHeader)
                .above(submitButton)
        );
        System.out.println("6. [Chaining]: Located chained input element with tag: " + chainedInput.getTagName());
    }
}