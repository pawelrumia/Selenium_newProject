package com.JavaSelenium;

import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentIssuesPage extends BasePage {
    public CurrentIssuesPage(WebDriver driver) {
        super(driver);
    }

    public void checkCurrentIssuesHeader() {
        assertThat(super.driver.getTitle()).isEqualTo("News update | Nordea");
    }
}
