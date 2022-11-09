package com.logigear.pages;

import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends GeneralPage {

    //Locators
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@type='submit' and @value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //Elements
    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    public WebElement getBtnLogin(){

        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginErrorMsg(){
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    public void login (String username, String password){
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    @Override
    public String getWelcomeMessage() {
        return super.getWelcomeMessage();
    }
    public String getLblLoginErrorMsgTxt(){
        return this.getLblLoginErrorMsg().getText();
    }
}
