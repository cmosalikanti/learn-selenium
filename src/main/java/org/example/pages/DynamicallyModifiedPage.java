package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicallyModifiedPage extends BasePage {
    private final By button = By.id("buttonDelete");
    private final By element = By.id("element-to-remove");

    public DynamicallyModifiedPage(WebDriver driver) {
        super(driver);
    }
    public void clickButton() {
        clickOn(button);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5001));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public boolean isElementPresent() {
        try {
            findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
