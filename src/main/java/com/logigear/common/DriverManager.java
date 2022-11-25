package com.logigear.common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static void setBrowser(String browser){
        switch (browser){
            case "chrome":
                initChromeDriver();
                break;
            case "firefox":
                initFirefoxDriver();
                break;
        }
    }
    public static void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
    }
    public static void initFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\executables\\geckodriver.exe");
        Constant.WEBDRIVER = new FirefoxDriver();
    }

    public static void maximizeWindow(){
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
    public void acceptAlert() {
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
}
