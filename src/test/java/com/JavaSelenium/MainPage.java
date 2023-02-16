package com.JavaSelenium;

import com.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//h1[@data-uniqid]")
    private WebElement titleHeader;
    @FindBy(how = How.XPATH, using = "//div[@class='left-align']//fieldset//label")
    private WebElement radioButtonExampleInput;
    @FindBy(how = How.XPATH, using = "//select[@id='carselect']")
    private WebElement selectCarDropdown;
    @FindBy(how = How.ID, using = "displayed-text")
    private WebElement enterTextField;
    @FindBy(how = How.ID, using = "hide-textbox")
    private WebElement hideTextBoxButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return super.getTextOfElement(this.titleHeader);
    }

    public MainPage selectRadioButton(String option) {
        super.selectRadioButton(this.radioButtonExampleInput, option);
        return this;
    }

    public MainPage selectFromDropdownList(String carToChoose) {
        super.selectFromDropDownList(this.selectCarDropdown, carToChoose);
        return this;
    }

    public boolean isTextFieldDisplayed() {
        return super.isVisible(this.enterTextField);
    }

    public boolean isTextFieldNotDisplayed(String xpathLocator) {
        return super.isDisplayed(By.xpath(xpathLocator));
    }

    public MainPage clickHideButton() {
        super.click(this.hideTextBoxButton);
        return this;
    }

}
