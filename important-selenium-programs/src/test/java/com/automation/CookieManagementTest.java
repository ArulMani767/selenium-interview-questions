package com.automation;

import org.testng.annotations.Test;
import org.openqa.selenium.Cookie;

public class CookieManagementTest extends TestBase {
    @Test
    public void testCookies() {
        driver.get("https://the-internet.herokuapp.com/");

        var customCookie = new Cookie("user_session", "interview_prep_2026");
        driver.manage().addCookie(customCookie);

        var retrievedCookie = driver.manage().getCookieNamed("user_session");
        System.out.println("Cookie Value: " + retrievedCookie.getValue());

        driver.manage().deleteAllCookies();
    }
}
