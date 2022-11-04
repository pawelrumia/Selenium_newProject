package com.JavaSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//h2[@class=\"medium-h4\"]")
    private WebElement titleHeader;
    @FindBy(how = How.XPATH, using = "//a[@class='wscrOk']")
    private WebElement alert;
    @FindBy(how = How.XPATH, using = "//ul//a[@title=\"Ajankohtaisia uutisia - Page data\"]")
    private List<WebElement> cardLinksList;
    @FindBy(how = How.XPATH, using = "//button[@class = 'nav__button nav__button--login']")
    private WebElement logInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlert() {
        super.click(this.alert);
    }

    public int getLatestNewsTitlesCount() {
        return this.cardLinksList.size();
    }

    public String getSecondHrefText() {
        return this.cardLinksList.get(1).getAttribute("href");
    }

    public void checkHeader() {
        assertThat(super.driver.getTitle()).isEqualTo("Frequently asked questions | Nordea");
    }

    public void isLogInButtonVisible() {
        assertThat(super.isVisible(this.logInButton)).isTrue();
    }

    public void clickSecondLink(){
        super.click(this.cardLinksList.get(1));
    }
}
