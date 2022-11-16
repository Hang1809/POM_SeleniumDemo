package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import com.logigear.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
    private String linkBookTicketWithRow = "//tr[td[count(//table//tr/th[.='No']/preceding-sibling::th)+1][.='%s']]/td[count(//th[text()='Book ticket']/preceding::th)+1]";
    ////td[text()='Huế']/following-sibling::td[text()='Sài Gòn']/..//a[text()='book ticket']
    public WebElement getLinkBookTicketWithRow(String rowNumber){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkBookTicketWithRow,rowNumber)));
    }
    public void clickLinkTicketWithRow(String rowNumber){
        Utilities.scrollToElement(getLink());
        getLinkBookTicketWithRow(rowNumber).click();
    }
}
