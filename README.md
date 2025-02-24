## Concepts, Examples for developing UI Automation scripts using Selenium and Java

### Resource for creating test scripts
https://www.selenium.dev/selenium/web/

- FormPage: https://www.selenium.dev/selenium/web/formPage.html
- WebForm: https://www.selenium.dev/selenium/web/web-form.html
- Test Hidden elements: https://www.selenium.dev/selenium/web/coordinates_tests/page_with_hidden_element.html
- Alerts and Prompts: https://www.selenium.dev/selenium/web/alerts.html
- Mouse interactions: https://www.selenium.dev/selenium/web/mouse_interaction.html
- Tall frame: https://www.selenium.dev/selenium/web/scrolling_tests/page_with_tall_frame.html
- Keyboard shortcut: https://www.selenium.dev/selenium/web/keyboard_shortcut.html

# Things to note in DOM model
- The value of the 'name' attribute  is not required to be unique across the DOM.

## Selenium 4 Features:
-   Relative locators: When using them, be mindful about the viewPort size. For e.g., in the mobile view, the element
might not be "below" the element as in the web view.

##  Selenium API
- isEnabled(): This method checks whether an element can be interacted with, indicating its enabled or disabled state.
- isDisplayed(): This method in WebDriver is used to check if an element is currently visible on the page.
- Implicit Wait: The web driver just waits up to the time specified as below. This is applied globally. Used for all
element lookups across the entire webdriver instance. Use to control waits across all element interactions.
 ```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
```
- Explicit wait - This wait applies only to only one element and is based on the explicit condition. Conditionally wait
for specific interactions.
```java
        var wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byRevealed)));
```
- Do not mix wait strategies as below
  1. Incorrect: Implicit wait AND Explicit wait - This will cause unpredictable wait time
  2. Correct: Implicit OR Explicit wait

- Fluent wait - Allow specifying polling intervals and ignoring specific exceptions.
```java
//  default wait for a fluent wait is 500ms
var wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(5))
        .pollingEvery(Duration.ofMillis(300))
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.visibilityOf(driver.findElement(byRevealed)));
````
### Actions API
Provided by webdriver to have precise control over mouse and keyboard events

For e.g., to hover over an element
```java
new Actions(driver).moveToElement(WebElement).perform();
```
to perform double-click:
```java
new Actions(driver).doubleClick(WebElement).perform();
```
to perform context-click (right click):
```java
new Actions(driver).contextClick(WebElement).perform();
```

   
