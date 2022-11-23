package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import com.logigear.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class LoginPage extends GeneralPage {

    //Locators
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@type='submit' and @value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By titleLoginPage = By.xpath("//h1[contains(text(),'Login Page')]");


    //Elements
    private WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {return Constant.WEBDRIVER.findElement(btnLogin);}

    private WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    public void fillDataLogin(String username, String password) {
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        Utilities.scrollToElementInFireFox();
    }
    public void fillUsername(String username){
        getTxtUsername().sendKeys(username);
    }
    public void fillInvalidPassword(String password){
        getTxtPassword().sendKeys(password);
    }
    public void clickBtnLogin(){
        getBtnLogin().click();
    }

    @Override
    public String getWelcomeMessage() {
        return super.getWelcomeMessage();
    }
    public String getLblLoginErrorMsgTxt() {
        return this.getLblLoginErrorMsg().getText();
    }
    public String getTitleLoginPage(){ return Constant.WEBDRIVER.findElement(titleLoginPage).getText();}

}
