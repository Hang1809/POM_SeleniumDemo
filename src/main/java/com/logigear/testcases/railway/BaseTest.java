package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.common.DriverManager;
import com.logigear.common.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition: Created Account");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+ "\\executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        DriverManager.open();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
