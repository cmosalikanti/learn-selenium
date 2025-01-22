package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickOn(By by) {
        findElement(by).click();
    }

    protected WebElement findElement(By by) {
        return driver.findElement(by);
    }
}
