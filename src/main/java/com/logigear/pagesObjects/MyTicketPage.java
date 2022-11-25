package com.logigear.pagesObjects;

import com.logigear.common.Utilities;
import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    private String btnCancelWithRowNumber = "//td[.='%s']/..//input[@type='button' and @value='Cancel' or @value='Delete']";
    private By lblNoCurrentTicketMessage = By.xpath("//div[contains(@class,'message')]/li[contains(text(),'You currently book 6 tickets')]");
    private By lblErrorMessage = By.xpath("//div[contains(@class,'error message')]");
    private WebElement getBtnCancelWithRow(String rowNumber) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancelWithRowNumber, rowNumber)));
    }

    public String getLblNoCurrentTicketMsg() {
        return Constant.WEBDRIVER.findElement(lblNoCurrentTicketMessage).getText();
    }

    public String getErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblErrorMessage).getText();
    }

    public void cancelTicketByStringRow(String rowNumber) {
        Utilities.scrollToElement(getLink());
        getBtnCancelWithRow(rowNumber).click();
    }


}