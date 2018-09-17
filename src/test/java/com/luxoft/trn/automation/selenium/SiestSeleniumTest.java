package com.luxoft.trn.automation.selenium;

//import org.junit.jupiter.api.;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class SiestSeleniumTest {

    private static WebDriver wd;
    WebElement searchField;

    @BeforeAll
    public static void Setup() {
    wd = new ChromeDriver();
    }

    @Test
    public void searchforSelenium() throws InterruptedException {
        wd.get("https://www.google.com.ua");
        Assertions.assertEquals(wd.getTitle(), "Google");
        searchField = wd.findElement(By.id("lst-ib"));
        searchField.sendKeys("Selenium" + Keys.RETURN);
        Assertions.assertTrue(wd.getTitle().contains("Selenium"));
        Thread.sleep(3000);
    }

    @AfterAll
    static void tearDown() {
        wd.quit();
    }
}
