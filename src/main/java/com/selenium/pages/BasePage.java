package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
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

    public void selectFromDropDownList(WebElement element, String text) {
        waitUntil().until(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectRadioButton(WebElement radioGroup, String optionToSelect) {
        waitUntil().until(ExpectedConditions.visibilityOf(radioGroup));
        String xpath = String.format("//input[@value='%s']", optionToSelect);
        WebElement radioGroupButton = radioGroup.findElement(By.xpath(xpath));
        this.click(radioGroupButton);
    }
}
