package com.epam.ari_kaczmarek.steps;

import com.epam.ari_kaczmarek.pages.HomePage;
import com.microsoft.playwright.Page;

public class ProductSearchStep extends TestStep {
    private final String searchTerm;

    public ProductSearchStep(Page page, String searchTerm) {
        super(page);
        this.searchTerm = searchTerm;
    }

    @Override
    public void execute() {
        var homePage = new HomePage(page);
        homePage.search(searchTerm);
    }
    
}
