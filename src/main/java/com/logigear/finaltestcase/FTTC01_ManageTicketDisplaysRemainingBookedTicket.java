package com.logigear.finaltestcase;

import com.logigear.common.Constant;
import com.logigear.common.JSONUtils;
import com.logigear.common.Log;
import com.logigear.pagesObjects.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FTTC01_ManageTicketDisplaysRemainingBookedTicket extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void FTTC01() {
        //REGISTER ACCOUNT
        Log.info("Register Account");
        JSONArray registeredAccountList = JSONUtils.getJSONList(RegisterPage.REGISTERED_ACCOUNT_PATH);
        String username = RegisterPage.REGISTER_USERNAME;
        String password = Constant.PASSWORD;
        homePage.goToRegisterPage();
        registerPage.register(username, password, Constant.PASSWORD, Constant.PID);

        //WRITE NEW REGISTERED_ACCOUNT INTO JSON FILE
        JSONObject registerAccount = new JSONObject();
        registerAccount.put("Username",username);
        registerAccount.put("Password",password);
        registeredAccountList.add(registerAccount);
        JSONUtils.setJSONList(RegisterPage.REGISTERED_ACCOUNT_PATH,registeredAccountList);

        //GET ACCOUNT
        JSONArray existedAccountList = JSONUtils.getJSONList(RegisterPage.REGISTERED_ACCOUNT_PATH);
        JSONObject account = JSONUtils.getJSONObjectByIndex(existedAccountList,5);
        String validUserName = account.get("Username").toString();
        String validPassword = account.get("Password").toString();

        //LOGIN
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Login with a valid account");
        homePage.goToLoginPage();
        loginPage.fillDataLogin(validUserName,validPassword);
        loginPage.clickBtnLogin();

        //BOOK TICKET
        Log.info("Step3: Book 6 tickets with different Depart Dates");
        for (int i=1; i<=6; i++) {
            homePage.goToBookTicketPage();
            bookTicketPage.selectWithDptDate(bookTicketPage.DEPART_DATE);
            bookTicketPage.bookTicketWithoutDptDate("Sài Gòn", "Nha Trang", "1", "Hard seat");
            bookTicketPage.clickBtnBookTicket();
        }

        Log.info("Step4:  Click on 'My ticket' tab");
        bookTicketPage.goToMyTicketPage();

        //ASSERT MESSAGE
        String expectedMsg = "You currently book 6 tickets, you can book 4 more.";
        Assert.assertEquals(myTicketPage.getLblNoCurrentTicketMsg(),expectedMsg,"Current ticket is incorrectly");


    }
}
