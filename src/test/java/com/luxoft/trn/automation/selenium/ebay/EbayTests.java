package com.luxoft.trn.automation.selenium.ebay;

import com.luxoft.trn.automation.selenium.ebay.pageObject.EbayComPageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EbayTests extends BaseTest {

    EbayComPageObject ebayPage;

    @Test
    public void shouldShowBestPriceWhenSelectAuctionAfterSearch(){
        ebayPage = new EbayComPageObject(wd);

        ebayPage.goToMainPage()
                .searchFor("leather bags")
                .selectAuctionItems();
       assertThat(ebayPage.getAuctionBestPrices(), containsInAnyOrder("Under $8.00", "$8.00 - $18.00", "Over $18.00"));
    }

    @Test
    public void shouldShowBestPriceAfterSelectingItemInAdditionalCategory() throws InterruptedException {
        ebayPage = new EbayComPageObject(wd);
        ebayPage.goToMainPage()
                .selectItemInAdditionalCategory("Video Games & Consoles", "_Electronics_");
        assertThat(ebayPage.getTitle(), containsString("Video Games"));
    }



    @Test
    public void emptyCartWtenFirstTimeOpenPage(){
        ebayPage = new EbayComPageObject(wd);
        ebayPage.goToMainPage()
                .openShoppingCart();
        assertThat(ebayPage.getEmtyCartMessage(), containsString("You don't have any items in your cart"));
    }

    @Test
    public void checkIfShopByPriceBarWithThreePricesRoundedWithBlueBoxesIsVisible(){
        ebayPage = new EbayComPageObject(wd);
        ebayPage.goToMainPage()
                .searchFor("leather bags")
                .selectAuctionItems();

        assertThat(ebayPage.getAuctionBestPrices(), hasSize(3));
        assertThat(ebayPage.getAuctionBestPricesBorder(), containsString("1px solid rgb(6, 84, 186)"));
    }



}
