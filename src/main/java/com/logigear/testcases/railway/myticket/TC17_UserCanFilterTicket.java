package com.logigear.testcases.railway.myticket;

import com.logigear.common.Constant;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.MyTicketPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.annotations.Test;

public class TC17_UserCanFilterTicket extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC17(){
        System.out.println("User can filter ticket with valid data : depart station, arrive station, status");

        loginPage.goToLoginPage();
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        myTicketPage.goToMyTicketPage();
        myTicketPage.filterTicket("2","3","","1");

    }
}
