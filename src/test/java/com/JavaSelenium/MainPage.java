package com.JavaSelenium;

import com.selenium.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @FindBy(how = How.XPATH, using = "//input[@name='enter-name']")
    private WebElement enterNameTextField;
    @FindBy(how = How.ID, using = "alertbtn")
    private WebElement alertButton;
    @FindBy(how = How.XPATH, using = "//tbody//tr")
    private List<WebElement> codingTableRows;
    @FindBy(how = How.ID, using = "enabled-example-input")
    private WebElement enabledDisabledTextField;
    @FindBy(how = How.ID, using = "disabled-button")
    private WebElement disableButton;
    @FindBy(how = How.ID, using = "enabled-button")
    private WebElement enableButton;
    @FindBy(how = How.ID, using = "mousehover")
    private WebElement mouseHoverField;
    @FindBy(how = How.XPATH, using = "//div[@class='mouse-hover-content']//a[1]")
    private WebElement topButton;


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

    public MainPage enterTextToAlert(String text) {
        super.sendText(text, this.enterNameTextField);
        return this;
    }

    public MainPage clickAlertButton() {
        super.click(this.alertButton);
        return this;
    }

    public List<Map<String, String>> getTableData() {
        List<Map<String, String>> actualTableRows = new ArrayList<>();

        this.codingTableRows.stream().skip(1).forEach(row -> actualTableRows.add(
                Map.of(
                        "Author", row.findElement(By.className("author-name")).getText(),
                        "Course", row.findElement(By.className("course-name")).getText(),
                        "Price", row.findElement(By.className("price")).getText()
                )
        ));
        return actualTableRows;
    }

    public MainPage clickDisableButton() {
        super.click(this.disableButton);
        return this;
    }

    public MainPage clickEnableButton() {
        super.click(this.enableButton);
        return this;
    }

    public boolean verifyTextFieldIsEnabled() {
        return super.isElementEnabled(this.enabledDisabledTextField);
    }

    public MainPage moveToHoverField() {
        super.moveTo(this.mouseHoverField);
        return this;
    }

    public MainPage clickTopButton() {
        super.click(this.topButton);
        return this;
    }
}
