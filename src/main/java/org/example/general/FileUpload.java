package org.example.general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileUpload {
    public static void main(String[] args) {
        new FileUpload().testFileUpload();
    }
    private void testFileUpload() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        URL fileUrl = getClass().getClassLoader().getResource("test.txt");

        File file;
        try {
            file = new File(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String filePath = file.getAbsolutePath();
        driver.findElement(By.name("my-file")).sendKeys(filePath);
        driver.quit();
    }
}
