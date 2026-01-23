package com.epam.ari_kaczmarek.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;

public class OpenHomePageStep extends TestStep {
    private static final String HOME_PAGE_URL = "https://store.steampowered.com/";
    private static Logger logger = LogManager.getLogger(OpenHomePageStep.class);

    public OpenHomePageStep(Page page) {
        super(page);
    }

    @Override
    public void execute() {
        logger.debug("Navigating to home page, URL: " + HOME_PAGE_URL);
        page.navigate(HOME_PAGE_URL);
    }
    
}
