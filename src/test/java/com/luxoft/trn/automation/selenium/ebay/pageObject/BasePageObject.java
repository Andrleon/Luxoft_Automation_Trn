package com.luxoft.trn.automation.selenium.ebay.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePageObject {
    private static int MAX_WAIT_TIME = 5;
    WebDriver wd;


    public BasePageObject(WebDriver wd) {
        this.wd = wd;
    }

    private void captureScreenShot() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String time = LocalDateTime.now().format(dtf);
        File screenshot1 = new File("target/screenshot"+time+".png");
        File outFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(outFile.toPath(), screenshot1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected WebElement findElementWithWait(By locator){
        try {
            return new WebDriverWait(wd, MAX_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (WebDriverException ex){
            captureScreenShot();
        }
        return null;
    };
}
