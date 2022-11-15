package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.common.DriverManager;
import com.logigear.common.Log;
import com.logigear.common.Utilities;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser) {
        System.out.println("Pre-condition:");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\executables\\chromedriver.exe");
            Constant.WEBDRIVER = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\executables\\geckodriver.exe");
            Constant.WEBDRIVER = new FirefoxDriver();
        }
        Log.info("Step 1: Navigate to QA Railway Website");
        DriverManager.open();
        DOMConfigurator.configure(Utilities.getProjectPath()+"\\configs\\log4j.xml");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
