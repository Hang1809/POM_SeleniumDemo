package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    private final By txtCurrentPass = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPass = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPass = By.xpath("//input[@id='confirmPassword']");
    private final By btnChangePass = By.xpath("//input[@type='submit' and @value='Change Password']");
    private final By lblSuccessChangePass = By.xpath("//p[@class='message success']");
}
