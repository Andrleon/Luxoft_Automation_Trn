package com.luxoft.trn.automation.selenium.ebay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class EbayComPageObject extends BasePageObject{
    private final String mainPage = "https://www.ebay.com";
    private static final String SEARC_SELECTOR_ID = "gh-ac";
    private static final String AUCTION_BUTTON_SELECTOR = "//a[@title = 'Auction']";
    private static final String AUCTION_BEST_PRICES_SELECTOR = "//nav[@role = 'navigation']//li//div";

    @FindBy(id = "gh-ac")
    private WebElement searchFieldElement;

    public EbayComPageObject(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    public EbayComPageObject goToMainPage(){
        wd.get(mainPage);
        return this;
    };

    public EbayComPageObject searchFor(String text) {
        enterCriteriaToSerachField(text);
        return this;
    }

    private void enterCriteriaToSerachField(String text) {
       // WebElement searchField = searchFieldElement;
        WebElement searchField = findElementWithWait(By.id("gh-ac"));
        searchField.clear();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
    }

    public EbayComPageObject selectAuctionItems() {
        WebElement auctionItems = findElementWithWait(By.xpath(AUCTION_BUTTON_SELECTOR));
        auctionItems.click();
        return this;
    }

    public List<String> getAuctionBestPrices() {
        return wd.findElements(By.xpath(AUCTION_BEST_PRICES_SELECTOR)).stream().map(e -> e.getText()).collect(Collectors.toList());
    }
}