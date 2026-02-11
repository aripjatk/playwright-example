package com.epam.ari_kaczmarek.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage {
    private static final String CART_ITEM_NAME_XPATH = "//div[@id='«r1»']";
    private static final Logger logger = LogManager.getLogger(CartPage.class);

    public CartPage(Page page) {
        super(page);
    }
    
    public String getCartItemName() {
        logger.debug("Attempting to obtain cart item name");
        return page.locator(CART_ITEM_NAME_XPATH).innerText();
    }

    public void removeAllItems() {
        logger.debug("Removing all items from the cart");
        try {
            page.getByText("Remove all items").click();
        } catch (Throwable t) {
            logger.warn("Failed to remove all items from the cart. " +
                "Please do this manually before running the test again.", t);
        }
    }
}
