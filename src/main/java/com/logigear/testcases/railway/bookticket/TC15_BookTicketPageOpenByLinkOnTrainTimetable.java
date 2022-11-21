package com.logigear.testcases.railway.bookticket;

import com.logigear.common.Constant;
import com.logigear.common.Log;
import com.logigear.common.PropertiesFile;
import com.logigear.pagesObjects.HomePage;
import com.logigear.pagesObjects.LoginPage;
import com.logigear.pagesObjects.TimeTablePage;
import com.logigear.testcases.railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15_BookTicketPageOpenByLinkOnTrainTimetable extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    TimeTablePage timeTablePage = new TimeTablePage();


    @Test
    public void TC15(){
        String dptStation = "Huế";
        String arrStation = "Sài Gòn";
        Log.info("TC15_User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");
        Log.info("Step1. Navigate to QA Railway Website");
        loginPage.goToLoginPage();
        Log.info("Step2. Login with a valid account");
        loginPage.fillDataLogin(Constant.USERNAME, PropertiesFile.getPropValue("password"));
        loginPage.clickBtnLogin();
        Log.info("Step3. Click on 'Timetable' tab");
        homePage.goToTimeTablePage();
        Log.info("Step4: Click on 'book ticket' link of the route from 'Huế' to 'Sài Gòn' ");
        timeTablePage.clickLinkBookTicketByString(dptStation,arrStation);

        String actualDptStation = dptStation;
        String actualArrStation = arrStation;
        String expectedDptStation = "Huế";
        String expectedArrStation = "Sài Gòn";

        Assert.assertEquals(actualDptStation,expectedDptStation,"Depart Station is incorrectly");
        Assert.assertEquals(actualArrStation,expectedArrStation,"Arrive Station is incorrectly");

    }
}
