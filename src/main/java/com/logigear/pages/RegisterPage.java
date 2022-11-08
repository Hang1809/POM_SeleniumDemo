package com.logigear.pages;

import com.logigear.common.common.Utilities;
import com.logigear.common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locators
    private final By _txtUsername = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPass = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPID = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//input[@type='submit' and @value='Register']");
    private final By _successRegisterMsg = By.xpath("//div[@id='content']/p[contains(text(),'here')]");
    private final By _lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By _blInvalidErrorMsg = By.xpath("//label[@class='validation-error']");



    //Elements
    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPass(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPass);
    }
    public WebElement getTxtPID(){
        return Constant.WEBDRIVER.findElement(_txtPID);
    }
    public WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    public WebElement getLblRegisterErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg);
    }
    public WebElement getLblInvalidErrorMsg(){return Constant.WEBDRIVER.findElement(_blInvalidErrorMsg);}
    public WebElement getSuccessRegisterMsg(){
        return Constant.WEBDRIVER.findElement(_successRegisterMsg);
    }


    public void register (String username, String password, String confirmPassword, String pID){
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPass().sendKeys(confirmPassword);
        getTxtPID().sendKeys(pID);
        Utilities.scrollToElement(getLink());
        getBtnRegister().click();

    }

    public String getSuccessRegisterMsgTxt(){
         return this.getSuccessRegisterMsg().getText();
       // return  Constant.WEBDRIVER.findElement(_successRegisterMsg).getText();
    }

    public String getLblRegisterErrorMsgTxt(){

        return this.getLblRegisterErrorMsg().getText();
    }
    public String getLblInvalidErrorMsgTxt(){
        return this.getLblInvalidErrorMsg().getText();
    }

}
