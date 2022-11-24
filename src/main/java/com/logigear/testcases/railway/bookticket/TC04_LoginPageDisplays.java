package com.logigear.testcases.railway.bookticket;

import com.logigear.common.Log;
import com.logigear.pagesObjects.BookTicketPage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_LoginPageDisplays extends BaseTest {
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC04() {
        Log.info("Login page displays when un-logged User clicks on 'Book ticket' tab");
        Log.info("Step1. Navigate to QA Railway Website");
        Log.info("Step2. Click on 'Book ticket' tab ");
        bookTicketPage.goToBookTicketPage();

        String actualMsg = loginPage.getTitleLoginPage();
        String expectedMsg = "Login Page";

        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not displayed as expected");
    }
}
