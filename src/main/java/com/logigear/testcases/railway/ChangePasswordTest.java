package com.logigear.testcases.railway;

import com.logigear.common.Constant;
import com.logigear.pagesObjects.ChangePasswordPage;
import com.logigear.pagesObjects.LoginPage;
import org.testng.annotations.Test;

public class ChangePasswordTest {

    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC09(){
        System.out.println("User can change password");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.goToChangePasswordPage();


    }
}
