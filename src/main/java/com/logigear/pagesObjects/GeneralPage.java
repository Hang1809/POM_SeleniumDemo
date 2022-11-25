package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabTimeTable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private static final By link = By.xpath("//center/a[contains(text(),'Somee.com')]");

}
