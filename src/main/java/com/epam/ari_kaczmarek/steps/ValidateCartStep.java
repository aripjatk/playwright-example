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
        new ProductPage(page).goToCart();
        var cartPage = new CartPage(page);
        var actualProductName = cartPage.getCartItemName();
        logger.info("Expected product name: " + expectedProductName);
        logger.info("Actual product name: " + actualProductName);
        cartPage.removeAllItems();
        try {
            assertEquals(expectedProductName, actualProductName);
            logger.info("Product name validation successful");
        } catch (AssertionError e) {
            logger.error("Product name validation failed", e);
            throw e;
        }
    }
}
