package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.dataObjects.invalidPass.InvalidPassService;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    InvalidPassService invalidPassService = new InvalidPassService();

    @Test
    public void TC01() {
        System.out.println("TC01- User can log into Railway with valid username and password");

        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank 'Username' textbox");

        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getLblLoginErrorMsgTxt();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password ");

        homePage.gotoLoginPage();
        String actualMsg = "";
        String expectedMsg = "Invalid username or password. Please try again.";
        for(int i =0; i<=4; i++) {
            loginPage.login(Constant.USERNAME, String.valueOf(invalidPassService.getInvalidPassById(i)));
            actualMsg= loginPage.getLblLoginErrorMsgTxt();
            Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
        };
    }

    @Test
    public void TC05(){
        System.out.println("System shows message when user enters wrong password several times");

        homePage.gotoLoginPage();
        String actualMsg ="";
        String expectedMsg = "Invalid username or password. Please try again.";
        for (int i =0; i<=3; i++){
            loginPage.login(Constant.USERNAME,String.valueOf(invalidPassService.getInvalidPassById(i)));
            actualMsg= loginPage.getLblLoginErrorMsgTxt();
            Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
        }
    }

    @Test
    public void TC06(){
        System.out.println("Additional pages display once user logged in");

        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoChangePasswordPage();
        loginPage.gotoMyTicketPage();

    }
}
