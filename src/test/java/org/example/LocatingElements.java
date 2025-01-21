package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class LocatingElements {
    static {
        chromedriver().setup();
    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");

        //  finding an element
        WebElement emailTextField = driver.findElement(By.id("email"));

        WebElement imageButton = driver.findElement(By.id("imageButton"));

        //  finding multiple elements
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        System.out.println("Radio buttons size: " + radioButtons.size());

        //  using Relative locators
        WebElement bottomSubmitButton = driver.findElement(
                RelativeLocator.with(By.name("submit")).below(By.id("submit"))
        );

        WebElement clickButton = driver.findElement(RelativeLocator
                .with(By.cssSelector("input[type='submit']"))
                .near(By.id("lone_disabled_selected_radio"))
        );
        System.out.println("Button name is: " + clickButton.getDomAttribute("value"));

        WebElement workingTextField = driver.findElement(By.id("working"));
        driver.quit();
    }
}
