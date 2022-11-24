package com.logigear.testcases.railway.register;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.RegisterPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11_RegisterWithBlankPasswordAndBlankPID extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC11() {
        Log.info("User can't create account while password and PID fields are empty");
        Log.info("Step1. Navigate to QA Railway Website");
        Log.info("Step2. Click on 'Register' tab");
        homePage.goToRegisterPage();
        Log.info("Step3. Enter valid email address and leave other fields empty");
        registerPage.register(RegisterPage.REGISTER_USERNAME, "", "", "");

        String actualMsg = registerPage.getLblRegisterErrorMsgTxt();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
