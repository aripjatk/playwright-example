package com.epam.ari_kaczmarek.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;

public class SearchResultsPage extends BasePage {
    private static final String PRODUCT_XPATH_FORMAT = "//span[text()='%s']/ancestor::a";
    private static Logger logger = LogManager.getLogger(SearchResultsPage.class);

    public SearchResultsPage(Page page) {
        super(page);
    }
    
    public void selectProduct(String productName) {
        logger.debug("Selecting search result: " + productName);
        page.locator(String.format(PRODUCT_XPATH_FORMAT, productName)).click();
        logger.debug("Search result selected successfully");
    }
}
