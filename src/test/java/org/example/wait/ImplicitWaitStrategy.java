package org.example.wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitStrategy {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //  this is implicit timeout: waiting for up to 3 secs for the elements to be found before throwing an exception.
        //  If the elements is found, web driver will interact with the web page straight away and won't waste the test
        //  execution
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("reveal")).click();
        driver.findElement(By.id("revealed")).sendKeys("text in the revealed input");
        driver.quit();
    }
}
