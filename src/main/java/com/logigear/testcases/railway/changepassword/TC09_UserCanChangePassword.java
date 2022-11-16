package com.logigear.testcases.railway.changepassword;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.pagesObjects.ChangePasswordPage;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_UserCanChangePassword extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC09(){
        //not finished yettttttt
        String newPass ="123456789";
        System.out.println("User can change password");
        Log.info("Step1: Navigate to QA Railway Website");
        homePage.goToLoginPage();
        Log.info("Step2: Login with valid account");
        loginPage.fillDataLogin(Constant.USERNAME, Constant.PASSWORD);
        Log.info("Step3: Click on \"Change Password\" tab");
        loginPage.goToChangePasswordPage();
        Log.info("Step4: Enter valid value into all fields.");
        changePasswordPage.changePassword(Constant.PASSWORD,newPass,newPass);

        String actualMsg = changePasswordPage.getLblSuccessChangPassMsg();
        String expectedMsg ="Your password has been updated!" ;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

    }
}
