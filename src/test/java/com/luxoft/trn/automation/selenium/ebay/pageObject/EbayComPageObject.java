package com.luxoft.trn.automation.selenium.ebay.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EbayComPageObject extends BasePageObject{
    private final String mainPage = "https://www.ebay.com";
    private static final String SEARC_SELECTOR_ID = "gh-ac";
    private static final String AUCTION_BUTTON_SELECTOR = "//a[@title = 'Auction']";
    private static final String AUCTION_BEST_PRICES_SELECTOR = "//nav[@role = 'navigation']//li//div";
    private static final String AUCTION_BEST_PRICES_CSS_SELECTOR = ".bluepills a.search-guidance__text-item-link";
    private static final String EMPTY_CART_MESSAGE_SELECTOR = "//div[@class = 'empty-cart']/div/span/span";

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

    public String getEmtyCartMessage(){
        return wd.findElement(By.xpath(EMPTY_CART_MESSAGE_SELECTOR)).getText();

    }

    public EbayComPageObject openShoppingCart() {
        wd.findElement(By.xpath("//*[@id='gh-cart-i']")).click();
        return this;
    }

    public String getAuctionBestPricesColor() {
        return wd.findElement(By.cssSelector(AUCTION_BEST_PRICES_CSS_SELECTOR)).getCssValue("color");

    }

    public String getAuctionBestPricesBorder() {
        return wd.findElement(By.cssSelector(AUCTION_BEST_PRICES_CSS_SELECTOR)).getCssValue("border");

    }


    public EbayComPageObject selectItemInAdditionalCategory(String subCategory, String category) throws InterruptedException {
        Actions builder = new Actions(wd);
        String xpathSelCategory = String.format("//td[@role = 'listitem']/a[contains(text(), '%s')]", category);
        String xpathSelSubCategory = String.format("//a[contains(text(), '%s')]", subCategory);

        WebElement categoryItem = findElementWithWait(By.xpath(xpathSelCategory));
        Action ourComplexAction = builder.moveToElement(categoryItem).build();
        ourComplexAction.perform();

        WebElement subCategoryItem = findElementWithWait(By.xpath(xpathSelSubCategory));
        ourComplexAction = builder.moveToElement(subCategoryItem).click().build();
        ourComplexAction.perform();

        return this;
    }

    public String getTitle() {
        return wd.getTitle();
    }

}
