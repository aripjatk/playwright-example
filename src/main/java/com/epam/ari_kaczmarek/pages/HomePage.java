package com.epam.ari_kaczmarek.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    private static final String LOGIN_LINK_XPATH = "//a[contains(@class, 'global') and contains(@href, 'login')]";
    private static final String LOGGED_IN_USER_XPATH = "//button[contains(@class, 'persona_name_text_content')]";
    private static final String PROFILE_PICTURE_LINK_XPATH = "//img/parent::a[@aria-label='View your profile' and contains(@class, 'playerAvatar')]";
    private static final String SEARCH_BAR_XPATH = "//input[@name='term']";

    public HomePage(Page page) {
        super(page);
    }

    public void clickLoginLink() {
        page.locator(LOGIN_LINK_XPATH).click();
    }

    public String getLoggedInUserName() {
        return page.locator(LOGGED_IN_USER_XPATH).textContent();
    }

    public void goToProfilePage() {
        page.locator(PROFILE_PICTURE_LINK_XPATH).click();
    }

    public void search(String searchTerm) {
        page.locator(SEARCH_BAR_XPATH).fill(searchTerm);
        page.locator(SEARCH_BAR_XPATH).press("Enter");
    }
}
