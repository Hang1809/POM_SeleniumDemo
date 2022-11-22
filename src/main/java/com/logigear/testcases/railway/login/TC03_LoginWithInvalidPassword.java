package com.logigear.testcases.railway.login;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.dataObjects.invalidPass.InvalidPassService;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_LoginWithInvalidPassword extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    InvalidPassService invalidPassService = new InvalidPassService();

    @Test
    public void TC03(){
        Log.info("TC03 - User cannot log into Railway with invalid password ");
        Log.info("Step1: Navigate to QA Railway Website");
        Log.info("Step2: Click on 'Login' tab");
        homePage.goToLoginPage();
        Log.info("Step3: Enter valid Email and invalid Password ");

        loginPage.fillUsername(Constant.USERNAME);
        for (int i =1; i<=4; i++){
            loginPage.fillInvalidPassword(invalidPassService.getInvalidPassById(i).getInvalidPass());
            System.out.println(invalidPassService.getInvalidPassById(i).getInvalidPass());
            loginPage.clickBtnLogin();
            String actualMsg = loginPage.getLblLoginErrorMsgTxt();
            Assert.assertEquals(actualMsg, "Invalid username or password. Please try again.", "Error message is not displayed correctly");
        };
    }
}
