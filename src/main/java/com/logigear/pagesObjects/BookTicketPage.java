package com.logigear.pagesObjects;

import org.openqa.selenium.By;

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

}
