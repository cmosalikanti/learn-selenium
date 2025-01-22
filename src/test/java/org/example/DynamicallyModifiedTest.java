package org.example;

import org.example.base.BaseTest;
import org.example.pages.DynamicallyModifiedPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicallyModifiedTest extends BaseTest {

    private DynamicallyModifiedPage dynamicallyModifiedPage;
    @BeforeEach
    public void before() {
        driver.get("https://www.selenium.dev/selenium/web/dynamicallyModifiedPage.html");
        dynamicallyModifiedPage = new DynamicallyModifiedPage(driver);
    }

    @Test
    public void shouldVerifyElementIsPresent() {
        assertTrue(dynamicallyModifiedPage.isElementPresent());
    }

    @Test
    public void shouldVerifyElementHasDisappeared() {
        dynamicallyModifiedPage.clickButton();
        assertFalse(dynamicallyModifiedPage.isElementPresent());
    }
}
