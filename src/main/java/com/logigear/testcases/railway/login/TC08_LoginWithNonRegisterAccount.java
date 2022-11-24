package com.logigear.testcases.railway.login;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.RegisterPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08_LoginWithNonRegisterAccount extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC08() {
        Log.info("TC08_ User can't login with an account hasn't been registered");
        Log.info("Step1. Navigate to QA Railway Website");
        Log.info("Step2. Click on 'Login' tab");
        homePage.goToLoginPage();
        Log.info("Step3. Enter username and password of account hasn't been registered.");
        loginPage.fillDataLogin(RegisterPage.NON_REGISTER_USERNAME, Constant.PASSWORD);
        Log.info("Step4. Click on 'Login' button");
        loginPage.clickBtnLogin();

        String actualMsg = loginPage.getLblLoginErrorMsgTxt();
        Assert.assertEquals(actualMsg, "Invalid username or password. Please try again.", "Error message is not displayed correctly");
    }
}
