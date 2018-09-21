package com.luxoft.trn.automation.selenium;

//import org.junit.jupiter.api.;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class FirstSeleniumTest {

    private static WebDriver wd;
    WebElement searchField;

    @BeforeEach
    public void Setup() {
    wd = new ChromeDriver();
    }

    @Test
    public void searchforSeleniumInGoogle() throws InterruptedException {
        wd.get("https://www.google.com.ua");
        Assertions.assertEquals(wd.getTitle(), "Google");
        searchField = wd.findElement(By.id("lst-ib"));
        searchField.sendKeys("Selenium" + Keys.RETURN);
        Assertions.assertTrue(wd.getTitle().contains("Selenium"));
        Thread.sleep(3000);
    }


    /*
- Open advancced search
- Using advansed search execute the following query:
- Enter keywords or item number: "Xiaomi Note Redmi";
- with "Exact words, any order";
- with Price  between 100$ and 200$
- with Buying formats: "Buy it now"
- Condition: New
- Sellers:  Only show items from ->  Sellers with eBay stores
*/

    @Test
    public void sbayAdvancedSearchTest() throws InterruptedException {
        //        - Open advancced search
        wd.get("https://www.ebay.com/");
        wd.findElement(By.id("gh-as-a")).click();
        Assertions.assertEquals(wd.getTitle(), "eBay Search: Advanced Search");

        //        - Using advansed search execute the following query:

        //        - Enter keywords or item number: "Xiaomi Note Redmi";
        wd.findElement(By.name("_nkw")).sendKeys("Xiaomi Note Redmi");
        //        - with "Exact words, any order";
        wd.findElement(By.id("_in_kw")).click();
        wd.findElement(By.xpath("//*[@id='_in_kw']//option[@value = '4']")).click();
//                - with Price  between 100$ and 200$
        wd.findElement(By.name("_udlo")).sendKeys("100");
        wd.findElement(By.name("_udhi")).sendKeys("200");
//                - with Buying formats: "Buy it now"
        wd.findElement(By.id("LH_BIN")).click();
//                - Condition: New
        wd.findElement(By.id("LH_ItemConditionNew")).click();
//                - Sellers:  Only show items from ->  Sellers with eBay stores
        wd.findElement(By.id("_fss")).click();
        wd.findElement(By.id("LH_SellerWithStore_id")).click();

        //                - Click search
        wd.findElement(By.id("searchBtnLowerLnk")).click();
        Thread.sleep(500);


    }

    @AfterEach
     void tearDown() {
        wd.quit();
        wd = null;
    }
}
