package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.common.PropertiesFile;
import com.logigear.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    private final By titleChangePasswordPage = By.xpath("//h1[contains(text(),'Change password')]");
    private final By txtCurrentPass = By.id("currentPassword");
    private final By txtNewPass = By.id("newPassword");
    private final By txtConfirmPass = By.id("confirmPassword");
    private final By btnChangePass = By.xpath("//input[@type='submit' and @value='Change Password']");
    private final By lblSuccessChangePass = By.xpath("//p[@class='message success']");

    private WebElement getCurrentPass() {
        return Constant.WEBDRIVER.findElement(txtCurrentPass);
    }

    private WebElement getNewPass() {
        return Constant.WEBDRIVER.findElement(txtNewPass);
    }

    private WebElement getConfirmPass() {
        return Constant.WEBDRIVER.findElement(txtConfirmPass);
    }

    private WebElement getBtnChangePass() {
        return Constant.WEBDRIVER.findElement(btnChangePass);
    }

    public String getLblSuccessChangPassMsg() {
        return Constant.WEBDRIVER.findElement(lblSuccessChangePass).getText();
    }

    public String getTitleChangePasswordPage() {
        return Constant.WEBDRIVER.findElement(titleChangePasswordPage).getText();
    }

    public void changePassword(String currentPass, String newPass, String confirmPass) {
        PropertiesFile.setPropertiesFile();
        getCurrentPass().sendKeys(currentPass);
        getNewPass().sendKeys(newPass);
        getConfirmPass().sendKeys(confirmPass);
        Utilities.scrollToElementInFireFox();
        Log.info("Step5: Click on 'Change Password' button");
        getBtnChangePass().click();
    }
}
