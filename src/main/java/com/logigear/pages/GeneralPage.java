package com.logigear.pages;

import com.logigear.common.constant.Constant;
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

    private final By _link = By.xpath("//center/a[contains(text(),'Somee.com')]");


    //Elements
    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabRegister(){return Constant.WEBDRIVER.findElement(tabRegister);}
    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getTabBookTicket(){return Constant.WEBDRIVER.findElement(tabBookTicket);}
    protected WebElement getTabMyTicket(){return Constant.WEBDRIVER.findElement(tabMyTicket);}
    protected WebElement getLink(){
        return Constant.WEBDRIVER.findElement(_link);
    }

    //Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }
    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public BookTicketPage gotoBookTicketPage(){
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }
    public LogoutPage logoutPage(){
        this.getTabLogout().click();
        return new LogoutPage();
    }
    public MyTicketPage gotoMyTicketPage(){
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }
}
