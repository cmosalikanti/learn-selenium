package org.example.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingAlertAndPrompt {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/alerts.html");
        driver.findElement(By.id("slow-alert")).click();

        var wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(alert.getText());
        alert.accept();

        //  handling double prompts
        driver.findElement(By.id("double-prompt")).click();
        Alert firstPrompt = driver.switchTo().alert();
        firstPrompt.sendKeys("This is the first prompt");
        firstPrompt.accept();

        Alert secondPrompt = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(secondPrompt.getText());
        driver.switchTo().alert();
        secondPrompt.sendKeys("This is the second prompt");
        secondPrompt.accept();
        driver.quit();
    }
}
