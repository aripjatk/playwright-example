package com.epam.ari_kaczmarek.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;

public class ProfilePage extends BasePage {
    private static final String PROFILE_SUMMARY_XPATH = "//div[contains(@class, 'profile_summary noexpand')]";
    private static final String EDIT_PROFILE_BUTTON_XPATH = "//a[contains(@href, 'edit/info')]";
    private static final Logger logger = LogManager.getLogger(ProfilePage.class);

    public ProfilePage(Page page) {
        super(page);
    }

    public String getProfileSummaryText() {
        logger.debug("Attempting to obtain profile summary text");
        return page.locator(PROFILE_SUMMARY_XPATH).innerText();
    }

    public void clickEditProfileButton() {
        logger.debug("Clicking Edit Profile button");
        page.locator(EDIT_PROFILE_BUTTON_XPATH).click();
    }
}
