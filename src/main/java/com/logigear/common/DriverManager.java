package com.logigear.common;

public class DriverManager {
    public static void open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
}
