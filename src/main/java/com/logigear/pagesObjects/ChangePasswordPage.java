package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    private By titleChangePassPage = By.xpath("//h1[contains(text(),'Change password')]");
    private By txtCurrentPass = By.xpath("//input[@id='currentPassword']");
    private By txtNewPass = By.xpath("//input[@id='newPassword']");
    private By txtConfirmPass = By.xpath("//input[@id='confirmPassword']");
    private By btnChangePass = By.xpath("//input[@type='submit' and @value='Change Password']");
    private By lblSuccessChangePass = By.xpath("//p[@class='message success']");

    private String newPass;
    private String confirmPass;

    public WebElement getCurrentPass = Constant.WEBDRIVER.findElement(txtCurrentPass);
    public WebElement getNewPass = Constant.WEBDRIVER.findElement(txtNewPass);
    public WebElement getConfirmPass = Constant.WEBDRIVER.findElement(txtConfirmPass);
    public WebElement getBtnChangePass = Constant.WEBDRIVER.findElement(btnChangePass);

    public String getLblSuccessChangPassMsg(){
      return Constant.WEBDRIVER.findElement(lblSuccessChangePass).getText();
    }

    public String getTitleChangePassPage() { return Constant.WEBDRIVER.findElement(titleChangePassPage).getText(); }

    public void changePassword(){
        getCurrentPass.sendKeys(Constant.PASSWORD);
        getNewPass.sendKeys(newPass);
        getConfirmPass.sendKeys(confirmPass);
        getBtnChangePass.click();
    }
}
