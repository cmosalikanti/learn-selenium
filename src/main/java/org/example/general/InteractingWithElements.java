package org.example.general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class InteractingWithElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");

        WebElement nameTextField = driver.findElement(By.name("id-name1"));
        nameTextField.clear();
        nameTextField.sendKeys("Selenium");
        driver.quit();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        //  handling Drop-down menus
        Select dropdown = new Select(driver.findElement(By.name("my-select")));
        dropdown.selectByVisibleText("Three");
        driver.quit();
    }
}
