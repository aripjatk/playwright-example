package com.epam.ari_kaczmarek;

import com.epam.ari_kaczmarek.steps.*;
import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private Browser browser;
    private Page page;

    private static final String LOGIN_USERNAME = "arkaczmaepam";
    private static final String LOGIN_PASSWORD = "bLx0$gc1";
    private static final String DISPLAYED_USERNAME = "ari_kaczmarek";

    @Before
    public void setUp() {
        browser = Playwright.create()
            .chromium()
            .launch(new LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void loginTest() {
        new OpenHomePageStep(page).execute();
        new LogInStep(page, LOGIN_USERNAME, LOGIN_PASSWORD).execute();
        new ValidateUserNameStep(page, DISPLAYED_USERNAME).execute();
    }

    @Test
    public void editProfileTest() {
        new OpenHomePageStep(page).execute();
        new LogInStep(page, LOGIN_USERNAME, LOGIN_PASSWORD).execute();
        new GoToProfileStep(page).execute();
        var summary1 = "My Test Summary";
        var summary2 = "Test";
        int updateAttempts = 5;
        new EditProfileSummaryStep(page, summary1, updateAttempts).execute();
        new ValidateProfileSummaryEditStep(page, summary1).execute();
        new EditProfileSummaryStep(page, summary2, updateAttempts).execute();
        new ValidateProfileSummaryEditStep(page, summary2).execute();
    }

    @Test
    public void addToCartTest() {
        var productName = "Red Dead Redemption 2";
        new OpenHomePageStep(page).execute();
        new LogInStep(page, LOGIN_USERNAME, LOGIN_PASSWORD).execute();
        new ProductSearchStep(page, productName).execute();
        new SelectSearchResultStep(page, productName).execute();
        new AddToCartStep(page, productName).execute();
        new ValidateCartStep(page, productName).execute();
    }
}
