package org.example.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyAndPaste {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");

        //  identify the platform so we can either use CMD or Control to do the copy-paste
        Keys keys = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        //  copy the text from source to destination
        WebElement source = driver.findElement(By.id("withText"));
        WebElement destination = driver.findElement(By.id("emptyTextArea"));

        //  click, press down command key, press a, press c, release command key (select all and copy)
        new Actions(driver)
                .click(source)
                .keyDown(keys)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(keys)
                .perform();

        //  click, press down command key, press c, release command key (paste)
        new Actions(driver)
                .click(destination)
                .keyDown(keys)
                .sendKeys("v")
                .keyUp(keys)
                .perform();

        driver.quit();
    }
}
