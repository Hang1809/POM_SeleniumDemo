package com.logigear.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private WebDriver driver;

    static String appURL ="https://www.railwayb2.somee.com/Page/HomePage.cshtml";
    static String driverPath = "resources\\drivers\\";

    public WebDriver getDriver() {
        return driver;
    }

    private static WebDriver initChromeDriver(String appURL) {

        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.drive", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }
}

