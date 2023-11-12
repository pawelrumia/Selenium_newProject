package com.JavaSelenium;

import com.selenium.pages.PageGenerator;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest extends PageGenerator{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public PageGenerator pageGenerator;

    public BaseTest() {}



    @After
    public void tearDown() {
        driver.quit();
    }
}
