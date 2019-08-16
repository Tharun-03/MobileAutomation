package com.amazon.tests;

import com.amazon.framework.BaseTestCase;
import com.amazon.pages.*;
import org.testng.annotations.Test;

public class PurchaseItemTest extends BaseTestCase {
    @Test(priority = 0, enabled=false)
    public void loginWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForAmazonLogo();
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginPage();
        loginPage.enterUserCredentials(testData("username"), testData("password"));
    }

    @Test(priority = 1)
    public void searchItem() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchItem(testData("searchitem"), testData("modelnumber"));
    }

    @Test(priority = 2)
    public void purchaseSearchedItem() {
        ItemPage itemPage = new ItemPage(driver);
        itemPage.scrollAndTapBuyNow(testData("modelnumber"));

        DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
        deliveryAddressPage.waitforDeliveryAddressPage();


    }

}
