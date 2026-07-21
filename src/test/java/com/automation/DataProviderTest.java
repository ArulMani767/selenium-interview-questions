package com.automation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest extends TestBase {
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                { "user1", "pass1" },
                { "user2", "pass2" },
                { "user3", "pass3" }
        };
    }

    @Test(dataProvider = "loginData")
    public void testLoginData(String user, String pass) {
        System.out.println("Running parameterized test with user: " + user);
    }
}
