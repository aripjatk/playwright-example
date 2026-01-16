package com.epam.ari_kaczmarek.steps;

import com.microsoft.playwright.Page;

public class OpenHomePageStep extends TestStep {
    private static final String HOME_PAGE_URL = "https://store.steampowered.com/";

    public OpenHomePageStep(Page page) {
        super(page);
    }

    @Override
    public void execute() {
        page.navigate(HOME_PAGE_URL);
    }
    
}
