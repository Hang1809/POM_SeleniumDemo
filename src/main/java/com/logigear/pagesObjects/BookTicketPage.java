package com.logigear.pagesObjects;

import com.logigear.common.Log;
import com.logigear.common.Utilities;
import com.logigear.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private By selectedDate = By.xpath("//select[@name='Date']");
    private By dptFrom = By.xpath("//select[@name='DepartStation']");
    private By arriveStation = By.xpath("//select[@name='ArriveStation']");
    private By seatType = By.xpath("//select[@name='SeatType']");
    private By ticketAmount = By.xpath("//select[@name='TicketAmount']");
    private By btnBookTicket = By.xpath("//input[@type='submit' and @value='Book ticket']");
    private By successBookingMsg = By.xpath("//h1[contains(text(),'Booked Successfully')]");
    private By errorBookingMsg = By.xpath("//p[@class='message error']");

    public WebElement getSelectedDate() {
        return Constant.WEBDRIVER.findElement(selectedDate);
    }

    public WebElement getSelectedDepart() {
        return Constant.WEBDRIVER.findElement(dptFrom);
    }

    public WebElement getSelectedArrive() {
        return Constant.WEBDRIVER.findElement(arriveStation);
    }

    public WebElement getSelectedTicketAmount() {
        return Constant.WEBDRIVER.findElement(ticketAmount);
    }

    public WebElement getSelectedSeatType() {
        return Constant.WEBDRIVER.findElement(seatType);
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public String getSuccessBookingMsg() {
        return Constant.WEBDRIVER.findElement(successBookingMsg).getText();
    }

    public String getErrorBookingMsg() {
        return Constant.WEBDRIVER.findElement(errorBookingMsg).getText();
    }

    public void bookTicket(String departDate, String departFrom, String arrive, String ticket, String seat) {
        Select sltDepartDate = new Select(getSelectedDate());
        Select sltDepartFrom = new Select(getSelectedDepart());
        Select sltArrive = new Select(getSelectedArrive());
        Select sltTicket = new Select(getSelectedTicketAmount());
        Select sltSeat = new Select(getSelectedSeatType());
        Utilities.scrollToElementInFireFox();
        //Utilities.scrollToElement(getLink());
        sltDepartDate.selectByIndex(Integer.parseInt(departDate));
        sltDepartFrom.selectByVisibleText(departFrom);
        sltArrive.selectByVisibleText(arrive);
        sltTicket.selectByVisibleText(ticket);
        sltSeat.selectByVisibleText(seat);
        Log.info("Step8: Click on \"Book ticket\" button");
        getBtnBookTicket().click();
    }
}
