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
}
