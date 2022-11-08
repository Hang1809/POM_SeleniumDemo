package com.logigear.testcases.railway;

import com.logigear.common.constant.Constant;
import com.logigear.pages.BookTicketPage;
import com.logigear.pages.HomePage;
import com.logigear.pages.LoginPage;
import com.logigear.pages.MyTicketPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTicketTest {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition: Created Account");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SATTDN22.03.09\\Downloads\\chromedriver_win32\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
//        Constant.WEBDRIVER.quit();
    }
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC15(){
        System.out.println("User can filter ticket with valid data : depart station, arrive station, status");
        homePage.open();
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        myTicketPage.gotoMyTicketPage();
        myTicketPage.filterTicket();

//        String actualMsg = myTicketPage.getSuccessFilter();
//        String expectedMsg = "";
//
//        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not displayed as expected");
        
    }
}
