package com.logigear.pagesObjects;

import com.logigear.common.Utilities;
import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class MyTicketPage extends GeneralPage {
    private By titleMyTicketPage = By.xpath("//h1[contains(text(),'Manage Tickets')]");
    private By filterDptStation = By.xpath("//select[@name='FilterDpStation']");
    private By filterArStation = By.xpath("//select[@name='FilterArStation']");
    private By filterDptDate = By.xpath("//input[@name='FilterDpDate']");
    private By filterStatus = By.xpath("//select[@name='FilterStatus']");
    private By btnFilter = By.xpath("//input[@type='submit' and @value='Apply Filter']");
    private String btnCancelWithRowNumber = "//td[.='%s']/..//input[@type='button' and @value='Cancel' or @value='Delete']";
    private String rowNumberSelected= "//input[@onclick='%s']";
    private WebElement getRowNumberSelected(String id){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(rowNumberSelected,id)));
    }
    private WebElement getBtnCancelWithRow(String rowNumber) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelWithRowNumber, rowNumber)));
    }
    private WebElement getFilterDptStation() {
        return Constant.WEBDRIVER.findElement(filterDptStation);
    }

    private WebElement getFilterArStation() {
        return Constant.WEBDRIVER.findElement(filterArStation);
    }

    private WebElement getFilterDptDate() {
        return Constant.WEBDRIVER.findElement(filterDptDate);
    }

    private WebElement getFilterStatus() {
        return Constant.WEBDRIVER.findElement(filterStatus);
    }

    private WebElement getBtnFilter() {
        return Constant.WEBDRIVER.findElement(btnFilter);
    }

    public String getTitleMyTicketPage() {
        return Constant.WEBDRIVER.findElement(titleMyTicketPage).getText();
    }

    public void filterTicket(String departureStation, String arriveStation, String dptDate, String statusTicket) {
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

    public void cancelTicketByStringRow(String rowNumber) {
        Utilities.scrollToElement(getLink());
        getBtnCancelWithRow(rowNumber).click();
    }

    public boolean checkTicketDisappear(String id){
        try {
            WebElement rowSelected = getRowNumberSelected(id);
        }
        catch(Exception e){
            return true;
        }
        return false;
    }
}
