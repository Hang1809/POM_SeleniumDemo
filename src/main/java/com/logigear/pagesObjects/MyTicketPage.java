package com.logigear.pagesObjects;

import com.logigear.common.Utilities;
import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends GeneralPage {
    private By titleMyTicketPage = By.xpath("//h1[contains(text(),'Manage Tickets')]");
    private By filterDptStation = By.xpath("//select[@name='FilterDpStation']");
    private By filterArStation = By.xpath("//select[@name='FilterArStation']");
    private By filterDptDate = By.xpath("//input[@name='FilterDpDate']");
    private By filterStatus = By.xpath("//select[@name='FilterStatus']");
    private By btnFilter = By.xpath("//input[@type='submit' and @value='Apply Filter']");
    private By successFilterMsg = By.xpath("//");

    public WebElement getFilterDptStation(){
        return Constant.WEBDRIVER.findElement(filterDptStation);
    }
    public WebElement getFilterArStation(){
        return Constant.WEBDRIVER.findElement(filterArStation);
    }
    public WebElement getFilterDptDate(){
        return Constant.WEBDRIVER.findElement(filterDptDate);
    }
    public WebElement getFilterStatus(){
        return Constant.WEBDRIVER.findElement(filterStatus);
    }
    public WebElement getBtnFilter(){
        return Constant.WEBDRIVER.findElement(btnFilter);
    }
    public String getTitleMyTicketPage(){return Constant.WEBDRIVER.findElement(titleMyTicketPage).getText();}
    public String getSuccessFilterMsg(){
        return Constant.WEBDRIVER.findElement(successFilterMsg).getText();
    }

    public void filterTicket(){
        Utilities.scrollToElement(getLink());
        Select dptStation = new Select(getFilterDptStation());
        Select arStation = new Select(getFilterArStation());
        Select status = new Select(getFilterStatus());
        dptStation.selectByValue("2");
        arStation.selectByValue("3");
        getFilterDptDate().sendKeys("");
        status.selectByValue("1");
        getBtnFilter().click();

    }
}
