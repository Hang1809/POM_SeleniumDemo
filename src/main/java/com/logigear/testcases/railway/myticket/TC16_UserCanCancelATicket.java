package com.logigear.testcases.railway.myticket;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.common.PropertiesFile;
import com.logigear.pagesObjects.BookTicketPage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.MyTicketPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC16_UserCanCancelATicket extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test public void TC16(){
        Log.info("User can cancel a ticket");
        Log.info("Step1. Navigate to QA Railway Website");
        loginPage.goToLoginPage();
        Log.info("Step2. Login with a valid account");
        loginPage.fillDataLogin(Constant.USERNAME, PropertiesFile.getPropValue("password"));
        Log.info("Step3: Book a ticket");
        myTicketPage.goToBookTicketPage();
        bookTicketPage.bookTicket("1","Sài Gòn","Nha Trang","1","Hard seat");
        Log.info("Step4: Click on 'My ticket' tab");
        loginPage.goToMyTicketPage();
        Log.info("Step5: Click on 'Cancel' button of ticket which user want to cancel");
        myTicketPage.cancelTicketByStringRow("2");
        Log.info("Step6: Click on 'OK' button on Confirmation message 'Are you sure?'");
        myTicketPage.acceptAlert();

    }
}
