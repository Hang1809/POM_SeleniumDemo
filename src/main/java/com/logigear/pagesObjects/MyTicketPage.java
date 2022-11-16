package com.logigear.pagesObjects;

import com.logigear.common.Utilities;
import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class MyTicketPage extends GeneralPage {
    private By titleMyTicketPage = By.xpath("//h1[contains(text(),'Manage Tickets')]");
    private By filterDptStation = By.xpath("//select[@name='FilterDpStation']");
    private By filterArStation = By.xpath("//select[@name='FilterArStation']");
    private By filterDptDate = By.xpath("//input[@name='FilterDpDate']");
    private By filterStatus = By.xpath("//select[@name='FilterStatus']");
    private By btnFilter = By.xpath("//input[@type='submit' and @value='Apply Filter']");
    private String btnCancelWithRowNumber = "//td[.='%s']/..//input[@type='button' and @value='Cancel' or @value='Delete']";

    public WebElement getBtnCancelWithRow(String rowNumber){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelWithRowNumber,rowNumber)));
    }
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

    public void filterTicket(String departureStation,String arriveStation,String dptDate, String statusTicket){
        Utilities.scrollToElement(getLink());
        Select dptStation = new Select(getFilterDptStation());
        Select arStation = new Select(getFilterArStation());
        Select status = new Select(getFilterStatus());
        dptStation.selectByValue(departureStation);
        arStation.selectByValue(arriveStation);
        getFilterDptDate().sendKeys(dptDate);
        status.selectByValue(statusTicket);
        getBtnFilter().click();
    }
    public void cancelTicketByStringRow(String rowNumber){
        Utilities.scrollToElementInFireFox();
        //Utilities.scrollToElement(getLink());
        getBtnCancelWithRow(rowNumber).click();
    }
    public void acceptAlert(){
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

}
