package com.logigear.testcases.railway;

import com.logigear.common.constant.Constant;
import com.logigear.pages.BookTicketPage;
import com.logigear.pages.HomePage;
import com.logigear.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest {
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
    @Test
    public void TC13(){
        System.out.println("");

    }


}
