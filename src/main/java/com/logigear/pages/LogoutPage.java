package com.logigear.pages;

import com.logigear.common.constant.Constant;
import org.openqa.selenium.By;

public class LogoutPage extends GeneralPage{
    private By homepageLogoutMsg = By.xpath("//h1[contains(text(),'Welcome to Safe Railway')]");
    public String getHomepageLogoutMsg(){
        return Constant.WEBDRIVER.findElement(homepageLogoutMsg).getText();
    }


}
