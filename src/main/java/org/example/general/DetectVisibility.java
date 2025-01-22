package org.example.general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DetectVisibility {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/coordinates_tests/page_with_hidden_element.html");
        WebElement element = driver.findElement(By.id("box"));

        if (element.isDisplayed()) {
            element.click();
        } else {
            System.out.println("The box is not visible !");
        }

        driver.quit();
    }
}
