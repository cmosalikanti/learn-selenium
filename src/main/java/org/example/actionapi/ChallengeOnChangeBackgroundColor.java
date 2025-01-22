package org.example.actionapi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ChallengeOnChangeBackgroundColor {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/keyboard_shortcut.html");

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.SHIFT)
                .sendKeys("1")
                .keyUp(Keys.CONTROL)
                .keyUp(Keys.SHIFT)
                .perform();

        System.out.println(driver.findElement(By.tagName("body")).getDomAttribute("style"));

        new Actions(driver)
                .keyDown(Keys.ALT)
                .sendKeys("1")
                .keyUp(Keys.ALT)
                .perform();

        System.out.println(driver.findElement(By.tagName("body")).getDomAttribute("style"));

        driver.quit();
    }
}
