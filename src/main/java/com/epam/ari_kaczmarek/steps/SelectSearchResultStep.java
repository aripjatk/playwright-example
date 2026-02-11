package com.epam.ari_kaczmarek.steps;

import com.epam.ari_kaczmarek.pages.SearchResultsPage;
import com.microsoft.playwright.Page;

public class SelectSearchResultStep extends TestStep {
    private final String resultToSelect;

    public SelectSearchResultStep(Page page, String resultToSelect) {
        super(page);
        this.resultToSelect = resultToSelect;
    }

    @Override
    public void execute() {
        new SearchResultsPage(page).selectProduct(resultToSelect);
    }
    
}
