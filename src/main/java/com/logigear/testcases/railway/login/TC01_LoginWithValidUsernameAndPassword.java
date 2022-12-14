package com.logigear.testcases.railway.login;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.common.PropertiesFile;
import com.logigear.common.Utilities;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_LoginWithValidUsernameAndPassword extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        Log.info("TC01- User can log into Railway with valid username and password");
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Click on 'Login' tab");
        homePage.goToLoginPage();
        Log.info("Step3: Enter valid Email and Password ");
        loginPage.fillDataLogin(Constant.USERNAME, PropertiesFile.getPropValue("password"));
        Log.info("Step4: Click on 'Login' button");
        loginPage.clickBtnLogin();

        Assert.assertEquals(loginPage.getWelcomeMessage(), "Welcome " + Constant.USERNAME, "Welcome message is not displayed as expected");
    }
}
