package com.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadConfigFileTest extends TestBase {
    @Test
    public void testReadConfig() throws IOException {
        var props = new Properties();
        var file = new FileInputStream("config.properties");

        props.load(file);
        System.out.println("Browser Configured: " + props.getProperty("browser", "chrome"));
    }
}
