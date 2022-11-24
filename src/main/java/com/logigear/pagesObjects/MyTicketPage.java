package com.logigear.pagesObjects;

import com.logigear.common.Utilities;
import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    private By titleMyTicketPage = By.xpath("//h1[contains(text(),'Manage Tickets')]");
    private By dblFilterDptStation = By.xpath("//select[@name='FilterDpStation']");
    private By dblFilterArStation = By.xpath("//select[@name='FilterArStation']");
    private By dblFilterDptDate = By.xpath("//input[@name='FilterDpDate']");
    private By dblFilterStatus = By.xpath("//select[@name='FilterStatus']");
    private By btnFilter = By.xpath("//input[@type='submit' and @value='Apply Filter']");
    private String btnCancelWithRowNumber = "//td[.='%s']/..//input[@type='button' and @value='Cancel' or @value='Delete']";
    private String btnCancelSelectedById = "//input[@onclick='%s']";

    private WebElement getBtnCancelById(String id) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelSelectedById, id)));
    }

    private WebElement getBtnCancelWithRow(String rowNumber) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelWithRowNumber, rowNumber)));
    }

    public String getIdOfBtnCancel(String no){
        return getBtnCancelWithRow(no).getAttribute("onclick") ;
    }
    public String getTitleMyTicketPage() {
        return Constant.WEBDRIVER.findElement(titleMyTicketPage).getText();
    }

    public void cancelTicketByStringRow(String rowNumber) {
        Utilities.scrollToElementInFireFox();
        getBtnCancelWithRow(rowNumber).click();
    }

    public boolean checkTicketDisappear(String id) {
        try {
            WebElement btnCancel = getBtnCancelById(id);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
