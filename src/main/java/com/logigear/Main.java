package com.logigear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SATTDN22.03.09\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://www.railwayb2.somee.com/Page/HomePage.cshtml");
        System.out.println(driver.getTitle());

        //set thời gian chờ 20s
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.navigate().to("http://www.railwayb2.somee.com/Account/Login.cshtml");

        // Log-In Function

        driver.findElement(By.id("username")).sendKeys("milo@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();

    }
}