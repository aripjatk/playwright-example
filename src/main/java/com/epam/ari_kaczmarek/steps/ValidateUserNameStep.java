package com.epam.ari_kaczmarek.steps;

import static org.junit.Assert.assertTrue;

import com.epam.ari_kaczmarek.pages.HomePage;
import com.microsoft.playwright.Page;

public class ValidateUserNameStep extends TestStep {
    private final String expectedUserName;

    public ValidateUserNameStep(Page page, String expectedUserName) {
        super(page);
        this.expectedUserName = expectedUserName;
    }

    @Override
    public void execute() {
        var homePage = new HomePage(page);
        var actualUserName = homePage.getLoggedInUserName();
        assertTrue(
            "Expected user name to contain: " + expectedUserName + " but was: " + actualUserName,
            actualUserName.contains(expectedUserName)
        );
    }
}
