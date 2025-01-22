package org.example.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ChallengeOnAlertAndMultipleWindows {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/alerts.html");
        String mainWindowHandle = driver.getWindowHandle();
        driver.findElement(By.id("open-window-with-onload-alert")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowHandles = driver.getWindowHandles();

        String secondaryWindow = null;
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                secondaryWindow = handle;
                driver.switchTo().window(handle);
                break;
            }
        }

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        //  switch the focus to the secondary window
        driver.switchTo().window(secondaryWindow);
        System.out.println(driver.getCurrentUrl());

        //  switch the focus to the originating window
        driver.switchTo().window(mainWindowHandle);
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
