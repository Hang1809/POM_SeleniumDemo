package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.MyTicketPage;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest{

    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC15(){
        System.out.println("User can filter ticket with valid data : depart station, arrive station, status");

        loginPage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        myTicketPage.goToMyTicketPage();
        myTicketPage.filterTicket();

        
    }
}
