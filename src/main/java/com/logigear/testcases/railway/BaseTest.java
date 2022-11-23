package com.logigear.testcases.railway;

import com.logigear.common.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;



public class BaseTest {
    private void setBrowser(String browser){
        switch (browser){
            case "chrome":
                initChromeDriver();
                break;
            case "firefox":
                initFirefoxDriver();
                break;
        }
    }
    private static void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
    }
    private static void initFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\executables\\geckodriver.exe");
        Constant.WEBDRIVER = new FirefoxDriver();
    }
    @BeforeMethod
    public void beforeMethod() {
        PropertiesFile.setPropertiesFile();
        setBrowser(PropertiesFile.getPropValue("browser"));
        DriverManager.open();
        maximizeWindow();
        System.out.println("Pre-condition:");
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
