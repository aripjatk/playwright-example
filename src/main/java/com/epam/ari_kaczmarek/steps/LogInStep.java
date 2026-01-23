package com.epam.ari_kaczmarek.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ari_kaczmarek.pages.HomePage;
import com.epam.ari_kaczmarek.pages.LoginPage;
import com.microsoft.playwright.Page;

public class LogInStep extends TestStep {
    private final String username;
    private final String password;
    private static Logger logger = LogManager.getLogger(LogInStep.class);

    public LogInStep(Page page, String username, String password) {
        super(page);
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() {
        HomePage homePage = new HomePage(page);
        logger.debug("Clicking login link");
        try {
            homePage.clickLoginLink();
        } catch(Throwable t) {
            logger.error("Failed to click login link", t);
            throw t;
        }
        LoginPage loginPage = new LoginPage(page);
        logger.debug("Filling in login form");
        try {
            loginPage.fillUsername(username);
            loginPage.fillPassword(password);
        } catch(Throwable t) {
            logger.error("Failed to fill in login form", t);
            throw t;
        }
        logger.debug("Clicking login button");
        try {
            loginPage.clickLoginButton();
        } catch(Throwable t) {
            logger.error("Failed to click login button", t);
            throw t;
        }
    }
}
