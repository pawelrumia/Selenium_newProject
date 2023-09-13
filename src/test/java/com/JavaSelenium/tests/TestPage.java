package com.JavaSelenium.tests;

import com.JavaSelenium.BaseTest;
import com.JavaSelenium.MainPage;
import com.selenium.driverFactory.PageManager;
import com.selenium.pages.PageGenerator;
import hook.CommonHooks;
import lombok.NoArgsConstructor;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPage extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestPage.class);
    private final PageGenerator pageGenerator = PageManager.getInstance().getPageGenerator();
    private final MainPage mainPage = this.pageGenerator.getInstance(MainPage.class);

    public TestPage(WebDriver driver) {
        super(driver);
    }

    @Test
    public void navigateToMainPageAndCheckHeader() {
        LOGGER.info("Header check!");
        mainPage.navigateToMainPage();
        assertThat(mainPage.getPageTitle()).isEqualTo("Practice Page");
    }

    @Test
    public void navigateToPageAndClickRadioButtonAndSelectFromList() {
        mainPage.selectRadioButton("honda")
                .selectFromDropdownList("Benz");
    }

    @Test
    public void checkFieldVisibility() {
        assertThat(mainPage.isTextFieldDisplayed()).isTrue();
        mainPage.clickHideButton();
        assertThat(mainPage.isTextFieldNotDisplayed("//input[@id='displayed-text']")).isTrue();
    }

    @Test
    public void sendNameAndHandleAlert() {
        mainPage.enterTextToAlert("Pawel")
                .clickAlertButton()
                .handleAlertMessageIfPresent();
    }

    @Test
    public void checkTableData() {
        List<Map<String, String>> tableData = mainPage.getTableData();
        assertThat(tableData.get(1).get("Course")).isEqualTo("Python Programming Language");
        assertThat(tableData.get(2), IsMapContaining.hasEntry("Course", "JavaScript Programming Language"));
    }

    @Test
    public void verifyTextFieldIsDisabledThenEnabled() {
        mainPage.clickDisableButton();
        assertThat(mainPage.verifyTextFieldIsEnabled()).isFalse();
        mainPage.clickEnableButton();
        assertThat(mainPage.verifyTextFieldIsEnabled()).isTrue();
    }

    @Test
    public void hoverButton() {
        mainPage.moveToHoverField()
                .clickTopButton();
    }
}
