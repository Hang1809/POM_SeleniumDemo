package com.logigear.testcases.railway.register;

import com.logigear.common.Constant;
import com.logigear.common.JSONUtils;
import com.logigear.common.Log;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.RegisterPage;
import com.logigear.testcases.railway.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_UserCanCreateNewAccount extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07(){
        JSONArray registeredAccountList = JSONUtils.getJSONList(RegisterPage.REGISTERED_ACCOUNT_PATH);
        String username = RegisterPage.REGISTER_USERNAME;
        String password = Constant.PASSWORD;
        Log.info("User can create new account ");
        Log.info("Step1. Navigate to QA Railway Website");
        Log.info("Step2. Click on 'Register' tab");
        homePage.goToRegisterPage();
        Log.info("Step3. Enter valid information into all fields");
        registerPage.register(username, password, Constant.PASSWORD, Constant.PID);
        //WRITE NEW REGISTERED_ACCOUNT INTO JSON FILE
        JSONObject registerAccount = new JSONObject();
        registerAccount.put("Username",username);
        registerAccount.put("Password",password);
        registeredAccountList.add(registerAccount);
        JSONUtils.setJSONList(RegisterPage.REGISTERED_ACCOUNT_PATH,registeredAccountList);

        Assert.assertEquals(registerPage.getSuccessRegisterMsgTxt(), "You're here", "Success message is not displayed as expected");

    }
}
