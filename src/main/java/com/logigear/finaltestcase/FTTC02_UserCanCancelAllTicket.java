package com.logigear.finaltestcase;

import com.logigear.common.Constant;
import com.logigear.common.DriverManager;
import com.logigear.common.JSONUtils;
import com.logigear.common.Log;
import com.logigear.pagesObjects.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FTTC02_UserCanCancelAllTicket extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    DriverManager driverManager = new DriverManager();

    @Test
    public void FTTC02(){

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
        JSONObject account = JSONUtils.getJSONObjectByIndex(existedAccountList,1);
        String validUserName = account.get("Username").toString();
        String validPassword = account.get("Password").toString();

        //LOGIN
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Login with a valid account");
        homePage.goToLoginPage();
        loginPage.fillDataLogin(validUserName,validPassword);
        loginPage.clickBtnLogin();

        //BOOK TICKET
        Log.info("Step3: Book more than 4 tickets");
        loginPage.goToBookTicketPage();
        bookTicketPage.bookTicket(BookTicketPage.DEPART_DATE,"Sài Gòn", "Nha Trang", "5", "Hard seat");
        bookTicketPage.clickBtnBookTicket();

        Log.info("Step4: Click on 'My ticket' tab");
        bookTicketPage.goToMyTicketPage();

        //CANCEL TICKET
        Log.info("Step5: Cancel all existing tickets");
        myTicketPage.cancelTicketByStringRow("1");
        driverManager.acceptAlert();


//        //ASSERT MESSAGE
//        String expectedMsg = "Sorry, can't find any results that match your filters";
//        Assert.assertEquals(myTicketPage.getErrorMessage(),expectedMsg,"Error Message is not correct");

    }

}
