package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pages.HomePage;
import com.logigear.pages.LoginPage;
import com.logigear.pages.LogoutPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Test
    public void TC13(){
        System.out.println("User can logout successfully");
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        logoutPage.logoutPage();

        String actualMsg = logoutPage.getHomepageLogoutMsg();
        String expectedMsg = "Welcome to Safe Railway";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

}
