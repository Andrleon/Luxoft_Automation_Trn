package com.luxoft.trn.automation.selenium.etsy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseEtsyTestClas {
    protected static WebDriver wd;
    WebElement searchField;

    @BeforeEach
    public void Setup() {
        wd = new ChromeDriver();
        wd.manage().deleteAllCookies();
    }

    @AfterEach
    void tearDown() {
        wd.quit();
        wd = null;
    }


}
