package com.selenium.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverSupplier {
    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start--maximized");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        WebDriverManager.chromedriver().setup();
        return (WebDriver) new ChromeDriver(options);
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
    }

    public DriverType driverType;
    public WebDriver driver;
    private final String driverProp = System.getProperty("browser");
    private final String runLocally = System.getProperty("runLocally");

    WebDriver supplyValue() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private void selectDriver() {
        switch (driverProp) {
            case "firefox":
                driverType = DriverType.FIREFOX;
                break;
            case "chrome":
                driverType = DriverType.CHROME;
                break;
            default:
                throw new RuntimeException("Unsupported driver:"+ driverProp);
        }
    }
}
