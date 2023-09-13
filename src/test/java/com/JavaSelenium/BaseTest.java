package com.JavaSelenium;

import com.selenium.driverFactory.PageManager;
import com.selenium.pages.PageGenerator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest extends PageGenerator{
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator pageGenerator;
    public MainPage mainPage;

    public BaseTest(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setUp() {
        PageManager.getInstance().initializePageGenerator();
        System.out.println("Page generator initialized!");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
