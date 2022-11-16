package com.logigear.testcases.railway.login;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.dataObjects.invalidPass.InvalidPassService;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_LoginWithBlankUsernameTxt extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


    @Test
    public void TC02(){
        Log.info("TC02 - User can't login with blank 'Username' textbox");
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Click on 'Login' tab");
        homePage.goToLoginPage();
        Log.info("Step3: User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox ");
        loginPage.fillDataLogin("", Constant.PASSWORD);

        String actualMsg = loginPage.getLblLoginErrorMsgTxt();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }
}
