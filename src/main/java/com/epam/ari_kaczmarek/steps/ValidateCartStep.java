package com.epam.ari_kaczmarek.steps;

import org.junit.Assert;

import com.epam.ari_kaczmarek.pages.CartPage;
import com.epam.ari_kaczmarek.pages.ProductPage;
import com.microsoft.playwright.Page;

public class ValidateCartStep extends TestStep {
    private final String expectedProductName;

    public ValidateCartStep(Page page, String productName) {
        super(page);
        expectedProductName = productName;
    }

    @Override
    public void execute() {
        new ProductPage(page).goToCart();
        var cartPage = new CartPage(page);
        var actualProductName = cartPage.getCartItemName();
        cartPage.removeAllItems();
        Assert.assertEquals(expectedProductName, actualProductName);
    }
}
