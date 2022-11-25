package com.logigear.finaltestcase;

import com.logigear.common.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        PropertiesFile.setPropertiesFile();
        DriverManager.setBrowser(PropertiesFile.getPropValue("browser"));
        DriverManager.open();
        DriverManager.maximizeWindow();
        Log.info("Pre-condition: Create and activate a new account");
        DOMConfigurator.configure(Utilities.getProjectPath()+"\\configs\\log4j.xml");

    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

}
