package com.logigear.pagesObjects;

import com.logigear.common.Log;
import com.logigear.common.Utilities;
import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterPage extends GeneralPage {

    //Locators
    private final By txtUsername = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPass = By.xpath("//input[@id='confirmPassword']");
    private final By txtPID = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@type='submit' and @value='Register']");
    private final By successRegisterMsg = By.xpath("//div[@id='content']/p[contains(text(),'here')]");
    private final By lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By blInvalidErrorMsg = By.xpath("//label[@class='validation-error']");

    //Elements
    private WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getTxtConfirmPass() {
        return Constant.WEBDRIVER.findElement(txtConfirmPass);
    }

    private WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    private WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    private WebElement getLblRegisterErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblRegisterErrorMsg);
    }

    private WebElement getLblInvalidErrorMsg() {
        return Constant.WEBDRIVER.findElement(blInvalidErrorMsg);
    }

    private WebElement getSuccessRegisterMsg() {
        return Constant.WEBDRIVER.findElement(successRegisterMsg);
    }

    public void register(String username, String password, String confirmPassword, String pID) {
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPass().sendKeys(confirmPassword);
        getTxtPID().sendKeys(pID);
        Utilities.scrollToElementInFireFox();
        //Utilities.scrollToElement(getLink());
        Log.info("Click on 'Register' button");
        getBtnRegister().click();

    }

    public String getSuccessRegisterMsgTxt() {
        return this.getSuccessRegisterMsg().getText();
    }

    public String getLblRegisterErrorMsgTxt() {
        return this.getLblRegisterErrorMsg().getText();
    }

    public String getLblInvalidErrorMsgTxt() {
        return this.getLblInvalidErrorMsg().getText();
    }
}
