package com.epam.ari_kaczmarek.pages;

import com.microsoft.playwright.Page;

public class ProfilePage extends BasePage {
    private static final String PROFILE_SUMMARY_XPATH = "//div[contains(@class, 'profile_summary noexpand')]";
    private static final String EDIT_PROFILE_BUTTON_XPATH = "//a[contains(@href, 'edit/info')]";

    public ProfilePage(Page page) {
        super(page);
    }

    public String getProfileSummaryText() {
        return page.locator(PROFILE_SUMMARY_XPATH).innerText();
    }

    public void clickEditProfileButton() {
        page.locator(EDIT_PROFILE_BUTTON_XPATH).click();
    }
}
