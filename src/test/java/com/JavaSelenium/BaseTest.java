package com.JavaSelenium;

import com.selenium.pages.PageGenerator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator pageGenerator;
    public MainPage mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        pageGenerator = new PageGenerator(driver);
        mainPage = pageGenerator.getInstance(MainPage.class);
        mainPage.navigateToMainPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
