package com.logigear.testcases.railway.register;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.RegisterPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_UserCanCreateNewAccount extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07() {
        Log.info("User can create new account ");
        Log.info("Step1. Navigate to QA Railway Website");
        Log.info("Step2. Click on 'Register' tab");
        homePage.goToRegisterPage();
        Log.info("Step3. Enter valid information into all fields");
        registerPage.register(Constant.REGISTER_USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        String actualMsg = registerPage.getSuccessRegisterMsgTxt();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not displayed as expected");
    }
}
