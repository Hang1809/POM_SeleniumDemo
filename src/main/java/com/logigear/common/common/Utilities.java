package com.logigear.common.common;


import com.logigear.common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.logigear.common.constant.Constant.WEBDRIVER;

public class Utilities {

    public static void scrollToElement(WebElement element){
//        WebElement element = WEBDRIVER.findElement(By.xpath("//input[@type='submit' and @value='Register']"));
        Actions actions = new Actions(WEBDRIVER);
        actions.moveToElement(element);
        actions.perform();

    }

}
