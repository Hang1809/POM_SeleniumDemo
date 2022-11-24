package com.logigear.testcases.railway.login;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.common.PropertiesFile;
import com.logigear.dataObjects.invalidPass.InvalidPassService;
import com.logigear.pagesObjects.ChangePasswordPage;
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
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC06() {
        Log.info("Additional pages display once user logged in");
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Click on 'Login' tab");
        homePage.goToLoginPage();
        Log.info("Step3: Login with valid account");
        loginPage.fillDataLogin(Constant.USERNAME, PropertiesFile.getPropValue("password"));
        Log.info("Step4: Click on 'Login' button");
        loginPage.clickBtnLogin();
        Assert.assertEquals(homePage.getTabLogout(), "Log out", "Logout Page is not displayed correctly");
        Log.info("Click 'Change password' tab, user will be directed to Change password page");
        homePage.goToChangePasswordPage();
        Assert.assertEquals(changePasswordPage.getTitleChangePasswordPage(), "Change password", "Change Password Page is not displayed correctly");
        Log.info("Click 'My ticket' tab, user will be directed to My ticket page");
        homePage.goToMyTicketPage();
        Assert.assertEquals(myTicketPage.getTitleMyTicketPage(), "Manage Tickets", "My Ticket Page is not displayed correctly");

    }
}
