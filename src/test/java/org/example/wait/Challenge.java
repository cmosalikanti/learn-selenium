package org.example.wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Challenge {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/dynamicallyModifiedPage.html");
        driver.findElement(By.id("buttonDelete")).click();

        By elementToRemove = By.id("element-to-remove");

        //  on clicking of the 'buttonDelete' button, the element 'element-to-remove' will be removed in half a second
        //  Here, it doesn't make sense to use FluentWait since we know that the element will not removed
        //  before half a second.
        var wait = new WebDriverWait( driver, Duration.ofMillis(5001));
        Boolean isRemoved = wait.until(ExpectedConditions.invisibilityOf(driver.findElement(elementToRemove)));
        System.out.println("Element removed ? :" + isRemoved);

        driver.quit();
    }
}
