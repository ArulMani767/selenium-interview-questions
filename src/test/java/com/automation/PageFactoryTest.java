package com.automation;

import org.testng.annotations.Test;

import com.automation.pages.LoginPageFactory;

public class PageFactoryTest  extends TestBase{
    @Test
    public void testPageFactory() {
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");
    }
}
