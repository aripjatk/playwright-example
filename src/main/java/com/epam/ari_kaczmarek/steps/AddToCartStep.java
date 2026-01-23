package com.epam.ari_kaczmarek.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ari_kaczmarek.pages.ProductPage;
import com.microsoft.playwright.Page;

public class AddToCartStep extends TestStep {
    private final String productName;
    private static Logger logger = LogManager.getLogger(AddToCartStep.class);

    public AddToCartStep(Page page, String productName) {
        super(page);
        this.productName = productName;
    }

    @Override
    public void execute() {
        ProductPage productPage = new ProductPage(page);
        logger.debug("Adding product to cart: " + productName);
        try {
            productPage.addToCart(productName);
            logger.debug("Successfully added product to cart");
        } catch(Throwable t) {
            logger.error("Failed to add the product \"" + productName + "\" to cart", t);
            throw t;
        }
    }
}
 