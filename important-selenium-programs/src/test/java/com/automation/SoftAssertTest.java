package com.automation;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest extends TestBase {
    @Test
    public void testSoftAssert() {
        driver.get("https://the-internet.herokuapp.com/");

        var softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getTitle(), "The Internet", "Title mismatch");
        softAssert.assertTrue(driver.getCurrentUrl().contains("herokuapp"), "URL mismatch");

        softAssert.assertAll();
    }
}
