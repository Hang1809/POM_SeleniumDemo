package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pagesObjects.BookTicketPage;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC11(){
        System.out.println("User can book ticket successfully with valid data input");
        homePage.open();
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.bookTicket();

        String actualMsg = bookTicketPage.getSuccessBookingMsg();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not displayed as expected");
    }
    @Test
    public void TC12(){
        System.out.println("User can't book over 10 tickets");
        System.out.println("Pre-condition: Having booked ticket already");
        homePage.open();
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.book10Ticket();

        String actualMsg = bookTicketPage.getErrorBookingMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

}
