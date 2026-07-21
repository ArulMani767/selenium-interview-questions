package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class XPathMasteryTest extends TestBase {
    @Test
    public void testAllXPathSyntaxes() {
        driver.get("https://the-internet.herokuapp.com/login");

        // ---------------------------------------------------------------------
        // 1. BASIC ATTRIBUTES & ABSOLUTE / RELATIVE PATHS
        // Syntax: //tagname[@attribute='value']
        // ---------------------------------------------------------------------
        var basicXpath = driver.findElement(
            By.xpath("//input[@id='username']")
        );
        basicXpath.sendKeys("tomsmith");

        // ---------------------------------------------------------------------
        // 2. TEXT-BASED FUNCTIONS
        // Syntax: //tagname[text()='exact text']
        // Syntax: //tagname[contains(text(),'partial text')]
        // Syntax: //tagname[starts-with(text(),'prefix')]
        // Syntax: //tagname[normalize-space(text())='cleaned text']
        // ---------------------------------------------------------------------
        var exactText = driver.findElement(
            By.xpath("//h2[text()='Login Page']")
        );

        var containsText = driver.findElement(
            By.xpath("//h4[contains(text(),'This is where you can log in')]")
        );

        var startsWithText = driver.findElement(
            By.xpath("//h2[starts-with(text(),'Log')]")
        );

        var normalizedText = driver.findElement(
            By.xpath("//div[normalize-space(text())='Powered by Elementary School']")
        );

        // ---------------------------------------------------------------------
        // 3. ATTRIBUTE-BASED FUNCTIONS
        // Syntax: //tagname[contains(@attribute,'substring')]
        // Syntax: //tagname[starts-with(@attribute,'prefix')]
        // ---------------------------------------------------------------------
        var containsAttr = driver.findElement(
            By.xpath("//button[contains(@class, 'radius')]")
        );

        var startsWithAttr = driver.findElement(
            By.xpath("//form[starts-with(@name, 'login')]")
        );

        // ---------------------------------------------------------------------
        // 4. LOGICAL OPERATORS (AND, OR, NOT)
        // Syntax: //tagname[@attr1='val1' and @attr2='val2']
        // Syntax: //tagname[@attr1='val1' or @attr2='val2']
        // Syntax: //tagname[not(@type='hidden')]
        // ---------------------------------------------------------------------
        var andOperator = driver.findElement(
            By.xpath("//input[@type='password' and @name='password']")
        );

        var orOperator = driver.findElement(
            By.xpath("//button[@type='submit' or @id='loginBtn']")
        );

        var notOperator = driver.findElement(
            By.xpath("//input[@type='text' and not(@disabled)]")
        );

        // ---------------------------------------------------------------------
        // 5. INDEXING & POSITION FUNCTIONS
        // Syntax: (//tagname)[index]
        // Syntax: //tagname[position()=1]
        // Syntax: //tagname[last()] / //tagname[last()-1]
        // ---------------------------------------------------------------------
        var positionFirst = driver.findElement(
            By.xpath("(//input)[position()=1]")
        );

        var groupedIndex = driver.findElement(
            By.xpath("(//input)[2]")
        );

        var positionLast = driver.findElement(
            By.xpath("(//input)[last()]")
        );

        // ---------------------------------------------------------------------
        // 6. WILDCARD LOCATORS
        // Syntax: //*[@attribute='value']
        // Syntax: //tagname[@*='value']
        // ---------------------------------------------------------------------
        var anyTag = driver.findElement(
            By.xpath("//*[@id='login']")
        );

        var anyAttr = driver.findElement(
            By.xpath("//input[@*='username']")
        );

        // ---------------------------------------------------------------------
        // 7. XPATH AXES (PARENT, CHILD, ANCESTOR, DESCENDANT)
        // Syntax: //tagname/parent::parentTag
        // Syntax: //tagname/child::childTag
        // Syntax: //tagname/ancestor::ancestorTag
        // Syntax: //tagname/descendant::descendantTag
        // ---------------------------------------------------------------------
        var parentAxis = driver.findElement(
            By.xpath("//input[@id='username']/parent::div")
        );

        var childAxis = driver.findElement(
            By.xpath("//form[@id='login']/child::div[1]")
        );

        var ancestorAxis = driver.findElement(
            By.xpath("//input[@id='username']/ancestor::form")
        );

        var descendantAxis = driver.findElement(
            By.xpath("//form[@id='login']/descendant::input[@type='password']")
        );

        // ---------------------------------------------------------------------
        // 8. XPATH AXES (SIBLINGS & PRECEDING/FOLLOWING)
        // Syntax: //tagname/following-sibling::siblingTag
        // Syntax: //tagname/preceding-sibling::siblingTag
        // Syntax: //tagname/following::anyTag
        // Syntax: //tagname/preceding::anyTag
        // ---------------------------------------------------------------------
        var followingSibling = driver.findElement(
            By.xpath("//label[text()='Username']/following-sibling::input")
        );

        var precedingSibling = driver.findElement(
            By.xpath("//input[@id='password']/preceding-sibling::label")
        );

        var followingNode = driver.findElement(
            By.xpath("//label[text()='Username']/following::input[1]")
        );

        var precedingNode = driver.findElement(
            By.xpath("//button[@type='submit']/preceding::input[1]")
        );

        // Print confirmations to verify successful locator evaluation
        System.out.println("Page Heading: " + exactText.getText());
        System.out.println("Sub-heading: " + containsText.getText());
        System.out.println("Parent Div Class: " + parentAxis.getAttribute("class"));
    }
}
