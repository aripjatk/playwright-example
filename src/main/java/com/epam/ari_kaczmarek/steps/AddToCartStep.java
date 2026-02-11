package com.epam.ari_kaczmarek.steps;

import com.epam.ari_kaczmarek.pages.ProductPage;
import com.microsoft.playwright.Page;

public class AddToCartStep extends TestStep {
    private final String productName;

    public AddToCartStep(Page page, String productName) {
        super(page);
        this.productName = productName;
    }

    @Override
    public void execute() {
        ProductPage productPage = new ProductPage(page);
        productPage.addToCart(productName);
    }
}
 