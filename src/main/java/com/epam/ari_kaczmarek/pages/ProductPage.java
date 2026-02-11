package com.epam.ari_kaczmarek.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;

public class ProductPage extends BasePage {
    private static final String ADD_TO_CART_XPATH_FORMAT = 
        "//h2[contains(@id, 'add_to_cart_title') and text()='Buy %s']/following-sibling::*/descendant::div[@class='btn_addtocart']";
    private static final String GO_TO_CART_XPATH = "//button[contains(@class, 'Primary')]";
    private static final Logger logger = LogManager.getLogger(ProductPage.class);
    public ProductPage(Page page) {
        super(page);
    }

    public void addToCart(String productName) {
        logger.debug("Adding product to cart: " + productName);
        page.locator(String.format(ADD_TO_CART_XPATH_FORMAT, productName)).click();
        logger.debug("Successfully added product to cart");
    }

    public void goToCart() {
        logger.debug("Opening cart page");
        page.locator(GO_TO_CART_XPATH).click();
    }
}
