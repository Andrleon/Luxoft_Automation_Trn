package com.luxoft.trn.automation.selenium.ebay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
    private static int MAX_WAIT_TIME = 30;
    WebDriver wd;


    public BasePageObject(WebDriver wd) {
        this.wd = wd;
    }

    protected WebElement findElementWithWait(By locator){
        return new WebDriverWait(wd, MAX_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(locator));
    };

}
