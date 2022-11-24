package com.logigear.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirmPassword");
    private By PIDNoInput = By.id("pid");
    private By registerBtn = By.xpath("//input[@type='submit' and @value='Register']");
    private By errorRegisterMsgText = By.className("message error");


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
    public void register(String email, String password,String confirmPassword, String pid) throws Exception{
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterPID(pid);
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
