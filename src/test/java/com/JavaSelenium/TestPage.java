package com.JavaSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestPage {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navigateToPage() {
        driver.get("https://www.nordea.fi/en/personal/get-help/");
        MainPage page = PageFactory.initElements(driver, MainPage.class);
        //Accept cookies by clicking accept button or via javascript - does not work
        page.clickAlert();
        //Print out header of the card
        System.out.println(driver.getTitle());
        //Print out count of card links
        System.out.println(page.getLatestNewsTitlesCount());
        //Print out link nr 2 href
        System.out.println(page.getSecondHrefText());
        //Come up with 2 assertions for elements in the card
        page.checkHeader();
        page.isLogInButtonVisible();
        //Click on link nr 2
        page.clickSecondLink();
        //Add assertion that you were redirected correctly
        CurrentIssuesPage secondPage = PageFactory.initElements(driver, CurrentIssuesPage.class);
        secondPage.checkCurrentIssuesHeader();
    }

    @After
    public void close() {
        driver.quit();
    }
}
