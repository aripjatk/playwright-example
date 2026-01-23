package com.epam.ari_kaczmarek.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ari_kaczmarek.pages.HomePage;
import com.microsoft.playwright.Page;

public class ProductSearchStep extends TestStep {
    private final String searchTerm;
    private static Logger logger = LogManager.getLogger(ProductSearchStep.class);

    public ProductSearchStep(Page page, String searchTerm) {
        super(page);
        this.searchTerm = searchTerm;
    }

    @Override
    public void execute() {
        logger.debug("Searching for product: " + searchTerm);
        try {
            var homePage = new HomePage(page);
            homePage.search(searchTerm);
            logger.debug("Search successful");
        } catch (Throwable t) {
            logger.error("Failed to search for product: " + searchTerm, t);
            throw t;
        }
    }
    
}
