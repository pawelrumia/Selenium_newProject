package com.JavaSelenium;

import hook.CommonHooks;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class TestPage extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHooks.class);

    @Test
    public void navigateToMainPageAndCheckHeader() {
        mainPage.navigateToMainPage();
        assertThat(mainPage.getPageTitle()).isEqualTo("Practice Page");
    }

    @Test
    public void navigateToPageAndClickRadioButtonAndSelectFromList() {
        mainPage.navigateToMainPage();
        mainPage.selectRadioButton("honda")
                .selectFromDropdownList("Benz");
    }

    @Test
    public void checkFieldVisibility() {
        mainPage.navigateToMainPage();
        assertThat(mainPage.isTextFieldDisplayed()).isTrue();
        mainPage.clickHideButton();
        assertThat(mainPage.isTextFieldNotDisplayed("//input[@id='displayed-text']")).isTrue();
    }
}
