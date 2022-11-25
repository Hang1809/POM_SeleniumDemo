package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterPage {
    private By dblFilterDptStation = By.xpath("//select[@name='FilterDpStation']");
    private By dblFilterArStation = By.xpath("//select[@name='FilterArStation']");
    private By dblFilterDptDate = By.xpath("//input[@name='FilterDpDate']");
    private By dblFilterStatus = By.xpath("//select[@name='FilterStatus']");
    private By btnFilter = By.xpath("//input[@type='submit' and @value='Apply Filter']");

    private String numberRowInFilter = "//table[@class ='MyTable']//tr[not (contains(@class, 'TableSmallHeader'))]";

    private String filterRowByValues = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..";


    private WebElement getFilterDptStation() {
        return Constant.WEBDRIVER.findElement(dblFilterDptStation);
    }

    private WebElement getDblFilterArStation() {
        return Constant.WEBDRIVER.findElement(dblFilterArStation);
    }

    private WebElement getDblFilterDptDate() {
        return Constant.WEBDRIVER.findElement(dblFilterDptDate);
    }

    private WebElement getDblFilterStatus() {
        return Constant.WEBDRIVER.findElement(dblFilterStatus);
    }

    private WebElement getBtnFilter() {
        return Constant.WEBDRIVER.findElement(btnFilter);
    }
}
