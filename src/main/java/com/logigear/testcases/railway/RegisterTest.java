package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07() {
        System.out.println("User can create new account ");

        homePage.goToRegisterPage();
        registerPage.register(Constant.REGISTER_USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        String actualMsg = registerPage.getSuccessRegisterMsgTxt();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not displayed as expected");
    }

    @Test
    public void TC10(){
        System.out.println("User can't create account with 'Confirm password' is not the same with 'Password' ");

        homePage.goToRegisterPage();
        registerPage.register(Constant.REGISTER_USERNAME,Constant.PASSWORD,"abc",Constant.PID);

        String actualMsg = registerPage.getLblInvalidErrorMsgTxt();
        String expectedMsg = "The two passwords do not match";

        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }

    @Test
    public void TC11(){
        System.out.println("User can't create account while password and PID fields are empty");

        homePage.goToRegisterPage();
        registerPage.register(Constant.REGISTER_USERNAME, "","","");

        String actualMsg = registerPage.getLblRegisterErrorMsgTxt();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }

}
