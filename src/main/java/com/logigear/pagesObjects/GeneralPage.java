package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");

    private final By tabTimeTable = By.xpath("//div[@id=\"menu\"]//a[@href='TrainTimeListPage.cshtml']");
    private final By link = By.xpath("//center/a[contains(text(),'Somee.com')]");


    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getTabTimeTable(){
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }
    protected WebElement getLink() {
        return Constant.WEBDRIVER.findElement(link);
    }

    //Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void goToLoginPage() {
        this.getTabLogin().click();
    }

    public void goToRegisterPage() {
        this.getTabRegister().click();
    }

    public void goToBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void logoutPage() {
        this.getTabLogout().click();
    }

    public void goToMyTicketPage() {
        this.getTabMyTicket().click();
    }
    public void goToChangePasswordPage(){
        this.getTabChangePassword().click();
    }
    public void goToTimeTablePage(){this.getTabTimeTable().click();}
}
