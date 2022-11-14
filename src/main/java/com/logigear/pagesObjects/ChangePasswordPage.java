package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    private final By titleChangePassPage = By.xpath("//h1[contains(text(),'Change password')]");
    private final By txtCurrentPass = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPass = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPass = By.xpath("//input[@id='confirmPassword']");
    private final By btnChangePass = By.xpath("//input[@type='submit' and @value='Change Password']");
    private final By lblSuccessChangePass = By.xpath("//p[@class='message success']");
    public WebElement getCurrentPass(){
        return Constant.WEBDRIVER.findElement(txtCurrentPass);
    }
    public WebElement getNewPass(){
        return Constant.WEBDRIVER.findElement(txtNewPass);
    }
    public WebElement getConfirmPass(){
        return Constant.WEBDRIVER.findElement(txtConfirmPass);
    }
    public WebElement getBtnChangePass(){
        return Constant.WEBDRIVER.findElement(btnChangePass);
    }
    public String getLblSuccessChangPassMsg(){
      return Constant.WEBDRIVER.findElement(lblSuccessChangePass).getText();
    }
    public String getTitleChangePassPage() { return Constant.WEBDRIVER.findElement(titleChangePassPage).getText(); }

    public void changePassword(String currentPass,String newPass, String confirmPass){
        getCurrentPass().sendKeys(currentPass);
        getNewPass().sendKeys(newPass);
        getConfirmPass().sendKeys(confirmPass);
        getBtnChangePass().click();
    }
}
