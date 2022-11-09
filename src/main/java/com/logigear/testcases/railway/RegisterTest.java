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
    public void TC06() {
        System.out.println("User can register account successfully with valid data ");
        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.REGISTER_USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        String actualMsg = registerPage.getSuccessRegisterMsgTxt();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not displayed as expected");
    }

    @Test
    public void TC07() {
        System.out.println("User can't register account with existing email address");
        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        String actualMsg = registerPage.getLblRegisterErrorMsgTxt();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC08() {
        System.out.println("User can't register account  if email length isn't from 6 to 32 characters");
        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.INVALID_USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        String actualMsg = registerPage.getLblInvalidErrorMsgTxt();
        String expectedMsg = "Invalid email length";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

    }

    @Test
    public void TC09() {
        System.out.println(" User is unable to register account if confirm password mismatch with the password");
        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.USERNAME, Constant.PASSWORD, "1234", Constant.PID);

        String actualMsg = registerPage.getLblInvalidErrorMsgTxt();
        String expectedMsg = "The two passwords do not match";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

    }

    @Test
    public void TC10() {
        System.out.println("User can't register account with blank password");
        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.USERNAME, "", Constant.PASSWORD, Constant.PID);

        String actualMsg = registerPage.getLblInvalidErrorMsgTxt();
        String expectedMsg = "Invalid password length";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

    }

}
