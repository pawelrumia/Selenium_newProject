package com.selenium.pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    public WebDriver driver;

    public PageGenerator() {this.driver = new ChromeDriver();}

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }
}
