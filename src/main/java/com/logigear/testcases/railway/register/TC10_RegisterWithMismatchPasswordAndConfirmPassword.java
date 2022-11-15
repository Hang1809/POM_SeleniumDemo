package com.logigear.testcases.railway.register;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.RegisterPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_RegisterWithMismatchPasswordAndConfirmPassword extends BaseTest {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC10(){
        Log.info("User can't create account with 'Confirm password' is not the same with 'Password' ");
        Log.info("Step1. Navigate to QA Railway Website");
        Log.info("Step2. Click on 'Register' tab");
        homePage.goToRegisterPage();
        Log.info("Step3. Enter valid information into all fields except 'Confirm password' is not the same with 'Password'");
        registerPage.register(Constant.REGISTER_USERNAME,Constant.PASSWORD,"abc",Constant.PID);

        String actualMsg = registerPage.getLblInvalidErrorMsgTxt();
        String expectedMsg = "The two passwords do not match";

        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }

}
