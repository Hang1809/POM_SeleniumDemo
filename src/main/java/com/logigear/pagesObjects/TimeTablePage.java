package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import com.logigear.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
    private String linkBookTicketByString ="//td[text()='%s']/following-sibling::td[text()='%s']/..//a[text()='book ticket']";
    private WebElement getLinkBookTicketByString(String dptStation, String arrStation){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkBookTicketByString,dptStation,arrStation)));
    }
    public void clickLinkBookTicketByString(String dptStation, String arrStation){
        Utilities.scrollToElement(getLink());
        getLinkBookTicketByString(dptStation,arrStation).click();
    }

}
