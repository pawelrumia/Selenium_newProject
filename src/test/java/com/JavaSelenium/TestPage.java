package com.JavaSelenium;

import hook.CommonHooks;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestPage extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHooks.class);

    @Test
    public void navigateToMainPageAndCheckHeader() {
        LOGGER.info("Header check!");
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
