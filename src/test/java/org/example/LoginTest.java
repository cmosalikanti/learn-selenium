package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class LoginTest {
    public static void main(String[] args) {
        chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");

        By usernameFieldLocator = By.cssSelector("#user-name");
        By passwordFieldLocator = By.cssSelector("#password");
        By submitButtonLocator = By.cssSelector(".btn_action");
        By inventoryContainer = By.cssSelector("#inventory_container");

        //  explicit wait - waiting for a duration of up to 5 secs, with a condition.

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameFieldLocator)).isDisplayed();

        wait.until((driver) -> driver.findElement(usernameFieldLocator).isDisplayed());

        browser.findElement(usernameFieldLocator).sendKeys("standard_user");
        browser.findElement(passwordFieldLocator).sendKeys("secret_sauce");
        browser.findElement(submitButtonLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(inventoryContainer)).isDisplayed();

        //  quit the browser
        browser.quit();
    }
}