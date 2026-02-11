package com.epam.ari_kaczmarek.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private static final String USERNAME_INPUT_XPATH = "//input[@type='text' and not(@placeholder)]";
    private static final String PASSWORD_INPUT_XPATH = "//input[@type='password']";
    private static final String LOGIN_BUTTON_XPATH = "//input[@type='password']/parent::*/following-sibling::*/button[@type='submit']";
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(Page page) {
        super(page);
    }
    public void fillUsername(String username) {
        logger.debug("Entering username: " + username);
        try {
            page.locator(USERNAME_INPUT_XPATH).fill(username);
        } catch(Throwable t) {
            logger.error("Failed to fill in username", t);
            throw t;
        }
    }
    public void fillPassword(String password) {
        logger.debug("Entering password: " + password);
        try {
            page.locator(PASSWORD_INPUT_XPATH).fill(password);
        } catch(Throwable t) {
            logger.error("Failed to fill in password", t);
            throw t;
        }
    }
    public void clickLoginButton() {
        logger.debug("Clicking login button");
        try {
            page.locator(LOGIN_BUTTON_XPATH).click();
        } catch(Throwable t) {
            logger.error("Failed to click login button", t);
            throw t;
        }
    }
}