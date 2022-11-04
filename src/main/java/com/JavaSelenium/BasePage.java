package com.JavaSelenium;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
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
}
