package com.luxoft.trn.automation.selenium.ebay;

import com.luxoft.trn.automation.selenium.ebay.pageObject.EbayComPageObject;
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

}
