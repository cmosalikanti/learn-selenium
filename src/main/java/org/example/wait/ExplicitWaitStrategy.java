package org.example.wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitStrategy {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("reveal")).click();

        By byRevealed = By.id("revealed");

        //  explicit wait - This wait applies only to this element and is based on the explicit  condition.
        var wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byRevealed)));

        driver.findElement(byRevealed).sendKeys("text in the revealed input");
        driver.quit();
    }
}
