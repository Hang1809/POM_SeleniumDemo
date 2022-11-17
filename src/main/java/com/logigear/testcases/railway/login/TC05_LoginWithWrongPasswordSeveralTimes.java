package com.logigear.testcases.railway.login;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.dataObjects.invalidPass.InvalidPassService;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_LoginWithWrongPasswordSeveralTimes extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    InvalidPassService invalidPassService = new InvalidPassService();

    @Test
    public void TC05(){
        Log.info("System shows message when user enters wrong password several times");
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Click on 'Login' tab");
        homePage.goToLoginPage();
        Log.info("Step3: Enter valid information into 'Username' textbox except 'Password' textbox.");

        String actualMsg ="";
        String expectedMsg = "Invalid username or password. Please try again.";
        for (int i =0; i<=3; i++){
            loginPage.fillDataLogin(Constant.USERNAME,String.valueOf(invalidPassService.getInvalidPassById(i)));
            actualMsg= loginPage.getLblLoginErrorMsgTxt();
            Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
        }
    }
}
