package com.logigear.testcases.railway.bookticket;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.pagesObjects.BookTicketPage;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.MyTicketPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14_UserCanBook1Ticket extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC14(){
        Log.info("User can book 1 ticket at a time");
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Login with a valid account ");
        homePage.goToLoginPage();
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        Log.info("Step3: Click on 'Book ticket' tab ");
        bookTicketPage.goToBookTicketPage();
        Log.info("Step4: Select a \"Depart date\" from the list");
        Log.info("Step5: Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\". ");
        Log.info("Step6: Select \"Soft bed with air conditioner\" for \"Seat type\"");
        Log.info("Step7: Select \"1\" for \"Ticket amount\"");
        bookTicketPage.bookTicket("1","Sài Gòn","Nha Trang","1","Soft bed with air conditioner");

        String actualMsg = bookTicketPage.getSuccessBookingMsg();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not displayed as expected");
    }

}

