package com.logigear.common;


import com.logigear.pagesObjects.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.logigear.common.Constant.WEBDRIVER;

public class Utilities {
    public static void scrollToElement(WebElement element){
        Actions actions = new Actions(WEBDRIVER);
        actions.moveToElement(element);
        actions.perform();
    }
    public static String getProjectPath(){
        return "src/main/resources";
    }
}
