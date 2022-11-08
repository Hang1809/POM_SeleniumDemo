package com.logigear.pages;

import com.logigear.common.common.Utilities;
import com.logigear.common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private By selectedDate = By.xpath("//select[@name='Date']");
    private By departFrom = By.xpath("//select[@name='DepartStation']");
    private By arriveStation = By.xpath("//select[@name='ArriveStation']");
    private By seatType = By.xpath("//select[@name='SeatType']");
    private By ticketAmount = By.xpath("//select[@name='TicketAmount']");
    private By btnBookTicket = By.xpath("//input[@type='submit' and @value='Book ticket']");
    private By successBooking = By.xpath("//h1[contains(text(),'Booked Successfully')]");
    private By errorBookingMsg = By.xpath("//p[@class='message error']");

    public WebElement getSelectedDate() {
        return Constant.WEBDRIVER.findElement(selectedDate);
    }

    public WebElement getSelectedDepart() {
        return Constant.WEBDRIVER.findElement(departFrom);
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
        return Constant.WEBDRIVER.findElement(successBooking).getText();
    }
    public String getErrorBookingMsg(){
        return Constant.WEBDRIVER.findElement(errorBookingMsg).getText();
    }

    public void bookTicket() {
        Utilities.scrollToElement(getLink());
        Select departDate = new Select(getSelectedDate());
        departDate.selectByValue("4");
        Select departFrom = new Select(getSelectedDepart());
        departFrom.selectByValue("4");
        Select arrive = new Select(getSelectedArrive());
        arrive.selectByValue("3");
        Select ticket = new Select(getSelectedTicketAmount());
        ticket.selectByValue("1");
        Select seat = new Select(getSelectedSeatType());
        seat.selectByValue("1");
        getBtnBookTicket().click();
    }

    public void book10Ticket() {
        Utilities.scrollToElement(getLink());
        Select departDate = new Select(getSelectedDate());
        departDate.selectByValue("4");
        Select departFrom = new Select(getSelectedDepart());
        departFrom.selectByValue("4");
        Select arrive = new Select(getSelectedArrive());
        arrive.selectByValue("3");
        Select ticket = new Select(getSelectedTicketAmount());
        ticket.selectByValue("10");
        Select seat = new Select(getSelectedSeatType());
        seat.selectByValue("1");
        getBtnBookTicket().click();
    }

}
