package org.example.general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitAForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        By byUserNameTextField = By.id("my-text-id");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(byUserNameTextField));

        WebElement userNameTextField = driver.findElement(byUserNameTextField);
        userNameTextField.sendKeys("username");

        driver.findElement(By.name("my-password")).sendKeys("password123");
        driver.findElement(By.name("my-textarea")).sendKeys("I am learning Selenium Webdriver");

        Select dropdown = new Select(driver.findElement(By.name("my-select")));
        dropdown.selectByVisibleText("Three");

        WebElement checkedCheckbox = driver.findElement(By.id("my-check-1"));
        if (checkedCheckbox.isSelected()) {
            checkedCheckbox.click();
        }

        WebElement defaultCheckbox = driver.findElement(By.id("my-check-2"));
        if (!defaultCheckbox.isSelected()) {
            defaultCheckbox.click();
        }

        //  for radio buttons, we do not need to check if it is selected or not
        //  we just need to click on it since the others will be de-selected
        driver.findElement(By.id("my-radio-2")).click();

        WebElement submitButton = driver.findElement(By.cssSelector("button.btn-outline-primary"));
        submitButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        driver.quit();
    }
}
