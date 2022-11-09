package com.logigear.common;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL="http://www.railwayb2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "milo@gmail.com";
    public static final String INVALID_USERNAME = "abc";
    public static final String REGISTER_USERNAME = "hang"+(int)(Math.random()*1000)+"@gmail.com";
    public static final String PASSWORD ="12345678";
    public static final String PID ="12345678";
}
