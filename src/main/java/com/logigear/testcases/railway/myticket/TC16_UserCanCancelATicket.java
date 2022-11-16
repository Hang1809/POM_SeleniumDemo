package com.logigear.testcases.railway.myticket;

import com.logigear.common.Constant;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.MyTicketPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.annotations.Test;

public class TC16_UserCanCancelATicket extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test public void TC16(){
        System.out.println("User can cancel a ticket");

        loginPage.goToLoginPage();
        loginPage.fillDataLogin(Constant.USERNAME,Constant.PASSWORD);
        loginPage.goToMyTicketPage();
        myTicketPage.cancelTicketByStringRow("3");
        myTicketPage.acceptAlert();

    }
}
