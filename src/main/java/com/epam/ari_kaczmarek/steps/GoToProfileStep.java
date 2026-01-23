package com.epam.ari_kaczmarek.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ari_kaczmarek.pages.HomePage;
import com.microsoft.playwright.Page;

public class GoToProfileStep extends TestStep {

    private static Logger logger = LogManager.getLogger(GoToProfileStep.class);

    public GoToProfileStep(Page page) {
        super(page);
    }

    @Override
    public void execute() {
        var homePage = new HomePage(page);
        logger.debug("Navigating to profile page");
        homePage.goToProfilePage();
    }
}
