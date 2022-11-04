package com.logigear.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;
    private By emailInput = By.id("EmailInputEmail");
    private By passwordInput = By.id("PasswordInputPassword");
    private By confirmPasswordInput = By.id("ConfirmPassword");
    private By PIDNoInput = By.id("PIDNumber");
    private By registerBtn = By.id("RegisterButton");
    private By errorRegisterMsgText = By.id("RegisterError");

    public RegisterPage(WebDriver driver){
        this.driver= driver;
    }
    public String getRegisterPageTitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;
    }
    public boolean verifyRegisterPageTitle(){
        String expectedTitle = "Create account";
        return getRegisterPageTitle().equals(expectedTitle);
    }
    public void register(String username, String password,String confirmPassword, String PIDNumber) throws Exception{
        enterEmail(username);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterPID(PIDNumber);
        clickRegister();
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

    public void enterConfirmPassword(String confirmPassword){
        WebElement confirmpasswordTextBox = driver.findElement(confirmPasswordInput);
        if(confirmpasswordTextBox.isDisplayed())
            confirmpasswordTextBox.sendKeys(confirmPassword);
    }
    public void enterPID(String PIDNumber ){
        WebElement pIDTextBox = driver.findElement(PIDNoInput);
        if(pIDTextBox.isDisplayed())
            pIDTextBox.sendKeys(PIDNumber);
    }

    public void clickRegister(){
        WebElement register = driver.findElement(registerBtn);
        if(register.isDisplayed()){
            register.click();
        }
    }
    public String getErrorMessage(){
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(errorRegisterMsgText);
        if(errorMsg.isDisplayed() && errorMsg.isEnabled())
            strErrorMsg =errorMsg.getText();
        return strErrorMsg;
    }

}
