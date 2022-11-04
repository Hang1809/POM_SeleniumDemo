package com.logigear;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SATTDN22.03.09\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://www.railwayb2.somee.com/Page/HomePage.cshtml");
        System.out.println(driver.getTitle());
        driver.navigate().to("http://www.railwayb2.somee.com/Account/Login.cshtml");
    }
}