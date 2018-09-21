package com.luxoft.trn.automation.selenium.etsy;

import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class EtsyTest extends BaseEtsyTestClas{

    @Test
    public void chechEmptyCart() throws InterruptedException {
        wd.get("https://www.etsy.com");
        Thread.sleep(3000);
        wd.findElement(By.className("nav-link")).click();
        Thread.sleep(3000);
       // Assertions.assertEquals("Ваша корзина пуста.", wd.findElement(By.xpath("//*[@id='newempty']/div/h2")).getText().trim());

    }


}