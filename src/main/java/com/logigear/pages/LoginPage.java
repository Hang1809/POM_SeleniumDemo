package com.logigear.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By emailInput = By.id("EmailInputEmail");
    private By passwordInput= By.id("PasswordInputPassword");
    private By logninBtn = By.id("LogInButton");
    private By errorMsgText = By.id("logInError");

    public LoginPage(WebDriver driver){
        this.driver= driver;
    }
    public String getLoginPageTitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;
    }
    public boolean verifyLogInPageTitle(){
        String expectedTitle = "Login Page";
        return getLoginPageTitle().equals(expectedTitle);
    }
    public void login(String username, String password) throws Exception{
        enterEmail(username);
        enterPassword(password);
        clickLogIn();
    }
    public boolean verifyLogIn(){
        enterEmail("abc");
        enterPassword("123456789");
        clickLogIn();
        return getErrorMessage().contains("incorrect");
    }
    public void enterEmail(String email){
        WebElement emailTextBox = driver.findElement(emailInput);
        if(emailTextBox.isDisplayed())
            emailTextBox.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordTextBox = driver.findElement(passwordInput);
        if(passwordTextBox.isDisplayed())
            passwordTextBox.sendKeys(password);
    }
    public void clickLogIn(){
        WebElement login = driver.findElement(logninBtn);
        if(login.isDisplayed()){
            login.click();
        }
    }
    public String getErrorMessage(){
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(errorMsgText);
        if(errorMsg.isDisplayed() && errorMsg.isEnabled())
            strErrorMsg =errorMsg.getText();
        return strErrorMsg;
    }

}
