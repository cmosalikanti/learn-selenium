package org.example.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollToBottom {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/page_with_tall_frame.html");

        var heightOfPage = driver.findElement(By.tagName("body")).getRect().getHeight();
        new Actions(driver).scrollByAmount(0, heightOfPage).perform();
        driver.quit();
    }
}
