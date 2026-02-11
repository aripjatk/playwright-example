package com.epam.ari_kaczmarek.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    private static final String LOGIN_LINK_XPATH = "//a[contains(@class, 'global') and contains(@href, 'login')]";
    private static final String LOGGED_IN_USER_XPATH = "//button[contains(@class, 'persona_name_text_content')]";
    private static final String PROFILE_PICTURE_LINK_XPATH = "//img/parent::a[@aria-label='View your profile' and contains(@class, 'playerAvatar')]";
    private static final String SEARCH_BAR_XPATH = "//input[@name='term']";
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(Page page) {
        super(page);
    }

    public void clickLoginLink() {
        logger.debug("Clicking login link");
        try {
            page.locator(LOGIN_LINK_XPATH).click();
        } catch(Throwable t) {
            logger.error("Failed to click login link", t);
            throw t;
        }
    }

    public String getLoggedInUserName() {
        logger.debug("Attempting to obtain logged-in user name");
        try {
            return page.locator(LOGGED_IN_USER_XPATH).textContent();
        } catch(Throwable t) {
            logger.error("Failed to obtain logged-in user name (user may not be logged in)", t);
            throw t;
        }
    }

    public void goToProfilePage() {
        logger.debug("Navigating to profile page");
        page.locator(PROFILE_PICTURE_LINK_XPATH).click();
    }

    public void search(String searchTerm) {
        logger.debug("Searching for product: " + searchTerm);
        page.locator(SEARCH_BAR_XPATH).fill(searchTerm);
        page.locator(SEARCH_BAR_XPATH).press("Enter");
        logger.debug("Search successful");
    }
}
