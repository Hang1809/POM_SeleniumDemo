package com.logigear.pagesObjects;

import com.logigear.common.Constant;
import com.logigear.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    public static final String DEPART_DATE = String.valueOf((int)(Math.random()*27+4));
    private By ddlDate = By.xpath("//select[@name='Date']");
    private By ddlDepartStation = By.xpath("//select[@name='DepartStation']");
    private By ddlArriveStation = By.xpath("//select[@name='ArriveStation']");
    private By ddlSeatType = By.xpath("//select[@name='SeatType']");
    private By ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private By btnBookTicket = By.xpath("//input[@type='submit' and @value='Book ticket']");
    private By dblDate = By.xpath("//table//td[count(//th[.='Depart Date']/preceding-sibling::th)+1]");
    private By dblDepartStation = By.xpath("//table//td[count(//th[.='Depart Station']/preceding-sibling::th)+1]");
    private By dblArriveStation = By.xpath("//table//td[count(//th[.='Arrive Station']/preceding-sibling::th)+1]");
    private By dblSeatType = By.xpath("//table//td[count(//th[.='Seat Type']/preceding-sibling::th)+1]");
    private By dblTicketAmount = By.xpath("//table//td[count(//th[.='Amount']/preceding-sibling::th)+1]");
    private By lblSuccessBookingMsg = By.xpath("//h1[contains(text(),'Booked Successfully')]");

    private WebElement getDdlDate() {
        return Constant.WEBDRIVER.findElement(ddlDate);
    }
    private WebElement getSelectedDepart() {
        return Constant.WEBDRIVER.findElement(ddlDepartStation);
    }
    private WebElement getSelectedArrive() {
        return Constant.WEBDRIVER.findElement(ddlArriveStation);
    }
    private WebElement getSelectedTicketAmount() {
        return Constant.WEBDRIVER.findElement(ddlTicketAmount);
    }
    private WebElement getSelectedSeatType() {
        return Constant.WEBDRIVER.findElement(ddlSeatType);
    }
    private WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
    public String getLblSuccessBookingMsg() {
        return Constant.WEBDRIVER.findElement(lblSuccessBookingMsg).getText();
    }
    private WebElement getDblDate(){ return Constant.WEBDRIVER.findElement(dblDate);}
    private WebElement getDblDepartStation(){return Constant.WEBDRIVER.findElement(dblDepartStation);}
    private WebElement getDblArriveStation(){return Constant.WEBDRIVER.findElement(dblArriveStation);}
    private WebElement getDblSeatType(){return Constant.WEBDRIVER.findElement(dblSeatType);}
    private WebElement getDblTicketAmount(){return Constant.WEBDRIVER.findElement(dblTicketAmount);}

    public void selectWithDptDate(String dptDate){
        Utilities.scrollToElement(getLink());
        Select sltDepartDate = new Select(getDdlDate());
        sltDepartDate.selectByValue(dptDate);

    }
    public void bookTicketWithoutDptDate(String departFrom, String arrive, String ticket, String seat) {
        Utilities.scrollToElement(getLink());
        Select sltDepartFrom = new Select(getSelectedDepart());
        Select sltArrive = new Select(getSelectedArrive());
        Select sltTicket = new Select(getSelectedTicketAmount());
        Select sltSeat = new Select(getSelectedSeatType());
        sltDepartFrom.selectByVisibleText(departFrom);
        sltArrive.selectByVisibleText(arrive);
        sltTicket.selectByVisibleText(ticket);
        sltSeat.selectByVisibleText(seat);
    }

    public void bookTicket(String departDate, String departFrom, String arrive, String ticket, String seat) {
        Utilities.scrollToElement(getLink());
        Select sltDepartDate = new Select(getDdlDate());
        Select sltDepartFrom = new Select(getSelectedDepart());
        Select sltArrive = new Select(getSelectedArrive());
        Select sltTicket = new Select(getSelectedTicketAmount());
        Select sltSeat = new Select(getSelectedSeatType());
        sltDepartDate.selectByValue(departDate);
        sltDepartFrom.selectByVisibleText(departFrom);
        sltArrive.selectByVisibleText(arrive);
        sltTicket.selectByVisibleText(ticket);
        sltSeat.selectByVisibleText(seat);
    }
    public void clickBtnBookTicket(){
        getBtnBookTicket().click();
    }

}
