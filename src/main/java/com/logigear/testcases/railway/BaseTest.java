package com.logigear.testcases.railway;

import com.logigear.common.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private void setBrowser(String browser){
        switch (browser){
            case "chrome":
                initChromeDriver();
                break;
            case "firefox":
                initFirefoxDrive();
                break;
        }
    }
    private static void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
    }
    private static void initFirefoxDrive(){
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\executables\\geckodriver.exe");
        Constant.WEBDRIVER = new FirefoxDriver();
    }
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser) {
        setBrowser("chrome");
        maximizeWindow();
        System.out.println("Pre-condition:");
        DriverManager.open();
        PropertiesFile.setPropertiesFile();
        DOMConfigurator.configure(Utilities.getProjectPath()+"\\configs\\log4j.xml");
    }
    public void maximizeWindow(){
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
