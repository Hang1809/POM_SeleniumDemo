package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pagesObjects.BookTicketPage;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC04(){
        System.out.println("Login page displays when un-logged User clicks on 'Book ticket' tab");

        bookTicketPage.goToBookTicketPage();

        String actualMsg = loginPage.getTitleLoginPage();
        String expectedMsg ="Login Page";

        Assert.assertEquals(actualMsg,expectedMsg,"Success message is not displayed as expected");
    }
    @Test
    public void TC14(){
        System.out.println("User can book 1 ticket at a time");

        loginPage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        bookTicketPage.goToBookTicketPage();
        bookTicketPage.bookTicket("1","Sài Gòn","Nha Trang","1","Soft bed with air conditioner");

        String actualMsg = bookTicketPage.getSuccessBookingMsg();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not displayed as expected");
    }
    @Test
    public void TC15(){
        System.out.println("User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");

        loginPage.goToLoginPage();
        System.out.println("Step2. Login with a valid account");
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        System.out.println("Step3. Click on 'Timetable' tab");
        homePage.goToTimeTablePage();
        System.out.println("Step4: Click on 'book ticket' link of the route from 'Huế' to 'Sài Gòn' ");

    }

}
