package com.logigear.testcases.railway.myticket;

import com.logigear.common.Constant;
import com.logigear.common.DriverManager;
import com.logigear.common.Log;
import com.logigear.common.PropertiesFile;
import com.logigear.pagesObjects.BookTicketPage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.MyTicketPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC16_UserCanCancelATicket extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    DriverManager driverManager = new DriverManager();

    @Test public void TC16() {
        String rowNumber ="1";
        Log.info("User can cancel a ticket");
        Log.info("Step1. Navigate to QA Railway Website");
        loginPage.goToLoginPage();
        Log.info("Step2. Login with a valid account");
        loginPage.fillDataLogin(Constant.USERNAME, PropertiesFile.getPropValue("password"));
        loginPage.clickBtnLogin();
        Log.info("Step3: Book a ticket");
        myTicketPage.goToBookTicketPage();
        bookTicketPage.bookTicket(Constant.DEPART_DATE,"Sài Gòn","Nha Trang","1","Hard seat");
        Log.info("Step4: Click on 'My ticket' tab");
        loginPage.goToMyTicketPage();
        Log.info("Step5: Click on 'Cancel' button of ticket which user want to cancel");
        myTicketPage.cancelTicketByStringRow(rowNumber);
        Log.info("Step6: Click on 'OK' button on Confirmation message 'Are you sure?'");
        driverManager.acceptAlert();
        Log.info("The canceled ticket is disappeared.");
        Log.info(myTicketPage.checkTicketDisappear(rowNumber));
    }
}
