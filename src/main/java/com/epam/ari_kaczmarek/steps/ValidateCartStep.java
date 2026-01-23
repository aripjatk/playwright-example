package com.epam.ari_kaczmarek.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ari_kaczmarek.pages.CartPage;
import com.epam.ari_kaczmarek.pages.ProductPage;
import com.microsoft.playwright.Page;

public class ValidateCartStep extends TestStep {
    private final String expectedProductName;
    private static Logger logger = LogManager.getLogger(ValidateCartStep.class);

    public ValidateCartStep(Page page, String productName) {
        super(page);
        expectedProductName = productName;
    }

    @Override
    public void execute() {
        logger.debug("Opening cart page");
        new ProductPage(page).goToCart();
        var cartPage = new CartPage(page);
        logger.debug("Attempting to obtain cart item name");
        var actualProductName = cartPage.getCartItemName();
        logger.info("Expected product name: " + expectedProductName);
        logger.info("Actual product name: " + actualProductName);
        logger.debug("Attempting to remove all items from cart");
        try {
            cartPage.removeAllItems();
        } catch (Throwable t) {
            logger.warn("Failed to remove all items from the cart. " +
                "Please do this manually before running the test again.", t);
        }
        try {
            assertEquals(expectedProductName, actualProductName);
            logger.info("Product name validation successful");
        } catch (AssertionError e) {
            logger.error("Product name validation failed", e);
            throw e;
        }
    }
}
