package com.logigear.testcases.railway;
import com.logigear.common.Constant;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.LogoutPage;
import org.testng.Assert;
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
