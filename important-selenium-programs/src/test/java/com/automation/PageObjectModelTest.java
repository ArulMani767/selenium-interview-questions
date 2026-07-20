package com.automation;

import com.automation.pages.LoginPage;
import org.testng.annotations.Test;
// Test Login Functionality using Page Object Model (POM) and it is in loginpage seperate folder
public class PageObjectModelTest extends TestBase {
    @Test
    public void testPOM() {
        driver.get("https://the-internet.herokuapp.com/login");

        var loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");
    }
}
