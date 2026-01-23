package com.epam.ari_kaczmarek.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ari_kaczmarek.pages.SearchResultsPage;
import com.microsoft.playwright.Page;

public class SelectSearchResultStep extends TestStep {
    private final String resultToSelect;
    private static Logger logger = LogManager.getLogger(SelectSearchResultStep.class);

    public SelectSearchResultStep(Page page, String resultToSelect) {
        super(page);
        this.resultToSelect = resultToSelect;
    }

    @Override
    public void execute() {
        logger.debug("Selecting search result: " + resultToSelect);
        try {
            new SearchResultsPage(page).selectProduct(resultToSelect);
            logger.debug("Search result selected successfully");
        } catch (Throwable t) {
            logger.error("Failed to select search result: " + resultToSelect, t);
            throw t;
        }
    }
    
}
