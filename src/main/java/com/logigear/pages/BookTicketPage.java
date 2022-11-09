package com.logigear.pages;

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



    public void bookTicket() {
        Select departDate = new Select(getSelectedDate());
        Select departFrom = new Select(getSelectedDepart());
        Select arrive = new Select(getSelectedArrive());
        Select ticket = new Select(getSelectedTicketAmount());
        Select seat = new Select(getSelectedSeatType());
        Utilities.scrollToElement(getLink());
        departDate.selectByValue("4");
        departFrom.selectByValue("4");
        arrive.selectByValue("3");
        ticket.selectByValue("1");
        seat.selectByValue("1");
        getBtnBookTicket().click();
    }

    public void book10Ticket() {
        Utilities.scrollToElement(getLink());
        Select departDate = new Select(getSelectedDate());
        Select departFrom = new Select(getSelectedDepart());
        Select arrive = new Select(getSelectedArrive());
        Select ticket = new Select(getSelectedTicketAmount());
        Select seat = new Select(getSelectedSeatType());
        departDate.selectByValue("4");
        departFrom.selectByValue("4");
        arrive.selectByValue("3");
        ticket.selectByValue("10");
        seat.selectByValue("1");
        getBtnBookTicket().click();
    }

}
