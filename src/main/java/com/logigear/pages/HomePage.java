package com.logigear.pages;

import com.logigear.common.Constant;

public class HomePage extends GeneralPage {
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
