package com.logigear.testcases.railway.login;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.common.PropertiesFile;
import com.logigear.dataObjects.invalidPass.InvalidPassService;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.MyTicketPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;

public class TC06_AdditionalPagesDisplay extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC06(){
        Log.info("Additional pages display once user logged in");
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Click on 'Login' tab");
        homePage.goToLoginPage();
        Log.info("Step3: Login with valid account");
        loginPage.fillDataLogin(Constant.USERNAME, PropertiesFile.getPropValue("password"));
        Log.info("Click 'Change password' tab, user will be directed to Change password page");
        loginPage.goToChangePasswordPage();
        Log.info("Click 'My ticket' tab, user will be directed to My ticket page");
        loginPage.goToMyTicketPage();

        String actualMsg=myTicketPage.getTitleMyTicketPage();
        String expectedMsg ="Manage Tickets";

        Assert.assertEquals(actualMsg,expectedMsg,"Success message is not displayed correctly");
    }
}
