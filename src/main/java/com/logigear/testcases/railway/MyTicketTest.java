package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pages.HomePage;
import com.logigear.pages.LoginPage;
import com.logigear.pages.MyTicketPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest{
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
