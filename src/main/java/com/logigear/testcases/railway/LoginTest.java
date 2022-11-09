package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pages.HomePage;
import com.logigear.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        System.out.println("TC01- User can login with valid username and password");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02- User can't login with invalid username");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.INVALID_USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getLblLoginErrorMsgTxt();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User can't login with invalid password");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, "ABCD123");

        String actualMsg = loginPage.getLblLoginErrorMsgTxt();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }

    @Test
    public void TC04() {
        System.out.println("TC03 - User can't login with blank email");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getLblLoginErrorMsgTxt();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }

    @Test
    public void TC05() {
        System.out.println("TC03 - User can't login with blank password");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, "");

        String actualMsg = loginPage.getLblLoginErrorMsgTxt();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }
}
