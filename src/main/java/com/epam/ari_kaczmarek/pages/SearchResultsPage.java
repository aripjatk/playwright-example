package com.epam.ari_kaczmarek.pages;

import com.microsoft.playwright.Page;

public class SearchResultsPage extends BasePage {
    private static final String PRODUCT_XPATH_FORMAT = "//span[text()='%s']/ancestor::a";

    public SearchResultsPage(Page page) {
        super(page);
    }
    
    public void selectProduct(String productName) {
        page.locator(String.format(PRODUCT_XPATH_FORMAT, productName)).click();
    }
}
