package com.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BasePage extends PageGenerator{

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage navigateToMainPage() {
        this.driver.get("https://courses.letskodeit.com/practice");
        return this;
    }

    protected FluentWait<WebDriver> waitUntil(Duration timeout, Duration polling) {
        return new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(NoSuchElementException.class);
    }

    protected FluentWait<WebDriver> waitUntil() {
        return waitUntil(20);
    }

    protected FluentWait<WebDriver> waitUntil(long seconds) {
        return this.waitUntil(Duration.ofSeconds(seconds), Duration.ofSeconds(1));
    }

    protected void click(WebElement element) {
        waitUntil().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected boolean isVisible(WebElement element) {
         waitUntil(Duration.ofSeconds(2), Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));
         return true;
    }

    protected boolean isDisplayed(By elementLocator) {
        return !this.driver.findElements(elementLocator).isEmpty();
    }

    protected String getTextOfElement(WebElement element) {
        waitUntil().until(ExpectedConditions.visibilityOf(element));
        return element.getText().strip();
    }

    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    protected void selectFromDropDownList(WebElement element, String text) {
        waitUntil().until(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    protected void selectRadioButton(WebElement radioGroup, String optionToSelect) {
        waitUntil().until(ExpectedConditions.visibilityOf(radioGroup));
        String xpath = String.format("//input[@value='%s']", optionToSelect);
        WebElement radioGroupButton = radioGroup.findElement(By.xpath(xpath));
        this.click(radioGroupButton);
    }

    protected void moveTo(WebElement element) {
        final Actions action = new Actions(this.driver);
        waitUntil().until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).perform();
    }

    public void handleAlertMessageIfPresent() {
        try {
            this.waitUntil().until(ExpectedConditions.alertIsPresent()).accept();
        } catch (NoAlertPresentException exception) {
            exception.printStackTrace();
        }
        this.waitUntil(2);
    }

    protected void sendText(String text, WebElement element) {
        waitUntil().until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }

    protected boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }
}
