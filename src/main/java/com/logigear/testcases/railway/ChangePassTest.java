package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pagesObjects.ChangePasswordPage;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePassTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC09(){
        String newPass ="123456789";
        System.out.println("User can change password");
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.goToChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD,newPass,newPass);

        String actualMsg = changePasswordPage.getLblSuccessChangPassMsg();
        String expectedMsg ="Your password has been updated!" ;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

    }
}
