package com.epam.ari_kaczmarek.steps;

import org.junit.Assert;

import com.epam.ari_kaczmarek.pages.EditProfilePage;
import com.epam.ari_kaczmarek.pages.ProfilePage;
import com.microsoft.playwright.Page;

public class ValidateProfileSummaryEditStep extends TestStep {
    private final String expectedSummary;

    public ValidateProfileSummaryEditStep(Page page, String expectedSummary) {
        super(page);
        this.expectedSummary = expectedSummary;
    }

    @Override
    public void execute() {
        var editProfilePage = new EditProfilePage(page);
        editProfilePage.goBackToProfilePage();
        var profilePage = new ProfilePage(page);
        String actualSummary = profilePage.getProfileSummaryText();
        Assert.assertEquals(expectedSummary, actualSummary);
    }
}
